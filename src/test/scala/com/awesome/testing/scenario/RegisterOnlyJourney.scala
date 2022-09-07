package com.awesome.testing.scenario

import com.awesome.testing.feeder.CredentialsFeeder.userData
import com.awesome.testing.request.EditUserRequest.editUserRequest
import com.awesome.testing.request.GetAllRequest.getAllRequest
import com.awesome.testing.request.GetUserRequest.getUserRequest
import com.awesome.testing.request.LoginRequest.loginRequest
import com.awesome.testing.request.RegisterRequest.registerRequest
import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder

object RegisterOnlyJourney {

  val registerOnlyScenario: ScenarioBuilder =
    scenario("Training scenario - register only")
      .feed(userData)
      .exec(registerRequest)
}
