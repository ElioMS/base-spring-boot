package com.elioms.cambioymoneda.services.register;

import com.elioms.cambioymoneda.models.request.RegisterRequest;

public interface RegisterService {
    String register(RegisterRequest body);
}
