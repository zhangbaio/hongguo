package com.xs.fm.player.sdk.play.address;

import com.bytedance.covode.number.Covode;
import com.xs.fm.player.base.play.address.PlayAddress;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class PlayAddressCache implements Serializable {
    private boolean hasAddPreloadTask;
    private boolean isAuditing;
    private final PlayAddress playAddress;

    static {
        Covode.recordClassIndex(655919);
    }

    public final boolean getHasAddPreloadTask() {
        return this.hasAddPreloadTask;
    }

    public final PlayAddress getPlayAddress() {
        return this.playAddress;
    }

    public final boolean isAuditing() {
        return this.isAuditing;
    }

    public final void setAuditing(boolean z) {
        this.isAuditing = z;
    }

    public final void setHasAddPreloadTask(boolean z) {
        this.hasAddPreloadTask = z;
    }

    public PlayAddressCache(PlayAddress playAddress) {
        this.playAddress = playAddress;
    }
}
