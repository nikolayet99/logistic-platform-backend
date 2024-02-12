package nt.logisticplatform.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import nt.logisticplatform.exception.ApiClientRuntimeException;
import nt.logisticplatform.model.Office;
import nt.logisticplatform.repository.OfficeRepository;
import nt.logisticplatform.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class OfficeServiceImpl implements OfficeService {
    private static final String EMAIL_REGEX = "^(.+)@(\\\\S+)$";
    private static final Pattern PATTERN = Pattern.compile(EMAIL_REGEX);

    @Autowired
    OfficeRepository officeRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Office> getAllOffices() {
        return officeRepository.findAll();
    }

    @Override
    public Office createOffice(Office office) {
        validateOffice(office);
        return officeRepository.save(office);
    }

    @Override
    public Office updateOffice(Office office) {
        validateOffice(office);
        Office existingOffice = entityManager.find(Office.class, office.getId());
        if (existingOffice == null)
            throw new ApiClientRuntimeException("Invalid office provided");

        existingOffice = office;
        return entityManager.merge(existingOffice);
    }

    @Override
    public void deleteOffice(Long id) {
        Office existingOffice = entityManager.find(Office.class, id);
        if (existingOffice == null)
            throw new IllegalArgumentException("Invalid office provided");

        officeRepository.deleteById(id);
    }

    private void validateOffice(Office office) {
        String address = office.getAddress();
        if (address == null || address.isEmpty())
            throw new ApiClientRuntimeException("Invalid office address provided.");

        if (isValidEmail(office.getEmail()))
            throw new ApiClientRuntimeException("Invalid office email provided.");

        String name = office.getName();
        if (name == null || name.isEmpty())
            throw new ApiClientRuntimeException("Invalid office name provided.");

        String phoneNumber = office.getPhoneNumber();
        if (phoneNumber == null || phoneNumber.isEmpty() || !containsOnlyNumbers(phoneNumber)
                || (phoneNumber.startsWith("+") && !containsOnlyNumbers(phoneNumber.substring(1)) ||
                !containsOnlyNumbers(phoneNumber)))
            throw new ApiClientRuntimeException("Invalid office phone number provided.");
    }

    private boolean isValidEmail(String email) {
        return email != null && PATTERN.matcher(email).matches();
    }

    private boolean containsOnlyNumbers(String s) {
        for (char c : s.toCharArray())
            if (!Character.isDigit(c))
                return false;

        return true;
    }
}
