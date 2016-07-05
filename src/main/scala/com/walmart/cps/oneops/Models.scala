package com.walmart.cps.oneops

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import com.walmart.cps.oneops.config.Config
import org.json4s.JsonAST.JString
import org.json4s.native.JsonMethods._
import org.json4s.native.Serialization
import org.json4s.{CustomSerializer, NoTypeHints, StringInput}

import scalaj.http.{Http, HttpOptions, HttpRequest}

/**
  * Created by wal-mart on 7/4/16.
  *
  * @author: wal-mart
  * @author: grosal3
  */
case class Organization(id: Long, name: String, createdAt: LocalDateTime, updatedAt: LocalDateTime,
                        cmsId: Long, assemblies: Boolean, catalogs: Boolean,
                        services: Boolean, announcement: String, fullName: String,
                        var config: Option[Config],
                        var headers: Option[Map[String, String]]) {

  def assemblyList(): List[Assembly] = {
    val request: HttpRequest = Http(s"${config.get.siteUrl}/${name}/assemblies")
      .headers(headers.get)
      .option(HttpOptions.allowUnsafeSSL)
    val response: String = request.asString.body
    implicit val formats = Serialization.formats(NoTypeHints) + new LocalDateTimeSerializer
    val result: List[Assembly] = parse(new StringInput(response)).extract[List[Assembly]]
    result.foreach(ass => {
      ass.config = config
      ass.headers = headers
    })
    result
  }

  def assembly(name:String): Option[Assembly] = {
    val result:Option[Assembly] = assemblyList().find(_.ciName == name)
    result.foreach(assembly => {
      assembly.headers = headers
      assembly.config = config
    })
    result
  }
}


class LocalDateTimeSerializer extends CustomSerializer[LocalDateTime](format => ( {
  case JString(s) =>

    LocalDateTime.parse(s, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"))
}, {
  case x: LocalDateTime =>
    JString(x.format(DateTimeFormatter.ISO_INSTANT))
}
  ))

case class Assembly(ciId: Long, ciName: String, ciClassName: String, impl: String,
                    nsPath: String, ciGoid: String, comments: String, ciState: String,
                    lastAppliedRfcId: Long, createdBy: String, updatedBy: String,
                    created: Long, updated: Long, nsId: Long, ciAttributes: OneOpsAttribute,
                    attrProps: AttributeProperties,
                    var config: Option[Config],
                    var headers: Option[Map[String, String]] ){



}

case class OneOpsAttribute(owner: String, description: String)

case class AttributeProperties()
