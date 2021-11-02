package com.awesome.testing

import com.awesome.testing.core.FunctionalAssertions.assertions
import com.awesome.testing.core.HttpConfig.httpProtocol
import com.awesome.testing.scenario.TrainingScenario.trainingScenario
import io.gatling.core.Predef._

import scala.language.postfixOps

class BasicSimulation extends Simulation {

  setUp(
    trainingScenario
      .inject(atOnceUsers(10))
      .protocols(httpProtocol)
  )
    .assertions(assertions)
}
