package com.example1.thirumurthi.activitylab;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityTwo extends Activity {

   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_two, menu);
        return true;
    }
*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }//*/


    // Use these as keys when you're saving state between reconfigurations
    private static final String RESTART_KEY = "restart";
    private static final String RESUME_KEY = "resume";
    private static final String START_KEY = "start";
    private static final String CREATE_KEY = "create";

    // String for LogCat documentation
    private final static String TAG = "Lab-ActivityTwo";

    // Lifecycle counters

    // TODO:
    // Create variables named
    // mCreate, mRestart, mStart and mResume
    // to count calls to onCreate(), onRestart(), onStart() and
    // onResume(). These variables should not be defined as static.
    int mCreate =0, mRestart =0, mStart =0, mResume =0;
    // You will need to increment these variables' values when their
    // corresponding lifecycle methods get called.




    // TODO: Create variables for each of the TextViews
    // named  mTvCreate, mTvRestart, mTvStart, mTvResume.
    // for displaying the current count of each counter variable
    /*TextView mTvCreate = (TextView) findViewById(R.id.create);
    TextView mTvRestart = (TextView) findViewById(R.id.restart);
    TextView mTvStart = (TextView) findViewById(R.id.start);
    TextView mTvResume = (TextView) findViewById(R.id.resume);*/
    TextView mTvCreate;
    TextView mTvRestart;
    TextView mTvStart;
    TextView mTvResume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        // TODO: Assign the appropriate TextViews to the TextView variables
        // Hint: Access the TextView by calling Activity's findViewById()
        // textView1 = (TextView) findViewById(R.id.textView1);
         mTvCreate = (TextView) findViewById(R.id.create);
         mTvStart = (TextView) findViewById(R.id.start);
         mTvResume = (TextView) findViewById(R.id.resume);
         mTvRestart = (TextView) findViewById(R.id.restart);

        Button closeButton = (Button) findViewById(R.id.bClose);
        closeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // TODO:
                // This function closes Activity Two
                // Hint: use Context's finish() method
                    finish();

            }
        });

        // Has previous state been saved?
        if (savedInstanceState != null) {

            // TODO:
            // Restore value of counters from saved state
            // Only need 4 lines of code, one for every count variable
            mCreate =savedInstanceState.getInt(CREATE_KEY);
            mRestart =savedInstanceState.getInt(RESTART_KEY);
            mStart =savedInstanceState.getInt(START_KEY);
            mResume =savedInstanceState.getInt(RESUME_KEY);
        }

        // Emit LogCat message
        Log.i(TAG, "Entered the onCreate() method");

        // TODO:
        // Update the appropriate count variable
        // Update the user interface via the displayCounts() method
mCreate++;
        displayCounts();

    }

    // Lifecycle callback methods overrides

    @Override
    public void onStart() {
        super.onStart();

        // Emit LogCat message
        Log.i(TAG, "Entered the onStart() method");

        // TODO:
        // Update the appropriate count variable
        // Update the user interface
mStart++;
        displayCounts();
    }

    @Override
    public void onResume() {
        super.onResume();

        // Emit LogCat message
        Log.i(TAG, "Entered the onResume() method");

        // TODO:
        // Update the appropriate count variable
        // Update the user interface
mResume++;
        displayCounts();

    }

    @Override
    public void onPause() {
        super.onPause();

        // Emit LogCat message
        Log.i(TAG, "Entered the onPause() method");
    }

    @Override
    public void onStop() {
        super.onStop();

        // Emit LogCat message
        Log.i(TAG, "Entered the onStop() method");
    }

    @Override
    public void onRestart() {
        super.onRestart();

        // Emit LogCat message
        Log.i(TAG, "Entered the onRestart() method");

        // TODO:
        // Update the appropriate count variable
        // Update the user interface
mRestart++;
        displayCounts();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        // Emit LogCat message
        Log.i(TAG, "Entered the onDestroy() method");
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        // TODO:
        // Save counter state information with a collection of key-value pairs
        // 4 lines of code, one for every count variable

        savedInstanceState.putInt(START_KEY,mStart);
        savedInstanceState.putInt(RESUME_KEY,mResume);
        savedInstanceState.putInt(RESTART_KEY,mRestart);
        savedInstanceState.putInt(CREATE_KEY,mCreate);

    }

    // Updates the displayed counters
    // This method expects that the counters and TextView variables use the
    // names
    // specified above
    public void displayCounts() {

        // TODO - uncomment these lines
	//*
		mTvCreate.setText("onCreate() calls: " + mCreate);
		mTvStart.setText("onStart() calls: " + mStart);
		mTvResume.setText("onResume() calls: " + mResume);
		mTvRestart.setText("onRestart() calls: " + mRestart);
	//*/

    }
}
