package com.walmart.cps.omeops

import com.walmart.cps.oneops.{Oneops, Organization}
import com.walmart.cps.oneops.config.{Config, ConfigBuilder}
import org.scalatest._

/**
  * Created by wal-mart on 7/4/16.
  *
  * @author: wal-mart
  * @author: grosal3
  */
class OneopsSpec extends FlatSpec {

  val config: Config = new ConfigBuilder()
    .withCredentials("", "")
    .withSiteUrl("").build()

  val organizationName:String = ""

  "A Call To Get All Organizations" should "have size greater than 0" in {
    val o: Oneops = new Oneops(config)
    assert(o.organizations().nonEmpty)
  }

  "A Call to Get All Assemblies in the organization" should "have a size greater than 0" in {
    val o: Oneops = new Oneops(config)
    assert(o.organization(organizationName).map(_.assemblyList()).nonEmpty)
  }

}
