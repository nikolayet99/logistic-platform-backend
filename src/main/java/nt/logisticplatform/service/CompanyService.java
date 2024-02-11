package nt.logisticplatform.service;

import nt.logisticplatform.model.Company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompany();

    Company createCompany(Company company);

    Company updateCompany(Company company);

    void deleteCompany(Long id);
}
