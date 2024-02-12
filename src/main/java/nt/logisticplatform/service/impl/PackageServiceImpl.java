package nt.logisticplatform.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import nt.logisticplatform.exception.ApiClientRuntimeException;
import nt.logisticplatform.model.*;
import nt.logisticplatform.model.Package;
import nt.logisticplatform.repository.PackageRepository;
import nt.logisticplatform.service.FinanceService;
import nt.logisticplatform.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PackageServiceImpl implements PackageService {
    @Autowired
    PackageRepository packageRepository;

    @Autowired
    FinanceService financeService;

    @PersistenceContext
    EntityManager entityManager;

    @Value("${package-price}")
    String packagePrice;

    @Override
    public List<Package> getAllPackages(Boolean sent, Boolean received) {
        if (Boolean.TRUE.equals(received))
            return packageRepository.findAllByReceivedTrue();
        else if (Boolean.TRUE.equals(sent))
            return packageRepository.findAllBySentTrue();
        else
            return packageRepository.findAll();
    }

    @Override
    public List<Package> getAllSentPackagesByPerson(Long personId) {
        return packageRepository.findAllBySenderIdAndSentTrue(personId);
    }

    @Override
    public List<Package> getAllReceivedPackagesByPerson(Long personId) {
        return packageRepository.findAllByReceiverIdAndReceivedTrue(personId);
    }

    @Override
    public List<Package> getAllRegisteredPackagesByPerson(Long personId) {
        return packageRepository.findAllByEmployeeId(personId);
    }

    @Override
    public Package createPackage(PackDTO pack) {
        validatePackage(pack);
        Package newPack = new Package(
                new Person(pack.getSenderId()),
                new Person(pack.getReceiverId()),
                new Person(pack.getEmployeeId()),
                new Office(pack.getSenderOfficeId()),
                new Office(pack.getReceiverOfficeId()),
                pack.getContent(),
                pack.getPrice(),
                true,
                false
        );
        Package savedPack = packageRepository.save(newPack);
        financeService.addBill(new Bill(savedPack, BigDecimal.valueOf(Double.parseDouble(packagePrice))));
        return savedPack;
    }

    @Override
    public Package updatePackage(PackDTO pack) {
        Package existingPackage = entityManager.find(Package.class, pack.getId());
        if (existingPackage == null)
            throw new ApiClientRuntimeException("Invalid package provided.");

        validatePackage(pack);
        existingPackage = new Package(
                new Person(pack.getSenderId()),
                new Person(pack.getReceiverId()),
                new Person(pack.getEmployeeId()),
                new Office(pack.getSenderOfficeId()),
                new Office(pack.getReceiverOfficeId()),
                pack.getContent(),
                pack.getPrice(),
                true,
                false
        );
        return entityManager.merge(existingPackage);
    }

    @Override
    public void deletePackage(Long id) {
        Package existingPackage = entityManager.find(Package.class, id);
        if (existingPackage == null)
            throw new ApiClientRuntimeException("Invalid package provided.");

        packageRepository.deleteById(id);
    }

    private void validatePackage(PackDTO pack) {
        String content = pack.getContent();
        if (content == null || content.isEmpty())
            throw new ApiClientRuntimeException("Invalid package content provided.");

        if (pack.getReceiverId() == null)
            throw new ApiClientRuntimeException("Invalid package receiver provided.");

        if (pack.getReceiverOfficeId() == null)
            throw new ApiClientRuntimeException("Invalid package receiver office provided.");

        if (pack.getSenderId() == null)
            throw new ApiClientRuntimeException("Invalid sender provided.");

        if (pack.getEmployeeId() == null)
            throw new ApiClientRuntimeException("Invalid employee sender provided.");

        if (pack.getSenderOfficeId() == null)
            throw new ApiClientRuntimeException("Invalid sender office provided.");

        BigDecimal price = pack.getPrice();
        if (price == null || price.compareTo(BigDecimal.valueOf(0.01)) < 0)
            throw new ApiClientRuntimeException("Invalid package price provided.");
    }
}
