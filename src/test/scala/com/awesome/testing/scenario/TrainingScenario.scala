package com.awesome.testing.scenario

import com.awesome.testing.feeder.CredentialsFeeder.credentialsFeeder
import com.awesome.testing.request.EditUser.editUserRequest
import com.awesome.testing.request.GetUsers.getUsersRequest
import com.awesome.testing.request.Login.loginRequest
import com.awesome.testing.request.Register.registrationRequest
import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder

object TrainingScenario {

  val trainingScenario: ScenarioBuilder =
    scenario("Training scenario")
      .feed(credentialsFeeder)
      .exec(registrationRequest)
      .pause(10)
      .exec(loginRequest)
      .pause(1)
      .exec(getUsersRequest)
      .pause(4)
      .exec(editUserRequest)

}
