package com.awesome.testing.core

import io.gatling.core.Predef._

object Assertions {

  val assertions = Seq(
    global.responseTime.max.lt(3000),
    global.successfulRequests.percent.is(100)
  )

}
