package experiments.tasks;

import experiments.utils.CONS;
import experiments.utils.Methods_LM;
import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Vibrator;
import android.util.Log;
import android.widget.Toast;

public class Task_PostLoc extends AsyncTask<String, Integer, Integer> {

	Activity actv;
	
	Vibrator vib;
	
	public Task_PostLoc(Activity actv) {
		super();
		this.actv = actv;
		
		vib = (Vibrator) actv.getSystemService(Context.VIBRATOR_SERVICE);
		
	}

	@Override
	protected Integer doInBackground(String... params) {
		// TODO Auto-generated method stub
		
		int result;
		
		// Log
		String log_msg = "params[0]=" + params[0];
		
		Log.d("["
				+ "Task_PostLoc.java : "
				+ +Thread.currentThread().getStackTrace()[2]
						.getLineNumber() + " : "
						+ Thread.currentThread().getStackTrace()[2].getMethodName()
						+ "]", log_msg);
		
		if (params[0].equals(CONS.TaskData.TaskItems.PostLoc.toString())) {
			
			result = Methods_LM.post_Loc(actv);

			
		} else {//if (params[0].equals(CONS.TaskData.TaskItems.PostLoc.toString()))
			
			result = CONS.ReturnValues.NOP;
			
		}//if (params[0].equals(CONS.TaskData.TaskItems.PostLoc.toString()))
		
		
		return result;
		
	}//protected String doInBackground(String... params)

	@Override
	protected void onCancelled() {
		// TODO Auto-generated method stub
		super.onCancelled();
	}

	@Override
	protected void onPostExecute(Integer result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		
		vib.vibrate(CONS.Admin.VIB_LENGTH);
		
		// Log
		String log_msg = "Post loc => Done (Result="
				+ String.valueOf(result.intValue())
				+ ")";
		
		Log.d("[" + "Task_PostLoc.java : "
				+ +Thread.currentThread().getStackTrace()[2].getLineNumber()
				+ " : "
				+ Thread.currentThread().getStackTrace()[2].getMethodName()
				+ "]", log_msg);
		
		// debug
		String toa_msg = "Post loc => Done (Result="
					+ String.valueOf(result.intValue())
					+ ")";
		
		Toast.makeText(actv, toa_msg, Toast.LENGTH_SHORT).show();
		
	}//protected void onPostExecute(Integer result)

	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
	}

	@Override
	protected void onProgressUpdate(Integer... values) {
		// TODO Auto-generated method stub
		super.onProgressUpdate(values);
	}

	
}
