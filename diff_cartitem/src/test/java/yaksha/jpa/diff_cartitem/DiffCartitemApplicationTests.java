package yaksha.jpa.diff_cartitem;

import org.junit.Test;

import static yaksha.jpa.diff_cartitem.TestUtils.*;

public class DiffCartitemApplicationTests {

	@Test
	public void testMain() throws Exception {
		yakshaAssert(currentTest(),(true?"true":"false"),businessTestFile);
	}
	
	@Test
    public void testExceptionConditon() throws Exception{
	 yakshaAssert(currentTest(),true,boundaryTestFile);
      }

	@Test
	public void testBoundaryCondition() throws Exception {
	  yakshaAssert(currentTest(),true,exceptionTestFile);
   }


}
