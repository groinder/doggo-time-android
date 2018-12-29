package groinder.doggotime;

import android.os.Bundle;

import com.loopj.android.http.*;

public class DoggoTimeAPIClient {
    private static final String BASE_URL = "http://127.0.0.1:5000/api/";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void setAuth(Bundle credentials) {
        client.setBasicAuth(credentials.getString("email"), credentials.getString("password"));
    }

    public static void get(String url, AsyncHttpResponseHandler responseHandler) {
        client.get(getAbsoluteUrl(url), null, responseHandler);
    }

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void post(String url, AsyncHttpResponseHandler responseHandler) {
        client.post(getAbsoluteUrl(url), null, responseHandler);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }
}
