package exp.listeners.button;

import java.text.NumberFormat;

import exp.utils.CONS;
import exp.utils.Methods_LM;
import exp.utils.Tags;
import experiments.main.LocationActv;
import experiments.main.R;
import android.app.Activity;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class BOCL implements OnClickListener {

	Activity actv;

	//
	Vibrator vib;
	
	//
	int position;
	
	//
	ListView lv;

	public BOCL(Activity actv) {
		//
		this.actv = actv;
		
		//
		vib = (Vibrator) actv.getSystemService(actv.VIBRATOR_SERVICE);
	}

	public void onClick(View v) {
//		//
		Tags.ButtonTags tag = (Tags.ButtonTags) v.getTag();
//
		vib.vibrate(CONS.Admin.VIB_LENGTH);
		
		//
		switch (tag) {
		
		case GetData:
			
			_case_GetData();
			
			break;
			
		case SaveData:
			
			_case_SaveData();
			
			break;
			
		default:
			break;
			
		}//switch (tag)
		
	}//public void onClick(View v)

	private void _case_SaveData() {
		// TODO Auto-generated method stub
		
		// Location obtained?
		if (LocationActv.locationObtained == false) {
			
			// debug
			String toa_msg = "Location not yet obtained";
			Toast.makeText(actv, toa_msg, Toast.LENGTH_SHORT).show();
			
			// Log
			String log_msg = "Location not yet obtained";

			Log.d("["
					+ "BOCL.java : "
					+ +Thread.currentThread().getStackTrace()[2]
							.getLineNumber() + " : "
					+ Thread.currentThread().getStackTrace()[2].getMethodName()
					+ "]", log_msg);
			
			return;
			
		}//if (LocationActv.locationObtained == false)
		
		// If yes, save data
		boolean res = Methods_LM.save_LocData(actv);
		
	}//private void _case_SaveData()

	private void _case_GetData() {
		// TODO Auto-generated method stub
		if (CONS.LocData.LONGITUDE == null ||
				CONS.LocData.LATITUDE == null) {
			
			// debug
			String toa_msg = "Sorry. Data is null, yet";
			Toast.makeText(actv, toa_msg, Toast.LENGTH_LONG).show();
			
			Toast.makeText(actv, 
					"Sorry. Data is null, yet", 
					Toast.LENGTH_SHORT).show();
			return;
			
		} else {
			TextView tv_Long =
					(TextView) actv.findViewById(R.id.actv_loc_tv_longi_str);
			TextView tv_Lat =
					(TextView) actv.findViewById(R.id.actv_loc_tv_lat_str);
			
			NumberFormat format = NumberFormat.getInstance();
			// Set the number of floating digits => 10
			format.setMaximumFractionDigits(CONS.LocData.MaximumFractionDigits);
//			format.setMaximumFractionDigits(10);
			
			String val_Longi = String.valueOf(format.format(CONS.LocData.LONGITUDE));
			String val_Lat = String.valueOf(format.format(CONS.LocData.LATITUDE));
			
			// Log
			String log_msg = String.valueOf(CONS.LocData.LONGITUDE);

			Log.d("["
					+ "BOCL.java : "
					+ +Thread.currentThread().getStackTrace()[2]
							.getLineNumber() + " : "
					+ Thread.currentThread().getStackTrace()[2].getMethodName()
					+ "]", log_msg);
			
			// Set: values
			tv_Long.setText(val_Longi);
			tv_Lat.setText(val_Lat);
			
		}
		
	}//private void case_GetData()

}//public class BOCL implements OnClickListener
