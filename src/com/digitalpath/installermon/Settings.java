package com.digitalpath.installermon;

import android.app.Activity;
import android.content.SharedPreferences;

public class Settings {

	public static final String SAVED_DATA = "SavedDataFile";
	
	private SharedPreferences settings;
	private SharedPreferences.Editor settingsEditor;
	Activity parent;
	
	public Settings(Activity p){
		parent = p;
		settings = p.getSharedPreferences(SAVED_DATA, 0);
		settingsEditor = settings.edit();
	}
	
	public boolean getBoolean(String key){
		return settings.getBoolean(key, false);
	}
	
	public void setBoolean(String key, boolean value){
		settingsEditor.putBoolean(key, value);
		settingsEditor.commit();
	}
}
