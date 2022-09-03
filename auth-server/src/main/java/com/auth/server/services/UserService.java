package com.auth.server.services;

import com.auth.server.entity.User;

import java.util.Optional;

public interface UserService {

    Optional<User> save(User user);
}
