package org.education.service.impl;

import lombok.RequiredArgsConstructor;
import org.education.entity.Cource;
import org.education.entity.User;
import org.education.entity.UserCources;
import org.education.repository.CourceRepository;
import org.education.repository.UserCourcesRepository;
import org.education.repository.UserRepository;
import org.education.service.UserCourcesService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserCourcesServiceImpl implements UserCourcesService {

    private final UserRepository userRepository;
    private final UserCourcesRepository userCourcesRepository;
    private final CourceRepository courceRepository;

    @Transactional
    @Override
    public void subscribeUserOnCource(Integer courceId, String email) {
        Cource cource = courceRepository.findById(courceId).orElseThrow();
        User user = userRepository.findByEmail(email).orElseThrow();

        UserCources userCources = new UserCources(
                user.getId(),
                courceId,
                0);
        cource.setUsersCount(cource.getUsersCount() + 1);

        courceRepository.saveAndFlush(cource);
        userCourcesRepository.saveAndFlush(userCources);
    }

    @Transactional
    @Override
    public void unsubscribeUserFromCource(Integer courceId, String email) {
        Cource cource = courceRepository.findById(courceId).orElseThrow();
        User user = userRepository.findByEmail(email).orElseThrow();

        UserCources userCources = userCourcesRepository.findByUserIdAndCourceId(user.getId(), courceId)
                .orElseThrow();

        cource.setUsersCount(cource.getUsersCount() - 1);

        courceRepository.saveAndFlush(cource);
        userCourcesRepository.delete(userCources);
    }

    @Override
    public boolean checkSubscribeOnCource(Integer courceId, String email) {
        User user = userRepository.findByEmail(email).orElseThrow();
        return userCourcesRepository.existsByUserIdAndCourceId(user.getId(), courceId);
    }


}
