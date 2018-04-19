/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/4/17 15:28:26                           */
/*==============================================================*/


drop table if exists eventattr;

drop table if exists eventform;

drop table if exists eventobject;

drop table if exists eventpos;

drop table if exists eventrelation;

drop table if exists fieldtype;

drop table if exists formdatatype;

drop table if exists hierarchy;

drop table if exists master;

drop table if exists relationtype;

drop table if exists role;

drop table if exists travel;

drop table if exists user;

drop table if exists userlink;

/*==============================================================*/
/* Table: eventattr                                             */
/*==============================================================*/
create table eventattr
(
   attrid               bigint not null,
   objectid             bigint,
   fieldtypeid          char(24),
   attrname             char(24) not null,
   value                char(255),
   primary key (attrid)
)
charset = UTF8;

alter table eventattr comment '事件对象的属性';

/*==============================================================*/
/* Table: eventform                                             */
/*==============================================================*/
create table eventform
(
   formid               bigint not null,
   objectid             bigint,
   fromtypeid           char(24) not null,
   data                 mediumblob,
   srsid                char(24) not null,
   primary key (formid)
)
charset = UTF8;

alter table eventform comment '事件对象的形态存储表';

/*==============================================================*/
/* Table: eventobject                                           */
/*==============================================================*/
create table eventobject
(
   objectid             bigint not null,
   posid                int,
   name                 char(24) not null,
   pobjectid            bigint,
   srsid                char(24),
   primary key (objectid)
)
charset = UTF8;

alter table eventobject comment '事件对象';

/*==============================================================*/
/* Table: eventpos                                              */
/*==============================================================*/
create table eventpos
(
   posid                int not null,
   x                    double not null,
   y                    double not null,
   primary key (posid)
)
charset = UTF8;

/*==============================================================*/
/* Table: eventrelation                                         */
/*==============================================================*/
create table eventrelation
(
   fromobjectid         bigint not null,
   endobjectid          bigint not null,
   typeid               int,
   primary key (fromobjectid, endobjectid)
)
charset = UTF8;

/*==============================================================*/
/* Table: fieldtype                                             */
/*==============================================================*/
create table fieldtype
(
   typeid               char(24) not null,
   typename             char(24) not null,
   primary key (typeid)
)
charset = UTF8;

/*==============================================================*/
/* Table: formdatatype                                          */
/*==============================================================*/
create table formdatatype
(
   typeid               char(24) not null,
   typename             char(64) not null,
   primary key (typeid)
)
charset = UTF8;

/*==============================================================*/
/* Table: hierarchy                                             */
/*==============================================================*/
create table hierarchy
(
   hierachyid           int not null,
   hierachyname         char(24) not null,
   hierarchydepth       int not null,
   hierarchyinfo        text not null,
   primary key (hierachyid)
)
charset = UTF8;

alter table hierarchy comment '用户的层级定制表，用于记录用户定制的层级结构，用户每开始一次旅行就需要定制一个层级结构';

/*==============================================================*/
/* Table: master                                                */
/*==============================================================*/
create table master
(
   name                 char(24) not null,
   password             char(64) not null,
   roleid               int,
   primary key (name)
)
charset = UTF8;

alter table master comment '超级管理员用户，一个系统有且只有一个';

/*==============================================================*/
/* Table: relationtype                                          */
/*==============================================================*/
create table relationtype
(
   typeid               int not null,
   typename             char(24) not null,
   primary key (typeid)
)
charset = UTF8;

alter table relationtype comment '记录关联的方式';

/*==============================================================*/
/* Table: role                                                  */
/*==============================================================*/
create table role
(
   roleid               int not null,
   name                 char(24) not null,
   des                  char(255),
   primary key (roleid)
)
charset = UTF8;

alter table role comment '角色，有普通用户、管理员用户和超级管理员，权限不同';

INSERT INTO role values
(1,'超级管理员','具有最高权限且唯一，具有对管理员的管理权限'),
(2,'管理员','具有后台维护的权限以及普通用户的管理权限，也具有普通用户的功能权限'),
(3,'普通用户','具有系统登录权限');

/*==============================================================*/
/* Table: travel                                                */
/*==============================================================*/
create table travel
(
   travelid             int not null,
   travelname           char(24) not null,
   des                  text,
   userid               int not null,
   hierachyid           int not null,
   rootobjectid         bigint,
   primary key (travelid)
)
charset = UTF8;

alter table travel comment '用户旅行信息表';

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   userid               int not null auto_increment,
   name                 char(24) not null,
   password             char(64) not null,
   roleid               int not null,
   portrait             mediumblob,
   sex                  bool,
   primary key (userid)
)
charset = UTF8;

alter table user comment '用户表，用于存储普通用户和管理员用户';

/*==============================================================*/
/* Table: userlink                                              */
/*==============================================================*/
create table userlink
(
   sponsorid            int not null,
   receiverid           int not null,
   linktime             datetime not null,
   primary key (sponsorid, receiverid)
)
charset = UTF8;

alter table userlink comment '用于存储相互关注的用户，sponsorid是发起者id，reveiverid是接收者id';

alter table eventattr add constraint FK_eventattr_eventobject foreign key (objectid)
      references eventobject (objectid) on delete restrict on update restrict;

alter table eventattr add constraint FK_eventattr_fieldtype foreign key (fieldtypeid)
      references fieldtype (typeid) on delete restrict on update restrict;

alter table eventform add constraint FK_eventform_eventobject foreign key (objectid)
      references eventobject (objectid) on delete restrict on update restrict;

alter table eventform add constraint FK_eventform_formdatatype foreign key (fromtypeid)
      references formdatatype (typeid) on delete restrict on update restrict;

alter table eventobject add constraint FK_eventobject_eventpos foreign key (posid)
      references eventpos (posid) on delete restrict on update restrict;

alter table eventrelation add constraint FK_eventrelation_eventobject_from foreign key (fromobjectid)
      references eventobject (objectid) on delete restrict on update restrict;

alter table eventrelation add constraint FK_eventrelation_eventobject_to foreign key (endobjectid)
      references eventobject (objectid) on delete restrict on update restrict;

alter table eventrelation add constraint FK_eventrelation_relationtype foreign key (typeid)
      references relationtype (typeid) on delete restrict on update restrict;

alter table master add constraint FK_master_role foreign key (roleid)
      references role (roleid) on delete restrict on update restrict;

alter table travel add constraint FK_travel_eventobject foreign key (rootobjectid)
      references eventobject (objectid) on delete restrict on update restrict;

alter table travel add constraint FK_travel_hierarchy foreign key (hierachyid)
      references hierarchy (hierachyid) on delete restrict on update restrict;

alter table travel add constraint FK_travel_user foreign key (userid)
      references user (userid) on delete restrict on update restrict;

alter table user add constraint FK_user_role foreign key (roleid)
      references role (roleid) on delete restrict on update restrict;

alter table userlink add constraint FK_userlink_user_receiver foreign key (receiverid)
      references user (userid) on delete restrict on update restrict;

alter table userlink add constraint FK_userlink_user_sponsor foreign key (sponsorid)
      references user (userid) on delete restrict on update restrict;

