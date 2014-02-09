package exp.listeners.button;

import exp.utils.Tags;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Vibrator;
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
				
				v.setBackgroundColor(Color.GRAY);
				
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
				
			default:
				
				v.setBackgroundColor(Color.WHITE);
				
				break;
				
			}//switch (tag)
			
			break;//case MotionEvent.ACTION_UP:
			
		}//switch (event.getActionMasked())
		
		return false;
		
	}//onTouch(View v, MotionEvent event)

}//public class BOTL implements OnTouchListener
