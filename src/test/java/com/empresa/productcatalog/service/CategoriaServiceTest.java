package com.empresa.productcatalog.service;

import com.empresa.productcatalog.model.Producto;
import com.empresa.productcatalog.repository.ProductoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

class ProductoServiceTest {

    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private ProductoService productoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllProductos_ShouldReturnListOfProductos() {
        // Arrange
        Producto producto1 = new Producto();
        producto1.setId(1L);
        producto1.setNombre("Coca-Cola");
        producto1.setPrecio(new BigDecimal("1.0"));
        producto1.setStock(100);

        Producto producto2 = new Producto();
        producto2.setId(2L);
        producto2.setNombre("Papitas");
        producto2.setPrecio(new BigDecimal("0.5"));
        producto2.setStock(200);

        List<Producto> expectedProductos = Arrays.asList(producto1, producto2);
        when(productoRepository.findAll()).thenReturn(expectedProductos);

        // Act
        List<Producto> actualProductos = productoService.getAllProductos();

        // Assert
        assertEquals(expectedProductos, actualProductos);
        verify(productoRepository, times(1)).findAll();
    }

    @Test
    void getProductoById_ShouldReturnProductoWhenExists() {
        // Arrange
        Producto producto = new Producto();
        producto.setId(1L);
        producto.setNombre("Coca-Cola");
        producto.setPrecio(new BigDecimal("1.0"));
        producto.setStock(100);

        when(productoRepository.findById(1L)).thenReturn(Optional.of(producto));

        // Act
        Producto foundProducto = productoService.getProductoById(1L);

        // Assert
        assertEquals(producto, foundProducto);
        verify(productoRepository, times(1)).findById(1L);
    }

    @Test
    void getProductoById_ShouldReturnNullWhenNotExists() {
        // Arrange
        when(productoRepository.findById(1L)).thenReturn(Optional.empty());

        // Act
        Producto foundProducto = productoService.getProductoById(1L);

        // Assert
        assertNull(foundProducto);
        verify(productoRepository, times(1)).findById(1L);
    }

    @Test
    void saveProducto_ShouldReturnSavedProducto() {
        // Arrange
        Producto producto = new Producto();
        producto.setNombre("Leche");
        producto.setPrecio(new BigDecimal("0.8"));
        producto.setStock(150);

        Producto savedProducto = new Producto();
        savedProducto.setId(1L);
        savedProducto.setNombre("Leche");
        savedProducto.setPrecio(new BigDecimal("0.8"));
        savedProducto.setStock(150);

        when(productoRepository.save(any(Producto.class))).thenReturn(savedProducto);

        // Act
        Producto result = productoService.saveProducto(producto);

        // Assert
        assertEquals(savedProducto, result);
        verify(productoRepository, times(1)).save(producto);
    }
}
