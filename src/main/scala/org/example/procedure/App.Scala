package org.example.procedure

import com.snowflake.snowpark.functions.col
import com.snowflake.snowpark.types._
import com.snowflake.snowpark.{Row, Session}
import org.example.function.ExampleFunction.myUdf
import org.example.util.LocalSession

object App {

  def run(session: Session): Unit = {
    val schema = StructType(Seq(
      StructField("Hello", StringType),
      StructField("World", StringType)))

    val data = Seq(
      Row.fromSeq(Seq("Welcome to", "Snowflake!")),
      Row.fromSeq(Seq("Get started:", "http://www.snowflake.com/etc")))

    val df = session.createDataFrame(data, schema)

    df
      .select(
        myUdf.apply(
          col("Hello"),
          col("World")))
      .show

    session.close()
  }

  def main(args: Array[String]): Unit = {
    val session = LocalSession.getLocalSession()

    run(session)
  }
}
