package org.example.procedure

import com.snowflake.snowpark.functions.col
import com.snowflake.snowpark.types._
import com.snowflake.snowpark.{Row, Session}
import org.example.function.ExampleFunction
import org.example.util.LocalSession

object App {

  def run(session: Session, msg: String): String = {
    val schema = StructType(
      Seq(StructField("Hello", StringType), StructField("World", StringType))
    )

    val data = Seq(
      Row.fromSeq(Seq("Welcome to ", "Snowflake!")),
      Row.fromSeq(Seq("Learn more: ", "https://www.snowflake.com/snowpark/"))
    )

    val df = session.createDataFrame(data, schema)

    val func = session.udf.registerTemporary(ExampleFunction.combine)

    df
      .select(func.apply(col("Hello"), col("World")))
      .show

    msg
  }

  def main(args: Array[String]): Unit = {
    val session = LocalSession.getLocalSession()

    run(session, "")
  }
}
