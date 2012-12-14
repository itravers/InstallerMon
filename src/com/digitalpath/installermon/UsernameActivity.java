package com.digitalpath.installermon;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class UsernameActivity extends Activity {
	
	Settings settings;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_username);
		settings = new Settings(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_username, menu);
		return true;
	}

}
