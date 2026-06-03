package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SignalColumnType {
    public static final a a;
    private static final Lazy<SignalColumnType> b;

    @SerializedName("enable_video_pack_bottom_bar")
    public final boolean bottomBarInEnd;

    @SerializedName("enable_single_col_bottom_bar")
    public final boolean bottomBarInSingle;

    @SerializedName("isShowAbstractInfo")
    public final boolean isShowAbstractInfo;

    @SerializedName("isShowCover")
    public final boolean isShowCover;

    @SerializedName("isSpaceAdapta")
    public final boolean isSpaceOpt;

    public SignalColumnType() {
        this(false, false, false, false, false, 31, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598530);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SignalColumnType a() {
            return b();
        }

        public final SignalColumnType b() {
            return (SignalColumnType) SignalColumnType.b.getValue();
        }
    }

    static {
        Lazy<SignalColumnType> lazy;
        Covode.recordClassIndex(598529);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.f2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SignalColumnType c;
                c = SignalColumnType.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SignalColumnType c() {
        return (SignalColumnType) qq3.a.c("signal_column_type_v709", new SignalColumnType(false, false, false, false, false, 31, null), false, 4, null);
    }

    public final boolean d(int i) {
        boolean z;
        boolean z2;
        if (this.bottomBarInSingle && i == 1) {
            z = true;
        } else {
            z = false;
        }
        if (this.bottomBarInEnd && i == 5) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z && !z2) {
            return false;
        }
        return true;
    }

    public SignalColumnType(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.isShowCover = z;
        this.isSpaceOpt = z2;
        this.isShowAbstractInfo = z3;
        this.bottomBarInSingle = z4;
        this.bottomBarInEnd = z5;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ SignalColumnType(boolean r4, boolean r5, boolean r6, boolean r7, boolean r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L5
            r4 = 1
        L5:
            r10 = r9 & 2
            r0 = 0
            if (r10 == 0) goto Lc
            r10 = 0
            goto Ld
        Lc:
            r10 = r5
        Ld:
            r5 = r9 & 4
            if (r5 == 0) goto L13
            r1 = 0
            goto L14
        L13:
            r1 = r6
        L14:
            r5 = r9 & 8
            if (r5 == 0) goto L1a
            r2 = 0
            goto L1b
        L1a:
            r2 = r7
        L1b:
            r5 = r9 & 16
            if (r5 == 0) goto L20
            goto L21
        L20:
            r0 = r8
        L21:
            r5 = r3
            r6 = r4
            r7 = r10
            r8 = r1
            r9 = r2
            r10 = r0
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.component.shortvideo.api.config.ssconfig.SignalColumnType.<init>(boolean, boolean, boolean, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
