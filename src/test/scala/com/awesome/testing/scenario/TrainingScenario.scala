package com.awesome.testing.scenario

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._

object TrainingScenario {

  val trainingScenario: ScenarioBuilder = scenario("Training scenario")
    .exec(
      http("Admin login request")
        .post("/users/signin")
        .body(ElFileBody("bodies/adminLogin.json")).asJson
        .check(status.is(200))
    )

}
