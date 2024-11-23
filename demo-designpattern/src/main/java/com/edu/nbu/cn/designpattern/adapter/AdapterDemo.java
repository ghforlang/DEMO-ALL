package com.edu.nbu.cn.designpattern.adapter;

/**
 * @author laoshi . hua
 * @version 1.0 2023/5/6-3:31 PM
 * @since 1.0
 */
public class AdapterDemo {
    public static void main(String[] args) {
        AudioPlayer player = new AudioPlayer();
        player.play("mp5","张三的老师");
        player.play("mp3","张三的歌");
        player.play("mp4","张三的老");
        player.play("vlc","张三的师");
    }
}
