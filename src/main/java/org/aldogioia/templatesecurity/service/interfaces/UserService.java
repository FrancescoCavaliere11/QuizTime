package org.aldogioia.templatesecurity.service.interfaces;


import org.aldogioia.templatesecurity.data.dto.UserCreateDto;

public interface UserService {
    void createCustomer(UserCreateDto userCreateDto);
}
