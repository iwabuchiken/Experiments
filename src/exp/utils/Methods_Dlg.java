package exp.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import exp.adapters.DBAdminAdapter;
import exp.listeners.dialog.DB_OCL;
import exp.listeners.dialog.DB_OTL;
import exp.listeners.dialog.DOI_CL;
import exp.utils.Tags.DialogTags;
import experiments.main.R;
import android.app.Activity;
import android.app.Dialog;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class Methods_Dlg {

	public static void
	dlg_DbAdmin(Activity actv) {
		
		Dialog dlg = Methods_Dlg.dlg_Template_Cancel(
				actv, R.layout.dlg_tmpl_list_cancel, 
				R.string.menu_LocActv_DB_Dialog_Title,
				
				R.id.dlg_tmpl_list_cancel_bt_cancel, 
				Tags.DialogTags.dlg_generic_dismiss);

		String[] choices = {
				actv.getString(R.string.menu_LocActv_Exec_Sql),
				actv.getString(R.string.menu_LocActv_Backup_Db),
				actv.getString(R.string.menu_LocActv_Restore_Db),
		};
		
		List<String> list = new ArrayList<String>();
		
		for (String item : choices) {
			
			list.add(item);
			
		}
		
		Collections.sort(list);

		/*----------------------------
		 * 3. Adapter
			----------------------------*/
		DBAdminAdapter adapter = new DBAdminAdapter(
				actv,
//				R.layout.dlg_db_admin,
				R.layout.list_row_simple_1,
//				android.R.layout.simple_list_item_1,
				list,
				dlg
				);
//		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//						actv,
////				R.layout.dlg_db_admin,
//						R.layout.list_row_simple_1,
////				android.R.layout.simple_list_item_1,
//						list
//						);

		ListView lv = (ListView) dlg.findViewById(R.id.dlg_tmpl_list_cancel_lv);
		
		lv.setAdapter(adapter);

		/*----------------------------
		 * 5. Set listener to list
			----------------------------*/
		lv.setTag(Tags.DialogItemTags.Db_Admin_LV);
		
		lv.setOnItemClickListener(new DOI_CL(actv, dlg));
//		lv.setOnItemClickListener(new DialogOnItemClickListener(actv, dlg));
		
		/*----------------------------
		 * 6. Show dialog
			----------------------------*/
		dlg.show();
		

	}//dlg_DbAdmin(Activity actv)

	public static Dialog
	dlg_Template_Cancel
	(Activity actv,
			int layoutId, int titleStringId,
			int cancelButtonId, DialogTags cancelTag) {
		/*----------------------------
		* Steps
		* 1. Set up
		* 2. Add listeners => OnTouch
		* 3. Add listeners => OnClick
		----------------------------*/
		
		// 
		Dialog dlg = new Dialog(actv);
		
		//
		dlg.setContentView(layoutId);
		
		// Title
		dlg.setTitle(titleStringId);
		
		/*----------------------------
		* 2. Add listeners => OnTouch
		----------------------------*/
		//
		Button btn_cancel = (Button) dlg.findViewById(cancelButtonId);
		
		//
		btn_cancel.setTag(cancelTag);
		
		//
		btn_cancel.setOnTouchListener(new DB_OTL(actv, dlg));
//		btn_cancel.setOnTouchListener(new DialogButtonOnTouchListener(actv, dlg));
		
		/*----------------------------
		* 3. Add listeners => OnClick
		----------------------------*/
		//
		btn_cancel.setOnClickListener(new DB_OCL(actv, dlg));
		
		//
		//dlg.show();
		
		return dlg;
	
	}//public static Dialog dlg_template_okCancel()

}
