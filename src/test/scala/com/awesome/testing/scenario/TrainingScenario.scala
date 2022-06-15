package com.awesome.testing.scenario

import com.awesome.testing.feeder.UserFeeder.userFeeder
import com.awesome.testing.request.GetAllUsers.getAllUsersRequest
import com.awesome.testing.request.Login.loginRequest
import com.awesome.testing.request.Me.meRequest
import com.awesome.testing.request.Refresh.refreshRequest
import com.awesome.testing.request.Register.registerRequest
import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder

object TrainingScenario {

  val trainingScenario: ScenarioBuilder = scenario("Training scenario")
    .feed(userFeeder)
    .exec(registerRequest)
    .pause(2)
    .exec(loginRequest)
    .pause(2)
    .exec(getAllUsersRequest)
    .pause(2)
    .exec(refreshRequest)
    .pause(2)
    .exec(meRequest)

}
