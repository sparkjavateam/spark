# More about routes

## Filter
Use `Spark.before()` to process a request before the Route is called.
Typically, this filter is used to protect routes that are only allowed to be accessed by logged in users.

Use `Spark.after()` to process a request after the Route is called.

Use `Spark.afterAfter()` to process a request after the after filters even in case of an exception. It's like a finally block.


## Halt
Use `Spark.halt()` to stop a request immediately inside a filter or route.
A typical use case is calling halt() in the before filter if the user login failed.

## Error handling
Use `Spark.notFound(html)` to send your own status 404 "page not found" error page.

To react on any uncatched exception use `Spark.exception(YourException.class, (exception, req, res) -> { ... })`.
Don't call halt() in such exception handling.

## Static files
A website typically needs static files such as CSS and JavaScript files. Spark can deliver these files without routes.
To do this, place the files in the folder src/main/resources/web, for example. If the file css/site.css is located there,
it can be loaded in the browser via "http://localhost:4567/css/site.css".

Use `Spark.staticFiles.location("web")` for defining your base folder inside src/main/resources that contains
static files to be served by Spark.
Also use `Spark.staticFiles.externalLocation("src/main/resources/web")` if you are in IDE mode. The first method
is for files inside the Classpath, the second for files outside the Classpath. Call these methods _before_ your route definitions. If
there are no routes you have to call `Spark.init()` to start the server.

## Compress communication
GZIP is done automatically if it's in both the request and the response headers. This usually only means that you have to set it
in your response headers.

If you want to GZIP a single response, you can add it manually to your route:

```
Spark.get(path, (req, res) -> {
  // ...
  res.header("Content-Encoding", "gzip");
});
```

If you want to GZIP everything, you can use
`Spark.after((req, res) -> res.header("Content-Encoding", "gzip"));`

