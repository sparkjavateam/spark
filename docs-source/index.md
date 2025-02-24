# Spark

Micro web framework for Java

## Hello World example

```
import static spark.Spark.*;

public class HelloWorld {
  public static void main(String[] args) {
    get("/hello", (req, res) -> "Hello World");
  }
}
```

View in browser: http://localhost:4567/hello

## About
Spark is a Java framework that makes it very easy to write web applications.
It was inspired by the micro web framework "[Sinatra](https://sinatrarb.com)" developed in Ruby.
Spark is often used for creating REST APIs. Spark is also used for websites that serve many, many users.
Spark uses the embedded servlet container Eclipse Jetty.

This framework is also called Sparkjava to avoid confusion with Apache Spark.

Spark has been primarily developed by Per Wendel since 2011.
Since he is obviously no longer continuing it, we have created a **community-driven** fork.
[More supporters are welcome!](contribute.html)

[Release Notes](release-notes.html)

++ This website is still under construction. ++

## Java version
Main support is for **Java 17**. It also works and is tested for Java 11 LTS and Java 21 LTS. It might work for other versions >= 8.

## License
[Apache License 2.0](https://github.com/sparkjavateam/spark/blob/master/LICENSE)
