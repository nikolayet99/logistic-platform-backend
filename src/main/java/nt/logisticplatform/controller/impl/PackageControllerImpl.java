package nt.logisticplatform.controller.impl;

import nt.logisticplatform.controller.PackageController;
import nt.logisticplatform.model.PackDTO;
import nt.logisticplatform.model.Package;
import nt.logisticplatform.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PackageControllerImpl implements PackageController {
    @Autowired
    private PackageService packageService;

    @Override
    public List<Package> getAllPackages(Boolean sent, Boolean received) {
        return packageService.getAllPackages(sent, received);
    }

    @Override
    public List<Package> getAllSentPackagesByPerson(Long personId) {
        return packageService.getAllSentPackagesByPerson(personId);
    }

    @Override
    public List<Package> getAllReceivedPackagesByPerson(Long personId) {
        return packageService.getAllReceivedPackagesByPerson(personId);
    }

    @Override
    public List<Package> getAllRegisteredPackagesByPerson(Long personId) {
        return packageService.getAllRegisteredPackagesByPerson(personId);
    }

    @Override
    public Package createPackage(PackDTO pack) {
        return packageService.createPackage(pack);
    }

    @Override
    public Package updatePackage(PackDTO pack) {
        return packageService.updatePackage(pack);
    }

    @Override
    public void deletePackage(Long id) {
        packageService.deletePackage(id);
    }
}
