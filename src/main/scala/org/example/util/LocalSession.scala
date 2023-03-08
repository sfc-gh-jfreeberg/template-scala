package org.example.util

import com.snowflake.snowpark.Session

object LocalSession {
  def getLocalSession(): Session = {

    try {
      val password = System.getenv("SNOWSQL_PASSWORD")
      Session.builder
        .configFile("dev.properties")
        .config("PASSWORD", password)
        .create
    } catch {
      case e: NullPointerException =>
        println("ERROR: Environment variable, SNOWFLAKE_PASSWORD, not found. Please set this variable");
        e.printStackTrace()
        null
    }
  }
}
