package com.ss.ttm.player;

import com.bytedance.covode.number.Covode;
import java.nio.ByteBuffer;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class AJMediaCodecFrame implements Cloneable {
    public ByteBuffer data;
    public int flags;
    public int index;
    public long pts = -269488145;
    public int size;

    static {
        Covode.recordClassIndex(652067);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public AJMediaCodecFrame m45clone() {
        try {
            return (AJMediaCodecFrame) super.clone();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
