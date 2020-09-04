package org.watermelon.framework.global.media.control;

import android.content.Context;
import android.media.AudioManager;

import androidx.annotation.NonNull;

import static android.content.Context.AUDIO_SERVICE;

/**
 * Helper class to manage audio focus requests and the UI surrounding this feature.
 */
public class AudioFocusHelper implements AudioManager.OnAudioFocusChangeListener, AudioFocusSwitch {

    private final AudioManager mAudioManager;
    private int mStreamType = AudioManager.STREAM_MUSIC;
    /**
     * AudioManager.AUDIOFOCUS_GAIN
     * AudioManager.AUDIOFOCUS_GAIN_TRANSIENT
     * AudioManager.AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK
     */
    private int mFocusType;
    private MusicPlayerControl mController;
    private AudioFocusCallback mFocusCallback;
    private float mPrevVolume = 0;

    public AudioFocusHelper(@NonNull Context context,
                             @NonNull int focusType,
                             MusicPlayerControl controller,
                            AudioFocusCallback focusCallback) {

        mAudioManager = (AudioManager) context.getSystemService(AUDIO_SERVICE);
        mFocusType = focusType;
        mController = controller;
        mFocusCallback = focusCallback;
    }

    private void requestAudioFocus(final int hint) {
        mAudioManager.requestAudioFocus(this, mStreamType, hint);
    }

    @Override
    public void onFocus() {
        requestAudioFocus(mFocusType);
        mFocusCallback.play();
    }

    @Override
    public void offFocus() {
        mAudioManager.abandonAudioFocus(this);
        mFocusCallback.stop();
    }

    @Override
    public void onAudioFocusChange(int focusChange) {
        switch (focusChange) {
            case AudioManager.AUDIOFOCUS_GAIN:
                // 정상 재생 (unknown duration.) ex) 통화
                onFocus();
                mAudioManager.setStreamVolume(mStreamType,
                        mAudioManager.getStreamMaxVolume(mStreamType),
                        AudioManager.FLAG_PLAY_SOUND);
                break;
            case AudioManager.AUDIOFOCUS_GAIN_TRANSIENT:
                // 정상 재생 (temporary gain, a short amount of time) ex) 네비 소리
                onFocus();
                break;
            case AudioManager.AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK:
                // 동시 재생 가능하나 재생시 DUCK 처리되어 작은 소리로 재생 ex) 음악
                mController.setVolume(mPrevVolume);
                onFocus();
                break;
            case AudioManager.AUDIOFOCUS_GAIN_TRANSIENT_EXCLUSIVE:
                // 단독 재생 필수 (media playback should have paused.)
                break;
            case AudioManager.AUDIOFOCUS_LOSS:
                // 정상 멈춤 (unknown duration.)
                offFocus();
                mController.pausePlayer();
                break;
            case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                // 정상 멈춤
                offFocus();
                mController.pausePlayer();
                break;
            case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                // 동시 재생중 작아짐
//                mPrevVolume = mController.getVolume();
//                mController.setVolume(20f);

                mAudioManager.setStreamVolume(mStreamType,
                        0,
                        AudioManager.FLAG_PLAY_SOUND);
                break;
            default:
                offFocus();
        }

    }
}
