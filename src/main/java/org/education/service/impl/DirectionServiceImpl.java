package org.education.service.impl;

import lombok.RequiredArgsConstructor;
import org.education.entity.Direction;
import org.education.repository.DirectionRepository;
import org.education.service.DirectionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DirectionServiceImpl implements DirectionService {

    private final DirectionRepository directionRepository;

    @Override
    public List<String> getListDirection() {
        List<Direction> list = directionRepository.findAll();
        return list.stream()
                .map(Direction::getName)
                .toList();
    }
}
