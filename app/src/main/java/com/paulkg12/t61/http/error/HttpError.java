package com.paulkg12.t61.http.error;

public class HttpError extends Error {
    private int errorCode = -1;
    public HttpError(int errorCode) {
        super(HttpErrorCode.getErrorMsg(errorCode));
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
