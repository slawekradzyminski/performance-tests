package com.awesome.testing.feeder

import com.awesome.testing.util.RandomUtil.randomString

object CredentialsFeeder {

  private val gatling = "gatling"

  val credentialsFeeder: Iterator[Map[String, String]] = Iterator.continually {
    Map(
      "firstName" -> (gatling + randomString(8)),
      "lastName" -> (gatling + randomString(8)),
      "username" -> (gatling + randomString(8)),
      "password" -> (gatling + randomString(8)),
      "email" -> (gatling + randomString(8) + "@gatling.com"),
    )
  }

}
