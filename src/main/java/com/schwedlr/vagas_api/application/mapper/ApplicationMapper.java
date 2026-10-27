package com.schwedlr.vagas_api.application.mapper;

import com.schwedlr.vagas_api.application.domain.Application;
import com.schwedlr.vagas_api.application.request.ApplicationPutRequest;
import com.schwedlr.vagas_api.application.request.ApplicationRequest;
import com.schwedlr.vagas_api.application.response.ApplicationResponse;
import com.schwedlr.vagas_api.job.domain.Job;
import com.schwedlr.vagas_api.job.request.JobRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ApplicationMapper {


    @Mapping(target = "job", ignore = true)
    Application toDomain(ApplicationRequest request);

    ApplicationResponse toResponse(Application application);

    @Mapping(target = "id", ignore = true)
    void updateDomain(ApplicationPutRequest request, @MappingTarget Application application);
}
