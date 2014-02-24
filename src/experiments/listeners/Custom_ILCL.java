package experiments.listeners;

import experiments.items.Loc;
import experiments.main.ShowMapActv;
import experiments.utils.CONS;
import experiments.utils.Tags;
import android.app.Activity;
import android.content.Intent;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemLongClickListener;

public class Custom_ILCL
implements OnItemLongClickListener {

	Activity actv;
	static Vibrator vib;

	
	public Custom_ILCL(Activity actv) {
		
		this.actv = actv;
		vib = (Vibrator) actv.getSystemService(actv.VIBRATOR_SERVICE);

	}

	@Override
	public boolean onItemLongClick
	(AdapterView<?> parent, View v, int position, long id) {
		// TODO Auto-generated method stub
		
		Tags.ListTags tag = (Tags.ListTags) parent.getTag();
		
		vib.vibrate(40);

		switch (tag) {
		
		case actv_main_lv://-----------------------------

			case_actv_main_lv(parent, position);
			
			break;// case actv_main_lv
			
		case actv_main_lv_locs://-----------------------------
			
			case_Actv_main_lv_locs(parent, position);
			
			break;// case actv_main_lv_locs
			
		default:
			break;
		}//switch (tag) {
		
		return false;
	}//public boolean onItemLongClick

	private void
	case_Actv_main_lv_locs(AdapterView<?> parent, int position) {
		// TODO Auto-generated method stub
		Loc loc = (Loc) parent.getItemAtPosition(position);
		
		// Data obtained?
		if (loc.getLongitude() == null ||
				loc.getLatitude() == null) {
			
			// Log
			String log_msg = "loc data => null";
			
			Log.d("["
					+ "BOCL.java : "
					+ +Thread.currentThread().getStackTrace()[2]
							.getLineNumber() + " : "
							+ Thread.currentThread().getStackTrace()[2].getMethodName()
							+ "]", log_msg);
			
			// debug
			String toa_msg = "Loc data is null";
			Toast.makeText(actv, toa_msg, Toast.LENGTH_SHORT).show();
			
			return;
			
		}//if (CONS.LocData.LONGITUDE == null)
		
		float longi = Float.valueOf(loc.getLongitude());
		float lat = Float.valueOf(loc.getLatitude());
		
		// Log
		String log_msg = "longi=" + String.valueOf(longi)
						+ "/"
						+ "lat=" + String.valueOf(lat);

		Log.d("[" + "Custom_ILCL.java : "
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

	private void case_actv_main_lv
	(AdapterView<?> parent, int position) {
		
		String itemName = (String) parent.getItemAtPosition(position);
		
		// debug
		Toast.makeText(actv, itemName, Toast.LENGTH_LONG).show();
		
	}//private void case_actv_main_lv

}//public class Custom_ILCL
