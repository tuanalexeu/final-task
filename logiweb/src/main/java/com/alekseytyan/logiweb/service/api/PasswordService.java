package com.alekseytyan.logiweb.service.api;

import com.alekseytyan.logiweb.dto.PasswordResetTokenDTO;
import com.alekseytyan.logiweb.dto.UserDTO;
import com.alekseytyan.logiweb.entity.auth.PasswordResetToken;

public interface PasswordService extends AbstractService<PasswordResetToken, PasswordResetTokenDTO, Long> {
    void createPasswordResetTokenForUser(UserDTO user, String token);
}