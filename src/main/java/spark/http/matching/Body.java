/*
 * Copyright 2016 - Per Wendel
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package spark.http.matching;

import java.io.IOException;
import java.io.OutputStream;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import spark.Request;
import spark.Response;
import spark.serialization.SerializerChain;
import spark.utils.GzipUtils;

/**
 * Represents the 'body'
 */
public final class Body {
    private Object content;

    public static Body create() {
        return new Body();
    }

    private Body() {
    }

    public boolean notSet() {
        return content == null;
    }

    public boolean isSet() {
        return content != null;
    }

    public Object get() {
        return content;
    }

    public void set(Object content) {
        this.content = content;
    }

    public void serializeTo(HttpServletResponse httpResponse,
                            SerializerChain serializerChain,
                            HttpServletRequest httpRequest, Request requestWrapper, Response responseWrapper) throws IOException {

        if (!httpResponse.isCommitted()) {
            if (httpResponse.getContentType() == null) {
                httpResponse.setContentType("text/html; charset=utf-8");
            }

            // Check if GZIP is wanted/accepted and in that case handle that
            OutputStream responseStream = GzipUtils.checkAndWrap(httpRequest, httpResponse, true);

            // Serialize the body to output stream
            serializerChain.process(responseStream, content, requestWrapper, responseWrapper);

            responseStream.flush(); // needed for GZIP stream. Not sure where the HTTP response actually gets cleaned up
            responseStream.close(); // needed for GZIP
        }
    }
}
