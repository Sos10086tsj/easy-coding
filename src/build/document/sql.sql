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

/*用户注册申请*/
CREATE TABLE `easycoding`.`sys_user_register` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '',
  `username` VARCHAR(45) NULL COMMENT '',
  `salt` VARCHAR(45) NULL COMMENT '',
  `password` VARCHAR(45) NULL COMMENT '',
  `company` VARCHAR(45) CHARACTER SET 'utf8' NULL COMMENT '',
  `eff_from` TIMESTAMP NULL COMMENT '',
  `eff_to` TIMESTAMP NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `SYS_USER_REGISTER_IDX1` (`username` ASC)  COMMENT '');
ALTER TABLE `easycoding`.`sys_user_register` ADD COLUMN `token` VARCHAR(45) NULL COMMENT '' AFTER `eff_to`;
ALTER TABLE `easycoding`.`sys_user_register` 
ADD COLUMN `status` INT NULL COMMENT '' AFTER `token`;
