package com.awesome.testing.feeder

import com.awesome.testing.util.RandomUtil

object EmailFeeder {
  val emailFeeder: Iterator[Map[String, String]] = Iterator.continually {
    Map(
      "to" -> s"${RandomUtil.randomString(6)}@foo.com",
      "message" -> RandomUtil.randomString(6),
      "subject" -> RandomUtil.randomString(6)
    )
  }

}
