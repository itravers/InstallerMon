package com.digitalpath.installermon;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

public class UsernameActivity extends Activity {
	
	Settings settings;
	Button submitButton;
	Button cancelButton;
	EditText usernameField;
	EditText passwordField;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_username);
		
		submitButton = (Button) findViewById(R.id.username_activity_submitButton);
		cancelButton = (Button) findViewById(R.id.username_activity_cancelButton);
		usernameField = (EditText) findViewById(R.id.username_activity_editText1);
		passwordField = (EditText) findViewById(R.id.username_activity_editText2);
		settings = new Settings(this);
		
		populateFields();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_username, menu);
		return true;
	}
	
	private void populateFields(){
		String username = settings.getString("username", "none");
		String password = settings.getString("password", "none");
		
		usernameField.setText(username);
		passwordField.setText(password);
	}
	
	public void submitClicked(View view){
		String username = usernameField.getText().toString();
		String password = passwordField.getText().toString();
		
		
		settings.setString("username", username);
		settings.setString("password", password);
		
		Toast.makeText(this, "Username: " + username + "\nPassword: " + password, Toast.LENGTH_LONG).show();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finish();
	}
	
	public void cancelClicked(View view){
		//Intent intent = new Intent();
       // intent.setClass(this, OptionsActivity.class);
        //startActivity(intent);
		this.finish();
	}

}
