package com.awesome.testing.scenario

import com.awesome.testing.feeder.CredentialsFeeder.credentialsFeeder
import com.awesome.testing.request.Login.loginRequest
import com.awesome.testing.request.Register.registrationRequest
import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder

object BasicScenario {

  val scn: ScenarioBuilder =
    scenario("Training scenarion")
      .feed(credentialsFeeder)
      .exec(registrationRequest)
      .pause(10)
      .exec(loginRequest)

}
