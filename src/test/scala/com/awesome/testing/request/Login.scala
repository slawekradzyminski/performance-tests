package com.awesome.testing.request

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object Login {

  val loginRequest: HttpRequestBuilder = http("login request")
    .post("/users/signin")
    .body(ElFileBody("bodies/login.json")).asJson
    .check(status.is(200))

}
