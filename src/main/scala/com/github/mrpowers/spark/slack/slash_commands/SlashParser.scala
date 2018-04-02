package com.github.mrpowers.spark.slack.slash_commands

import spray.json._

class SlashParser(responseJson: String) {

  def buildSlackSlashCommandResponse(json: String): SlashResponse = {
    json.parseJson.convertTo[SlashResponse]
  }

}
