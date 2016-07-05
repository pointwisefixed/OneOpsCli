package com.walmart.cps.oneops.config


/**
  * Created by gary on 7/2/2016.
  */
case class Config(credential:Credential, siteUrl: String, organization: String)

class ConfigBuilder{

  private var credential:Credential = null
  private var siteUrl:String = null
  private var organization:String = null

  def build():Config = {
    new Config(credential, siteUrl, organization)
  }


  def withCredentials(authToken:String, password:String):ConfigBuilder = {
    this.credential = new Credential(authToken, password)
    this
  }

  def withSiteUrl(siteUrl:String):ConfigBuilder = {
    this.siteUrl = siteUrl
    this
  }

  def withOrganization(organization:String):ConfigBuilder = {
    this.organization = organization
    this
  }
}

case class Credential(username: String, password: String)


