package com.paulkg12.t61.http.error;

public class HttpPageNoFoundError extends HttpError {
    public HttpPageNoFoundError() {
        super(HttpErrorCode.PAGE_NOT_FOUND);
    }
}
