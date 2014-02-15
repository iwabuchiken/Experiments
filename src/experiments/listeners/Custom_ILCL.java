package experiments.listeners;

import experiments.utils.Tags;
import android.app.Activity;
import android.os.Vibrator;
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
			
			break;
			
		default:
			break;
		}//switch (tag) {
		
		return false;
	}//public boolean onItemLongClick

	private void case_actv_main_lv
	(AdapterView<?> parent, int position) {
		
		String itemName = (String) parent.getItemAtPosition(position);
		
		// debug
		Toast.makeText(actv, itemName, Toast.LENGTH_LONG).show();
		
	}//private void case_actv_main_lv

}//public class Custom_ILCL
