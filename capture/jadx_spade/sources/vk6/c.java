package vk6;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.Resolution;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class c {
    public Context a;
    public boolean b;
    public boolean d;
    public boolean e;
    public String g;
    public long h;
    public long k;
    public long l;
    public boolean m;
    public final pk6.c n;
    public boolean c = true;
    public boolean f = true;
    public Resolution i = Resolution.Standard;
    public String j = "default";

    static {
        Covode.recordClassIndex(655852);
    }

    public final Context getContext() {
        return this.a;
    }

    public String toString() {
        return "PreloadInfo(playParam=" + this.n + ", needRetry=" + this.b + ", needPrepare=" + this.c + ", prepareWithSurface=" + this.d + ", needCancelWhenNotWifi=" + this.f + ", cacheKey=" + this.g + ", preloadVideoSize=" + this.h + ", dashPreloadAudioSize=" + this.k + ", dashPreloadVideoSize=" + this.l + ", preloadResolution=" + this.i + ", preloadScene=" + this.j + ", onlyPreloadVm=" + this.m + ')';
    }

    public final void a(Resolution resolution) {
        this.i = resolution;
    }

    public final void b(String str) {
        this.j = str;
    }

    public c(pk6.c cVar) {
        this.n = cVar;
    }
}
