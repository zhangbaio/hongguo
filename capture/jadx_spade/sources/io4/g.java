package io4;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.ShowType;
import com.bytedance.kmp.reading.model.VideoContentType;
import com.bytedance.kmp.reading.model.VideoInnerNextItem;
import com.bytedance.kmp.reading.model.om0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g implements d {
    public static final int f;
    public final jd4.c a;
    public ShowType b;
    public VideoInnerNextItem c;
    private boolean d;
    public final MutableState<Boolean> e;

    static {
        Covode.recordClassIndex(609043);
        f = 8;
    }

    public boolean a() {
        return this.d;
    }

    @Override // io4.d
    public om0 getVideoData() {
        return this.a.b;
    }

    public final boolean b() {
        om0 videoData = getVideoData();
        if (videoData == null) {
            return false;
        }
        Integer num = videoData.y;
        int value = VideoContentType.Album.getValue();
        if (num == null || num.intValue() != value) {
            return false;
        }
        return true;
    }

    public final boolean e() {
        List list;
        om0 videoData = getVideoData();
        if (videoData == null || (list = videoData.s0) == null || !(!list.isEmpty())) {
            return false;
        }
        return true;
    }

    public final boolean g() {
        om0 videoData = getVideoData();
        if (videoData == null) {
            return false;
        }
        Integer num = videoData.y;
        int value = VideoContentType.UnrealShortPlay.getValue();
        if (num == null || num.intValue() != value) {
            return false;
        }
        return true;
    }

    public final boolean d() {
        Integer num;
        om0 videoData = getVideoData();
        if (videoData != null) {
            num = videoData.y;
        } else {
            num = null;
        }
        if (this.a.d) {
            int value = VideoContentType.Movie.getValue();
            if (num == null || num.intValue() != value) {
                int value2 = VideoContentType.TelePlay.getValue();
                if (num != null && num.intValue() == value2) {
                }
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002c A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean f() {
        /*
            r3 = this;
            com.bytedance.kmp.reading.model.om0 r0 = r3.getVideoData()
            if (r0 == 0) goto L9
            com.bytedance.kmp.reading.model.qn0 r0 = r0.y0
            goto La
        L9:
            r0 = 0
        La:
            r1 = 0
            if (r0 == 0) goto L2d
            com.bytedance.kmp.reading.model.om0 r0 = r3.getVideoData()
            r2 = 1
            if (r0 == 0) goto L29
            com.bytedance.kmp.reading.model.qn0 r0 = r0.y0
            if (r0 == 0) goto L29
            java.lang.String r0 = r0.a
            if (r0 == 0) goto L29
            int r0 = r0.length()
            if (r0 <= 0) goto L24
            r0 = 1
            goto L25
        L24:
            r0 = 0
        L25:
            if (r0 != r2) goto L29
            r0 = 1
            goto L2a
        L29:
            r0 = 0
        L2a:
            if (r0 == 0) goto L2d
            r1 = 1
        L2d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io4.g.f():boolean");
    }

    public void h(boolean z) {
        this.d = z;
    }

    public final void i(ShowType showType) {
        Intrinsics.checkNotNullParameter(showType, "<set-?>");
        this.b = showType;
    }

    public g(jd4.c tabModel) {
        boolean z;
        Intrinsics.checkNotNullParameter(tabModel, "tabModel");
        this.a = tabModel;
        this.b = ShowType.RanklistSingleCol;
        om0 videoData = getVideoData();
        if (videoData != null) {
            z = Intrinsics.areEqual(videoData.U0, Boolean.TRUE);
        } else {
            z = false;
        }
        this.e = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z), (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    public String c(int i) {
        Object valueOf;
        StringBuilder sb = new StringBuilder();
        om0 om0Var = this.a.b;
        if (om0Var == null || (valueOf = om0Var.p) == null) {
            valueOf = Integer.valueOf(hashCode());
        }
        sb.append(valueOf);
        sb.append('_');
        sb.append(i);
        return sb.toString();
    }
}
