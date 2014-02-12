package exp.utils;

import org.apache.commons.lang.StringUtils;

import android.app.Activity;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

public class Methods_LM {

	public static void execSql(Activity actv) {
		// TODO Auto-generated method stub
		
		boolean res = _Mig__20140212_101940_CreateTable(actv);
//		String sql = _Sql__20140212_101940_CreateTable(actv);
		
		
		
	}

	private static boolean
	_Mig__20140212_101940_CreateTable(Activity actv) {
		// TODO Auto-generated method stub
		
		DBUtils dbu = new DBUtils(actv, CONS.DB.dbName_LM);
		
		SQLiteDatabase wdb = dbu.getWritableDatabase();
		
		boolean res = dbu.createTable(
						wdb,
						CONS.DB.tname_Location,
						
						CONS.DB.cols_Locations_Names_skimmed,
						CONS.DB.cols_Locations_Types_skimmed);
		
		// Log
		String log_msg = "res => " + res;

		Log.d("[" + "Methods_LM.java : "
				+ +Thread.currentThread().getStackTrace()[2].getLineNumber()
				+ " : "
				+ Thread.currentThread().getStackTrace()[2].getMethodName()
				+ "]", log_msg);
		
		wdb.close();
		
		return false;
	}

	private static String
	_Sql__20140212_101940_CreateTable(Activity actv) {
		// TODO Auto-generated method stub
		String params = "";
		
		params += "(";
		
		for (int i = 0; i < CONS.DB.cols_Locations_Names.length; i++) {
			
			params += CONS.DB.cols_Locations_Names[i]
						+ " "
						+ CONS.DB.cols_Locations_Types[i];
		}
		
		params += ")";
		
		String sql = StringUtils.join(
						new String[]{
								"CREATE TABLE",
								CONS.DB.tname_Location,
								params
						}, " ");
		
		DBUtils dbu = new DBUtils(actv, CONS.DB.dbName_LM);
		
		SQLiteDatabase wdb = dbu.getWritableDatabase();
		
		/*********************************
		 * Table exists?
		 *********************************/
		boolean res = dbu.tableExists(wdb, CONS.DB.tname_Location);
		
		if (res == true) {
			
			// debug
			String toa_msg = "Table exists => " + CONS.DB.tname_Location;
			Toast.makeText(actv, toa_msg, Toast.LENGTH_SHORT).show();
			
			// Log
			String log_msg = "Table exists => " + CONS.DB.tname_Location;

			Log.d("["
					+ "Methods_LM.java : "
					+ +Thread.currentThread().getStackTrace()[2]
							.getLineNumber() + " : "
					+ Thread.currentThread().getStackTrace()[2].getMethodName()
					+ "]", log_msg);
		}
		
		/*********************************
		 * Exec sql
		 *********************************/
		try {
			wdb.execSQL(sql);
		} catch (SQLException e) {
			
			// Log
			String log_msg = e.toString();

			Log.d("["
					+ "Methods_LM.java : "
					+ +Thread.currentThread().getStackTrace()[2]
							.getLineNumber() + " : "
					+ Thread.currentThread().getStackTrace()[2].getMethodName()
					+ "]", log_msg);
			
//			e.printStackTrace();
		}
		
		wdb.close();
		
		return sql;
		
	}//_Sql__20140212_101940_CreateTable(Activity actv)

}
