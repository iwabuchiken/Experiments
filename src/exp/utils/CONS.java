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
		 * DB names
		 *********************************/
		public static final String dbName_LM = "db_LM.db";
		
		/*********************************
		 * Table: locations
		 *********************************/
		public static final String tname_Location	= "locations";
		
		public static final String[] cols_Locations_Names	= {
				android.provider.BaseColumns._ID,	// 0
				"created_at",						// 1
				"modified_at",						// 2

				"longitude",						// 3
				"latitude",							// 4
				"memo",								// 5
				
				"uploaded_at"						// 6
		};
		
		public static final String[] cols_Locations_Types	= {
			"TEXT",
			"INTEGER",
			"INTEGER",
			
			"INTEGER",
			"INTEGER",
			"TEXT",
		};
		
		public static final String[] cols_Locations_Names_skimmed	= {
			
			"longitude",						// 0
			"latitude",							// 1
			"memo",								// 2
			
			"uploaded_at"						// 3
			
		};
		
		public static final String[] cols_Locations_Types_skimmed	= {
			
				"INTEGER",				// 0
				"INTEGER",				// 1
				"TEXT",					// 2
				
				"INTEGER",				// 3
		};
		
		/*********************************
		 * Paths
		 *********************************/
		public static String dpath_ExternalStorage = "/mnt/sdcard-ext";

//		public static String dirPath_db = "/data/data/shoppinglist.main/databases";
		public static String dpath_Db = "/data/data/experiments.main/databases";
		
		public static String fname_Db_Backup_trunk = "LM_backup";

		public static String fname_Db_Backup_ext = ".bk";

		public static String dpath_Db_Backup = 
							dpath_ExternalStorage + "/LM_backup";

		
	}//public static class DB

	public static class ReturnValues {
		/*********************************
		 * DB: Successes: 10 ~
		 *********************************/
		public static final int DB_BACKUP_SUCCESSFUL	= 10;
		
		/*********************************
		 * Operation failed: -10 ~
		 *********************************/
		public static final int QueryFailed		= -10;
		
		public static final int BuildJOBodyFailed	= -11;
		
		public static final int BuildEntityFailed	= -12;
		
		public static final int BuildHttpPostFailed	= -13;
		
		public static final int HttpPostFailed		= -14;
		
		public static final int PostedButNotUpdated	= -15;
		
		public static final int ServerError		= -16;
		
		public static final int ClientError		= -17;
		
		public static final int ParamVariableNull	= -18;

		/*********************************
		 * DB-related: -20 ~
		 *********************************/
		public static final int DB_DOESNT_EXIST		= -20;
		
		public static final int DB_CANT_CREATE_FOLDER	= -21;
		
		/*********************************
		 * File-related: -30 ~
		 *********************************/
		public static final int FileNotFoundException	= -30;
		
		public static final int IOException			= -31;
		
		
		/*********************************
		 * Others: > 0, <= -90
		 *********************************/
		public static final int OK				= 1;
		
		public static final int NOP				= -90;
		
		public static final int FAILED			= -91;
		
		public static final int MAGINITUDE_ONE	= 1000;
		
	}//public static class ReturnValues

}
