package br.com.tivit.mvpsaude.service.contract;

import br.com.tivit.mvpsaude.dto.auth.RefreshResponse;
import br.com.tivit.mvpsaude.dto.auth.LoginRequest;
import br.com.tivit.mvpsaude.dto.auth.LoginResponse;

public interface AuthenticationService {
    LoginResponse authenticateUser(LoginRequest loginRequest);

    RefreshResponse refreshTheToken(String requestRefreshToken);

    //public test version
    String resetPassword(String email);
}
