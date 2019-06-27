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
import io.vertx.cluster.platform.model.ModelUser;
import io.vertx.cluster.platform.util.ResourceResponse;
import io.vertx.cluster.platform.util.VerticleHelper;

import java.util.List;
import java.util.Map;

public class UserApiVerticle extends AbstractVerticle {
    private VerticleHelper verticleHelper = new VerticleHelper(this.getClass());

    private static final String GETALLUSERS_SERVICE_ID = "getAllUsers_v1";
    private static final String GETUSERBYID_SERVICE_ID = "getUserById_v1";

    private UserApi service;

    /**
     * Handler for getAllUsers
     */
    final Handler<Message<JsonObject>> getAllUsersHandler = message -> {
        try {
            service.getAllUsers().subscribe(
                verticleHelper.getRxResultHandler(message, true, new TypeReference<List<ModelUser>>(){}),
                verticleHelper.getErrorAction(message, GETALLUSERS_SERVICE_ID)
            );        } catch (Exception e) {
            verticleHelper.manageError(message, e, GETALLUSERS_SERVICE_ID);
        }
    };

    /**
     * Handler for getUserById
     */
    final Handler<Message<JsonObject>> getUserByIdHandler = message -> {
        try {
            String userId = message.body().getString("userId");
            service.getUserById(userId).subscribe(
                verticleHelper.getRxResultHandler(message, true, new TypeReference<ModelUser>(){}),
                verticleHelper.getErrorAction(message, GETUSERBYID_SERVICE_ID)
            );        } catch (Exception e) {
            verticleHelper.manageError(message, e, GETUSERBYID_SERVICE_ID);
        }
    };


    @Override
    public void start() throws Exception {
        this.service = createServiceImplementation();
    	vertx.eventBus().<JsonObject> consumer(GETALLUSERS_SERVICE_ID).handler(getAllUsersHandler);
    	vertx.eventBus().<JsonObject> consumer(GETUSERBYID_SERVICE_ID).handler(getUserByIdHandler);
    }

    protected UserApi createServiceImplementation() {
    	ArrayList<UserApi> realizations = Lists.newArrayList(ServiceLoader.load(UserApi.class));
        if(realizations.isEmpty()) {
            throw new RuntimeException("No realizations for "+ UserApi.class +" were founded");
        }
        if(realizations.size() > 1 ) {
            throw new RuntimeException("More then one realization of "+ UserApi.class +" were founded: "+ realizations);
        }
        return realizations.get(0);
    }
}
