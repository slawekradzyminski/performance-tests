package com.awesome.testing.request

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object RegisterRequest {

  val registerRequest: HttpRequestBuilder = http("Register request")
    .post("/users/signup")
    .body(ElFileBody("bodies/register.json")).asJson
    .check(status.is(201))

}
