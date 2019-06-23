/*
Navicat MySQL Data Transfer

Source Server         : train
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : train

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-06-17 11:39:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for budget
-- ----------------------------
DROP TABLE IF EXISTS `budget`;
CREATE TABLE `budget` (
  `budget_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) DEFAULT '' COMMENT '预算项目',
  `ysje` double DEFAULT '0' COMMENT '预算费用',
  `hfje` double DEFAULT '0' COMMENT '花费金额',
  `ysyear` varchar(200) DEFAULT '' COMMENT '预算年度，yyyy',
  PRIMARY KEY (`budget_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='预算表';

-- ----------------------------
-- Records of budget
-- ----------------------------

-- ----------------------------
-- Table structure for pxjiesuan
-- ----------------------------
DROP TABLE IF EXISTS `pxjiesuan`;
CREATE TABLE `pxjiesuan` (
  `pxjiesuan_id` int(11) NOT NULL AUTO_INCREMENT,
  `pxshenbao_id` int(11) NOT NULL COMMENT '培训申报id',
  `user_id` bigint(20) NOT NULL COMMENT '结算人',
  `begindate` datetime NOT NULL COMMENT '开始时间',
  `enddate` datetime NOT NULL COMMENT '结束时间',
  `txuser` varchar(200) DEFAULT NULL COMMENT '同行人',
  `hfje` double DEFAULT '0' COMMENT '花费金额',
  `pxzj` mediumtext COMMENT '培训总结',
  `audit` tinyint(4) DEFAULT '0' COMMENT '审批(0.未审批、1.同意、2.不同意、3.修改)',
  `bxstatus` tinyint(4) DEFAULT '0' COMMENT '报销状态(1.已报修、0.未报销)',
  PRIMARY KEY (`pxjiesuan_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='出差结算表';

-- ----------------------------
-- Records of pxjiesuan
-- ----------------------------

-- ----------------------------
-- Table structure for pxshenbao
-- ----------------------------
DROP TABLE IF EXISTS `pxshenbao`;
CREATE TABLE `pxshenbao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(150) NOT NULL COMMENT '出差项目名称',
  `organization` varchar(100) NOT NULL COMMENT '组织单位',
  `pxconent` longtext NOT NULL COMMENT '出差事项',
  `address` varchar(100) NOT NULL COMMENT '出差地点',
  `begindate` datetime NOT NULL COMMENT '开始时间',
  `enddate` datetime NOT NULL COMMENT '结束时间',
  `user_id` bigint(20) NOT NULL COMMENT '出差人',
  `txuser` varchar(200) DEFAULT NULL COMMENT '同行人',
  `budget_id` int(11) NOT NULL COMMENT '预算项目',
  `feiyong` double DEFAULT '0' COMMENT '预计花费',
  `pxfile` varchar(200) DEFAULT NULL COMMENT '邀请函',
  `audit` tinyint(4) DEFAULT '0' COMMENT '审核(0：未审核，1：已审核)',
  `ccstatus` tinyint(4) DEFAULT '0' COMMENT '出差状态，0：未结束，1：已结束',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='出差申报表';

-- ----------------------------
-- Records of pxshenbao
-- ----------------------------

-- ----------------------------
-- Table structure for traininfo
-- ----------------------------
DROP TABLE IF EXISTS `traininfo`;
CREATE TABLE `traininfo` (
  `info_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) DEFAULT '' COMMENT '培训名称',
  `content` mediumtext COMMENT '培训内容',
  `view_count` int(11) DEFAULT '0' COMMENT '浏览数',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `user_id` bigint(20) NOT NULL COMMENT '创建人',
  PRIMARY KEY (`info_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='培训信息表';

-- ----------------------------
-- Records of traininfo
-- ----------------------------
INSERT INTO `traininfo` VALUES ('1', '大数据培训', '北京出发', '0', '2019-05-31 15:44:32', '1');
INSERT INTO `traininfo` VALUES ('2', 'java培训', '上海出发', '0', '2019-05-30 16:09:46', '2');
INSERT INTO `traininfo` VALUES ('3', 'python', '武汉', '0', '2019-05-21 16:10:21', '1');
INSERT INTO `traininfo` VALUES ('4', 'a', 'a', '0', '2019-05-31 16:11:11', '1');
INSERT INTO `traininfo` VALUES ('5', 'b', 'b', '0', '2019-05-30 16:11:24', '3');
INSERT INTO `traininfo` VALUES ('6', 'c', 'c', '0', '2019-05-31 16:11:37', '4');
INSERT INTO `traininfo` VALUES ('9', 'd87679', 'd8', '0', '2019-05-31 16:12:18', '1');
INSERT INTO `traininfo` VALUES ('18', '培训', '后台', null, null, '0');
INSERT INTO `traininfo` VALUES ('19', '北京 培训', '培训内容', null, '2019-06-10 17:21:35', '0');
INSERT INTO `traininfo` VALUES ('20', '43', '234', null, '2019-06-14 15:51:44', '0');
INSERT INTO `traininfo` VALUES ('21', '2345', '56324532', null, '2019-06-14 15:51:49', '0');
INSERT INTO `traininfo` VALUES ('22', '235', '2352', null, '2019-06-14 15:51:54', '0');
INSERT INTO `traininfo` VALUES ('23', 'pi', 'uiu', null, '2019-06-14 17:06:32', '0');
INSERT INTO `traininfo` VALUES ('24', 'ppo', 'uuiu', null, '2019-06-14 17:17:59', '0');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `dept` varchar(20) DEFAULT NULL COMMENT '教研室',
  `login_name` varchar(30) NOT NULL COMMENT '登录账号',
  `user_name` varchar(30) NOT NULL COMMENT '教工姓名',
  `user_type` varchar(2) DEFAULT '00' COMMENT '用户类型（00管理员、01秘书、02院长、03老师）',
  `email` varchar(50) DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) DEFAULT '' COMMENT '手机号码',
  `sex` char(1) DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(100) DEFAULT '' COMMENT '头像路径',
  `password` varchar(50) DEFAULT '' COMMENT '密码',
  `salt` varchar(20) DEFAULT '' COMMENT '盐加密',
  `status` char(1) DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `login_ip` varchar(50) DEFAULT '' COMMENT '最后登陆IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '办公室', 'admin', '管理员', '00', 'ry@163.com', '15888888888', '1', '', '29c67a30398638269fe600f73a054934', '111111', '0', '0', '127.0.0.1', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '管理员');
INSERT INTO `user` VALUES ('2', '办公室', 'secretary', '秘书', '01', 'sec@qq.com', '15666666666', '1', '', '8e6d98b90472783cc73c17047ddccf36', '222222', '0', '0', '127.0.0.1', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '测试员');
