package nt.logisticplatform.service;

import nt.logisticplatform.model.Package;
import nt.logisticplatform.model.PackDTO;

import java.util.List;

public interface PackageService {
    List<Package> getAllPackages(Boolean sent, Boolean received);

    List<Package> getAllSentPackagesByPerson(Long personId);

    List<Package> getAllReceivedPackagesByPerson(Long personId);

    List<Package> getAllRegisteredPackagesByPerson(Long personId);

    Package createPackage(PackDTO pack);

    Package updatePackage(PackDTO pack);

    void deletePackage(Long id);
}
