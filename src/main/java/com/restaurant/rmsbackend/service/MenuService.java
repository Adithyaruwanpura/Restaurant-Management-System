package com.restaurant.rmsbackend.service;
import com.restaurant.rmsbackend.model.MenuItem;
import com.restaurant.rmsbackend.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.restaurant.rmsbackend.dto.MenuItemDTO;
import com.restaurant.rmsbackend.mapper.MenuItemMapper;
import com.restaurant.rmsbackend.model.Category;
import com.restaurant.rmsbackend.repository.CategoryRepository;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Optional;


@Service
public class MenuService {
    @Autowired
    private MenuItemRepository menuItemRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<MenuItemDTO> getAllMenuItems() {
        return menuItemRepository.findAll().stream()
                .map(MenuItemMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<MenuItemDTO> getMenuItemById(Long id) {
        return menuItemRepository.findById(id)
                .map(MenuItemMapper::toDTO);
    }

    public MenuItemDTO createMenuItem(MenuItemDTO dto) {
        Category category = categoryRepository.findByName(dto.getCategoryName())
                .orElseThrow(() -> new RuntimeException("Category not found: " + dto.getCategoryName()));

        MenuItem item = MenuItemMapper.toEntity(dto, category);
        return MenuItemMapper.toDTO(menuItemRepository.save(item));
    }

    public MenuItemDTO updateMenuItem(Long id, MenuItemDTO dto) {
        Category category = categoryRepository.findByName(dto.getCategoryName())
                .orElseThrow(() -> new RuntimeException("Category not found: " + dto.getCategoryName()));

        return menuItemRepository.findById(id)
                .map(existing -> {
                    existing.setName(dto.getName());
                    existing.setPrice(dto.getPrice());
                    existing.setDescription(dto.getDescription());
                    existing.setAvailable(dto.isAvailable());
                    existing.setCategory(category);
                    return MenuItemMapper.toDTO(menuItemRepository.save(existing));
                })
                .orElseThrow(() -> new RuntimeException("Menu item not found: " + id));
    }

    public boolean deleteMenuItem(Long id) {
        if (menuItemRepository.existsById(id)) {
            menuItemRepository.deleteById(id);
            return true;
        }
        return false;
    }

}

