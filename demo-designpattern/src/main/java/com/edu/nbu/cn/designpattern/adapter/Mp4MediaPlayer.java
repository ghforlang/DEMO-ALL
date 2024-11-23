package com.edu.nbu.cn.designpattern.adapter;

/**
 * @author laoshi . hua
 * @version 1.0 2023/5/6-3:18 PM
 * @since 1.0
 */
public class Mp4MediaPlayer implements AdvanceMediaPlayer{
    @Override
    public void playVlc(String fileName) {
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("playing mp4 " + fileName + "!");
    }
}
