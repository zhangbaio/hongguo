package com.xs.fm.player.sdk.play.player.audio.engine;

import android.os.HandlerThread;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a {
    private static volatile HandlerThread a;
    public static final a b;

    private a() {
    }

    static {
        Covode.recordClassIndex(655947);
        b = new a();
    }

    public static final HandlerThread a() {
        if (a == null) {
            synchronized (b) {
                if (a == null) {
                    HandlerThread handlerThread = new HandlerThread("EngineLooperMonitorThread");
                    handlerThread.start();
                    a = handlerThread;
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        return a;
    }
}
