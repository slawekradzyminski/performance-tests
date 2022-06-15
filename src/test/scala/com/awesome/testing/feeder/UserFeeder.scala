package com.awesome.testing.feeder

import scala.util.Random

object UserFeeder {

  val userFeeder: Iterator[Map[String, String]] = Iterator.continually {
    Map(
      "email" -> s"${getRandomString}@foo.com",
      "username" -> getRandomString,
      "password" -> getRandomString,
      "firstName" -> getRandomString,
      "lastName" -> getRandomString
    )
  }

  private def getRandomString = {
    Random.alphanumeric.take(5).mkString
  }
}
