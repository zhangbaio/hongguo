package com.ss.videoarch.liveplayer.effect;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.texturerender.VideoSurface;
import com.ss.texturerender.effect.ICEffect.ICEffectWrapper;
import com.ss.videoarch.liveplayer.VideoLiveManager;
import com.ss.videoarch.liveplayer.t;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class VeLivePlayerVideoEffectManager {
    private VideoSurface a;
    private boolean e;
    public boolean f;
    private VideoLiveManager g;
    public boolean b = false;
    private boolean c = false;
    private boolean d = false;
    private final int h = 2;
    private final int i = 3;
    private final int j = 4;
    private final int k = 5;
    private final int l = 6;
    private final int m = 8;

    public interface VeLivePlayerVideoEffectCallback {
        void onResult(t tVar);
    }

    public interface VeLivePlayerVideoEffectMessageListener {
        void onMessage(int i, long j, long j2, String str);
    }

    public interface VeLivePlayerVideoEffectResourceFinder {
        long createNativeResourceFinder(long j);

        void release(long j);
    }

    static {
        Covode.recordClassIndex(653027);
    }

    public void b() {
        if (this.e && this.a != null) {
            com.ss.videoarch.liveplayer.log.a.c("VeLivePlayerVideoEffectManager", "release effect");
            Bundle bundle = new Bundle();
            bundle.putInt("effect_type", 21);
            bundle.putInt("action", 10);
            this.a.setEffect(bundle);
            this.e = false;
            this.f = false;
            this.b = false;
            this.g.stopUseTextureRender();
        }
    }

    /* renamed from: com.ss.videoarch.liveplayer.effect.VeLivePlayerVideoEffectManager$3, reason: invalid class name */
    class AnonymousClass3 implements ICEffectWrapper.IEffectResourceFinder {
        final /* synthetic */ a val$configuration;

        public void release(long j) {
        }

        public long createNativeResourceFinder(long j) {
            throw null;
        }

        AnonymousClass3(a aVar) {
        }
    }

    /* renamed from: com.ss.videoarch.liveplayer.effect.VeLivePlayerVideoEffectManager$2, reason: invalid class name */
    class AnonymousClass2 implements ICEffectWrapper.IEffectInitCallback {
        final /* synthetic */ a val$configuration;

        public void onInitCallback(int i) {
            if (i == 0) {
                new t(t.a.a);
                VeLivePlayerVideoEffectManager.this.f = true;
            } else {
                new t(t.a.u);
            }
            throw null;
        }

        AnonymousClass2(a aVar) {
        }
    }

    public VeLivePlayerVideoEffectManager(VideoLiveManager videoLiveManager) {
        this.g = videoLiveManager;
    }

    public void d(int i) {
        com.ss.videoarch.liveplayer.log.a.c("VeLivePlayerVideoEffectManager", "setVideoEffectSixDofLiteMode: " + i);
        if (this.e && this.a != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("action", 13);
            bundle.putInt("effect_type", 21);
            bundle.putInt("int_value", i);
            this.a.setEffect(bundle);
        }
    }

    /* renamed from: com.ss.videoarch.liveplayer.effect.VeLivePlayerVideoEffectManager$1, reason: invalid class name */
    class AnonymousClass1 implements ICEffectWrapper.IEffectMsgListener {
        final /* synthetic */ a val$configuration;

        AnonymousClass1(a aVar) {
        }

        public void onMessageReceived(int i, long j, long j2, String str) {
            throw null;
        }
    }

    public void c(String str, String str2) {
        if (this.e && this.a != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && this.b) {
            Bundle bundle = new Bundle();
            bundle.putInt("effect_type", 21);
            bundle.putInt("action", 6);
            bundle.putString("sei_key", str);
            bundle.putString("sei_info", str2);
            this.a.setEffect(bundle);
        }
    }
}
