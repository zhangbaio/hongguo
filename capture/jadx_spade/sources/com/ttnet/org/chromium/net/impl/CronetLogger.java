package com.ttnet.org.chromium.net.impl;

import com.bytedance.covode.number.Covode;
import java.time.Duration;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class CronetLogger {
    static {
        Covode.recordClassIndex(654597);
    }

    public abstract void a(int i, a aVar, c cVar, CronetSource cronetSource);

    public abstract void b(int i, b bVar);

    public enum CronetSource {
        CRONET_SOURCE_UNSPECIFIED,
        CRONET_SOURCE_STATICALLY_LINKED,
        CRONET_SOURCE_PLAY_SERVICES,
        CRONET_SOURCE_FALLBACK;

        static {
            Covode.recordClassIndex(654599);
        }
    }

    public static class c {
        public final int a;
        public final int b;
        public final int c;
        public final int d;

        static {
            Covode.recordClassIndex(654601);
        }

        public String toString() {
            return "" + this.a + "." + this.b + "." + this.c + "." + this.d;
        }

        public c(String str) {
            String[] split = str.split("\\.");
            this.a = Integer.parseInt(split[0]);
            this.b = Integer.parseInt(split[1]);
            this.c = Integer.parseInt(split[2]);
            this.d = Integer.parseInt(split[3]);
        }
    }

    public static class a {
        public final boolean a;
        public final String b;
        public final String c;
        public final boolean d;
        public final boolean e;
        public final boolean f;
        public final int g;
        public final String h;
        public final boolean i;
        public final int j;

        static {
            Covode.recordClassIndex(654598);
        }

        public a(CronetEngineBuilderImpl cronetEngineBuilderImpl) {
            this.a = cronetEngineBuilderImpl.d;
            this.b = cronetEngineBuilderImpl.e;
            this.c = cronetEngineBuilderImpl.f;
            this.d = cronetEngineBuilderImpl.g;
            this.e = cronetEngineBuilderImpl.h;
            this.f = cronetEngineBuilderImpl.i;
            this.g = cronetEngineBuilderImpl.e0();
            this.h = cronetEngineBuilderImpl.l;
            this.i = cronetEngineBuilderImpl.n;
            this.j = cronetEngineBuilderImpl.F0(10);
        }
    }

    public static class b {
        public final long a;
        public final long b;
        public final long c;
        public final long d;
        public final int e;
        public final Duration f;
        public final Duration g;
        public final String h;
        public final boolean i;
        public final boolean j;

        static {
            Covode.recordClassIndex(654600);
        }

        public b(long j, long j2, long j3, long j4, int i, Duration duration, Duration duration2, String str, boolean z, boolean z2) {
            this.a = j;
            this.b = j2;
            this.c = j3;
            this.d = j4;
            this.e = i;
            this.f = duration;
            this.g = duration2;
            this.h = str;
            this.i = z;
            this.j = z2;
        }
    }
}
