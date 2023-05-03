package org.education.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.education.cookie.ActionWithCookie;
import org.education.jwt.ActionWithJwt;
import org.education.service.UserCourcesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cource")
public class UserCourcesController {

    private final UserCourcesService userCourcesService;
    private final ActionWithJwt actionWithJwt;
    private final ActionWithCookie actionWithCookie;

    @PostMapping("/{courceId}/subscribe")
    public ResponseEntity subscribeUserOnCource(HttpServletRequest httpServletRequest,
                                                @PathVariable("courceId") Integer courceId) {
        String token = actionWithCookie.getTokenFromRequest(httpServletRequest);
        String email = actionWithJwt.getEmailByToken(token);

        userCourcesService.subscribeUserOnCource(courceId, email);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{courceId}/unsubscribe")
    public ResponseEntity unsubscribeUserFromCource(HttpServletRequest httpServletRequest,
                                                    @PathVariable("courceId") Integer courceId) {
        String token = actionWithCookie.getTokenFromRequest(httpServletRequest);
        String email = actionWithJwt.getEmailByToken(token);

        userCourcesService.unsubscribeUserFromCource(courceId, email);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
