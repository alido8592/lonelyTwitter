package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

import com.robotium.solo.Solo;

import junit.framework.TestCase;

public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

    private Solo solo;

    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    /**
     * runs before starting tests
     * @throws Exception
     */

    public void setUp() throws Exception{
        solo = new Solo(getInstrumentation(), getActivity());
    }

    public void testStart() throws Exception {
        Activity activity = getActivity();

    }

    public void testTweet() {
        solo.assertCurrentActivity("Wrong Activity", LonelyTwitterActivity.class); //if not LonelyTwitterActivity class
        solo.enterText((EditText) solo.getView(R.id.body), "Test Tweet!");

        solo.clickOnButton("Save");

        solo.enterText((EditText) solo.getView(R.id.body), "");
        assertTrue(solo.waitForText("Test Tweet!")); //wait for "Test Tweet!" to appear
        solo.clickOnButton("Clear");
    }

    public void testClickTweetList() {
        solo.assertCurrentActivity("Wrong Activity", LonelyTwitterActivity.class);
        solo.clickOnButton("Clear");

        solo.enterText((EditText) solo.getView(R.id.body), "Test Tweet!");
        solo.clickOnButton("Save");
        solo.waitForText("Test Tweet!");

        solo.clickInList(0); //solo clicks first item in list
        solo.assertCurrentActivity("Wrong Activity", EditTweetActivity.class);
        assertTrue(solo.waitForText("Test Tweet!"));


    }

    /**
     * runs after tests
     * @throws Exception
     */
    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }
}