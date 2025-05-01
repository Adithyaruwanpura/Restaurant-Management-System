package com.restaurant.rmsbackend.service;

import com.restaurant.rmsbackend.dto.ReservationDTO;
import com.restaurant.rmsbackend.mapper.ReservationMapper;
import com.restaurant.rmsbackend.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List; import java.util.stream.Collectors;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<ReservationDTO> getAllReservations() {
        return reservationRepository.findAll().stream()
                .map(ReservationMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ReservationDTO createReservation(ReservationDTO dto) {
        return ReservationMapper.toDTO(
                reservationRepository.save(ReservationMapper.toEntity(dto))
        );
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

}

