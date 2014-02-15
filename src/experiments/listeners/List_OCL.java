package experiments.listeners;

import experiments.utils.Tags;
import android.app.Activity;
import android.app.Dialog;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class List_OCL implements OnClickListener {

	Activity actv;
	Dialog dlg1;
	
	Vibrator vib;
	
	public List_OCL(Activity actv, Dialog dlg1) {
		// TODO Auto-generated constructor stub
		this.actv = actv;
		this.dlg1 = dlg1;
		
		//
		vib = (Vibrator) actv.getSystemService(actv.VIBRATOR_SERVICE);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Tags.ListTags tag_name = (Tags.ListTags) v.getTag();
		
		// Log
		String log_msg = "tag => " + tag_name;

		Log.d("[" + "List_OCL.java : "
				+ +Thread.currentThread().getStackTrace()[2].getLineNumber()
				+ " : "
				+ Thread.currentThread().getStackTrace()[2].getMethodName()
				+ "]", log_msg);
		
	}

}
