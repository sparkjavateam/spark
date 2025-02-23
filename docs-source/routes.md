# Routes

Main part is serving routes. The class
`spark.Spark` ([Javadoc](https://javadoc.io/doc/io.github.sparkjavateam/spark-core/latest/spark/Spark.html))
defines a static method for every HTTP verb:

- get
- post
- put
- delete
- patch
- connect
- head
- options
- trace

## Path
The first argument is the path. The path is the path after the host name (or part of it). The path can contain parameters
(e.g. `/book/:id/edit`) and wildcards (`/product/*`).

## Route
An object that implements [Route](https://javadoc.io/doc/io.github.sparkjavateam/spark-core/latest/spark/Route.html) or TemplateViewRoute is also always an argument. Typically, a route is defined as
`(req, res) -> code_returning_the_response`, where req is the [Request](request.html) object and res is the
[Response](request.html) object. The return value is an Object. Often it is HTML or JSON. If the route wants to return nothing
you can return `null`.

## ResponseTransformer
Use the HTTP verb methods with a ResponseTransformer argument if you want to transform the response object (to a String).
A typical use case is that a route returns a data object and a JsonTransformer transforms this object into a JSON string.

```
import com.google.gson.Gson;

public class JsonTransformer implements ResponseTransformer {
  private static final Gson gson = new Gson();

  @Override
  public String render(Object model) {
    return gson.toJson(model);
  }
}
```

## Accept Type
If you specify a MIME type as the Accept Type String, HTTP verb methods will only be called if the caller has also specified
this MIME type in the Accept attribute of the HTTP request.

- text/plain
- text/html
- text/xml (or application/xml)
- text/csv
- application/json
- application/pdf
- application/zip
- image/png
- image/jpeg
