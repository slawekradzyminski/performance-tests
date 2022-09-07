package com.awesome.testing.feeder

import scala.util.Random

object CredentialsFeeder {

  val userData = Iterator.continually {
    Map(
      "email" -> s"${Random.alphanumeric.take(5).mkString}@foo.com",
      "firstName" -> Random.alphanumeric.take(5).mkString,
      "lastName" -> Random.alphanumeric.take(5).mkString,
      "username" -> Random.alphanumeric.take(5).mkString,
      "password" -> Random.alphanumeric.take(5).mkString
    )
  }

}
