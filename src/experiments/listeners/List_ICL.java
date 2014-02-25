package experiments.listeners;

import experiments.items.Loc;
import experiments.main.ShowMapActv;
import experiments.utils.CONS;
import experiments.utils.Tags;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class List_ICL
implements OnItemClickListener {

	Activity actv;
	static Vibrator vib;

	
	public List_ICL(Activity actv) {
		
		this.actv = actv;
		vib = (Vibrator) actv.getSystemService(actv.VIBRATOR_SERVICE);

	}

	@Override
	public void onItemClick
	(AdapterView<?> parent, View v, int position, long id) {
		// TODO Auto-generated method stub
		/*********************************
		 * Set: Preference value for position
		 *********************************/
		SharedPreferences prefs = actv.getSharedPreferences(
								CONS.Prefs.pName_LM,
								Context.MODE_PRIVATE);
		
		SharedPreferences.Editor editor = prefs.edit();
		
		editor.putInt(CONS.Prefs.pKey_CurrentItemPosition, position);
		editor.commit();
		
		if (CONS.Adapters.adp_LocList != null) {
			
			CONS.Adapters.adp_LocList.notifyDataSetChanged();
			
		}
		
		/*********************************
		 * Main processes
		 *********************************/
		Tags.ListTags tag = (Tags.ListTags) parent.getTag();
		
		vib.vibrate(40);

		switch (tag) {
		
		case actv_main_lv_locs://-----------------------------
			
			_case_Actv_main_lv_locs(parent, position);
			
			break;// case actv_main_lv_locs
			
		default:
			break;
		}//switch (tag) {
		
		return;
		
	}//public boolean onItemLongClick

	private void
	_case_Actv_main_lv_locs(AdapterView<?> parent, int position) {
		// TODO Auto-generated method stub
		Loc loc = (Loc) parent.getItemAtPosition(position);
		
		// Data obtained?
		if (loc.getLongitude() == null ||
				loc.getLatitude() == null) {
			
			// Log
			String log_msg = "loc data => null";
			
			Log.d("["
					+ "List_ICL.java : "
					+ +Thread.currentThread().getStackTrace()[2]
							.getLineNumber() + " : "
							+ Thread.currentThread().getStackTrace()[2].getMethodName()
							+ "]", log_msg);
			
			// debug
			String toa_msg = "Loc data is null";
			Toast.makeText(actv, toa_msg, Toast.LENGTH_SHORT).show();
			
			return;
			
		}//if (CONS.LocData.LONGITUDE == null)
		
		double longi = Double.valueOf(loc.getLongitude());
		double lat = Double.valueOf(loc.getLatitude());
		
		// Log
		String log_msg = "longi=" + String.valueOf(longi)
						+ "/"
						+ "lat=" + String.valueOf(lat);

		Log.d("[" + "List_ICL.java : "
				+ +Thread.currentThread().getStackTrace()[2].getLineNumber()
				+ " : "
				+ Thread.currentThread().getStackTrace()[2].getMethodName()
				+ "]", log_msg);
		
		Intent i = new Intent();
		
		i.setClass(actv, ShowMapActv.class);
		
		i.putExtra(CONS.IntentData.iName_Showmap_Longitude,
					longi);
		
		i.putExtra(CONS.IntentData.iName_Showmap_Latitude,
					lat);
		
		i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		
		actv.startActivity(i);
		
	}//case_Actv_main_lv_locs(AdapterView<?> parent, int position)

}//public class Custom_ILCL
