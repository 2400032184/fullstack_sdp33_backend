-- =========================================
-- DATABASE: feedback_db
-- =========================================

-- USERS TABLE
CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    last_login DATETIME,
    last_logout DATETIME
);

-- Sample Users
INSERT INTO users (username, email, password, last_login, last_logout) VALUES
('sriya', 'sriya@gmail.com', 'Srij@207', '2026-04-09 06:12:47', '2026-04-09 06:12:51'),
('tejaswi', 'tejaswi@gmail.com', 'Srij@207', '2026-04-09 06:13:55', '2026-04-09 06:14:03'),
('aadhi', 'aadhi@gmail.com', 'Srij@207', '2026-04-09 06:16:25', '2026-04-09 06:16:34');

-- ADMINS TABLE
CREATE TABLE IF NOT EXISTS admins (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE,
    email VARCHAR(100) UNIQUE,
    password VARCHAR(100),
    role VARCHAR(20)
);

-- Sample Admins
INSERT INTO admins (username, email, password, role) VALUES
('125', '125@gmail.com', 'Srij@207', 'ADMIN'),
('sir', 'sir@gmail.com', 'Srij@207', 'ADMIN'),
('xy', 'xy@gmail.com', 'Srij@207', 'ADMIN'),
('admin', 'admin@gmail.com', 'Srij@207', 'ADMIN');

-- COURSE TABLE
CREATE TABLE IF NOT EXISTS course (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100),
    instructor VARCHAR(100),
    duration VARCHAR(50)
);

-- Sample Courses
INSERT INTO course (id, title, instructor, duration) VALUES
(4, 'Java', 'ABC', '3 Months'),
(6, 'english', 'dude', '3 Months'),
(7, 'telugu', 'sundharam', '4 months'),
(8, 'hindi', 'shanthi', '30 days'),
(9, 'aiml', 'ramesh', '6 months'),
(10, 'cloud infrastructure', 'ram', '3 months'),
(11, 'azure', 'anusha', '12 weeks'),
(12, 'mathematical optimisation', 'imran ali', '6 months');

-- FEEDBACKS TABLE
CREATE TABLE IF NOT EXISTS feedbacks (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT,
    username VARCHAR(50),
    course VARCHAR(100),
    instructor VARCHAR(100),
    star_ratings TEXT,
    options TEXT,
    improvement TEXT,
    submitted_at DATETIME
);

-- Sample Feedbacks
INSERT INTO feedbacks (id, course, improvement, instructor, user_id, submitted_at, options, star_ratings, username) VALUES
(19, 'telugu', 'make it a little easier', 'sundharam', 3, '2026-04-09 01:21:32',
 '{"SyllabusCoverage":"Mostly Covered","FacultySupport":"Supportive","Infrastructure":"Excellent","AssignmentQuality":"Very Relevant"}',
 '{"Course Content Quality":3,"Faculty Teaching Effectiveness":2,"Practical /Lab Sessions":4,"Class Engagement":2,"Overall Satisfaction":4}',
 'abc'),
(20, 'hindi', 'need to improve workbook editions', 'shanthi', 3, '2026-04-09 01:43:10',
 '{"SyllabusCoverage":"Mostly Covered","FacultySupport":"Very Supportive","Infrastructure":"Needs Improvement","AssignmentQuality":"Relevant"}',
 '{"Course Content Quality":3,"Faculty Teaching Effectiveness":5,"Practical /Lab Sessions":2,"Class Engagement":3,"Overall Satisfaction":4}',
 'sriya'),
(21, 'mathematical optimisation', 'problems are too complex', 'imran ali', 7, '2026-04-09 01:44:49',
 '{"SyllabusCoverage":"Mostly Covered","FacultySupport":"Very Supportive","Infrastructure":"Average","AssignmentQuality":"Very Relevant"}',
 '{"Course Content Quality":5,"Faculty Teaching Effectiveness":5,"Practical /Lab Sessions":3,"Class Engagement":4,"Overall Satisfaction":5}',
 'sriya'),
(22, 'hindi', 'more practice', 'shanthi', 7, '2026-04-09 03:35:16',
 '{"SyllabusCoverage":"Insufficient","FacultySupport":"Not Available","Infrastructure":"Average","AssignmentQuality":"Moderate"}',
 '{"Course Content Quality":3,"Faculty Teaching Effectiveness":1,"Practical /Lab Sessions":1,"Class Engagement":1,"Overall Satisfaction":2}',
 'xy');

-- FEEDBACK_FORM TABLE
CREATE TABLE IF NOT EXISTS feedback_form (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    star_categories TEXT,
    options TEXT
);

-- Sample Feedback Form
INSERT INTO feedback_form (id, options, star_categories) VALUES
(1,
'[{"key":"SyllabusCoverage","label":"Syllabus Coverage","choices":["Completed Fully","Mostly Covered","Partially Covered","Insufficient"]},
  {"key":"FacultySupport","label":"Faculty Support Outside Class","choices":["Very Supportive","Supportive","Sometimes Available","Not Available"]},
  {"key":"Infrastructure","label":"Classroom & Infrastructure","choices":["Excellent","Good","Average","Needs Improvement"]},
  {"key":"AssignmentQuality","label":"Assignments & Assessments","choices":["Very Relevant","Relevant","Moderate","Not Useful"]}]',
'["Course Content Quality","Faculty Teaching Effectiveness","Practical / Lab Sessions","Class Engagement","Overall Satisfaction"]'
);