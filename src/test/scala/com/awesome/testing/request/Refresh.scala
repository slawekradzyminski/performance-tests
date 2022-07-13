package com.awesome.testing.request

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object Refresh {

  val refreshRequest: HttpRequestBuilder = {
    http("Refresh token request")
      .get("/users/refresh")
      .header("Authorization", "Bearer #{token}")
      .check(status.is(200))
      .check(bodyString.saveAs("token"))
  }

}
