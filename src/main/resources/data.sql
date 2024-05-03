-- 認証テーブル
INSERT INTO auths (auth_id, password, authority) VALUES
-- password
('1111', '$100801$h0bJXCuEyGoc09W7AFNxmw==$L17E2eyODKwbLuknH+dnrBPtsl6ycXHPJURWgD/GU7k=', 'GENERAL'),
('2222', '$100801$h0bJXCuEyGoc09W7AFNxmw==$L17E2eyODKwbLuknH+dnrBPtsl6ycXHPJURWgD/GU7k=', 'ADMIN'),
('3333', '$100801$h0bJXCuEyGoc09W7AFNxmw==$L17E2eyODKwbLuknH+dnrBPtsl6ycXHPJURWgD/GU7k=', 'SUPER_USER'),
('4444', '$100801$h0bJXCuEyGoc09W7AFNxmw==$L17E2eyODKwbLuknH+dnrBPtsl6ycXHPJURWgD/GU7k=', 'GENERAL');

-- ユーザーテーブル
INSERT INTO users (user_name, auth_id) VALUES
('test1', '1111'),
('test2', '2222'),
('test3', '3333'),
('test4', '4444');

-- ロールテーブル
INSERT INTO roles (role_name) VALUES
('不明'),
('役職なし'),
('部長');

-- ユーザー×ロールテーブル
INSERT INTO user_role (user_id, role_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 1);

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