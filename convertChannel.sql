
/*创建high与low两个用户，并创建数据库pay*/
create user high identified by 123456789;
create user low identified by 123456789;
create schema pay authorization sysdba;

/*新建员工表*/
create table "PAY"."employee"
(
	"id" INTEGER not null ,
	"name" VARCHAR(50) not null ,
	"date" DATE,
	"sex" CHAR(10),
	"nativeplace" VARCHAR(50),
	"eduback" CHAR(10),
	primary key("id")
)
storage(initial 1, next 1, minextents 1, fillfactor 0)
;

comment on table "PAY"."employee" is '员工表';

comment on column "PAY"."employee"."id" is '员工编号';

comment on column "PAY"."employee"."name" is '姓名';

comment on column "PAY"."employee"."date" is '出生日期';

comment on column "PAY"."employee"."sex" is '性别';

comment on column "PAY"."employee"."nativeplace" is '籍贯';

comment on column "PAY"."employee"."eduback" is '学历';

/*新建工资表*/
create table "PAY"."payroll"
(
	"id" INTEGER,
	"year" INTEGER,
	"month" TINYINT,
	"salary" DOUBLE(53)
)
storage(initial 1, next 1, minextents 1, fillfactor 0)
;

comment on table "PAY"."payroll" is '工资单';

comment on column "PAY"."payroll"."id" is '员工编号';

comment on column "PAY"."payroll"."year" is '年份';

comment on column "PAY"."payroll"."month" is '月份';

comment on column "PAY"."payroll"."salary" is '工资实发数';

alter table "PAY"."payroll" add constraint foreign key("id") references "PAY"."employee"("id") on update cascade;




/*授权high与low用户在员工基本表和工资表的所有权限*/
grant SELECT on "PAY"."employee" to "HIGH";

grant INSERT on "PAY"."employee" to "HIGH";

grant DELETE on "PAY"."employee" to "HIGH";

grant UPDATE on "PAY"."employee" to "HIGH";

grant REFERENCES on "PAY"."employee" to "HIGH";

grant SELECT FOR DUMP on "PAY"."employee" to "HIGH";

grant SELECT on "PAY"."payroll" to "HIGH";

grant INSERT on "PAY"."payroll" to "HIGH";

grant DELETE on "PAY"."payroll" to "HIGH";

grant UPDATE on "PAY"."payroll" to "HIGH";

grant REFERENCES on "PAY"."payroll" to "HIGH";

grant SELECT FOR DUMP on "PAY"."payroll" to "HIGH";

grant SELECT on "PAY"."payroll" to "LOW";

grant INSERT on "PAY"."payroll" to "LOW";

grant DELETE on "PAY"."payroll" to "LOW";

grant UPDATE on "PAY"."payroll" to "LOW";

grant REFERENCES on "PAY"."payroll" to "LOW";

grant SELECT FOR DUMP on "PAY"."payroll" to "LOW";

grant SELECT on "PAY"."employee" to "LOW";

grant INSERT on "PAY"."employee" to "LOW";

grant DELETE on "PAY"."employee" to "LOW";

grant UPDATE on "PAY"."employee" to "LOW";

grant REFERENCES on "PAY"."employee" to "LOW";