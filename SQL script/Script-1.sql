DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS craftedinventory;
DROP TABLE IF EXISTS componentinventory;
DROP TABLE IF EXISTS craftedgoodsrequirements;


CREATE TABLE users(
	userID serial PRIMARY KEY,
	username VARCHAR(999) UNIQUE NOT null,
	userpassword VARCHAR(999) NOT null,
	usertype Integer
);


CREATE TABLE craftedinventory(
	craftedinventoryID int PRIMARY KEY REFERENCES users (userID),
	linenleggings integer DEFAULT 0,
	linenbonnet integer DEFAULT 0,
	linenshoes integer DEFAULT 0,
	linenhat integer DEFAULT 0,
	linenhandwraps integer DEFAULT 0,
	linenshirt integer DEFAULT 0,
	linenpants integer DEFAULT 0,
	linendress integer DEFAULT 0,
	linengloves integer DEFAULT 0,
	coarseleatherboots integer DEFAULT 0,
	coarseleathergloves integer DEFAULT 0,
	coarseleatherpants integer DEFAULT 0,
	coarseleathershirt integer DEFAULT 0,
	coarseleatherhat integer DEFAULT 0,
	irongreataxe integer DEFAULT 0,
	ironwarhammer integer DEFAULT 0,
	ironspear integer DEFAULT 0,
	ironrapier integer DEFAULT 0,
	ironhatchet integer DEFAULT 0,
	ironroundshield integer DEFAULT 0,
	ironlongsword integer DEFAULT 0,
	ironplategreaves integer DEFAULT 0,
	ironplatehelmet integer DEFAULT 0,
	ironplateboots integer DEFAULT 0,
	ironplatebreastplate integer DEFAULT 0,
	ironplategauntlets integer DEFAULT 0,
	ironmusket integer DEFAULT 0,
	treatedwoodenbow integer DEFAULT 0,
	ironskinningknife integer DEFAULT 0,
	ironloggingaxe integer DEFAULT 0,
	ironminingpickaxe integer DEFAULT 0,
	ironharvestingsickle  integer DEFAULT 0,
	treatedwoodenpole integer DEFAULT 0	
);


CREATE TABLE componentinventory(
	componentinventoryID int PRIMARY KEY REFERENCES users (userID),
	timber integer DEFAULT 0,
	coarseleather integer DEFAULT 0,
	linen integer DEFAULT 0,
	ironingot integer DEFAULT 0,
	greenwood integer DEFAULT 0,
	ironore integer DEFAULT 0,
	rawhide integer DEFAULT 0,
	fibers integer DEFAULT 0
	);

CREATE TABLE craftedgoodsrequirements(
	goodname VARCHAR(50) PRIMARY KEY,
	timber integer,
	coarseleather integer,
	linen integer,
	ironingot integer,
	greenwood integer,
	ironore integer,
	rawhide integer,
	fibers integer
	
);


CREATE OR REPLACE PROCEDURE createnewuser(userrname varchar(999), userrpassword varchar(999), userrtype int)
LANGUAGE plpgsql
AS $$
BEGIN
INSERT INTO users (username, userpassword, usertype) VALUES (userrname, userrpassword, userrtype);
INSERT INTO componentinventory (componentinventoryID) VALUES ((SELECT userid FROM users WHERE username = userrname));
INSERT INTO craftedinventory (craftedinventoryID) VALUES ((SELECT userid FROM users WHERE username = userrname));
END; $$


INSERT INTO craftedgoodsrequirements (goodname, timber, coarseleather, linen, ironingot, greenwood, ironore, rawhide, fibers)
	VALUES ('linenleggings', 0, 6, 10, 2, 0, 0, 0, 0);

INSERT INTO craftedgoodsrequirements (goodname, timber, coarseleather, linen, ironingot, greenwood, ironore, rawhide, fibers)
	VALUES ('linenbonnet', 0, 6, 11, 1, 0, 0, 0, 0);

INSERT INTO craftedgoodsrequirements (goodname, timber, coarseleather, linen, ironingot, greenwood, ironore, rawhide, fibers)
	VALUES ('linenshoes', 0, 3, 5, 1, 0, 0, 0, 0);

INSERT INTO craftedgoodsrequirements (goodname, timber, coarseleather, linen, ironingot, greenwood, ironore, rawhide, fibers)
	VALUES ('linenhat', 0, 6, 11, 1, 0, 0, 0, 0);

INSERT INTO craftedgoodsrequirements (goodname, timber, coarseleather, linen, ironingot, greenwood, ironore, rawhide, fibers)
	VALUES ('linenhandwraps', 0, 4, 4, 1, 0, 0, 0, 0);

INSERT INTO craftedgoodsrequirements (goodname, timber, coarseleather, linen, ironingot, greenwood, ironore, rawhide, fibers)
	VALUES ('linenshirt', 0, 12, 22, 1, 0, 0, 0, 0);

INSERT INTO craftedgoodsrequirements (goodname, timber, coarseleather, linen, ironingot, greenwood, ironore, rawhide, fibers)
	VALUES ('linenpants', 0, 6, 10, 2, 0, 0, 0, 0);

INSERT INTO craftedgoodsrequirements (goodname, timber, coarseleather, linen, ironingot, greenwood, ironore, rawhide, fibers)
	VALUES ('linendress', 0, 12, 22, 1, 0, 0, 0, 0);

INSERT INTO craftedgoodsrequirements (goodname, timber, coarseleather, linen, ironingot, greenwood, ironore, rawhide, fibers)
	VALUES ('linengloves', 0, 4, 4, 1, 0, 0, 0, 0);

INSERT INTO craftedgoodsrequirements (goodname, timber, coarseleather, linen, ironingot, greenwood, ironore, rawhide, fibers)
	VALUES ('coarseleatherboots', 0, 5, 3, 1, 0, 0, 0, 0);

INSERT INTO craftedgoodsrequirements (goodname, timber, coarseleather, linen, ironingot, greenwood, ironore, rawhide, fibers)
	VALUES ('coarseleathergloves', 0, 4, 4, 1, 0, 0, 0, 0);

INSERT INTO craftedgoodsrequirements (goodname, timber, coarseleather, linen, ironingot, greenwood, ironore, rawhide, fibers)
	VALUES ('coarseleatherpants', 0, 10, 6, 2, 0, 0, 0, 0);

INSERT INTO craftedgoodsrequirements (goodname, timber, coarseleather, linen, ironingot, greenwood, ironore, rawhide, fibers)
	VALUES ('coarseleathershirt', 0, 22, 12, 1, 0, 0, 0, 0);

INSERT INTO craftedgoodsrequirements (goodname, timber, coarseleather, linen, ironingot, greenwood, ironore, rawhide, fibers)
	VALUES ('coarseleatherhat', 0, 11, 6, 1, 0, 0, 0, 0);

INSERT INTO craftedgoodsrequirements (goodname, timber, coarseleather, linen, ironingot, greenwood, ironore, rawhide, fibers)
	VALUES ('irongreataxe', 3, 2, 0, 12, 0, 0, 0, 0);

INSERT INTO craftedgoodsrequirements (goodname, timber, coarseleather, linen, ironingot, greenwood, ironore, rawhide, fibers)
	VALUES ('ironwarhammer', 3, 2, 0, 12, 0, 0, 0, 0);

INSERT INTO craftedgoodsrequirements (goodname, timber, coarseleather, linen, ironingot, greenwood, ironore, rawhide, fibers)
	VALUES ('ironspear', 10, 2, 0, 5, 0, 0, 0, 0);

INSERT INTO craftedgoodsrequirements (goodname, timber, coarseleather, linen, ironingot, greenwood, ironore, rawhide, fibers)
	VALUES ('ironrapier', 2, 1, 0, 7, 0, 0, 0, 0);

INSERT INTO craftedgoodsrequirements (goodname, timber, coarseleather, linen, ironingot, greenwood, ironore, rawhide, fibers)
	VALUES ('ironhatchet', 2, 1, 0, 7, 0, 0, 0, 0);

INSERT INTO craftedgoodsrequirements (goodname, timber, coarseleather, linen, ironingot, greenwood, ironore, rawhide, fibers)
	VALUES ('ironroundshield', 2, 1, 0, 7, 0, 0, 0, 0);

INSERT INTO craftedgoodsrequirements (goodname, timber, coarseleather, linen, ironingot, greenwood, ironore, rawhide, fibers)
	VALUES ('ironlongsword', 2, 1, 0, 7, 0, 0, 0, 0);

INSERT INTO craftedgoodsrequirements (goodname, timber, coarseleather, linen, ironingot, greenwood, ironore, rawhide, fibers)
	VALUES ('ironplategreaves', 0, 6, 2, 10, 0, 0, 0, 0);

INSERT INTO craftedgoodsrequirements (goodname, timber, coarseleather, linen, ironingot, greenwood, ironore, rawhide, fibers)
	VALUES ('ironplatehelmet', 0, 6, 4, 8, 0, 0, 0, 0);

INSERT INTO craftedgoodsrequirements (goodname, timber, coarseleather, linen, ironingot, greenwood, ironore, rawhide, fibers)
	VALUES ('ironplateboots', 0, 3, 1, 5, 0, 0, 0, 0);

INSERT INTO craftedgoodsrequirements (goodname, timber, coarseleather, linen, ironingot, greenwood, ironore, rawhide, fibers)
	VALUES ('ironplatebreastplate', 0, 12, 7, 16, 0, 0, 0, 0);

INSERT INTO craftedgoodsrequirements (goodname, timber, coarseleather, linen, ironingot, greenwood, ironore, rawhide, fibers)
	VALUES ('ironplategauntlets', 0, 4, 1, 4, 0, 0, 0, 0);

INSERT INTO craftedgoodsrequirements (goodname, timber, coarseleather, linen, ironingot, greenwood, ironore, rawhide, fibers)
	VALUES ('ironmusket', 3, 2, 0, 12, 0, 0, 0, 0);

INSERT INTO craftedgoodsrequirements (goodname, timber, coarseleather, linen, ironingot, greenwood, ironore, rawhide, fibers)
	VALUES ('treatedwoodenbow', 12, 3, 2, 0, 0, 0, 0, 0);

INSERT INTO craftedgoodsrequirements (goodname, timber, coarseleather, linen, ironingot, greenwood, ironore, rawhide, fibers)
	VALUES ('ironskinningknife', 2, 1, 0, 7, 0, 0, 0, 0);

INSERT INTO craftedgoodsrequirements (goodname, timber, coarseleather, linen, ironingot, greenwood, ironore, rawhide, fibers)
	VALUES ('ironloggingaxe', 3, 2, 0, 12, 0, 0, 0, 0);

INSERT INTO craftedgoodsrequirements (goodname, timber, coarseleather, linen, ironingot, greenwood, ironore, rawhide, fibers)
	VALUES ('ironminingpickaxe', 3, 2, 0, 12, 0, 0, 0, 0);

INSERT INTO craftedgoodsrequirements (goodname, timber, coarseleather, linen, ironingot, greenwood, ironore, rawhide, fibers)
	VALUES ('ironharvestingsickle', 2, 1, 0, 7, 0, 0, 0, 0);

INSERT INTO craftedgoodsrequirements (goodname, timber, coarseleather, linen, ironingot, greenwood, ironore, rawhide, fibers)
	VALUES ('treatedwoodenpole', 12, 3, 2, 0, 0, 0, 0, 0);

--SELECT userID FROM users WHERE username = 'billybob';
--UPDATE componentinventory SET timber = 5, linen = 5 WHERE componentinventoryID = (SELECT userID FROM users WHERE username = 'bob');
--UPDATE componentinventory SET timber = 777 WHERE componentinventoryID = (SELECT userID FROM users WHERE username = 'jermy');


--UPDATE craftedgoodsrequirements SET timber = 1, coarseleather = 2, linen = 3, ironingot =  4, greenwood = 5, ironore =6 , rawhide=7, fibers=8 
--WHERE goodname = 'linenleggings';
--UPDATE users SET usertype = 1 WHERE username = ?;

--INSERT INTO users (username, userpassword) VALUES ('asdas', 'asfasd');
--INSERT INTO users (username, userpassword) VALUES ('asdsffsds', 'assdafsaffasd');
--INSERT INTO craftedinventory (ironwarhammer) VALUES (0);

--INSERT INTO craftedgoodsrequirements (goodname, timber, coarseleather, linen, ironingot, greenwood, ironore, rawhide, fibers)
	--VALUES ('timber', 0, 0, 0, 0, 4, 0, 0, 0);

--INSERT INTO craftedgoodsrequirements (goodname, timber, coarseleather, linen, ironingot, greenwood, ironore, rawhide, fibers)
	--VALUES ('ironingot', 0, 0, 0, 0, 0, 4, 0, 0);

--INSERT INTO craftedgoodsrequirements (goodname, timber, coarseleather, linen, ironingot, greenwood, ironore, rawhide, fibers)
--	VALUES ('coarseleather', 0, 0, 0, 0, 0, 0, 4, 0);

--INSERT INTO craftedgoodsrequirements (goodname, timber, coarseleather, linen, ironingot, greenwood, ironore, rawhide, fibers)
--	VALUES ('linen', 0, 0, 0, 0, 0, 0, 0, 4);


--INSERT INTO componentinventory (timber,
--	coarseleather,
--	linen,
--	ironingot,
--	greenwood,
--	ironore,
--	rawhide,
	--fibers) VALUES (50, 50, 50, 50, 50, 50, 50, 50);

--UPDATE componentinventory SET (timber, coarseleather, linen, ironingot, greenwood, ironore, rawhide,
--	fibers) = ((SELECT timber, coarseleather, linen, ironingot, greenwood, ironore, rawhide,
--	fibers FROM componentinventory WHERE 
--	componentinventoryID = 1) - (SELECT timber, coarseleather, linen, ironingot, greenwood, ironore, rawhide,
--	fibers FROM craftedgoodsrequirements WHERE goodname = 'ironplatebreastplate'))
--	WHERE componentinventoryID = 1;

--UPDATE componentinventory
--SET timber = (cgr.timber- (SELECT timber 









