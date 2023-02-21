# Scala Project Template for Snowflake

Use this project template to start writing data applications on Snowflake using Scala

## Start Here

First, set your account URL, username, role, database, and schema in [dev.properties](dev.properties).

Next, set an environment variable with your Snowflake password:

```bash
# Linux/MacOS
set SNOWFLAKE_PASSWORD=<your-password>
```

```PowerShell
# Windows
$env:SNOWFLAKE_PASSWORD = <your-password>
```

## Project Structure

- [procedure/](src/main/scala/com/example/procedure/): Your stored procedures
- [udf/](src/main/scala/com/example/udf/): Your user-defined functions

## Docs

- [Snowpark Scaladoc](https://docs.snowflake.com/en/developer-guide/snowpark/reference/scala/com/snowflake/snowpark/index.html)
- [Developer Guide](https://docs.snowflake.com/en/developer-guide/snowpark/scala/index.html)
    - [Writing Stored Procedures](https://docs.snowflake.com/en/sql-reference/stored-procedures-scala.html) ... This isn't linked in the dev guide?

# TODO

- [ ] Test build
- [ ] Commit back to remote
- [ ] Add Maven pom
