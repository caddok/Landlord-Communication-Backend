CREATE SCHEMA `landlordcommunicationdb` ;

CREATE TABLE `landlordcommunicationdb`.`users` (
  `userId` INT NOT NULL AUTO_INCREMENT,
  `picture` LONGTEXT NULL,
  `islandlord` TINYINT NOT NULL DEFAULT 0,
  `username` VARCHAR(45) NOT NULL,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `isonline` TINYINT NOT NULL DEFAULT 0,
  `passwordhash` TINYTEXT NULL,
  `passwordsalt` TINYTEXT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

CREATE TABLE `landlordcommunicationdb`.`ratings` (
  `ratingId` INT NOT NULL AUTO_INCREMENT,
  `rating` DECIMAL(2,1) NOT NULL,
  `voteFrom` INT NOT NULL,
  `voteFor` INT NOT NULL,
  PRIMARY KEY (`ratingId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


CREATE TABLE `landlordcommunicationdb`.`places` (
  `placeId` INT NOT NULL AUTO_INCREMENT,
  `landlordId` INT NOT NULL,
  `tenantId` INT NULL DEFAULT 0,
  `address` VARCHAR(55) NOT NULL,
  `description` MEDIUMTEXT NOT NULL,
  PRIMARY KEY (`placeId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

CREATE TABLE `landlordcommunicationdb`.`cards` (
  `cardId` INT NOT NULL AUTO_INCREMENT,
  `brand` VARCHAR(45) NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  `cardnumber` VARCHAR(16) NOT NULL,
  `cvvnumber` VARCHAR(3) NOT NULL,
  `userId` INT NOT NULL,
  `balance` DECIMAL(9,2) NOT NULL,
  PRIMARY KEY (`cardId`),
  UNIQUE INDEX `cardnumber_UNIQUE` (`cardnumber` ASC),
  UNIQUE INDEX `cvvnumber_UNIQUE` (`cvvnumber` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


CREATE TABLE `landlordcommunicationdb`.`payments` (
  `paymentId` INT NOT NULL AUTO_INCREMENT,
  `userId` INT NOT NULL,
  `cardId` INT NOT NULL,
  `rentId` INT NOT NULL,
  `placeId` INT NOT NULL,
  `amount` DECIMAL(7,2) NOT NULL,
  `date` VARCHAR(11) NOT NULL,
  PRIMARY KEY (`paymentId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


CREATE TABLE `landlordcommunicationdb`.`rents` (
  `rentId` INT NOT NULL AUTO_INCREMENT,
  `totalamount` DECIMAL(7,2) NOT NULL,
  `remaining` DECIMAL(7,2) NOT NULL,
  `placeId` INT NOT NULL,
  `ispaid` TINYINT NOT NULL DEFAULT 0,
  `duedate` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`rentId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


CREATE TABLE `landlordcommunicationdb`.`chatsessions` (
  `chatsessionId` INT NOT NULL AUTO_INCREMENT,
  `landlordId` INT NOT NULL,
  `tenantId` INT NOT NULL,
  `createdate` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`chatsessionId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


CREATE TABLE `landlordcommunicationdb`.`messages` (
  `messageId` INT NOT NULL AUTO_INCREMENT,
  `senderId` INT NOT NULL,
  `receiverId` INT NOT NULL,
  `timestamp` VARCHAR(45) NOT NULL,
  `text` VARCHAR(100) NOT NULL,
  `chatsessionId` INT NOT NULL,
  PRIMARY KEY (`messageId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


ALTER TABLE `landlordcommunicationdb`.`cards` 
ADD CONSTRAINT `FK_Card_User`
  FOREIGN KEY (`userId`)
  REFERENCES `landlordcommunicationdb`.`users` (`userId`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;  
  


ALTER TABLE `landlordcommunicationdb`.`payments` 
ADD INDEX `FK_Payment_User_idx` (`userId` ASC) ,
ADD INDEX `FK_Payment_Card_idx` (`cardId` ASC) ,
ADD INDEX `FK_Payment_Rent_idx` (`rentId` ASC) ,
ADD INDEX `FK_Payment_Place_idx` (`placeId` ASC) ;
;
ALTER TABLE `landlordcommunicationdb`.`payments` 
ADD CONSTRAINT `FK_Payment_User`
  FOREIGN KEY (`userId`)
  REFERENCES `landlordcommunicationdb`.`users` (`userId`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `FK_Payment_Card`
  FOREIGN KEY (`cardId`)
  REFERENCES `landlordcommunicationdb`.`cards` (`cardId`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `FK_Payment_Place`
  FOREIGN KEY (`placeId`)
  REFERENCES `landlordcommunicationdb`.`places` (`placeId`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `FK_Payment_Rent`
  FOREIGN KEY (`rentId`)
  REFERENCES `landlordcommunicationdb`.`rents` (`rentId`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

ALTER TABLE `landlordcommunicationdb`.`ratings` 
ADD INDEX `FK_VoteFor_Users_idx` (`voteFor` ASC) ,
ADD INDEX `FK_VoteFrom_Users_idx` (`voteFrom` ASC) ;
;
ALTER TABLE `landlordcommunicationdb`.`ratings` 
ADD CONSTRAINT `FK_VoteFor_Users`
  FOREIGN KEY (`voteFor`)
  REFERENCES `landlordcommunicationdb`.`users` (`userId`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `FK_VoteFrom_Users`
  FOREIGN KEY (`voteFrom`)
  REFERENCES `landlordcommunicationdb`.`users` (`userId`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;  

  
  
ALTER TABLE `landlordcommunicationdb`.`rents` 
ADD INDEX `FK_Rent_Place_idx` (`placeId` ASC) ;
;
ALTER TABLE `landlordcommunicationdb`.`rents` 
ADD CONSTRAINT `FK_Rent_Place`
  FOREIGN KEY (`placeId`)
  REFERENCES `landlordcommunicationdb`.`places` (`placeId`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
  
  
ALTER TABLE `landlordcommunicationdb`.`chatsessions` 
ADD INDEX `FK_ChatTenant_User_idx` (`tenantId` ASC) ,
ADD INDEX `FK_ChatLandlord_User_idx` (`landlordId` ASC);

ALTER TABLE `landlordcommunicationdb`.`chatsessions` ADD CONSTRAINT `FK_ChatTenant_User`
  FOREIGN KEY (`tenantId`)
  REFERENCES `landlordcommunicationdb`.`users` (`userId`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `FK_ChatLandlord_User`
  FOREIGN KEY (`landlordId`)
  REFERENCES `landlordcommunicationdb`.`users` (`userId`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
  
  
ALTER TABLE `landlordcommunicationdb`.`places` 
ADD INDEX `FK_PlaceLandlord_User_idx` (`landlordId` ASC);

ALTER TABLE `landlordcommunicationdb`.`places` 
ADD CONSTRAINT `FK_PlaceLandlord_User`
  FOREIGN KEY (`landlordId`)
  REFERENCES `landlordcommunicationdb`.`users` (`userId`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
  
ALTER TABLE `landlordcommunicationdb`.`messages` 
ADD INDEX `FK_Sender_Users_idx` (`senderId` ASC) ,
ADD INDEX `FK_Receiver_Users_idx` (`receiverId` ASC),
ADD INDEX `FK_Chat_ChatSession_idx` (`chatsessionId` ASC);

ALTER TABLE `landlordcommunicationdb`.`messages` 
ADD CONSTRAINT `FK_Chat_ChatSession`
  FOREIGN KEY (`chatsessionId`)
  REFERENCES `landlordcommunicationdb`.`chatsessions` (`chatsessionId`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `FK_Receiver_Users`
  FOREIGN KEY (`receiverId`)
  REFERENCES `landlordcommunicationdb`.`users` (`userId`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
ADD CONSTRAINT `FK_Sender_Users`
  FOREIGN KEY (`senderId`)
  REFERENCES `landlordcommunicationdb`.`users` (`userId`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;  
  