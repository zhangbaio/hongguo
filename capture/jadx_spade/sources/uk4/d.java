package uk4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d {
    static {
        Covode.recordClassIndex(608004);
    }

    public static final class a implements rk6.b {
        final /* synthetic */ c a;

        @Override // rk6.b
        public void onCancel() {
            this.a.onCancel();
        }

        @Override // rk6.b
        public void onFinish() {
            this.a.onFinish();
        }

        a(c cVar) {
            this.a = cVar;
        }
    }

    public static final rk6.a a(b bVar) {
        if (bVar != null) {
            return bVar.d;
        }
        return null;
    }

    public static final rk6.b b(c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        return new a(cVar);
    }
}
