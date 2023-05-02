package org.education.service.mapper;

import org.education.dto.cource.CourceDto;
import org.education.entity.Cource;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class CourceMapper {

    public CourceDto mapCourceToCourceDto(Cource cource) {
        return new CourceDto(
                cource.getId(),
                cource.getTitle(),
                cource.getInfo(),
                cource.getImageUrl(),
                cource.getUsersCount(),
                cource.getRating(),
                cource.getDirection()
        );
    }

    public List<CourceDto> mapCourceToCourceDto(Collection<Cource> cources) {
        return cources.stream().map(this::mapCourceToCourceDto).toList();
    }
}
