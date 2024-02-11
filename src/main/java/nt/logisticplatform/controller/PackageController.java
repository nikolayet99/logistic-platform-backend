package nt.logisticplatform.controller;

import io.swagger.v3.oas.annotations.Operation;
import nt.logisticplatform.model.Package;
import nt.logisticplatform.model.PackDTO;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/package")
public interface PackageController {
    @GetMapping("/all")
    @Operation(tags = {"Package"}, summary = "Get all packages")
    List<Package> getAllPackages(@RequestParam(required = false) Boolean sent, @RequestParam(required = false) Boolean received);

    @GetMapping("/all/sent/{personId}")
    @Operation(tags = {"Package"}, summary = "Get all sent packages by person")
    List<Package> getAllSentPackagesByPerson(@PathVariable Long personId);

    @GetMapping("/all/received/{personId}")
    @Operation(tags = {"Package"}, summary = "Get all received packages by person")
    List<Package> getAllReceivedPackagesByPerson(@PathVariable Long personId);

    @GetMapping("/all/registered/{personId}")
    @Operation(tags = {"Package"}, summary = "Get all registered packages by person")
    List<Package> getAllRegisteredPackagesByPerson(@PathVariable Long personId);

    @PostMapping
    @Transactional
    @Operation(tags = {"Package"}, summary = "Create package")
    Package createPackage(@RequestBody PackDTO pack);

    @PutMapping
    @Transactional
    @Operation(tags = {"Package"}, summary = "Update package")
    Package updatePackage(@RequestBody PackDTO pack);

    @DeleteMapping("/{id}")
    @Transactional
    @Operation(tags = {"Package"}, summary = "Delete package by package id")
    void deletePackage(@PathVariable Long id);
}
