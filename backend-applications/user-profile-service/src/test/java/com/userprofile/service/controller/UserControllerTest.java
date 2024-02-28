//package com.userprofile.service.controller;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.any;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import com.userprofile.service.model.User;
//import com.userprofile.service.repository.UserRepository;
//import com.userprofile.service.service.SequenceGeneratorService;
//import com.userprofile.service.service.UserService;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
//import org.springframework.http.ResponseEntity;
//
//class UserControllerTest {
//
//    @Test
//    void testAddUser() {
//
//
//        UserRepository userRepository = mock(UserRepository.class);
//        UserController userController = new UserController(new UserService(userRepository,
//                new SequenceGeneratorService(new MongoTemplate(new SimpleMongoClientDatabaseFactory("Connection String")))));
//
//        User user = new User();
//        user.setAge(1);
//        user.setEmail("satya@gmail.com");
//        user.setGender("M");
//        user.setHeight(10.0f);
//        user.setPassword("satya123");
//        user.setUserId(1L);
//        user.setUsername("satya");
//        user.setWeight(10.0f);
//        userController.addUser(user);
//        assertNotNull(userController);
//    }
//
//
//    @Test
//    void testAddUser2() {
//
//        UserRepository userRepository = mock(UserRepository.class);
//        UserController userController = new UserController(
//                new UserService(userRepository, new SequenceGeneratorService(new MongoTemplate(null))));
//
//        User user = new User();
//        user.setAge(1);
//        user.setEmail("satya@gmail.com");
//        user.setGender("M");
//        user.setHeight(10.0f);
//        user.setPassword("satya123");
//        user.setUserId(1L);
//        user.setUsername("satya");
//        user.setWeight(10.0f);
//        userController.addUser(user);
//        assertNotNull(userController);
//    }
//
//
//    @Test
//    void testAddUser3() {
//
//
//        UserRepository userRepository = mock(UserRepository.class);
//        UserController userController = new UserController(
//                new UserService(userRepository, new SequenceGeneratorService(null)));
//
//        User user = new User();
//        user.setAge(1);
//        user.setEmail("satya@gmail.com");
//        user.setGender("M");
//        user.setHeight(10.0f);
//        user.setPassword("satya123");
//        user.setUserId(1L);
//        user.setUsername("satya");
//        user.setWeight(10.0f);
//        userController.addUser(user);
//        assertNotNull(userController);
//    }
//
//
//    @Test
//    void testAddUser4() {
//
//
//        User user = new User();
//        user.setAge(1);
//        user.setEmail("satya@gmail.com");
//        user.setGender("M");
//        user.setHeight(10.0f);
//        user.setPassword("satya123");
//        user.setUserId(1L);
//        user.setUsername("satya");
//        user.setWeight(10.0f);
//        UserRepository userRepository = mock(UserRepository.class);
//        when(userRepository.save((User) any())).thenReturn(user);
//        SequenceGeneratorService sequenceGeneratorService = mock(SequenceGeneratorService.class);
//        when(sequenceGeneratorService.getSequenceNumber((String) any())).thenReturn(10);
//        UserController userController = new UserController(new UserService(userRepository, sequenceGeneratorService));
//
//        User user1 = new User();
//        user.setAge(1);
//        user.setEmail("satya@gmail.com");
//        user.setGender("M");
//        user.setHeight(10.0f);
//        user.setPassword("satya123");
//        user.setUserId(1L);
//        user.setUsername("satya");
//        user.setWeight(10.0f);
//        ResponseEntity<User> actualAddUserResult = userController.addUser(user1);
//        assertTrue(actualAddUserResult.hasBody());
//        assertTrue(actualAddUserResult.getHeaders().isEmpty());
//        assertEquals(201, actualAddUserResult.getStatusCodeValue());
//        verify(userRepository).save((User) any());
//        verify(sequenceGeneratorService).getSequenceNumber((String) any());
//        assertEquals(10L, user1.getUserId());
//    }
//}
//
