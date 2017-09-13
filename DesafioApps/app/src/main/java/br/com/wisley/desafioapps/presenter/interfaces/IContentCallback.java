package br.com.wisley.desafioapps.presenter.interfaces;

import br.com.wisley.desafioapps.model.Content;
import br.com.wisley.desafioapps.model.Result;
import br.com.wisley.desafioapps.model.response.ErrorResponse;

/**
 * Created by Wisley on 12/09/17.
 * this interface is listener changes in request and refresh view content
 */

public interface IContentCallback {

    /* send notification on connection failure and others erros    */
    void notifyError(final ErrorResponse errorResponse);

    /**
     * send notification has start
     */
    void notifyStart();

    /**
     * send notification has finish
     */
    void notifySucces(final Result reponse);
}
