package br.com.wisley.desafioapps.network;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.JsonSyntaxException;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

import br.com.wisley.desafioapps.util.Utils;

/**
 * Created by Murilo on 06/10/16.
 */

public class GsonContentRequest<T> extends GsonRequest<T> {

    /**
     * @param method        Method of the request (GET, POST, PUT, DELETE)
     * @param url           URL of the request to make
     * @param clazz         Relevant class object, for Gson's reflection
     * @param object        Object to call POST and PUT
     * @param listener
     * @param errorListener
     */
    public GsonContentRequest(int method, String url, Class<T> clazz,
                              Object object, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        super(method, url, clazz, object, listener, errorListener);
    }

    /**
     * @param method        Method of the request (GET, POST, PUT, DELETE)
     * @param url           URL of the request to make
     * @param clazz         Relevant class object, for Gson's reflection
     * @param listener
     * @param errorListener
     */
    public GsonContentRequest(int method, String url, Class<T> clazz,
                              Response.Listener<T> listener, Response.ErrorListener errorListener) {
        super(method, url, clazz, null, listener, errorListener);
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {

            String json = new String(response.data, HttpHeaderParser
                    .parseCharset(response.headers));
            try {
                JSONObject jsonObject = new JSONObject(json);

                if (!jsonObject.isNull("result")) {
                    if (Utils.isJsonObject(jsonObject, "result"))
                        return Response.success(
                                gson.fromJson(jsonObject
                                        .getJSONObject("result").toString(), clazz),
                                HttpHeaderParser.parseCacheHeaders(response));
                    else
                        return Response.success(
                                gson.fromJson(jsonObject
                                        .getJSONArray("result").toString(), clazz),
                                HttpHeaderParser.parseCacheHeaders(response));
                } else {
                    final String userErrorKey = "userErrorKey";
                    if (jsonObject.has(userErrorKey)) {
                        VolleyError error = new VolleyError(jsonObject
                                .getString(userErrorKey));
                        return Response.error(error);
                    }
                }
                return Response.success(gson.fromJson(jsonObject.toString(), clazz),
                        HttpHeaderParser.parseCacheHeaders(response));

            } catch (JSONException e) {
                return Response.error(new ParseError(e));
            }
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JsonSyntaxException e) {
            return Response.error(new ParseError(e));
        }
    }

    @Override
    protected VolleyError parseNetworkError(VolleyError volleyError) {

        try {
            if (volleyError != null && volleyError.networkResponse != null) {
                String json = new String(volleyError.networkResponse.data, HttpHeaderParser
                        .parseCharset(volleyError.networkResponse.headers));

                JSONObject jsonObject = new JSONObject(json);
                final String result = "result";
                if (jsonObject.has(result)) {
                    final String errors = "errors";
                    jsonObject = jsonObject.getJSONObject(result);
                    if (jsonObject.has(errors))
                        return new VolleyError(jsonObject
                                .getString(errors));
                }
            } else {
                return volleyError;
            }
        } catch (UnsupportedEncodingException e) {
            return new VolleyError(new ParseError(e));
        } catch (JSONException e) {
            return new VolleyError(new ParseError(e));
        }
        return super.parseNetworkError(volleyError);
    }
}
