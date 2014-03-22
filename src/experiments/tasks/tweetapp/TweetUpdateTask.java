package experiments.tasks.tweetapp;

import android.app.Activity;
import android.os.AsyncTask;

public class TweetUpdateTask extends AsyncTask<Object, Void, Void> {

    // Activity取得用
    private Activity activity;

    // コンストラクタ
    public TweetUpdateTask(Activity activity) {
        super();
        this.activity = activity;
    }

	@Override
	protected Void doInBackground(Object... params) {
		// TODO Auto-generated method stub
		return null;
	}

}
