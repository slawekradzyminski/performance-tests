package com.awesome.testing.scenario

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.core.structure.ScenarioBuilder

object UserJourney {

  val testWarezTestScenario: ScenarioBuilder =
    scenario("Training scenario")
      .exec(
        http("Admin login request")
          .post("/users/signin")
          .body(ElFileBody("bodies/adminLogin.json")).asJson
          .check(status.is(200))
      )

}
