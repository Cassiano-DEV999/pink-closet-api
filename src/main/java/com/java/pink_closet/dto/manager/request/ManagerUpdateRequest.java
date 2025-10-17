package com.java.pink_closet.dto.manager.request;

import lombok.Data;

@Data
public class ManagerUpdateRequest {
    private String name;
    private String email;
    private String password;
}
