package com.schwedlr.vagas_api.job.repository;

import com.schwedlr.vagas_api.job.domain.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
}
