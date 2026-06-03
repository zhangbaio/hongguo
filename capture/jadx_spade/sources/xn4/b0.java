package xn4;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.json.JsonObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b0 {
    public static final b0 a;

    static {
        Covode.recordClassIndex(608960);
        a = new b0();
    }

    private b0() {
    }

    private final zn4.a c() {
        return (zn4.a) eo0.c.a.a(Reflection.getOrCreateKotlinClass(zn4.a.class));
    }

    public final boolean g() {
        zn4.a c = c();
        if (c != null) {
            return c.v3();
        }
        return false;
    }

    public final boolean j() {
        zn4.a c = c();
        if (c != null) {
            return c.b7();
        }
        return false;
    }

    public static final class a implements zn4.c {
        final /* synthetic */ Function1<vn4.b, Unit> a;
        final /* synthetic */ Function1<Throwable, Unit> b;

        @Override // zn4.c
        public void a(vn4.b content) {
            Intrinsics.checkNotNullParameter(content, "content");
            this.a.invoke(content);
        }

        @Override // zn4.c
        public void onFailure(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            this.b.invoke(new IllegalStateException(message));
        }

        /* JADX WARN: Multi-variable type inference failed */
        a(Function1<? super vn4.b, Unit> function1, Function1<? super Throwable, Unit> function12) {
            this.a = function1;
            this.b = function12;
        }
    }

    public final byte[] b(String resId) {
        Intrinsics.checkNotNullParameter(resId, "resId");
        zn4.a c = c();
        if (c != null) {
            return c.F4(resId);
        }
        return null;
    }

    public final un4.g d(String shareChannelID) {
        Intrinsics.checkNotNullParameter(shareChannelID, "shareChannelID");
        zn4.a c = c();
        if (c != null) {
            return c.Z6(shareChannelID);
        }
        return null;
    }

    public final JsonObject e(String posterGuid) {
        String str;
        Intrinsics.checkNotNullParameter(posterGuid, "posterGuid");
        com.dragon.read.kmp.utils.v vVar = com.dragon.read.kmp.utils.v.a;
        zn4.a c = c();
        if (c != null) {
            str = c.v5(posterGuid);
        } else {
            str = null;
        }
        JsonObject g = vVar.g(str);
        if (!(g instanceof JsonObject)) {
            return null;
        }
        return g;
    }

    public final boolean f(String shareChannelId) {
        Intrinsics.checkNotNullParameter(shareChannelId, "shareChannelId");
        zn4.a c = c();
        if (c != null) {
            return c.b9(shareChannelId);
        }
        return false;
    }

    public final Unit h(un4.e kmpShareContent) {
        Intrinsics.checkNotNullParameter(kmpShareContent, "kmpShareContent");
        zn4.a c = c();
        if (c != null) {
            c.la(kmpShareContent);
            return Unit.INSTANCE;
        }
        return null;
    }

    public final Unit i(String shareType) {
        Intrinsics.checkNotNullParameter(shareType, "shareType");
        zn4.a c = c();
        if (c != null) {
            c.ha(shareType);
            return Unit.INSTANCE;
        }
        return null;
    }

    public final void a(JsonObject posterData, String posterGuid, vn4.d qrStyle, Function1<? super vn4.b, Unit> onSuccess, Function1<? super Throwable, Unit> onError) {
        Intrinsics.checkNotNullParameter(posterData, "posterData");
        Intrinsics.checkNotNullParameter(posterGuid, "posterGuid");
        Intrinsics.checkNotNullParameter(qrStyle, "qrStyle");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        zn4.a c = c();
        if (c != null) {
            c.n1(posterData.toString(), posterGuid, qrStyle, new a(onSuccess, onError));
        } else {
            onError.invoke(new IllegalStateException("IShareHostService unavailable"));
        }
    }
}
