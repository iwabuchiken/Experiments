package experiments.main;

import experiments.listeners.sensors.SEL;
import experiments.utils.CONS;
import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class PMActv extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // レイアウト設定ファイル指定
        setContentView(R.layout.actv_pm);
    }

    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		
		CONS.PM.sensorManager
				.unregisterListener(CONS.PM.sensorEventListener);
		
		// Log
		String log_msg = "CONS.PM.sensorManager => Unregistered";

		Log.d("[" + "PMActv.java : "
				+ +Thread.currentThread().getStackTrace()[2].getLineNumber()
				+ " : "
				+ Thread.currentThread().getStackTrace()[2].getMethodName()
				+ "]", log_msg);
		
	}

	// onStartメソッド(アクティビティ起動イベント)
    @Override
    protected void onStart() {
        super.onStart();
        
        // Log
		String log_msg = "onStart()";

		Log.d("[" + "PMActv.java : "
				+ +Thread.currentThread().getStackTrace()[2].getLineNumber()
				+ " : "
				+ Thread.currentThread().getStackTrace()[2].getMethodName()
				+ "]", log_msg);
		
		_Setup_UIs();
		
//        _Setup_Sensor();
        
    }//protected void onStart()

    private void _Setup_UIs() {
    	
		// TODO Auto-generated method stub
		CONS.PM.tv_X = (TextView) findViewById(R.id.actv_pm_tv_x_val);
		CONS.PM.tv_Y = (TextView) findViewById(R.id.actv_pm_tv_y_val);
		CONS.PM.tv_Z = (TextView) findViewById(R.id.actv_pm_tv_z_val);
		
	}

	private void _Setup_Sensor() {
		// TODO Auto-generated method stub
    	CONS.PM.sensorManager = (SensorManager) this.getSystemService(SENSOR_SERVICE);
    	
    	CONS.PM.accelerometerSensors =
    			CONS.PM.sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);
    	
    	// Listener
    	CONS.PM.sensorEventListener = new SEL(this);
    	
        // 加速度センサーオブジェクトが取得できた場合
        if (CONS.PM.accelerometerSensors.size() > 0) {
            // SensorManagerインスタンスにセンサーイベントリスナーを設定
//        	CONS.PM.sensorManager.registerListener(sensorEventListener,
			CONS.PM.sensorManager.registerListener(
							CONS.PM.sensorEventListener,
							CONS.PM.accelerometerSensors.get(0),
							SensorManager.SENSOR_DELAY_GAME);
			
			// Log
			String log_msg = "CONS.PM.sensorManager => Listener set";

			Log.d("["
					+ "PMActv.java : "
					+ +Thread.currentThread().getStackTrace()[2]
							.getLineNumber() + " : "
					+ Thread.currentThread().getStackTrace()[2].getMethodName()
					+ "]", log_msg);
			
        }

    	
	}//private void _Setup_Sensor()

	// onResumeメソッド(Twitter認証画面後の処理)
    @Override
    protected void onResume() {
    	
        super.onResume();
        
        // Log
		String log_msg = "onResume()";

		Log.d("[" + "PMActv.java : "
				+ +Thread.currentThread().getStackTrace()[2].getLineNumber()
				+ " : "
				+ Thread.currentThread().getStackTrace()[2].getMethodName()
				+ "]", log_msg);
        
        _Setup_Sensor();
        
    }

}
