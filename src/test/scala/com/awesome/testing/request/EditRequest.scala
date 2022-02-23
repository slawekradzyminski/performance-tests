package com.awesome.testing.request

import com.awesome.testing.util.Authorization.{Authorization, authValue}
import com.awesome.testing.util.BodyUtil.stringBody
import com.awesome.testing.util.RandomUtil.randomString
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object EditRequest {

  val editRequest: HttpRequestBuilder = http("Edit request")
    .put("/users/" + "#{username}")
    .header(Authorization, authValue)
    .body(stringBody(requestBody()))
    .check(status.is(200))

  private def requestBody() = {
    session: Session => {
      Map(
        "email" -> (randomString(8) + "@ocado.com"),
        "firstName" -> randomString(8),
        "lastName" -> randomString(8),
        "username" -> session("username").as[String],
        "roles" -> List("ROLE_CLIENT")
      )
    }
  }
}
