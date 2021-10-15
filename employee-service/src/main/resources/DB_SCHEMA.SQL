#DEPARTMENT
 CREATE TABLE `department` (
  `id` int NOT NULL,
  `dept_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
#EMPLOYEE
CREATE TABLE `employee` (
  `ID` int NOT NULL,
  `NAME` varchar(20) DEFAULT NULL,
  `dept` int DEFAULT NULL,
  `salary` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_dept` (`dept`),
  CONSTRAINT `fk_dept` FOREIGN KEY (`dept`) REFERENCES `department` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

