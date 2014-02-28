package experiments.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import experiments.adapters.DBAdminAdapter;
import experiments.items.Loc;
import experiments.listeners.dialog.DB_OCL;
import experiments.listeners.dialog.DB_OTL;
import experiments.listeners.dialog.DOI_CL;
import experiments.main.R;
import experiments.utils.Tags.DialogTags;
import android.app.Activity;
import android.app.Dialog;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

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

	public static boolean
	dlg_EditLoc
	(Activity actv, Loc loc, AdapterView<?> parent, int position) {
		// TODO Auto-generated method stub
		Dialog dlg = new Dialog(actv);
		
		//
		dlg.setContentView(R.layout.dlg_edit_locs);
		
		// Title
		dlg.setTitle(actv.getString(R.string.dlg_edit_locs_title));
		
		/*********************************
		 * Set: values
		 *********************************/
		// Date
		TextView tv_Date = (TextView) dlg.findViewById(
								R.id.dlg_edit_locs_tv_date_val);
		
		//REF return http://stackoverflow.com/questions/16601585/add-new-line-character-in-string answered May 17 '13 at 4:53
		String date = StringUtils.join(loc.getCreated_at().split("_"), "\n");
		
		if (loc.getCreated_at() != null) {
			
			tv_Date.setText(date);
//			tv_Date.setText(loc.getCreated_at());
			
		}
		
		// Longi
		TextView tv_Longi = (TextView) dlg.findViewById(
				R.id.dlg_edit_locs_tv_longi_val);
		
		String longi = loc.getLongitude();
		
		if (longi == null) {
			
			longi = "";
			
		} else if (longi.length() > CONS.Others.Default_LocStringLength) {
			
			longi = longi.substring(0, CONS.Others.Default_LocStringLength);
			
		}
		
		tv_Longi.setText(longi);
		
		// Lat
		TextView tv_Lat = (TextView) dlg.findViewById(
				R.id.dlg_edit_locs_tv_lat_val);
		
		String lat = loc.getLatitude();
		
		if (lat == null) {
			
			lat = "";
			
		} else if (lat.length() > CONS.Others.Default_LocStringLength) {
			
			lat = lat.substring(0, CONS.Others.Default_LocStringLength);
			
		}
		
		tv_Lat.setText(lat);
		
		// Memo
		EditText et_Memo = (EditText) dlg.findViewById(R.id.dlg_edit_locs_tv_memo_val);
		
		String original_Memo = loc.getMemo();
		
		et_Memo.setText(original_Memo);
		
		/*********************************
		 * Set: Listeners
		 *********************************/
		/* Cancel */
		Button btn_cancel = (Button) dlg.findViewById(R.id.dlg_edit_locs_btn_cancel);
		
		//
		btn_cancel.setTag(Tags.DialogTags.dlg_generic_dismiss);
		
		//
		btn_cancel.setOnTouchListener(new DB_OTL(actv, dlg));
		//
		btn_cancel.setOnClickListener(new DB_OCL(actv, dlg));
		
		/* Ok */
		Button btn_Ok = (Button) dlg.findViewById(R.id.dlg_edit_locs_btn_ok);
		
		//
		btn_Ok.setTag(Tags.DialogTags.dlg_edit_locs_btn_ok);
		
		//
		btn_Ok.setOnTouchListener(new DB_OTL(actv, dlg));
		
		// Get the current memo value
		
		// Pass the value to OnClickListener
		btn_Ok.setOnClickListener(new DB_OCL(
				actv, dlg, loc, parent, position, original_Memo));
		
		/*********************************
		 * Show
		 *********************************/
		dlg.show();
		
		return false;
		
	}//dlg_EditLoc

}
