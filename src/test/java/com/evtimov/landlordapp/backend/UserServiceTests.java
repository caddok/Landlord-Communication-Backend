package com.evtimov.landlordapp.backend;

import com.evtimov.landlordapp.backend.models.User;
import com.evtimov.landlordapp.backend.repositories.UserRepositoryImpl;
import com.evtimov.landlordapp.backend.repositories.base.UserRepository;
import com.evtimov.landlordapp.backend.services.base.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class UserServiceTests {
    @Mock
    UserRepository mockRepository;

    @Mock
    UserService userService;

    @InjectMocks
    UserRepositoryImpl mockService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void verifyRegisterUserWorks_whenCalledFromService(){
        User user = mock(User.class);
        userService.registerUser(user);
        verify(userService,times(1))
                .registerUser(user);
    }
    @Test
    public void verifyRegisterUserWorks_whenCalledFromRepository(){
        User user = mock(User.class);
        mockRepository.registerUser(user);
        verify(mockRepository,times(1))
                .registerUser(user);
    }

    @Test
    public void verifyServiceCalls_findAllTenants(){
        userService.findAllTenants();
        verify(userService,times(1))
                .findAllTenants();
    }

    @Test
    public void verifyFindAllTenants_repositoryMethodIsCalled(){
        mockRepository.findAllTenants();
        verify(mockRepository,times(1))
                .findAllTenants();
    }

    @Test
    public void verifyServiceCalls_findAllLandlords(){
        userService.findAllLandlords();
        verify(userService,times(1))
                .findAllLandlords();
    }

    @Test
    public void verifyFindAllLandlords_repositoryMethodIsCalled(){
        mockRepository.findAllLandlords();
        verify(mockRepository,times(1))
                .findAllLandlords();
    }

    @Test
    public void verifyServiceCalls_findUserByUsername(){
        userService.findUserByUsername("John Doe");
        verify(userService,times(1))
                .findUserByUsername("John Doe");
    }

    @Test
    public void verifyFindUserByUsername_repositoryMethodIsCalled(){
        mockRepository.getUserByUsername("John Doe");
        verify(mockRepository,times(1))
                .getUserByUsername("John Doe");
    }
    @Test
    public void verifyServiceCalls_getUserHashAndSalt(){
        userService.getUserHashAndSaltByUsername("username");
        verify(userService,times(1))
                .getUserHashAndSaltByUsername("username");
    }

    @Test
    public void verifyGetUserHashAndSalt_repositoryMethodIsCalled(){
        mockRepository.getUserHashAndSaltByUsername("username");
        verify(mockRepository,times(1))
                .getUserHashAndSaltByUsername("username");
    }

    @Test
    public void verifyServiceCalls_checkUsername(){
        userService.checkUsername("username");
        verify(userService,times(1))
                .checkUsername("username");
    }

    @Test
    public void verifyCheckUsername_repositoryMethodIsCalled(){
        mockRepository.checkUsername("username");
        verify(mockRepository,times(1))
                .checkUsername("username");
    }

    @Test
    public void verifyServiceCalls_checkEmail(){
        userService.checkEmail("email");
        verify(userService,times(1))
                .checkEmail("email");
    }

    @Test
    public void verifyCheckEmail_repositoryMethodIsCalled(){
        mockRepository.checkEmail("email");
        verify(mockRepository,times(1))
                .checkEmail("email");
    }
    @Test
    public void verifyServiceCalls_getUserById(){
        userService.getUserById(1);
        verify(userService,times(1))
                .getUserById(1);
    }

    @Test
    public void verifygetUserById_repositoryMethodIsCalled(){
        mockRepository.getUserById(1);
        verify(mockRepository,times(1))
                .getUserById(1);
    }



}
