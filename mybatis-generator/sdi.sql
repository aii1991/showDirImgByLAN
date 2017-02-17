/*==============================================================*/
/* Database name:  sdi                                          */
/* DBMS name:      Sybase SQL Anywhere 12                       */
/* Created on:     2017/2/17 10:53:17                           */
/*==============================================================*/


drop database sdi;

/*==============================================================*/
/* Database: sdi                                                */
/*==============================================================*/
create database 'sdi.db';

/*==============================================================*/
/* Table: t_file                                                */
/*==============================================================*/
create table t_file 
(
   id                   bigint                         not null,
   name                 char(32)                       null,
   path                 char(126)                      null,
   size                 bigint                         null,
   update_time          bigint                         null,
   create_time          bigint                         null,
   constraint PK_T_FILE primary key clustered (id)
);

