package com.awesome.testing.scenario

import com.awesome.testing.request.LoginRequest.loginRequest
import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder

object UserJourney {

  val testWarezTestScenario: ScenarioBuilder =
    scenario("Training scenario")
      .exec(loginRequest)

}
