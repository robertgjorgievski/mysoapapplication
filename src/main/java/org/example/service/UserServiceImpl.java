package org.example.service;

import com.example.soap.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    private static final Map<Integer, User> users = new HashMap<>();

    static {
        User user1 = new User();
        user1.setId(1);
        user1.setName("John Doe");
        user1.setEmail("john@example.com");

        User user2 = new User();
        user2.setId(2);
        user2.setName("Jane Smith");
        user2.setEmail("jane@example.com");

        users.put(user1.getId(), user1);
        users.put(user2.getId(), user2);
    }

    @Override
    public User getUserById(int id) {
        return users.get(id);
    }
}
