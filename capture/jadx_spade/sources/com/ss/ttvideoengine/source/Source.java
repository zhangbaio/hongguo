package com.ss.ttvideoengine.source;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface Source {
    public static final /* synthetic */ int a = 0;

    public static final class EncodeType {
        static {
            Covode.recordClassIndex(652684);
        }
    }

    static {
        Covode.recordClassIndex(652683);
    }

    int codecStrategy();

    boolean isCodecStrategyValid();

    Object tag();

    Type type();

    String vid();

    public enum Type {
        DIRECT_URL_SOURCE,
        VID_PLAY_AUTH_TOKEN_SOURCE,
        VIDEO_MODEL_SOURCE;

        static {
            Covode.recordClassIndex(652685);
        }
    }

    /* renamed from: com.ss.ttvideoengine.source.Source$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        static {
            int i = Source.a;
        }

        public static boolean isCodecStrategyValid(int i) {
            return i == 1 || i == 2;
        }
    }
}
