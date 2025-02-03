create database calendar default character set utf8 collate utf8_general_ci;

use calendar;

create table calendar (
                          id int auto_increment primary key,
                          author varchar(100) not null COMMENT '작성자',
                          todolist varchar(100) not null COMMENT '스케쥴',
                          password varchar(50) not null COMMENT '비밀번호',
                          createDate timestamp default current_timestamp,
                          updateDate timestamp default current_timestamp on update current_timestamp
);