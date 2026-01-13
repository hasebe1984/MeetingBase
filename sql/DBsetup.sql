DROP USER IF EXISTS 'user'@'localhost';
-- いれば消す
CREATE USER 'user'@'localhost' IDENTIFIED BY 'pass';
GRANT ALL PRIVILEGES ON `meetingroomB`.* TO 'user'@'localhost';
-- .*: ユーザー登録及び、そのデータベース内にあるすべてのテーブルへの権限付与
FLUSH PRIVILEGES;
-- メモリ情報の再読み込み
-- 権限確認
-- SHOW GRANTS FOR 'user'@'localhost';
-- ユーザー一覧
-- select user, host from mysql.user;
-- https://www.digitalocean.com/community/tutorials/how-to-create-a-new-user-and-grant-permissions-in-mysql-ja

※データは、DB.sqlをみてね。
is〇〇関連は、デフォルトで０が入るようになってます。

-- SELECT * FROM user;
-- SELECT * FROM room;
-- SELECT * FROM reservation;
-- SELECT * FROM reservation, user, room WHERE reservation.roomid = room.id AND reservation.userid = user.id;
-- SELECT name, address FROM user WHERE id = '1100015' AND password = 'yyyyyy';