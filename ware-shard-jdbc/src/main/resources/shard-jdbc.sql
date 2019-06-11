CREATE TABLE table_one (
	id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID',
	phone VARCHAR(20) NOT NULL COMMENT '手机号',
	back_one VARCHAR(50) DEFAULT NULL COMMENT '备用1',
	back_two VARCHAR(50) DEFAULT NULL COMMENT '备用2',
	back_three VARCHAR(50) DEFAULT NULL COMMENT '备用3',
	KEY `phoneIndex` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='表1';

CREATE TABLE table_two (
	id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID',
	phone VARCHAR(20) NOT NULL COMMENT '手机号',
	back_one VARCHAR(50) DEFAULT NULL COMMENT '备用1',
	back_two VARCHAR(50) DEFAULT NULL COMMENT '备用2',
	back_three VARCHAR(50) DEFAULT NULL COMMENT '备用3',
	KEY `phoneIndex` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='表2';

CREATE TABLE table_three (
	id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID',
	phone VARCHAR(20) NOT NULL COMMENT '手机号',
	back_one VARCHAR(50) DEFAULT NULL COMMENT '备用1',
	back_two VARCHAR(50) DEFAULT NULL COMMENT '备用2',
	back_three VARCHAR(50) DEFAULT NULL COMMENT '备用3',
	KEY `phoneIndex` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='表3';


-- 分表：可以数据库编程建表，或者程序建表
CREATE TABLE `table_one_1` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `phone` varchar(20) NOT NULL COMMENT '手机号',
  `back_one` varchar(50) DEFAULT NULL COMMENT '备用1',
  `back_two` varchar(50) DEFAULT NULL COMMENT '备用2',
  `back_three` varchar(50) DEFAULT NULL COMMENT '备用3',
  PRIMARY KEY (`id`),
  KEY `phoneIndex` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `table_one_2` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `phone` varchar(20) NOT NULL COMMENT '手机号',
  `back_one` varchar(50) DEFAULT NULL COMMENT '备用1',
  `back_two` varchar(50) DEFAULT NULL COMMENT '备用2',
  `back_three` varchar(50) DEFAULT NULL COMMENT '备用3',
  PRIMARY KEY (`id`),
  KEY `phoneIndex` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;

CREATE TABLE `table_one_3` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `phone` varchar(20) NOT NULL COMMENT '手机号',
  `back_one` varchar(50) DEFAULT NULL COMMENT '备用1',
  `back_two` varchar(50) DEFAULT NULL COMMENT '备用2',
  `back_three` varchar(50) DEFAULT NULL COMMENT '备用3',
  PRIMARY KEY (`id`),
  KEY `phoneIndex` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;

CREATE TABLE `table_one_4` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `phone` varchar(20) NOT NULL COMMENT '手机号',
  `back_one` varchar(50) DEFAULT NULL COMMENT '备用1',
  `back_two` varchar(50) DEFAULT NULL COMMENT '备用2',
  `back_three` varchar(50) DEFAULT NULL COMMENT '备用3',
  PRIMARY KEY (`id`),
  KEY `phoneIndex` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;

CREATE TABLE `table_one_5` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `phone` varchar(20) NOT NULL COMMENT '手机号',
  `back_one` varchar(50) DEFAULT NULL COMMENT '备用1',
  `back_two` varchar(50) DEFAULT NULL COMMENT '备用2',
  `back_three` varchar(50) DEFAULT NULL COMMENT '备用3',
  PRIMARY KEY (`id`),
  KEY `phoneIndex` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;

CREATE TABLE `table_two_1` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `phone` varchar(20) NOT NULL COMMENT '手机号',
  `back_one` varchar(50) DEFAULT NULL COMMENT '备用1',
  `back_two` varchar(50) DEFAULT NULL COMMENT '备用2',
  `back_three` varchar(50) DEFAULT NULL COMMENT '备用3',
  PRIMARY KEY (`id`),
  KEY `phoneIndex` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `table_two_2` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `phone` varchar(20) NOT NULL COMMENT '手机号',
  `back_one` varchar(50) DEFAULT NULL COMMENT '备用1',
  `back_two` varchar(50) DEFAULT NULL COMMENT '备用2',
  `back_three` varchar(50) DEFAULT NULL COMMENT '备用3',
  PRIMARY KEY (`id`),
  KEY `phoneIndex` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;

CREATE TABLE `table_two_3` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `phone` varchar(20) NOT NULL COMMENT '手机号',
  `back_one` varchar(50) DEFAULT NULL COMMENT '备用1',
  `back_two` varchar(50) DEFAULT NULL COMMENT '备用2',
  `back_three` varchar(50) DEFAULT NULL COMMENT '备用3',
  PRIMARY KEY (`id`),
  KEY `phoneIndex` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;

CREATE TABLE `table_two_4` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `phone` varchar(20) NOT NULL COMMENT '手机号',
  `back_one` varchar(50) DEFAULT NULL COMMENT '备用1',
  `back_two` varchar(50) DEFAULT NULL COMMENT '备用2',
  `back_three` varchar(50) DEFAULT NULL COMMENT '备用3',
  PRIMARY KEY (`id`),
  KEY `phoneIndex` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;

CREATE TABLE `table_two_5` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `phone` varchar(20) NOT NULL COMMENT '手机号',
  `back_one` varchar(50) DEFAULT NULL COMMENT '备用1',
  `back_two` varchar(50) DEFAULT NULL COMMENT '备用2',
  `back_three` varchar(50) DEFAULT NULL COMMENT '备用3',
  PRIMARY KEY (`id`),
  KEY `phoneIndex` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;