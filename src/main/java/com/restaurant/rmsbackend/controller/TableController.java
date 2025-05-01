package com.restaurant.rmsbackend.controller;
import com.restaurant.rmsbackend.dto.DiningTableDTO;
import com.restaurant.rmsbackend.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/tables")
@CrossOrigin("*")



public class TableController {


    @Autowired
    private TableService tableService;

    @GetMapping
    public List<DiningTableDTO> getAll() {
        return tableService.getAllTables();
    }

    @PostMapping
    public DiningTableDTO create(@RequestBody DiningTableDTO dto) {
        return tableService.createTable(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        tableService.deleteTable(id);
    }

}
