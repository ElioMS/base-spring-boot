package com.elioms.cambioymoneda.services.resetPassword;

import com.elioms.cambioymoneda.exceptions.NotFoundException;
import com.elioms.cambioymoneda.models.dao.IUserDao;
import com.elioms.cambioymoneda.models.entity.User;
import com.elioms.cambioymoneda.utils.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResetPasswordServiceImpl implements ResetPasswordService {

    @Autowired
    private IUserDao iUserDao;

    @Autowired
    private MailService mailService;

    @Override
    public void resetPasswordApp(String email, String password) {
        updatePassword(email, password);

        mailService.sendMail(email, "RECUPERAR CONTRASEÑA", "SU CONTRASEÑA HA SIDO ACTUALIZADA");
    }

    @Override
    public String resetPasswordWeb(String email, String password) {
        return null;
    }

    private void updatePassword(String email, String password) {

        if (!iUserDao.existsUserByEmail(email)) {
            throw new NotFoundException("El usuario no existe");
        }

        var user = iUserDao.findByEmail(email);
        user.setPassword(password);
    }
}
