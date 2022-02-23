package com.awesome.testing.scenario

import com.awesome.testing.request.LoginRequest.loginRequest
import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder

object TrainingScenario {

  val trainingScenario: ScenarioBuilder = scenario("Training scenario")
    .feed(csv("data/users.csv").circular)
    .exec(loginRequest)

}
