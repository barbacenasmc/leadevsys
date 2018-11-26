CREATE TABLE `cgtypes` (
  `cgtype_id` int(11) NOT NULL,
  `cgtype` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cgtype_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
INSERT INTO `leadevsys`.`cgtypes` (`cgtype_id`, `cgtype`) VALUES ('1', 'Youth Girls');
INSERT INTO `leadevsys`.`cgtypes` (`cgtype_id`, `cgtype`) VALUES ('2', 'Youth Boys');
INSERT INTO `leadevsys`.`cgtypes` (`cgtype_id`, `cgtype`) VALUES ('3', 'Women');
INSERT INTO `leadevsys`.`cgtypes` (`cgtype_id`, `cgtype`) VALUES ('4', 'Men');
INSERT INTO `leadevsys`.`cgtypes` (`cgtype_id`, `cgtype`) VALUES ('5', 'Senior Women');
INSERT INTO `leadevsys`.`cgtypes` (`cgtype_id`, `cgtype`) VALUES ('6', 'Senior Men');
INSERT INTO `leadevsys`.`cgtypes` (`cgtype_id`, `cgtype`) VALUES ('7', 'Kids Boys');
INSERT INTO `leadevsys`.`cgtypes` (`cgtype_id`, `cgtype`) VALUES ('8', 'Kids Girls');
