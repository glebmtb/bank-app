CREATE TABLE IF NOT EXISTS `account`(
 `accountId`    INTEGER PRIMARY KEY,
 `amount`       BIGINT NOT NULL
);

INSERT INTO account
VALUES (1, 100);