package com.awesome.testing.request

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object Email {

  val emailRequest: HttpRequestBuilder = http("Mail request")
    .post("/email")
    .body(ElFileBody("bodies/email.json")).asJson
    .check(status.is(200))

}