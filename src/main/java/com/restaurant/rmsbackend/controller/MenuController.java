package com.restaurant.rmsbackend.controller;
import com.restaurant.rmsbackend.dto.MenuItemDTO;
import com.restaurant.rmsbackend.mapper.MenuItemMapper;
import com.restaurant.rmsbackend.model.MenuItem;
import com.restaurant.rmsbackend.model.Category;
import com.restaurant.rmsbackend.service.CategoryService;
import com.restaurant.rmsbackend.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


import java.util.List;

@RestController
@RequestMapping("/api/menu")
@CrossOrigin(origins = "*")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @Autowired
    private MenuItemMapper mapper;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<MenuItemDTO>> getAll() {
        return ResponseEntity.ok(menuService.getAllMenuItems());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuItemDTO> getById(@PathVariable Long id) {
        return menuService.getMenuItemById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MenuItemDTO> create(@RequestBody MenuItemDTO dto) {
        return ResponseEntity.ok(menuService.createMenuItem(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MenuItemDTO> update(@PathVariable Long id, @RequestBody MenuItemDTO dto) {
        return ResponseEntity.ok(menuService.updateMenuItem(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return menuService.deleteMenuItem(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

}