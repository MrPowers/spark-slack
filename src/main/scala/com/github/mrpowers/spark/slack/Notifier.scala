package com.github.mrpowers.spark.slack

import net.gpedro.integrations.slack.{SlackApi, SlackMessage}

class Notifier(webhookUrl: String) {

  val slackApi = new SlackApi(webhookUrl)

  def speak(text: String, channel: String, icon: String, username: String) {
    val slackMessage = new SlackMessage()
    slackMessage.setChannel(channel)
    slackMessage.setIcon(icon)
    slackMessage.setText(text)
    slackMessage.setUsername(username)
    slackApi.call(slackMessage)
  }

}
