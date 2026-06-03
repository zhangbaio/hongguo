package cp4;

import androidx.compose.animation.m;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.story.api.service.StoryGoldBarStatus;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class h {
    public final float a;
    public final String b;
    public final int c;
    public final StoryGoldBarStatus d;
    public final boolean e;
    public final int f;

    static {
        Covode.recordClassIndex(609191);
    }

    public h() {
        this(0.0f, null, 0, null, false, 0, 63, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return Float.compare(this.a, hVar.a) == 0 && Intrinsics.areEqual(this.b, hVar.b) && this.c == hVar.c && this.d == hVar.d && this.e == hVar.e && this.f == hVar.f;
    }

    public int hashCode() {
        return (((((((((Float.floatToIntBits(this.a) * 31) + this.b.hashCode()) * 31) + this.c) * 31) + this.d.hashCode()) * 31) + m.a(this.e)) * 31) + this.f;
    }

    public String toString() {
        return "KmpStoryGoldBarSnapshot(currentProgress=" + this.a + ", text=" + this.b + ", countDownSecond=" + this.c + ", status=" + this.d + ", needRewardAnim=" + this.e + ", awardCount=" + this.f + ')';
    }

    public h(float f, String text, int i, StoryGoldBarStatus status, boolean z, int i2) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(status, "status");
        this.a = f;
        this.b = text;
        this.c = i;
        this.d = status;
        this.e = z;
        this.f = i2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ h(float r5, java.lang.String r6, int r7, com.dragon.read.kmp.story.api.service.StoryGoldBarStatus r8, boolean r9, int r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r4 = this;
            r12 = r11 & 1
            if (r12 == 0) goto L5
            r5 = 0
        L5:
            r12 = r11 & 2
            if (r12 == 0) goto Lb
            java.lang.String r6 = ""
        Lb:
            r12 = r6
            r6 = r11 & 4
            r0 = 0
            if (r6 == 0) goto L13
            r1 = 0
            goto L14
        L13:
            r1 = r7
        L14:
            r6 = r11 & 8
            if (r6 == 0) goto L1a
            com.dragon.read.kmp.story.api.service.StoryGoldBarStatus r8 = com.dragon.read.kmp.story.api.service.StoryGoldBarStatus.PROGRESS
        L1a:
            r2 = r8
            r6 = r11 & 16
            if (r6 == 0) goto L21
            r3 = 0
            goto L22
        L21:
            r3 = r9
        L22:
            r6 = r11 & 32
            if (r6 == 0) goto L27
            goto L28
        L27:
            r0 = r10
        L28:
            r6 = r4
            r7 = r5
            r8 = r12
            r9 = r1
            r10 = r2
            r11 = r3
            r12 = r0
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cp4.h.<init>(float, java.lang.String, int, com.dragon.read.kmp.story.api.service.StoryGoldBarStatus, boolean, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
