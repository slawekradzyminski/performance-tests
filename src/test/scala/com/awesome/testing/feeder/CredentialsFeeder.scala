package com.awesome.testing.feeder

import com.awesome.testing.util.RandomUtil.randomString

object CredentialsFeeder {

  val userFeeder: Iterator[Map[String, String]] = Iterator.continually {
    Map(
      "email" -> s"${randomString(6)}@foo.com",
      "username" -> randomString(6),
      "password" -> randomString(6),
      "firstName" -> randomString(6),
      "lastName" -> randomString(6),
    )
  }

}
