package com.walmart.cps.oneops.service

/**
  * Created by gary on 7/2/2016.
  */
trait DefaultService {

  //
  //
  //  {
  //    val c = new ConfigBuilder().withCredentials("1", "2").withOrganization("site").withSiteUrl("url").build()
  //
  //    oneops = new Oneops(config)
  //
  //    organization = oneops.organizations()
  //    organization = oneops.organization("organization name")
  //
  //    assemblies = organization.assemblies()
  //    assembly = organization.assembly("assembly")
  //
  //    assembly = new AssemblyCreator(organization).name("").comments("").description("").owner("email").create()
  //
  //    variable = new VariableCreator(assembly).name("name").value("value").encrypted(false).create()
  //
  //    variable = new VariableUpdator(platform).name("name").value("value").encrypted(true).update()
  //
  //    platform = new PlatformCreator(assembly).comments("").source("").description("").majorVersion("").packName("").version("").create()
  //    components = platform.components()
  //    component = platform.component("")
  //    platform.deleteComponnent("")
  //
  //    component = new ComponentUpdater(platform).template(componentTemplate).update()
  //
  //    componentTemplate = platform.newComponentTemplate("type")
  //    component = new ComponentCreator(platform).template(componentTemplate).create()
  //
  //    attachmentTemplate = component.createAttachmentTemplate()
  //    attachment = new AttachmentCreator(component).template(attachmentTemplate).create()
  //    attachment = new AttachmentUpdator(component).template(attachmentTemplate).update()0
  //
  //
  //    releases = assembly.releases()
  //    assembly.commit("releaseId")
  //    assembly.discard("releaseId")
  //
  //
  //
  //    platforms = assembly.platforms()
  //    platform = assembly.platform("name")
  //
  //    transitions = assembly.transitions()
  //
  //
  //    environments = assembly.environments()
  //    environment = assembly.environment("environment")
  //
  //  }
}
