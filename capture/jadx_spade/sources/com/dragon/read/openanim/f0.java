package com.dragon.read.openanim;

import android.view.View;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f0 extends b {
    public static final a m;
    public static final int n;
    public o i;
    public o j;
    public int k;
    public boolean l;

    static {
        Covode.recordClassIndex(612655);
        m = new a(null);
        n = 8;
    }

    @Override // com.dragon.read.openanim.b
    protected o g() {
        return this.i;
    }

    @Override // com.dragon.read.openanim.b
    protected o h() {
        return this.j;
    }

    public static final class a {
        static {
            Covode.recordClassIndex(612656);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final f0 a(View boundView, View view) {
            Intrinsics.checkNotNullParameter(boundView, "boundView");
            return new f0();
        }

        public static /* synthetic */ f0 b(a aVar, View view, View view2, int i, Object obj) {
            if ((i & 2) != 0) {
                view2 = null;
            }
            return aVar.a(view, view2);
        }
    }
}
