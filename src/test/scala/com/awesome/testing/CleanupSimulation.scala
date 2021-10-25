package com.awesome.testing

import com.awesome.testing.core.HttpConfig.httpProtocol
import com.awesome.testing.scenario.CleanupScenario.cleanupScenario
import io.gatling.core.Predef._

import scala.language.postfixOps

class CleanupSimulation extends Simulation {

  setUp(
    cleanupScenario.inject(atOnceUsers(1))
      .protocols(httpProtocol)
  ).assertions(
    global.successfulRequests.percent.is(100)
  )
}
