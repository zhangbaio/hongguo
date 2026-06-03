package op4;

import a0.l;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.t;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.service.b1;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mn0.m;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a implements kn0.c {
    private final tp4.b a = new tp4.b("CustomResourceCallback");

    static {
        Covode.recordClassIndex(609331);
    }

    public void b(on0.a document) {
        Intrinsics.checkNotNullParameter(document, "document");
    }

    /* renamed from: op4.a$a, reason: collision with other inner class name */
    static final class C0250a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ String a;
        final /* synthetic */ float b;
        final /* synthetic */ float c;

        C0250a(String str, float f, float f2) {
            this.a = str;
            this.b = f;
            this.c = f2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(Composer composer, int i) {
            boolean z;
            boolean z2;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1666014616, i, -1, "com.dragon.read.kmp.story.impl.feeds.paging.CustomResourceCallback.getCustomComposable.<anonymous> (CustomResourceCallback.kt:35)");
                }
                String str = this.a;
                if (str != null && str.length() != 0) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!(!z2)) {
                    str = null;
                }
                if (str != null) {
                    float f = this.b;
                    float f2 = this.c;
                    f.c(str, l.d((Float.floatToRawIntBits(f2) & 4294967295L) | (Float.floatToRawIntBits(f) << 32)), composer, 0);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    public mn0.a a(String str, String str2, m mVar, l lVar) {
        boolean z;
        this.a.a("getCustomComposable: relative_path=" + str + ",parent_path=" + str2 + ", size=" + lVar);
        if (lVar != null) {
            if (!l.h(lVar.o(), l.b.b())) {
                if (Float.intBitsToFloat((int) (lVar.o() >> 32)) == 0.0f) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    float q = b1.a.q() - 44;
                    float intBitsToFloat = (Float.intBitsToFloat((int) (lVar.o() & 4294967295L)) / Float.intBitsToFloat((int) (lVar.o() >> 32))) * q;
                    return new mn0.a(0.0f, 0.0f, q, intBitsToFloat, 0, t.c(-1666014616, true, new C0250a(str, q, intBitsToFloat)), mVar);
                }
                return null;
            }
            return null;
        }
        return null;
    }
}
