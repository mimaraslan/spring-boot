CREATE SCHEMA `mymasterdetaildb` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;

USE `mymasterdetaildb`;

CREATE TABLE `user` (`id` bigint(20) NOT NULL,
                     `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                     `user_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
                     PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `mymasterdetaildb`.`user` (`id`, `password`, `user_name`) VALUES ('1', '123', 'Lolo');

SELECT * FROM mymasterdetaildb.user;