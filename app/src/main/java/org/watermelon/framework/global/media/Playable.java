package org.watermelon.framework.global.media;

import android.content.Context;
import android.view.TextureView;

public interface Playable<T extends Media> {
    void mediaPlay(Context context, T media, TextureView view);
    void mediaStop();
    boolean isPlay();
    long getCurrentPosition();
}
