package com.elioms.cambioymoneda.services.resetPassword;

public interface ResetPasswordService {

    void resetPasswordApp(String email, String password);
    String resetPasswordWeb(String email, String password);

}
