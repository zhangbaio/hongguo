package kotlinx.coroutines.channels;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@JvmInline
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class ChannelResult<T> {
    public static final b Companion;
    private static final c failed;
    private final Object holder;

    public static class c {
        static {
            Covode.recordClassIndex(659081);
        }

        public String toString() {
            return "Failed";
        }
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ChannelResult m1085boximpl(Object obj) {
        return new ChannelResult(obj);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static <T> Object m1086constructorimpl(Object obj) {
        return obj;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1087equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof ChannelResult) && Intrinsics.areEqual(obj, ((ChannelResult) obj2).m1097unboximpl());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1088equalsimpl0(Object obj, Object obj2) {
        return Intrinsics.areEqual(obj, obj2);
    }

    public static /* synthetic */ void getHolder$annotations() {
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1092hashCodeimpl(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public boolean equals(Object obj) {
        return m1087equalsimpl(this.holder, obj);
    }

    public int hashCode() {
        return m1092hashCodeimpl(this.holder);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Object m1097unboximpl() {
        return this.holder;
    }

    public String toString() {
        return m1096toStringimpl(this.holder);
    }

    public static final class a extends c {
        public final Throwable a;

        static {
            Covode.recordClassIndex(659079);
        }

        public int hashCode() {
            Throwable th = this.a;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        @Override // kotlinx.coroutines.channels.ChannelResult.c
        public String toString() {
            return "Closed(" + this.a + ')';
        }

        public a(Throwable th) {
            this.a = th;
        }

        public boolean equals(Object obj) {
            if ((obj instanceof a) && Intrinsics.areEqual(this.a, ((a) obj).a)) {
                return true;
            }
            return false;
        }
    }

    public static final class b {
        static {
            Covode.recordClassIndex(659080);
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <E> Object b() {
            return ChannelResult.m1086constructorimpl(ChannelResult.failed);
        }

        public final <E> Object c(E e) {
            return ChannelResult.m1086constructorimpl(e);
        }

        public final <E> Object a(Throwable th) {
            return ChannelResult.m1086constructorimpl(new a(th));
        }
    }

    static {
        Covode.recordClassIndex(659078);
        Companion = new b(null);
        failed = new c();
    }

    /* renamed from: isClosed-impl, reason: not valid java name */
    public static final boolean m1093isClosedimpl(Object obj) {
        return obj instanceof a;
    }

    /* renamed from: isFailure-impl, reason: not valid java name */
    public static final boolean m1094isFailureimpl(Object obj) {
        return obj instanceof c;
    }

    private /* synthetic */ ChannelResult(Object obj) {
        this.holder = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOrNull-impl, reason: not valid java name */
    public static final T m1090getOrNullimpl(Object obj) {
        if (obj instanceof c) {
            return null;
        }
        return obj;
    }

    /* renamed from: isSuccess-impl, reason: not valid java name */
    public static final boolean m1095isSuccessimpl(Object obj) {
        return !(obj instanceof c);
    }

    /* renamed from: exceptionOrNull-impl, reason: not valid java name */
    public static final Throwable m1089exceptionOrNullimpl(Object obj) {
        a aVar;
        if (obj instanceof a) {
            aVar = (a) obj;
        } else {
            aVar = null;
        }
        if (aVar == null) {
            return null;
        }
        return aVar.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOrThrow-impl, reason: not valid java name */
    public static final T m1091getOrThrowimpl(Object obj) {
        Throwable th;
        if (!(obj instanceof c)) {
            return obj;
        }
        if ((obj instanceof a) && (th = ((a) obj).a) != null) {
            throw th;
        }
        throw new IllegalStateException(("Trying to call 'getOrThrow' on a failed channel result: " + obj).toString());
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1096toStringimpl(Object obj) {
        if (obj instanceof a) {
            return ((a) obj).toString();
        }
        return "Value(" + obj + ')';
    }
}
