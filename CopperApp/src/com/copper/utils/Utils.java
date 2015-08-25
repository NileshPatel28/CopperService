package com.copper.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.copper.app.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Utils {

	public static void backAction(final ActionBarActivity actionBarActivity) {
		actionBarActivity.getSupportActionBar().getCustomView()
				.findViewById(R.id.back).setVisibility(View.VISIBLE);
 		actionBarActivity.getSupportActionBar().getCustomView()
				.findViewById(R.id.back)
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						actionBarActivity.finish();
					}
				});

	}

	public static String formatDateToTime(String dtStart) {
		String time = "00:00";
		String s2 = dtStart.substring(0, dtStart.indexOf("."));
		String s3 = dtStart.replace("T", " ");

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
		// 2000-01-01T14:00:00.000Z
		try {
			Date dt = format.parse(s3);

			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm aa");
			time = sdf.format(dt);
			Log.v("N", "Date " + dt);
			Log.v("N", "TIME " + time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return time;
	}

	public static void hideKetyboard(Activity context) {
		View view = context.getCurrentFocus();
		if (view != null) {
			InputMethodManager imm = (InputMethodManager) context
					.getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
		}
	}

	public static void deleteDialog(final Context mContext,
			DialogInterface.OnClickListener clickListener) {

		AlertDialog.Builder builder = null;
		if (android.os.Build.VERSION.SDK_INT >= 11) {
			builder = new AlertDialog.Builder(mContext,
					AlertDialog.THEME_HOLO_LIGHT);
		} else {
			builder = new AlertDialog.Builder(mContext);
		}
		builder.setTitle("CopperApp");

		builder.setMessage("Are you sure you want to delete this item?")

		.setPositiveButton("OK", clickListener)
				.setNegativeButton("Cancel", null);

		AlertDialog alert = builder.create();
		alert.setCanceledOnTouchOutside(true);
		alert.show();
		TextView messageText = (TextView) alert
				.findViewById(android.R.id.message);
		messageText.setGravity(Gravity.CENTER);
	}

	public static void showToast(Context mContext, String text) {
		Toast.makeText(mContext, text, 1).show();
	}

	public static String ID = "0";

	public static void hideKeyBoard(Context context, EditText et) {

		try {
			InputMethodManager imm = (InputMethodManager) context
					.getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(et.getWindowToken(), 0);
		} catch (Exception e) {
		}

	}

	/**
	 * Validate hex with regular expression
	 * 
	 * @param hex
	 *            hex for validation
	 * @return true valid hex, false invalid hex
	 */
	public static boolean validate(final String hex) {
		final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

		Pattern pattern = Pattern.compile(EMAIL_PATTERN);

		Matcher matcher;

		matcher = pattern.matcher(hex);
		return matcher.matches();

	}

	/**
	 * Convert milliseconds into time hh:mm:ss
	 * 
	 * @param milliseconds
	 * @return time in String
	 */
	public static String getDuration(long milliseconds) {

		long sec = (milliseconds / 1000) % 60;
		long min = (milliseconds / (60 * 1000)) % 60;
		long hour = milliseconds / (60 * 60 * 1000);

		String s = (sec < 10) ? "0" + sec : "" + sec;
		String m = (min < 10) ? "0" + min : "" + min;
		String h = "" + hour;

		String time = "";
		if (hour > 0) {
			time = h + ":" + m + ":" + s;
		} else {
			time = m + ":" + s;
		}

		return time;
	}

}
