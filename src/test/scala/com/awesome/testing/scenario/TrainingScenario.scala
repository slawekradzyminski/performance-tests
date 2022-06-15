package com.awesome.testing.scenario

import com.awesome.testing.request.Login.loginRequest
import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder

object TrainingScenario {

  val trainingScenario: ScenarioBuilder = scenario("Training scenario")
    .exec(loginRequest)

}
