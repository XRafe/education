package org.education.service.impl;

import lombok.RequiredArgsConstructor;
import org.education.dto.cource.CourceDto;
import org.education.dto.cource.CreateCourceDto;
import org.education.dto.cource.EditCourceDto;
import org.education.dto.cource.SubscribeCourceDto;
import org.education.entity.Cource;
import org.education.entity.User;
import org.education.repository.CourceRepository;
import org.education.repository.UserRepository;
import org.education.repository.criteria.CourceCriteriaRepository;
import org.education.service.ChatService;
import org.education.service.CourceService;
import org.education.service.mapper.CourceMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourceServiceImpl implements CourceService {

    private final CourceRepository courceRepository;
    private final ChatService chatService;
    private final UserRepository userRepository;
    private final CourceMapper courceMapper;
    private final CourceCriteriaRepository courceCriteriaRepository;


    @Transactional
    @Override
    public Integer createCourceWithChat(CreateCourceDto createCource, String emailUser) {
        User user = userRepository.findByEmail(emailUser).orElseThrow();
        Cource cource = new Cource(
                createCource.getTitle(),
                createCource.getInfo(),
                createCource.getImageUrl(),
                createCource.getUsersCount(),
                createCource.getRating(),
                createCource.getDirection(),
                user.getId());

        cource = courceRepository.saveAndFlush(cource);

        chatService.createChat(cource.getId());

        return cource.getId();
    }

    @Override
    public CourceDto getCourceById(Integer id) {
        Cource cource = courceRepository.findById(id).orElseThrow();

        return courceMapper.mapCourceToCourceDto(cource);
    }


    @Transactional
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

    @Override
    public List<CourceDto> getList() {
        List<Cource> list = courceRepository.findAll();
        return courceMapper.mapCourceToCourceDto(list);
    }

    @Override
    public List<CourceDto> getAllByUserId(String email) {
        User user = userRepository.findByEmail(email).orElseThrow();

        List<Cource> list = courceRepository.findAllByUserId(user.getId());
        return courceMapper.mapCourceToCourceDto(list);
    }

    @Override
    public List<SubscribeCourceDto> getListSubscribeUser(String email) {
        User user = userRepository.findByEmail(email).orElseThrow();
        return courceCriteriaRepository.getListSubscribeUser(user.getId());
    }


    @Transactional
    @Override
    public void deleteCource(Integer id) {
        courceRepository.deleteById(id);
    }
}
