package io.vertx.cluster.platform.api;

import io.vertx.cluster.platform.MainApiException;
import io.vertx.cluster.platform.MainApiHeader;
import io.vertx.cluster.platform.util.ResourceResponse;
import io.vertx.cluster.platform.util.VerticleHelper;

public final class ReportApiException extends MainApiException {
    public ReportApiException(int statusCode, String statusMessage) {
        super(statusCode, statusMessage);
    }
    
    
}