package com.awesome.testing.scenario

import com.awesome.testing.feeder.CredentialsFeeder.credentialsFeeder
import com.awesome.testing.request.LoginRequest.loginRequest
import com.awesome.testing.request.RegisterRequest.registerRequest
import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder

import scala.concurrent.duration.DurationInt
import scala.language.postfixOps

object TrainingScenario {

  val trainingScenario: ScenarioBuilder = scenario("Training scenario")
    .feed(credentialsFeeder)
    .exec(registerRequest)
    .exitHereIfFailed
    .pause(5 seconds)
    .exec(loginRequest)

}
