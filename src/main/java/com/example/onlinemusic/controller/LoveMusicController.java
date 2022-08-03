package com.example.onlinemusic.controller;

import com.example.onlinemusic.mapper.LoveMusicMapper;
import com.example.onlinemusic.model.Music;
import com.example.onlinemusic.model.User;
import com.example.onlinemusic.tools.Constant;
import com.example.onlinemusic.tools.ResponseBodyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author 12629
 * @Date 2022/4/15 17:41
 * @Description：
 */
@RestController
@RequestMapping("/lovemusic")
public class LoveMusicController {

    @Resource
    private LoveMusicMapper loveMusicMapper;

    @RequestMapping("/likeMusic")
    public ResponseBodyMessage<Boolean> likeMusic(@RequestParam String id, HttpServletRequest request) {

        int musicId = Integer.parseInt(id);
        System.out.println("musicId："+musicId);
        //1、检查是否登录了
        HttpSession httpSession = request.getSession(false);
        if(httpSession == null || httpSession.getAttribute(Constant.USERINFO_SESSION_KEY) == null) {
            System.out.println("没有登录！");
            return new ResponseBodyMessage<>(-1,"请登录后上传",false);
        }

        User user = (User)httpSession.getAttribute(Constant.USERINFO_SESSION_KEY);
        int userId = user.getId();
        System.out.println("userId："+userId);

        Music music = loveMusicMapper.findLoveMusicByMusicIdAndUserId(userId,musicId);
        if(music != null) {
            //之前收藏过，不能进行收藏了!TODO:【作业】加一个取消收藏的功能！
            return new ResponseBodyMessage<>(-1,"您之前收藏过这个音乐",false);
        }

        boolean effect = loveMusicMapper.insertLoveMusic(userId,musicId);
        if(effect) {
            return new ResponseBodyMessage<>(0,"收藏成功！",true);
        }else {
            return new ResponseBodyMessage<>(0,"收藏失败！",true);
        }
    }

    @RequestMapping("/findlovemusic")
    public ResponseBodyMessage<List<Music>> findLoveMusic(@RequestParam(required = false) String musicName,
                                                          HttpServletRequest  request) {
        //1、检查是否登录了
        HttpSession httpSession = request.getSession(false);
        if(httpSession == null || httpSession.getAttribute(Constant.USERINFO_SESSION_KEY) == null) {
            System.out.println("没有登录！");
            return new ResponseBodyMessage<>(-1,"请登录后查找",null);
        }

        User user = (User)httpSession.getAttribute(Constant.USERINFO_SESSION_KEY);
        int userId = user.getId();
        System.out.println("userId："+userId);

        List<Music> musicList = null;
        if(musicName == null) {
            musicList = loveMusicMapper.findLoveMusicByUserId(userId);
        }else {
            musicList = loveMusicMapper.findLoveMusicBykeyAndUID(musicName,userId);
        }
        return new ResponseBodyMessage<>(0,"查询到了所有的歌曲信息",musicList);
    }

    @RequestMapping("/deletelovemusic")
    public ResponseBodyMessage<Boolean> deleteLoveMusic(@RequestParam String id,HttpServletRequest request) {
        int musicId = Integer.parseInt(id);

        HttpSession httpSession = request.getSession(false);
        if(httpSession == null || httpSession.getAttribute(Constant.USERINFO_SESSION_KEY) == null) {
            System.out.println("没有登录！");
            return new ResponseBodyMessage<>(-1,"请登录后移除",null);
        }

        User user = (User)httpSession.getAttribute(Constant.USERINFO_SESSION_KEY);
        int userId = user.getId();

        int ret = loveMusicMapper.deleteLoveMusic(userId,musicId);

        if(ret == 1) {
            return new ResponseBodyMessage<>(0,"取消收藏成功！",true);
        }else {
            return new ResponseBodyMessage<>(-1,"取消收藏失败！",false);
        }
    }
}
