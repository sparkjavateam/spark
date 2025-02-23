# Release Notes

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
