package com.awesome.testing.core

import io.gatling.core.Predef._

object FunctionalAssertions {

  val assertions: Seq[Assertion] = Seq(
    global.responseTime.max.lt(3000),
    global.successfulRequests.percent.is(100)
  )

}
