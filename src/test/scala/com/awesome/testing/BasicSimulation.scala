package com.awesome.testing

import com.awesome.testing.config.LocalConfig
import com.awesome.testing.scenario.UserJourney.testWarezTestScenario
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

import scala.concurrent.duration.DurationInt
import scala.language.postfixOps

class BasicSimulation extends Simulation {

  private final val json = "application/json"

  private val httpConfigForAllGatlingRequests: HttpProtocolBuilder = http
    .baseUrl(LocalConfig.BaseUrl)
    .header("Accept", json)
    .header("Content-Type", json)

  private val desiredRpsForBaseRequest = 5

  setUp(
    testWarezTestScenario.inject(
      rampUsersPerSec(0).to(desiredRpsForBaseRequest).during(1 minutes),
      constantUsersPerSec(desiredRpsForBaseRequest).during(2 minutes) randomized,
      rampUsersPerSec(desiredRpsForBaseRequest).to(0).during(1 minutes)
    )
      .protocols(httpConfigForAllGatlingRequests)
  ).assertions(
    global.responseTime.percentile(99).lte(3000),
    global.successfulRequests.percent.is(100)
  )
}
