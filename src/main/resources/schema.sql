-- 認証テーブル
CREATE TABLE auths(
    auth_id VARCHAR(128) PRIMARY KEY,
    password VARCHAR(128)
);

-- ユーザーテーブル
CREATE TABLE users(
    user_id BIGSERIAL PRIMARY KEY,
    user_name VARCHAR(256) NOT NULL
);

-- ユーザー×認証テーブル
CREATE TABLE user_auth(
    user_id BIGINT NOT NULL,
    auth_id VARCHAR(128) NOT NULL,
    role ENUM('GENERAL', 'ADMIN', 'SUPERUSER') NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (auth_id) REFERENCES auths(auth_id)
);

-- 理由概要テーブル
CREATE TABLE reason_summaries(
    reason_summary_id BIGSERIAL PRIMARY KEY,
    reason_summary VARCHAR(100) NOT NULL UNIQUE
);

-- 帰社テーブル
CREATE TABLE returning_to_works(
    returning_to_work_id BIGSERIAL PRIMARY KEY,
    reason_summary_id VARCHAR(100) NOT NULL,
    reason_details TEXT,
    date_time DATETIME,
    user_id BIGINT NOT NULL,
    FOREIGN KEY (reason_summary_id) REFERENCES reason_summaries(reason_summary_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

-- 帰宅テーブル
CREATE TABLE going_homes(
    going_home_id BIGSERIAL PRIMARY KEY,
    returning_to_work_id BIGINT NOT NULL,
    date_time DATETIME,
    FOREIGN KEY (returning_to_work_id) REFERENCES returning_to_works(returning_to_work_id)
);