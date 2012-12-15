package com.digitalpath.installermon;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.support.v4.app.NavUtils;

public class SurveyActivity extends Activity {
	
	Settings settings;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_survey);
		settings = new Settings(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.activity_survey, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	private boolean validateUsername(){
		String username = settings.getString("username", "none");
		String password = settings.getString("password", "none");
		
		if(username.equals("none") || password.equals("none")){
			Toast.makeText(this, "Username and/or Password \nNOT SET", Toast.LENGTH_LONG).show();
			return false;
		}else{
			return true;
		}
		
	}
	
	public void clickToSurvey(View view){
		validateUsername();
		if(validateUsername()){
			Toast.makeText(this, "Survey Clicked", Toast.LENGTH_LONG).show();
		}else{
			Intent intent = new Intent();
		    intent.setClass(this, UsernameActivity.class);
		    startActivity(intent);
		}	
	}

}
