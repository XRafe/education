package org.education.service;

import org.education.dto.cource.CourceDto;
import org.education.dto.cource.CreateCourceDto;
import org.education.dto.cource.EditCourceDto;

public interface CourceService {
    Integer createCourceWithChat(CreateCourceDto createCource, String emailUser);

    CourceDto getCourceById(Integer id);

    CourceDto editCource(Integer id, EditCourceDto editCource);
}
