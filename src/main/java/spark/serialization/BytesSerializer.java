/*
 * Copyright 2015 - Per Wendel
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
package spark.serialization;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

import spark.Request;
import spark.Response;

/**
 * @author alex
 */
class BytesSerializer extends Serializer {

    @Override
    public boolean canProcess(Object element) {
        return element instanceof byte[] || element instanceof ByteBuffer;
    }

    @Override
    public void process(OutputStream outputStream, Object element, Request request, Response response)
            throws IOException {
        byte[] bytes = null;
        if (element instanceof byte[] el) {
            bytes = el;
        } else if (element instanceof ByteBuffer bb) {
            bytes = bb.array();
        }
        outputStream.write(bytes);
    }
}
