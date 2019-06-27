package io.vertx.cluster.platform.api;

import io.vertx.cluster.platform.MainApiException;
import io.vertx.cluster.platform.MainApiHeader;
import io.vertx.cluster.platform.model.ModelUser;
import io.vertx.cluster.platform.util.ResourceResponse;
import io.vertx.cluster.platform.util.VerticleHelper;

public final class UserApiHeader extends MainApiHeader {
    private UserApiHeader(String name, String value) {
        super(name, value);
    }
    
    private UserApiHeader(String name, Iterable<String> values) {
        super(name, values);
    }
    
    
}