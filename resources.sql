
CREATE STAGE IF NOT EXISTS artifacts;

PUT file://*.jar @artifacts AUTO_COMPRESS=FALSE OVERWRITE=TRUE;

CREATE OR REPLACE PROCEDURE MYPROC(msg STRING)
  RETURNS STRING
  LANGUAGE SCALA
  RUNTIME_VERSION = '2.12'
  IMPORTS = ('@artifacts/scala-template-assembly-0.1.0.jar')
  HANDLER = 'org.example.procedure.App.run';
