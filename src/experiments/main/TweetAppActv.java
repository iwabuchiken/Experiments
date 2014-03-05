package experiments.main;

import experiments.tweetapp.commons.AppConstants;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthProvider;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.exception.OAuthNotAuthorizedException;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class TweetAppActv extends Activity {

    // OAuth認証コンシューマインスタンス
    private CommonsHttpOAuthConsumer oauthConsumer = null;
    // OAuth認証プロバイダインスタンス
    private CommonsHttpOAuthProvider oauthProvider = null;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // レイアウト設定ファイル指定
        setContentView(R.layout.tweet_app);
    }

    // onStartメソッド(アクティビティ起動イベント)
    @Override
    protected void onStart() {
        super.onStart();

        // コンシューマオブジェクトが設定されていない場合
        if (oauthConsumer == null) {
            // Consumer KeyとConsumer Secretを設定してコンシューマオブジェクト生成
            oauthConsumer =
                new CommonsHttpOAuthConsumer(AppConstants.CONSUMER_KEY,
                    AppConstants.CONSUMER_SECRET);
        }

        // プロバイダオブジェクトが設定されていない場合
        if (oauthProvider == null) {
            // プロバイダオブジェクト生成
            oauthProvider =
                new CommonsHttpOAuthProvider(
                    AppConstants.REQUEST_TOKEN_ENDPOINT_URL,
                    AppConstants.ACCESS_TOKEN_ENDPOINT_URL,
                    AppConstants.AUTHORIZATION_WEBSITE_URL);
        }
        
    }//protected void onStart()

    // onClickBtnLoginメソッド(「ログイン」ボタンクリック処理)
    public void onClickBtnLogin(View v) {
        String authUrl = "";
        try {
            // Twitter認証画面の起動用設定
            authUrl =
                oauthProvider.retrieveRequestToken(oauthConsumer,
                    AppConstants.CALLBACK_URL);
        } catch (OAuthMessageSignerException e) {
            Log.e(getClass().getSimpleName(), "Twitter OAuth Error", e);
        } catch (OAuthNotAuthorizedException e) {
            Log.e(getClass().getSimpleName(), "Twitter OAuth Error", e);
        } catch (OAuthExpectationFailedException e) {
            Log.e(getClass().getSimpleName(), "Twitter OAuth Error", e);
        } catch (OAuthCommunicationException e) {
            Log.e(getClass().getSimpleName(), "Twitter OAuth Error", e);
        }

        // Log
		String log_msg = "authUrl => " + authUrl;

		Log.d("[" + "TweetAppActv.java : "
				+ +Thread.currentThread().getStackTrace()[2].getLineNumber()
				+ " : "
				+ Thread.currentThread().getStackTrace()[2].getMethodName()
				+ "]", log_msg);
		
        // Twitter認証画面起動
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(authUrl)));
		
    }//public void onClickBtnLogin(View v)

}
