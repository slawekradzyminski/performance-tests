package com.awesome.testing

import com.awesome.testing.core.FunctionalAssertions.assertions
import com.awesome.testing.core.Http.httpConfig
import com.awesome.testing.scenario.TrainingScenario.trainingScenario
import io.gatling.core.Predef._

import scala.language.postfixOps

class BasicSimulation extends Simulation {

  setUp(
    trainingScenario
      .inject(
        atOnceUsers(4)
      )
      .protocols(httpConfig)
  ).assertions(assertions)
}
