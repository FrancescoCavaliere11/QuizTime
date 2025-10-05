package org.aldogioia.templatesecurity.service.implementations;

import lombok.RequiredArgsConstructor;
import org.aldogioia.templatesecurity.data.dao.UserDao;
import org.aldogioia.templatesecurity.data.dto.UserCreateDto;
import org.aldogioia.templatesecurity.data.entities.User;
import org.aldogioia.templatesecurity.service.interfaces.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final ModelMapper modelMapper;

    @Override
    public void createCustomer(UserCreateDto userCreateDto) {
        User user = modelMapper.map(userCreateDto, User.class);
        userDao.save(user);
    }
}
