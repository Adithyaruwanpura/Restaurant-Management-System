package com.restaurant.rmsbackend.service;
import com.restaurant.rmsbackend.model.MenuItem;
import com.restaurant.rmsbackend.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class MenuService {
    @Autowired
    private MenuItemRepository menuItemRepository;

    public List<MenuItem> getAllMenuItems(){
        return menuItemRepository.findAll();
    }

    public Optional<MenuItem>getMenuItemById(Long id){
        return menuItemRepository.findById(id);
    }

    public MenuItem createMenuItem(MenuItem menuitem){
        return menuItemRepository.save(menuitem);
    }

    public MenuItem updateMenuItem(Long id, MenuItem updatedItem) {
        return menuItemRepository.findById(id).map(item -> {
            item.setName(updatedItem.getName());
            item.setCategory(updatedItem.getCategory());
            item.setPrice(updatedItem.getPrice());
            item.setDescription(updatedItem.getDescription());
            item.setAvailable(updatedItem.isAvailable());
            return menuItemRepository.save(item);
        }).orElse(null);
    }

    public boolean deleteMenuItem(Long id){
        if (menuItemRepository.existsById(id)){
            menuItemRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

