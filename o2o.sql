-- 地区
create table tb_area (
	area_id int(5) not null auto_increment,
	area_name varchar(200) not null,
	area_desc varchar(1000) default null,
	priority int(2) not null default '0',
	create_time datetime default null,
	last_edit_time datetime default null,
	primary key (area_id),
	unique key uk_area (area_name)
) engine=InnoDB auto_increment=7 default charset=utf8;

-- 个人信息
create table tb_person_info (
	user_id int(10) not null auto_increment,
	name varchar(32) collate utf8_unicode_ci default null,
	birthday datetime default null,
	gender varchar(2) collate utf8_unicode_ci default null,
	phone varchar(32) collate utf8_unicode_ci default null,
	email varchar(128) collate utf8_unicode_ci default null,
	profile_img varchar(1024) collate utf8_unicode_ci default null,
	customer_flag int(2) not null default 0,
	shop_owner_flag int(2) not null default 0,
	admin_flag int(2) not null,
	create_time datetime default null,
	last_edit_time datetime default null,
	enable_status int(2) not null default 0,
	primary key (user_id)
) engine=InnoDB auto_increment=12 default charset=utf8 collate=utf8_unicode_ci;

-- 微信账户
create table tb_wechat_auth (
	wechat_auth_id int(10) not null auto_increment,
	user_id int(10) not null,
	open_id varchar(512) not null,
	create_time datetime default null,
	primary key (wechat_auth_id),
 	constraint fk_wechatauth_profile foreign key user_id references tb_person_info(user_id)
) engine=InnoDB auto_increment=1 default charset=utf8;

-- 本地账户
create table tb_local_auth (
	local_auth_id int(10) not null auto_increment,
	user_id int(10) not null,
	username varchar(128) not null,
	password varchar(128) not null,
	create_time datetime default null,
	last_edit_time datetime default null,
	primary key(local_auth_id),
	unique key uk_local_profile(username),
	constraint fk_localauth_profile foreign key(user_id) references tb_person_info(user_id)
) engine=InnoDB auto_increment=1 default charset=utf8;

-- 头条
create table tb_head_line (
	line_id int(100) not null auto_increment,
	line_name varchar(1000) default null,
	line_link varchar(2000) not null,
	line_img varchar(2000) not null,
	priority int(2) default null,
	enable_status int(2) not null default 0,
	create_time datetime default null,
	last_edit_time datetime default null,
	primary key (line_id)
) engine=InnoDB auto_increment=1 default charset=utf8;

-- 店铺分类
create table tb_shop_category (
	shop_category_id int(11) not null auto_increment,
	shop_category_name varchar(100) not null default '',
	shop_category_desc varchar(1000) default '',
	shop_category_img varchar(2000) default null,
	priority int(2) not null default 0,
	create_time datetime default null,
	last_edit_time datetime default null,
	parent_id int(11) default null,
	primary key (shop_category_id),
	constraint fk_shop_category_self foreign key(parent_id) references tb_shop_category(shop_category_id)
) engine=InnoDB auto_increment=1 default charset=utf8;

-- 店铺
create table tb_shop (
	shop_id int(10) not null auto_increment,
	owner_id int(10) not null comment '店铺创建人',
	area_id int(5) default null,
	shop_category_id int(11) default null,
	shop_name varchar(256) not null,
	shop_desc varchar(1024) default null,
	shop_addr varchar(200) default null,
	phone varchar(128) default null,
	shop_img varchar(1024) default null,
	priority int(3) default 0,
	create_time datetime default null,
	last_edit_time datetime default null,
	enable_status int(2) not null default 0,
	advice varchar(255) default null,
	primary key(shop_id),
	constraint fk_shop_area foreign key(area_id) references tb_area(area_id),
	constraint fk_shop_profile foreign key(owner_id) references tb_person_info(user_id),
	constraint fk_shop_shopcate foreign key(shop_category_id) references tb_shop_category(shop_category_id)
) engine=InnoDB auto_increment=1 default charset=utf8;

-- 商品分类
create table tb_product_category (
	product_category_id int(11) not null auto_increment,
	product_Category_name varchar(100) not null,
	priority int(2) default 0,
	create_time datetime default null,
	shop_id int(20) not null default 0,
	primary key(product_category_id),
	constraint fk_procate_shop foreign key(shop_id) references tb_shop(shop_id)
) engine=InnoDB auto_increment=1 default charset=utf8;


-- 商品
create table tb_product (
	product_id int(100) not null auto_increment,
	product_name varchar(100) not null,
	product_desc varchar(2000) default null,
	img_addr varchar(2000) default '',
	normal_price varchar(100) default null,
	promotion_price varchar(100) default null,
	priority int(2) not null default 0,
	create_time datetime default null,
	last_edit_time datetime default null,
	enable_status int(2) not null default 0,
	product_category_id int(11) default null,
	shop_id int(20) not null default 0,
	primary key(product_id),
	constraint fk_product_procate foreign key(product_category_id) references tb_product_category(product_category_id),
	constraint fk_product_shop foreign key(shop_id) references tb_shop(shop_id)
) engine=InnoDB auto_increment=1 default charset=utf8;


-- 商品详情图片
create table tb_product_img (
	product_img_id int(20) not null auto_increment,
	img_addr varchar(2000) not null,
	img_desc varchar(2000) default null,
	priority int(2) default 0,
	create_time datetime default null,
	product_id int(20) default null,
	primary key (product_img_id),
	constraint fk_proimg_product foreign key(product_id) references tb_product(product_id)
) engine=InnoDB auto_increment=1 default charset=utf8;
