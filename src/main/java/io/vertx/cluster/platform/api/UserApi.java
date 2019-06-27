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

public interface UserApi  {
	

   /**
   * Получить всех пользователей
   * 
   * @return List&lt;ModelUser&gt;
   * @throws ApiException if fails to make API call
	*/
    Single<ResourceResponse<List<ModelUser>>> getAllUsers();    

   /**
   * Получить пользователя по Id
   * 
   * @param userId Id пользователя (required)
   * @return ModelUser
   * @throws ApiException if fails to make API call
	*/
    Single<ResourceResponse<ModelUser>> getUserById(String userId);    
}
