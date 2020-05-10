package com.arexe.lmatic.user;

import java.util.Optional;

public interface UserService {

    Optional<User> findById(Long id);

    User save(User user);

    Iterable<User> findAll();

}
