CREATE TABLE `landlordcommunicationdb`.`users` (
  `userId` INT NOT NULL AUTO_INCREMENT,
  `picture` BLOB NULL,
  `islandlord` TINYINT NOT NULL DEFAULT 0,
  `username` VARCHAR(45) NOT NULL,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `isonline` TINYINT NOT NULL DEFAULT 0,
  `raiting` DECIMAL(2,1) NOT NULL DEFAULT 1.0,
  `passwordhash` TINYTEXT NOT NULL,
  `passwordsalt` TINYTEXT NOT NULL,
  `votes` INT NOT NULL DEFAULT 0,
  `votesum` DECIMAL(5,1) NOT NULL DEFAULT 0.0,
  PRIMARY KEY (`userId`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

CREATE TABLE `landlordcommunicationdb`.`places` (
  `placeId` INT NOT NULL AUTO_INCREMENT,
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
  `cvvnumber` INT NOT NULL,
  `userId` INT NOT NULL,
  `balance` DECIMAL(9,2) NOT NULL,
  PRIMARY KEY (`cardId`),
  UNIQUE INDEX `cardnumber_UNIQUE` (`cardnumber` ASC),
  UNIQUE INDEX `cvvnumber_UNIQUE` (`cvvnumber` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

CREATE TABLE `landlordcommunicationdb`.`usersplaces` (
  `userId` INT NOT NULL,
  `placeId` INT NOT NULL,
  PRIMARY KEY (`userId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


CREATE TABLE `landlordcommunicationdb`.`reports` (
  `reportId` INT NOT NULL AUTO_INCREMENT,
  `placeId` INT NOT NULL,
  `issue` VARCHAR(35) NOT NULL,
  `picture` BLOB NULL,
  `date` DATE NOT NULL,
  `description` TINYTEXT NOT NULL,
  `isresolved` TINYINT NOT NULL DEFAULT 0,
  `userId` INT NOT NULL,
  PRIMARY KEY (`reportId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


CREATE TABLE `landlordcommunicationdb`.`payments` (
  `paymentId` INT NOT NULL AUTO_INCREMENT,
  `userId` INT NOT NULL,
  `cardId` INT NOT NULL,
  `placeId` INT NOT NULL,
  `rentId` INT NOT NULL,
  `amount` DECIMAL(7,2) NOT NULL,
  `date` DATE NOT NULL,
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
  `duedate` DATE NOT NULL,
  PRIMARY KEY (`rentId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


CREATE TABLE `landlordcommunicationdb`.`chatsessions` (
  `chatsessionId` INT NOT NULL AUTO_INCREMENT,
  `createdate` DATE NOT NULL,
  PRIMARY KEY (`chatsessionId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


CREATE TABLE `landlordcommunicationdb`.`messages` (
  `messageId` INT NOT NULL AUTO_INCREMENT,
  `senderId` INT NOT NULL,
  `recieverId` INT NOT NULL,
  `timestamp` DATE NOT NULL,
  `text` MEDIUMTEXT NOT NULL,
  `chatsessionId` INT NOT NULL,
  `picture` BLOB NULL,
  `status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`messageId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

CREATE TABLE `landlordcommunicationdb`.`chatsessionsusers` (
  `chatsessionId` INT NOT NULL,
  `userId` INT NOT NULL,
  PRIMARY KEY (`chatsessionId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


ALTER TABLE `landlordcommunicationdb`.`cards` 
ADD CONSTRAINT `FK_Card_User`
  FOREIGN KEY (`userId`)
  REFERENCES `landlordcommunicationdb`.`users` (`userId`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
  
ALTER TABLE `landlordcommunicationdb`.`chatsessionsusers` 
DROP PRIMARY KEY,
ADD PRIMARY KEY (`chatsessionId`, `userId`);
;
ALTER TABLE `landlordcommunicationdb`.`chatsessionsusers` 
ADD CONSTRAINT `FK_Chatsession_User`
  FOREIGN KEY (`userId`)
  REFERENCES `landlordcommunicationdb`.`users` (`userId`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `FK_User_Chatsession`
  FOREIGN KEY (`chatsessionId`)
  REFERENCES `landlordcommunicationdb`.`chatsessions` (`chatsessionId`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;  
  

ALTER TABLE `landlordcommunicationdb`.`messages` 
ADD INDEX `FK_Message_User_idx` (`senderId` ASC) ,
ADD INDEX `FK_Message_User_idx1` (`recieverId` ASC) ,
ADD INDEX `FK_Message_Chatsession_idx` (`chatsessionId` ASC) ;
;
ALTER TABLE `landlordcommunicationdb`.`messages` 
ADD CONSTRAINT `FK_Sender_User`
  FOREIGN KEY (`senderId`)
  REFERENCES `landlordcommunicationdb`.`users` (`userId`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `FK_Reciever_User`
  FOREIGN KEY (`recieverId`)
  REFERENCES `landlordcommunicationdb`.`users` (`userId`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,  
ADD CONSTRAINT `FK_Message_Chatsession`
  FOREIGN KEY (`chatsessionId`)
  REFERENCES `landlordcommunicationdb`.`chatsessions` (`chatsessionId`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
  


ALTER TABLE `landlordcommunicationdb`.`payments` 
ADD INDEX `FK_Payment_User_idx` (`userId` ASC) ,
ADD INDEX `FK_Payment_Card_idx` (`cardId` ASC) ,
ADD INDEX `FK_Payment_Place_idx` (`placeId` ASC) ,
ADD INDEX `FK_Payment_Rent_idx` (`rentId` ASC) ;
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

  
  
ALTER TABLE `landlordcommunicationdb`.`rents` 
ADD INDEX `FK_Rent_Place_idx` (`placeId` ASC) ;
;
ALTER TABLE `landlordcommunicationdb`.`rents` 
ADD CONSTRAINT `FK_Rent_Place`
  FOREIGN KEY (`placeId`)
  REFERENCES `landlordcommunicationdb`.`places` (`placeId`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
  
  
ALTER TABLE `landlordcommunicationdb`.`reports` 
ADD INDEX `FK_Report_Place_idx` (`placeId` ASC) ,
ADD INDEX `FK_Report_User_idx` (`userId` ASC) ;
;
ALTER TABLE `landlordcommunicationdb`.`reports` 
ADD CONSTRAINT `FK_Report_Place`
  FOREIGN KEY (`placeId`)
  REFERENCES `landlordcommunicationdb`.`places` (`placeId`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `FK_Report_User`
  FOREIGN KEY (`userId`)
  REFERENCES `landlordcommunicationdb`.`users` (`userId`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
  
  
  
ALTER TABLE `landlordcommunicationdb`.`usersplaces` 
DROP PRIMARY KEY,
ADD PRIMARY KEY (`userId`, `placeId`),
ADD INDEX `FK_User_Place_idx` (`placeId` ASC) ;
;
ALTER TABLE `landlordcommunicationdb`.`usersplaces` 
ADD CONSTRAINT `FK_User_Place`
  FOREIGN KEY (`placeId`)
  REFERENCES `landlordcommunicationdb`.`places` (`placeId`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `FK_Place_User`
  FOREIGN KEY (`userId`)
  REFERENCES `landlordcommunicationdb`.`users` (`userId`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;  