package com.jwt.jwt.apiResponse;



import org.springframework.http.HttpStatus;

public class Apiresponse {

    private Object status;
    private Object data;
    private Object error;

    public Apiresponse() {
        this.status =status;
        this.data = data;
        this.error = error;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }
}
