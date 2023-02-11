package org.example.function

import org.example.function.ExampleFunction.combineStrings
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class ExampleFunctionTest extends AnyFlatSpec with should.Matchers {

  /**
   * If I wanted to test the exposed UDF like this, then I would need to have a set up method and:
   * 1. Have Snowflake credentials in the project (or Snowflake)
   * 2. Connect to Snowflake
   * 3. Run the test
   */
  "ExampleFunction" should "return the concatenated string" in {
    combineStrings("Hello ", "World") should be ("Hello World")
    combineStrings("Snowflake ", "Snowpark") should be ("Snowflake Snowpark")
  }

}
