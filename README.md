# spark-slack

Speak Slack notifications and handle Slack Slack command responses.

## Accessing the library

The code is accessible via JitPack by adding these lines to your `build.sbt` file:

```
resolvers += "jitpack" at "https://jitpack.io"
libraryDependencies += "com.github.mrpowers" % "spark-slack" % "v0.0.1"
```

The [GitHub releases](https://github.com/MrPowers/spark-slack/releases/) have JAR files attached if you'd like to add the code as a managed dependency.

## Documentation

[Here is a link to the latest documentation](https://mrpowers.github.io).

### Slack notifications

Send messages to a Slack channel as follows:

```
import com.github.mrpowers.spark.slack.Notifier

val notifier = new Notifier("https://hooks.slack.com/services/your_secret_stuff")
notifier.speak("You are amazing", "general", ":wink:", "Frank")
```

### Handle Slack Slash Commands

[Read here](https://api.slack.com/slash-commands) to learn about Slack Slash commands.

Slack Slash commands send JSON responses in this format:

```
token=gIkuvaNzQIHg97ATvDxqgjtO
team_id=T0001
team_domain=example
channel_id=C2147483705
channel_name=test
user_id=U2147483697
user_name=Steve
command=/weather
text=94070
response_url=https://hooks.slack.com/commands/1234/5678
```

The `SlashParser` class converts the JSON response from Slack into a Scala object.

```
import com.github.mrpowers.spark.slack.slash_commands.SlashParser

val json = """{"token":"gIkuvaNzQIHg97ATvDxqgjtO","team_id":"T0001","team_domain":"example","channel_id":"C2147483705","channel_name":"test","user_id":"U2147483697","user_name":"Steve","command":"/weather","text":"94070","response_url":"https://hooks.slack.com/commands/1234/5678"}"""
val p = new SlashParser(json)
p.slashResponse.token // "gIkuvaNzQIHg97ATvDxqgjtO"
```

## How to contribute

Feel free to report bugs or send a pull request.

We're nice and happy to receive any contributions :wink:
