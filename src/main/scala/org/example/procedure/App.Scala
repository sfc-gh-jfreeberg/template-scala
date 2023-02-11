package org.example.procedure

import com.snowflake.snowpark.functions.col
import com.snowflake.snowpark.types._
import com.snowflake.snowpark.{Row, Session}
import org.example.function.ExampleFunction.combineStrings

object App {

  def main(args: Array[String]): Unit = {

    val session = Session.builder.configFile("dev.properties").create

    val schema = StructType(Seq(
      StructField("Hello", StringType),
      StructField("World", StringType)))

    val data = Seq(
      Row.fromSeq(Seq("Welcome to", "Snowflake!")),
      Row.fromSeq(Seq("Get started:", "http://www.snowflake.com/etc")))

    val df = session.createDataFrame(data, schema)

    df
      .select(
        combineStrings.apply(
          col("Hello"),
          col("World")))
      .show

    session.close()
  }
}
