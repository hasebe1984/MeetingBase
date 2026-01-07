DROP USER IF EXISTS 'user'@'localhost';
-- いれば消す
CREATE USER 'user'@'localhost' IDENTIFIED BY 'pass';
GRANT ALL PRIVILEGES ON `meetingroomB`.* TO 'user'@'localhost';
-- .*: ユーザー登録及び、そのデータベース内にあるすべてのテーブルへの権限付与
FLUSH PRIVILEGES;
-- メモリ情報の再読み込み
-- 権限確認
-- SHOW GRANTS FOR 'user'@'localhost';
-- https://www.digitalocean.com/community/tutorials/how-to-create-a-new-user-and-grant-permissions-in-mysql-ja

DROP DATABASE IF EXISTS meetingroomB;
CREATE DATABASE meetingroomB;
USE meetingroomB;

DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS room;
DROP TABLE IF EXISTS reservation;

CREATE TABLE user (
        id VARCHAR(7) PRIMARY KEY,
        password VARCHAR(10) NOT NULL,
        name VARCHAR(10),
        address VARCHAR(30)
);

CREATE TABLE room (
        id VARCHAR(4) PRIMARY KEY,
        name VARCHAR(20)
);

CREATE TABLE reservation (
        id INT PRIMARY KEY AUTO_INCREMENT,
        roomid VARCHAR(4) NOT NULL,
        date DATE NOT NULL,
        start TIME NOT NULL,
        end TIME NOT NULL,
        userid VARCHAR(7) NOT NULL,
        FOREIGN KEY(roomid) REFERENCES room(id),
        FOREIGN KEY(userid) REFERENCES user(id),
        UNIQUE(roomid, date, start)
);


INSERT INTO user VALUES('1100003','xxxxxx','情報太郎','東京都');
INSERT INTO user VALUES('1100015','yyyyyy','情報花子','大阪府');

INSERT INTO room VALUES('0201','大会議室');
INSERT INTO room VALUES('0301','３Ａ会議室');
INSERT INTO room VALUES('0302','３Ｂ会議室');

INSERT INTO reservation VALUES(NULL,'0201','テスト実施前日','09:00:00','10:00:00','1100003');
INSERT INTO reservation VALUES(NULL,'0201','テスト実施前日','11:00:00','12:00:00','1100003');
INSERT INTO reservation VALUES(NULL,'0201','テスト実施日','09:00:00','10:00:00','1100003');
INSERT INTO reservation VALUES(NULL,'0301','テスト実施日','12:00:00','13:00:00','1100003');
INSERT INTO reservation VALUES(NULL,'0301','テスト実施日','テスト実施後時間','テスト実施後時間＋１時間','1100003');
INSERT INTO reservation VALUES(NULL,'0302','テスト実施日','13:00:00','14:00:00','1100015');

SELECT * FROM user;
SELECT * FROM room;
SELECT * FROM reservation;

SELECT * FROM reservation, user, room WHERE reservation.roomid = room.id AND reservation.userid = user.id;

SELECT name, address FROM user WHERE id = '1100015' AND password = 'yyyyyy';