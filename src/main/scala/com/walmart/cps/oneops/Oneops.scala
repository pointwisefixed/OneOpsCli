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

  def organizations(): List[Organization] = {
    val request: HttpRequest = Http(s"${config.siteUrl}/account/organizations")
      .header("Authorization", s"Basic ${Base64.encodeString(s"${config.credential.username}:${config.credential.password}")}")
      .header("Content-Type", "application/json")
      .header("Accept", "application/json")
      .option(HttpOptions.allowUnsafeSSL)
    val response: String = request.asString.body
    implicit val formats = Serialization.formats(NoTypeHints) + new LocalDateTimeSerializer
    parse(new StringInput(response)).camelizeKeys.extract[List[Organization]]
  }


}
