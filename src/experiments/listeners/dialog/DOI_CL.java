package experiments.listeners.dialog;

import experiments.main.R;
import experiments.utils.CONS;
import experiments.utils.DBUtils;
import experiments.utils.Methods;
import experiments.utils.Methods_LM;
import experiments.utils.Migrations;
import experiments.utils.Tags;
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
			
			Migrations.execSql(actv);
//			Methods_LM.execSql(actv);
			
		} else if (item.equals(
				actv.getString(R.string.menu_LocActv_Backup_Db))){//if (item.equals(R.string.menu_LocActv_Exec_Sql))
			
			_case_Db_Admin_LV__BackupDb();
			
//			Methods.backupDb(actv, CONS.DB.dbName_LM, CONS.DB.dpath_Db_Backup);
			
		} else if (item.equals(
				actv.getString(R.string.menu_LocActv_Restore_Db))){//if (item.equals(R.string.menu_LocActv_Exec_Sql))
			
			_case_Db_Admin_LV__RestoreDb();
			
//			Methods.backupDb(actv, CONS.DB.dbName_LM, CONS.DB.dpath_Db_Backup);
			
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

	private void _case_Db_Admin_LV__RestoreDb() {
		// TODO Auto-generated method stub
		int res = DBUtils.restore_Db(actv);
		
		// Log
		String log_msg = "res => " + res;

		Log.d("[" + "DOI_CL.java : "
				+ +Thread.currentThread().getStackTrace()[2].getLineNumber()
				+ " : "
				+ Thread.currentThread().getStackTrace()[2].getMethodName()
				+ "]", log_msg);
		
		if (res == CONS.ReturnValues.DB_RESTORE_SUCCESSFUL) {
			
			// debug
			String toa_msg = "DB => Restored";
			Toast.makeText(actv, toa_msg, Toast.LENGTH_SHORT).show();
			
		} else {

			// debug
			String toa_msg = "Restore DB => Failed";
			Toast.makeText(actv, toa_msg, Toast.LENGTH_SHORT).show();
			
		}//if (res == CONS.ReturnValues.DB_RESTORE_SUCCESSFUL)
		
	}//private void _case_Db_Admin_LV__RestoreDb()

	private void _case_Db_Admin_LV__BackupDb() {
		// TODO Auto-generated method stub
		int res = Methods.backupDb(
						actv,
						CONS.DB.dbName_LM,
						CONS.DB.dpath_Db_Backup);

		if (res == CONS.ReturnValues.DB_BACKUP_SUCCESSFUL) {
			
			dlg1.dismiss();
			
			// debug
			String toa_msg = "Backup => Done";
			Toast.makeText(actv, toa_msg, Toast.LENGTH_SHORT).show();
			
		} else {//if (res == CONS.ReturnValues.DB_BACKUP_SUCCESSFUL)
			
			// debug
			String toa_msg = "Backup => Failed";
			Toast.makeText(actv, toa_msg, Toast.LENGTH_SHORT).show();
			
		}//if (res == CONS.ReturnValues.DB_BACKUP_SUCCESSFUL)
		
		
	}//private void _case_Db_Admin_LV__BackupDb()

}
