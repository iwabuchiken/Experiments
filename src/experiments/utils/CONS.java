package experiments.utils;

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
			"INTEGER",			// 0
			"TEXT",			// 1
			"TEXT",			// 2
			
			"INTEGER",		// 3
			"INTEGER",		// 4
			"TEXT",			// 5
			
			"TEXT",			// 6
		};
		
		public static final String[] cols_Locations_Names_skimmed	= {
			
			"longitude",						// 0
			"latitude",							// 1
			"memo",								// 2
			
			"uploaded_at"						// 3
			
		};
		
		public static final String[] cols_Locations_Types_skimmed	= {
			
				"TEXT",				// 0
				"TEXT",				// 1
				"TEXT",				// 2
				
				"TEXT",				// 3
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

		/*********************************
		 * SQL
		 *********************************/
		public static String SQLToken_ID = 
							android.provider.BaseColumns._ID
							+ " INTEGER PRIMARY KEY AUTOINCREMENT, ";
		
		public static String SQLToken_TimeStamps = 
							"created_at TEXT, modified_at TEXT, ";
		
	}//public static class DB

	public static class ReturnValues {
		/*********************************
		 * DB: Successes: 10 ~
		 *********************************/
		public static final int DB_BACKUP_SUCCESSFUL	= 10;
		
		public static final int DB_RESTORE_SUCCESSFUL	= 11;
		
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
		
		public static final int BuildLocsFailed		= -19;

		/*********************************
		 * DB-related: -20 ~
		 *********************************/
		public static final int DB_DOESNT_EXIST			= -20;
		
		public static final int DB_CANT_CREATE_FOLDER	= -21;
		
		public static final int DB_RESTORE_FAILED		= -22;
		
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

	public static class HTTPData {
		
		public static String UrlPostLM
//				= "http://cosmos-jqm-1.herokuapp.com/items/new";
					= "http://cosmos-jqm-1.herokuapp.com/sl/items/new";
		
		// http://cosmos-jqm-1.herokuapp.com/items/new
		
		public static String[] lmKeys = {
			
					"lm_mobile_id",
					"lm_mobile_created_at",
					"lm_mobile_modified_at",
					
					"lm_longitude",
					"lm_latitude",
					
					"lm_memo"
					
		};
		
		/*********************************
		 * Posting data => Types
		 *********************************/
		public static enum registerChoice {
			single_item,
			
			pur_history,
		};
		
		/*********************************
		 * Passwords
		 *********************************/
		public static final String PASSWD_LM_Key		= "passwd_lm";
		
		public static final String PASSWD_LM_NewLoc		= "lm_NewLoc";
		
		/*********************************
		 * Others
		 *********************************/
		public static final String PostItems_SeparatorString
					= " ";
		
	}//public static class HTTPData

	public static class HTTPResponse {
		/*********************************
		 * 2xx
		 *********************************/
		public static final int ServiceReady	= 220;
		
		/*********************************
		 * 4xx
		 *********************************/
		public static final int BadRequest	= 400;
		
		public static final int NotFound		= 404;
		
		/*********************************
		 * 5xx
		 *********************************/
		public static final int ServerError	= 500;
	}

	public static class TaskData {
		
		public static enum TaskItems {
			
			PostLoc,
			
		}
		
	}//public static class TaskData

	public static class Others {
		
		public static enum TimeLabelTypes {
			
			Readable,
			Serial,
			
		}

		public static String SpaceChar		= " ";
	}//public static class Others
	
}//public class CONS
