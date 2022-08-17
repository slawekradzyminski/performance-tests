package com.awesome.testing.scenario

import com.awesome.testing.feeder.CredentialsFeeder.credentialsFeeder
import com.awesome.testing.request.Edit.edit
import com.awesome.testing.request.GetAllUsers.getAllUsers
import com.awesome.testing.request.GetUser.getUser
import com.awesome.testing.request.Login.login
import com.awesome.testing.request.Register.register
import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder

object TrainingScenario {

/*
  private val credentialsFeeder = csv("data/credentials.csv").circular
  private val credentialsFeeder = jsonFile("data/credentials.json").circular
*/

  val trainingScenario: ScenarioBuilder = scenario("Training scenario")
    .feed(credentialsFeeder)
    .exec(register)
    .exitHereIfFailed
    .pause(3)
    .exec(login)
    .exitHereIfFailed
    .repeat(3) {
      pause(1).exec(getUser)
    }
    .pause(1)
    .exec(getAllUsers)
    .pause(1)
    .randomSwitch(
      50.0 -> exec(edit)
    )

}
