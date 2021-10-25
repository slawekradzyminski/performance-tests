package com.awesome.testing.request

import com.awesome.testing.util.Authorization.{Authorization, authValue}
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object DeleteUser {

  def deleteUserRequest(username: String): HttpRequestBuilder = {
    http("Delete user")
      .delete(s"/users/$username")
      .header(Authorization, authValue)
      .check(status.is(204))
  }

}
