package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class EditTweetActivity extends Activity {

    private EditText editTweet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tweet);

        editTweet = (EditText) findViewById(R.id.editTweet);
        Bundle extras = getIntent().getExtras();
        String message = extras.getString("message");

        editTweet.setText(message, TextView.BufferType.EDITABLE);
    }


}
