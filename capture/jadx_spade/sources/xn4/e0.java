package xn4;

import androidx.compose.ui.graphics.e1;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e0 {
    public static final e0 a;

    static {
        Covode.recordClassIndex(608963);
        a = new e0();
    }

    private e0() {
    }

    private final zn4.b d() {
        return (zn4.b) eo0.c.a.a(Reflection.getOrCreateKotlinClass(zn4.b.class));
    }

    public static final class a implements un4.c {
        final /* synthetic */ Function1<un4.h, Unit> a;
        final /* synthetic */ Function1<Throwable, Unit> b;

        @Override // un4.c
        public void a(un4.h data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.a.invoke(data);
        }

        @Override // un4.c
        public void onFailure(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            this.b.invoke(new IllegalStateException(message));
        }

        /* JADX WARN: Multi-variable type inference failed */
        a(Function1<? super un4.h, Unit> function1, Function1<? super Throwable, Unit> function12) {
            this.a = function1;
            this.b = function12;
        }
    }

    public final e1 e(Integer num) {
        return un4.i.a(f(num));
    }

    public final un4.h a(String str) {
        zn4.b d;
        if (str == null) {
            return null;
        }
        if (StringsKt__StringsKt.isBlank(str)) {
            str = null;
        }
        if (str == null || (d = d()) == null) {
            return null;
        }
        return d.K7(str);
    }

    public final un4.h f(Integer num) {
        if (num == null) {
            return null;
        }
        int intValue = num.intValue();
        zn4.b d = a.d();
        if (d == null) {
            return null;
        }
        return d.g1(intValue);
    }

    public final String i(un4.h hVar) {
        zn4.b d;
        if (!b0.a.j() || (d = d()) == null) {
            return null;
        }
        return d.J4(hVar);
    }

    public final e1 b(String url, int i) {
        Intrinsics.checkNotNullParameter(url, "url");
        return un4.i.a(c(url, i));
    }

    public final un4.h c(String url, int i) {
        Intrinsics.checkNotNullParameter(url, "url");
        zn4.b d = d();
        if (d != null) {
            return d.createQrCode(url, i);
        }
        return null;
    }

    public final un4.h h(String posterBase64, String qrCodeContent, vn4.d qrStyle) {
        Intrinsics.checkNotNullParameter(posterBase64, "posterBase64");
        Intrinsics.checkNotNullParameter(qrCodeContent, "qrCodeContent");
        Intrinsics.checkNotNullParameter(qrStyle, "qrStyle");
        zn4.b d = d();
        if (d != null) {
            return d.k9(posterBase64, qrCodeContent, qrStyle);
        }
        return null;
    }

    public final void g(String url, Function1<? super un4.h, Unit> onSuccess, Function1<? super Throwable, Unit> onError) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        zn4.b d = d();
        if (d != null) {
            d.x4(url, new a(onSuccess, onError));
        } else {
            onError.invoke(new IllegalStateException("IShareMediaService unavailable"));
        }
    }
}
