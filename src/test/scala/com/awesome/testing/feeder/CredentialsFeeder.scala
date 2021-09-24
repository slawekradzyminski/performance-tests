package com.awesome.testing.feeder

import com.awesome.testing.util.RandomUtil.randomString

object CredentialsFeeder {

  val credentialsFeeder: Iterator[Map[String, String]] = Iterator.continually(Map(
    "firstName" -> randomString(8),
    "lastName" -> randomString(8),
    "username" -> randomString(8),
    "password" -> randomString(8),
    "email" -> (randomString(8) + "@gatling.com"),
  ))

}
