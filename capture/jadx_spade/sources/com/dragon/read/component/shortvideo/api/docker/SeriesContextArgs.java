package com.dragon.read.component.shortvideo.api.docker;

import com.bytedance.covode.number.Covode;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SeriesContextArgs implements Serializable {
    public static final a Companion;
    private static final long serialVersionUID = 0;
    private boolean firstResume;
    private boolean hasShownListeningOnce;
    private boolean pausedByScene;

    public static final class a {
        static {
            Covode.recordClassIndex(598655);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(598654);
        Companion = new a(null);
    }

    public SeriesContextArgs() {
        this(false, false, false, 7, null);
    }

    public final boolean getFirstResume() {
        return this.firstResume;
    }

    public final boolean getHasShownListeningOnce() {
        return this.hasShownListeningOnce;
    }

    public final boolean getPausedByScene() {
        return this.pausedByScene;
    }

    public final void setFirstResume(boolean z) {
        this.firstResume = z;
    }

    public final void setHasShownListeningOnce(boolean z) {
        this.hasShownListeningOnce = z;
    }

    public final void setPausedByScene(boolean z) {
        this.pausedByScene = z;
    }

    public SeriesContextArgs(boolean z, boolean z2, boolean z3) {
        this.hasShownListeningOnce = z;
        this.pausedByScene = z2;
        this.firstResume = z3;
    }

    public /* synthetic */ SeriesContextArgs(boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? true : z3);
    }
}
