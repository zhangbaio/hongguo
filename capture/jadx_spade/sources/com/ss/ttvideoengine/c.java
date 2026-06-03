package com.ss.ttvideoengine;

import com.ss.texturerender.VideoSurface;
import java.io.Serializable;
import java.nio.ByteBuffer;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final /* synthetic */ class c implements VideoSurface.SaveFrameCallback, Serializable {
    public final /* synthetic */ SnapshotListener a;

    public /* synthetic */ c(SnapshotListener snapshotListener) {
        this.a = snapshotListener;
    }

    public final int onFrame(ByteBuffer byteBuffer, int i, int i2) {
        int lambda$snapshot$d0aa4498$1;
        lambda$snapshot$d0aa4498$1 = TTVideoEngineImpl.lambda$snapshot$d0aa4498$1(this.a, byteBuffer, i, i2);
        return lambda$snapshot$d0aa4498$1;
    }
}
