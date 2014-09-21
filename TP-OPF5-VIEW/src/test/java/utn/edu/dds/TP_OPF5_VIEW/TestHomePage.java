package utn.edu.dds.TP_OPF5_VIEW;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

import utn.edu.dds.TP_OPF5_VIEW.runnable.WicketApplication;
import utn.edu.dds.TP_OPF5_VIEW.ui.OFHomePage;

/**
 * Simple test using the WicketTester
 */
public class TestHomePage
{
	private WicketTester tester;

	@Before
	public void setUp()
	{
		tester = new WicketTester(new WicketApplication());
	}

	@Test
	public void homepageRendersSuccessfully()
	{
		//start and render the test page
		tester.startPage(OFHomePage.class);

		//assert rendered page class
		tester.assertRenderedPage(OFHomePage.class);
	}
}
