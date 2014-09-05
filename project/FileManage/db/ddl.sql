--����ҵ��Ա��
create table manager(
userid number,
username varchar2(50),
password varchar2(50)
);
create sequence seq_mgr;
insert into MANAGER (userid, username, password) values(0, 'admin', 'admin');

-- Create table �û�������
create table USER_FILE_INFO
(
  userserialid NUMBER(9) not null,
  userid       VARCHAR2(10) not null,
  username     VARCHAR2(10) not null,
  createdate   DATE not null,
  address      VARCHAR2(100),
  state        VARCHAR2(2) not null,
  logoutdate   DATE
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 16
    minextents 1
    maxextents unlimited
  );
-- Add comments to the columns 
comment on column USER_FILE_INFO.userserialid
  is '�û���ˮ��';
comment on column USER_FILE_INFO.userid
  is '�û����';
comment on column USER_FILE_INFO.username
  is '�û���';
comment on column USER_FILE_INFO.createdate
  is '��������';
comment on column USER_FILE_INFO.address
  is '�û���ַ';
comment on column USER_FILE_INFO.state
  is '�Ƿ�������y������   n�������ã�';
comment on column USER_FILE_INFO.logoutdate
  is '��������';
-- Create/Recreate primary, unique and foreign key constraints 
alter table USER_FILE_INFO
  add constraint PK_USERSERIALID primary key (USERSERIALID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

-- Create table �����¼��
create table FILE_CHANGE_RECORD
(
  changeserialid NUMBER(9) not null,
  ctable         VARCHAR2(30) not null,
  ctableserialid NUMBER(9) not null,
  userserialid   NUMBER(9) not null,
  cfield         VARCHAR2(30) not null,
  cbeforevalue   VARCHAR2(100),
  caftervalue    VARCHAR2(100),
  creason        VARCHAR2(200) not null,
  ccontent       VARCHAR2(100) not null,
  handler        VARCHAR2(10) not null,
  handletime     DATE
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 16
    minextents 1
    maxextents unlimited
  );
-- Add comments to the columns 
comment on column FILE_CHANGE_RECORD.changeserialid
  is '�����ˮ��';
comment on column FILE_CHANGE_RECORD.ctable
  is '�������';
comment on column FILE_CHANGE_RECORD.ctableserialid
  is '��Ӧ�޸ı����ˮ��';
comment on column FILE_CHANGE_RECORD.userserialid
  is '�û���ˮ��';
comment on column FILE_CHANGE_RECORD.cfield
  is '����ֶ�';
comment on column FILE_CHANGE_RECORD.cbeforevalue
  is '���ǰֵ';
comment on column FILE_CHANGE_RECORD.caftervalue
  is '�����ֵ';
comment on column FILE_CHANGE_RECORD.creason
  is '���ԭ��';
comment on column FILE_CHANGE_RECORD.ccontent
  is '�������';
comment on column FILE_CHANGE_RECORD.handler
  is '������';
comment on column FILE_CHANGE_RECORD.handletime
  is '����ʱ��';
-- Create/Recreate primary, unique and foreign key constraints 
alter table FILE_CHANGE_RECORD
  add constraint PK_CHANGESERIALID primary key (CHANGESERIALID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table FILE_CHANGE_RECORD
  add constraint FK_FCR_UFI_USERSERIALID foreign key (USERSERIALID)
  references USER_FILE_INFO (USERSERIALID);

-- Create table �û���ϵ��Ϣ��
create table USER_CONTACT_INFO
(
  contactserialid NUMBER(9) not null,
  userserialid    NUMBER(9) not null,
  contacttype     VARCHAR2(10) not null,
  contactdetails  VARCHAR2(20) not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64
    minextents 1
    maxextents unlimited
  );
-- Add comments to the columns 
comment on column USER_CONTACT_INFO.contactserialid
  is '��ϵ��Ϣ��ˮ��';
comment on column USER_CONTACT_INFO.userserialid
  is '�û���ˮ��';
comment on column USER_CONTACT_INFO.contacttype
  is '��ϵ��ʽ(''����''������    ''����''������)';
comment on column USER_CONTACT_INFO.contactdetails
  is '��ϵ���������';
-- Create/Recreate primary, unique and foreign key constraints 
alter table USER_CONTACT_INFO
  add constraint PK_CONTACTSERIALID primary key (CONTACTSERIALID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table USER_CONTACT_INFO
  add constraint FK_UCI_UFI_USERSERIALID foreign key (USERSERIALID)
  references USER_FILE_INFO (USERSERIALID);

-- Create table �û������
create table USER_FINANCAL_INFO
(
  financalserialid NUMBER(9) not null,
  userserialid     NUMBER(9) not null,
  openingbank      VARCHAR2(30) not null,
  account          VARCHAR2(50) not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64
    minextents 1
    maxextents unlimited
  );
-- Add comments to the columns 
comment on column USER_FINANCAL_INFO.financalserialid
  is '������Ϣ��ˮ��';
comment on column USER_FINANCAL_INFO.userserialid
  is '�û���ˮ��';
comment on column USER_FINANCAL_INFO.openingbank
  is '������';
comment on column USER_FINANCAL_INFO.account
  is '�˺�';
-- Create/Recreate primary, unique and foreign key constraints 
alter table USER_FINANCAL_INFO
  add constraint PK_FINANCALSERIALID primary key (FINANCALSERIALID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table USER_FINANCAL_INFO
  add constraint FK_UFNI_UFI_USERSERIALID foreign key (USERSERIALID)
  references USER_FILE_INFO (USERSERIALID);

-- ����
create sequence seq_fcr;
create sequence seq_uci;
create sequence seq_ufi;
create sequence seq_ufni;
  
--dml
delete from FILE_CHANGE_RECORD;
delete from USER_CONTACT_INFO;
delete from USER_FINANCAL_INFO;
delete from USER_FILE_INFO;

select * from user_file_info;
