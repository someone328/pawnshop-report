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

public interface ReportApi  {
	

   /**
   * Сохранение отчета
   * 
   * @param body  (required)
   * @throws ApiException if fails to make API call
	*/
    Single<ResourceResponse<Void>> saveReport(Object body);    
}
