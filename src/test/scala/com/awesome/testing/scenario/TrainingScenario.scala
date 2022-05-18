package com.awesome.testing.scenario

import com.awesome.testing.feeder.CredentialsFeeder.credentialsFeeder
import com.awesome.testing.request.EditUser.editUserRequest
import com.awesome.testing.request.GetUsers.getUsersRequest
import com.awesome.testing.request.Login.loginRequest
import com.awesome.testing.request.Register.registerRequest
import io.gatling.core.Predef._
import io.gatling.core.structure.{ChainBuilder, ScenarioBuilder}

object TrainingScenario {

  /**
   * Ścieżka jaką wykona jeden użytkownik, tj. jedna sesja Gatlinga
   * Kod poniżej ma jedną osobną sesję
   */
  val trainingScenario: ScenarioBuilder = scenario("Training scenario")
    .feed(credentialsFeeder)
    .exec(registerRequest)
    .pause(1)
    .exec(loginRequest)
    .pause(1)
    .exec(getUsersRequest)
    .pause(1)
    .exec(editUserRequest)


}
