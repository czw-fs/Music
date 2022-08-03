package com.example.onlinemusic.mapper;

import com.example.onlinemusic.model.Music;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.binding.BindingException;

import java.net.BindException;
import java.util.List;

/**
 * @Author 12629
 * @Date 2022/4/13 14:03
 * @Description：
 */
@Mapper
public interface MusicMapper {

    /**
     * 插入音乐
     * @param title
     * @param singer
     * @param time
     * @param url
     * @param userid
     * @return
     */
    int insert(String title,String singer,String time,String url,int userid);


    /**
     * 查询当前id的音乐是否存在
     * @param id
     * @return
     */
    Music findMusicById(int id);

    /**
     * 删除当前iD的音乐
     * @param musicId
     * @return
     */
    int deleteMusicById(int musicId);

    /**
     * 查询所有的音乐
     * @return
     */
    List<Music> findMusic();

    /**
     * 查询指定的音乐
     * @return
     */
    List<Music> findMusicByName(String musicName);

}
