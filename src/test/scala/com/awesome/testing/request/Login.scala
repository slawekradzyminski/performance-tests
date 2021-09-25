package com.awesome.testing.request

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object Login {

  val loginRequest: HttpRequestBuilder = buildLoginRequest("bodies/login.json")

  val adminLoginRequest: HttpRequestBuilder = buildLoginRequest("bodies/adminLogin.json")

  private def buildLoginRequest(bodyPath: String): HttpRequestBuilder = {
    http("Admin login request")
      .post("/users/signin")
      .body(ElFileBody(bodyPath)).asJson
      .check(status.is(200))
      .check(jsonPath("$.token").exists.saveAs("token"))
  }
}
