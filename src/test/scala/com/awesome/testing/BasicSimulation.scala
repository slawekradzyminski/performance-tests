package com.awesome.testing

import com.awesome.testing.core.HttpConfig.httpConfig
import com.awesome.testing.scenario.TrainingScenario.trainingScenario
import io.gatling.core.Predef._

import scala.language.postfixOps

class BasicSimulation extends Simulation {

  setUp(
    trainingScenario
      .inject(atOnceUsers(1))
      .protocols(httpConfig)
  ).assertions(
    global.responseTime.max.lt(3000),
    global.successfulRequests.percent.is(100)
  )
}
