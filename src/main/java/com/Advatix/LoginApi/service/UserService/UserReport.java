package com.Advatix.LoginApi.service.UserService;

import com.Advatix.LoginApi.dao.UserRepo;
import com.Advatix.LoginApi.entity.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserReport {
    @Autowired
    private UserRepo userRepo;

    public Map<String, List<String>> getListMap(Map<Integer, String> map) {
        Map<String, List<String>> map1 = new HashMap<>();
        List<User> listUser = userRepo.findAll();
        List<String> ls = new ArrayList<>();
        List<String> ls1 = new ArrayList<>();

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().equals("uid")) {
                for (User user : listUser) {
                    ls.add(String.valueOf(user.getUid()));
                }
                map1.put(entry.getValue(), ls);
            } else if (entry.getValue().equals("uName")) {
                for (User user : listUser) {
                    ls1.add(user.getUserName());
                }
                map1.put(entry.getValue(), ls1);
            }
        }
        return map1;
    }
}
