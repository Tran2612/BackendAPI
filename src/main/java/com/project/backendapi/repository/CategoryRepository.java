package com.project.backendapi.repository;

import com.project.backendapi.model.Categorys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Categorys, Long> {
}
