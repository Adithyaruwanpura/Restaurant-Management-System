package com.restaurant.rmsbackend.service;
import com.restaurant.rmsbackend.dto.CartItemDTO;
import com.restaurant.rmsbackend.mapper.CartItemMapper;
import com.restaurant.rmsbackend.model.CartItem;
import com.restaurant.rmsbackend.model.MenuItem;
import com.restaurant.rmsbackend.repository.CartItemRepository;
import com.restaurant.rmsbackend.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List; import java.util.stream.Collectors;
@Service
public class CartItemService {
    @Autowired
    private CartItemRepository cartRepo;

    @Autowired
    private MenuItemRepository menuRepo;

    public List<CartItemDTO> getCartBySession(String sessionId) {
        return cartRepo.findBySessionId(sessionId)
                .stream()
                .map(CartItemMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CartItemDTO addToCart(CartItemDTO dto) {
        MenuItem menuItem = menuRepo.findById(dto.getMenuItemId()).orElseThrow();
        CartItem item = CartItemMapper.toEntity(dto, menuItem);
        return CartItemMapper.toDTO(cartRepo.save(item));
    }

    public void clearCart(String sessionId) {
        cartRepo.deleteBySessionId(sessionId);
    }

}
