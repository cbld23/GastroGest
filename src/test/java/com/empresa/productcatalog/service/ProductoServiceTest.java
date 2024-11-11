package com.empresa.productcatalog.service;

import com.empresa.productcatalog.model.Categoria;
import com.empresa.productcatalog.repository.CategoriaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

class CategoriaServiceTest {

    @Mock
    private CategoriaRepository categoriaRepository;

    @InjectMocks
    private CategoriaService categoriaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllCategorias_ShouldReturnListOfCategorias() {
        // Arrange
        Categoria categoria1 = new Categoria();
        categoria1.setId(1L);
        categoria1.setNombre("Bebidas");

        Categoria categoria2 = new Categoria();
        categoria2.setId(2L);
        categoria2.setNombre("Snacks");

        List<Categoria> expectedCategorias = Arrays.asList(categoria1, categoria2);
        when(categoriaRepository.findAll()).thenReturn(expectedCategorias);

        // Act
        List<Categoria> actualCategorias = categoriaService.getAllCategorias();

        // Assert
        assertEquals(expectedCategorias, actualCategorias);
        verify(categoriaRepository, times(1)).findAll();
    }

    @Test
    void getCategoriaById_ShouldReturnCategoriaWhenExists() {
        // Arrange
        Categoria categoria = new Categoria();
        categoria.setId(1L);
        categoria.setNombre("Bebidas");

        when(categoriaRepository.findById(1L)).thenReturn(Optional.of(categoria));

        // Act
        Categoria foundCategoria = categoriaService.getCategoriaById(1L);

        // Assert
        assertEquals(categoria, foundCategoria);
        verify(categoriaRepository, times(1)).findById(1L);
    }

    @Test
    void getCategoriaById_ShouldReturnNullWhenNotExists() {
        // Arrange
        when(categoriaRepository.findById(1L)).thenReturn(Optional.empty());

        // Act
        Categoria foundCategoria = categoriaService.getCategoriaById(1L);

        // Assert
        assertNull(foundCategoria);
        verify(categoriaRepository, times(1)).findById(1L);
    }

    @Test
    void saveCategoria_ShouldReturnSavedCategoria() {
        // Arrange
        Categoria categoria = new Categoria();
        categoria.setNombre("Lácteos");

        Categoria savedCategoria = new Categoria();
        savedCategoria.setId(1L);
        savedCategoria.setNombre("Lácteos");

        when(categoriaRepository.save(any(Categoria.class))).thenReturn(savedCategoria);

        // Act
        Categoria result = categoriaService.saveCategoria(categoria);

        // Assert
        assertEquals(savedCategoria, result);
        verify(categoriaRepository, times(1)).save(categoria);
    }
}
