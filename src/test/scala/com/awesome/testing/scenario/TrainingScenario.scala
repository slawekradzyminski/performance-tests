package com.awesome.testing.scenario

import com.awesome.testing.request.Login.login
import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder

object TrainingScenario {

/*
  private val credentialsFeeder = csv("data/credentials.csv").circular
*/
  private val credentialsFeeder = jsonFile("data/credentials.json").circular

  val trainingScenario: ScenarioBuilder = scenario("Training scenario")
    .feed(credentialsFeeder)
    .exec(login)
    .exitHereIfFailed

}
