package experiments.adapters;

import java.util.List;

import experiments.items.Loc;
import experiments.main.R;
import experiments.utils.CONS;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Adp_Loc extends ArrayAdapter<Loc> {

	//
	private int resourceId;
	
	Context con;
	
	public Adp_Loc
	(Context context, int textViewResourceId, List<Loc> list) {
		super(context, textViewResourceId, list);
		// TODO �����������ꂽ�R���X�g���N�^�[�E�X�^�u
		this.con		= context;
		
		this.resourceId = textViewResourceId;
		
		
	}//public Adp_Loc

	@Override
	public View getView(int position, View v, ViewGroup parent) {
		/*----------------------------
		 * Steps
		 * 1. Inflate
		 * 2. Get views
		 * 3. Get item
		 * 4. Set values
		 * 
		 * 5. Set background
			----------------------------*/
		
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		
        if (v == null) {
        	
            LayoutInflater inflater = 
            		(LayoutInflater) getContext()
    					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            
            v = inflater.inflate(resourceId, null);
        }

        Loc loc = (Loc) getItem(position);

        _getView_SetTexts(v, loc, position);

		return v;
//		return super.getView(position, convertView, parent);
	}//public View getView(int position, View convertView, ViewGroup parent)

	private void
	_getView_SetTexts(View v, Loc loc, int position) {
		/*********************************
		 * Day
		 *********************************/
		// Get views
		TextView tv_Date = (TextView) v.findViewById(R.id.listrow_loc_list_tv_date);
		
		// Get data
		String date = loc.getCreated_at();
		
		String day = date.split("_")[0];
		
		tv_Date.setText(day);
		
		/*********************************
		 * Time
		 *********************************/
		// Get views
		TextView tv_Time = (TextView) v.findViewById(R.id.listrow_loc_list_tv_time);
		
		// Get data
		String time = date.split("_")[1];
		
		tv_Time.setText(time);
		
		/*********************************
		 * Longitude
		 *********************************/
		// Get views
		TextView tv_Longi = (TextView) v.findViewById(R.id.listrow_loc_list_tv_longi);
		
		// Get data
		String longi = loc.getLongitude();
		
		if (longi.length() > 12) {
			
			longi = longi.substring(0, 12);
			
		}
		
		tv_Longi.setText(longi);
		
		/*********************************
		 * Latitude
		 *********************************/
		// Get views
		TextView tv_Lat = (TextView) v.findViewById(R.id.listrow_loc_list_tv_lat);
		
		// Get data
		String lat = loc.getLatitude();
		
		if (lat.length() > 12) {
					
			lat = lat.substring(0, 12);
			
		}
		
		tv_Lat.setText(lat);

		/*********************************
		 * Memo
		 *********************************/
		String memo = loc.getMemo();
		
		TextView tv_Memo = (TextView) v.findViewById(R.id.listrow_loc_list_tv_memo);
		
		if (memo != null) {
			
			tv_Memo.setText(memo);
			
		} else {
			
			tv_Memo.setText("");
			
		}
		
		/*********************************
		 * Background
		 *********************************/
		// TODO Auto-generated method stub
		SharedPreferences prefs = ((Activity)con).getSharedPreferences(
				CONS.Prefs.pName_LM,
				Context.MODE_PRIVATE);
		
		int savedPosition = prefs.getInt(
				CONS.Prefs.pKey_CurrentItemPosition,
				-1);

		if (savedPosition == position) {
			
			tv_Longi.setBackgroundResource(R.color.gold2);
			tv_Longi.setTextColor(Color.BLACK);
			
			tv_Lat.setBackgroundResource(R.color.gold2);
			tv_Lat.setTextColor(Color.BLACK);
			
		} else if (savedPosition == -1) {//if (savedPosition == position)
			
		} else {//if (savedPosition == position)
			
			tv_Longi.setBackgroundColor(Color.BLACK);
			tv_Longi.setTextColor(Color.WHITE);
			
			tv_Lat.setBackgroundColor(Color.BLACK);
			tv_Lat.setTextColor(Color.WHITE);
			
		}//if (savedPosition == position)
		
	}//_getView_SetTexts(View convertView, Loc loc)

}//public class ItemListAdapter extends ArrayAdapter<ShoppingItem>
