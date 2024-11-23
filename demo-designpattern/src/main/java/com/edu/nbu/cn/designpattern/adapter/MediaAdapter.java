package com.edu.nbu.cn.designpattern.adapter;

/**
 * @author laoshi . hua
 * @version 1.0 2023/5/6-3:12 PM
 * @since 1.0
 */
public class MediaAdapter implements MediaPlayer{
    private AdvanceMediaPlayer advanceMediaPlayer;

    public MediaAdapter(String mediaType) {
        if(mediaType.equalsIgnoreCase("vlc")){
            advanceMediaPlayer = new VlcMediaPlayer();
        }else if(mediaType.equalsIgnoreCase("mp4")){
            advanceMediaPlayer = new Mp4MediaPlayer();
        }
    }

    @Override
    public void play(String mediaType, String fileName) {
        if(mediaType.equals("vlc")){
            advanceMediaPlayer.playVlc(fileName);
        }else if(mediaType.equals("mp4")){
            advanceMediaPlayer.playMp4(fileName);
        }
    }
}
