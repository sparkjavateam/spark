package spark.embeddedserver.jetty;

import org.eclipse.jetty.server.handler.ErrorHandler;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import spark.CustomErrorPages;
import spark.Request;
import spark.RequestResponseFactory;
import spark.Response;
import spark.http.matching.Body;
import spark.http.matching.MatcherFilter;
import spark.serialization.SerializerChain;

public class JettyErrorHandler extends ErrorHandler {
    private final MatcherFilter matcherFilter;

    public JettyErrorHandler(MatcherFilter matcherFilter) {
        this.matcherFilter=matcherFilter;
    }

    @Override
    protected void generateAcceptableResponse(org.eclipse.jetty.server.Request baseRequest, HttpServletRequest servletRequest,
                                              HttpServletResponse servletResponse, int code, String message, String contentType) throws IOException {
        if (CustomErrorPages.existsFor(code)) {
            Request request = RequestResponseFactory.create(servletRequest);
            Response response = RequestResponseFactory.create(servletResponse);
            SerializerChain serializer = matcherFilter.getSerializerChain();
            Object page = CustomErrorPages.getFor(code, request, response);
            Body body = Body.create();
            body.set(page);
            body.serializeTo(servletResponse, serializer, servletRequest, request, response);
        } else {
            super.generateAcceptableResponse(baseRequest, servletRequest, servletResponse, code, message, contentType);
        }
    }
}
