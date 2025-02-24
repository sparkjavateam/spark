package spark.embeddedserver.jetty;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Map;

import org.eclipse.jetty.server.ConnectionFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.SslConnectionFactory;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.junit.Ignore;
import org.junit.Test;

import spark.Whitebox;
import spark.ssl.SslStores;

public class SocketConnectorFactoryTest {

    @Test
    public void testCreateSocketConnector_whenServerIsNull_thenThrowException() {

        try {
            SocketConnectorFactory.createSocketConnector(null, "host", 80, true);
            fail("SocketConnector creation should have thrown an IllegalArgumentException");
        } catch(IllegalArgumentException ex) {
            assertEquals("'server' must not be null", ex.getMessage());
        }
    }


    @Test
    public void testCreateSocketConnector_whenHostIsNull_thenThrowException() {

        Server server = new Server();

        try {
            SocketConnectorFactory.createSocketConnector(server, null, 80, true);
            fail("SocketConnector creation should have thrown an IllegalArgumentException");
        } catch(IllegalArgumentException ex) {
            assertEquals("'host' must not be null", ex.getMessage());
        }
    }

    @Test
    public void testCreateSocketConnector() {
        final String host = "localhost";
        final int port = 8888;

        Server server = new Server();
        ServerConnector serverConnector = SocketConnectorFactory.createSocketConnector(server, "localhost", 8888, true);

        assertEquals("Server Connector Host should be set to the specified server", host, serverConnector.getHost());
        assertEquals("Server Connector Port should be set to the specified port", port, serverConnector.getPort());
        assertEquals("Server Connector Server should be set to the specified server", server, serverConnector.getServer());
    }

    @Test
    public void testCreateSecureSocketConnector_whenServerIsNull() {

        try {
            SocketConnectorFactory.createSecureSocketConnector(null, "localhost", 80, null, true);
            fail("SocketConnector creation should have thrown an IllegalArgumentException");
        } catch(IllegalArgumentException ex) {
            assertEquals("'server' must not be null", ex.getMessage());
        }
    }

    @Test
    public void testCreateSecureSocketConnector_whenHostIsNull() {

        Server server = new Server();

        try {
            SocketConnectorFactory.createSecureSocketConnector(server, null, 80, null, true);
            fail("SocketConnector creation should have thrown an IllegalArgumentException");
        } catch(IllegalArgumentException ex) {
            assertEquals("'host' must not be null", ex.getMessage());
        }
    }

    @Test
    public void testCreateSecureSocketConnector_whenSslStoresIsNull() {

        Server server = new Server();

        try {
            SocketConnectorFactory.createSecureSocketConnector(server, "localhost", 80, null, true);
            fail("SocketConnector creation should have thrown an IllegalArgumentException");
        } catch(IllegalArgumentException ex) {
            assertEquals("'sslStores' must not be null", ex.getMessage());
        }
    }


    @Ignore // TODO   @PrepareForTest({ServerConnector.class})
    @Test
    public void testCreateSecureSocketConnector() throws  Exception {

        final String host = "localhost";
        final int port = 8888;

        final String keystoreFile = "keystoreFile.jks";
        final String keystorePassword = "keystorePassword";
        final String truststoreFile = "truststoreFile.jks";
        final String trustStorePassword = "trustStorePassword";

        SslStores sslStores = SslStores.create(keystoreFile, keystorePassword, truststoreFile, trustStorePassword);

        Server server = new Server();

        ServerConnector serverConnector = SocketConnectorFactory.createSecureSocketConnector(server, host, port, sslStores, true);

        String internalHost = (String) Whitebox.getInternalState(serverConnector, "_host");
        int internalPort = (int) Whitebox.getInternalState(serverConnector, "_port");

        assertEquals("Server Connector Host should be set to the specified server", host, internalHost);
        assertEquals("Server Connector Port should be set to the specified port", port, internalPort);

        @SuppressWarnings("unchecked")
		Map<String, ConnectionFactory> factories = (Map<String, ConnectionFactory>) Whitebox.getInternalState(serverConnector, "_factories");

        assertTrue("Should return true because factory for SSL should have been set",
                factories.containsKey("ssl") && factories.get("ssl") != null);

        SslConnectionFactory sslConnectionFactory = (SslConnectionFactory) factories.get("ssl");
        SslContextFactory sslContextFactory = sslConnectionFactory.getSslContextFactory();

        assertEquals("Should return the Keystore file specified", keystoreFile,
                sslContextFactory.getKeyStoreResource().getFile().getName());

        assertEquals("Should return the Truststore file specified", truststoreFile,
                sslContextFactory.getTrustStoreResource().getFile().getName());

    }

}
