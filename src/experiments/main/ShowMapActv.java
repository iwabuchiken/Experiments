package experiments.main;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

public class ShowMapActv extends FragmentActivity {
//	public class ShowMapActv extends Activity {

	public static boolean locationObtained = false; 

//	private GoogleMap googleMap;
	private GoogleMap gm;
	private SupportMapFragment smf;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.actv_show_map);

		Fragment fr = this.getSupportFragmentManager().findFragmentById(
				R.id.map);

		smf = (SupportMapFragment) fr;

		gm = smf.getMap();

		//REF http://stackoverflow.com/questions/14074129/google-maps-v2-set-both-my-location-and-zoom-in answered Dec 28 '12 at 19:51
		CameraUpdate center = CameraUpdateFactory.newLatLng(new LatLng(
				40.76793169992044, -73.98180484771729));
		CameraUpdate zoom = CameraUpdateFactory.zoomTo(15);

		gm.moveCamera(center);
		gm.animateCamera(zoom);

		// this.setTitle(this.getClass().getName());

		// do_debugs();

	}

	private void do_debugs() {
		// TODO Auto-generated method stub
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
		
		default:
			
			break;

		}//switch (item.getItemId())

		
		return super.onOptionsItemSelected(item);
	}


	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();

		// Log
		String log_msg = "Destroying...";

		Log.d("[" + "ShowMapActv.java : "
				+ +Thread.currentThread().getStackTrace()[2].getLineNumber()
				+ " : "
				+ Thread.currentThread().getStackTrace()[2].getMethodName()
				+ "]", log_msg);
		this.finish();
		
		this.overridePendingTransition(0, 0);
		
		locationObtained = false;
		
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
//		super.onBackPressed();
		
		//REF override http://foobarpig.com/android-dev/how-to-disable-animation-on-startactivity-finish-and-backpressed.html
		// Log
		String log_msg = "Back pressed...";

		Log.d("[" + "ShowMapActv.java : "
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
	protected void onRestart() {
		// TODO Auto-generated method stub
		// Log
		String log_msg = "onRestart()";

		Log.d("[" + "ShowMapActv.java : "
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

		Log.d("[" + "ShowMapActv.java : "
				+ +Thread.currentThread().getStackTrace()[2].getLineNumber()
				+ " : "
				+ Thread.currentThread().getStackTrace()[2].getMethodName()
				+ "]", log_msg);
		
		super.onResume();
		
	}//protected void onResume()


	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		
		// Log
		String log_msg = "onStart()";

		Log.d("[" + "ShowMapActv.java : "
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

		Log.d("[" + "ShowMapActv.java : "
				+ +Thread.currentThread().getStackTrace()[2].getLineNumber()
				+ " : "
				+ Thread.currentThread().getStackTrace()[2].getMethodName()
				+ "]", log_msg);
		
		locationObtained = false;
		
		super.onStop();
	}

}
