package fp4;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class c {
    public static final int f;
    public final String a;
    public final org.jetbrains.compose.resources.b b;
    public final boolean c;
    public Function0<Unit> d;
    public Function0<Unit> e;

    static {
        Covode.recordClassIndex(609235);
        f = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c() {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d() {
        return Unit.INSTANCE;
    }

    public final void e(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.e = function0;
    }

    public final void f(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.d = function0;
    }

    public c(String itemName, org.jetbrains.compose.resources.b bVar, boolean z, Function0<Unit> onShow, Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter(itemName, "itemName");
        Intrinsics.checkNotNullParameter(onShow, "onShow");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.a = itemName;
        this.b = bVar;
        this.c = z;
        this.d = onShow;
        this.e = onClick;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ c(java.lang.String r7, org.jetbrains.compose.resources.b r8, boolean r9, kotlin.jvm.functions.Function0 r10, kotlin.jvm.functions.Function0 r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r6 = this;
            r13 = r12 & 1
            if (r13 == 0) goto L6
            java.lang.String r7 = ""
        L6:
            r1 = r7
            r7 = r12 & 4
            if (r7 == 0) goto Le
            r9 = 1
            r3 = 1
            goto Lf
        Le:
            r3 = r9
        Lf:
            r7 = r12 & 8
            if (r7 == 0) goto L18
            fp4.a r10 = new fp4.a
            r10.<init>()
        L18:
            r4 = r10
            r7 = r12 & 16
            if (r7 == 0) goto L22
            fp4.b r11 = new fp4.b
            r11.<init>()
        L22:
            r5 = r11
            r0 = r6
            r2 = r8
            r0.<init>(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fp4.c.<init>(java.lang.String, org.jetbrains.compose.resources.b, boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
