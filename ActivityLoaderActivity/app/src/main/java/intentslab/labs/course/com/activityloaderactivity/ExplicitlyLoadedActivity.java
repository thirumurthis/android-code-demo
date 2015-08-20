package intentslab.labs.course.com.activityloaderactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class ExplicitlyLoadedActivity extends Activity {

        static private final String TAG = "Lab-Intents";

        private EditText mEditText;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.explicitly_loaded_activity);

        // Get a reference to the EditText field
        mEditText = (EditText) findViewById(R.id.editText);

        // Declare and setup "Enter" button
        Button enterButton = (Button) findViewById(R.id.enter_button);
        enterButton.setOnClickListener(new OnClickListener() {

            // Call enterClicked() when pressed

            @Override
            public void onClick(View v) {

                enterClicked();

            }
        });

    }

        // Sets result to send back to calling Activity and finishes

    private void enterClicked() {

        Log.i(TAG,"Entered enterClicked()");

        // TODO - Save user provided input from the EditText field

            String userinput = mEditText.getText()!=null? mEditText.getText().toString():"";
        // TODO - Create a new intent and save the input from the EditText field as an extra
            Intent result = new Intent();
            result.putExtra("no_text_entered",userinput);
        // TODO - Set Activity's result with result code RESULT_OK
        setResult(Activity.RESULT_OK,result);
        // TODO - Finish the Activity
            finish();
    }
   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.explicitly_loaded_activity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_explicitly_loaded, menu);
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
