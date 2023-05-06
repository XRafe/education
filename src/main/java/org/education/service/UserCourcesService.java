package org.education.service;

public interface UserCourcesService {

    void subscribeUserOnCource(Integer courceId, String email);

    void unsubscribeUserFromCource(Integer courceId, String email);

    boolean checkSubscribeOnCource(Integer courceId, String email);
}
