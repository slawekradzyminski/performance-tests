package com.awesome.testing.util

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.afterburner.AfterburnerModule
import com.fasterxml.jackson.module.scala.DefaultScalaModule

import scala.reflect.{ClassTag, classTag}

object JacksonJsonUtil {
  private val objectMapper =
    new ObjectMapper()
      .registerModule(DefaultScalaModule)
      .registerModule(new Jdk8Module)
      .registerModule(new JavaTimeModule)
      .registerModule(new AfterburnerModule)

  def writeToMap[V](value: String): Map[String, V] = objectMapper.readValue(value, classOf[Map[String, V]])

  def toJson(value: Map[Symbol, Any]): String = {
    toJson(value map { case (k, v) => k.name -> v })
  }

  def toJson(value: Any): String = {
    objectMapper.writeValueAsString(value)
  }

  def fromJson[T: ClassTag](json: String): T = {
    objectMapper.readValue[T](json, classTag[T].runtimeClass.asInstanceOf[Class[T]])
  }
}