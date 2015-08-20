package intentslab.labs.course.com.activityloaderactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityLoaderActivity extends Activity {

    static private final int GET_TEXT_REQUEST_CODE = 1;
    static private final String URL = "http://www.google.com";
    static private final String TAG = "Lab-Intents";

    // For use with app chooser
    static private final String CHOOSER_TEXT = "Load " + URL + " with:";

    // TextView that displays user-entered text from ExplicitlyLoadedActivity runs
    private TextView mUserTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loader_activity);

        // Get reference to the textView
        mUserTextView = (TextView) findViewById(R.id.textView1);

        // Declare and setup Explicit Activation button
        Button explicitActivationButton = (Button) findViewById(R.id.explicit_activation_button);
        explicitActivationButton.setOnClickListener(new OnClickListener() {

            // Call startExplicitActivation() when pressed
            @Override
            public void onClick(View v) {

                startExplicitActivation();

            }
        });

        // Declare and setup Implicit Activation button
        Button implicitActivationButton = (Button) findViewById(R.id.implicit_activation_button);
        implicitActivationButton.setOnClickListener(new OnClickListener() {

            // Call startImplicitActivation() when pressed
            @Override
            public void onClick(View v) {

                startImplicitActivation();

            }
        });

    }


    // Start the ExplicitlyLoadedActivity

    private void startExplicitActivation() {

        Log.i(TAG,"Entered startExplicitActivation()");

        // TODO - Create a new intent to launch the ExplicitlyLoadedActivity class
        Intent explicitIntent = null;
        explicitIntent = new Intent(ActivityLoaderActivity.this,ExplicitlyLoadedActivity.class);

        // TODO - Start an Activity using that intent and the request code defined above
        startActivityForResult(explicitIntent, GET_TEXT_REQUEST_CODE);


    }

    // Start a Browser Activity to view a web page or its URL

    private void startImplicitActivation() {

        Log.i(TAG, "Entered startImplicitActivation()");

        // TODO - Create a base intent for viewing a URL
        // (HINT:  second parameter uses Uri.parse())

        Intent baseIntent = null;
        Uri webpageuri = Uri.parse(URL);
        baseIntent = new Intent(Intent.ACTION_VIEW,webpageuri);
        //baseIntent = new Intent(Intent.ACTION_SEND,webpageuri);
        // TODO - Create a chooser intent, for choosing which Activity
        // will carry out the baseIntent
        // (HINT: Use the Intent class' createChooser() method)
        Intent chooserIntent = null;

        Intent intent = new Intent(Intent.ACTION_SEND);
        chooserIntent = Intent.createChooser(baseIntent,CHOOSER_TEXT);
       // chooserIntent = Intent.createChooser(intent,CHOOSER_TEXT);

        Log.i(TAG, "Chooser Intent Action:" + chooserIntent.getAction());
        // TODO - Start the chooser Activity, using the chooser intent
       // startActivity(chooserIntent);

        if (chooserIntent.resolveActivity(getPackageManager()) != null) {
           // startActivity(baseIntent);
            startActivity(chooserIntent);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        Log.i(TAG, "Entered onActivityResult()");

        // TODO - Process the result only if this method received both a
        // RESULT_OK result code and a recognized request code
        // If so, update the Textview showing the user-entered text.
        if(requestCode == GET_TEXT_REQUEST_CODE){
            if(resultCode == RESULT_OK){

                String enteredValue = data.getExtras().getString("no_text_entered");
                mUserTextView.setText(enteredValue);
            }
        }


    }

   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loader_activity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_loader, menu);
        return true;
    }

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
    }*/

}
