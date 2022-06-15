package com.awesome.testing.request

import com.awesome.testing.feeder.UserFeeder.getRandomString
import com.awesome.testing.util.BodyUtil.stringBody
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object Edit {

  val editUserRequest: HttpRequestBuilder = http("Edit user request")
    .put("/users/#{username}")
    .header("Authorization", "Bearer #{token}")
    .body(stringBody(bodySupplier()))
    .check(status.is(200))

  def bodySupplier(): Session => Map[String, Serializable] = {
    session: Session => {
      Map(
        "email" -> s"${getRandomString}@foo.com",
        "firstName" -> getRandomString,
        "lastName" -> getRandomString,
        "username" -> session("username").as[String],
        "roles" -> List("ROLE_CLIENT")
      )
    }
  }
}
