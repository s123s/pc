package pc;

import org.junit.After;
import org.junit.Test;

public class IntegrationTest {
  @org.junit.Before
  public void setUp() throws Exception {
      System.out.println("setUp");

  }

  @After
  public void tearDown() throws Exception {

      System.out.println("tearDown ");

  }

  @Test
  public void testfirst() throws Exception {
      System.out.println("testfirst");

  }
  @Test
  public void testsecond() throws Exception {
      System.out.println("testsecond");
//      Assert.fail();
  }

}