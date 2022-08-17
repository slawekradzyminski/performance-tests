package com.awesome.testing.request

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object GetAllUsers {

  val getAllUsers: HttpRequestBuilder = http("Get all users request")
    .get("/users")
    .header("Authorization", "Bearer #{token}")
    .check(status.is(200))

}
