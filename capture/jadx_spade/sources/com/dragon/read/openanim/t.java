package com.dragon.read.openanim;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.ThreadUtils;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class t extends a {
    public static final int e;
    private final RecyclerView c;
    private final RecyclerView.ItemAnimator d;

    static {
        Covode.recordClassIndex(612639);
        e = 8;
    }

    @Override // com.dragon.read.openanim.a
    public void a() {
        ThreadUtils.postInForeground(new Runnable() { // from class: com.dragon.read.openanim.s
            @Override // java.lang.Runnable
            public final void run() {
                t.c(t.this);
            }
        }, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(t tVar) {
        tVar.c.setItemAnimator(tVar.d);
    }

    public t(RecyclerView rv) {
        Intrinsics.checkNotNullParameter(rv, "rv");
        this.c = rv;
        this.d = rv.getItemAnimator();
        rv.setItemAnimator((RecyclerView.ItemAnimator) null);
    }
}
