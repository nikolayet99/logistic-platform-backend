package nt.logisticplatform.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import nt.logisticplatform.exception.ApiClientRuntimeException;
import nt.logisticplatform.model.Company;
import nt.logisticplatform.repository.CompanyRepository;
import nt.logisticplatform.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    CompanyRepository companyRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    public Company createCompany(Company company) {
        validateCompany(company);
        return companyRepository.save(company);
    }

    @Override
    public Company updateCompany(Company company) {
        validateCompany(company);
        Company existingCompany = entityManager.find(Company.class, company.getId());
        if (existingCompany == null)
            throw new ApiClientRuntimeException("Invalid company provided.");

        existingCompany = company;
        return entityManager.merge(existingCompany);
    }

    @Override
    public void deleteCompany(Long id) {
        Company existingCompany = entityManager.find(Company.class, id);
        if (existingCompany == null)
            throw new ApiClientRuntimeException("Invalid company provided.");

        companyRepository.deleteById(id);
    }

    private void validateCompany(Company company) {
        String name = company.getName();
        if (name == null || name.isEmpty())
            throw new ApiClientRuntimeException("Invalid company name.");
    }
}
