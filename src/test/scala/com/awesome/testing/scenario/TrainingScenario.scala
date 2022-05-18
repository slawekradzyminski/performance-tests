package com.awesome.testing.scenario

import com.awesome.testing.request.Login.loginRequest
import io.gatling.core.Predef._
import io.gatling.core.structure.{ChainBuilder, ScenarioBuilder}

object TrainingScenario {


  private val credentialsFeeder = csv("data/credentials.csv").circular

  /**
   * Ścieżka jaką wykona jeden użytkownik, tj. jedna sesja Gatlinga
   * Kod poniżej ma jedną osobną sesję
   */
  val trainingScenario: ScenarioBuilder = scenario("Training scenario")
    .feed(credentialsFeeder)
    .exec(loginRequest)

}
