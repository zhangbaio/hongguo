package kotlinx.datetime.format;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.datetime.DateTimeFormatException;
import kotlinx.datetime.Instant;
import kotlinx.datetime.format.DateTimeComponents;
import kotlinx.datetime.format.w;
import kotlinx.datetime.format.y;
import zm6.o;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class DateTimeComponents {
    public static final a k;
    static final /* synthetic */ KProperty<Object>[] l;
    public final v a;
    private final i1 b;
    private final i1 c;
    private final i1 d;
    private final i1 e;
    private final i1 f;
    private final i1 g;
    private final i1 h;
    private final i1 i;
    private final i1 j;

    /* JADX WARN: Multi-variable type inference failed */
    public DateTimeComponents() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static final class b {
        public static final b a;
        private static final x<DateTimeComponents> b;
        private static final x<DateTimeComponents> c;

        private b() {
        }

        public final x<DateTimeComponents> C() {
            return b;
        }

        static {
            Covode.recordClassIndex(659451);
            a = new b();
            a aVar = DateTimeComponents.k;
            b = aVar.a(new Function1() { // from class: kotlinx.datetime.format.h
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit o;
                    o = DateTimeComponents.b.o((y.c) obj);
                    return o;
                }
            });
            c = aVar.a(new Function1() { // from class: kotlinx.datetime.format.m
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit u;
                    u = DateTimeComponents.b.u((y.c) obj);
                    return u;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit y(y.c alternativeParsing) {
            Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit B(y.c alternativeParsing) {
            Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
            alternativeParsing.q("UT");
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit p(y.c alternativeParsing) {
            Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
            z.b(alternativeParsing, 't');
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit q(y.c alternativeParsing) {
            Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
            z.b(alternativeParsing, 'T');
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit s(y.c alternativeParsing) {
            Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
            y.e.a.a(alternativeParsing, null, 1, null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit v(y.c alternativeParsing) {
            Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
            alternativeParsing.q("Z");
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit A(y.c optional) {
            Intrinsics.checkNotNullParameter(optional, "$this$optional");
            z.b(optional, ':');
            y.d.a.c(optional, null, 1, null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit r(y.c optional) {
            Intrinsics.checkNotNullParameter(optional, "$this$optional");
            z.b(optional, '.');
            optional.d(1, 9);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit t(y.c alternativeParsing) {
            Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
            alternativeParsing.j(o.b.a.b());
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit w(y.c alternativeParsing) {
            Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
            z.c(alternativeParsing, "GMT", new Function1() { // from class: kotlinx.datetime.format.l
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit x;
                    x = DateTimeComponents.b.x((y.c) obj);
                    return x;
                }
            });
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit x(y.c optional) {
            Intrinsics.checkNotNullParameter(optional, "$this$optional");
            optional.j(o.b.a.a());
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit z(y.c alternativeParsing) {
            Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
            alternativeParsing.y(DayOfWeekNames.b.a());
            alternativeParsing.q(", ");
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit o(y.c Format) {
            Intrinsics.checkNotNullParameter(Format, "$this$Format");
            Format.u(n0.j());
            z.a(Format, new Function1[]{new Function1() { // from class: kotlinx.datetime.format.t
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit p;
                    p = DateTimeComponents.b.p((y.c) obj);
                    return p;
                }
            }}, new Function1() { // from class: kotlinx.datetime.format.u
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit q;
                    q = DateTimeComponents.b.q((y.c) obj);
                    return q;
                }
            });
            y.d.a.a(Format, null, 1, null);
            z.b(Format, ':');
            y.d.a.b(Format, null, 1, null);
            z.b(Format, ':');
            y.d.a.c(Format, null, 1, null);
            z.d(Format, null, new Function1() { // from class: kotlinx.datetime.format.i
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit r;
                    r = DateTimeComponents.b.r((y.c) obj);
                    return r;
                }
            }, 1, null);
            z.a(Format, new Function1[]{new Function1() { // from class: kotlinx.datetime.format.j
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit s;
                    s = DateTimeComponents.b.s((y.c) obj);
                    return s;
                }
            }}, new Function1() { // from class: kotlinx.datetime.format.k
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit t;
                    t = DateTimeComponents.b.t((y.c) obj);
                    return t;
                }
            });
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit u(y.c Format) {
            Intrinsics.checkNotNullParameter(Format, "$this$Format");
            z.a(Format, new Function1[]{new Function1() { // from class: kotlinx.datetime.format.n
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit y;
                    y = DateTimeComponents.b.y((y.c) obj);
                    return y;
                }
            }}, new Function1() { // from class: kotlinx.datetime.format.o
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit z;
                    z = DateTimeComponents.b.z((y.c) obj);
                    return z;
                }
            });
            Format.m(Padding.NONE);
            z.b(Format, ' ');
            Format.e(MonthNames.b.a());
            z.b(Format, ' ');
            y.a.C0226a.c(Format, null, 1, null);
            z.b(Format, ' ');
            y.d.a.a(Format, null, 1, null);
            z.b(Format, ':');
            y.d.a.b(Format, null, 1, null);
            z.d(Format, null, new Function1() { // from class: kotlinx.datetime.format.p
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit A;
                    A = DateTimeComponents.b.A((y.c) obj);
                    return A;
                }
            }, 1, null);
            Format.q(" ");
            z.a(Format, new Function1[]{new Function1() { // from class: kotlinx.datetime.format.q
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit B;
                    B = DateTimeComponents.b.B((y.c) obj);
                    return B;
                }
            }, new Function1() { // from class: kotlinx.datetime.format.r
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit v;
                    v = DateTimeComponents.b.v((y.c) obj);
                    return v;
                }
            }}, new Function1() { // from class: kotlinx.datetime.format.s
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit w;
                    w = DateTimeComponents.b.w((y.c) obj);
                    return w;
                }
            });
            return Unit.INSTANCE;
        }
    }

    public final Integer a() {
        return this.a.b.o();
    }

    public final Integer b() {
        return this.a.a.e();
    }

    public final zm6.j d() {
        return this.a.b.d();
    }

    public final zm6.o e() {
        return this.a.c.e();
    }

    static {
        Covode.recordClassIndex(659449);
        l = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(DateTimeComponents.class, "monthNumber", "getMonthNumber()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DateTimeComponents.class, "dayOfMonth", "getDayOfMonth()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DateTimeComponents.class, "hour", "getHour()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DateTimeComponents.class, "hourOfAmPm", "getHourOfAmPm()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DateTimeComponents.class, "minute", "getMinute()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DateTimeComponents.class, "second", "getSecond()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DateTimeComponents.class, "offsetHours", "getOffsetHours()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DateTimeComponents.class, "offsetMinutesOfHour", "getOffsetMinutesOfHour()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DateTimeComponents.class, "offsetSecondsOfMinute", "getOffsetSecondsOfMinute()Ljava/lang/Integer;", 0))};
        k = new a(null);
    }

    public final Instant c() {
        int i;
        zm6.o e = e();
        zm6.j d = d();
        e0 copy = this.a.a.copy();
        copy.m(Integer.valueOf(((Number) n0.l(copy.e(), "year")).intValue() % 10000));
        try {
            Intrinsics.checkNotNull(b());
            long a2 = an6.c.a(an6.c.c(r4.intValue() / 10000, 315569520000L), ((copy.d().f() * 86400) + d.f()) - e.a());
            Instant.a aVar = Instant.Companion;
            if (a2 >= aVar.e().getEpochSeconds() && a2 <= aVar.d().getEpochSeconds()) {
                Integer a3 = a();
                if (a3 != null) {
                    i = a3.intValue();
                } else {
                    i = 0;
                }
                return aVar.b(a2, i);
            }
            throw new DateTimeFormatException("The parsed date is outside the range representable by Instant");
        } catch (ArithmeticException e2) {
            throw new DateTimeFormatException("The parsed date is outside the range representable by Instant", e2);
        }
    }

    public static final class a {
        static {
            Covode.recordClassIndex(659450);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final x<DateTimeComponents> a(Function1<? super y.c, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            w.a aVar = new w.a(new kotlinx.datetime.internal.format.d());
            block.invoke(aVar);
            return new w(aVar.B());
        }
    }

    public DateTimeComponents(v contents) {
        Intrinsics.checkNotNullParameter(contents, "contents");
        this.a = contents;
        e0 e0Var = contents.a;
        final e0 e0Var2 = contents.a;
        this.b = new i1(new MutablePropertyReference0Impl(e0Var2) { // from class: kotlinx.datetime.format.DateTimeComponents$monthNumber$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((e0) this.receiver).w();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object obj) {
                ((e0) this.receiver).j((Integer) obj);
            }
        });
        final e0 e0Var3 = contents.a;
        this.c = new i1(new MutablePropertyReference0Impl(e0Var3) { // from class: kotlinx.datetime.format.DateTimeComponents$dayOfMonth$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((e0) this.receiver).n();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object obj) {
                ((e0) this.receiver).v((Integer) obj);
            }
        });
        final g0 g0Var = contents.b;
        this.d = new i1(new MutablePropertyReference0Impl(g0Var) { // from class: kotlinx.datetime.format.DateTimeComponents$hour$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((g0) this.receiver).x();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object obj) {
                ((g0) this.receiver).C((Integer) obj);
            }
        });
        final g0 g0Var2 = contents.b;
        this.e = new i1(new MutablePropertyReference0Impl(g0Var2) { // from class: kotlinx.datetime.format.DateTimeComponents$hourOfAmPm$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((g0) this.receiver).p();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object obj) {
                ((g0) this.receiver).t((Integer) obj);
            }
        });
        g0 g0Var3 = contents.b;
        final g0 g0Var4 = contents.b;
        this.f = new i1(new MutablePropertyReference0Impl(g0Var4) { // from class: kotlinx.datetime.format.DateTimeComponents$minute$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((g0) this.receiver).k();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object obj) {
                ((g0) this.receiver).B((Integer) obj);
            }
        });
        final g0 g0Var5 = contents.b;
        this.g = new i1(new MutablePropertyReference0Impl(g0Var5) { // from class: kotlinx.datetime.format.DateTimeComponents$second$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((g0) this.receiver).i();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object obj) {
                ((g0) this.receiver).b((Integer) obj);
            }
        });
        h0 h0Var = contents.c;
        final h0 h0Var2 = contents.c;
        this.h = new i1(new MutablePropertyReference0Impl(h0Var2) { // from class: kotlinx.datetime.format.DateTimeComponents$offsetHours$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((h0) this.receiver).y();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object obj) {
                ((h0) this.receiver).c((Integer) obj);
            }
        });
        final h0 h0Var3 = contents.c;
        this.i = new i1(new MutablePropertyReference0Impl(h0Var3) { // from class: kotlinx.datetime.format.DateTimeComponents$offsetMinutesOfHour$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((h0) this.receiver).z();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object obj) {
                ((h0) this.receiver).r((Integer) obj);
            }
        });
        final h0 h0Var4 = contents.c;
        this.j = new i1(new MutablePropertyReference0Impl(h0Var4) { // from class: kotlinx.datetime.format.DateTimeComponents$offsetSecondsOfMinute$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((h0) this.receiver).d();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object obj) {
                ((h0) this.receiver).A((Integer) obj);
            }
        });
    }

    public /* synthetic */ DateTimeComponents(v vVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new v(null, null, null, null, 15, null) : vVar);
    }
}
