USE DATABASE JASONFREEBERG;
USE SCHEMA PUBLIC;
USE WAREHOUSE JASONFREEBERG_WH;

CREATE OR REPLACE STAGE artifacts;

PUT file://target/scala-2.12/scala-template-assembly-0.1.0.jar @~/artifacts

CREATE OR REPLACE PROCEDURE MYPROC(msg STRING)
  RETURNS STRING
  LANGUAGE SCALA
  RUNTIME_VERSION = '2.12'
  PACKAGES = ('com.snowflake:snowpark:1.7.0')
  IMPORTS = ('@artifacts/scala-template-assembly-0.1.0.jar')
  HANDLER = 'org.example.procedure.App.run';
