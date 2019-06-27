package io.vertx.cluster.platform.api;

import io.vertx.cluster.platform.MainApiException;
import io.vertx.cluster.platform.MainApiHeader;
import io.vertx.cluster.platform.model.ModelUser;
import io.vertx.cluster.platform.util.ResourceResponse;
import io.vertx.cluster.platform.util.VerticleHelper;

public final class UserApiException extends MainApiException {
    public UserApiException(int statusCode, String statusMessage) {
        super(statusCode, statusMessage);
    }
    
    public static UserApiException UserApi_getAllUsers_401_createException() {
        return new UserApiException(401, "Unauthorised");
    }
public static UserApiException UserApi_getAllUsers_500_createException() {
        return new UserApiException(500, "Unknown error");
    }

}