# Release Notes

## 2.10.0

This is the first release by sparkjavateam.
Highlights are **Java 17**, **Jetty 11**, virtual threads and a new website.
Updating to Jetty 12 would be a too big change for this release.

- #1: [New website](https://sparkjavateam.github.io/spark), Powermock removed, testcases removed: StaticFilesFromArchiveTest, WebSocketServletContextHandlerFactoryTest, ServletFlagTest
- #2: Moved [examples](https://sparkjavateam.github.io/spark/examples.html) from README.md to website
- #3: Set cookie name. If multiple webapps run on one host, they have the same session ID cookie. Use this code to give each app a unique cookie name: `EmbeddedServers.add(EmbeddedServers.Identifiers.JETTY, new EmbeddedJettyFactory().withCookieName("SESSIONID_" + appName));`
- #6: Update Jetty version. Minimum Java version is now 17. Package changes from javax.servlet to jakarta.servlet.
- #7: Expose SerializerChain
- #8: Allow setting servlet event listeners
- #9: Virtual threads (You need Java >= 19 if you want to use this feature.)
- #10: Java Module support
- #11: Fix Spark error pages when there are websocket routes
- #12: Update some versions: Jetty 11.0.24, slf4j 2.0.17, ...
- Set response body in after after

## 2.9.4

The release 2.9.4 is identical to the last release 2.9.4 by Per Wendel.
This version serves as a starting point for the transition to our Spark source. Please change the Mavencentral coordinates to:

Maven
```
<dependency>
    <groupId>io.github.sparkjavateam</groupId>
    <artifactId>spark-core</artifactId>
    <version>2.9.4</version>
</dependency>
```

Gradle
```
implementation 'io.github.sparkjavateam:spark-core:2.9.4'
```

- PW#1261: Update Jetty to 9.4.48.v20220622
- PW#1201: Update Jetty to 9.4.33.v20201020 to fix CVE-2020-27216
- PW#1197: added trustForwardHeaders method to decide if to trust HTTP forward headers
- PW#1146: webSocketIdleTimeoutMillis should handle Long instead of Integer

## Older versions
See [Mavencentral](https://repo1.maven.org/maven2/com/sparkjava/spark-core/) for older versions.

----

## More information about the sparkjavateam fork

This is a fork of Per Wendel's software Spark.
Please note the NOTICE file in the repository.
Changes that we have made since the fork are fully included in the history of the Github repository sparkjavateam/spark.
In contrast to contribution forks and forks by individuals, our aim here is to achieve the official continuation of the project.
Contributors who contribute a lot or important things can become maintainers and then have an equal say in the further development of Spark.
The project is not an authorized continuation because Per Wendel never responded to requests.
The website is also down.
See also [PW#1291 "Is the project dead?"](https://github.com/perwendel/spark/issues/1291).
We assume that he does not want to invest any more work in this project.
