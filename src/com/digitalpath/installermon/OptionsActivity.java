package com.digitalpath.installermon;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

public class OptionsActivity extends Activity {
	
	public static final String SAVED_DATA = "SavedDataFile";
	
	Settings settings;
	ToggleButton debugButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_options);
		debugButton = (ToggleButton) findViewById(R.id.activity_options_debug_button);
		settings = new Settings(this);
		debugButton.setChecked(settings.getBoolean("isDebugging"));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.activity_options, menu);
		return true;
	}
	
	public void debugClicked(View view){
		String message = "";
		if(debugButton.isChecked()){
			settings.setBoolean("isDebugging", true);
			message = "Debug Turned On";
		}else{
			settings.setBoolean("isDebugging", false);
			message = "Debug Turned Off";
		}
		Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
	}
	
	public void usernameClicked(View view){
		 Intent intent = new Intent();
         intent.setClass(this, UsernameActivity.class);
         startActivity(intent);
	}

}
