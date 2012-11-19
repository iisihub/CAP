create table PostZip
(
	ZipCode			Char(3) 	not null,
	AreaCode		Char(2) 	not null,
	City			VARCHAR(9) 	not null,
	CityArea		VARCHAR(9),
	Road			VARCHAR(37),
	Scoop			VARCHAR(54)
);

create index PostZip_Index on PostZip(
	ZipCode 
);

create index PostZip_Index2 on PostZip(
	City 
);