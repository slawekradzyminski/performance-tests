package com.awesome.testing.util

import scala.util.Random

object RandomUtil {

  private val rnd = new Random()

  def randomString(length: Int): String = {
    rnd.alphanumeric.filter(_.isLetter).take(length).mkString
  }

}
