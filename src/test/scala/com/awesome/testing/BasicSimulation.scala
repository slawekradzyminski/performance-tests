package com.awesome.testing

import com.awesome.testing.core.HttpConfig.httpProtocol
import com.awesome.testing.scenario.TrainingScenario.trainingScenario
import io.gatling.core.Predef._

import scala.concurrent.duration._
import scala.language.postfixOps

class BasicSimulation extends Simulation {

  setUp(
    trainingScenario.inject(atOnceUsers(1))
//    trainingScenario.inject(rampUsers(200) during(60 seconds))
      .protocols(httpProtocol)
  ).assertions(
    global.responseTime.max.lt(3000),
    global.successfulRequests.percent.is(100)
  )
}
