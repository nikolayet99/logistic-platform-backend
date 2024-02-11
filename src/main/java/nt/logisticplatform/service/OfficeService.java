package nt.logisticplatform.service;

import nt.logisticplatform.model.Office;

import java.util.List;

public interface OfficeService {
    List<Office> getAllOffices();

    Office createOffice(Office office);

    Office updateOffice(Office office);

    void deleteOffice(Long id);
}
