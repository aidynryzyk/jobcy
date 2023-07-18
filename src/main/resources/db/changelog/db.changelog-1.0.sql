--liquibase formatted sql

--changeset aidyninho:1
CREATE TABLE IF NOT EXISTS categories
(
    id   serial NOT NULL PRIMARY KEY ,
    name character varying(128),
    icon character varying(128)
);

--changeset aidyninho:2
CREATE TABLE IF NOT EXISTS experience
(
    id    serial                 NOT NULL PRIMARY KEY ,
    level character varying(128) NOT NULL
);

--changeset aidyninho:3
CREATE TABLE IF NOT EXISTS industries
(
    id   serial NOT NULL PRIMARY KEY ,
    name character varying(128)
);


--changeset aidyninho:4
CREATE TABLE IF NOT EXISTS keywords
(
    id   serial NOT NULL PRIMARY KEY ,
    name character varying(128)
);

--changeset aidyninho:5
CREATE TABLE IF NOT EXISTS users
(
    id          serial NOT NULL PRIMARY KEY ,
    username    character varying(128),
    email       character varying(128),
    password    character varying(128),
    role        character varying(128),
    full_name   character varying(128),
    description text,
    phone       character varying(128),
    whatsapp    character varying(128),
    instagram   character varying(128),
    image       character varying(128)
);

--changeset aidyninho:6
CREATE TABLE IF NOT EXISTS jobs
(
    id            serial                 NOT NULL PRIMARY KEY ,
    name          character varying(128) NOT NULL,
    experience_id integer REFERENCES experience(id),
    location      character varying(128),
    salary        integer,
    qualification character varying(128),
    post_date     date                   NOT NULL,
    description   text,
    type          character varying(128),
    industry_id   integer REFERENCES industries(id),
    user_id       integer not null REFERENCES users(id),
    category_id   integer REFERENCES categories(id)
);


--changeset aidyninho:7
CREATE TABLE IF NOT EXISTS jobs_keywords
(
    job_id      integer REFERENCES jobs(id) ON DELETE CASCADE ,
    keywords_id integer REFERENCES keywords(id)
);


--changeset aidyninho:8
CREATE TABLE IF NOT EXISTS jobs_users
(
    jobs_id  integer REFERENCES jobs(id) ON DELETE CASCADE ,
    users_id integer REFERENCES users(id) ON DELETE CASCADE ,
    message  text,
    id       serial NOT NULL PRIMARY KEY
);