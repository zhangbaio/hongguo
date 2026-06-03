package xn4;

import androidx.compose.ui.graphics.e1;
import com.bytedance.covode.number.Covode;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f0 {
    public static final f0 a;

    static {
        Covode.recordClassIndex(608964);
        a = new f0();
    }

    private f0() {
    }

    private final zn4.d c() {
        return (zn4.d) eo0.c.a.a(Reflection.getOrCreateKotlinClass(zn4.d.class));
    }

    public final e1 d() {
        return un4.i.a(e());
    }

    public final un4.h e() {
        zn4.d c = c();
        if (c != null) {
            return c.a8();
        }
        return null;
    }

    public final Map<String, String> b() {
        Map<String, String> emptyMap;
        Map<String, String> n9;
        zn4.d c = c();
        if (c == null || (n9 = c.n9()) == null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            return emptyMap;
        }
        return n9;
    }

    public static final class a implements un4.b {
        final /* synthetic */ Function1<bh1.a, Unit> a;

        a(Function1<? super bh1.a, Unit> function1) {
            this.a = function1;
        }

        @Override // un4.b
        public void a(bh1.a channel) {
            Intrinsics.checkNotNullParameter(channel, "channel");
            this.a.invoke(channel);
        }
    }

    public static final class b implements un4.c {
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
        b(Function1<? super un4.h, Unit> function1, Function1<? super Throwable, Unit> function12) {
            this.a = function1;
            this.b = function12;
        }
    }

    public final un4.f f(String colorHex) {
        un4.f o6;
        Intrinsics.checkNotNullParameter(colorHex, "colorHex");
        zn4.d c = c();
        if (c == null || (o6 = c.o6(colorHex)) == null) {
            return new un4.f(0, 0);
        }
        return o6;
    }

    public final wn4.a a(com.dragon.read.kmp.share.business.series.o videoPlayerPost, List<bh1.a> shareChannelList, Function1<? super bh1.a, Unit> onClickListener) {
        Intrinsics.checkNotNullParameter(videoPlayerPost, "videoPlayerPost");
        Intrinsics.checkNotNullParameter(shareChannelList, "shareChannelList");
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        zn4.d c = c();
        if (c != null) {
            return c.j1(videoPlayerPost, shareChannelList, new a(onClickListener));
        }
        return null;
    }

    public final void g(String coverUrl, Function1<? super un4.h, Unit> onSuccess, Function1<? super Throwable, Unit> onError) {
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        zn4.d c = c();
        if (c != null) {
            c.T2(coverUrl, new b(onSuccess, onError));
        } else {
            onError.invoke(new IllegalStateException("IShareSeriesService unavailable"));
        }
    }
}
