package experiments.utils;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import experiments.items.Loc;

import android.app.Activity;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

public class Methods_LM {


	/*********************************
	 * @return true => Insertion succeeded
	 *********************************/
	public static boolean
	save_LocData(Activity actv) {
		// TODO Auto-generated method stub
		DBUtils dbu = new DBUtils(actv, CONS.DB.dbName_LM);
		
		SQLiteDatabase wdb = dbu.getWritableDatabase();
		
		/*********************************
		 * Table exists?
		 *********************************/
		boolean res = dbu.tableExists(wdb, CONS.DB.tname_Location);
		
		if (res == true) {
			
//			// debug
//			String toa_msg = "Table exists => " + CONS.DB.tname_Location;
//			Toast.makeText(actv, toa_msg, Toast.LENGTH_SHORT).show();
			
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
		String[] colNames = Arrays.copyOfRange(CONS.DB.cols_Locations_Names, 1, 5);
//		"created_at",						// 2
//		"modified_at",						// 3
//
//		"longitude",						// 4
//		"latitude",							// 5
//		"memo",								// 6
		String[] values = new String[]{
				// created_at
				String.valueOf(
						Methods.getTimeLabel(Methods.getMillSeconds_now())),
				// modified_at		
				String.valueOf(
						Methods.getTimeLabel(Methods.getMillSeconds_now())),
				// longitude		
				String.valueOf(CONS.LocData.LONGITUDE),
				// latitude
				String.valueOf(CONS.LocData.LATITUDE),
				// memo
				""
		};
		
		res = dbu.insertData(wdb, CONS.DB.tname_Location, colNames, values);
		
		// Log
		String log_msg = "res => " + res;

		Log.d("[" + "Methods_LM.java : "
				+ +Thread.currentThread().getStackTrace()[2].getLineNumber()
				+ " : "
				+ Thread.currentThread().getStackTrace()[2].getMethodName()
				+ "]", log_msg);
		
		if (res == true) {
			
			// debug
			String toa_msg = "Location => Saved";
			Toast.makeText(actv, toa_msg, Toast.LENGTH_SHORT).show();
			
		} else {//if (res == true)
			
			// debug
			String toa_msg = "Location => Wasn't saved";
			Toast.makeText(actv, toa_msg, Toast.LENGTH_SHORT).show();
			
		}//if (res == true)
		
		
		wdb.close();
		
		return res;
		
	}//save_LocData(Activity actv)

	public static int post_Loc(Activity actv) {
		// TODO Auto-generated method stub
		
		List<Loc> locs = Methods_LM.get_Locs(actv);
		
		Loc loc = locs.get(0);

		// Log
		String log_msg = "locs => " + locs.size();

		Log.d("[" + "Methods_LM.java : "
				+ +Thread.currentThread().getStackTrace()[2].getLineNumber()
				+ " : "
				+ Thread.currentThread().getStackTrace()[2].getMethodName()
				+ "]", log_msg);
		
		/*********************************
		 * JSONBody
		 *********************************/
		JSONObject joBody = Methods_LM._post_Loc_GetJsonBody(actv, loc);
		
		/*********************************
		 * Build: HTTP object
		 *********************************/
		String url = CONS.HTTPData.UrlPostLM;

		HttpPost httpPost = _post_Loc_Get_HttpPost(url, joBody);
		
		if (httpPost == null) {
			
			// Log
			Log.d("["
					+ "Methods_LM.java : "
					+ +Thread.currentThread().getStackTrace()[2]
							.getLineNumber() + " : "
					+ Thread.currentThread().getStackTrace()[2].getMethodName()
					+ "]", "httpPost => null");
			
			return CONS.ReturnValues.BuildHttpPostFailed;
			
		}
		
		// Log
		Log.d("[" + "Methods_LM.java : "
				+ +Thread.currentThread().getStackTrace()[2].getLineNumber()
				+ " : "
				+ Thread.currentThread().getStackTrace()[2].getMethodName()
				+ "]",
				"httpPost => " + httpPost.toString()
				+ "(" + httpPost.getURI().toString() + ")"
				);
		

	    /***************************************
		 * Post
		 ***************************************/
		int iRes = _doInBackground__4_PostData(httpPost);
		
		if (iRes != CONS.ReturnValues.OK) {
			
			return iRes;
			
		}

		/*********************************
		 * Update: SI.posted_at
		 *********************************/
		boolean res = Methods_LM.update_LM(actv, loc);
		
		if (res == false) {
			
			return CONS.ReturnValues.PostedButNotUpdated;
			
		}

		return CONS.ReturnValues.OK;
//		return CONS.ReturnValues.NOP;
		
	}//public static int post_Loc(Activity actv)

	public static boolean
	update_LM(Activity actv, Loc loc) {
		
//		DBUtils dbu = new DBUtils(actv);
//		
//		return dbu.updateData_SI_all_V2(loc);
		
		return false;
		
	}//update_SI(Activity actv, ShoppingItem si)

	private static int
	_doInBackground__4_PostData(HttpPost httpPost) {
		// TODO Auto-generated method stub
	    DefaultHttpClient dhc = new DefaultHttpClient();
	    
		HttpResponse hr = null;
		
		try {
			
			hr = dhc.execute(httpPost);
			
		} catch (ClientProtocolException e) {
			// Log
			Log.d("Methods_LM.java" + "["
					+ Thread.currentThread().getStackTrace()[2].getLineNumber()
					+ "]", e.toString());
			
			return CONS.ReturnValues.HttpPostFailed;
			
		} catch (IOException e) {
			
			// Log
			Log.d("Methods_LM.java" + "["
					+ Thread.currentThread().getStackTrace()[2].getLineNumber()
					+ "]", e.toString());
			
			return CONS.ReturnValues.HttpPostFailed;
			
		}
		
		if (hr == null) {
		
			// Log
			Log.d("Methods_LM.java" + "["
					+ Thread.currentThread().getStackTrace()[2].getLineNumber()
					+ "]", "hr => null");
			
			return CONS.ReturnValues.HttpPostFailed;
			
		}//if (hr == null)
	
		// Log
		Log.d("[" + "Methods_LM.java : "
				+ +Thread.currentThread().getStackTrace()[2].getLineNumber()
				+ " : "
				+ Thread.currentThread().getStackTrace()[2].getMethodName()
				+ "]", "hr => " + hr.getStatusLine().getStatusCode());
		
		/*********************************
		 * Check: HTTP return code
		 *********************************/
		int iRes = _doInBackground__3_CheckHTTPCodes(hr);
		
		if (iRes != CONS.ReturnValues.OK) {
			
			return iRes;
			
		}
		
		return CONS.ReturnValues.OK;
		
	}//_doInBackground__4_PostData(HttpPost httpPost)

	private static int 
	_doInBackground__3_CheckHTTPCodes(HttpResponse hr) {
		// TODO Auto-generated method stub
		int status = hr.getStatusLine().getStatusCode();
		
		if (status >= CONS.HTTPResponse.ServerError) {
		
			// Log
			Log.d("Task_GetYomi.java" + "["
					+ Thread.currentThread().getStackTrace()[2].getLineNumber()
					+ ":"
					+ Thread.currentThread().getStackTrace()[2].getMethodName()
					+ "]", "status=" + status);
		
			return CONS.ReturnValues.ServerError;
		//	return CONS.HTTP_Response.CREATED;
			
		} else if (status < CONS.HTTPResponse.ServerError
					&& status >= CONS.HTTPResponse.BadRequest){//if (status == CONS.HTTP_Response.CREATED)
			
			// Log
			Log.d("Task_GetYomi.java" + "["
					+ Thread.currentThread().getStackTrace()[2].getLineNumber()
					+ ":"
					+ Thread.currentThread().getStackTrace()[2].getMethodName()
					+ "]", "status=" + status);
		
			return CONS.ReturnValues.ClientError;
			
		} else {//if (status == CONS.HTTP_Response.CREATED)
			
			// Log
			Log.d("Task_GetTexts.java" + "["
					+ Thread.currentThread().getStackTrace()[2].getLineNumber()
					+ ":"
					+ Thread.currentThread().getStackTrace()[2].getMethodName()
					+ "]", "status=" + status);
			
//			return CONS.HTTP_Response.NOT_CREATED;
			
		}//if (status == CONS.HTTP_Response.CREATED)

		return CONS.ReturnValues.OK;
		
	}//_doInBackground__3_CheckHTTPCodes(HttpResponse hr)

	private static HttpPost
	_post_Loc_Get_HttpPost
	(String url, JSONObject joBody) {
		// TODO Auto-generated method stub
		StringEntity se;
		
		HttpPost httpPost = new HttpPost(url);
		
		try {
			
			//REF encoging: http://stackoverflow.com/questions/5084462/how-to-send-unicode-characters-in-an-httppost-on-android answered Feb 22 '11 at 22:38
			se = new StringEntity(joBody.toString(), "UTF-8");
			
			// Log
			Log.d("Methods_LM.java" + "["
					+ Thread.currentThread().getStackTrace()[2].getLineNumber()
					+ ":"
					+ Thread.currentThread().getStackTrace()[2].getMethodName()
					+ "]", "joBody => Set \"UTF-8\"");
			
		} catch (UnsupportedEncodingException e) {
			
			// Log
			Log.d("Methods_LM.java" + "["
					+ Thread.currentThread().getStackTrace()[2].getLineNumber()
					+ ":"
					+ Thread.currentThread().getStackTrace()[2].getMethodName()
					+ "]", e.toString());
			
			return null;
			
		}
		
		httpPost.setEntity(se);
		
		httpPost.setHeader("Accept", "application/json");
	    httpPost.setHeader("Content-type", "application/json");

		return httpPost;
	}//_doInBackground__2_getHttpPost(String url, JSONObject joBody)

	/*********************************
	 * @return null =>	1. Build JSONBody => Failed<br>
	 * 					2. Add password param => Failed
	 *********************************/
	private static JSONObject
	_post_Loc_GetJsonBody(Activity actv, Loc loc) {
		// TODO Auto-generated method stub
//		"lm_mobile_id",
//		"lm_mobile_created_at",
//		"lm_mobile_modified_at",
//		
//		"lm_longitude",
//		"lm_latitude",
//		
//		"lm_memo"
		
		Object[] values = new Object[]{
				
				loc.getId(),
				loc.getCreated_at(),
				loc.getModified_at(),
				
				loc.getLongitude(),
				loc.getLatitude(),
				
				loc.getMemo()
				
		};
		
		String[] keys = CONS.HTTPData.lmKeys;
		
		JSONObject joBody = Methods_LM._post_Loc_Build_JsonBody_LM(keys, values);
		
		if (joBody == null) {
			
			// Log
			String log_msg = "Build JSONBody => Failed";

			Log.d("["
					+ "Methods_LM.java : "
					+ +Thread.currentThread().getStackTrace()[2]
							.getLineNumber() + " : "
					+ Thread.currentThread().getStackTrace()[2].getMethodName()
					+ "]", log_msg);
			
			return null;
			
		}
		
		try {
			
//			joBody.put("passwd[sl]", "abc");
//			joBody.put("pass_sl", "abc");
			joBody.put(
					CONS.HTTPData.PASSWD_LM_Key,
					CONS.HTTPData.PASSWD_LM_NewLoc);
//			CONS.HTTPData.passwdKey_SL,
//			CONS.HTTPData.passwdSL_NewItem);
//			joBody.put("password_sl", "abc");
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			
			// Log
			Log.d("["
					+ "Methods_LM.java : "
					+ +Thread.currentThread().getStackTrace()[2]
							.getLineNumber() + " : "
					+ Thread.currentThread().getStackTrace()[2].getMethodName()
					+ "]",
					
					"add password param => Failed"
					+ "(" + e.getMessage() + ")");
		
			return null;
		}

		return joBody;
		
	}//_post_Loc_GetJsonBody(Activity actv, Loc loc)
	
	/*********************************
	 * @return null => JSONException
	 *********************************/

	private static JSONObject
	_post_Loc_Build_JsonBody_LM
	(String[] keys, Object[] values) {
		// TODO Auto-generated method stub
		
		JSONObject joBody = new JSONObject();
		
		try {
			
			for(int i = 0; i < keys.length; i++) {
				
				joBody.put(keys[i], values[i]);
				
			}
			
		} catch (JSONException e) {
			
			// Log
			Log.d("Methods_LM.java" + "["
					+ Thread.currentThread().getStackTrace()[2].getLineNumber()
					+ ":"
					+ Thread.currentThread().getStackTrace()[2].getMethodName()
					+ "]", e.toString());
			
			return null;
			
		}

		return joBody;
		
	}//_post_Loc_Build_JsonBody_LM
	

	private static List<Loc>
	get_Locs(Activity actv) {
		// TODO Auto-generated method stub
		List<Loc> locs = new ArrayList<Loc>();
		
		DBUtils dbm = new DBUtils(actv);
		
		SQLiteDatabase rdb = dbm.getReadableDatabase();
		
		Cursor c = null;
		
		try {
			
			c = rdb.query(
					CONS.DB.tname_Location, 
					CONS.DB.cols_Locations_Names,
//					CONS.columns_with_index2,
					null, null, null, null, null);
			
			// Log
			String log_msg = "query => done";

			Log.d("["
					+ "Methods_LM.java : "
					+ +Thread.currentThread().getStackTrace()[2]
							.getLineNumber() + " : "
					+ Thread.currentThread().getStackTrace()[2].getMethodName()
					+ "]", log_msg);
			
		} catch (Exception e) {
			
			// Log
			String log_msg = e.toString();

			Log.d("["
					+ "Methods_LM.java : "
					+ +Thread.currentThread().getStackTrace()[2]
							.getLineNumber() + " : "
					+ Thread.currentThread().getStackTrace()[2].getMethodName()
					+ "]", log_msg);
			
			rdb.close();
			
			return null;
			
		}//try

		/*********************************
		 * No entry?
		 *********************************/
		if (c.getCount() < 1) {
			
			// Log
			String log_msg = "No entry";

			Log.d("["
					+ "Methods_LM.java : "
					+ +Thread.currentThread().getStackTrace()[2]
							.getLineNumber() + " : "
					+ Thread.currentThread().getStackTrace()[2].getMethodName()
					+ "]", log_msg);
			
			rdb.close();
			
			return null;
			
		}
		
		/*********************************
		 * Build list
		 *********************************/
		c.moveToFirst();
		
//		android.provider.BaseColumns._ID,	// 0
//		"created_at",						// 1
//		"modified_at",						// 2
//
//		"longitude",						// 3
//		"latitude",							// 4
//		"memo",								// 5
//		
//		"uploaded_at"						// 6
		
		for (int i = 0; i < c.getCount(); i++) {

//			0									1		2		3		4			5
//			{android.provider.BaseColumns._ID, "name", "yomi", "genre", "store", "price"}
			Loc loc = new Loc.Builder()
						.setId			(c.getLong(0))
						.setCreated_at	(c.getString(1))
						.setModified_at	(c.getString(2))
						
						.setLongitude	(c.getString(3))
						.setLatitude	(c.getString(4))
						.setMemo		(c.getString(5))
						
						.setUploaded_at	(c.getString(6))
						
						.build();
			
			//
			locs.add(loc);
			
			//
			c.moveToNext();
			
		}//for (int i = 0; i < c.getCount(); i++)
		
		//
		rdb.close();

		
		return locs;
	}

}//public class Methods_LM
