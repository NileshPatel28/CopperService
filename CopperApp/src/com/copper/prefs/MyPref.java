package com.copper.prefs;

import android.content.Context;
import android.content.SharedPreferences;

public class MyPref {
	private static SharedPreferences _sPrefs = null;
	private static SharedPreferences.Editor _editor = null;
	private static final String PERFERENCE_NAME = "TOP_40_PREFS";
	private static MyPref _instance = null;
	public static final String USER_ID = "userId";

	public MyPref() {
	}

	public MyPref(Context context) {
		_sPrefs = context.getSharedPreferences(PERFERENCE_NAME,
				Context.MODE_PRIVATE);
	}

	public static MyPref getInstance(Context context) {

		_instance = new MyPref(context);

		return _instance;
	}

	public static void setInstance(MyPref instance) {
		// TODO Auto-generated method stub
		_instance = instance;

	}

	public String readPrefs(String pref_name) {
		return _sPrefs.getString(pref_name, "");
	}

	public String readPrefs(String pref_name, String defaultVaule) {
		return _sPrefs.getString(pref_name, defaultVaule);
	}

	public void writePrefs(String pref_name, String pref_val) {
		_editor = _sPrefs.edit();
		_editor.putString(pref_name, pref_val);
		_editor.commit();
	}

	public void clearPrefs() {
		_editor = _sPrefs.edit();
		_editor.clear();
		_editor.commit();
	}

	public boolean readBooleanPrefs(String pref_name) {
		return _sPrefs.getBoolean(pref_name, true);
	}

	public boolean readBooleanPrefs(String pref_name, boolean value) {
		return _sPrefs.getBoolean(pref_name, value);
	}

	public int readIntegerPrefs(String pref_name) {
		return _sPrefs.getInt(pref_name, -1);
	}

	public int readIntegerPrefs(String pref_name, int defaultValue) {
		return _sPrefs.getInt(pref_name, defaultValue);
	}

	public void writeBooleanPrefs(String pref_name, boolean pref_val) {
		_editor = _sPrefs.edit();
		_editor.putBoolean(pref_name, pref_val);
		_editor.commit();
	}

	public void writeIntegerPref(String pref_name, int pref_val) {
		_editor = _sPrefs.edit();
		_editor.putInt(pref_name, pref_val);
		_editor.commit();
	}

	public void removePref(String pref_name) {
		_editor = _sPrefs.edit();
		_editor.remove(pref_name);
		_editor.commit();
	}

}
