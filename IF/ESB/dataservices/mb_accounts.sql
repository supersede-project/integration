-- Table: mb_accounts

-- DROP TABLE mb_accounts;

CREATE TABLE mb_accounts
(
  platform text NOT NULL,
  mb_user text,
  mb_password text,
  mb_url text,
  CONSTRAINT pk_platform PRIMARY KEY (platform),
  CONSTRAINT unique_platform UNIQUE (platform)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE mb_accounts
  OWNER TO supersede;
