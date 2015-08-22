package com.copper.view.fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.w3c.dom.Document;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import com.copper.app.R;
import com.copper.bean.MapBean;
import com.copper.communicator.CallBackListener;
import com.copper.communicator.RequestMethod;
import com.copper.prefs.MyPref;
import com.copper.utils.GMapV2GetRouteDirection;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.maps.GeoPoint;

public class DirectionMapChildFragment extends Fragment implements
		CallBackListener, LocationListener {
	String provider;
	MapView mapView;
	private View mainView;
	TextView pick_title;
	MarkerOptions markerOptions;
	GeoPoint point1, point2;
	LocationManager locManager;
	Drawable drawable;
	Document document;
	GMapV2GetRouteDirection v2GetRouteDirection;
	LatLng fromPosition;
	LatLng toPosition;
	GoogleMap mGoogleMap;
	Location location;
	ArrayList<LatLng> latLngs = new ArrayList<LatLng>();
	ArrayList<LatLng> route = new ArrayList<LatLng>();
	private GetRouteTask getRoute;
	private RadioGroup radioGroup;
	private RadioButton radio1;
	private RadioButton radio2;
	private RadioButton radio3;

	private double lat, lon;
	private LatLng home;
	private LatLng offfice;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		super.onDestroyView();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		locManager = (LocationManager) getActivity().getSystemService(
				Context.LOCATION_SERVICE);
		Criteria c = new Criteria();
		provider = locManager.getBestProvider(c, false);
		// // now you have best provider
		// get location
		location = locManager.getLastKnownLocation(provider);
		locManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0,
				0, (android.location.LocationListener) this);
		if (location != null) {
			// get latitude and longitude of the location
			lon = location.getLongitude();
			lat = location.getLatitude();
			// display on text view
		}

		mainView = inflater.inflate(R.layout.fragment_map, null);
		// Gets the MapView from the XML layout and creates it
		radio1 = (RadioButton) mainView.findViewById(R.id.radio1);
		radio2 = (RadioButton) mainView.findViewById(R.id.radio2);
		radio3 = (RadioButton) mainView.findViewById(R.id.radio3);

		radioGroup = (RadioGroup) mainView.findViewById(R.id.radioGroup);
		radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				if (radioGroup.getCheckedRadioButtonId() == radio1.getId()) {
					{
						latLngs.set(0, new LatLng(lat, lon));
					}
				} else if (radioGroup.getCheckedRadioButtonId() == radio2
						.getId()) {
					if (home != null) {
						latLngs.set(0, home);

					} else {
						Toast.makeText(getActivity(), "Address not available",
								1).show();
					}

				} else {
					if (offfice != null) {
						latLngs.set(0, offfice);
					} else {
						Toast.makeText(getActivity(), "Address not available",
								1).show();
					}

				}
				getRoute = new GetRouteTask();
				getRoute.execute();
				if (latLngs.size() > 0)
					mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
							latLngs.get(0), 12));

			}
		});
		mapView = (MapView) mainView.findViewById(R.id.cluster_mapView);
		MapsInitializer.initialize(this.getActivity());
		mapView.onCreate(savedInstanceState);
		RequestMethod.getRoute(getActivity(), MyPref.getInstance(getActivity())
				.readPrefs(MyPref.USER_ID), this);
		return mainView;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		mGoogleMap = mapView.getMap();
		if (mGoogleMap == null) {
			return;
		}
		v2GetRouteDirection = new GMapV2GetRouteDirection();
		mGoogleMap.setMyLocationEnabled(true);
		mGoogleMap.getUiSettings().setZoomControlsEnabled(true);
		mGoogleMap.getUiSettings().setCompassEnabled(true);
		mGoogleMap.getUiSettings().setMyLocationButtonEnabled(true);
		mGoogleMap.getUiSettings().setAllGesturesEnabled(true);
		mGoogleMap.setTrafficEnabled(true);
		markerOptions = new MarkerOptions();

	}

	@Override
	public void onResume() {
		mapView.onResume();
		super.onResume();
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		mapView.onPause();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		mapView.onDestroy();
	}

	private void addMarkers() {
		if (mGoogleMap != null) {
			for (int i = 0; i < latLngs.size(); i++) {
				mGoogleMap.addMarker(new MarkerOptions().position(
						latLngs.get(i)).title(
						getCompleteAddressString(latLngs.get(i).latitude,
								latLngs.get(i).longitude)));

			}

		}
	}

	/**
	 * 
	 * @author VIJAYAKUMAR M This class Get Route on the map
	 * 
	 */
	private class GetRouteTask extends AsyncTask<String, Void, String> {

		private ProgressDialog Dialog;
		String response = "";

		@Override
		protected void onPreExecute() {
			Dialog = new ProgressDialog(getActivity());
			Dialog.setMessage("Loading route...");
			Dialog.show();
		}

		@Override
		protected String doInBackground(String... urls) {
			// Get All Route values
			for (int i = 0; i < latLngs.size() - 1; i++) {
				getDirection(i, i + 1);
			}

			return response;

		}

		private void getDirection(int from, int to) {
			fromPosition = latLngs.get(from);
			toPosition = latLngs.get(to);
			document = v2GetRouteDirection.getDocument(fromPosition,
					toPosition, GMapV2GetRouteDirection.MODE_DRIVING);
			ArrayList<LatLng> directionPoint = v2GetRouteDirection
					.getDirection(document);
			route.addAll(directionPoint);
		}

		@Override
		protected void onPostExecute(String result) {
			// mGoogleMap.clear();
			// if (response.equalsIgnoreCase("Success")) {

			PolylineOptions rectLine = new PolylineOptions().width(15).color(
					Color.BLUE);

			for (int i = 0; i < route.size(); i++) {
				rectLine.add(route.get(i));
			}
			// Adding route on the map
			mGoogleMap.addPolyline(rectLine);
			markerOptions.position(toPosition);
			markerOptions.draggable(true);
			addMarkers();
			// }
			if (latLngs.size() > 0)
				mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
						latLngs.get(0), 12));

			Dialog.dismiss();

		}
	}

	// 953666
	@SuppressWarnings("unchecked")
	@Override
	public void onCallBack(int taskType, Object object) {
		// TODO Auto-generated method stub
		if (object != null) {
			if (object instanceof MapBean) {
				MapBean mapBean = (MapBean) object;
				latLngs = mapBean.getLatLngs();
				home = mapBean.getHome();
				offfice = mapBean.getHome();
			}
		}

		//
		// latLngs.add(new LatLng(22.696073, 75.865677));
		// latLngs.add(new LatLng(22.710432, 75.880661));
		// latLngs.add(new LatLng(22.697822, 75.878534));
		// latLngs.add(new LatLng(22.6925666, 75.8676832));
		// latLngs.add(new LatLng(22.696073, 75.865677));
		if (lat != 0 && lon != 0)
			latLngs.add(new LatLng(lat, lon));
		//
		getRoute = new GetRouteTask();
		getRoute.execute();

	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		lon = location.getLongitude();
		lat = location.getLatitude();

	}

	private String getCompleteAddressString(double LATITUDE, double LONGITUDE) {
		String strAdd = "";
		Geocoder geocoder = new Geocoder(getActivity(), Locale.getDefault());
		try {
			List<Address> addresses = geocoder.getFromLocation(LATITUDE,
					LONGITUDE, 1);
			if (addresses != null) {
				Address returnedAddress = addresses.get(0);
				StringBuilder strReturnedAddress = new StringBuilder("");

				for (int i = 0; i < returnedAddress.getMaxAddressLineIndex(); i++) {
					strReturnedAddress
							.append(returnedAddress.getAddressLine(i)).append(
									"\n");
				}
		 	 
				
				strAdd = strReturnedAddress.toString();
				Log.w("My Current loction address",
						"" + strReturnedAddress.toString());
		  
			} else {
				Log.w("My Current loction address", "No Address returned!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Log.w("My Current loction address", "Canont get Address!");
		}
		return strAdd;
	}
}
