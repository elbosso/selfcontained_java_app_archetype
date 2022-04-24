import ch.qos.logback.classic.Level;

@org.junit.runner.RunWith(junitparams.JUnitParamsRunner.class)
public class HelloTest
{
	private final static org.slf4j.Logger CLASS_LOGGER =org.slf4j.LoggerFactory.getLogger(HelloTest.class);

	@org.junit.Rule
	public org.junit.rules.TemporaryFolder folder = new org.junit.rules.TemporaryFolder();

	@org.junit.Ignore
	@org.junit.Test
	public void testFail()
	{
		org.junit.Assert.fail("TestExample");
	}

	@org.junit.Rule
	public org.junit.rules.TestName name = new org.junit.rules.TestName();

	@org.junit.Test(expected = IllegalArgumentException.class)
	public void testExceptionIsThrown()
	{
		CLASS_LOGGER.trace(name.getMethodName());
		throw new java.lang.IllegalArgumentException("i want to see this!");
	}

	/**
	 * The Test annotation indicates that the public void method to which it is
	 * attached can be run as a test case.
	 */
	@org.junit.Test
	public void methodTest()
	{
		org.junit.Assert.assertTrue("Always succeeds!"!=null);
	}

	/**
	 * The Parameters annotation indicates that the public void method to which it is
	 * attached can be run as a test case with the given parameters.
	 */
	@org.junit.Test
	@junitparams.Parameters({"1,1", "2,2"/* This shows failing tests:,"1,2"*/})
	public void parameterizedMethodTest(java.lang.String stringParam,java.lang.Integer intParam)
	{
		org.junit.Assert.assertEquals(intParam.intValue(),java.lang.Integer.parseInt(stringParam));
	}

	/**
	 * The Before annotation indicates that this method must be executed before
	 * each test in the class, so as to execute some preconditions necessary for
	 * the test.
	 */

	@org.junit.Before
	public void methodBefore()
	{
	}

	/**
	 * The BeforeClass annotation indicates that the static method to which is
	 * attached must be executed once and before all tests in the class. That
	 * happens when the test methods share computationally expensive setup (e.g.
	 * connect to database).
	 */

	@org.junit.BeforeClass
	public static void methodBeforeClass()
	{
		de.elbosso.util.Utilities.configureBasicStdoutLogging(Level.ALL);
	}

	/**
	 * The After annotation indicates that this method gets executed after
	 * execution of each test (e.g. reset some variables after execution of
	 * every test, delete temporary variables etc)
	 */

	@org.junit.After
	public void methodAfter()
	{
	}

	/**
	 * The AfterClass annotation can be used when a method needs to be executed
	 * after executing all the tests in a JUnit Test Case class so as to
	 * clean-up the expensive set-up (e.g disconnect from a database).
	 * Attention: The method attached with this annotation (similar to
	 * BeforeClass) must be defined as static.
	 */

	@org.junit.AfterClass
	public static void methodAfterClass()
	{
		de.elbosso.util.Utilities.configureBasicStdoutLogging(Level.OFF);
	}

	/**
	 * The Ignore annotation can be used when you want temporarily disable the
	 * execution of a specific test. Every method that is annotated with @Ignore
	 * won’t be executed.
	 */

	@org.junit.Ignore
	public static void methodIgnore()
	{
		org.junit.Assert.fail("Ignore me!");
	}
}
