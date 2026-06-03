package bk4;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g extends i {
    public static final int t;

    static {
        Covode.recordClassIndex(607752);
        t = yh4.g.l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e1(g gVar, ck4.a aVar, int i, Composer composer, int i2) {
        gVar.X0(aVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(wh4.i depend) {
        super(depend);
        Intrinsics.checkNotNullParameter(depend, "depend");
    }

    public final String i1(String originalText) {
        boolean contains$default;
        String replace$default;
        Intrinsics.checkNotNullParameter(originalText, "originalText");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) originalText, (CharSequence) "章", false, 2, (Object) null);
        if (contains$default) {
            replace$default = StringsKt__StringsJVMKt.replace$default(originalText, "章", "话", false, 4, (Object) null);
            return replace$default;
        }
        return originalText;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0031, code lost:
    
        r4 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0045, code lost:
    
        r7 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000d, code lost:
    
        r1 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String h1(ck4.a r18) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: bk4.g.h1(ck4.a):java.lang.String");
    }

    @Override // bk4.i
    public void X0(final ck4.a data, Composer composer, final int i) {
        int i2;
        boolean z;
        boolean changedInstance;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(data, "data");
        Composer startRestartGroup = composer.startRestartGroup(-509840918);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(data)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if ((i & 64) == 0) {
                changedInstance = startRestartGroup.changed(this);
            } else {
                changedInstance = startRestartGroup.changedInstance(this);
            }
            if (changedInstance) {
                i3 = 32;
            } else {
                i3 = 16;
            }
            i2 |= i3;
        }
        if ((i2 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-509840918, i2, -1, "com.dragon.read.kmp.mine.search.holder.BookCollectSearchHolder.bindSubTitle (BookCollectSearchHolder.kt:22)");
            }
            Q0(h1(data));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: bk4.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit e1;
                    e1 = g.e1(g.this, data, i, (Composer) obj, ((Integer) obj2).intValue());
                    return e1;
                }
            });
        }
    }

    public final String f1(Integer num, float f, int i, int i2) {
        boolean z;
        if (f >= 0.9995d) {
            z = true;
        } else {
            z = false;
        }
        if (f > 0.0f && i != 0) {
            if (z) {
                if (nc4.a.a.q(num)) {
                    return "已读完";
                }
                return "已听完";
            }
            return (i + "") + "章/" + i2 + (char) 31456;
        }
        if (nc4.a.a.q(num)) {
            return "未读过";
        }
        return "未听过";
    }

    public final String g1(int i, int i2, int i3, float f, int i4) {
        float f2 = (i * 1.0f) / i2;
        nc4.a aVar = nc4.a.a;
        return aVar.c(i3, f2, f, aVar.s(Integer.valueOf(i4)));
    }
}
