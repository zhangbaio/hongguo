package np4;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.compose.common.load.LoadStatus;
import com.dragon.read.kmp.story.impl.feeds.enums.PageShadeStyle;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e extends gp4.b {
    public static final int l;
    public final nn0.b e;
    public final int f;
    private final MutableState g;
    private final MutableState h;
    private final MutableState i;
    private final MutableState j;
    private final MutableState k;

    static {
        Covode.recordClassIndex(609321);
        l = bp4.a.c | nn0.b.b;
    }

    @Override // gp4.b
    public int b() {
        return this.f;
    }

    public final LoadStatus d() {
        return (LoadStatus) this.j.getValue();
    }

    public final int e() {
        return ((Number) this.g.getValue()).intValue();
    }

    public final PageShadeStyle f() {
        return (PageShadeStyle) this.i.getValue();
    }

    public final boolean g() {
        return ((Boolean) this.h.getValue()).booleanValue();
    }

    @Override // yo4.c
    public int i() {
        return (int) Float.intBitsToFloat((int) (this.e.k(this.f) & 4294967295L));
    }

    public final void h(boolean z) {
        this.k.setValue(Boolean.valueOf(z));
    }

    public final void j(LoadStatus loadStatus) {
        Intrinsics.checkNotNullParameter(loadStatus, "<set-?>");
        this.j.setValue(loadStatus);
    }

    public final void k(int i) {
        this.g.setValue(Integer.valueOf(i));
    }

    public final void l(PageShadeStyle pageShadeStyle) {
        Intrinsics.checkNotNullParameter(pageShadeStyle, "<set-?>");
        this.i.setValue(pageShadeStyle);
    }

    public final void m(boolean z) {
        this.h.setValue(Boolean.valueOf(z));
    }

    @Override // yo4.c
    public String a(int i) {
        return c() + "_text_" + i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(String storyId, String chapterId, nn0.b richTextChapter, int i) {
        super(storyId, chapterId);
        Intrinsics.checkNotNullParameter(storyId, "storyId");
        Intrinsics.checkNotNullParameter(chapterId, "chapterId");
        Intrinsics.checkNotNullParameter(richTextChapter, "richTextChapter");
        this.e = richTextChapter;
        this.f = i;
        this.g = SnapshotStateKt.mutableStateOf$default(-1, (SnapshotMutationPolicy) null, 2, (Object) null);
        Boolean bool = Boolean.FALSE;
        this.h = SnapshotStateKt.mutableStateOf$default(bool, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.i = SnapshotStateKt.mutableStateOf$default(PageShadeStyle.None, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.j = SnapshotStateKt.mutableStateOf$default(LoadStatus.Init, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.k = SnapshotStateKt.mutableStateOf$default(bool, (SnapshotMutationPolicy) null, 2, (Object) null);
    }
}
