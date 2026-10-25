package com.schwedlr.vagas_api.job.service;

import com.schwedlr.vagas_api.job.domain.Job;
import com.schwedlr.vagas_api.job.mapper.JobMapper;
import com.schwedlr.vagas_api.job.repository.JobRepository;
import com.schwedlr.vagas_api.job.request.JobRequest;
import com.schwedlr.vagas_api.job.response.JobResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobService {

    private final JobRepository repository;
    private final JobMapper mapper;

    public JobService(JobRepository repository, JobMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    // CREATE
    public JobResponse create(JobRequest request) {
        Job job = mapper.toDomain(request);
        repository.save(job);
        return mapper.toResponse(job);
    }

    // READ ALL
    public List<JobResponse> findAll() {
        return repository.findAll().stream().map(mapper::toResponse).collect(Collectors.toList());
    }

    // READ BY ID
    public JobResponse findById(Long id) {
        Job job = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Job not found: " + id));
        return mapper.toResponse(job);
    }

    // UPDATE
    public JobResponse update(Long id, JobRequest request) {
        Job job = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Job not found: " + id));
        mapper.updateDomain(request, job);

        Job jobSaved = repository.save(job);
        return mapper.toResponse(jobSaved);
    }

    // DELETE
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Job not found: " + id);
        }
        repository.deleteById(id);
    }

}
