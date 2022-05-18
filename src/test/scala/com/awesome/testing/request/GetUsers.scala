package com.awesome.testing.request

import com.awesome.testing.util.Authorization.Authorization
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object GetUsers {

  val getUsersRequest: HttpRequestBuilder = http("Get users")
    .get("/users")
    .header(Authorization, "Bearer #{token}")
    .check(status.is(200))

}
