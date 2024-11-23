package com.edu.nbu.cn.designpattern.adapter;

/**
 * @author laoshi . hua
 * @version 1.0 2023/5/6-3:13 PM
 * @since 1.0
 */
public class AudioPlayer implements MediaPlayer{
    private MediaAdapter mediaAdapter;
    @Override
    public void play(String mediaType, String fileName) {
        if(mediaType.equalsIgnoreCase("mp3")){
            System.out.println("play mp3 " + fileName +" !");
        } else if (mediaType.equalsIgnoreCase("vlc") || mediaType.equalsIgnoreCase("mp4")) {
            mediaAdapter = new MediaAdapter(mediaType);
            mediaAdapter.play(mediaType,fileName);
        } else {
            System.out.println("not supported media type " + mediaType);
        }
    }
}
