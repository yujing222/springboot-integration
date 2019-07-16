CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_name` varchar(30) DEFAULT NULL,
  `user_role` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户权限表';

INSERT INTO `user_role` (`id`, `user_name`, `user_role`) VALUES ('1', 'root', 'ROLE_LEVEL1');
INSERT INTO `user_role` (`id`, `user_name`, `user_role`) VALUES ('2', 'root', 'ROLE_LEVEL2');