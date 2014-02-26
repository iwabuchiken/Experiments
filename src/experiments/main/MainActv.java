package experiments.main;

import java.util.ArrayList;

import experiments.listeners.List_ILCL;
import experiments.utils.CONS;
import experiments.utils.Methods;
import experiments.utils.Tags;
import experiments.utils.CONS.Admin;
import android.os.Bundle;
import android.os.Vibrator;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActv extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.actv_main);
		
		this.setTitle(this.getClass().getName());
		
		Admin.vib = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
	}

	@Override
	protected void
	onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
		ListView lv = this.getListView();
		
		String itemName = (String) lv.getItemAtPosition(position);

		if (itemName.equals(this.getString(R.string.mainactv_list_position))) {
			
			_onItemClick__LocationManager();
			
		} else {//if (itemName.equals(this.getString(R.string.mainactv_list_position)))

			// debug
			String toa_msg = itemName;
			Toast.makeText(this, toa_msg, Toast.LENGTH_LONG).show();
			
		}//if (itemName.equals(this.getString(R.string.mainactv_list_position)))
		
		
	}//onListItemClick(ListView l, View v, int position, long id)

	private void
	_onItemClick__LocationManager() {
		// TODO Auto-generated method stub
		Intent i = new Intent();
		
		i.setClass(this, LocationActv.class);
		
		/*********************************
		 * 3. Start
		 *********************************/
		startActivity(i);
		
		//REF no animation http://stackoverflow.com/questions/6972295/switching-activities-without-animation answered Nov 19 '13 at 21:42
		this.overridePendingTransition(0, 0);
		
	}//_onItemClick__LocationManager()

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		
		/*********************************
		 * Prep: ListView
		 *********************************/
		// List items
		CONS.Admin.list_MainActv = new ArrayList<String>();
		
		CONS.Admin.list_MainActv.add(
					this.getString(R.string.mainactv_list_position));
		
		CONS.Main.mainAdapter = new ArrayAdapter<String>(
									this, 
									android.R.layout.simple_list_item_1, 
									CONS.Admin.list_MainActv);
		
		// Set list to the view
		this.setListAdapter(CONS.Main.mainAdapter);
		
		/*********************************
		 * Set: Listener
		 *********************************/
		set_listener_to_list();
		
	}

	private void set_listener_to_list() {
		/*********************************
		 * 1. Long click
		 * 
		 * 2. On touch
		 *********************************/
		ListView lv = this.getListView();
		
//		lv.setTag(Methods.ItemTags.dir_list);
		lv.setTag(Tags.ListTags.actv_main_lv);
		
		lv.setOnItemLongClickListener(new List_ILCL(this));
		
		/*********************************
		 * 2. On touch
		 *********************************/
		
		
	}//private void set_listener_to_list()

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_actv, menu);
		return true;
	}


	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		
		Methods.confirm_quit(this, keyCode);
		
		return super.onKeyDown(keyCode, event);
	}
	
}
