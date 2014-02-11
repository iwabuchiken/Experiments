package exp.utils;

import java.io.File;
import java.util.ArrayList;

import android.database.sqlite.SQLiteDatabase;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.widget.ArrayAdapter;

public class CONS {

	public static class Admin {
		
		public static Vibrator vib;
		
		public static final int VIB_LENGTH = 50;
		
		public static ArrayList<String> list_MainActv;
	}
	
	public static class Main {
		
		public static ArrayAdapter mainAdapter;
		
	}
	
	public static class LocData {
		
		public static Double LONGITUDE;
		public static Double LATITUDE;
		
//		public static final int MaximumFractionDigits	= 5;
		public static final int MaximumFractionDigits	= 9;
		
	}


	public static class Prefs {
		
	}

	public static class DB {
		/*********************************
		 * Table: locations
		 *********************************/
		public static final String tname_Location	= "locations";
		
		public static final String[] cols_Locations_Names	= {
				android.provider.BaseColumns._ID,	// 1
				"created_at",						// 2
				"modified_at",						// 3

				"longitude",						// 4
				"latitude",							// 5
				"memo",								// 6
		};
		
		public static final String[] cols_Locations_Types	= {
				"TEXT",
				"INTEGER",
				"INTEGER",
				
				"INTEGER",
				"INTEGER",
				"TEXT",
		};
		
		
	}//public static class DB
}
