package br.com.wisley.desafioapps.network.enums;

/**
 * Created by Murilo on 06/10/16.
 */

public enum ServiceMessage {

    PREVIOUS_SESSION_NEEDED("PREVIOUS_SESSION_NEEDED"),
    CHECK_SESSION("CHECK_SESSION");

    private String message;

    ServiceMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
