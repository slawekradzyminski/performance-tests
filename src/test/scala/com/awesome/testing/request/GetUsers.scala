package com.awesome.testing.request

import com.awesome.testing.util.Authorization.{authValue, Authorization}
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object GetUsers {

  val getUsersRequest: HttpRequestBuilder = {
    http("Get all users request")
      .get("/users")
      .header(Authorization, authValue)
      .check(status.is(200))
  }

  val getUsersAsAdminRequest: HttpRequestBuilder = {
    getUsersRequest
      .check(jsonPath("$..username").findAll.optional.saveAs("usernames"))
  }

}
