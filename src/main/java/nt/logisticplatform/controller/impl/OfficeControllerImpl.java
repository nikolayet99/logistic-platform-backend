package nt.logisticplatform.controller.impl;

import nt.logisticplatform.controller.OfficeController;
import nt.logisticplatform.model.Office;
import nt.logisticplatform.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OfficeControllerImpl implements OfficeController {
    @Autowired
    private OfficeService officeService;

    @Override
    public List<Office> getAllOffices() {
        return officeService.getAllOffices();
    }

    @Override
    public Office createOffice(Office office) {
        return officeService.createOffice(office);
    }

    @Override
    public Office updateOffice(Office office) {
        return officeService.updateOffice(office);
    }

    @Override
    public void deleteOffice(Long id) {
        officeService.deleteOffice(id);
    }
}
