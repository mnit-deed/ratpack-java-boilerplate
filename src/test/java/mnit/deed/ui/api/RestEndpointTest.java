package mnit.deed.ui.api;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ratpack.test.MainClassApplicationUnderTest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ratpack.test.MainClassApplicationUnderTest;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class RestEndpointTest {

  String lineSeparator = System.getProperty("line.separator");

  MainClassApplicationUnderTest aut = new MainClassApplicationUnderTest(RestEndpoint.class);

  @After
  public void tearDown() {
    aut.close();
  }

  @Test
  public void rootHandler() throws Exception {
    // assertEquals("root handler!", aut.getHttpClient().getText());
    // assertEquals("root handler!", aut.getHttpClient().getText("unknown-path"));
    assertEquals("Client error 404", aut.getHttpClient().getText());
    assertEquals("Client error 404", aut.getHttpClient().getText("unknown-path"));
  }

  @Test
  public void healthCheckHandler() throws Exception {
    assertEquals("status : HEALTHY", aut.getHttpClient().getText("health"));
    assertEquals("status : HEALTHY", aut.getHttpClient().getText("health/status"));
  }

}
