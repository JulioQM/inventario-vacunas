/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     20/8/2022 12:47:31                           */
/*==============================================================*/


drop index I_PERSONA;

drop table PERSONAS;

drop index I_ROL;

drop table ROLES;

drop index I_TIPO_VACUNA;

drop table TIPO_VACUNAS;

drop index I_USUARIO;

drop table USUARIOS;

drop domain DOMAIN_1;

drop sequence SEG_PERSONA;

drop sequence SEG_ROL;

drop sequence SEG_TIPO_VACUNA;

drop sequence SEG_USUARIO;

create sequence SEG_PERSONA
increment 1
minvalue 1
maxvalue 999999
start 1
cache 1;

create sequence SEG_ROL
increment 1
minvalue 1
maxvalue 999999
start 1
cache 1;

create sequence SEG_TIPO_VACUNA
increment 1
minvalue 1
maxvalue 999999
start 1
cache 1;

create sequence SEG_USUARIO
increment 1
minvalue 1
maxvalue 999999
start 1
cache 1;


/*==============================================================*/
/* Table: PERSONAS                                              */
/*==============================================================*/
create table PERSONAS (
   PERS_ID              INTEGER              not null,
   USUA_ID              INTEGER              null,
   TIPV_ID              INTEGER              null,
   PERS_FECHA_NACIMIENTO TIMESTAMP            null,
   PERS_DIRECCION       VARCHAR(50)          null,
   PERS_TELEFONO        VARCHAR(15)          null,
   PERS_ESTADO_VACUNA   VARCHAR(50)          null,
   PERS_FECHA_VACUNACION TIMESTAMP            null default NULL,
   PERS_NUMERO_DOSIS    INTEGER              null,
   PERS_FECHA_CREACION  TIMESTAMP            null default CURRENT_TIMESTAMP,
   PERS_FECHA_ACTUALIZACION TIMESTAMP            null,
   PERS_ESTADO          BOOL                 null default true
      constraint CKC_PERS_ESTADO_PERSONAS check (PERS_ESTADO is null or (PERS_ESTADO in (true,false))),
   constraint PK_PERSONAS primary key (PERS_ID)
);

/*==============================================================*/
/* Index: I_PERSONA                                             */
/*==============================================================*/
create unique index I_PERSONA on PERSONAS (
PERS_ID
);

/*==============================================================*/
/* Table: ROLES                                                 */
/*==============================================================*/
create table ROLES (
   ROLE_ID              INTEGER              not null,
   ROLE_NOMBRE          VARCHAR(50)          null,
   ROLE_DESCRIPCION     VARCHAR(100)         null,
   ROLE_FECHA_CREACION  TIMESTAMP            null default CURRENT_TIMESTAMP,
   ROLE_FECHA_ACTUALIZACION TIMESTAMP            null,
   ROLE_ESTADO          BOOL                 null default true
      constraint CKC_ROLE_ESTADO_ROLES check (ROLE_ESTADO is null or (ROLE_ESTADO in (true,false))),
   constraint PK_ROLES primary key (ROLE_ID)
);

/*==============================================================*/
/* Index: I_ROL                                                 */
/*==============================================================*/
create unique index I_ROL on ROLES (
ROLE_ID
);

/*==============================================================*/
/* Table: TIPO_VACUNAS                                          */
/*==============================================================*/
create table TIPO_VACUNAS (
   TIPV_ID              INTEGER              not null,
   TIPV_NOMBRE          VARCHAR(50)          null,
   TIPV_FECHA_CREACION  TIMESTAMP            null default CURRENT_TIMESTAMP,
   TIPV_FECHA_ACTUALIZACION TIMESTAMP            null,
   TIPV_ESTADO          BOOL                 null default true
      constraint CKC_TIPV_ESTADO_TIPO_VAC check (TIPV_ESTADO is null or (TIPV_ESTADO in (true,false))),
   constraint PK_TIPO_VACUNAS primary key (TIPV_ID)
);

/*==============================================================*/
/* Index: I_TIPO_VACUNA                                         */
/*==============================================================*/
create unique index I_TIPO_VACUNA on TIPO_VACUNAS (
TIPV_ID
);

/*==============================================================*/
/* Table: USUARIOS                                              */
/*==============================================================*/
create table USUARIOS (
   USUA_ID              INTEGER              not null,
   ROL_ID               INTEGER              null,
   USUA_CEDULA          VARCHAR(10)          null,
   USUA_NOMBRES         VARCHAR(50)          null,
   USUA_APELLIDOS       VARCHAR(50)          null,
   USUA_EMAIL           VARCHAR(50)          null,
   USUA_CLAVE           VARCHAR(32)          null,
   USUA_FECHA_CREACION  TIMESTAMP            null default CURRENT_TIMESTAMP,
   USUA_FECHA_ACTUALIZACION TIMESTAMP            null,
   USUA_ESTADO          BOOL                 null default true
      constraint CKC_USUA_ESTADO_USUARIOS check (USUA_ESTADO is null or (USUA_ESTADO in (true,false))),
   constraint PK_USUARIOS primary key (USUA_ID)
);

/*==============================================================*/
/* Index: I_USUARIO                                             */
/*==============================================================*/
create unique index I_USUARIO on USUARIOS (
USUA_ID
);

alter table PERSONAS
   add constraint FK_PERSONAS_REFERENCE_USUARIOS foreign key (USUA_ID)
      references USUARIOS (USUA_ID)
      on delete restrict on update restrict;

alter table PERSONAS
   add constraint FK_PERSONAS_REFERENCE_TIPO_VAC foreign key (TIPV_ID)
      references TIPO_VACUNAS (TIPV_ID)
      on delete restrict on update restrict;

alter table USUARIOS
   add constraint FK_USUARIOS_REFERENCE_ROLES foreign key (ROL_ID)
      references ROLES (ROLE_ID)
      on delete restrict on update restrict;

