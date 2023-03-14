package com.zjy.study.leetcodestudy.designPattern.Adapter;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @Author zjy
 * @Date 2023/3/14 9:26
 * @Description
 */
@Slf4j
public class ApiTest {
    @Test
    public void testAdapter(){
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }
}
