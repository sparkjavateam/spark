module spark {
    exports spark;
    exports spark.utils;
    exports spark.serialization;
    exports spark.embeddedserver;
    exports spark.embeddedserver.jetty;
    exports spark.route;
    exports spark.routematch;
    exports spark.servlet;

    requires java.sql;

    requires org.eclipse.jetty.websocket.jetty.server;
    requires org.eclipse.jetty.websocket.servlet;
    requires org.eclipse.jetty.websocket.core.server;
    requires org.slf4j;
}
