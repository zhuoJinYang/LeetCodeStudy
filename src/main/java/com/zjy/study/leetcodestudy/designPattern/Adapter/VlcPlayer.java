package com.zjy.study.leetcodestudy.designPattern.Adapter;

/**
 * @Author zjy
 * @Date 2023/3/14 9:18
 * @Description
 */
public class VlcPlayer implements AdvanceMediaPlayer{
    @Override
    public void playVlc(String filename) {
        System.out.println("Playing vlc file. Name : "+filename);
    }

    @Override
    public void playMp4(String filename) {
        // 什么都不做
    }
}
