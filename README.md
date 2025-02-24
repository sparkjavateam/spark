[![](https://img.shields.io/github/license/sparkjavateam/spark.svg)](./LICENSE)
[![](https://img.shields.io/maven-central/v/io.github.sparkjavateam/spark-core.svg)](http://mvnrepository.com/artifact/io.github.sparkjavateam/spark-core)

# Spark - micro web framework for Java

[website](https://sparkjavateam.github.io/spark)

## Spark 2.9.4 is out!

Gradle
```gradle
implementation 'io.github.sparkjavateam:spark-core:2.9.4'
```

Maven
```xml
<dependency>
    <groupId>io.github.sparkjavateam</groupId>
    <artifactId>spark-core</artifactId>
    <version>2.9.4</version>
</dependency>
```

## Getting started

```java
import static spark.Spark.*;

public class HelloWorld {
    public static void main(String[] arg) {
        get("/hello", (request, response) -> "Hello World!");
    }
}
```

View at: http://localhost:4567/hello
