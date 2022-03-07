package com.awesome.testing

import io.gatling.app.Gatling
import io.gatling.core.config.GatlingPropertiesBuilder

object GatlingRunner {

  def main(args: Array[String]): Unit = {

    val simClass = classOf[BasicSimulation].getName
    val props = new GatlingPropertiesBuilder
    props.simulationClass(simClass)
    Gatling.fromMap(props.build)

  }

}