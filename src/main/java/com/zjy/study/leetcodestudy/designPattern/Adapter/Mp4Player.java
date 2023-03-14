package com.zjy.study.leetcodestudy.designPattern.Adapter;

/**
 * @Author zjy
 * @Date 2023/3/14 9:19
 * @Description
 */
public class Mp4Player implements AdvanceMediaPlayer{
    @Override
    public void playVlc(String filename) {
        // 什么也不做
    }

    @Override
    public void playMp4(String filename) {
        System.out.println("Playing mp4 file. Name : "+filename);
    }
}
