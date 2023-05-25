package com.example.demo19.ApiRessponce;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@AllArgsConstructor
@ToString
public class ApiResponce {
    private boolean success;
    private String message;
    private Object data;
}
