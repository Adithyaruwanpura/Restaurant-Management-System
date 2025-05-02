package com.restaurant.rmsbackend.service;

import com.restaurant.rmsbackend.dto.ReservationDTO;
import com.restaurant.rmsbackend.mapper.ReservationMapper;
import com.restaurant.rmsbackend.repository.ReservationRepository;
import com.restaurant.rmsbackend.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import com.restaurant.rmsbackend.model.DiningTable;


@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private TableRepository tableRepository;

    public List<ReservationDTO> getAllReservations() {
        return reservationRepository.findAll().stream()
                .map(ReservationMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ReservationDTO createReservation(ReservationDTO dto) {
        DiningTable table = tableRepository.findByTableNumber(dto.getTableNumber())
                .orElseThrow(() -> new RuntimeException("Table not found: " + dto.getTableNumber()));

        return ReservationMapper.toDTO(
                reservationRepository.save(ReservationMapper.toEntity(dto, table))
        );
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}

