CREATE DATABASE test_cbrf
  DEFAULT CHARACTER SET cp1251
  DEFAULT COLLATE cp1251_general_ci;

CREATE TABLE bnkseek
(
  id       INT AUTO_INCREMENT
    PRIMARY KEY,
  real_bik VARCHAR(4)  NULL,
  pzn      INT         NULL,
  uer      INT         NOT NULL,
  rgn      INT         NOT NULL,
  ind      VARCHAR(6)  NULL,
  tnp      INT         NULL,
  nnp      VARCHAR(25) NULL,
  adr      VARCHAR(30) NULL,
  rkc      VARCHAR(9)  NULL,
  namep    VARCHAR(45) NOT NULL,
  newnum   VARCHAR(9)  NOT NULL,
  telef    VARCHAR(25) NULL,
  regn     VARCHAR(9)  NULL,
  okpo     VARCHAR(8)  NULL,
  dt_izm   DATE        NOT NULL,
  ksnp     VARCHAR(20) NULL,
  date_in  DATE        NOT NULL,
  date_ch  DATE        NULL,
  CONSTRAINT bnkseek_newnum_uindex
  UNIQUE (newnum)
)
  CHARACTER SET cp1251
  COLLATE cp1251_general_ci;

CREATE INDEX bnkseek_pzn_pzn_fk
  ON bnkseek (pzn);

CREATE INDEX bnkseek_reg_rgn_fk
  ON bnkseek (rgn);

CREATE INDEX bnkseek_uer_uer_fk
  ON bnkseek (uer);

CREATE TABLE pzn
(
  id      INT AUTO_INCREMENT
    PRIMARY KEY,
  pzn     INT         NOT NULL,
  imy     VARCHAR(4)  NOT NULL,
  name    VARCHAR(40) NOT NULL,
  cb_date DATE        NOT NULL,
  ce_date DATE        NULL
)
  CHARACTER SET cp1251
  COLLATE cp1251_general_ci;

CREATE TABLE reg
(
  id     INT AUTO_INCREMENT
    PRIMARY KEY,
  rgn    INT         NOT NULL,
  name   VARCHAR(40) NOT NULL,
  center VARCHAR(30) NULL,
  namet  VARCHAR(40) NOT NULL
)
  CHARACTER SET cp1251
  COLLATE cp1251_general_ci;

CREATE TABLE tnp
(
  id        TINYINT AUTO_INCREMENT
    PRIMARY KEY,
  tnp       INT         NOT NULL,
  fullname  VARCHAR(25) NOT NULL,
  shortname VARCHAR(5)  NOT NULL
)
  CHARACTER SET cp1251
  COLLATE cp1251_general_ci;

CREATE TABLE uer
(
  id      INT AUTO_INCREMENT
    PRIMARY KEY,
  uer     INT         NOT NULL,
  uername VARCHAR(70) NOT NULL
)
  CHARACTER SET cp1251
  COLLATE cp1251_general_ci;