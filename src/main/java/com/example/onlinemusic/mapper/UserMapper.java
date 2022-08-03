package com.example.onlinemusic.mapper;

import com.example.onlinemusic.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.Mapping;

/**
 * @Author 12629
 * @Date 2022/4/11 11:07
 * @Description：
 */
@Mapper
public interface UserMapper {
    User login(User loginUser);

    User selectByName(String username);

}
