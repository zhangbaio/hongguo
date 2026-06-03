package com.dragon.read.component.shortvideo.api;

import android.view.View;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.Args;
import com.dragon.read.plugin.common.api.live.feed.LiveFeedScene;
import com.dragon.read.rpc.model.LiveRoomData;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface t {

    public interface a {

        /* renamed from: com.dragon.read.component.shortvideo.api.t$a$a, reason: collision with other inner class name */
        public static final class C0015a {
            static {
                Covode.recordClassIndex(598155);
            }

            public static void a(a aVar) {
            }

            public static void b(a aVar) {
            }
        }

        void onComplete();

        void onError(String str);

        void onFirstFrame();

        void onPause();

        void onPlaying();

        void onPrepared();

        void onResume();

        void p();
    }

    void V0(LiveRoomData liveRoomData, b bVar, int i);

    void enterLiveRoom();

    View getLayoutView();

    boolean isPlaying();

    void release();

    void setPreviewStatusListener(a aVar);

    void start();

    void stop();

    public static final class b {
        public static final int g;
        public final boolean a;
        public final boolean b;
        public final LiveFeedScene c;
        public final int d;
        public final Integer e;
        public final Args f;

        static {
            Covode.recordClassIndex(598156);
            g = 8;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.a == bVar.a && this.b == bVar.b && this.c == bVar.c && this.d == bVar.d && Intrinsics.areEqual(this.e, bVar.e) && Intrinsics.areEqual(this.f, bVar.f);
        }

        public int hashCode() {
            int a = ((((((androidx.compose.animation.m.a(this.a) * 31) + androidx.compose.animation.m.a(this.b)) * 31) + this.c.hashCode()) * 31) + this.d) * 31;
            Integer num = this.e;
            return ((a + (num == null ? 0 : num.hashCode())) * 31) + this.f.hashCode();
        }

        public String toString() {
            return "VideoLivePreviewConfig(isBlurCover=" + this.a + ", isMute=" + this.b + ", scene=" + this.c + ", viewWidth=" + this.d + ", coverPlaceHolder=" + this.e + ", extraReportArgs=" + this.f + ')';
        }

        public b(boolean z, boolean z2, LiveFeedScene scene, int i, Integer num, Args extraReportArgs) {
            Intrinsics.checkNotNullParameter(scene, "scene");
            Intrinsics.checkNotNullParameter(extraReportArgs, "extraReportArgs");
            this.a = z;
            this.b = z2;
            this.c = scene;
            this.d = i;
            this.e = num;
            this.f = extraReportArgs;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public /* synthetic */ b(boolean r10, boolean r11, com.dragon.read.plugin.common.api.live.feed.LiveFeedScene r12, int r13, java.lang.Integer r14, com.dragon.read.base.Args r15, int r16, kotlin.jvm.internal.DefaultConstructorMarker r17) {
            /*
                r9 = this;
                r0 = r16 & 1
                r1 = 1
                if (r0 == 0) goto L7
                r3 = 1
                goto L8
            L7:
                r3 = r10
            L8:
                r0 = r16 & 2
                if (r0 == 0) goto Le
                r4 = 1
                goto Lf
            Le:
                r4 = r11
            Lf:
                r0 = r16 & 16
                if (r0 == 0) goto L16
                r0 = 0
                r7 = r0
                goto L17
            L16:
                r7 = r14
            L17:
                r0 = r16 & 32
                if (r0 == 0) goto L22
                com.dragon.read.base.Args r0 = new com.dragon.read.base.Args
                r0.<init>()
                r8 = r0
                goto L23
            L22:
                r8 = r15
            L23:
                r2 = r9
                r5 = r12
                r6 = r13
                r2.<init>(r3, r4, r5, r6, r7, r8)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.component.shortvideo.api.t.b.<init>(boolean, boolean, com.dragon.read.plugin.common.api.live.feed.LiveFeedScene, int, java.lang.Integer, com.dragon.read.base.Args, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }
    }
}
