package com.example.onlinemusic.mapper;

import com.example.onlinemusic.model.Music;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author 12629
 * @Date 2022/4/15 17:09
 * @Description：
 */
@Mapper
public interface LoveMusicMapper {

    /**
     * 查询喜欢的音乐
     * @param userId
     * @param musicId
     * @return
     */
    Music findLoveMusicByMusicIdAndUserId(int userId,int musicId);

    /**
     * 收藏音乐
     * @param userId
     * @param musicId
     * @return
     */
    boolean insertLoveMusic(int userId,int musicId);


    /**
     * 查询这个用户，收藏过的所有的音乐
     * @param userId
     * @return
     */
    List<Music> findLoveMusicByUserId(int userId);


    /**
     * 查询当前用户，指定为musicName的音乐，支持模糊查询
     * @param musicName
     * @param userId
     * @return
     */
    List<Music> findLoveMusicBykeyAndUID(String musicName,int userId);

    /**
     * 移除某个用户喜欢的音乐
     * @param userId 用户的ID
     * @param musicId 音乐的ID
     * @return 受影响的行数
     */
    int deleteLoveMusic(int userId,int musicId);

    /**
     * 根据音乐的ID 进行删除
     * @param musicId 音乐的ID
     * @return
     */
    int deleteLoveMusicByMusicId(int musicId);

}
