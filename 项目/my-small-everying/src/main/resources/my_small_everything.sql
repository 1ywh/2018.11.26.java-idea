--create database if not exists
--只需要创建表，在本地文件里面
drop table if  exists file_thing;
create table if not exists file_thing(
                                         file_name varchar(256) not null comment'文件的名称',
                                         file_path varchar(1024) not null comment'文件路径',
                                         file_depth     int      not null  comment'文件路径深度',
                                         file_type varchar(32)   not null  comment'文件类型'
)
