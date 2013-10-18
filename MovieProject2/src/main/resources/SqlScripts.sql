CREATE TABLE `movie_list` (
  `listId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `listName` varchar(45) DEFAULT NULL,
 
  PRIMARY KEY (`listId`)
) 

CREATE TABLE `movie_entry` (
  `entryId` int(11) NOT NULL AUTO_INCREMENT,
  `listId` int(11) DEFAULT NULL,
  `movieName` varchar(45) DEFAULT NULL,
  `imdbId` int(11) DEFAULT NULL,
  `dateAdded` DATETIME DEFAULT NULL,
 
  PRIMARY KEY (`entryId`)
) 


