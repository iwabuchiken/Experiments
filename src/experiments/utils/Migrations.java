package experiments.utils;

import org.apache.commons.lang.StringUtils;

import android.app.Activity;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

public class Migrations {

	public static void execSql(Activity actv) {
		// TODO Auto-generated method stub
		
		boolean res = _Mig__20140216_080106_ChangeColTypeCreatedAt(actv);
//		boolean res = _Mig__20140214_084333_AddColUploadedAt(actv);
//		boolean res = _Mig__20140212_101940_CreateTable(actv);
//		String sql = _Sql__20140212_101940_CreateTable(actv);
		
		
		
	}

	private static boolean
	_Mig__20140216_080106_ChangeColTypeCreatedAt
	(Activity actv) {

		
		
//		__Mig__20140216_080106_DropTable_Old(actv);
		
//		__Mig__20140216_080106_RenameTable_New2Old(actv);
		
//		__Mig__20140216_080106_DropTable_New(actv);
		
//		__Mig__20140216_080106_CreateTable_New(actv);
		
//		__Mig__20140216_080106_InsertData_FromOldTable(actv);
		
		return false;
		
	}//_Mig__20140216_080106_ChangeColTypeCreatedAt

	private static void
	__Mig__20140216_080106_RenameTable_New2Old(Activity actv) {
		// TODO Auto-generated method stub
		DBUtils dbu = new DBUtils(actv, CONS.DB.dbName_LM);
		
		SQLiteDatabase wdb = dbu.getWritableDatabase();

		String sql = StringUtils.join(
						new String[]{
								"ALTER TABLE",
								CONS.DB.tname_Location + "_new",
								"RENAME TO",
								CONS.DB.tname_Location,
						},
						" ");
		
		// Log
		String log_msg = "sql=" + sql;

		Log.d("[" + "Methods_LM.java : "
				+ +Thread.currentThread().getStackTrace()[2].getLineNumber()
				+ " : "
				+ Thread.currentThread().getStackTrace()[2].getMethodName()
				+ "]", log_msg);
		
		/*********************************
		 * Exec sql
		 *********************************/
		try {
			
			wdb.execSQL(sql);
			
			// Log
			log_msg = "sql => done";

			Log.d("["
					+ "Methods_LM.java : "
					+ +Thread.currentThread().getStackTrace()[2]
							.getLineNumber() + " : "
					+ Thread.currentThread().getStackTrace()[2].getMethodName()
					+ "]", log_msg);
		} catch (SQLException e) {
			
			// Log
			log_msg = e.toString();

			Log.d("["
					+ "Methods_LM.java : "
					+ +Thread.currentThread().getStackTrace()[2]
							.getLineNumber() + " : "
					+ Thread.currentThread().getStackTrace()[2].getMethodName()
					+ "]", log_msg);
			
//			e.printStackTrace();
		}		
	}

	private static void
	__Mig__20140216_080106_DropTable_Old(Activity actv) {
		// TODO Auto-generated method stub

		DBUtils dbu = new DBUtils(actv, CONS.DB.dbName_LM);
		
		SQLiteDatabase wdb = dbu.getWritableDatabase();
		
		dbu.dropTable(actv, wdb, CONS.DB.tname_Location);
		
		wdb.close();

	}

	//REF http://stackoverflow.com/questions/4253804/insert-new-column-into-table-in-sqlite answered Nov 23 '10 at 7:59
	private static void
	__Mig__20140216_080106_InsertData_FromOldTable(
			Activity actv) {
		// TODO Auto-generated method stub
		DBUtils dbu = new DBUtils(actv, CONS.DB.dbName_LM);
		
		SQLiteDatabase wdb = dbu.getWritableDatabase();

		String sql = __Mig__20140216_080106_BuildSql();
		
		// Log
		String log_msg = "sql=" + sql;

		Log.d("[" + "Methods_LM.java : "
				+ +Thread.currentThread().getStackTrace()[2].getLineNumber()
				+ " : "
				+ Thread.currentThread().getStackTrace()[2].getMethodName()
				+ "]", log_msg);
		
		/*********************************
		 * Exec sql
		 *********************************/
		try {
			
			wdb.execSQL(sql);
			
			// Log
			log_msg = "sql => done";

			Log.d("["
					+ "Methods_LM.java : "
					+ +Thread.currentThread().getStackTrace()[2]
							.getLineNumber() + " : "
					+ Thread.currentThread().getStackTrace()[2].getMethodName()
					+ "]", log_msg);
		} catch (SQLException e) {
			
			// Log
			log_msg = e.toString();

			Log.d("["
					+ "Methods_LM.java : "
					+ +Thread.currentThread().getStackTrace()[2]
							.getLineNumber() + " : "
					+ Thread.currentThread().getStackTrace()[2].getMethodName()
					+ "]", log_msg);
			
//			e.printStackTrace();
		}
		
	}

	
	private static void
	__Mig__20140216_080106_CreateTable_New(Activity actv) {
		// TODO Auto-generated method stub
		DBUtils dbu = new DBUtils(actv, CONS.DB.dbName_LM);
		
		SQLiteDatabase wdb = dbu.getWritableDatabase();
	
		dbu.createTable(wdb,
				CONS.DB.tname_Location + "_new",
				CONS.DB.cols_Locations_Names_skimmed,
				CONS.DB.cols_Locations_Types_skimmed);
		
		wdb.close();
		
	}

	private static void
	__Mig__20140216_080106_DropTable_New(Activity actv) {
		// TODO Auto-generated method stub
		DBUtils dbu = new DBUtils(actv, CONS.DB.dbName_LM);
		
		SQLiteDatabase wdb = dbu.getWritableDatabase();
		
		dbu.dropTable(actv, wdb, CONS.DB.tname_Location + "_new");
		
		wdb.close();
		
	}

	private static String
	__Mig__20140216_080106_BuildSql() {
		// TODO Auto-generated method stub
		
		String columns = StringUtils.join(
							CONS.DB.cols_Locations_Names,
							", ");
		
		
		String sql = StringUtils.join(
						new String[]{
								"INSERT INTO",
								CONS.DB.tname_Location + "_new",
								"(",
								columns,
								")",
								"SELECT",
								columns,
								"FROM",
								CONS.DB.tname_Location
						},
						" ");
		
		return sql;
		
	}//__Mig__20140216_080106_BuildSql()
	

	private static boolean
	_Mig__20140214_084333_AddColUploadedAt(Activity actv) {

		
		return DBUtils.add_Column_To_Table(
				actv,
				CONS.DB.dbName_LM, CONS.DB.tname_Location,
				CONS.DB.cols_Locations_Names_skimmed[3],
				CONS.DB.cols_Locations_Types_skimmed[3]);
		
	}//_Mig__20140214_084333_AddColUploadedAt(Activity actv)

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
