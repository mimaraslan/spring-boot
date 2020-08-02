CREATE DATABASE IF NOT EXISTS mydemodb DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;

CREATE TABLE `mydemodb`.`user` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME = 'mydemodb';
SHOW DATABASES LIKE 'mydemodb';
INSERT INTO `mydemodb`.`user` (`id`, `name`) VALUES ('1', 'Katerina');
INSERT INTO `mydemodb`.`user` (`id`, `name`) VALUES ('2', 'Anastasiya');
INSERT INTO `mydemodb`.`user` (`id`, `name`) VALUES ('3', 'Yelena');
SELECT * FROM mydemodb.user;
