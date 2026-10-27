package com.schwedlr.vagas_api.application.service;

import com.schwedlr.vagas_api.application.domain.Application;
import com.schwedlr.vagas_api.application.mapper.ApplicationMapper;
import com.schwedlr.vagas_api.application.repository.ApplicationRepository;
import com.schwedlr.vagas_api.application.request.ApplicationPutRequest;
import com.schwedlr.vagas_api.application.request.ApplicationRequest;
import com.schwedlr.vagas_api.application.response.ApplicationResponse;
import com.schwedlr.vagas_api.exceptions.ApplicationNotFoundException;
import com.schwedlr.vagas_api.exceptions.DuplicateApplicationException;
import com.schwedlr.vagas_api.exceptions.JobNotFoundException;
import com.schwedlr.vagas_api.job.domain.Job;
import com.schwedlr.vagas_api.job.repository.JobRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final JobRepository jobRepository;
    private final ApplicationMapper mapper;

    public ApplicationService(ApplicationRepository applicationRepository, JobRepository jobRepository, ApplicationMapper mapper) {
        this.applicationRepository = applicationRepository;
        this.jobRepository = jobRepository;
        this.mapper = mapper;
    }

    // CREATE
    public ApplicationResponse create (ApplicationRequest request){
        Job job = jobRepository.findById(request.jobId()).orElseThrow(() -> new JobNotFoundException(request.jobId()));

        if (applicationRepository.existsByJobId(job.getId())){
            throw new DuplicateApplicationException(request.jobId());
        }

        Application application = mapper.toDomain(request);
        application.setJob(job);
        Application applicationCreated = applicationRepository.save(application);

        return mapper.toResponse(applicationCreated);
    }


    // READ ALL
    public List<ApplicationResponse> findAll(){
        return applicationRepository.findAll().stream().map(mapper::toResponse).collect(Collectors.toList());
    }

    // READ BY ID
    public ApplicationResponse findById(Long id){
        Application application = applicationRepository.findById(id).orElseThrow(() -> new ApplicationNotFoundException(id));
        return mapper.toResponse(application);
    }

    // UPDATE
    public ApplicationResponse update(Long id, ApplicationPutRequest request){
        Application application = applicationRepository.findById(id).orElseThrow(() -> new ApplicationNotFoundException(id));
        mapper.updateDomain(request,application);
        Application applicationSaved = applicationRepository.save(application);
        return mapper.toResponse(applicationSaved);
    }

    // DELETE
    public void delete (Long id){
        Application application = applicationRepository.findById(id).orElseThrow(() -> new ApplicationNotFoundException(id));
        applicationRepository.delete(application);
    }
}
