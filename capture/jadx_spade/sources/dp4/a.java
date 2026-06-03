package dp4;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.ugc.model.k0;
import com.dragon.read.kmp.story.impl.album.c;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface a {
    public static final C0143a a;

    static {
        Covode.recordClassIndex(609212);
        a = C0143a.a;
    }

    void a(Function1<? super com.dragon.read.kmp.story.impl.album.base.b, Unit> function1, Function1<? super Throwable, Unit> function12);

    boolean b();

    com.dragon.read.kmp.story.impl.album.base.b c(ep4.a aVar);

    k0 d(String str);

    c e(String str);

    void f(Function1<? super com.dragon.read.kmp.story.impl.album.base.b, Unit> function1);

    void g(Function1<? super com.dragon.read.kmp.story.impl.album.base.b, Unit> function1, Function1<? super Throwable, Unit> function12);

    void h(Function1<? super com.dragon.read.kmp.story.impl.album.base.b, Unit> function1);

    boolean k();

    /* renamed from: dp4.a$a, reason: collision with other inner class name */
    public static final class C0143a {
        static final /* synthetic */ C0143a a;
        private static final a b;

        private C0143a() {
        }

        public final a a() {
            return b;
        }

        /* renamed from: dp4.a$a$a, reason: collision with other inner class name */
        public static final class C0144a implements a {
            C0144a() {
            }

            @Override // dp4.a
            public boolean b() {
                return b.e(this);
            }

            @Override // dp4.a
            public boolean k() {
                return b.d(this);
            }

            @Override // dp4.a
            public void f(Function1<? super com.dragon.read.kmp.story.impl.album.base.b, Unit> function1) {
                b.i(this, function1);
            }

            @Override // dp4.a
            public void h(Function1<? super com.dragon.read.kmp.story.impl.album.base.b, Unit> function1) {
                b.h(this, function1);
            }

            @Override // dp4.a
            public com.dragon.read.kmp.story.impl.album.base.b c(ep4.a aVar) {
                return b.c(this, aVar);
            }

            @Override // dp4.a
            public k0 d(String str) {
                return b.a(this, str);
            }

            @Override // dp4.a
            public c e(String str) {
                return b.b(this, str);
            }

            @Override // dp4.a
            public void a(Function1<? super com.dragon.read.kmp.story.impl.album.base.b, Unit> function1, Function1<? super Throwable, Unit> function12) {
                b.f(this, function1, function12);
            }

            @Override // dp4.a
            public void g(Function1<? super com.dragon.read.kmp.story.impl.album.base.b, Unit> function1, Function1<? super Throwable, Unit> function12) {
                b.g(this, function1, function12);
            }
        }

        static {
            Covode.recordClassIndex(609213);
            a = new C0143a();
            b = new C0144a();
        }
    }

    public static final class b {
        static {
            Covode.recordClassIndex(609214);
        }

        public static k0 a(a aVar, String str) {
            return null;
        }

        public static c b(a aVar, String str) {
            return null;
        }

        public static boolean d(a aVar) {
            return false;
        }

        public static boolean e(a aVar) {
            return false;
        }

        public static void f(a aVar, Function1<? super com.dragon.read.kmp.story.impl.album.base.b, Unit> onSuccess, Function1<? super Throwable, Unit> onError) {
            Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
            Intrinsics.checkNotNullParameter(onError, "onError");
        }

        public static void g(a aVar, Function1<? super com.dragon.read.kmp.story.impl.album.base.b, Unit> onSuccess, Function1<? super Throwable, Unit> onError) {
            Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
            Intrinsics.checkNotNullParameter(onError, "onError");
        }

        public static void h(a aVar, Function1<? super com.dragon.read.kmp.story.impl.album.base.b, Unit> observer) {
            Intrinsics.checkNotNullParameter(observer, "observer");
        }

        public static void i(a aVar, Function1<? super com.dragon.read.kmp.story.impl.album.base.b, Unit> observer) {
            Intrinsics.checkNotNullParameter(observer, "observer");
        }

        public static com.dragon.read.kmp.story.impl.album.base.b c(a aVar, ep4.a param) {
            Intrinsics.checkNotNullParameter(param, "param");
            return new com.dragon.read.kmp.story.impl.album.base.b(new ArrayList(), -1, false, false, false, 24, null);
        }
    }
}
