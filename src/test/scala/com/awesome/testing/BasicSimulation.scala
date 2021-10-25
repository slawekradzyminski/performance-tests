package com.awesome.testing

import com.awesome.testing.config.LocalConfig
import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.language.postfixOps

class BasicSimulation extends Simulation {

  private final val json = "application/json"

  setUp(
    scenario("Training scenarion")
      .exec(
        http("Admin login request")
          .post("/users/signin")
          .body(ElFileBody("bodies/adminLogin.json")).asJson
          .check(status.is(200))
      )
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
