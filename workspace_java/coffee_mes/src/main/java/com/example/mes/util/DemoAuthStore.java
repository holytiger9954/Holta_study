package com.example.mes.util;

import com.example.mes.model.User;

import java.util.HashMap;
import java.util.Map;

public class DemoAuthStore {
    private static final Map<String, User> USER_MAP = new HashMap<>();

    static {
        USER_MAP.put("admin", new User("admin", "admin1234", "김관리", "ADMIN"));
        USER_MAP.put("worker", new User("worker", "worker1234", "이작업", "WORKER"));
    }

    private DemoAuthStore() {
    }

    public static User authenticate(String userId, String password) {
        User user = USER_MAP.get(userId);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
