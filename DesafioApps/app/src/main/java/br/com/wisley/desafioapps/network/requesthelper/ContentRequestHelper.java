package br.com.wisley.desafioapps.network.requesthelper;

import br.com.wisley.desafioapps.network.requesthelper.contracts.IContentRequest;

/**
 * Created by Wisley on 12/09/17.
 */

public class ContentRequestHelper<T> extends  BaseRequestHelper<T>{
    private IContentRequest mPresenter;

    public ContentRequestHelper(Class<T> clazz, IContentRequest mPresenter) {
        super(clazz);
        this.mPresenter = mPresenter;
    }

    /**
     * this method call news content
     */
    public void getContent(){

    }

}
