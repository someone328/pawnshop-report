package io.vertx.cluster.platform.api;

import io.vertx.cluster.platform.MainApiException;
import io.vertx.cluster.platform.MainApiHeader;
import io.vertx.cluster.platform.util.ResourceResponse;
import io.vertx.cluster.platform.util.VerticleHelper;

import rx.Completable;
import rx.Single;
import io.vertx.rxjava.ext.auth.User;

import java.util.List;
import java.util.Map;

public class ReportApiImpl implements ReportApi {
    //saveReport
    public Single<ResourceResponse<Void>> saveReport(Object body){
        throw new java.lang.UnsupportedOperationException("Not implemented, yet") ;
    };    
}
