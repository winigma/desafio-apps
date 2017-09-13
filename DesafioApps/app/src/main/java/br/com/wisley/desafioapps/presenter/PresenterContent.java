package br.com.wisley.desafioapps.presenter;

import br.com.wisley.desafioapps.model.Content;
import br.com.wisley.desafioapps.model.Result;
import br.com.wisley.desafioapps.model.response.ErrorResponse;
import br.com.wisley.desafioapps.network.requesthelper.ContentRequestHelper;
import br.com.wisley.desafioapps.network.requesthelper.contracts.IContentRequest;
import br.com.wisley.desafioapps.presenter.interfaces.IContentCallback;

/**
 * Created by Wisley on 12/09/17.
 */

public class PresenterContent implements IContentRequest {

    IContentCallback mCallBack;

    public PresenterContent(IContentCallback mCallBack) {
        this.mCallBack = mCallBack;
    }

    @Override
    public void notifyStart() {
        mCallBack.notifyStart();
        final ContentRequestHelper request = new ContentRequestHelper(Content.class,this);
        request.getContent();
    }

    @Override
    public void notifySuccess(Result response) {
        this.mCallBack.notifySucces(response);
    }

    @Override
    public void notifyFailure(ErrorResponse errorResponse) {
        this.mCallBack.notifyError(errorResponse);
    }
}
