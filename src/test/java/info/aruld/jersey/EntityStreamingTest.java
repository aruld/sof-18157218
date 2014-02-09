package info.aruld.jersey;

import org.glassfish.jersey.apache.connector.ApacheConnectorProvider;
import org.glassfish.jersey.client.*;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 *  http://stackoverflow.com/questions/18157218/jersey-2-0-content-length-not-set
 */
public class EntityStreamingTest extends JerseyTest {

  private static final Logger LOGGER = Logger.getLogger(EntityStreamingTest.class.getName());

  @Path("/test")
  public static class HttpMethodResource {
    @POST
    @Path("chunked")
    public String postChunked(@HeaderParam("Transfer-Encoding") String transferEncoding, String entity) {
      assertEquals("POST", entity);
      assertEquals("chunked", transferEncoding);
      return entity;
    }

    @POST
    public String postBuffering(@HeaderParam("Content-Length") String contentLength, String entity) {
      assertEquals("POST", entity);
      assertEquals(entity.length(), Integer.parseInt(contentLength));
      return entity;
    }
  }

  @Override
  protected Application configure() {
    ResourceConfig config = new ResourceConfig(HttpMethodResource.class);
    config.register(new LoggingFilter(LOGGER, true));
    return config;
  }

  @Override
  protected void configureClient(ClientConfig config) {
    config.connectorProvider(new ApacheConnectorProvider());
  }

  @Test
  public void testPostChunked() {
    Response response = target().path("test/chunked").request().post(Entity.text("POST"));

    assertEquals(200, response.getStatus());
    assertTrue(response.hasEntity());
  }

  @Test
  public void testPostBuffering() {
    ClientConfig cc = new ClientConfig();
    cc.property(ClientProperties.REQUEST_ENTITY_PROCESSING, RequestEntityProcessing.BUFFERED);
    cc.connectorProvider(new ApacheConnectorProvider());
    JerseyClient client = JerseyClientBuilder.createClient(cc);
    WebTarget target = client.target(getBaseUri());
    Response response = target.path("test").request().post(Entity.text("POST"));

    assertEquals(200, response.getStatus());
    assertTrue(response.hasEntity());
  }
}
