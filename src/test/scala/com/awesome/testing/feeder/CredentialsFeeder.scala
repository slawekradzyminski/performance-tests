package com.awesome.testing.feeder

import com.awesome.testing.util.RandomUtil.randomString

object CredentialsFeeder {

  val credentialsFeeder: Iterator[Map[String, String]] = Iterator.continually {
    Map(
      "email" -> s"${randomString(6)}@ocado.com",
      "firstName" -> randomString(6),
      "lastName" -> randomString(6),
      "username" -> randomString(6),
      "password" -> randomString(6)
    )
  }

}
