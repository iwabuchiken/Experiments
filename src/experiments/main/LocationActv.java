package experiments.main;

import exp.listeners.button.BOCL;
import exp.listeners.button.BOTL;
import exp.utils.CONS;
import exp.utils.Tags;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class LocationActv extends Activity implements LocationListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.actv_location);
        
        this.setTitle(this.getClass().getName());
        
        LocationManager mLocationManager =
        		(LocationManager) getSystemService(Context.LOCATION_SERVICE);
        
        // Setup: Criteria
        Criteria criteria = _setup_SetCriteria();
        
        String provider = mLocationManager.getBestProvider(criteria, true);
        
        // Register: manager
        mLocationManager.requestLocationUpdates(provider, 0, 0, this);
        
        // Show the obtained provider name
        _Setup_ShowProviderName(provider);
        
        // Set listeners
        _Setup_SetListeners();
        
	}

	private void _Setup_SetListeners() {
		/*********************************
		 * Button: Get data
		 *********************************/
		Button bt_GetData = (Button) findViewById(R.id.actv_loc_bt_get_data);
		
		bt_GetData.setTag(Tags.ButtonTags.GetData);
		
		bt_GetData.setOnTouchListener(new BOTL(this));
		bt_GetData.setOnClickListener(new BOCL(this));
		
	}

	private void
	_Setup_ShowProviderName(String provider) {
		// TODO Auto-generated method stub
		TextView tv_Longi = (TextView) findViewById(R.id.actv_loc_tv_longi_str);
		TextView tv_Lat = (TextView) findViewById(R.id.actv_loc_tv_lat_str);
		TextView tv_Message = (TextView) findViewById(R.id.actv_loc_tv_message);
		
		tv_Message.setText("Provider=" + provider);
		
	}

	private Criteria _setup_SetCriteria() {
		// TODO Auto-generated method stub
		Criteria criteria = new Criteria();

		//Accuracyを指定
		criteria.setAccuracy(Criteria.ACCURACY_FINE);
//		criteria.setAccuracy(Criteria.ACCURACY_COARSE);
		
		//PowerRequirementを指定
		criteria.setPowerRequirement(Criteria.POWER_LOW);
		
		//SpeedRequiredを指定
		criteria.setSpeedRequired(false);
		
		//AltitudeRequiredを指定
		criteria.setAltitudeRequired(false);
		
		//BearingRequiredを指定
		criteria.setBearingRequired(false);
		
		//CostAllowedを指定
		criteria.setCostAllowed(false);

		return criteria;
		
	}//private void _setup_SetCriteria()

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();

		// Log
		String log_msg = "Destroying...";

		Log.d("[" + "LocationActv.java : "
				+ +Thread.currentThread().getStackTrace()[2].getLineNumber()
				+ " : "
				+ Thread.currentThread().getStackTrace()[2].getMethodName()
				+ "]", log_msg);
		this.finish();
		
		this.overridePendingTransition(0, 0);
		
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
//		super.onBackPressed();
		
		//REF override http://foobarpig.com/android-dev/how-to-disable-animation-on-startactivity-finish-and-backpressed.html
		// Log
		String log_msg = "Back pressed...";

		Log.d("[" + "LocationActv.java : "
				+ +Thread.currentThread().getStackTrace()[2].getLineNumber()
				+ " : "
				+ Thread.currentThread().getStackTrace()[2].getMethodName()
				+ "]", log_msg);
		this.finish();
		
		this.overridePendingTransition(0, 0);
		
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}

	@Override
	public void onLocationChanged(Location loc) {
		// TODO Auto-generated method stub
		CONS.LocData.LONGITUDE = loc.getLongitude();
		CONS.LocData.LATITUDE = loc.getLatitude();
		
	}

	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub
		
	}

	
	
}
