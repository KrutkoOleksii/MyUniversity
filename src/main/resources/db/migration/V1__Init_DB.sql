-- SCHEMA: schedule
-- DROP SCHEMA IF EXISTS schedule ;
CREATE SCHEMA IF NOT EXISTS schedule
    AUTHORIZATION postgres;

-- Table: schedule.audience
-- DROP TABLE IF EXISTS schedule.audience;
CREATE TABLE IF NOT EXISTS schedule.audience
(
    id bigint NOT NULL,
    name character varying(255),
    CONSTRAINT audience_pkey PRIMARY KEY (id)
);

-- Table: schedule.person
-- DROP TABLE IF EXISTS schedule.person;
CREATE TABLE IF NOT EXISTS schedule.person
(
    id bigint NOT NULL,
    name character varying(255),
    surname character varying(255),
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

-- Table: schedule.study_group
-- DROP TABLE IF EXISTS schedule.study_group;
CREATE TABLE IF NOT EXISTS schedule.study_group
(
    id bigint NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT study_group_pkey PRIMARY KEY (id)
);

-- Table: schedule.subject
-- DROP TABLE IF EXISTS schedule.subject;
CREATE TABLE IF NOT EXISTS schedule.subject
(
    id bigint NOT NULL,
    name character varying(255),
    CONSTRAINT subject_pkey PRIMARY KEY (id)
);

-- Table: schedule.group_schedule
-- DROP TABLE IF EXISTS schedule.group_schedule;
CREATE TABLE IF NOT EXISTS schedule.group_schedule
(
    id bigint NOT NULL,
    study_group_id bigint,
    CONSTRAINT group_schedule_pkey PRIMARY KEY (id),
    CONSTRAINT fkch6iyl2k8h0byaw44s7j8pwlk FOREIGN KEY (study_group_id)
        REFERENCES schedule.study_group (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

-- Table: schedule.professor
-- DROP TABLE IF EXISTS schedule.professor;
CREATE TABLE IF NOT EXISTS schedule.professor
(
    id bigint NOT NULL,
    person_id bigint,
    CONSTRAINT professor_pkey PRIMARY KEY (id),
    CONSTRAINT fkh2gyh31ixmqk2wicvlpbj5xy7 FOREIGN KEY (person_id)
        REFERENCES schedule.person (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

-- Table: schedule.student

-- DROP TABLE IF EXISTS schedule.student;

CREATE TABLE IF NOT EXISTS schedule.student
(
    id bigint NOT NULL,
    person_id bigint,
    study_group_id bigint,
    CONSTRAINT student_pkey PRIMARY KEY (id),
    CONSTRAINT fkf7v2dqk1lpijr113vtuu0etnq FOREIGN KEY (study_group_id)
        REFERENCES schedule.study_group (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fknwsufvlvlnsxqv60ltj06bbfx FOREIGN KEY (person_id)
        REFERENCES schedule.person (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

-- Table: schedule.day_schedule
-- DROP TABLE IF EXISTS schedule.day_schedule;
CREATE TABLE IF NOT EXISTS schedule.day_schedule
(
    id bigint NOT NULL,
    day_of_week integer,
    group_schedule_id bigint,
    CONSTRAINT day_schedule_pkey PRIMARY KEY (id),
    CONSTRAINT fkm5rq3by5mddxmi9kbq8plm7py FOREIGN KEY (group_schedule_id)
        REFERENCES schedule.group_schedule (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

-- Table: schedule.lecture
-- DROP TABLE IF EXISTS schedule.lecture;
CREATE TABLE IF NOT EXISTS schedule.lecture
(
    id bigint NOT NULL,
    audience_id bigint,
    day_schedule_id bigint,
    professor_id bigint,
    subject_id bigint,
    CONSTRAINT lecture_pkey PRIMARY KEY (id),
    CONSTRAINT fke4a1kd2dml7m5hr42aal7nvew FOREIGN KEY (subject_id)
        REFERENCES schedule.subject (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkrr5qj8ii9c0hek5ek3t1kxqwi FOREIGN KEY (day_schedule_id)
        REFERENCES schedule.day_schedule (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkt8mbxt40u04lpmvtyxbwprfkw FOREIGN KEY (professor_id)
        REFERENCES schedule.professor (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkti0ca63fo45ex4eed32uo6b8u FOREIGN KEY (audience_id)
        REFERENCES schedule.audience (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

