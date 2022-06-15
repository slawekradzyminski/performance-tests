package com.awesome.testing.request

import com.awesome.testing.util.Authorization.{Authorization, authValue}
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object Refresh {

  val refreshRequest: HttpRequestBuilder = {
    http("Get me request")
      .get("/users/refresh")
      .header(Authorization, authValue)
      .check(status.is(200))
      .check(bodyString.saveAs("token"))
  }

}
