INSERT INTO student (id, student_no, name, email, password)
VALUES (1, 'test', 'Test User', 'test@example.com', '$2a$10$3J3j2b3L3v3k3n3m3p3q3r3s3t3u3v3w3x3y3z3A3B3C3D3E3F3G3H3I3J3K');

INSERT INTO student_roles (student_id, roles)
VALUES (1, 'USER');