
CREATE TABLE IF NOT EXISTS "testme"."definition"
(
  id					integer ,
  name   				VARCHAR(63) NOT NULL,
  applicableattributes TEXT ARRAY,
  scope   				VARCHAR(16) NOT NULL,
  scopeid  			    VARCHAR(16) NOT NULL,
  active  				BOOLEAN 	NOT NULL DEFAULT TRUE,
  applications 			TEXT ARRAY,
  defaultsort 			integer			NOT NULL DEFAULT 1,
  PRIMARY KEY(id, scopeid)
)  PARTITION BY LIST (scopeid) ;

CREATE TABLE "testme"."tenantonedefinition" PARTITION OF "testme"."definition" FOR VALUES IN ('tenantone');
 CREATE TABLE "testme"."tenanttwodefinition" PARTITION OF "testme"."definition" FOR VALUES IN ('tenanttwo');
 CREATE TABLE "testme"."tenantthreedefinition" PARTITION OF "testme"."definition" FOR VALUES IN ('tenantthree');
 CREATE TABLE "testme"."tenantglobaldefinition" PARTITION OF "testme"."definition" FOR VALUES IN ('tenantglobal');


INSERT INTO "testme".definition(id, name, scope, scopeid)	 VALUES (1, 'cars1', 'Tenant', 'tenantone');
INSERT INTO "testme".definition(id, name, scope, scopeid)	 VALUES (2, 'cars2', 'Tenant', 'tenantone');
INSERT INTO "testme".definition(id, name, scope, scopeid)	 VALUES (3, 'cars3', 'Tenant', 'tenantone');
INSERT INTO "testme".definition(id, name, scope, scopeid)	 VALUES (4, 'cars4', 'Tenant', 'tenantone');
INSERT INTO "testme".definition(id, name, scope, scopeid)	 VALUES (5, 'cars5', 'Tenant', 'tenantone');

INSERT INTO "testme".definition(id, name, scope, scopeid)	 VALUES (6, 'cars6', 'Tenant', 'tenanttwo');
INSERT INTO "testme".definition(id, name, scope, scopeid)	 VALUES (7, 'cars7', 'Tenant', 'tenanttwo');
INSERT INTO "testme".definition(id, name, scope, scopeid)	 VALUES (8, 'cars8', 'Tenant', 'tenanttwo');
INSERT INTO "testme".definition(id, name, scope, scopeid)	 VALUES (9, 'cars9', 'Tenant', 'tenanttwo');
INSERT INTO "testme".definition(id, name, scope, scopeid)	 VALUES (10, 'cars10', 'Tenant', 'tenanttwo');



CREATE TABLE IF NOT EXISTS "testme"."values"
(
  id					integer ,
  picklistid			integer   	,
  value					TEXT 	NOT NULL,
  displayorder   		integer,
  scopeid  			    VARCHAR(16) ,
  active  				BOOLEAN 	NOT NULL DEFAULT TRUE,
  PRIMARY KEY( id,scopeid ),
  FOREIGN KEY (picklistid,scopeid) REFERENCES "testme"."definition"(id,scopeid)
	 
)  PARTITION BY LIST (scopeid) ;


 CREATE TABLE "testme"."tenantonevalues" PARTITION OF "testme"."values"  FOR VALUES IN ('tenantone');
 CREATE TABLE "testme"."tenanttwovalues" PARTITION OF "testme"."values" FOR VALUES IN ('tenanttwo');
 CREATE TABLE "testme"."tenantthreevalues" PARTITION OF "testme"."values" FOR VALUES IN ('tenantthree');
 CREATE TABLE "testme"."tenantglobalvalues" PARTITION OF "testme"."values" FOR VALUES IN ('tenantglobal');


INSERT INTO "testme".values( id, picklistid, value,  scopeid)  VALUES (1,1, 'BMW - 1','tenantone');
INSERT INTO "testme".values( id, picklistid, value,  scopeid)  VALUES (2,1, 'BMW - 2','tenantone');
INSERT INTO "testme".values( id, picklistid, value,  scopeid)  VALUES (3,1, 'BMW - 3','tenantone');
INSERT INTO "testme".values( id, picklistid, value,  scopeid)  VALUES (4,1, 'BMW - 4','tenantone');
INSERT INTO "testme".values( id, picklistid, value,  scopeid)  VALUES (5,1, 'BMW - 5','tenantone');
INSERT INTO "testme".values( id, picklistid, value,  scopeid)  VALUES (6,1, 'BMW - 6','tenantone');
INSERT INTO "testme".values( id, picklistid, value,  scopeid)  VALUES (7,1, 'BMW - 7','tenantone');
INSERT INTO "testme".values( id, picklistid, value,  scopeid)  VALUES (8,1, 'BMW - 8','tenantone');
INSERT INTO "testme".values( id, picklistid, value,  scopeid)  VALUES (9,1, 'BMW - 9','tenantone');
INSERT INTO "testme".values( id, picklistid, value,  scopeid)  VALUES (10,1, 'BMW - 10','tenantone');


INSERT INTO "testme".values( id, picklistid, value,  scopeid)  VALUES (1,6, 'BMW - 1','tenanttwo');
INSERT INTO "testme".values( id, picklistid, value,  scopeid)  VALUES (2,6, 'BMW - 2','tenanttwo');
INSERT INTO "testme".values( id, picklistid, value,  scopeid)  VALUES (3,6, 'BMW - 3','tenanttwo');
INSERT INTO "testme".values( id, picklistid, value,  scopeid)  VALUES (4,6, 'BMW - 4','tenanttwo');
INSERT INTO "testme".values( id, picklistid, value,  scopeid)  VALUES (5,6, 'BMW - 5','tenanttwo');
INSERT INTO "testme".values( id, picklistid, value,  scopeid)  VALUES (6,6, 'BMW - 6','tenanttwo');
INSERT INTO "testme".values( id, picklistid, value,  scopeid)  VALUES (7,6, 'BMW - 7','tenanttwo');
INSERT INTO "testme".values( id, picklistid, value,  scopeid)  VALUES (8,6, 'BMW - 8','tenanttwo');
INSERT INTO "testme".values( id, picklistid, value,  scopeid)  VALUES (9,6, 'BMW - 9','tenanttwo');
INSERT INTO "testme".values( id, picklistid, value,  scopeid)  VALUES (10,6, 'BMW - 10','tenanttwo');