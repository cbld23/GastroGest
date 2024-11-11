package com.empresa.productcatalog.repository;

import com.empresa.productcatalog.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
