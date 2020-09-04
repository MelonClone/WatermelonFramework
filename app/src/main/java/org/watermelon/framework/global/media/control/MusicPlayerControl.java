package org.watermelon.framework.global.media.control;

import org.watermelon.framework.global.media.listener.MusicChangedListener;
import org.watermelon.framework.global.media.player.MusicPlayer;

public interface MusicPlayerControl {
    MusicPlayer getPlayer();






    void startPlayer();
    void pausePlayer();
    void resetPlayer();
    void stopPlayer();
    void destroyPlayer();
    void releasePlayer();
    void seekTo(int pos);
    void setRepeatMode(MusicPlayer.Repeat repeatMode);
    void addMusicChangedListener(MusicChangedListener musicChangedListener);
    boolean isPlaying();
    boolean isDestroyed();
    void setVolume(float volume);
    float getVolume();
    boolean isPrepared();
    long getDuration();
    long getCurrentPosition();
    long getBufferPosition();
}
