package com.awesome.testing

import com.awesome.testing.config.LocalConfig
import com.awesome.testing.scenario.TrainingScenario.trainingScenario
import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.language.postfixOps

class BasicSimulation extends Simulation {

  private final val json = "application/json"

  setUp(
    trainingScenario
      .inject(atOnceUsers(1))
      .protocols(http
        .baseUrl(LocalConfig.BaseUrl)
        .header("Accept", json)
        .header("Content-Type", json))
  ).assertions(
    global.responseTime.max.lt(3000),
    global.successfulRequests.percent.is(100)
  )
}
