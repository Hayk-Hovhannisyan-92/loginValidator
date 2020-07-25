# FirstIndependentlyProject

#Data Preparation

-- Database: myProjectDB

-- DROP DATABASE "myProjectDB";

CREATE DATABASE "myProjectDB"
    WITH 
    OWNER = admin
    ENCODING = 'UTF8'
    LC_COLLATE = 'Armenian_Armenia.utf8'
    LC_CTYPE = 'Armenian_Armenia.utf8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
    
CREATE TABLE public.users
(
    id integer NOT NULL DEFAULT nextval('users_id_seq'::regclass),
    email character varying COLLATE pg_catalog."default" NOT NULL,
    password character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT users_pkey PRIMARY KEY (id)
)
    

#To Build the project run the following command

mvn clean install

#To run the Login Validator run RunLoginValidator class as java application



