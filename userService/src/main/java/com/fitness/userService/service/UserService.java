package com.fitness.userService.service;

import com.fitness.userService.dto.RegisterRequest;
import com.fitness.userService.dto.UserResponse;
import com.fitness.userService.entity.User;
import com.fitness.userService.error.BadRequestException;
import com.fitness.userService.error.ResourceNotFoundException;
import com.fitness.userService.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.Nullable;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final  UserRepository userRepository;
    private final ModelMapper modelMapper;


    public UserResponse register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {

            throw new BadRequestException(

                    "User already exists with email: " + request.getEmail()

            );

        }


        User user = User.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .build();





//            User  savedUser= userRepository.save(user);
//            UserResponse userResponse = new UserResponse();
//            userResponse.setId(savedUser.getId());
//            userResponse.setPassword(savedUser.getPassword());
//            userResponse.setEmail(savedUser.getEmail());
//            userResponse.setFirstName(savedUser.getFirstName());
//            userResponse.setCreatedAt(savedUser.getCreatedAt() );
//            userResponse.setUpdatedAt(savedUser.getUpdatedAt() );
//            return userResponse;
            User savedUser =userRepository.save(user);

            return modelMapper.map(savedUser, UserResponse.class);




        }
    public UserResponse getUserProfile(String userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User",userId )
                );

        return modelMapper.map(user, UserResponse.class);
    }


    public  Boolean existByUserId(String userId) {
        log.info("calling user validation api for userId:{}",userId);
        return userRepository.existsById(userId);
    }
}
