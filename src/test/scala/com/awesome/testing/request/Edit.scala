package com.awesome.testing.request

import com.awesome.testing.util.BodyUtil.stringBody
import com.awesome.testing.util.RandomUtil.randomString
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
        "email" -> s"${randomString(5)}@foo.com",
        "firstName" -> randomString(5),
        "lastName" -> randomString(5),
        "username" -> session("username").as[String],
        "roles" -> List("ROLE_CLIENT")
      )
    }
  }
}
