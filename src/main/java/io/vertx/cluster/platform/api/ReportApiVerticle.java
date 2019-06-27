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

public class ReportApiVerticle extends AbstractVerticle {
    private VerticleHelper verticleHelper = new VerticleHelper(this.getClass());

    private static final String SAVEREPORT_SERVICE_ID = "saveReport_v1";

    private ReportApi service;

    /**
     * Handler for saveReport
     */
    final Handler<Message<JsonObject>> saveReportHandler = message -> {
        try {
            Object body = Json.mapper.readValue(message.body().getJsonObject("body").encode(), Object.class);
            service.saveReport(body).subscribe(
                verticleHelper.getRxResultHandler(message, false, new TypeReference<Void>(){}),
                verticleHelper.getErrorAction(message, SAVEREPORT_SERVICE_ID)
            );        } catch (Exception e) {
            verticleHelper.manageError(message, e, SAVEREPORT_SERVICE_ID);
        }
    };


    @Override
    public void start() throws Exception {
        this.service = createServiceImplementation();
    	vertx.eventBus().<JsonObject> consumer(SAVEREPORT_SERVICE_ID).handler(saveReportHandler);
    }

    protected ReportApi createServiceImplementation() {
    	ArrayList<ReportApi> realizations = Lists.newArrayList(ServiceLoader.load(ReportApi.class));
        if(realizations.isEmpty()) {
            throw new RuntimeException("No realizations for "+ ReportApi.class +" were founded");
        }
        if(realizations.size() > 1 ) {
            throw new RuntimeException("More then one realization of "+ ReportApi.class +" were founded: "+ realizations);
        }
        return realizations.get(0);
    }
}
