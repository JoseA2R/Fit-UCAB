INSERT INTO PERSON (PERSONID,PERSONUSERNAME,PERSONPASSWORD,PERSONEMAIL,PERSONSEX,PERSONPHONE) VALUES (1,'USUARIO1','PSWD1','CORREO1','SEXO1','TELEFONO1');

INSERT INTO REGISTRY (REGISTRYID,REGISTRYWEIGHT,REGISTRYHEIGHT,REGISTRYPOINT,FK_PERSONID) VALUES (1,80,'1',1,1);

INSERT INTO SPORT (SPORTID,SPORTNAME,SPORTMET) VALUES (nextval('SPORTID'),'CAMINAR',3.3);
INSERT INTO SPORT (SPORTID,SPORTNAME,SPORTMET) VALUES (nextval('SPORTID'),'TROTAR',7);
INSERT INTO SPORT (SPORTID,SPORTNAME,SPORTMET) VALUES (nextval('SPORTID'),'BICICLETA',8);
INSERT INTO SPORT (SPORTID,SPORTNAME,SPORTMET) VALUES (nextval('SPORTID'),'NATACION',8.5);
INSERT INTO SPORT (SPORTID,SPORTNAME,SPORTMET) VALUES (nextval('SPORTID'),'YOGA',2.5);
INSERT INTO SPORT (SPORTID,SPORTNAME,SPORTMET) VALUES (nextval('SPORTID'),'ESTIRAMIENTOS',2.5);
INSERT INTO SPORT (SPORTID,SPORTNAME,SPORTMET) VALUES (nextval('SPORTID'),'ELIPTICA',7);
INSERT INTO SPORT (SPORTID,SPORTNAME,SPORTMET) VALUES (nextval('SPORTID'),'ESCALERAS',9);
INSERT INTO SPORT (SPORTID,SPORTNAME,SPORTMET) VALUES (nextval('SPORTID'),'BAILAR',5);
INSERT INTO SPORT (SPORTID,SPORTNAME,SPORTMET) VALUES (nextval('SPORTID'),'AEROBIC',8.5);
INSERT INTO SPORT (SPORTID,SPORTNAME,SPORTMET) VALUES (nextval('SPORTID'),'REMO',8);
INSERT INTO SPORT (SPORTID,SPORTNAME,SPORTMET) VALUES (nextval('SPORTID'),'BASKETBALL',6);
INSERT INTO SPORT (SPORTID,SPORTNAME,SPORTMET) VALUES (nextval('SPORTID'),'FUTBOL',6.5);
INSERT INTO SPORT (SPORTID,SPORTNAME,SPORTMET) VALUES (nextval('SPORTID'),'TENIS',5);
INSERT INTO SPORT (SPORTID,SPORTNAME,SPORTMET) VALUES (nextval('SPORTID'),'VOLEIBOL',6.5);

INSERT INTO EXERCISE (EXERCISEID,FK_SPORT,FK_PERSON) VALUES (nextval('EXERCISEID'),1,1);
INSERT INTO EXERCISE (EXERCISEID,FK_SPORT,FK_PERSON) VALUES (nextval('EXERCISEID'),2,1);
INSERT INTO EXERCISE (EXERCISEID,FK_SPORT,FK_PERSON) VALUES (nextval('EXERCISEID'),3,1);

INSERT INTO ACTIVITY (ACTIVITYID,ACTIVITYSTARTTIME,ACTIVITYENDTIME,ACTIVITYDATE,ACTIVITYKM,ACTIVITYCALOR,FK_REGISTRY,FK_SPORT)
     VALUES (nextval('ACTIVITYID'),'12:00','1:00','20/05/2017',1200,50,1,1);


