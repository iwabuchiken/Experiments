package experiments.listeners.dialog;

import experiments.utils.Tags;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class DB_OTL implements OnTouchListener {

	/*----------------------------
	 * Fields
		----------------------------*/
	//
	Activity actv;
	Dialog dlg1;
	Dialog dlg2;
	
	public DB_OTL(Activity actv, Dialog dlg) {
		//
		this.actv = actv;
		this.dlg1 = dlg;
	}
	
	public DB_OTL(Activity actv) {
		//
		this.actv = actv;
	}

	public DB_OTL(Activity actv, Dialog dlg1, Dialog dlg2) {
		// TODO Auto-generated constructor stub
		this.actv = actv;
		this.dlg1 = dlg1;
		this.dlg2 = dlg2;

	}

	//	@Override
	public boolean
	onTouch(View v, MotionEvent event) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		Tags.DialogTags tag_name = (Tags.DialogTags) v.getTag();
		
		switch (event.getActionMasked()) {
		case MotionEvent.ACTION_DOWN:
				switch (tag_name) {
				
				case dlg_generic_dismiss:
				case dlg_generic_dismiss_third_dialog:
				case dlg_generic_dismiss_second_dialog:
				case dlg_edit_locs_btn_ok:
					
					v.setBackgroundColor(Color.GRAY);
					
					break;
				}//switch (tag_name)
		
			break;//case MotionEvent.ACTION_DOWN:
			
		case MotionEvent.ACTION_UP:
			switch (tag_name) {

			case dlg_generic_dismiss:
			case dlg_generic_dismiss_second_dialog:
			case dlg_generic_dismiss_third_dialog:
			case dlg_edit_locs_btn_ok:

				v.setBackgroundColor(Color.WHITE);
					
				break;
			}//switch (tag_name)
		
			break;//case MotionEvent.ACTION_UP:
		
		}//switch (event.getActionMasked())
		
		return false;
		
	}//onTouch(View v, MotionEvent event)

}//public class DB_OTL implements OnTouchListener
