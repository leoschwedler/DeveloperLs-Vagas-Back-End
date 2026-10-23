CREATE TABLE jobs (
                      id          BIGSERIAL PRIMARY KEY,
                      source      VARCHAR(20)  NOT NULL,
                      external_id VARCHAR(100) NOT NULL,
                      title       VARCHAR(255) NOT NULL,
                      company     VARCHAR(255) NOT NULL,
                      location    VARCHAR(255),
                      workplace   VARCHAR(20),
                      url         TEXT         NOT NULL,
                      posted_at   DATE,
                      created_at  TIMESTAMPTZ  NOT NULL DEFAULT now(),
                      CONSTRAINT uk_jobs_source_external UNIQUE (source, external_id),
                      CONSTRAINT ck_jobs_source CHECK (source IN ('LINKEDIN', 'INDEED', 'GUPY'))
);

CREATE TABLE applications (
                              id         BIGSERIAL PRIMARY KEY,
                              job_id     BIGINT      NOT NULL REFERENCES jobs (id),
                              status     VARCHAR(20) NOT NULL DEFAULT 'APPLIED',
                              applied_at TIMESTAMPTZ NOT NULL DEFAULT now(),
                              notes      TEXT,
                              updated_at TIMESTAMPTZ NOT NULL DEFAULT now(),
                              CONSTRAINT uk_applications_job UNIQUE (job_id),
                              CONSTRAINT ck_applications_status CHECK (status IN (
                                                                                  'APPLIED', 'SCREENING', 'INTERVIEW', 'TECHNICAL_TEST',
                                                                                  'OFFER', 'REJECTED', 'GHOSTED', 'WITHDRAWN'))
);

CREATE INDEX idx_applications_status ON applications (status);

CREATE TABLE interviews (
                            id             BIGSERIAL PRIMARY KEY,
                            application_id BIGINT      NOT NULL REFERENCES applications (id) ON DELETE CASCADE,
                            type           VARCHAR(20) NOT NULL,
                            scheduled_at   TIMESTAMPTZ,
                            interviewer    VARCHAR(255),
                            result         VARCHAR(20) NOT NULL DEFAULT 'PENDING',
                            notes          TEXT,
                            created_at     TIMESTAMPTZ NOT NULL DEFAULT now(),
                            CONSTRAINT ck_interviews_type   CHECK (type IN ('HR', 'TECHNICAL', 'FINAL', 'OTHER')),
                            CONSTRAINT ck_interviews_result CHECK (result IN ('PENDING', 'PASSED', 'FAILED'))
);

CREATE INDEX idx_interviews_application ON interviews (application_id);