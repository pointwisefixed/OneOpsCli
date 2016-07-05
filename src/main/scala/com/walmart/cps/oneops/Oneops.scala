package com.walmart.cps.oneops

import com.walmart.cps.oneops.config.Config
import org.json4s._
import org.json4s.native.JsonMethods._
import org.json4s.native.Serialization

import scalaj.http._

/**
  * Created by gary on 7/4/2016.
  */


case class Oneops(config: Config) {

  def defaultHeaders: Map[String, String] = {
    Map("Authorization" -> s"Basic ${Base64.encodeString(s"${config.credential.username}:${config.credential.password}")}",
      "Content-Type" -> "application/json",
      "Accept" -> "application/json")
  }

  def organizations(): List[Organization] = {
    val request: HttpRequest = Http(s"${config.siteUrl}/account/organizations")
        .headers(defaultHeaders)
      .option(HttpOptions.allowUnsafeSSL)
    val response: String = request.asString.body
    implicit val formats = Serialization.formats(NoTypeHints) + new LocalDateTimeSerializer
    val orgs:List[Organization] = parse(new StringInput(response)).camelizeKeys.extract[List[Organization]]
    orgs.foreach(org => { org.oneops = Some(this)})
    orgs
  }

  def organization(orgName: String): Option[Organization] = {
    val organization:Option[Organization] = organizations().find(_.name == orgName)
    organization.foreach(_.oneops = Some(this))
    organization
  }


}
