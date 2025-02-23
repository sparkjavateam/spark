# Start and stop the server
Spark is started automatically. `Spark.init()` only needs to be called if no routes have been defined.
Certain methods (e.g. port()) must be called before routes are defined. `Spark.stop()` is used for stopping the server.

## Port
Call `Spark.port(8080)` to set the port to 8080.
