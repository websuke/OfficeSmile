-- 認証テーブル
INSERT INTO auths (auth_id, password) VALUES
('1111', 'password'),
('2222', 'password'),
('3333', 'password');

-- ユーザーテーブル
INSERT INTO users (user_name) VALUES
('test1'),
('test2'),
('test3');

-- ユーザー×認証テーブル
INSERT INTO user_auth (user_id, auth_id, role) VALUES
(1 , '1111', 'GENERAL'),
(2 , '2222', 'ADMIN'),
(3 , '3333', 'SUPERUSER');

-- 理由概要テーブル
INSERT INTO reason_summaries (reason_summary) VALUES
('面談'),
('自主学習'),
('遊びに来ただけ'),
('その他');

-- 帰社テーブル
INSERT INTO returning_to_works (reason_summary_id, reason_details, date_time, user_id) VALUES
(1, 'xxさんとの面談', '2024-04-21 17:00:05', 1),
(2, 'カリキュラム学習', '2024-04-22 17:00:05', 2),
(3, null, '2024-04-23 17:00:05', 3),
(4, '書類提出', '2024-04-23 17:50:05', 1);

-- 帰宅テーブル
INSERT INTO going_homes (returning_to_work_id, date_time) VALUES
(1, '2024-04-21 19:00:00'),
(2, '2024-04-22 19:00:00'),
(3, '2024-04-23 19:00:00'),
(4, '2024-04-23 19:00:00');