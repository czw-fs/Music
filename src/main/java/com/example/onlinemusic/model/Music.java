package com.example.onlinemusic.model;

import lombok.Data;

/**
 * @Author 12629
 * @Date 2022/4/11 17:38
 * @Description：
 */
@Data
public class Music {
    private int id;
    private String title;
    private String singer;
    private String time;
    private String url;
    private int userid;
}
