package com.awesome.testing.request

import com.awesome.testing.util.Authorization.Authorization
import com.awesome.testing.util.BodyUtil.stringBody
import com.awesome.testing.util.RandomUtil.randomString
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object EditUserRequest {

  val editUserRequest: HttpRequestBuilder = http("Edit user request")
    .put("/users/#{username}")
    .header(Authorization, "Bearer #{token}")
    .body(stringBody(body()))
    .check(status.is(200))

  def body(): Session => Map[String, Serializable] = {
    session: Session => {
      Map(
        "email" -> s"${randomString(6)}@foo.com",
        "firstName" -> randomString(6),
        "lastName" -> randomString(6),
        "username" -> session("username").as[String],
        "roles" -> List("ROLE_CLIENT")
      )
    }
  }

}
