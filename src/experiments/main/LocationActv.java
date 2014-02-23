package experiments.main;

import java.util.List;

import experiments.adapters.Adp_Loc;
import experiments.items.Loc;
import experiments.listeners.button.BOCL;
import experiments.listeners.button.BOTL;
import experiments.utils.CONS;
import experiments.utils.Methods_Dlg;
import experiments.utils.Methods_LM;
import experiments.utils.Tags;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class LocationActv extends Activity implements LocationListener {

	public static boolean locationObtained = false; 

	private LocationManager mLocationManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.actv_location);
        
        this.setTitle(this.getClass().getName());
        
        _Setup_LocationManager();
        
//        LocationManager mLocationManager =
//        		(LocationManager) getSystemService(Context.LOCATION_SERVICE);
//        
//        // Setup: Criteria
//        Criteria criteria = _setup_SetCriteria();
//        
//        String provider = mLocationManager.getBestProvider(criteria, true);
//        
//        // Register: manager
//        mLocationManager.requestLocationUpdates(provider, 0, 0, this);
//        
//        // Show the obtained provider name
//        _Setup_ShowProviderName(provider);
        
        // Set listeners
        _Setup_SetListeners();
        
        
        _Setup_LocList();
        
        do_debugs();
        
	}

	
	private void _Setup_LocList() {
		// TODO Auto-generated method stub
		List<Loc> loc_List = Methods_LM.get_Locs_All(this);
		
		Adp_Loc adp_LocList = new Adp_Loc(
						this,
						R.layout.list_row_loc_list,
						loc_List
		);
		
		// Log
		String log_msg = "loc_List.size() => " + loc_List.size();

		Log.d("[" + "LocationActv.java : "
				+ +Thread.currentThread().getStackTrace()[2].getLineNumber()
				+ " : "
				+ Thread.currentThread().getStackTrace()[2].getMethodName()
				+ "]", log_msg);
		
		// Set adapter to the list view
		ListView lv = (ListView) findViewById(R.id.actv_loc_lv);
		
		lv.setAdapter(adp_LocList);
		
	}


	private void _Setup_LocationManager() {
		// TODO Auto-generated method stub
		mLocationManager =
//				LocationManager mLocationManager =
        		(LocationManager) getSystemService(Context.LOCATION_SERVICE);
        
        // Setup: Criteria
        Criteria criteria = _setup_SetCriteria();
        
        String provider = mLocationManager.getBestProvider(criteria, true);
        
        // Register: manager
        mLocationManager.requestLocationUpdates(provider, 0, 0, this);
        
        // Show the obtained provider name
        _Setup_ShowProviderName(provider);
        
	}//private void _Setup_LocationManager()


	private void do_debugs() {
		// TODO Auto-generated method stub
		_Debug_D_3_v_3_0__Preference();
	}


	private void _Debug_D_3_v_3_0__Preference() {
		// TODO Auto-generated method stub
		SharedPreferences prefs = 
				this.getSharedPreferences(
						this.getString(R.string.prefName),
						MODE_PRIVATE);
		
		boolean res = prefs.getBoolean(
						this.getString(R.string.prefKey_ShowMemoDialog),
						false);
		
		// Log
		String log_msg = this.getString(R.string.prefKey_ShowMemoDialog)
						+ " => "
						+ res;

		Log.d("[" + "LocationActv.java : "
				+ +Thread.currentThread().getStackTrace()[2].getLineNumber()
				+ " : "
				+ Thread.currentThread().getStackTrace()[2].getMethodName()
				+ "]", log_msg);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.menu_loc_actv, menu);
		
		return super.onCreateOptionsMenu(menu);
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		switch (item.getItemId()) {
		
		case R.id.action_settings:
			
			_option_ActionSettings();
			
			break;
		
		case R.id.menu_LocActv_Db:
			
			_option_menu_LocActv_Db();
			
			break;
			
		default:
			
			break;

		}//switch (item.getItemId())

		
		return super.onOptionsItemSelected(item);
	}


	private void _option_menu_LocActv_Db() {
		// TODO Auto-generated method stub
		Methods_Dlg.dlg_DbAdmin(this);
	}


	private void _option_ActionSettings() {
		// TODO Auto-generated method stub
		Intent i = new Intent();
		
		i.setClass(this, Settings_LM.class);
		
		i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		
		this.startActivity(i);

	}


	private void _Setup_SetListeners() {
		/*********************************
		 * Button: Get data
		 *********************************/
		Button bt_GetData = (Button) findViewById(R.id.actv_loc_bt_get_data);
		
		bt_GetData.setTag(Tags.ButtonTags.GetData);
		
		bt_GetData.setOnTouchListener(new BOTL(this));
		bt_GetData.setOnClickListener(new BOCL(this));
		
		/*********************************
		 * Button: Save data
		 *********************************/
		Button bt_SaveData = (Button) findViewById(R.id.actv_loc_bt_save_data);
		
		bt_SaveData.setTag(Tags.ButtonTags.SaveData);
		
		bt_SaveData.setOnTouchListener(new BOTL(this));
		bt_SaveData.setOnClickListener(new BOCL(this));
		
		/*********************************
		 * Button: Post data
		 *********************************/
		Button bt_PostData = (Button) findViewById(R.id.actv_loc_bt_post_data);
		
		bt_PostData.setTag(Tags.ButtonTags.PostData);
		
		bt_PostData.setOnTouchListener(new BOTL(this));
		bt_PostData.setOnClickListener(new BOCL(this));
		
		/*********************************
		 * Button: Show map
		 *********************************/
		Button bt_ShowMap = (Button) findViewById(R.id.actv_loc_bt_show_map);
		
		bt_ShowMap.setTag(Tags.ButtonTags.ShowMap);
		
		bt_ShowMap.setOnTouchListener(new BOTL(this));
		bt_ShowMap.setOnClickListener(new BOCL(this));
		
	}//private void _Setup_SetListeners()

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
		
		locationObtained = false;
		
		//REF http://stackoverflow.com/questions/4197478/how-to-stop-location-manager asked Nov 16 '10 at 18:14
		this.mLocationManager.removeUpdates(this);
		
		// Log
		log_msg = "LocationManager => Updates removed";

		Log.d("[" + "LocationActv.java : "
				+ +Thread.currentThread().getStackTrace()[2].getLineNumber()
				+ " : "
				+ Thread.currentThread().getStackTrace()[2].getMethodName()
				+ "]", log_msg);
		
	}//protected void onDestroy()

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
		
		// Log
		String log_msg = "onPause()";

		Log.d("[" + "LocationActv.java : "
				+ +Thread.currentThread().getStackTrace()[2].getLineNumber()
				+ " : "
				+ Thread.currentThread().getStackTrace()[2].getMethodName()
				+ "]", log_msg);
		
		// Reset location data
		this.locationObtained	= false;
		CONS.LocData.LONGITUDE	= null;
		CONS.LocData.LATITUDE	= null;
		
		// Log
		log_msg = "locationObtained => false";

		Log.d("[" + "LocationActv.java : "
				+ +Thread.currentThread().getStackTrace()[2].getLineNumber()
				+ " : "
				+ Thread.currentThread().getStackTrace()[2].getMethodName()
				+ "]", log_msg);
		
	}

	
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		// Log
		String log_msg = "onRestart()";

		Log.d("[" + "LocationActv.java : "
				+ +Thread.currentThread().getStackTrace()[2].getLineNumber()
				+ " : "
				+ Thread.currentThread().getStackTrace()[2].getMethodName()
				+ "]", log_msg);
		super.onRestart();
	}


	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		// Log
		String log_msg = "onResume()";

		Log.d("[" + "LocationActv.java : "
				+ +Thread.currentThread().getStackTrace()[2].getLineNumber()
				+ " : "
				+ Thread.currentThread().getStackTrace()[2].getMethodName()
				+ "]", log_msg);
		
		super.onResume();
	}


	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		
		// Log
		String log_msg = "onStart()";

		Log.d("[" + "LocationActv.java : "
				+ +Thread.currentThread().getStackTrace()[2].getLineNumber()
				+ " : "
				+ Thread.currentThread().getStackTrace()[2].getMethodName()
				+ "]", log_msg);
		super.onStart();
		
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		// Log
		String log_msg = "onStop()";

		Log.d("[" + "LocationActv.java : "
				+ +Thread.currentThread().getStackTrace()[2].getLineNumber()
				+ " : "
				+ Thread.currentThread().getStackTrace()[2].getMethodName()
				+ "]", log_msg);
		
		locationObtained = false;
		
		super.onStop();
	}

	@Override
	public void onLocationChanged(Location loc) {
		// TODO Auto-generated method stub
		CONS.LocData.LONGITUDE = loc.getLongitude();
		CONS.LocData.LATITUDE = loc.getLatitude();
		
		if (locationObtained == false
				&& CONS.LocData.LONGITUDE != null
				&& CONS.LocData.LATITUDE != null) {
			
			locationObtained = true;
			
			// Button "Get data" => bg --> blue
			Button bt_GetData = (Button) findViewById(R.id.actv_loc_bt_get_data);
			
			bt_GetData.setBackgroundColor(
					this.getResources().getColor(R.color.blue1));
			
			// debug
			String toa_msg = "Location obtained";
			Toast.makeText(this, toa_msg, Toast.LENGTH_SHORT).show();
			
		}
	}//public void onLocationChanged(Location loc)

	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub
		
		// Log
		String log_msg = "onProviderEnabled()";

		Log.d("[" + "LocationActv.java : "
				+ +Thread.currentThread().getStackTrace()[2].getLineNumber()
				+ " : "
				+ Thread.currentThread().getStackTrace()[2].getMethodName()
				+ "]", log_msg);
	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub
		
	}

	
	
}
