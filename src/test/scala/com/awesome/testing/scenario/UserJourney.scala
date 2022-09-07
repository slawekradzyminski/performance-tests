package com.awesome.testing.scenario

import com.awesome.testing.request.LoginRequest.loginRequest
import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder

object UserJourney {

//  val credentialsFeeder = csv("data/credentials.csv").circular
  val credentialsFeeder = jsonFile("data/credentials.json").circular

  val testWarezTestScenario: ScenarioBuilder =
    scenario("Training scenario")
      .feed(credentialsFeeder)
      .exec(loginRequest)

}
