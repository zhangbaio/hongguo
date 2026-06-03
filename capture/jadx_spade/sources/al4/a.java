package al4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.profile.commonlayout.CommonErrorType;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final int i;
    public Pair<String, String> a;
    public String b = "";
    public int c = 150;
    public String d = "special_value_0";
    public String e = "";
    public float f = 1.0f;
    public CommonErrorType g = CommonErrorType.DefaultError;
    public Function0<Unit> h;

    static {
        Covode.recordClassIndex(608032);
        i = 8;
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.b = str;
    }

    public final void b(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.e = str;
    }

    public final void c(CommonErrorType commonErrorType) {
        Intrinsics.checkNotNullParameter(commonErrorType, "<set-?>");
        this.g = commonErrorType;
    }
}
