package com.awesome.testing

import com.awesome.testing.config.LocalConfig
import com.awesome.testing.scenario.UserJourney.testWarezTestScenario
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

import scala.language.postfixOps

class BasicSimulation extends Simulation {

  private final val json = "application/json"

  private val httpConfigForAllGatlingRequests: HttpProtocolBuilder = http
    .baseUrl(LocalConfig.BaseUrl)
    .header("Accept", json)
    .header("Content-Type", json)

  setUp(
    testWarezTestScenario.inject(
        atOnceUsers(4)
      )
      .protocols(httpConfigForAllGatlingRequests)
  ).assertions(
    global.responseTime.percentile(99).lte(3000),
    global.successfulRequests.percent.is(100)
  )
}
