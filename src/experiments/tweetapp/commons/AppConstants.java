package experiments.tweetapp.commons;

//�A�v���S�̗p�萔
public final class AppConstants {

    private AppConstants() {
    }

    // Request Token�擾�pURL
    public static final String REQUEST_TOKEN_ENDPOINT_URL =
        "https://api.twitter.com/oauth/request_token";

    // Access Token�擾�pURL
    public static final String ACCESS_TOKEN_ENDPOINT_URL =
        "https://api.twitter.com/oauth/access_token";

    // OAuth�F�ؗpURL
    public static final String AUTHORIZATION_WEBSITE_URL =
        "https://api.twitter.com/oauth/authorize";

    // Twitter�F�،�̃R�[���o�b�N�pURL
//    public static final String CALLBACK_URL = "tweetapp://techfuntech";
//    public static final String CALLBACK_URL =
//    			"http://cosmos-jqm-1.herokuapp.com/twitter_app/main?class=link";
    public static final String CALLBACK_URL = "tweetapp://techfun";
//    public static final String CALLBACK_URL = "tweetapp://techfun";

    // �F�ؗpConsumer�L�[
    // URL https://apps.twitter.com/app/5881366/keys
    public static final String CONSUMER_KEY = "GPH7OdrScUbYQ1RpyLkzYg";
//    public static final String CONSUMER_KEY = "oQ9ri0QyuMr9FkR5EUN0Uw";

    // �F�ؗpConsumer Secret�L�[
    public static final String CONSUMER_SECRET =
        "bEWx5aLKLfNQQvqHCugZC7phMDqhKPT12Uwjajbr7o";
//    "2TOsSnzHtiyTtvPKDkH4c9kLkXkAvHIi9O7muw";

    // CommonsHttpOAuthConsumer��n���p�p�����[�^��
    public static final String OAUTH_CONSUMER = "oauthConsumer";

    // �^�C�����C����URI
    public static final String TIMELINE_REQUEST_URL =
        "https://api.twitter.com/1/statuses/home_timeline.json";

    // �Ԃ₫�𓊍e����URI
    public static final String TWEET_REQUEST_URL =
        "https://api.twitter.com/1/statuses/update.json";
    
    // �F�؉�ʂŋ����Ȃ������ꍇ�̔���p
    public static final String REQUEST_TOKEN_DENIED = "denied";
}
