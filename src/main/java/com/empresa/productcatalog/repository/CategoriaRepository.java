package com.empresa.productcatalog.repository;

import com.empresa.productcatalog.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
