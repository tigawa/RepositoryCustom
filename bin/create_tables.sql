drop table staff;
drop table shop;
drop table result;
drop table result_detail;

create table shop (
	id int,
	name varchar(100),
	primary key(id)
);
create table staff (
	id int,
	name varchar(100),
	shop_id int,
	primary key(id),
	foreign key(shop_id) references shop(id)
);
create table result (
	id int,
	type_code int,
	primary key(id)
);
create table result_detail (
	id int,
	result_id int,
	staff_id int,
	point int,
	primary key(id),
	foreign key(result_id) references result(id),
	foreign key(staff_id) references staff(id)
);

insert into shop values(1,'松江店');
insert into shop values(2,'出雲店');
insert into shop values(3,'江津店');
insert into shop values(4,'浜田店');

insert into staff values(1, '松江　一郎', 1);
insert into staff values(2, '松江　次郎', 1);
insert into staff values(3, '出雲　三郎', 2);
insert into staff values(4, '出雲　四郎', 2);
insert into staff values(5, '江津　五郎', 3);
insert into staff values(6, '江津　四郎', 3);

insert into result values(1,100);
insert into result values(2,200);
insert into result values(3,300);

insert into result_detail value(1,1,1,50);
insert into result_detail value(2,1,2,30);
insert into result_detail value(3,2,3,60);
insert into result_detail value(4,2,4,20);

