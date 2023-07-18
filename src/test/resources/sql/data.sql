INSERT INTO categories (id, name, icon)
VALUES (1, 'IT', 'uim uim-layers-alt')
ON CONFLICT DO NOTHING;
INSERT INTO categories (id, name, icon)
VALUES (2, 'Technology', 'uim uim-airplay')
ON CONFLICT DO NOTHING;

INSERT INTO experience (id, level)
VALUES (1, 'No experience')
ON CONFLICT DO NOTHING;
INSERT INTO experience (id, level)
VALUES (2, '1-3 years')
ON CONFLICT DO NOTHING;

INSERT INTO industries (id, name)
VALUES (1, 'Private')
ON CONFLICT DO NOTHING;
INSERT INTO industries (id, name)
VALUES (2, 'Public')
ON CONFLICT DO NOTHING;

INSERT INTO keywords (id, name)
VALUES (1, 'Java')
ON CONFLICT DO NOTHING;
INSERT INTO keywords (id, name)
VALUES (2, 'Python')
ON CONFLICT DO NOTHING;

INSERT INTO users (id, username, email, password, role, full_name, description, phone, whatsapp, instagram,
                   image)
VALUES (1, 'kaspibank', 'kaspibank@kaspi.kz', '$2a$10$39Yx1i2EIbLbTqYZxZ7T3.aOOxyGy6BdAjrIqpV0Mk2TfgHlrXUPO', 'COMPANY',
        NULL, NULL, NULL,
        NULL, NULL, 'channels4_profile.jpg')
ON CONFLICT DO NOTHING;
INSERT INTO users (id, username, email, password, role, full_name, description, phone, whatsapp, instagram,
                   image)
VALUES (2, 'aidyninho', 'aidyninho@gmail.com', '$2a$10$UuMFiv33k6WcGJFpHRdOheag68MSOJnGPRk0b/jEYpLVYCbIAzGN.', 'USER',
        'Aidyn Ryzyk', 'Unemployed, motivated Java developer looking for a job', '87475328299',
        'https://www.whatsapp.com',
        'https://www.instagram.com', 'Kitagawa-Marin-Cosplay-Contact-Lenses.jpg')
ON CONFLICT DO NOTHING;


INSERT INTO jobs (id, name, experience_id, location, salary, qualification, post_date, description, type,
                  industry_id, user_id, category_id)
VALUES (1, 'Java Developer', 1, 'Almaty', 1000, 'Bachelor', '2023-07-05',
        'We are looking for a Java Developer', 'Fulltime', 1, 1, 1)
ON CONFLICT DO NOTHING;
INSERT INTO jobs (id, name, experience_id, location, salary, qualification, post_date, description, type,
                  industry_id, user_id, category_id)
VALUES (2, 'Python Developer', 2, 'Astana', 1500, 'Bachelor', '2023-07-07',
        'We are looking for a Python Developer', 'Featured', 2, 1, 2)
ON CONFLICT DO NOTHING;
SELECT setval('jobs_id_seq', (SELECT max(id) FROM jobs));

INSERT INTO jobs_keywords (job_id, keywords_id)
VALUES (1, 1)
ON CONFLICT DO NOTHING;
INSERT INTO jobs_keywords (job_id, keywords_id)
VALUES (2, 2)
ON CONFLICT DO NOTHING;

INSERT INTO jobs_users (jobs_id, users_id, message)
VALUES (1, 2, 'I want to get this job!')
ON CONFLICT DO NOTHING;
INSERT INTO jobs_users (jobs_id, users_id, message)
VALUES (2, 2, 'I want to get this job!')
ON CONFLICT DO NOTHING;

