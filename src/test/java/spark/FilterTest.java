package spark;

import static spark.Spark.afterAfter;
import static spark.Spark.awaitInitialization;
import static spark.Spark.before;
import static spark.Spark.get;
import static spark.Spark.stop;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import spark.util.SparkTestUtil;
import spark.util.SparkTestUtil.UrlResponse;

public class FilterTest {
    static SparkTestUtil testUtil;

    @AfterClass
    public static void tearDown() {
        stop();
    }

    @BeforeClass
    public static void setup() throws IOException {
        testUtil = new SparkTestUtil(4567);

        before("/justfilter", (q, a) -> System.out.println("Filter matched"));
		get("/foo", (req, resp) -> {
			Spark.halt(400, "Exception");
			return "";
		});
		afterAfter("/foo", (req, a) -> {
			Assert.assertEquals("Exception", a.body());
			System.out.println(req);
			System.out.println(a);
		});
        awaitInitialization();
    }

    @Test
    public void testJustFilter() throws Exception {
        UrlResponse response = testUtil.doMethod("GET", "/justfilter", null);

        System.out.println("response.status = " + response.status);
        Assert.assertEquals(404, response.status);
    }

    @Test // by Github user hemil-ruparel-blox
    public void testAfterAfter() throws Exception {
        UrlResponse response = testUtil.doMethod("GET", "/foo", null);
        System.out.println("response.status = " + response.status);
        Assert.assertEquals(400, response.status);
        Assert.assertEquals("Exception", response.body);
    }
}
