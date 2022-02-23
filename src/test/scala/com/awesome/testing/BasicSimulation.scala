package com.awesome.testing

import com.awesome.testing.config.LocalConfig
import com.awesome.testing.core.Assertions.assertions
import com.awesome.testing.core.HttpConfig.httpConfig
import com.awesome.testing.scenario.TrainingScenario.trainingScenario
import io.gatling.core.Predef._

import scala.language.postfixOps

class BasicSimulation extends Simulation {

  setUp(
    trainingScenario
      .inject(atOnceUsers(4))
      .protocols(httpConfig)
  ).assertions(assertions)
}
