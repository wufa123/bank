
create table account(
	account_id varchar(50) not null,
	password char(6) not null,
	remaining decimal(7,2) not null,
	primary key (account_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table trade(
	id int not null AUTO_INCREMENT,
	account_id varchar(50) not null,
	trade_type varchar(10) null,
	trade_money decimal(7,2) not null,
	trade_time datetime not null,
	trade_digest varchar(1024) null,
	primary key(id),
	key(account_id),
	constraint trade_account_id foreign key(account_id) references account(account_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into account values('10010008009','123123',20000),('10010009009','123456',300);