package com.schwedlr.vagas_api.application.domain;

import com.schwedlr.vagas_api.enums.Status;
import com.schwedlr.vagas_api.job.domain.Job;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "applications")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Status status = Status.APPLIED;
    @Column(name = "applied_at", insertable = false, updatable = false)
    private Timestamp appliedAt;
    private String notes;
    @UpdateTimestamp
    @Column(name = "updated_at", insertable = false)
    private Timestamp updatedAt;
    @OneToOne
    @JoinColumn(name = "job_id")
    private Job job;
}
