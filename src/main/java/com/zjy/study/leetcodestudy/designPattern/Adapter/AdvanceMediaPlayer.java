package com.zjy.study.leetcodestudy.designPattern.Adapter;

/**
 * @Author zjy
 * @Date 2023/3/14 9:17
 * @Description
 *      更高级的媒体播放器
 */
public interface AdvanceMediaPlayer {
    public void playVlc(String filename);
    public void playMp4(String filename);
}
