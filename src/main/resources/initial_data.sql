SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Records of driver
-- ----------------------------
INSERT INTO `driver` VALUES ('1', '2020-01-09 09:03:43');

-- ----------------------------
-- Records of passenger
-- ----------------------------
INSERT INTO `passenger` VALUES ('2', '1200');
INSERT INTO `passenger` VALUES ('3', '1200');
INSERT INTO `passenger` VALUES ('4', '1200');

-- ----------------------------
-- Records of rating
-- ----------------------------
INSERT INTO `rating` VALUES ('1', 'Genial, sin problemas', '4', '3', '1');
INSERT INTO `rating` VALUES ('2', 'Impecable conductor', '5', '4', '1');
INSERT INTO `rating` VALUES ('3', 'Buen conductor', '4', '2', '1');

-- ----------------------------
-- Records of travel
-- ----------------------------
INSERT INTO `travel` VALUES ('1', '\0', 'La Plata', 'Tres Arroyos', '900', '2017-05-11 09:03:43', '4', '1');

-- ----------------------------
-- Records of travelpassengers
-- ----------------------------
INSERT INTO `travelpassengers` VALUES ('2', '1');
INSERT INTO `travelpassengers` VALUES ('3', '1');
INSERT INTO `travelpassengers` VALUES ('4', '1');

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'Roberto', '1234', '2017-05-11 09:03:43');
INSERT INTO `user` VALUES ('2', 'Alicia', '1234', '2017-05-11 09:03:43');
INSERT INTO `user` VALUES ('3', 'Margarita', '1234', '2017-05-11 09:03:43');
INSERT INTO `user` VALUES ('4', 'German', '1234', '2017-05-11 09:03:43');
