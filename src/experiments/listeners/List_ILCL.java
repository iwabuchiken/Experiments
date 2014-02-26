package experiments.listeners;

import experiments.items.Loc;
import experiments.main.ShowMapActv;
import experiments.utils.CONS;
import experiments.utils.Methods_Dlg;
import experiments.utils.Tags;
import android.app.Activity;
import android.content.Intent;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemLongClickListener;

public class List_ILCL
implements OnItemLongClickListener {

	Activity actv;
	static Vibrator vib;

	
	public List_ILCL(Activity actv) {
		
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
		
		return true;
//		return false;
	}//public boolean onItemLongClick

	private void
	case_Actv_main_lv_locs(AdapterView<?> parent, int position) {
		// TODO Auto-generated method stub
		Loc loc = (Loc) parent.getItemAtPosition(position);
		
		// Show dialog
		boolean res = Methods_Dlg.dlg_EditLoc(actv, loc, parent, position);
		
		// If updated, update the data in the loc list, as well
		//	=> execute in the dialog process
		
	}//case_Actv_main_lv_locs(AdapterView<?> parent, int position)

	private void case_actv_main_lv
	(AdapterView<?> parent, int position) {
		
		String itemName = (String) parent.getItemAtPosition(position);
		
		// debug
		Toast.makeText(actv, itemName, Toast.LENGTH_LONG).show();
		
	}//private void case_actv_main_lv

}//public class Custom_ILCL
