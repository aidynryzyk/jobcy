package kz.aidyninho.jobcy.service;

import kz.aidyninho.jobcy.dto.UserEditDto;
import kz.aidyninho.jobcy.dto.UserReadDto;
import kz.aidyninho.jobcy.entity.User;
import kz.aidyninho.jobcy.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceIT extends IntegrationTestBase {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Test
    void findById() {
        UserReadDto actual = userService.findById(1L);
        assertNotNull(actual);
        assertEquals(1, actual.getId());
        assertEquals("kaspibank", actual.getUsername());
    }

    @Test
    void findByUsername() {
        UserReadDto actual = userService.findByUsername("kaspibank");
        assertNotNull(actual);
        assertEquals(1, actual.getId());
        assertEquals("kaspibank", actual.getUsername());
    }

    @Test
    void findAll() {
        List<UserReadDto> actual = userService.findAll();
        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(2, actual.size());
        actual.forEach(userReadDto -> assertInstanceOf(UserReadDto.class, userReadDto));
    }

    @Test
    void update() {
        User actual = userMapper.toModel(userService.findById(1L));
        assertEquals("kaspibank@kaspi.kz", actual.getEmail());
        UserEditDto userEditDto = userMapper.toEditDto(actual);
        userEditDto.setEmail("changed@gmail.com");
        userService.update(userEditDto);
        UserReadDto changed = userService.findById(1L);
        assertEquals("changed@gmail.com", changed.getEmail());
    }
}