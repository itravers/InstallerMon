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
	
	SharedPreferences settings;
	SharedPreferences.Editor settingsEditor;
	ToggleButton debugButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_options);
		debugButton = (ToggleButton) findViewById(R.id.activity_options_debug_button);
		settings = getSharedPreferences(SAVED_DATA, 0);
		settingsEditor = settings.edit();
		debugButton.setChecked(settings.getBoolean("isDebugging", false));
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
			settingsEditor.putBoolean("isDebugging", true);
			message = "Debug Turned On";
		}else{
			settingsEditor.putBoolean("isDebugging", false);
			message = "Debug Turned Off";
		}
		settingsEditor.commit();
		Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
		
	}

}
