package com.dragon.read.kmp.story.impl.album.viewmodel;

import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    public static final int c;
    private final Lazy a;
    private final SnapshotStateList<com.dragon.read.kmp.story.impl.album.base.a> b;

    static {
        Covode.recordClassIndex(609222);
        c = 8;
    }

    public SnapshotStateList<com.dragon.read.kmp.story.impl.album.base.a> f() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final tp4.b g() {
        return new tp4.b("StoryAlbumDataAdapter");
    }

    private final tp4.b e() {
        return (tp4.b) this.a.getValue();
    }

    public c() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.kmp.story.impl.album.viewmodel.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                tp4.b g;
                g = c.g();
                return g;
            }
        });
        this.a = lazy;
        this.b = SnapshotStateKt.mutableStateListOf();
    }

    public final void d(List<? extends com.dragon.read.kmp.story.impl.album.base.a> dataList, boolean z) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        SnapshotStateList<com.dragon.read.kmp.story.impl.album.base.a> snapshotStateList = this.b;
        if (z) {
            snapshotStateList.clear();
        }
        snapshotStateList.addAll(dataList);
    }

    public final void h(int i, com.dragon.read.kmp.story.impl.album.base.a data) {
        Intrinsics.checkNotNullParameter(data, "data");
        boolean z = false;
        if (i >= 0 && i < this.b.size()) {
            z = true;
        }
        if (z) {
            this.b.set(i, data.copy());
        }
    }

    public void b(List<? extends com.dragon.read.kmp.story.impl.album.base.a> data, Integer num) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (num != null && this.b.size() > num.intValue()) {
            this.b.addAll(num.intValue(), data);
        } else {
            this.b.addAll(data);
        }
    }

    public void c(com.dragon.read.kmp.story.impl.album.base.a data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.b.add(i, data);
        e().d("addData, pos=" + i + ",size:" + this.b.toList());
    }
}
