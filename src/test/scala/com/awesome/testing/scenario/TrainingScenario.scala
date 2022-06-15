package com.awesome.testing.scenario

import com.awesome.testing.request.Login.loginRequest
import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder

object TrainingScenario {

//  private val credentialsFeeder = csv("data/credentials.csv").circular
  private val credentialsFeeder = jsonFile("data/users.json").circular

  val trainingScenario: ScenarioBuilder = scenario("Training scenario")
    .feed(credentialsFeeder)
    .exec(loginRequest)

}
