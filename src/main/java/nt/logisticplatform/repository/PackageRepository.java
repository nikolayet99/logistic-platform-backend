package nt.logisticplatform.repository;

import nt.logisticplatform.model.Package;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackageRepository extends JpaRepository<Package, Long> {
    List<Package> findAllByReceivedTrue();

    List<Package> findAllBySentTrue();

    List<Package> findAllBySenderIdAndSentTrue(Long senderId);

    List<Package> findAllByReceiverIdAndReceivedTrue(Long receiverId);

    List<Package> findAllByEmployeeId(Long personId);
}
