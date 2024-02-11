package nt.logisticplatform.controller;

import io.swagger.v3.oas.annotations.Operation;
import nt.logisticplatform.model.Company;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/company")
public interface CompanyController {
    @GetMapping("/all")
    @Operation(tags = {"Company"}, summary = "Get all companies")
    List<Company> getAllCompany();

    @PostMapping
    @Transactional
    @Operation(tags = {"Company"}, summary = "Create company")
    Company createCompany(@RequestBody Company company);

    @PutMapping
    @Transactional
    @Operation(tags = {"Company"}, summary = "Update company")
    Company updateCompany(@RequestBody Company company);

    @DeleteMapping("/{id}")
    @Transactional
    @Operation(tags = {"Company"}, summary = "Delete company by company id")
    void deleteCompany(@PathVariable Long id);
}
