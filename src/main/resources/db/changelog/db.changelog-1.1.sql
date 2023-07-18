--liquibase formatted sql

--changeset aidyninho:1
INSERT INTO categories (name, icon)
VALUES ('IT', 'uim uim-layers-alt');
INSERT INTO categories (name, icon)
VALUES ('Technology', 'uim uim-airplay');
INSERT INTO categories (name, icon)
VALUES ('Government', 'uim uim-bag');
INSERT INTO categories (name, icon)
VALUES ('Telecommunication', 'uim uim-telegram-alt');
INSERT INTO categories (name, icon)
VALUES ('HR', 'uim uim-android-alt');
INSERT INTO categories (name, icon)
VALUES ('Game-Dev', 'uim uim-android-alt');
INSERT INTO categories (name, icon)
VALUES ('Design', 'uim uim-scenery');
INSERT INTO categories (name, icon)
VALUES ('Construction', 'uim uim-hospital');
INSERT INTO categories (name, icon)
VALUES ('Accounting', 'uim uim-user-md');


--changeset aidyninho:2
INSERT INTO experience (level)
VALUES ('No experience');
INSERT INTO experience (level)
VALUES ('1-3 years');
INSERT INTO experience (level)
VALUES ('3-6 years');
INSERT INTO experience (level)
VALUES ('More than 6 years');

--changeset aidyninho:3
INSERT INTO industries (name)
VALUES ('Private');
INSERT INTO industries (name)
VALUES ('Public');
INSERT INTO industries (name)
VALUES ('Medicine');
INSERT INTO industries (name)
VALUES ('Education');

--changeset aidyninho:4
INSERT INTO keywords (name)
VALUES ('Java');
INSERT INTO keywords (name)
VALUES ('Python');
INSERT INTO keywords (name)
VALUES ('Excel');
INSERT INTO keywords (name)
VALUES ('HTML');
INSERT INTO keywords (name)
VALUES ('JavaScript');
INSERT INTO keywords (name)
VALUES ('Golang');

--changeset aidyninho:5
INSERT INTO users (username, email, password, role, full_name, description, phone, whatsapp, instagram,
                   image)
VALUES ('kaspibank', 'kaspibank@kaspi.kz', '$2a$12$CSMnV8407MYRa.hOf7nrie0l60We9TXn.W8f52tTzknl7cv0RjbPu', 'COMPANY', NULL, NULL, NULL,
        NULL, NULL, '800px-Logo_of_Kaspi_bank.png');
INSERT INTO users (username, email, password, role, full_name, description, phone, whatsapp, instagram,
                   image)
VALUES ('welcome', 'welcome@gmail.com', '$2a$12$ygHYBC1oLJ1CNJLVoN0ub.h3fAeV2yXZikdmxgIwtHEV6TLVr3nZu', 'USER',
        'Welcome User', 'Unemployed, motivated Java developer looking for a job', null, 'https://www.whatsapp.com',
        'https://www.instagram.com', 'channels4_profile.jpg');


--changeset aidyninho:6
INSERT INTO jobs (name, experience_id, location, salary, qualification, post_date, description, type,
                         industry_id, user_id, category_id)
VALUES ('Java Developer', 1, 'Almaty', 1000, 'Bachelor', '2023-07-05',
        'We are looking for a Java Developer', 'Fulltime', 1, 1, 1);
INSERT INTO jobs (name, experience_id, location, salary, qualification, post_date, description, type,
                         industry_id, user_id, category_id)
VALUES ('Python Developer', 2, 'Astana', 1500, 'Bachelor', '2023-07-07',
        'We are looking for a Python Developer', 'Featured', 2, 1, 1);
INSERT INTO jobs (name, experience_id, location, salary, qualification, post_date, description, type,
                         industry_id, user_id, category_id)
VALUES ('Golang Developer', 3, 'Almaty', 1000, 'Bachelor', '2023-07-06',
        'We are looking for a Developer', 'Parttime', 1, 1, 1);
INSERT INTO jobs (name, experience_id, location, salary, qualification, post_date, description, type,
                         industry_id, user_id, category_id)
VALUES ('Sales manager', 1, 'Astana', 1000, 'Bachelor', '2023-07-05',
        'We are looking for a Sales Manager', 'Urgent', 1, 1, 3);
INSERT INTO jobs ( name, experience_id, location, salary, qualification, post_date, description, type,
                  industry_id, user_id, category_id)
VALUES ( 'Java Developer', 1, 'Shymkent', 1000, 'Bachelor', '2023-07-05',
        'We are looking for a Java Developer', 'Fulltime', 1, 1, 1);
INSERT INTO jobs (name, experience_id, location, salary, qualification, post_date, description, type,
                  industry_id, user_id, category_id)
VALUES ( 'Python Developer', 2, 'Aqtau', 1500, 'Bachelor', '2023-07-07',
        'We are looking for a Python Developer', 'Featured', 2, 1, 1);
INSERT INTO jobs (name, experience_id, location, salary, qualification, post_date, description, type,
                  industry_id, user_id, category_id)
VALUES ('Golang Developer', 3, 'Atyrau', 1000, 'Bachelor', '2023-07-06',
        'We are looking for a Developer', 'Parttime', 1, 1, 1);
INSERT INTO jobs (name, experience_id, location, salary, qualification, post_date, description, type,
                  industry_id, user_id, category_id)
VALUES ( 'Sales manager', 1, 'Almaty', 1000, 'Bachelor', '2023-07-05',
        'We are looking for a Sales Manager', 'Urgent', 1, 1, 3);
INSERT INTO jobs ( name, experience_id, location, salary, qualification, post_date, description, type,
                  industry_id, user_id, category_id)
VALUES ( 'Developer', 1, 'Almaty', 1000, 'Bachelor', '2023-07-05',
        'We are looking for a Java Developer', 'Remote', 1, 1, 1);
INSERT INTO jobs (name, experience_id, location, salary, qualification, post_date, description, type,
                  industry_id, user_id, category_id)
VALUES ( 'Python Middle Developer', 2, 'Astana', 1500, 'Bachelor', '2023-07-07',
        'We are looking for a Python Developer', 'Featured', 2, 1, 1);
INSERT INTO jobs ( name, experience_id, location, salary, qualification, post_date, description, type,
                  industry_id, user_id, category_id)
VALUES ( 'Golang Senior Developer', 3, 'Almaty', 1000, 'Bachelor', '2023-07-06',
        'We are looking for a Developer', 'Parttime', 1, 1, 1);
INSERT INTO jobs ( name, experience_id, location, salary, qualification, post_date, description, type,
                  industry_id, user_id, category_id)
VALUES ( 'Sales manager assistant', 1, 'Astana', 1000, 'Bachelor', '2023-07-05',
        'We are looking for a Sales Manager', 'Featured', 1, 1, 3);
INSERT INTO jobs ( name, experience_id, location, salary, qualification, post_date, description, type,
                  industry_id, user_id, category_id)
VALUES ( 'Java Junior Developer', 1, 'Almaty', 1000, 'Bachelor', '2023-07-05',
        'We are looking for a Java Developer', 'Parttime', 1, 1, 1);
INSERT INTO jobs ( name, experience_id, location, salary, qualification, post_date, description, type,
                  industry_id, user_id, category_id)
VALUES ( 'Python Developer trainee', 2, 'Astana', 1500, 'Bachelor', '2023-07-07',
        'We are looking for a Python Developer', 'Urgent', 2, 1, 1);
INSERT INTO jobs ( name, experience_id, location, salary, qualification, post_date, description, type,
                  industry_id, user_id, category_id)
VALUES ( 'Golang Developer', 3, 'Almaty', 1000, 'Bachelor', '2023-07-06',
        'We are looking for a Developer', 'Remote', 1, 1, 1);
INSERT INTO jobs ( name, experience_id, location, salary, qualification, post_date, description, type,
                  industry_id, user_id, category_id)
VALUES ( 'Sales manager', 1, 'Astana', 1000, 'Bachelor', '2023-07-05',
        'We are looking for a Sales Manager', 'Urgent', 1, 1, 3);
INSERT INTO jobs ( name, experience_id, location, salary, qualification, post_date, description, type,
                  industry_id, user_id, category_id)
VALUES ( 'No-code Developer', 1, 'Almaty', 1000, 'Bachelor', '2023-07-05',
        'We are looking for a Java Developer', 'Fulltime', 1, 1, 1);
INSERT INTO jobs ( name, experience_id, location, salary, qualification, post_date, description, type,
                  industry_id, user_id, category_id)
VALUES ( 'C# Developer', 2, 'Astana', 1500, 'Bachelor', '2023-07-07',
        'We are looking for a C# Developer', 'Featured', 2, 1, 1);
INSERT INTO jobs ( name, experience_id, location, salary, qualification, post_date, description, type,
                  industry_id, user_id, category_id)
VALUES ( 'Golang Team-lead', 3, 'Almaty', 5000, 'Bachelor', '2023-07-06',
        'We are looking for a Developer', 'Parttime', 1, 1, 1);
INSERT INTO jobs ( name, experience_id, location, salary, qualification, post_date, description, type,
                  industry_id, user_id, category_id)
VALUES ( 'Sales manager', 1, 'Astana', 1000, 'Bachelor', '2023-07-05',
        'We are looking for a Sales Manager', 'Urgent', 1, 1, 3);


--changeset aidyninho:7
INSERT INTO jobs_keywords (job_id, keywords_id)
VALUES (1, 1);
INSERT INTO jobs_keywords (job_id, keywords_id)
VALUES (1, 2);
INSERT INTO jobs_keywords (job_id, keywords_id)
VALUES (2, 2);
INSERT INTO jobs_keywords (job_id, keywords_id)
VALUES (3, 1);
INSERT INTO jobs_keywords (job_id, keywords_id)
VALUES (7, 1);
INSERT INTO jobs_keywords (job_id, keywords_id)
VALUES (7, 2);
INSERT INTO jobs_keywords (job_id, keywords_id)
VALUES (8, 1);
INSERT INTO jobs_keywords (job_id, keywords_id)
VALUES (10, 2);
INSERT INTO jobs_keywords (job_id, keywords_id)
VALUES (17, 2);
INSERT INTO jobs_keywords (job_id, keywords_id)
VALUES (18, 1);
INSERT INTO jobs_keywords (job_id, keywords_id)
VALUES (19, 2);

--changeset aidyninho:8
INSERT INTO jobs_users (jobs_id, users_id, message)
VALUES (1, 2, 'I want to get this job!');
INSERT INTO jobs_users (jobs_id, users_id, message)
VALUES (7, 2, 'I want to get this job!');
INSERT INTO jobs_users (jobs_id, users_id, message)
VALUES (10, 2, 'I want to get this job!');
INSERT INTO jobs_users (jobs_id, users_id, message)
VALUES (15, 2, 'I want to get this job!');
INSERT INTO jobs_users (jobs_id, users_id, message)
VALUES (20, 2, 'I want to get this job!');
INSERT INTO jobs_users (jobs_id, users_id, message)
VALUES (11, 2, 'I want to get this job!');

