package com.edu.nbu.cn.designpattern.adapter;

/**
 * @author laoshi . hua
 * @version 1.0 2023/5/6-3:16 PM
 * @since 1.0
 */
public class VlcMediaPlayer implements AdvanceMediaPlayer{
    @Override
    public void playVlc(String fileName) {
        System.out.println("playing vlc media " + fileName + "!");
    }

    @Override
    public void playMp4(String fileName) {
    }
}
