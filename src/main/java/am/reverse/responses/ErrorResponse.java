package am.reverse.responses;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public  class ErrorResponse {

    private String message;

    private final LocalDateTime localDateTime = LocalDateTime.now();

    private int code;

    private String status;

//    private String stackTrace;
//
//    private Object data;

    public ErrorResponse() {

    }

    public ErrorResponse(HttpStatus httpStatus, String message) {
        this.code = httpStatus.value();
        this.status = httpStatus.name();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

//    public String getStackTrace() {
//        return stackTrace;
//    }
//
//    public void setStackTrace(String stackTrace) {
//        this.stackTrace = stackTrace;
//    }
//
//    public Object getData() {
//        return data;
//    }
//
//    public void setData(Object data) {
//        this.data = data;
//    }
}
