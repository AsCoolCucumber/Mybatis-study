create table `blog` (
	`id` varchar(50) not null COMMENT '博客id',
	`title` varchar(100) not null COMMENT '博客标题',
	`author` varchar(30) not null COMMENT '博客作者',
	`create_time` datetime not null comment '创建时间',
	`views` int(30) not null COMMENT '浏览量'
)engine=innodb default charset=utf8