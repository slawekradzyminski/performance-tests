package com.awesome.testing

import com.awesome.testing.core.HttpConfig.httpProtocol
import com.awesome.testing.scenario.BasicScenario.scn
import io.gatling.core.Predef._

import scala.concurrent.duration._
import scala.language.postfixOps

class BasicSimulation extends Simulation {

  setUp(
    scn.inject(rampUsers(200) during(60 seconds))
      .protocols(httpProtocol)
  )
}
