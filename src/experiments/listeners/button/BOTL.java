package experiments.listeners.button;

import experiments.main.R;
import experiments.utils.Tags;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Vibrator;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class BOTL implements OnTouchListener {

	Activity actv;

	//
	Vibrator vib;
	
	public BOTL(Activity actv) {
		//
		this.actv = actv;
		
		vib = (Vibrator) actv.getSystemService(Context.VIBRATOR_SERVICE);
	}

	public boolean
	onTouch(View v, MotionEvent event) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		Tags.ButtonTags tag = (Tags.ButtonTags) v.getTag();
		
		switch (event.getActionMasked()) {
		case MotionEvent.ACTION_DOWN:
			
			switch (tag) {
			
			case GetData:
			case PostData:
			case ShowMap:
				
				v.setBackgroundColor(Color.GRAY);
				
//				v.setBackgroundColor(
//						actv.getResources().getColor(R.color.gray1));
				
				break;
				
			case SaveData:
				
//				v.setBackgroundColor(actv.getResources().getColor(R.color.darkgreen));
				v.setBackgroundColor(Color.GRAY);
				
				// Log
				String log_msg = "v => " + v.getClass().toString();

				Log.d("["
						+ "BOTL.java : "
						+ +Thread.currentThread().getStackTrace()[2]
								.getLineNumber()
						+ " : "
						+ Thread.currentThread().getStackTrace()[2]
								.getMethodName() + "]", log_msg);
				
				break;
				
			default:
				
				v.setBackgroundColor(Color.GRAY);
				
				break;
				
			}//switch (tag)
			
			break;//case MotionEvent.ACTION_DOWN:
			
			
		case MotionEvent.ACTION_UP:
			switch (tag) {
			case GetData:
				
				v.setBackgroundColor(Color.BLUE);
				
				break;

			case PostData:
				
				v.setBackgroundColor(
						actv.getResources().getColor(R.color.brown));
				
				break;

			case SaveData:
				
				v.setBackgroundColor(actv.getResources().getColor(R.color.darkgreen));
//				v.setBackgroundColor(Color.GREEN);
				
				break;
				
			case ShowMap:
				
				v.setBackgroundColor(
						actv.getResources().getColor(R.color.gold2));
				
				break;
				
			default:
				
				v.setBackgroundColor(Color.WHITE);
				
				break;
				
			}//switch (tag)
			
			break;//case MotionEvent.ACTION_UP:
			
		}//switch (event.getActionMasked())
		
		return false;
		
	}//onTouch(View v, MotionEvent event)

}//public class BOTL implements OnTouchListener
