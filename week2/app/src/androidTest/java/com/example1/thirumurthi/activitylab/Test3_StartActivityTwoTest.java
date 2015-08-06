package com.example1.thirumurthi.activitylab;

/**
 * Created by thirumurthi on 8/4/2015.
 */
import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

public class Test3_StartActivityTwoTest extends ActivityInstrumentationTestCase2<ActivityOne> {

    private Solo solo;
    private int timeout = 20000;
    private int sleep = 1000;

    public Test3_StartActivityTwoTest() {
        super(ActivityOne.class);
    }

    protected void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
    }

    protected void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

    // Executes the StartActivityTwoTest
    public void testRun() {

        // ==================== Section One =====================
        // Wait for activity: 'com.example1.thirumurthi.activitylab.ActivityOne'
        assertTrue("StartActivityTwoTest failed:" +
                        "Section One:" +
                        "ActivityOne did not load correctly",
                solo.waitForActivity(com.example1.thirumurthi.activitylab.ActivityOne.class, timeout));


        // ==================== Section Two =====================
        // Click on Start Activity Two

        solo.waitForView(com.example1.thirumurthi.activitylab.R.id.bLaunchActivityTwo);
        solo.clickOnView(solo
                .getView(com.example1.thirumurthi.activitylab.R.id.bLaunchActivityTwo));

        // Wait for activity: 'com.example1.thirumurthi.activitylab.ActivityTwo'
        assertTrue("StartActivityTwoTest failed:" +
                        "Section Two:" +
                        "ActivityTwo did not load correctly",
                solo.waitForActivity(com.example1.thirumurthi.activitylab.ActivityTwo.class, timeout));


        // Check for proper counts after ActivityTwo has been opened
        assertTrue("StartActivityTwoTest failed:" +
                        "Section Two:" +
                        "onCreate() count was off for ActivityTwo.",
                solo.waitForText("onCreate\\(\\) calls: 1"));

        assertTrue("StartActivityTwoTest failed:" +
                        "Section Two:" +
                        "onStart() count was off for ActivityTwo.",
                solo.waitForText("onStart\\(\\) calls: 1"));

        assertTrue("StartActivityTwoTest failed:" +
                        "Section Two:" +
                        "onResume() count was off for ActivityTwo.",
                solo.waitForText("onResume\\(\\) calls: 1"));

        assertTrue("StartActivityTwoTest failed:" +
                        "Section Two:" +
                        "onRestart() count was off for ActivityTwo.",
                solo.waitForText("onRestart\\(\\) calls: 0"));
    }

}
