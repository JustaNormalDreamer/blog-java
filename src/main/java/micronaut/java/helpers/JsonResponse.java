/*
 *
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 *
 */

package micronaut.java.helpers;

import io.micronaut.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public class JsonResponse<T> {
    private String code;

    private String message;

    private String localizedMessage;

    private Iterable<T> models;

    private T model;

    public JsonResponse(String code, String message, String localizedMessage) {
        this.code = code;
        this.message = message;
        this.localizedMessage = localizedMessage;
    }

    public JsonResponse(String code, String message, String localizedMessage, Iterable<T> models) {
        this.code = code;
        this.message = message;
        this.localizedMessage = localizedMessage;
        this.models = models;
    }

    public JsonResponse(String code, String message, String localizedMessage, T model) {
        this.code = code;
        this.message = message;
        this.localizedMessage = localizedMessage;
        this.model = model;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLocalizedMessage() {
        return localizedMessage;
    }

    public void setLocalizedMessage(String localizedMessage) {
        this.localizedMessage = localizedMessage;
    }

    public Iterable<T> getModels() {
        return models;
    }

    public void setModels(Iterable<T> models) {
        this.models = models;
    }

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }

    public Map<String, Object> response() {
        Map<String, Object> res = new HashMap<>();
        res.put("code", code);
        res.put("localizedMessage", localizedMessage);
        res.put("message", message);

        if(models != null) {
            res.put("data", models);
        } else if(model != null) {
            res.put("data", model);
        }

        return res;
    }
}
