package com.ss.ttm.player;

import com.bytedance.covode.number.Covode;
import java.nio.ByteBuffer;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class AudioProcessor extends NativeObject {
    static {
        Covode.recordClassIndex(652087);
    }

    public abstract void audioClose();

    public abstract void audioOpen(int i, int i2, int i3, int i4);

    public abstract void audioProcess(ByteBuffer[] byteBufferArr, int i, long j);

    public abstract void audioRelease(int i);
}
