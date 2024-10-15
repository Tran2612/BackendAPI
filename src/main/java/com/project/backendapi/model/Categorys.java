package com.project.backendapi.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Categorys {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();  // cập nhật cả updatedAt khi tạo mới
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();  // cập nhật updatedAt khi đối tượng bị thay đổi
    }
}
