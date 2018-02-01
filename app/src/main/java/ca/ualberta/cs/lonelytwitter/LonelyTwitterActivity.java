/*
 * LonelyTwitterActivity
 *
 * Version 1.0
 *
 * Copyright 2018 Team X. CMPUT 301. University of Alberta. All Rights Reserved.
 * You may use, distribute, or modify the code under terms and conditions of the Code of Student Behaviour at University of Alberta.
 * You can find a copy of the license in this project. Otherwise, please contact alido@ualberta.ca
 */

package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Represents the LonelyTwitterActivity activity
 * @author alido
 * @version 1.0
 */

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "tweets.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayList<Tweet> tweetList;
	private ArrayAdapter<Tweet> adapter;
	
	/** Called when the activity is first created. */
	/**
	 * Procedure run upon activity creation
	 * @param savedInstanceState Bundle of info sent to activity
	 */

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i("LifeCycle ---->", "onCreate is called");
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);
		Button happyButton = (Button) findViewById(R.id.happy);
		Button sadButton = (Button) findViewById(R.id.sad);
		Button clearButton = (Button) findViewById(R.id.clear);



		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();

				Tweet tweet = new NormalTweet(text);
				tweetList.add(tweet);
				adapter.notifyDataSetChanged();
				saveInFile();


			}
		});

		happyButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				Happy mood = new Happy();
				String text = bodyText.getText().toString();

				Tweet tweet = new NormalTweet(text,mood);
				tweetList.add(tweet);
				adapter.notifyDataSetChanged();
				saveInFile(); //gson is done in saveInFile process
			}
		});

		sadButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				Sad mood = new Sad();
				String text = bodyText.getText().toString();

				Tweet tweet = new NormalTweet(text,mood);
				tweetList.add(tweet);
				adapter.notifyDataSetChanged();
				saveInFile(); //gson is done in saveInFile process
			}
		});

		clearButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view) {
				tweetList.clear();
				adapter.notifyDataSetChanged();
				saveInFile();
			}
		});
	}

	/**
	 * Procedure run upon activity start
	 */
	@Override
	protected void onStart() {

		// TODO Auto-generated method stub
		super.onStart();
		Log.i("LifeCycle --->", "onStart is called");
		loadFromFile();
		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);

        NormalTweet normalTweet = new NormalTweet("");
        try {
            normalTweet.setMessage("Hello World!");
//            normalTweet.setMessage("aaaaaaaa123904ifkdjfhirhtiorhtherihgtjkerhgjkhergtjkherjkh49ryhui4thg754tdfjlsdkhioerhgiohruioghejiogfuioerhgfiohrjkfhasdjkhgiuhgiorgjkdfhgidfgsdkljfkldsjfklsdjklfjdklsfjkldghsk");
        }
        catch (TweetTooLongException e) {
            Log.e("Error ---->", "Tweet message too long");

        }


        ImportantTweet importantTweet1 = new ImportantTweet("Hello World! This is important");
        ImportantTweet importantTweet2 = new ImportantTweet("This is another important tweet");

        NormalTweet normalTweet1 = new NormalTweet("This is not that important");
        NormalTweet normalTweet2 = new NormalTweet("This is not that important either");

        ArrayList <Tweet> tweetList = new ArrayList<Tweet>();
        tweetList.add(normalTweet);
        tweetList.add(normalTweet1);
        tweetList.add(normalTweet2);
        tweetList.add(importantTweet1);
        tweetList.add(importantTweet2);

        for (Tweet t:
                tweetList) {
            Log.d("Tweet Polymorphism", t.isImportant().toString());

        }


        ArrayList <Tweetable> tweetableList = new ArrayList<Tweetable>();
        tweetableList.add(normalTweet);
        tweetableList.add(normalTweet1);
        tweetableList.add(normalTweet2);
        tweetableList.add(importantTweet1);
        tweetableList.add(importantTweet2);

        String messageOnScreen = "";
        for (Tweetable t:
             tweetableList) {
            messageOnScreen = t.getMessage() + "\n";
        }
        Toast.makeText(this, messageOnScreen, Toast.LENGTH_SHORT).show();

	}

	/**
	 * Loads activity saved on a file
	 * @return String of tweets saved
	 */

	private String[] loadFromFile() {
		ArrayList<String> tweets = new ArrayList<String>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));

			Gson gson = new Gson();

			// Taken https://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-type
			// 2018-01-23

			Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();
			tweetList = gson.fromJson(in, listType);


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			tweetList = new ArrayList<Tweet>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
		return tweets.toArray(new String[tweets.size()]);
	}

	/**
	 * Saves tweets into a file
	 */

	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

			Gson gson = new Gson();
			gson.toJson(tweetList, out);
			out.flush();


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}

	/**
	 * Procedure run upon activity end
	 */

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i("Lifecycle", "onDestroy is called");
	}
}