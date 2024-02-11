package nt.logisticplatform.controller;

import io.swagger.v3.oas.annotations.Operation;
import nt.logisticplatform.model.Office;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/office")
public interface OfficeController {
    @GetMapping("/all")
    @Operation(tags = {"Office"}, summary = "Get all offices")
    List<Office> getAllOffices();

    @PostMapping
    @Transactional
    @Operation(tags = {"Office"}, summary = "Create office")
    Office createOffice(@RequestBody Office office);

    @PutMapping
    @Transactional
    @Operation(tags = {"Office"}, summary = "Update office")
    Office updateOffice(@RequestBody Office office);

    @DeleteMapping("/{id}")
    @Transactional
    @Operation(tags = {"Office"}, summary = "Delete office by office id")
    void deleteOffice(@PathVariable Long id);
}
