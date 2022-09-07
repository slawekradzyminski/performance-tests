package com.awesome.testing.request

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object LoginRequest {

  val loginRequest: HttpRequestBuilder = http("Admin login request")
    .post("/users/signin")
    .body(ElFileBody("bodies/adminLogin.json")).asJson
    .check(status.is(200))

}
