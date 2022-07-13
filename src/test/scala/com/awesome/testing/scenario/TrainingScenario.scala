package com.awesome.testing.scenario

import com.awesome.testing.feeder.CredentialsFeeder.userFeeder
import com.awesome.testing.feeder.EmailFeeder.emailFeeder
import com.awesome.testing.request.Email.emailRequest
import com.awesome.testing.request.Login.loginRequest
import com.awesome.testing.request.Register.registerRequest
import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder

object TrainingScenario {

  val trainingScenario: ScenarioBuilder = scenario("Training scenario")
    .feed(userFeeder)
    .feed(emailFeeder)
    .exec(registerRequest)
    .pause(4)
    .exec(loginRequest)
    .pause(4)
    .exec(emailRequest)

}
