package ws3;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.NsShortVideoApi;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class l {
    public static final l a;

    static {
        Covode.recordClassIndex(599162);
        a = new l();
    }

    private l() {
    }

    public final boolean d(String str) {
        return Intrinsics.areEqual(str, "short_series_task_video_editor_internal_preview");
    }

    public final String b(String seriesID) {
        Intrinsics.checkNotNullParameter(seriesID, "seriesID");
        return "short_series_task_" + seriesID;
    }

    public final boolean c(String str) {
        if (!Intrinsics.areEqual(str, "short_series_task_video_editor") && !Intrinsics.areEqual(str, "short_series_task_video_editor_internal") && !Intrinsics.areEqual(str, "short_series_task_video_editor_internal_preview")) {
            return false;
        }
        return true;
    }

    public final boolean e(String str) {
        if (str == null || !StringsKt__StringsJVMKt.startsWith$default(str, "short_series_task", false, 2, null)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
    
        r9 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r9, new java.lang.String[]{"_"}, false, 0, 6, (java.lang.Object) null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String a(java.lang.String r9) {
        /*
            r8 = this;
            boolean r0 = r8.e(r9)
            java.lang.String r1 = ""
            if (r0 == 0) goto L25
            if (r9 == 0) goto L25
            java.lang.String r0 = "_"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r4 = 0
            r5 = 0
            r6 = 6
            r7 = 0
            r2 = r9
            java.util.List r9 = kotlin.text.StringsKt.split$default(r2, r3, r4, r5, r6, r7)
            if (r9 == 0) goto L25
            java.lang.Object r9 = kotlin.collections.CollectionsKt.lastOrNull(r9)
            java.lang.String r9 = (java.lang.String) r9
            if (r9 != 0) goto L24
            goto L25
        L24:
            r1 = r9
        L25:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ws3.l.a(java.lang.String):java.lang.String");
    }

    public final Pair<Boolean, String> f(q video, int i) {
        Intrinsics.checkNotNullParameter(video, "video");
        return NsShortVideoApi.IMPL.enableUpload(video, i);
    }
}
