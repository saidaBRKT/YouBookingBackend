
package com.example.youbookingbackend.repository.dto;

import lombok.*;

@Setter
@Getter
public class ResponseDto {
    private String status;
    private String message;
    private Object data;

    public ResponseDto(String status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ResponseDto(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
