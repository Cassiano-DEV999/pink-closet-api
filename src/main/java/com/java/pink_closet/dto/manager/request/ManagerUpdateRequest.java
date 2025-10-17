package com.java.pink_closet.dto.manager.request;

import com.java.pink_closet.model.ManagerRole;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ManagerUpdateRequest {
    private String name;
    private String email;
    private String password;
    private String phone;
    private ManagerRole role;
    private boolean active;
    private LocalDateTime updatedAt;
}
