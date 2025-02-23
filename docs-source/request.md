# Request, Response

## Request
The [Request](https://javadoc.io/static/io.github.sparkjavateam/spark-core/2.9.4/spark/Request.html)
object retrieves the information sent with the HTTP request.

### Parameters
Use `req.params(name)` to access a path parameter.

```
Spark.get("/book/:id", (req, res) -> "received ID " + req.params("id"));
```

Use `req.params()` for getting all parameters as Map.

### Wildcards
Use `req.splat()` to access the wildcard path parameters.

### Sent message
A message sent using e.g. the POST verb can be retrieved using `req.body()` (or `req.bodyAsBytes()`).

### Query parameters and form data
Use `req.queryParams(name)` to access a query parameter that is part of the URL:

`http://server:4567/path?name=value&name2=value2`

```
req.queryParams("name");  // = "value"
req.queryParams("name2"); // = "value2"
```

`queryParams(name)` is also used for form data sent e.g. by a POST message.

See [Javadoc](https://javadoc.io/static/io.github.sparkjavateam/spark-core/2.9.4/spark/Request.html) for more query... methods.

### Cookies
Use `req.cookies()` or `req.cookie(name)` to read cookies. The Response object has methods for writing cookies.

### Session
Use `req.session([create])` to read/write session attributes.

### Other methods
See [Javadoc](https://javadoc.io/static/io.github.sparkjavateam/spark-core/2.9.4/spark/Request.html) for other methods, especially
for getting information about the request.

----

## Response
The [Response](https://javadoc.io/static/io.github.sparkjavateam/spark-core/2.9.4/spark/Response.html)
object receives the response data.

Using the `res.redirect(path)` method, the client (browser) can be redirected to a new URL. For creating route aliases you
can use the [Redirect API](https://javadoc.io/static/io.github.sparkjavateam/spark-core/2.9.4/spark/Redirect.html)
using `import static spark.Spark.redirect`. Example: `redirect.get("/old-path", "/v2/new-path");`

Use `res.status(int)` for setting the response HTTP status code ([Wikipedia](https://en.wikipedia.org/wiki/List_of_HTTP_status_codes)),
e.g. `req.status(401);`

Use `res.type(mimeType)` for setting the content type of the response.
