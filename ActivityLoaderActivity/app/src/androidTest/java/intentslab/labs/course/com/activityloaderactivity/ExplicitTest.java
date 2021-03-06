package intentslab.labs.course.com.activityloaderactivity;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

import intentslab.labs.course.com.activityloaderactivity.ActivityLoaderActivity;

public class ExplicitTest extends
        ActivityInstrumentationTestCase2<ActivityLoaderActivity> {
    private Solo solo;

    public ExplicitTest() {
        super(ActivityLoaderActivity.class);
    }

    public void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());

    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

    // Executes the ExplicitTest
    public void testRun() {

        int delay = 2000*2;
        // =================== Section One =====================
        // Wait for activity: 'intentslab.labs.course.com.activityloaderactivity.ActivityLoaderActivity'
        assertTrue(
                "ExplicitTest:" + "Section One:"
                        + "ActivityLoaderActivity did not load correctly",
                solo.waitForActivity(intentslab.labs.course.com.activityloaderactivity.ActivityLoaderActivity.class, delay));

        solo.sleep(delay);

        // Click on Explicit Activation Button
        solo.clickOnView(solo
                .getView(R.id.explicit_activation_button));

        // Wait for activity: 'intentslab.labs.course.com.activityloaderactivity.ExplicitlyLoadedActivity'
        assertTrue(
                "ExplicitTest:" + "Section One:"
                        + "ExplicitlyLoadedActivity did not load correctly",
                solo.waitForActivity(intentslab.labs.course.com.activityloaderactivity.ExplicitlyLoadedActivity.class, delay));

        // Checks that the ExplicityLoadedActivity was launched by the correct
        // Intent
        assertEquals(
                "ExplicitTest:"
                        + "Section One:"
                        + "ExplicitlyLoadedActivity was not launched by the correct Intent",
                "Intent {cmp=intentslab.labs.course.com.activityLoaderactivity/.ExplicitlyLoadedActivity}",
                solo.getCurrentActivity().getIntent().toString());

        // =================== Section Two ==========================


        // Hide the soft keyboard
        solo.hideSoftKeyboard();

        solo.sleep(delay);

        // Clear any text in the EditText
        solo.clearEditText((android.widget.EditText) solo
                .getView(R.id.editText));

        // Enter the text: 'test'
        solo.enterText((android.widget.EditText) solo
                .getView(R.id.editText), "test");

        // Hide the soft keyboard
        solo.hideSoftKeyboard();

        solo.sleep(delay);

        // Click on Enter Button
        solo.clickOnView(solo.getView(R.id.enter_button));

        // Assert that: 'textView1' is shown
        assertTrue("ExplicitTest:" + "Section Two:"
                + "textView1 did not show correctly", solo.waitForView(solo
                .getView(R.id.textView1)));

        // Assert that the string 'test' is found in the display
        assertTrue(
                "ExplicitTest:"
                        + "Section Two:"
                        + "Correct text was not returned from ExplicitlyLoadedActivity to ActivityLoaderActivity",
                solo.searchText("test"));

    }
}
