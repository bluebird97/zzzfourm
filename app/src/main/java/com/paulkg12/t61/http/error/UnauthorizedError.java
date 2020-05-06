package com.paulkg12.t61.http.error;

public class UnauthorizedError extends HttpError {
    public UnauthorizedError() {
        super(HttpErrorCode.UNAUTHORIZED);
    }
}