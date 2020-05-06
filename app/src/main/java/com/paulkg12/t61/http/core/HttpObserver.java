package com.paulkg12.t61.http.core;

public interface HttpObserver<T> {
    void onError(Throwable error);
    void onSuccess(HttpResponse<T> response);
}
