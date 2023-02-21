# Scala Project Template for Snowflake

Use this project template to start writing data applications on Snowflake using Scala.

## Start Here

### Prerequisites

To develop your applications locally, you will need

- A Snowflake account
- Java 8 
- Scala 2.12
- An IDE or code editor (IntelliJ, VS Code, Eclipse)

### Set credentials

Set your account URL, username, role, database, and schema in [dev.properties](dev.properties).

Next, set an environment variable with your Snowflake password:

```bash
# Linux/MacOS
set SNOWFLAKE_PASSWORD=<your-password>
```

```bash
# Windows
$env:SNOWFLAKE_PASSWORD = <your-password>
```

Optional: You can set this env var permanently by editing your bash profile (on Linux/MacOS) or 
using the System Properties menu (on Windows).

### Test connection

Once you've set your credentials, you can test your connection by running the `run()` command 
in [`App.scala`](src/main/scala/org/example/procedure/App.scala). You can run this method directly from your IDE, or by
running `sbt run`.

You should see output like this:

```
------------------------------------------------------
|"""ACCOUNT"".""PUBLIC"".SNOWPARK_TEMP_FUN...        |
------------------------------------------------------
|Welcome to Snowflake!                               |
|Learn more: https://www.snowflake.com/snowpark/     |
------------------------------------------------------
```

### Deploy the contents

The GitHub Actions [workflow file](.github/workflows/build-and-deploy.yml) allows you to continously deploy your objects to Snowflake. When you're ready,
create a secret in your GitHub repository named `SNOWSQL_PASSWORD` with your account password. Then, replace the placeholders in the [workflow file](.github/workflows/build-and-deploy.yml)
with your username, database, and other account information.

## Project Structure

- [procedure/](src/main/scala/com/example/procedure/): Directory for your stored procedures
- [udf/](src/main/scala/com/example/udf/): Directory for your user-defined functions
- [util/](src/main/scala/com/example/util/): Directory for methods/classes shared between procedures and UDFs 
- [resources.sql](resources.sql): A deployment script for your objects
- [build-and-deploy.yaml](.github/workflows/build-and-deploy.yml): A GitHub Actions template to build and deploy your objects

## Docs

- [Snowpark Scaladoc](https://docs.snowflake.com/en/developer-guide/snowpark/reference/scala/com/snowflake/snowpark/index.html)
- [Developer Guide](https://docs.snowflake.com/en/developer-guide/snowpark/scala/index.html)
- [Writing Stored Procedures](https://docs.snowflake.com/en/sql-reference/stored-procedures-scala.html)
