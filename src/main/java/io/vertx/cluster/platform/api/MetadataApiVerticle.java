package io.vertx.cluster.platform.api;

import com.fasterxml.jackson.core.type.TypeReference;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Handler;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.User;
import com.github.phiz71.vertx.swagger.router.SwaggerRouter;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.ServiceLoader;

import io.vertx.cluster.platform.MainApiException;
import io.vertx.cluster.platform.MainApiHeader;
import io.vertx.cluster.platform.util.ResourceResponse;
import io.vertx.cluster.platform.util.VerticleHelper;

import java.util.List;
import java.util.Map;

public class MetadataApiVerticle extends AbstractVerticle {
    private VerticleHelper verticleHelper = new VerticleHelper(this.getClass());

    private static final String GETMETADATA_SERVICE_ID = "getMetadata_v1";

    private MetadataApi service;

    /**
     * Handler for getMetadata
     */
    final Handler<Message<JsonObject>> getMetadataHandler = message -> {
        try {
            service.getMetadata().subscribe(
                verticleHelper.getRxResultHandler(message, false, new TypeReference<Void>(){}),
                verticleHelper.getErrorAction(message, GETMETADATA_SERVICE_ID)
            );        } catch (Exception e) {
            verticleHelper.manageError(message, e, GETMETADATA_SERVICE_ID);
        }
    };


    @Override
    public void start() throws Exception {
        this.service = createServiceImplementation();
    	vertx.eventBus().<JsonObject> consumer(GETMETADATA_SERVICE_ID).handler(getMetadataHandler);
    }

    protected MetadataApi createServiceImplementation() {
    	ArrayList<MetadataApi> realizations = Lists.newArrayList(ServiceLoader.load(MetadataApi.class));
        if(realizations.isEmpty()) {
            throw new RuntimeException("No realizations for "+ MetadataApi.class +" were founded");
        }
        if(realizations.size() > 1 ) {
            throw new RuntimeException("More then one realization of "+ MetadataApi.class +" were founded: "+ realizations);
        }
        return realizations.get(0);
    }
}
