package org.example.function

import com.snowflake.snowpark.UserDefinedFunction
import com.snowflake.snowpark.functions.udf

object ExampleFunction {

  // UDF exposed to package with the proper type
  val combineStrings: UserDefinedFunction = udf(combine(_, _))

  // Internal UDF implementation. This could be multiple components, this is a
  // minimal example
  private def combine(a: String, b: String): String = {
    a.concat(b)
  }

}