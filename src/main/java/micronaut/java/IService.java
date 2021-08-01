/*
 *
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 *
 */

package micronaut.java;

import io.micronaut.http.HttpResponse;

public interface IService<T, Y> {
    HttpResponse<?> fetchModels();

    HttpResponse<?> fetchModel(Y id);

    HttpResponse<?> storeModel(T model);

    HttpResponse<?> updateModel(T model);

    HttpResponse<?> deleteModel(Y id);
}
