package com.schwedlr.vagas_api.job.domain;

import com.schwedlr.vagas_api.enums.Source;
import jakarta.persistence.*;
import lombok.*;
import java.sql.Timestamp;
import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "source")
    private Source jobSource;
    @Column(name = "external_id")
    private String externalId;
    private String title;
    private String company;
    private String location;
    private String workplace;
    private String url;
    @Column(name = "posted_at")
    private LocalDate postedAt;
    @Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt;

}
