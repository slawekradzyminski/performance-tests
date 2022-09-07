package com.awesome.testing.scenario

import com.awesome.testing.feeder.CredentialsFeeder.userData
import com.awesome.testing.request.GetAllRequest.getAllRequest
import com.awesome.testing.request.LoginRequest.loginRequest
import com.awesome.testing.request.RegisterRequest.registerRequest
import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder

object UserJourney {

  val testWarezTestScenario: ScenarioBuilder =
    scenario("Training scenario")
      .feed(userData)
      .exec(registerRequest)
      .pause(3)
      .exec(loginRequest)
      .pause(1)
      .exec(getAllRequest)

}
