
insert into BAH_JOB(jobId,jobDesc,jobResource,updater,updateTime) values('messageJob','讀檔測試','classpath:batch/jobs/message-job.xml','tester',current timestamp);
insert into BAH_JOB(jobId,jobDesc,jobResource,updater,updateTime) values('postZipImportJob','郵遞區號匯入','classpath:batch/jobs/postZipImport-job.xml','tester',current timestamp);

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
