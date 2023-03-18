package com.awesome.testing

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

class JsonPlaceholderSimulation extends Simulation {

  val baseUrl = "https://jsonplaceholder.typicode.com"
  val concurrentUsers = 1

  val httpConf: HttpProtocolBuilder = http
    .baseUrl(baseUrl)
    .acceptHeader("application/json")
    .userAgentHeader("Gatling")

  val scn: ScenarioBuilder = scenario("JsonPlaceholder GET requests")
    .exec(
      repeat(concurrentUsers) {
        exec(
          http("GET /posts")
            .get("/posts")
            .check(status.is(200))
        )
      }
    )

  setUp(
    scn.inject(atOnceUsers(concurrentUsers))
  ).protocols(httpConf)
}
