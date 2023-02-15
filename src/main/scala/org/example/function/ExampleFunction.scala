package org.example.function

import com.snowflake.snowpark.UserDefinedFunction
import com.snowflake.snowpark.functions.udf

object ExampleFunction extends Serializable {

  // UDF exposed to package with the UserDefinedFunction type
  val myUdf: UserDefinedFunction = udf(combine)

  // Internal UDF implementation. This could be multiple components, this is a
  // minimal example
  private val combine = (a: String, b: String) => {
    a.concat(b)
  }

}
