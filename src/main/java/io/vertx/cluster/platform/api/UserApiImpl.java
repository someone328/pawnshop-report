package io.vertx.cluster.platform.api;

import io.vertx.cluster.platform.MainApiException;
import io.vertx.cluster.platform.MainApiHeader;
import io.vertx.cluster.platform.model.ModelUser;
import io.vertx.cluster.platform.util.ResourceResponse;
import io.vertx.cluster.platform.util.VerticleHelper;

import rx.Completable;
import rx.Single;
import io.vertx.rxjava.ext.auth.User;

import java.util.List;
import java.util.Map;

public class UserApiImpl implements UserApi {
    //getAllUsers
    public Single<ResourceResponse<List<ModelUser>>> getAllUsers(){
        throw new java.lang.UnsupportedOperationException("Not implemented, yet") ;
    };    
    //getUserById
    public Single<ResourceResponse<ModelUser>> getUserById(String userId){
        throw new java.lang.UnsupportedOperationException("Not implemented, yet") ;
    };    
}
