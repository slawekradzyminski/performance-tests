package com.awesome.testing.scenario

import com.awesome.testing.config.LocalConfig
import com.awesome.testing.request.DeleteUser.deleteUserRequest
import com.awesome.testing.request.GetUsers.getUsersAsAdminRequest
import com.awesome.testing.request.Login.adminLoginRequest
import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder

import scala.concurrent.duration.DurationInt
import scala.language.postfixOps

object CleanupScenario {

  val cleanupScenario: ScenarioBuilder =
    scenario("Cleanup scenarion")
      .exec(adminLoginRequest)
      .pause(500 millis)
      .exec(getUsersAsAdminRequest)
      .pause(500 millis)
      .foreach("#{usernames}", "username") {
        doIf(session => !session("username").as[String].equals(LocalConfig.AdminUsername)) {
          exec(deleteUserRequest("#{username}"))
        }
      }
}
