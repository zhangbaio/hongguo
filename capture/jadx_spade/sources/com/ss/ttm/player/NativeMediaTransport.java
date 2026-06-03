package com.ss.ttm.player;

import android.util.AndroidRuntimeException;
import com.bytedance.covode.number.Covode;
import com.ss.ttm.player.MediaTransport;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class NativeMediaTransport extends MediaTransport {
    static {
        Covode.recordClassIndex(652147);
    }

    private static boolean isNativeMediaTransport(MediaTransport mediaTransport) {
        return mediaTransport instanceof NativeMediaTransport;
    }

    @Override // com.ss.ttm.player.MediaTransport
    protected void sendPacket(MediaTransport.MediaPacket mediaPacket) {
        throw new AndroidRuntimeException("Should not be here");
    }
}
