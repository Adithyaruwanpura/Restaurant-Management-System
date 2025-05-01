package com.restaurant.rmsbackend.controller;
import com.restaurant.rmsbackend.dto.MenuItemDTO;
import com.restaurant.rmsbackend.mapper.MenuItemMapper;
import com.restaurant.rmsbackend.model.MenuItem;
import com.restaurant.rmsbackend.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/api/menu")
@CrossOrigin(origins = "*")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private MenuItemMapper mapper;

    // GET all menu items
    @GetMapping
    public ResponseEntity<List<MenuItemDTO>> getAll() {
        List<MenuItemDTO> dtoList = menuService.getAllMenuItems()
                .stream()
                .map(mapper::toDTO)
                .toList();
        return ResponseEntity.ok(dtoList);
    }

    // GET single item by ID
    @GetMapping("/{id}")
    public ResponseEntity<MenuItemDTO> getById(@PathVariable Long id) {
        return menuService.getMenuItemById(id)
                .map(item -> ResponseEntity.ok(mapper.toDTO(item)))
                .orElse(ResponseEntity.notFound().build());
    }

    // POST create new item
    @PostMapping
    public ResponseEntity<MenuItemDTO> create(@RequestBody MenuItemDTO dto) {
        MenuItem saved = menuService.createMenuItem(mapper.toEntity(dto));
        return ResponseEntity.ok(mapper.toDTO(saved));
    }

    // PUT update existing item
    @PutMapping("/{id}")
    public ResponseEntity<MenuItemDTO> update(@PathVariable Long id, @RequestBody MenuItemDTO dto) {
        MenuItem updated = menuService.updateMenuItem(id, mapper.toEntity(dto));
        return updated != null
                ? ResponseEntity.ok(mapper.toDTO(updated))
                : ResponseEntity.notFound().build();
    }

    // DELETE item by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return menuService.deleteMenuItem(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}