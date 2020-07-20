-- MySQL

DROP database IF EXISTS mydemodb;

CREATE SCHEMA mydemodb ;

CREATE TABLE mydemodb.students
(
    id bigint NOT NULL,
    first_name character varying(255) NOT NULL,
    last_name character varying(255) NOT NULL,
    email_address character varying(255) NOT NULL,
    created_at time without time zone NOT NULL,
    created_by time without time zone NOT NULL,
    updated_at time without time zone NOT NULL,
    updated_by time without time zone NOT NULL,  
    PRIMARY KEY (id)
);

SELECT * FROM mydemodb.students ORDER BY id ASC LIMIT 100;

INSERT INTO mydemodb.students (id, created_at, created_by, email_address, first_name, last_name, updated_at, updated_by)
			     VALUES ('1', '2019-10-06', '2019-10-06', 'mimara.slan@gmail.com', 'Mimar','Aslan', '2019-10-06', '2019-10-06');



-- PostgreSQL

DROP database IF EXISTS mydemodb;

CREATE SCHEMA mydemodb ;

DROP TABLE public.students;

CREATE TABLE IF NOT EXISTS public.students
(
    id bigint NOT NULL,
    created_at timestamp without time zone,
    created_by character varying(255) COLLATE pg_catalog."default",
    email_address character varying(255) COLLATE pg_catalog."default" NOT NULL,
    first_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    last_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    updated_at timestamp without time zone,
    updated_by character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT students_pkey PRIMARY KEY (id)
    )


TABLESPACE pg_default;

ALTER TABLE public.students;

SELECT * FROM public.students ORDER BY id ASC LIMIT 100;

INSERT INTO public.students (id, created_at, created_by, email_address, first_name, last_name, updated_at, updated_by)
VALUES ('1', '2019-10-06', '2019-10-06', 'mimara.slan@gmail.com', 'Mimar','Aslan', '2019-10-06', '2019-10-06');

