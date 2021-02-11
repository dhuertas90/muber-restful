SET FOREIGN_KEY_CHECKS=0;

INSERT INTO `driver` VALUES ('1', '2020-01-09 09:03:43');
INSERT INTO `driver` VALUES ('2', '2021-01-09 09:03:43');
INSERT INTO `driver` VALUES ('3', '2022-01-09 09:03:43');

INSERT INTO `passenger` VALUES ('4', '6000');
INSERT INTO `passenger` VALUES ('5', '7000');
INSERT INTO `passenger` VALUES ('6', '8000');
INSERT INTO `passenger` VALUES ('7', '9000');
INSERT INTO `passenger` VALUES ('8', '10000');
INSERT INTO `passenger` VALUES ('9', '11000');
INSERT INTO `passenger` VALUES ('10', '12000');

INSERT INTO `rating` VALUES ('1', 'Genial, sin problemas', '1', '6', '1');
INSERT INTO `rating` VALUES ('2', 'Genial, sin problemas', '2', '7', '1');
INSERT INTO `rating` VALUES ('3', 'Genial, sin problemas', '3', '8', '1');
INSERT INTO `rating` VALUES ('4', 'Genial, sin problemas', '4', '9', '2');
INSERT INTO `rating` VALUES ('5', 'Genial, sin problemas', '5', '10', '2');
INSERT INTO `rating` VALUES ('6', 'Genial, sin problemas', '7', '6', '3');
INSERT INTO `rating` VALUES ('7', 'Genial, sin problemas', '8', '7', '3');
INSERT INTO `rating` VALUES ('8', 'Genial, sin problemas', '9', '8', '3');
INSERT INTO `rating` VALUES ('9', 'Genial, sin problemas', '10', '9', '4');


INSERT INTO `travel` VALUES ('1', '\0', 'La Plata', 'Capital Federal', '100', '2017-05-11 09:03:43', '4', '1');
INSERT INTO `travel` VALUES ('2', '\0', 'La Plata', 'Berisso', '200', '2017-05-11 09:03:43', '4', '1');
INSERT INTO `travel` VALUES ('3', '\0', 'La Plata', 'Ensenada', '300', '2017-05-11 09:03:43', '4', '2');
INSERT INTO `travel` VALUES ('4', '\0', 'La Plata', 'Tandil', '400', '2017-05-11 09:03:43', '4', '3');
INSERT INTO `travel` VALUES ('5', '', 'La Plata', 'Tigre', '500', '2017-05-11 09:03:43', '4', '3');


INSERT INTO `travelpassengers` VALUES ('6', '1');
INSERT INTO `travelpassengers` VALUES ('6', '3');
INSERT INTO `travelpassengers` VALUES ('7', '1');
INSERT INTO `travelpassengers` VALUES ('7', '3');
INSERT INTO `travelpassengers` VALUES ('8', '1');
INSERT INTO `travelpassengers` VALUES ('8', '3');
INSERT INTO `travelpassengers` VALUES ('9', '2');
INSERT INTO `travelpassengers` VALUES ('9', '4');
INSERT INTO `travelpassengers` VALUES ('10','2' );
INSERT INTO `travelpassengers` VALUES ('10','4' );


INSERT INTO `user` VALUES ('1', 'Conductor1', '1234', '2017-05-11 09:03:43');
INSERT INTO `user` VALUES ('2', 'Conductor2', '1234', '2017-05-11 09:03:43');
INSERT INTO `user` VALUES ('3', 'Conductor3', '1234', '2017-05-11 09:03:43');
INSERT INTO `user` VALUES ('4', 'Pasajero1', '1234', '2017-05-11 09:03:43');
INSERT INTO `user` VALUES ('5', 'Pasajero2', '1234', '2017-05-11 09:03:43');
INSERT INTO `user` VALUES ('6', 'Pasajero3', '1234', '2017-05-11 09:03:43');
INSERT INTO `user` VALUES ('7', 'Pasajero4', '1234', '2017-05-11 09:03:43');
INSERT INTO `user` VALUES ('8', 'Pasajero5', '1234', '2017-05-11 09:03:43');
INSERT INTO `user` VALUES ('9', 'Pasajero6', '1234', '2017-05-11 09:03:43');
INSERT INTO `user` VALUES ('10', 'Pasajero7', '1234', '2017-05-11 09:03:43');
