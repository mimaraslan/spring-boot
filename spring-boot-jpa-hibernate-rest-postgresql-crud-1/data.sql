CREATE TABLE public.users
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

ALTER TABLE public.users
    OWNER to postgres;
    

INSERT INTO users (id, created_at, created_by, email_address, first_name, last_name, updated_at, updated_by)
			     VALUES ('1', '2019-10-06', '2019-10-06', 'mimaraslan@gmail.com', 'Mimar','Aslan', '2019-10-06', '2019-10-06');
	
SELECT * FROM users;