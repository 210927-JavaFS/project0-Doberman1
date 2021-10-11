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
	craftedinventoryID serial PRIMARY KEY REFERENCES users (userID),
	linenleggings integer,
	linenbonnet integer,
	linenshoes integer,
	linenhat integer,
	linenhandwraps integer,
	linenshirt integer,
	linenpants integer,
	linendress integer,
	linengloves integer,
	coarseleatherboots integer,
	coarseleathergloves integer,
	coarseleatherpants integer,
	coarseleathershirt integer,
	coarseleatherhat integer,
	irongreataxe integer,
	ironwarhammer integer,
	ironspear integer,
	ironrapier integer,
	ironhatchet integer,
	ironroundshield integer,
	ironlongsword integer,
	ironplategreaves integer,
	ironplatehelmet integer,
	ironplateboots integer,
	ironplatebreastplate integer,
	ironplategauntlets integer,
	ironmusket integer,
	treatedwoodenbow integer,
	ironskinningknife integer,
	ironloggingaxe integer,
	ironminingpickaxe integer,
	ironharvestingsickle  integer,
	treatedwoodenpole integer	
);

CREATE TABLE componentinventory(
	componentinventoryID serial PRIMARY KEY REFERENCES users (userID),
	timber integer,
	coarseleather integer,
	linen integer,
	ironingot integer,
	greenwood integer,
	ironore integer,
	rawhide integer,
	fibers integer
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

INSERT INTO craftedgoodsrequirements (goodname, timber, coarseleather, linen, ironingot, greenwood, ironore, rawhide, fibers)
	VALUES ('timber', 0, 0, 0, 0, 4, 0, 0, 0);

INSERT INTO craftedgoodsrequirements (goodname, timber, coarseleather, linen, ironingot, greenwood, ironore, rawhide, fibers)
	VALUES ('ironingot', 0, 0, 0, 0, 0, 4, 0, 0);

INSERT INTO craftedgoodsrequirements (goodname, timber, coarseleather, linen, ironingot, greenwood, ironore, rawhide, fibers)
	VALUES ('coarseleather', 0, 0, 0, 0, 0, 0, 4, 0);

INSERT INTO craftedgoodsrequirements (goodname, timber, coarseleather, linen, ironingot, greenwood, ironore, rawhide, fibers)
	VALUES ('linen', 0, 0, 0, 0, 0, 0, 0, 4);














