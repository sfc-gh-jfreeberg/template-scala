addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "1.1.0")



//assembly / assemblyExcludedJars := {
//  val cp = (assembly / fullClasspath).value
//  cp filter {
//    _.data.getName.contains("snowpark")
//  }
//}