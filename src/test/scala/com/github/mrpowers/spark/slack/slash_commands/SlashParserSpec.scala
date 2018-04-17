package com.github.mrpowers.spark.slack.slash_commands

import org.scalatest.FunSpec

class SlashParserSpec extends FunSpec {

  describe("slashResponse") {

    it("creates a SlashResponse from a JSON string") {
      val json = """{"token":"gIkuvaNzQIHg97ATvDxqgjtO","team_id":"T0001","team_domain":"example","channel_id":"C2147483705","channel_name":"test","user_id":"U2147483697","user_name":"Steve","command":"/weather","text":"94070","response_url":"https://hooks.slack.com/commands/1234/5678"}"""
      val p = new SlashParser(json)
      assert(p.slashResponse.token === "gIkuvaNzQIHg97ATvDxqgjtO")
    }

  }

  describe("textComponents") {

    it("breaks up the text into components") {
      val json = """{"token":"gIkuvaNzQIHg97ATvDxqgjtO","team_id":"T0001","team_domain":"example","channel_id":"C2147483705","channel_name":"test","user_id":"U2147483697","user_name":"Steve","command":"/weather","text":"this is some stuff","response_url":"https://hooks.slack.com/commands/1234/5678"}"""
      val p = new SlashParser(json)
      assert(p.textComponents === Array("this", "is", "some", "stuff"))
    }

  }

  describe("user_id") {

    it("gets the user_id") {
      val json = """{"token":"gIkuvaNzQIHg97ATvDxqgjtO","team_id":"T0001","team_domain":"example","channel_id":"C2147483705","channel_name":"test","user_id":"U2147483697","user_name":"Steve","command":"/weather","text":"this is some stuff","response_url":"https://hooks.slack.com/commands/1234/5678"}"""
      val p = new SlashParser(json)
      assert(p.slashResponse.user_id === "U2147483697")
    }

  }

}
