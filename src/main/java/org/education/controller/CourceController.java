package org.education.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.education.cookie.ActionWithCookie;
import org.education.dto.cource.CourceDto;
import org.education.dto.cource.CreateCourceDto;
import org.education.dto.cource.EditCourceDto;
import org.education.jwt.ActionWithJwt;
import org.education.service.ChatService;
import org.education.service.CourceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cource")
@RequiredArgsConstructor
public class CourceController {

    private final CourceService courceService;
    private final ChatService chatService;
    private final ActionWithJwt actionWithJwt;
    private final ActionWithCookie actionWithCookie;

    @PostMapping("/create")
    public Integer createCourceWithChat(HttpServletRequest httpServletRequest, CreateCourceDto createCourceDto) {
        String token = actionWithCookie.getTokenFromRequest(httpServletRequest);
        String email = actionWithJwt.getEmailByToken(token);

        return courceService.createCourceWithChat(createCourceDto, email);
    }

    @GetMapping("/{id}")
    public CourceDto getCourceById(@PathVariable("id") Integer id) {
        return courceService.getCourceById(id);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<CourceDto> editCource(@PathVariable("id") Integer id,
                                                EditCourceDto editCourceDto) {
        return new ResponseEntity<>(courceService.editCource(id, editCourceDto), HttpStatus.OK);
    }
}
