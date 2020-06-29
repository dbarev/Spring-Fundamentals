package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.model.entity.User;
import softuni.exam.model.service.UserServiceModel;
import softuni.exam.repository.UserRepository;
import softuni.exam.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper mapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public UserServiceModel register(UserServiceModel userServiceModel) {
        return this.mapper.map(this.userRepository
                .saveAndFlush(this.mapper
                        .map(userServiceModel, User.class)), UserServiceModel.class);
    }

    @Override
    public UserServiceModel findByUsername(String username) {
        return this.userRepository
                .findByUsername(username)
                .map(user -> this.mapper.map(user, UserServiceModel.class))
                .orElse(null);
    }
}
