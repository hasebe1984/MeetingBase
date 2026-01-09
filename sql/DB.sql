DROP USER IF EXISTS 'user'@'localhost';
CREATE USER 'user'@'localhost' IDENTIFIED BY 'pass';
GRANT ALL PRIVILEGES ON `meetingroomB`.* TO 'user'@'localhost';
FLUSH PRIVILEGES;

DROP DATABASE IF EXISTS meetingroomB;
create database meetingroomB default character set utf8 collate utf8_general_ci;
USE meetingroomB;

DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS room;
DROP TABLE IF EXISTS reservation;

CREATE TABLE user (
        id VARCHAR(7) PRIMARY KEY,
        password VARCHAR(255) NOT NULL,
        name VARCHAR(10),
        address VARCHAR(30),
        isDeleted TINYINT(1) not null,
        isAdmin TINYINT(1) not null
);

CREATE TABLE room (
        id VARCHAR(4) PRIMARY KEY,
        name VARCHAR(20)
);

CREATE TABLE reservation (
        id INT PRIMARY KEY AUTO_INCREMENT,
        roomId VARCHAR(4) NOT NULL,
        date DATE NOT NULL,
        start TIME NOT NULL,
        end TIME NOT NULL,
        userId VARCHAR(7) NOT NULL,
        FOREIGN KEY(roomid) REFERENCES room(id),
        FOREIGN KEY(userid) REFERENCES user(id),
        UNIQUE(roomId, date, start)
);


INSERT INTO user VALUES('1100003','xxxxxx','一般太郎','東京都','0','0');
INSERT INTO user VALUES('1100015','yyyyyy','管理花子','大阪府','0','1');
INSERT INTO user VALUES('1100015','yyyyyy','削除よしお','大阪府','1','0');
INSERT INTO user VALUES('1100015','yyyyyy','管理削除リチャード','大阪府','1','1');

INSERT INTO room VALUES('0201','大会議室');
INSERT INTO room VALUES('0301','３Ａ会議室');
INSERT INTO room VALUES('0302','３Ｂ会議室');

INSERT INTO reservation VALUES(NULL,'0201','2026-01-01','09:00:00','10:00:00','1100003');
INSERT INTO reservation VALUES(NULL,'0201','2026-01-01','11:00:00','12:00:00','1100003');
INSERT INTO reservation VALUES(NULL,'0201','2026-01-05','09:00:00','10:00:00','1100003');
INSERT INTO reservation VALUES(NULL,'0301','2026-01-05','12:00:00','13:00:00','1100003');
INSERT INTO reservation VALUES(NULL,'0301','2026-01-05','09:00:00','10:00:00','1100003');
INSERT INTO reservation VALUES(NULL,'0302','2026-01-05','13:00:00','14:00:00','1100015');