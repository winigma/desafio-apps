package br.com.wisley.desafioapps.network.requesthelper;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import br.com.wisley.desafioapps.model.Content;
import br.com.wisley.desafioapps.model.Result;
import br.com.wisley.desafioapps.network.APIs;
import br.com.wisley.desafioapps.network.GsonSimpleRequest;
import br.com.wisley.desafioapps.network.requesthelper.contracts.IContentRequest;

/**
 * Created by Wisley on 12/09/17.
 */

public class ContentRequestHelper<T> extends BaseRequestHelper<T> {
    private IContentRequest mPresenter;

    public ContentRequestHelper(Class<T> clazz, IContentRequest mPresenter) {
        super(clazz);
        this.mPresenter = mPresenter;
    }

    /**
     * this method call news content
     */
    public void getContent() {
        final GsonSimpleRequest<Result> request = new GsonSimpleRequest<>(
                Request.Method.GET,
                APIs.URL_CONTENT,
                Result.class,
                null,
                new Response.Listener<Result>() {
                    @Override
                    public void onResponse(Result response) {
                        mPresenter.notifySuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        mPresenter.notifyFailure(getErrorResponse(error));
                    }
                });

        startRequest(request);

    }

}
