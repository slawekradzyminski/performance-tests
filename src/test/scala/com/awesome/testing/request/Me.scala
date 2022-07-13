package com.awesome.testing.request

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object Me {

  val meRequest: HttpRequestBuilder = {
    http("Get me request")
      .get("/users/me")
      .header("Authorization", "Bearer #{token}")
      .check(status.is(200))
  }

}
