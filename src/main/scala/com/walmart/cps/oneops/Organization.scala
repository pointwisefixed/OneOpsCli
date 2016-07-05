package com.walmart.cps.oneops

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import org.json4s.CustomSerializer
import org.json4s.JsonAST.JString

/**
  * Created by wal-mart on 7/4/16.
  *
  * @author: wal-mart
  * @author: grosal3
  */
case class Organization(id: Long, name: String, createdAt: LocalDateTime, updatedAt: LocalDateTime,
                        cmsId: Long, assemblies: Boolean, catalogs: Boolean,
                        services: Boolean, announcement: String, fullName: String)

class LocalDateTimeSerializer extends CustomSerializer[LocalDateTime](format => ( {
  case JString(s) =>

    LocalDateTime.parse(s, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"))
}, {
  case x: LocalDateTime =>
    JString(x.format(DateTimeFormatter.ISO_INSTANT))
}
  ))
