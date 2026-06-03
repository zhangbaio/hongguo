package xn4;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class h0 {
    public static final h0 a;

    static {
        Covode.recordClassIndex(608966);
        a = new h0();
    }

    private h0() {
    }

    private final zn4.f f() {
        return (zn4.f) eo0.c.a.a(Reflection.getOrCreateKotlinClass(zn4.f.class));
    }

    public final int d() {
        zn4.f f = f();
        if (f != null) {
            return f.c4();
        }
        return 0;
    }

    public final int e() {
        zn4.f f = f();
        if (f != null) {
            return f.getScreenWidth();
        }
        return 0;
    }

    public final Unit g() {
        zn4.f f = f();
        if (f != null) {
            f.L();
            return Unit.INSTANCE;
        }
        return null;
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

    public static final class b implements un4.b {
        final /* synthetic */ Function1<bh1.a, Unit> a;

        b(Function1<? super bh1.a, Unit> function1) {
            this.a = function1;
        }

        @Override // un4.b
        public void a(bh1.a channel) {
            Intrinsics.checkNotNullParameter(channel, "channel");
            this.a.invoke(channel);
        }
    }

    public static final class c implements un4.b {
        final /* synthetic */ Function1<bh1.a, Unit> a;

        c(Function1<? super bh1.a, Unit> function1) {
            this.a = function1;
        }

        @Override // un4.b
        public void a(bh1.a channel) {
            Intrinsics.checkNotNullParameter(channel, "channel");
            this.a.invoke(channel);
        }
    }

    public final Unit i(String str) {
        zn4.f f = f();
        if (f != null) {
            f.y(str);
            return Unit.INSTANCE;
        }
        return null;
    }

    public final Unit h(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        zn4.f f = f();
        if (f != null) {
            f.N9(text);
            return Unit.INSTANCE;
        }
        return null;
    }

    public final wn4.b c(String title, List<bh1.a> shareChannelList, Function1<? super bh1.a, Unit> onClickListener) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(shareChannelList, "shareChannelList");
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        zn4.f f = f();
        if (f != null) {
            return f.R5(title, shareChannelList, new c(onClickListener));
        }
        return null;
    }

    public final wn4.b a(String title, vn4.a shareParams, List<bh1.a> shareChannelList, Function1<? super bh1.a, Unit> onClickListener) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(shareParams, "shareParams");
        Intrinsics.checkNotNullParameter(shareChannelList, "shareChannelList");
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        zn4.f f = f();
        if (f != null) {
            return f.O1(title, shareParams, shareChannelList, new a(onClickListener));
        }
        return null;
    }

    public final wn4.b b(String title, List<bh1.a> shareChannelList, Function1<? super bh1.a, Unit> onClickListener, boolean z) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(shareChannelList, "shareChannelList");
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        zn4.f f = f();
        if (f != null) {
            return f.G2(title, shareChannelList, new b(onClickListener), z);
        }
        return null;
    }
}
