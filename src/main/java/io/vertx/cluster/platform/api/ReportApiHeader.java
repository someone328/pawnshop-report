package io.vertx.cluster.platform.api;

import io.vertx.cluster.platform.MainApiException;
import io.vertx.cluster.platform.MainApiHeader;
import io.vertx.cluster.platform.util.ResourceResponse;
import io.vertx.cluster.platform.util.VerticleHelper;

public final class ReportApiHeader extends MainApiHeader {
    private ReportApiHeader(String name, String value) {
        super(name, value);
    }
    
    private ReportApiHeader(String name, Iterable<String> values) {
        super(name, values);
    }
    
    
}