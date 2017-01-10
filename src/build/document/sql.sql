/*创建用户表*/
CREATE TABLE `easycoding`.`sys_user` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '',
  `username` VARCHAR(45) NULL COMMENT '',
  `salt` VARCHAR(10) NULL COMMENT '',
  `password` VARCHAR(45) NULL COMMENT '',
  `name` VARCHAR(45) CHARACTER SET 'utf8' NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `sys_user_username_idx` (`username` ASC)  COMMENT '');
/*增加管理员账号*/
INSERT INTO `easycoding`.`sys_user` (`username`, `salt`, `password`, `name`) VALUES ('admin', ')-w)4E', '9938f706ce2253ccb8cdb66b9aa85942', '管理员');
