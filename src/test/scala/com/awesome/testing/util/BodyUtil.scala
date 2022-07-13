package com.awesome.testing.util

import com.awesome.testing.util.JacksonJsonUtil.toJson
import io.gatling.core.Predef.{Session, StringBody}
import io.gatling.core.body.Body
import io.gatling.core.session.Expression
import io.gatling.core.Predef._

object BodyUtil {

  def stringBody(bodySupplier: Session => Any): Body with Expression[String] = {
    StringBody(session => toJson(bodySupplier(session)))
  }

  def stringBody(bodySupplier: () => Any): Body with Expression[String] = {
    StringBody(toJson(bodySupplier()))
  }

}
