package com.ss.ttm.player;

import android.content.Context;
import android.graphics.Rect;
import android.util.Size;
import android.view.ViewGroup;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface TTAVPlayerView {

    public interface LifeCycleCallback {

        /* renamed from: com.ss.ttm.player.TTAVPlayerView$LifeCycleCallback$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$onNewSurfaceAvailable(LifeCycleCallback lifeCycleCallback) {
            }
        }

        void onLoad(TTAVWindowClient tTAVWindowClient);

        void onNewSurfaceAvailable();
    }

    void attachToParent(ViewGroup viewGroup);

    void attachToParent(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams);

    void detachFromParent();

    Rect getSurfacePosition();

    Size getSurfaceSize();

    int getViewHeight();

    int getViewWidth();

    int getVisibility();

    boolean isSurfaceAvailable();

    boolean isSurfaceView();

    void setLayoutParams(ViewGroup.LayoutParams layoutParams);

    void setLifeCycleCallback(LifeCycleCallback lifeCycleCallback);

    void setScaleType(int i, float f, float f2);

    void setVisibility(int i);

    public static class Factory {
        static {
            Covode.recordClassIndex(652167);
        }

        public static TTAVPlayerView create(Context context, LifeCycleCallback lifeCycleCallback, int i, float f, int i2) {
            return new TTPlayerView(context, lifeCycleCallback, i, f, i2);
        }
    }
}
