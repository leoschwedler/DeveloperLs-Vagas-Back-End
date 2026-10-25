package com.schwedlr.vagas_api.job.mapper;

import com.schwedlr.vagas_api.job.domain.Job;
import com.schwedlr.vagas_api.job.request.JobRequest;
import com.schwedlr.vagas_api.job.response.JobResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface JobMapper {

    Job toDomain(JobRequest request);

    JobResponse toResponse(Job job);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    void updateDomain(JobRequest request, @MappingTarget Job job);
}
