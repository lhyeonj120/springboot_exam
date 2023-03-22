package com.example.restservice.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

//    private static List<User> users = new ArrayList<>();

//    private static int usersCount = 3;
//
//    static {
//        users.add(new User(1, "kosa", new Date(), "pass1", "701010-111111"));
//        users.add(new User(2, "metanet", new Date(), "pass2", "801010-111111"));
//        users.add(new User(3, "naver", new Date(), "pass3", "901010-111111"));
//    }

    public List<User> findAll(){
        return userMapper.findAllUsers();
    }

    public User findOne(int id){
//        for(User user : users){
//            if(user.getId() == id){
//                return user;
//            }
//        }
//        return null;
        return userMapper.findUser(id);
    }

    public User save(User user){
//        if(user.getId() == null){
//            user.setId(++usersCount);
//        }
//        users.add(user);
//
//        return user;
        userMapper.createUser(user);
        return user;
    }

    public User deleteById(int id){
//        Iterator<User> iterator = users.iterator();
//
//        while(iterator.hasNext()){
//            User user = iterator.next();
//
//            if(user.getId() == id){
//                iterator.remove();
//                return user;
//            }
//        }
//
//        return null;
        User deletedUser = userMapper.findUser(id);
        return userMapper.deleteUser(id) == true ? deletedUser : null;
    }
}
