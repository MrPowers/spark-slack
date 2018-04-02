package com.github.mrpowers.spark.slack.slash_commands

import org.json4s._
import org.json4s.native.JsonMethods._

class SlashParser(responseJson: String) {

  implicit val formats = org.json4s.DefaultFormats

  def buildSlashResponse(): SlashResponse = {
    parse(responseJson).extract[SlashResponse]
  }

}
