package com.burra.quizletclone.core.exceptions;

import java.util.Date;

public class ErrorResponse {

  private Date timestamp;
  private String status;
  private String message;
  private String details;
  private String exceptionType;

  public ErrorResponse(
      Date timestamp,
      String status,
      String message,
      String details,
      String exceptionType) {
    this.timestamp = timestamp;
    this.status = status;
    this.message = message;
    this.details = details;
    this.exceptionType = exceptionType;
  }

  public String getExceptionType() {
    return exceptionType;
  }

  public void setExceptionType(String exceptionType) {
    this.exceptionType = exceptionType;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getDetails() {
    return details;
  }

  public void setDetails(String details) {
    this.details = details;
  }
}
