package com.softwarefoundation.booksellerapi.service;

import com.softwarefoundation.booksellerapi.model.User;

public interface IAuthenticationService {
    User signInAndReturnJWT(User signRequest);
}
