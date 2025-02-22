# Release Notes

## Version 2.9.4

Our release 2.9.4 corresponds to release 2.9.4 from Per Wendel's repository. This release represents the starting point for switching to this repository. Change your Mavencentral coordinates to:

Maven
```xml
<dependency>
    <groupId>io.github.sparkjavateam</groupId>
    <artifactId>spark-core</artifactId>
    <version>2.9.4</version>
</dependency>
```

Gradle
```gradle
implementation 'io.github.sparkjavateam:spark-core:2.9.4'
```

- Update Jetty to 9.4.48.v20220622
- #PW1201: Update Jetty to 9.4.33.v20201020 to fix CVE-2020-27216
- #PW1197: added trustForwardHeaders method to decide if to trust HTTP forward headers
- #PW1146: webSocketIdleTimeoutMillis should handle Long instead of Integer
