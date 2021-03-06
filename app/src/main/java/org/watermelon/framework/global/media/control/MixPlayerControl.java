package org.watermelon.framework.global.media.control;

public interface MixPlayerControl extends MusicPlayerControl {

    void startMix();
    void stopMix();
    void pauseMix();
    void resetMix();
    void clearMix();
    void addMix(MusicPlayerControl mixPlayer);
    void setMixVolume(int index, float volume);
}