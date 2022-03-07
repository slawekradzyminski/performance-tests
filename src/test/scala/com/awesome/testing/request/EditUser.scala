package com.awesome.testing.request

import com.awesome.testing.util.Authorization.{Authorization, authValue}
import com.awesome.testing.util.BodyUtil.stringBody
import com.awesome.testing.util.RandomUtil.randomString
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object EditUser {

  val editUserRequest: HttpRequestBuilder = http("Edit user request")
    .put("/users/" + "#{username}")
    .header(Authorization, authValue)
    .body(stringBody(requestBody()))
    .check(status.is(200))

  private def requestBody() = {
    session: Session =>
      Map(
        "email" -> session("email").as[String],
        "firstName" -> randomString(10),
        "lastName" -> randomString(10),
        "username" -> randomString(10),
        "roles" -> List("ROLE_CLIENT")
      )
  }
}
