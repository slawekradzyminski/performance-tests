package com.awesome.testing.request

import com.awesome.testing.util.Authorization.Authorization
import com.awesome.testing.util.Authorization.authValue
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object GetAllUsers {

  val getAllUsersRequest: HttpRequestBuilder = http("Get all users")
    .get("/users")
    .header(Authorization, authValue)
    .check(status.is(200))

}
