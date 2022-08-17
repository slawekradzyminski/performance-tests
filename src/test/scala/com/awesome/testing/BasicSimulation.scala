package com.awesome.testing

import com.awesome.testing.core.HttpConfig.httpConfig
import com.awesome.testing.scenario.TrainingScenario.trainingScenario
import io.gatling.core.Predef._

import scala.concurrent.duration.DurationInt
import scala.language.postfixOps

class BasicSimulation extends Simulation {

  val baseOpw = 100000
  val targetTestOpw = 1000000
  val rpmReadFromNewRelic = 215
  val secondsInAMinute = 60
  val baseRequestRps = rpmReadFromNewRelic / secondsInAMinute

  val usersPerSecond = targetTestOpw / baseOpw * baseRequestRps

  setUp(
    trainingScenario
      .inject(
        rampConcurrentUsers(0).to(10) during 1.minutes,
        constantConcurrentUsers(10) during 1.minutes
      )
      .protocols(httpConfig)
  ).assertions(
    global.responseTime.percentile(90).lt(3000),
    global.successfulRequests.percent.gt(99.5)
  )
}
