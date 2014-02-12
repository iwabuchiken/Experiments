package exp.listeners.dialog;

import exp.utils.CONS;
import exp.utils.Methods_LM;
import exp.utils.Tags;
import experiments.main.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class DOI_CL implements OnItemClickListener {

	Activity actv;
	Dialog dlg1;
	Dialog dlg2;

	//
	Vibrator vib;
	

	
	public DOI_CL(Activity actv, Dialog dlg1) {
		// 
		this.actv = actv;
		this.dlg1 = dlg1;
		
		vib = (Vibrator) actv.getSystemService(Context.VIBRATOR_SERVICE);
		
	}//public DialogOnItemClickListener(Activity actv, Dialog dlg)
	
	@Override
	public void onItemClick
	(AdapterView<?> parent, View v, int position, long id) {
		// TODO Auto-generated method stub
		
		Tags.DialogItemTags tag = (Tags.DialogItemTags) parent.getTag();
//		
		vib.vibrate(CONS.Admin.VIB_LENGTH);
		
		switch (tag) {
		
		
		case Db_Admin_LV://-----------------------------------
			
			String item = (String) parent.getItemAtPosition(position);
			
			_case_Db_Admin_LV(item);
			
			break;//case Db_Admin_LV
		
		default:
			break;
		}//switch (tag)
		
	}//public void onItemClick

	private void
	_case_Db_Admin_LV(String item) {
		// TODO Auto-generated method stub

		// Log
		String log_msg = "item => " + item;

		Log.d("[" + "DOI_CL.java : "
				+ +Thread.currentThread().getStackTrace()[2].getLineNumber()
				+ " : "
				+ Thread.currentThread().getStackTrace()[2].getMethodName()
				+ "]", log_msg);
		if (item.equals(
				actv.getString(R.string.menu_LocActv_Exec_Sql))) {
			
			Methods_LM.execSql(actv);
			
		} else {//if (item.equals(R.string.menu_LocActv_Exec_Sql))
			
//			// Log
//			String log_msg = "item => " + item
//							+ "/"
//							+ "string => " + ;

			Log.d("["
					+ "DOI_CL.java : "
					+ +Thread.currentThread().getStackTrace()[2]
							.getLineNumber() + " : "
					+ Thread.currentThread().getStackTrace()[2].getMethodName()
					+ "]", log_msg);
			
			// debug
			String toa_msg = item;
			Toast.makeText(actv, toa_msg, Toast.LENGTH_SHORT).show();
			
		}//if (item.equals(R.string.menu_LocActv_Exec_Sql))
		
		
	}//_case_Db_Admin_LV(String item)

}
