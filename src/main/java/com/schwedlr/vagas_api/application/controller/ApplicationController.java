package com.schwedlr.vagas_api.application.controller;

import com.schwedlr.vagas_api.application.domain.Application;
import com.schwedlr.vagas_api.application.request.ApplicationPutRequest;
import com.schwedlr.vagas_api.application.request.ApplicationRequest;
import com.schwedlr.vagas_api.application.response.ApplicationResponse;
import com.schwedlr.vagas_api.application.service.ApplicationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/application")
public class ApplicationController {

    private final ApplicationService service;

    public ApplicationController(ApplicationService service) {
        this.service = service;
    }


    // CREATE
    @PostMapping(value = "/create")
    public ResponseEntity<ApplicationResponse> create(@Valid @RequestBody ApplicationRequest request) {
        ApplicationResponse applicationResponse = service.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(applicationResponse);
    }

    // READ ALL
    @GetMapping(value = "/findAll")
    public ResponseEntity<List<ApplicationResponse>> findAll() {
        List<ApplicationResponse> applications = service.findAll();
        return ResponseEntity.ok(applications);
    }

    // READ BY ID
    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<ApplicationResponse> findById(@PathVariable Long id) {
        ApplicationResponse application = service.findById(id);
        return ResponseEntity.ok(application);
    }

    // UPDATE
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<ApplicationResponse> update(@PathVariable Long id,@Valid @RequestBody ApplicationPutRequest request) {
        ApplicationResponse applicationUpdated = service.update(id, request);
        return ResponseEntity.ok(applicationUpdated);
    }

    // DELETE
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        service.delete(id);
      return  ResponseEntity.noContent().build();
    }


}
