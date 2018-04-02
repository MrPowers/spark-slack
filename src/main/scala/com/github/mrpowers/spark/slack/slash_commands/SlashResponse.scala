package com.github.mrpowers.spark.slack.slash_commands

case class SlashResponse(
  token: String,
  team_id: String,
  team_domain: String,
  channel_id: String,
  channel_name: String,
  user_id: String,
  user_name: String,
  command: String,
  text: String,
  response_url: String
)
