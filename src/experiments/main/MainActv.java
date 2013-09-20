package experiments.main;

import java.util.ArrayList;

import experiments.utils.CONS.Admin;
import experiments.utils.CONS;
import experiments.utils.Methods;
import android.os.Bundle;
import android.os.Vibrator;
import android.app.ListActivity;
import android.content.Context;
import android.view.KeyEvent;
import android.view.Menu;
import android.widget.ArrayAdapter;

public class MainActv extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.actv_main);
		
		this.setTitle(this.getClass().getName());
		
		Admin.vib = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		
		/*********************************
		 * Prep: ListView
		 *********************************/
		// List items
		CONS.Admin.list_MainActv = new ArrayList<String>();
		
		CONS.Admin.list_MainActv.add(this.getString(R.string.mainactv_list_position));
		
		CONS.Main.mainAdapter = new ArrayAdapter<String>(
									this, 
									android.R.layout.simple_list_item_1, 
									CONS.Admin.list_MainActv);
		
		// Set list to the view
		this.setListAdapter(CONS.Main.mainAdapter);
		
	}
	
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
