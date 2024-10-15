package com.project.backendapi.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Products {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private double price;
    @Lob
    private String description;
    private int stock;
    private String imageUrl;
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

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Categorys category;

}
