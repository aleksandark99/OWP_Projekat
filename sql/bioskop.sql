DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS movies;



CREATE TABLE users (
    username VARCHAR(30) NOT NULL, 
    password VARCHAR(30) NOT NULL, 
    role VARCHAR(5) NOT NULL DEFAULT 'USER',
    registerDate Date NOT NULL,
    PRIMARY KEY(userName)
);

CREATE TABLE movies (
id INTEGER NOT NULL,
naziv VARCHAR(30) NOT NULL,
reziser VARCHAR(30) ,
glumci VARCHAR(30) ,
zanrovi  VARCHAR(30) ,
trajanje INTEGER NOT NULL,
distributer VARCHAR(30) NOT NULL,
zemljaProekla VARCHAR(30) NOT NULL ,
godina INTEGER NOT NULL,
opis VARCHAR(30) ,
PRIMARY KEY (id)
);


insert into movies values(1,'movie1','reziser1','glumci 1','zanrovi 1',1,'distributer1','zemlja porekla 1',1,'opis1');
insert into movies values(2,'movie2','reziser2','glumci 2','zanrovi 2',2,'distributer2','zemlja porekla 2',2,'opis2');
insert into movies values(3,'movie3','reziser3','glumci 3','zanrovi 3',3,'distributer3','zemlja porekla 3',3,'opis3');
insert into movies values(4,'movie4','reziser4','glumci 4','zanrovi 4',4,'distributer4','zemlja porekla 4',4,'opis4');

select * from movies
select * from users