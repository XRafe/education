package org.education.service.impl;

import lombok.RequiredArgsConstructor;
import org.education.dto.cource.CourceDto;
import org.education.dto.cource.CreateCourceDto;
import org.education.dto.cource.EditCourceDto;
import org.education.entity.Chat;
import org.education.entity.Cource;
import org.education.repository.ChatRepository;
import org.education.repository.CourceRepository;
import org.education.service.CourceService;
import org.education.service.mapper.CourceMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourceServiceImpl implements CourceService {

    private final CourceRepository courceRepository;
    private final ChatRepository chatRepository;
    private final CourceMapper courceMapper;

    @Override
    public Integer createCourceWithChat(CreateCourceDto createCource) {
        Cource cource = new Cource(
                createCource.getTitle(),
                createCource.getInfo(),
                createCource.getImageUrl(),
                createCource.getUsersCount(),
                createCource.getRating(),
                createCource.getDirection());

        cource = courceRepository.saveAndFlush(cource);

        chatRepository.saveAndFlush(new Chat(cource));

        return cource.getId();
    }

    @Override
    public CourceDto getCourceById(Integer id) {
        Cource cource = courceRepository.findById(id).orElseThrow();

        return courceMapper.mapCourceToCourceDto(cource);
    }

    @Override
    public CourceDto editCource(Integer id, EditCourceDto editCource) {
        Cource cource = courceRepository.findById(id).orElseThrow();

        cource.setInfo(editCource.getInfo());
        cource.setTitle(editCource.getTitle());
        cource.setImageUrl(editCource.getImageUrl());
        cource.setDirection(editCource.getDirection());

        courceRepository.saveAndFlush(cource);

        return courceMapper.mapCourceToCourceDto(cource);
    }
}
