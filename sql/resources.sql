USE DATABASE JASONFREEBERG;
USE SCHEMA PUBLIC;
USE WAREHOUSE JASONFREEBERG_WH;

CREATE STAGE IF NOT EXISTS artifacts;

PUT file://scala-template-assembly-0.1.0.jar @artifacts AUTO_COMPRESS=FALSE OVERWRITE=TRUE;

CREATE OR REPLACE PROCEDURE MYPROC(msg STRING)
  RETURNS STRING
  LANGUAGE SCALA
  RUNTIME_VERSION = '2.12'
  PACKAGES = ('com.snowflake:snowpark:1.7.0')
  IMPORTS = ('@artifacts/scala-template-assembly-0.1.0.jar')
  HANDLER = 'org.example.procedure.App.run';
