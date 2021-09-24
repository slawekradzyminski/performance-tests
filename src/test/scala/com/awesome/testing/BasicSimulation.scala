package com.awesome.testing

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._
import scala.language.postfixOps

class BasicSimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("http://localhost:4000") // Here is the root for all relative URLs
    .header("Accept", "application/json")
    .header("Content-Type", "application/json")

  val scn =
    scenario("Training scenarion")
      .exec(
        http("login request")
          .post("/users/signin")
          .body(ElFileBody("bodies/login.json")).asJson
          .check(status.is(200))
      )
      .pause(1)

  setUp(scn.inject(rampUsers(200) during(60 seconds)).protocols(httpProtocol))
}
