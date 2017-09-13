package br.com.wisley.desafioapps.network.requesthelper.contracts;

import br.com.wisley.desafioapps.model.Content;
import br.com.wisley.desafioapps.model.Result;
import br.com.wisley.desafioapps.model.response.ErrorResponse;

/**
 * Created by Wisley on 12/09/17.
 */

public interface IContentRequest {

    /**
     * start request
     */
    void notifyStart();

    /**
     * notify on finish success
     *
     * @param response
     */
    void notifySuccess(final Result response);

    /**
     * notify error
     *
     * @param errorResponse
     */
    void notifyFailure(final ErrorResponse errorResponse);
}
