package com.schwedlr.vagas_api.application.repository;

import com.schwedlr.vagas_api.application.domain.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

    boolean existsByJobId(Long jobId);
}
