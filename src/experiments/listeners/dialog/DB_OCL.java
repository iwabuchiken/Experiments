package experiments.listeners.dialog;

import experiments.items.Loc;
import experiments.main.R;
import experiments.utils.CONS;
import experiments.utils.Tags;
import android.app.Activity;
import android.app.Dialog;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

//DB=DialogButton
public class DB_OCL implements OnClickListener {
	/*----------------------------
	 * Fields
		----------------------------*/
	//
	Activity actv;
	Dialog dlg1;
	Dialog dlg2;		//=> Used in dlg_input_empty_btn_XXX
	Dialog dlg3;

	AdapterView<?> parent;
	int position;
	String original_Memo;
	
	//
	Vibrator vib;
	
	public DB_OCL(Activity actv, Dialog dlg) {
		//
		this.actv = actv;
		this.dlg1 = dlg;
		
		//
		vib = (Vibrator) actv.getSystemService(actv.VIBRATOR_SERVICE);
	}

	public DB_OCL(Activity actv, Dialog dlg1,
			Dialog dlg2) {
		//
		this.actv = actv;
		this.dlg1 = dlg1;
		this.dlg2 = dlg2;
		
		//
		vib = (Vibrator) actv.getSystemService(actv.VIBRATOR_SERVICE);
	}

	public DB_OCL(Activity actv, Dialog dlg1,
			Dialog dlg2, Dialog dlg3) {
		//
		this.actv = actv;
		this.dlg1 = dlg1;
		this.dlg2 = dlg2;
		this.dlg3 = dlg3;
		
		//
		vib = (Vibrator) actv.getSystemService(actv.VIBRATOR_SERVICE);
	}

	public DB_OCL
	(Activity actv, Dialog dlg1,
		Loc loc,
		AdapterView<?> parent, int position, String original_Memo) {
		// TODO Auto-generated constructor stub
		this.actv	= actv;
		this.dlg1	= dlg1;
		
		this.parent			= parent;
		this.position		= position;
		this.original_Memo	= original_Memo;
		
		vib = (Vibrator) actv.getSystemService(actv.VIBRATOR_SERVICE);
		
	}

	public void onClick(View v) {
		//
		Tags.DialogTags tag_name = (Tags.DialogTags) v.getTag();

		// Log
		Log.d("DialogButtonOnClickListener.java" + "["
				+ Thread.currentThread().getStackTrace()[2].getLineNumber()
				+ "]", "tag_name.name()=" + tag_name.name());
		//
		switch (tag_name) {
		
		case dlg_generic_dismiss://------------------------------------------------
			
			vib.vibrate(CONS.Admin.VIB_LENGTH);
			
			dlg1.dismiss();
			
			break;

		case dlg_generic_dismiss_second_dialog: // ----------------------------------------------------
			
			vib.vibrate(CONS.Admin.VIB_LENGTH);
			
			dlg2.dismiss();
			
			break;// case dlg_generic_dismiss_second_dialog

		case dlg_generic_dismiss_third_dialog://------------------------------------------------
			
			vib.vibrate(CONS.Admin.VIB_LENGTH);
			
			dlg3.dismiss();
			
			break;

		case dlg_edit_locs_btn_ok://------------------------------------------------
			
			vib.vibrate(CONS.Admin.VIB_LENGTH);
			
			case_Dlg_EditLocs_Btn_Ok();
			
			break;// case dlg_edit_locs_btn_ok
			
		default: //----------------------------------------------------
			break;
			
		}//switch (tag_name)
		
	}//public void onClick(View v)

	private void case_Dlg_EditLocs_Btn_Ok() {
		// TODO Auto-generated method stub
		// Compare the current and the new memo value
		EditText et_Memo = (EditText) dlg1.findViewById(
								R.id.dlg_edit_locs_tv_memo_val);
		
		String new_Memo = et_Memo.getText().toString();
		

		// If any change, then replace the current value with the new
		if (original_Memo != null &&
				new_Memo != null &&
				original_Memo.equals(new_Memo)) {
			
			// Log
			String log_msg = "orig memo=" + original_Memo
					+ "/"
					+ "new memo=" + new_Memo;
			
			Log.d("[" + "DB_OCL.java : "
					+ +Thread.currentThread().getStackTrace()[2].getLineNumber()
					+ " : "
					+ Thread.currentThread().getStackTrace()[2].getMethodName()
					+ "]", log_msg);
			
		} else if(new_Memo == null){//if (original_Memo.equals(new_Memo))
			
			// Log
			String log_msg = "new memo => null";
			
			Log.d("[" + "DB_OCL.java : "
					+ +Thread.currentThread().getStackTrace()[2].getLineNumber()
					+ " : "
					+ Thread.currentThread().getStackTrace()[2].getMethodName()
					+ "]", log_msg);
			
		} else {//if (original_Memo.equals(new_Memo))
			
			Loc loc = CONS.Main.loc_List.get(position);
			
			loc.setMemo(new_Memo);
			
			CONS.Adapters.adp_LocList.notifyDataSetChanged();
			
			// Log
			String log_msg = "CONS.Adapters.adp_LocList => notified";

			Log.d("["
					+ "DB_OCL.java : "
					+ +Thread.currentThread().getStackTrace()[2]
							.getLineNumber() + " : "
					+ Thread.currentThread().getStackTrace()[2].getMethodName()
					+ "]", log_msg);
			
		}//if (original_Memo.equals(new_Memo))
		
		// Close dialog
		dlg1.dismiss();
		
	}//private void case_Dlg_EditLocs_Btn_Ok()

}//DialogButtonOnClickListener
