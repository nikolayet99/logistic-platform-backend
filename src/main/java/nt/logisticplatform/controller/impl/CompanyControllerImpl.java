package nt.logisticplatform.controller.impl;

import nt.logisticplatform.controller.CompanyController;
import nt.logisticplatform.model.Company;
import nt.logisticplatform.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompanyControllerImpl implements CompanyController {
    @Autowired
    private CompanyService companyService;

    @Override
    public List<Company> getAllCompany() {
        return companyService.getAllCompany();
    }

    @Override
    public Company createCompany(Company company) {
        return companyService.createCompany(company);
    }

    @Override
    public Company updateCompany(Company company) {
        return companyService.updateCompany(company);
    }

    @Override
    public void deleteCompany(Long id) {
        companyService.deleteCompany(id);
    }
}
