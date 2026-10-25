package com.schwedlr.vagas_api.interviews;

import com.schwedlr.vagas_api.applications.Application;
import com.schwedlr.vagas_api.enums.Result;
import com.schwedlr.vagas_api.enums.Type;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "interviews")
public class Interview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Type type;
    @Column(name = "scheduled_at")
    private Timestamp scheduledAt;
    private String interviewer;
    @Enumerated(EnumType.STRING)
    private Result result = Result.PENDING;
    private String notes;
    @Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt;
    @ManyToOne
    @JoinColumn(name = "application_id")
    private Application application;

}
