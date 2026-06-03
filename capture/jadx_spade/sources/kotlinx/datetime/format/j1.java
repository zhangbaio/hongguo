package kotlinx.datetime.format;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.datetime.format.y;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface j1 {
    public static final a a;

    static {
        Covode.recordClassIndex(659517);
        a = a.a;
    }

    public static abstract class b implements j1 {

        public static abstract class a extends b {
            static {
                Covode.recordClassIndex(659520);
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public abstract void c(y.a aVar);

            /* renamed from: kotlinx.datetime.format.j1$b$a$a, reason: collision with other inner class name */
            public static final class C0217a extends a {
                private final int b;
                private final char c;

                static {
                    Covode.recordClassIndex(659521);
                }

                @Override // kotlinx.datetime.format.j1.b
                public int a() {
                    return this.b;
                }

                @Override // kotlinx.datetime.format.j1.b
                public char b() {
                    return this.c;
                }

                public C0217a(int i) {
                    super(null);
                    this.b = i;
                    this.c = 'U';
                }

                @Override // kotlinx.datetime.format.j1.b.a
                /* renamed from: d, reason: merged with bridge method [inline-methods] */
                public Void c(y.a builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    m1.r("cyclic-year", null, 2, null);
                    throw new KotlinNothingValueException();
                }
            }

            /* renamed from: kotlinx.datetime.format.j1$b$a$b, reason: collision with other inner class name */
            public static final class C0218b extends a {
                private final int b;
                private final char c;

                static {
                    Covode.recordClassIndex(659522);
                }

                @Override // kotlinx.datetime.format.j1.b
                public int a() {
                    return this.b;
                }

                @Override // kotlinx.datetime.format.j1.b
                public char b() {
                    return this.c;
                }

                public C0218b(int i) {
                    super(null);
                    this.b = i;
                    this.c = 'd';
                }

                @Override // kotlinx.datetime.format.j1.b.a
                public void c(y.a builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    int a = a();
                    if (a != 1) {
                        if (a != 2) {
                            m1.p(this);
                            throw new KotlinNothingValueException();
                        }
                        builder.m(Padding.ZERO);
                        return;
                    }
                    builder.m(Padding.NONE);
                }
            }

            public static final class c extends a {
                private final int b;
                private final char c;

                static {
                    Covode.recordClassIndex(659523);
                }

                @Override // kotlinx.datetime.format.j1.b
                public int a() {
                    return this.b;
                }

                @Override // kotlinx.datetime.format.j1.b
                public char b() {
                    return this.c;
                }

                public c(int i) {
                    super(null);
                    this.b = i;
                    this.c = 'E';
                }

                @Override // kotlinx.datetime.format.j1.b.a
                /* renamed from: d, reason: merged with bridge method [inline-methods] */
                public Void c(y.a builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    m1.n(this, null, 1, null);
                    throw new KotlinNothingValueException();
                }
            }

            public static final class d extends a {
                private final int b;
                private final char c;

                static {
                    Covode.recordClassIndex(659524);
                }

                @Override // kotlinx.datetime.format.j1.b
                public int a() {
                    return this.b;
                }

                @Override // kotlinx.datetime.format.j1.b
                public char b() {
                    return this.c;
                }

                public d(int i) {
                    super(null);
                    this.b = i;
                    this.c = 'F';
                }

                @Override // kotlinx.datetime.format.j1.b.a
                /* renamed from: d, reason: merged with bridge method [inline-methods] */
                public Void c(y.a builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    m1.r("day-of-week-in-month", null, 2, null);
                    throw new KotlinNothingValueException();
                }
            }

            public static final class e extends a {
                private final int b;
                private final char c;

                static {
                    Covode.recordClassIndex(659525);
                }

                @Override // kotlinx.datetime.format.j1.b
                public int a() {
                    return this.b;
                }

                @Override // kotlinx.datetime.format.j1.b
                public char b() {
                    return this.c;
                }

                public e(int i) {
                    super(null);
                    this.b = i;
                    this.c = 'D';
                }

                @Override // kotlinx.datetime.format.j1.b.a
                /* renamed from: d, reason: merged with bridge method [inline-methods] */
                public Void c(y.a builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    m1.r("day-of-year", null, 2, null);
                    throw new KotlinNothingValueException();
                }
            }

            public static final class f extends a {
                private final int b;
                private final char c;

                static {
                    Covode.recordClassIndex(659526);
                }

                @Override // kotlinx.datetime.format.j1.b
                public int a() {
                    return this.b;
                }

                @Override // kotlinx.datetime.format.j1.b
                public char b() {
                    return this.c;
                }

                public f(int i) {
                    super(null);
                    this.b = i;
                    this.c = 'G';
                }

                @Override // kotlinx.datetime.format.j1.b.a
                /* renamed from: d, reason: merged with bridge method [inline-methods] */
                public Void c(y.a builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    m1.n(this, null, 1, null);
                    throw new KotlinNothingValueException();
                }
            }

            public static final class g extends a {
                private final int b;
                private final char c;

                static {
                    Covode.recordClassIndex(659527);
                }

                @Override // kotlinx.datetime.format.j1.b
                public int a() {
                    return this.b;
                }

                @Override // kotlinx.datetime.format.j1.b
                public char b() {
                    return this.c;
                }

                public g(int i) {
                    super(null);
                    this.b = i;
                    this.c = 'e';
                }

                @Override // kotlinx.datetime.format.j1.b.a
                /* renamed from: d, reason: merged with bridge method [inline-methods] */
                public Void c(y.a builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    m1.n(this, null, 1, null);
                    throw new KotlinNothingValueException();
                }
            }

            public static final class h extends a {
                private final int b;
                private final char c;

                static {
                    Covode.recordClassIndex(659528);
                }

                @Override // kotlinx.datetime.format.j1.b
                public int a() {
                    return this.b;
                }

                @Override // kotlinx.datetime.format.j1.b
                public char b() {
                    return this.c;
                }

                public h(int i) {
                    super(null);
                    this.b = i;
                    this.c = 'g';
                }

                @Override // kotlinx.datetime.format.j1.b.a
                /* renamed from: d, reason: merged with bridge method [inline-methods] */
                public Void c(y.a builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    m1.r("modified-julian-day", null, 2, null);
                    throw new KotlinNothingValueException();
                }
            }

            public static final class i extends a {
                private final int b;
                private final char c;

                static {
                    Covode.recordClassIndex(659529);
                }

                @Override // kotlinx.datetime.format.j1.b
                public int a() {
                    return this.b;
                }

                @Override // kotlinx.datetime.format.j1.b
                public char b() {
                    return this.c;
                }

                public i(int i) {
                    super(null);
                    this.b = i;
                    this.c = 'M';
                }

                @Override // kotlinx.datetime.format.j1.b.a
                public void c(y.a builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    int a = a();
                    if (a != 1) {
                        if (a != 2) {
                            if (a != 3 && a != 4 && a != 5) {
                                m1.p(this);
                                throw new KotlinNothingValueException();
                            }
                            m1.n(this, null, 1, null);
                            throw new KotlinNothingValueException();
                        }
                        builder.a(Padding.ZERO);
                        return;
                    }
                    builder.a(Padding.NONE);
                }
            }

            public static final class j extends a {
                private final int b;
                private final char c;

                static {
                    Covode.recordClassIndex(659530);
                }

                @Override // kotlinx.datetime.format.j1.b
                public int a() {
                    return this.b;
                }

                @Override // kotlinx.datetime.format.j1.b
                public char b() {
                    return this.c;
                }

                public j(int i) {
                    super(null);
                    this.b = i;
                    this.c = 'Q';
                }

                @Override // kotlinx.datetime.format.j1.b.a
                public void c(y.a builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    int a = a();
                    if (a != 1 && a != 2) {
                        if (a != 3 && a != 4 && a != 5) {
                            m1.p(this);
                            throw new KotlinNothingValueException();
                        }
                        m1.n(this, null, 1, null);
                        throw new KotlinNothingValueException();
                    }
                    m1.r("quarter-of-year", null, 2, null);
                    throw new KotlinNothingValueException();
                }
            }

            public static final class k extends a {
                private final int b;
                private final char c;

                static {
                    Covode.recordClassIndex(659531);
                }

                @Override // kotlinx.datetime.format.j1.b
                public int a() {
                    return this.b;
                }

                @Override // kotlinx.datetime.format.j1.b
                public char b() {
                    return this.c;
                }

                public k(int i) {
                    super(null);
                    this.b = i;
                    this.c = 'r';
                }

                @Override // kotlinx.datetime.format.j1.b.a
                /* renamed from: d, reason: merged with bridge method [inline-methods] */
                public Void c(y.a builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    m1.r("related-gregorian-year", null, 2, null);
                    throw new KotlinNothingValueException();
                }
            }

            public static final class l extends a {
                private final int b;
                private final char c;

                static {
                    Covode.recordClassIndex(659532);
                }

                @Override // kotlinx.datetime.format.j1.b
                public int a() {
                    return this.b;
                }

                @Override // kotlinx.datetime.format.j1.b
                public char b() {
                    return this.c;
                }

                public l(int i) {
                    super(null);
                    this.b = i;
                    this.c = 'c';
                }

                @Override // kotlinx.datetime.format.j1.b.a
                /* renamed from: d, reason: merged with bridge method [inline-methods] */
                public Void c(y.a builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    m1.n(this, null, 1, null);
                    throw new KotlinNothingValueException();
                }
            }

            public static final class m extends a {
                private final int b;
                private final char c;

                static {
                    Covode.recordClassIndex(659533);
                }

                @Override // kotlinx.datetime.format.j1.b
                public int a() {
                    return this.b;
                }

                @Override // kotlinx.datetime.format.j1.b
                public char b() {
                    return this.c;
                }

                public m(int i) {
                    super(null);
                    this.b = i;
                    this.c = 'L';
                }

                @Override // kotlinx.datetime.format.j1.b.a
                public void c(y.a builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    int a = a();
                    if (a != 1) {
                        if (a != 2) {
                            if (a != 3 && a != 4 && a != 5) {
                                m1.p(this);
                                throw new KotlinNothingValueException();
                            }
                            m1.n(this, null, 1, null);
                            throw new KotlinNothingValueException();
                        }
                        builder.a(Padding.ZERO);
                        return;
                    }
                    builder.a(Padding.NONE);
                }
            }

            public static final class n extends a {
                private final int b;
                private final char c;

                static {
                    Covode.recordClassIndex(659534);
                }

                @Override // kotlinx.datetime.format.j1.b
                public int a() {
                    return this.b;
                }

                @Override // kotlinx.datetime.format.j1.b
                public char b() {
                    return this.c;
                }

                public n(int i) {
                    super(null);
                    this.b = i;
                    this.c = 'q';
                }

                @Override // kotlinx.datetime.format.j1.b.a
                public void c(y.a builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    int a = a();
                    if (a != 1 && a != 2) {
                        if (a != 3 && a != 4 && a != 5) {
                            m1.p(this);
                            throw new KotlinNothingValueException();
                        }
                        m1.n(this, null, 1, null);
                        throw new KotlinNothingValueException();
                    }
                    m1.r("standalone-quarter-of-year", null, 2, null);
                    throw new KotlinNothingValueException();
                }
            }

            public static final class o extends a {
                private final int b;
                private final char c;

                static {
                    Covode.recordClassIndex(659535);
                }

                @Override // kotlinx.datetime.format.j1.b
                public int a() {
                    return this.b;
                }

                @Override // kotlinx.datetime.format.j1.b
                public char b() {
                    return this.c;
                }

                public o(int i) {
                    super(null);
                    this.b = i;
                    this.c = 'Y';
                }

                @Override // kotlinx.datetime.format.j1.b.a
                /* renamed from: d, reason: merged with bridge method [inline-methods] */
                public Void c(y.a builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    m1.r("week-based-year", null, 2, null);
                    throw new KotlinNothingValueException();
                }
            }

            public static final class p extends a {
                private final int b;
                private final char c;

                static {
                    Covode.recordClassIndex(659536);
                }

                @Override // kotlinx.datetime.format.j1.b
                public int a() {
                    return this.b;
                }

                @Override // kotlinx.datetime.format.j1.b
                public char b() {
                    return this.c;
                }

                public p(int i) {
                    super(null);
                    this.b = i;
                    this.c = 'W';
                }

                @Override // kotlinx.datetime.format.j1.b.a
                /* renamed from: d, reason: merged with bridge method [inline-methods] */
                public Void c(y.a builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    m1.r("week-of-month", null, 2, null);
                    throw new KotlinNothingValueException();
                }
            }

            public static final class q extends a {
                private final int b;
                private final char c;

                static {
                    Covode.recordClassIndex(659537);
                }

                @Override // kotlinx.datetime.format.j1.b
                public int a() {
                    return this.b;
                }

                @Override // kotlinx.datetime.format.j1.b
                public char b() {
                    return this.c;
                }

                public q(int i) {
                    super(null);
                    this.b = i;
                    this.c = 'w';
                }

                @Override // kotlinx.datetime.format.j1.b.a
                /* renamed from: d, reason: merged with bridge method [inline-methods] */
                public Void c(y.a builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    m1.r("week-of-week-based-year", null, 2, null);
                    throw new KotlinNothingValueException();
                }
            }

            public static final class r extends a {
                private final int b;
                private final char c;

                static {
                    Covode.recordClassIndex(659538);
                }

                @Override // kotlinx.datetime.format.j1.b
                public int a() {
                    return this.b;
                }

                @Override // kotlinx.datetime.format.j1.b
                public char b() {
                    return this.c;
                }

                public r(int i) {
                    super(null);
                    this.b = i;
                    this.c = 'u';
                }

                @Override // kotlinx.datetime.format.j1.b.a
                public void c(y.a builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    int a = a();
                    if (a != 1) {
                        if (a != 2) {
                            if (a != 3) {
                                if (a == 4) {
                                    builder.l(Padding.ZERO);
                                    return;
                                } else {
                                    m1.s(this, a());
                                    throw new KotlinNothingValueException();
                                }
                            }
                            m1.s(this, a());
                            throw new KotlinNothingValueException();
                        }
                        builder.g(2000);
                        return;
                    }
                    builder.l(Padding.NONE);
                }
            }

            public static final class s extends a {
                private final int b;
                private final char c;

                static {
                    Covode.recordClassIndex(659539);
                }

                @Override // kotlinx.datetime.format.j1.b
                public int a() {
                    return this.b;
                }

                @Override // kotlinx.datetime.format.j1.b
                public char b() {
                    return this.c;
                }

                public s(int i) {
                    super(null);
                    this.b = i;
                    this.c = 'y';
                }

                @Override // kotlinx.datetime.format.j1.b.a
                public void c(y.a builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    int a = a();
                    if (a != 1) {
                        if (a != 2) {
                            if (a != 3) {
                                if (a == 4) {
                                    n0.m(builder, Padding.ZERO);
                                    return;
                                } else {
                                    m1.s(this, a());
                                    throw new KotlinNothingValueException();
                                }
                            }
                            m1.s(this, a());
                            throw new KotlinNothingValueException();
                        }
                        n0.n(builder, 2000);
                        return;
                    }
                    n0.m(builder, Padding.NONE);
                }
            }

            private a() {
                super(null);
            }
        }

        /* renamed from: kotlinx.datetime.format.j1$b$b, reason: collision with other inner class name */
        public static abstract class AbstractC0219b extends b {
            static {
                Covode.recordClassIndex(659540);
            }

            public /* synthetic */ AbstractC0219b(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public abstract void c(y.e eVar);

            public abstract WhenToOutput e();

            public abstract WhenToOutput f();

            /* renamed from: kotlinx.datetime.format.j1$b$b$a */
            public static final class a extends AbstractC0219b {
                private final int b;
                private final char c;

                static {
                    Covode.recordClassIndex(659541);
                }

                @Override // kotlinx.datetime.format.j1.b
                public int a() {
                    return this.b;
                }

                @Override // kotlinx.datetime.format.j1.b
                public char b() {
                    return this.c;
                }

                @Override // kotlinx.datetime.format.j1.b.AbstractC0219b
                public WhenToOutput e() {
                    m1.n(this, null, 1, null);
                    throw new KotlinNothingValueException();
                }

                @Override // kotlinx.datetime.format.j1.b.AbstractC0219b
                public WhenToOutput f() {
                    m1.n(this, null, 1, null);
                    throw new KotlinNothingValueException();
                }

                public a(int i) {
                    super(null);
                    this.b = i;
                    this.c = 'O';
                }

                @Override // kotlinx.datetime.format.j1.b.AbstractC0219b
                /* renamed from: g, reason: merged with bridge method [inline-methods] */
                public Void c(y.e builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    m1.n(this, null, 1, null);
                    throw new KotlinNothingValueException();
                }
            }

            /* renamed from: kotlinx.datetime.format.j1$b$b$b, reason: collision with other inner class name */
            public static final class C0220b extends AbstractC0219b {
                private final int b;
                private final char c;

                static {
                    Covode.recordClassIndex(659542);
                }

                @Override // kotlinx.datetime.format.j1.b
                public int a() {
                    return this.b;
                }

                @Override // kotlinx.datetime.format.j1.b
                public char b() {
                    return this.c;
                }

                @Override // kotlinx.datetime.format.j1.b.AbstractC0219b
                public WhenToOutput e() {
                    if (a() == 1) {
                        return WhenToOutput.IF_NONZERO;
                    }
                    return WhenToOutput.ALWAYS;
                }

                @Override // kotlinx.datetime.format.j1.b.AbstractC0219b
                public WhenToOutput f() {
                    if (a() <= 3) {
                        return WhenToOutput.NEVER;
                    }
                    return WhenToOutput.IF_NONZERO;
                }

                public C0220b(int i) {
                    super(null);
                    this.b = i;
                    this.c = 'X';
                }

                @Override // kotlinx.datetime.format.j1.b.AbstractC0219b
                public void c(y.e builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    int a = a();
                    if (a != 1) {
                        if (a != 2) {
                            if (a != 3) {
                                if (a != 4) {
                                    if (a != 5) {
                                        m1.p(this);
                                        throw new KotlinNothingValueException();
                                    }
                                    d(builder, true, true);
                                    return;
                                }
                                d(builder, true, false);
                                return;
                            }
                            d(builder, true, true);
                            return;
                        }
                        d(builder, true, false);
                        return;
                    }
                    d(builder, true, false);
                }
            }

            /* renamed from: kotlinx.datetime.format.j1$b$b$c */
            public static final class c extends AbstractC0219b {
                private final int b;
                private final char c;

                static {
                    Covode.recordClassIndex(659543);
                }

                @Override // kotlinx.datetime.format.j1.b
                public int a() {
                    return this.b;
                }

                @Override // kotlinx.datetime.format.j1.b
                public char b() {
                    return this.c;
                }

                @Override // kotlinx.datetime.format.j1.b.AbstractC0219b
                public WhenToOutput e() {
                    if (a() == 1) {
                        return WhenToOutput.IF_NONZERO;
                    }
                    return WhenToOutput.ALWAYS;
                }

                @Override // kotlinx.datetime.format.j1.b.AbstractC0219b
                public WhenToOutput f() {
                    if (a() <= 3) {
                        return WhenToOutput.NEVER;
                    }
                    return WhenToOutput.IF_NONZERO;
                }

                public c(int i) {
                    super(null);
                    this.b = i;
                    this.c = 'x';
                }

                @Override // kotlinx.datetime.format.j1.b.AbstractC0219b
                public void c(y.e builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    int a = a();
                    if (a != 1) {
                        if (a != 2) {
                            if (a != 3) {
                                if (a != 4) {
                                    if (a != 5) {
                                        m1.p(this);
                                        throw new KotlinNothingValueException();
                                    }
                                    d(builder, false, true);
                                    return;
                                }
                                d(builder, false, false);
                                return;
                            }
                            d(builder, false, true);
                            return;
                        }
                        d(builder, false, false);
                        return;
                    }
                    d(builder, false, false);
                }
            }

            /* renamed from: kotlinx.datetime.format.j1$b$b$d */
            public static final class d extends AbstractC0219b {
                private final int b;
                private final char c;

                static {
                    Covode.recordClassIndex(659544);
                }

                @Override // kotlinx.datetime.format.j1.b
                public int a() {
                    return this.b;
                }

                @Override // kotlinx.datetime.format.j1.b
                public char b() {
                    return this.c;
                }

                @Override // kotlinx.datetime.format.j1.b.AbstractC0219b
                public WhenToOutput e() {
                    return WhenToOutput.ALWAYS;
                }

                @Override // kotlinx.datetime.format.j1.b.AbstractC0219b
                public WhenToOutput f() {
                    if (a() <= 3) {
                        return WhenToOutput.NEVER;
                    }
                    return WhenToOutput.IF_NONZERO;
                }

                public d(int i) {
                    super(null);
                    this.b = i;
                    this.c = 'Z';
                }

                @Override // kotlinx.datetime.format.j1.b.AbstractC0219b
                public void c(y.e builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    int a = a();
                    if (a != 1 && a != 2 && a != 3) {
                        if (a != 4) {
                            if (a != 5) {
                                m1.p(this);
                                throw new KotlinNothingValueException();
                            }
                            d(builder, false, true);
                            return;
                        }
                        new a(4).c(builder);
                        throw new KotlinNothingValueException();
                    }
                    d(builder, false, false);
                }
            }

            private AbstractC0219b() {
                super(null);
            }

            public final void d(y.e eVar, boolean z, boolean z2) {
                Intrinsics.checkNotNullParameter(eVar, "<this>");
                l2.O(eVar, z, z2, e(), f());
            }
        }

        public static abstract class c extends b {

            public static abstract class e extends c {
                static {
                    Covode.recordClassIndex(659550);
                }

                public /* synthetic */ e(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public static final class a extends e {
                    private final int b;
                    private final char c;

                    static {
                        Covode.recordClassIndex(659551);
                    }

                    @Override // kotlinx.datetime.format.j1.b
                    public int a() {
                        return this.b;
                    }

                    @Override // kotlinx.datetime.format.j1.b
                    public char b() {
                        return this.c;
                    }

                    public a(int i) {
                        super(null);
                        this.b = i;
                        this.c = 's';
                    }

                    @Override // kotlinx.datetime.format.j1.b.c
                    public void c(y.d builder) {
                        Intrinsics.checkNotNullParameter(builder, "builder");
                        int a = a();
                        if (a != 1) {
                            if (a != 2) {
                                m1.p(this);
                                throw new KotlinNothingValueException();
                            }
                            builder.w(Padding.ZERO);
                            return;
                        }
                        builder.w(Padding.NONE);
                    }
                }

                private e() {
                    super(null);
                }
            }

            public static abstract class f extends e {
                static {
                    Covode.recordClassIndex(659552);
                }

                public /* synthetic */ f(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public static final class a extends f {
                    private final int b;
                    private final char c;

                    static {
                        Covode.recordClassIndex(659553);
                    }

                    @Override // kotlinx.datetime.format.j1.b
                    public int a() {
                        return this.b;
                    }

                    @Override // kotlinx.datetime.format.j1.b
                    public char b() {
                        return this.c;
                    }

                    public a(int i) {
                        super(null);
                        this.b = i;
                        this.c = 'S';
                    }

                    @Override // kotlinx.datetime.format.j1.b.c
                    public void c(y.d builder) {
                        Intrinsics.checkNotNullParameter(builder, "builder");
                        builder.p(a());
                    }
                }

                /* renamed from: kotlinx.datetime.format.j1$b$c$f$b, reason: collision with other inner class name */
                public static final class C0223b extends f {
                    private final int b;
                    private final char c;

                    static {
                        Covode.recordClassIndex(659554);
                    }

                    @Override // kotlinx.datetime.format.j1.b
                    public int a() {
                        return this.b;
                    }

                    @Override // kotlinx.datetime.format.j1.b
                    public char b() {
                        return this.c;
                    }

                    public C0223b(int i) {
                        super(null);
                        this.b = i;
                        this.c = 'A';
                    }

                    @Override // kotlinx.datetime.format.j1.b.c
                    /* renamed from: d, reason: merged with bridge method [inline-methods] */
                    public Void c(y.d builder) {
                        Intrinsics.checkNotNullParameter(builder, "builder");
                        m1.r("millisecond-of-day", null, 2, null);
                        throw new KotlinNothingValueException();
                    }
                }

                /* renamed from: kotlinx.datetime.format.j1$b$c$f$c, reason: collision with other inner class name */
                public static final class C0224c extends f {
                    private final int b;
                    private final char c;

                    static {
                        Covode.recordClassIndex(659555);
                    }

                    @Override // kotlinx.datetime.format.j1.b
                    public int a() {
                        return this.b;
                    }

                    @Override // kotlinx.datetime.format.j1.b
                    public char b() {
                        return this.c;
                    }

                    public C0224c(int i) {
                        super(null);
                        this.b = i;
                        this.c = 'N';
                    }

                    @Override // kotlinx.datetime.format.j1.b.c
                    /* renamed from: d, reason: merged with bridge method [inline-methods] */
                    public Void c(y.d builder) {
                        Intrinsics.checkNotNullParameter(builder, "builder");
                        m1.r("nanosecond-of-day", null, 2, null);
                        throw new KotlinNothingValueException();
                    }
                }

                public static final class d extends f {
                    private final int b;
                    private final char c;

                    static {
                        Covode.recordClassIndex(659556);
                    }

                    @Override // kotlinx.datetime.format.j1.b
                    public int a() {
                        return this.b;
                    }

                    @Override // kotlinx.datetime.format.j1.b
                    public char b() {
                        return this.c;
                    }

                    public d(int i) {
                        super(null);
                        this.b = i;
                        this.c = 'n';
                    }

                    @Override // kotlinx.datetime.format.j1.b.c
                    /* renamed from: d, reason: merged with bridge method [inline-methods] */
                    public Void c(y.d builder) {
                        Intrinsics.checkNotNullParameter(builder, "builder");
                        m1.q("nano-of-second", "Maybe you meant 'S' instead of 'n'?");
                        throw new KotlinNothingValueException();
                    }
                }

                private f() {
                    super(null);
                }
            }

            static {
                Covode.recordClassIndex(659545);
            }

            public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public abstract void c(y.d dVar);

            public static final class a extends c {
                private final int b;
                private final char c;

                static {
                    Covode.recordClassIndex(659546);
                }

                @Override // kotlinx.datetime.format.j1.b
                public int a() {
                    return this.b;
                }

                @Override // kotlinx.datetime.format.j1.b
                public char b() {
                    return this.c;
                }

                public a(int i) {
                    super(null);
                    this.b = i;
                    this.c = 'h';
                }

                @Override // kotlinx.datetime.format.j1.b.c
                /* renamed from: d, reason: merged with bridge method [inline-methods] */
                public Void c(y.d builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    m1.n(this, null, 1, null);
                    throw new KotlinNothingValueException();
                }
            }

            /* renamed from: kotlinx.datetime.format.j1$b$c$b, reason: collision with other inner class name */
            public static final class C0221b extends c {
                private final int b;
                private final char c;

                static {
                    Covode.recordClassIndex(659547);
                }

                @Override // kotlinx.datetime.format.j1.b
                public int a() {
                    return this.b;
                }

                @Override // kotlinx.datetime.format.j1.b
                public char b() {
                    return this.c;
                }

                public C0221b(int i) {
                    super(null);
                    this.b = i;
                    this.c = 'a';
                }

                @Override // kotlinx.datetime.format.j1.b.c
                /* renamed from: d, reason: merged with bridge method [inline-methods] */
                public Void c(y.d builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    m1.n(this, null, 1, null);
                    throw new KotlinNothingValueException();
                }
            }

            /* renamed from: kotlinx.datetime.format.j1$b$c$c, reason: collision with other inner class name */
            public static final class C0222c extends c {
                private final int b;
                private final char c;

                static {
                    Covode.recordClassIndex(659548);
                }

                @Override // kotlinx.datetime.format.j1.b
                public int a() {
                    return this.b;
                }

                @Override // kotlinx.datetime.format.j1.b
                public char b() {
                    return this.c;
                }

                public C0222c(int i) {
                    super(null);
                    this.b = i;
                    this.c = 'H';
                }

                @Override // kotlinx.datetime.format.j1.b.c
                public void c(y.d builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    int a = a();
                    if (a != 1) {
                        if (a != 2) {
                            m1.p(this);
                            throw new KotlinNothingValueException();
                        }
                        builder.x(Padding.ZERO);
                        return;
                    }
                    builder.x(Padding.NONE);
                }
            }

            public static final class d extends c {
                private final int b;
                private final char c;

                static {
                    Covode.recordClassIndex(659549);
                }

                @Override // kotlinx.datetime.format.j1.b
                public int a() {
                    return this.b;
                }

                @Override // kotlinx.datetime.format.j1.b
                public char b() {
                    return this.c;
                }

                public d(int i) {
                    super(null);
                    this.b = i;
                    this.c = 'm';
                }

                @Override // kotlinx.datetime.format.j1.b.c
                public void c(y.d builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    int a = a();
                    if (a != 1) {
                        if (a != 2) {
                            m1.p(this);
                            throw new KotlinNothingValueException();
                        }
                        builder.v(Padding.ZERO);
                        return;
                    }
                    builder.v(Padding.NONE);
                }
            }

            private c() {
                super(null);
            }
        }

        public static abstract class d extends b {
            static {
                Covode.recordClassIndex(659557);
            }

            public /* synthetic */ d(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public abstract void c(y.c cVar);

            public static final class a extends d {
                private final int b;
                private final char c;

                static {
                    Covode.recordClassIndex(659558);
                }

                @Override // kotlinx.datetime.format.j1.b
                public int a() {
                    return this.b;
                }

                @Override // kotlinx.datetime.format.j1.b
                public char b() {
                    return this.c;
                }

                public a(int i) {
                    super(null);
                    this.b = i;
                    this.c = 'v';
                }

                @Override // kotlinx.datetime.format.j1.b.d
                /* renamed from: d, reason: merged with bridge method [inline-methods] */
                public Void c(y.c builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    m1.n(this, null, 1, null);
                    throw new KotlinNothingValueException();
                }
            }

            /* renamed from: kotlinx.datetime.format.j1$b$d$b, reason: collision with other inner class name */
            public static final class C0225b extends d {
                private final int b;
                private final char c;

                static {
                    Covode.recordClassIndex(659559);
                }

                @Override // kotlinx.datetime.format.j1.b
                public int a() {
                    return this.b;
                }

                @Override // kotlinx.datetime.format.j1.b
                public char b() {
                    return this.c;
                }

                public C0225b(int i) {
                    super(null);
                    this.b = i;
                    this.c = 'V';
                }

                @Override // kotlinx.datetime.format.j1.b.d
                public void c(y.c builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    if (a() != 2) {
                        m1.p(this);
                        throw new KotlinNothingValueException();
                    }
                    builder.o();
                }
            }

            public static final class c extends d {
                private final int b;
                private final char c;

                static {
                    Covode.recordClassIndex(659560);
                }

                @Override // kotlinx.datetime.format.j1.b
                public int a() {
                    return this.b;
                }

                @Override // kotlinx.datetime.format.j1.b
                public char b() {
                    return this.c;
                }

                public c(int i) {
                    super(null);
                    this.b = i;
                    this.c = 'z';
                }

                @Override // kotlinx.datetime.format.j1.b.d
                /* renamed from: d, reason: merged with bridge method [inline-methods] */
                public Void c(y.c builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    m1.m(this, "Format 'V' can be used to format time zone IDs in a locale-invariant manner.");
                    throw new KotlinNothingValueException();
                }
            }

            private d() {
                super(null);
            }
        }

        static {
            Covode.recordClassIndex(659519);
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract int a();

        public abstract char b();

        public int hashCode() {
            return (b() * 31) + a();
        }

        public String toString() {
            String repeat;
            repeat = StringsKt__StringsJVMKt.repeat(String.valueOf(b()), a());
            return repeat;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (b() == bVar.b() && a() == bVar.a()) {
                    return true;
                }
            }
            return false;
        }
    }

    public static final class c implements j1 {
        public final j1 b;

        static {
            Covode.recordClassIndex(659561);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && Intrinsics.areEqual(this.b, ((c) obj).b);
        }

        public int hashCode() {
            return this.b.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            sb.append(this.b);
            sb.append(']');
            return sb.toString();
        }

        public c(j1 format) {
            Intrinsics.checkNotNullParameter(format, "format");
            this.b = format;
        }
    }

    public static final class d implements j1 {
        public final List<j1> b;

        static {
            Covode.recordClassIndex(659562);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && Intrinsics.areEqual(this.b, ((d) obj).b);
        }

        public int hashCode() {
            return this.b.hashCode();
        }

        public String toString() {
            return CollectionsKt___CollectionsKt.joinToString$default(this.b, "", null, null, 0, null, null, 62, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public d(List<? extends j1> formats) {
            Intrinsics.checkNotNullParameter(formats, "formats");
            this.b = formats;
        }
    }

    public static final class e implements j1 {
        public final String b;

        static {
            Covode.recordClassIndex(659563);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof e) && Intrinsics.areEqual(this.b, ((e) obj).b);
        }

        public int hashCode() {
            return this.b.hashCode();
        }

        public String toString() {
            boolean z;
            if (Intrinsics.areEqual(this.b, "'")) {
                return "''";
            }
            String str = this.b;
            boolean z2 = false;
            int i = 0;
            while (true) {
                if (i < str.length()) {
                    if (Character.isLetter(str.charAt(i))) {
                        z = true;
                        break;
                    }
                    i++;
                } else {
                    z = false;
                    break;
                }
            }
            if (z) {
                return '\'' + this.b + '\'';
            }
            if (this.b.length() == 0) {
                z2 = true;
            }
            if (z2) {
                return "";
            }
            return this.b;
        }

        public e(String literal) {
            Intrinsics.checkNotNullParameter(literal, "literal");
            this.b = literal;
        }
    }

    public static final class a {
        static final /* synthetic */ a a;

        static {
            Covode.recordClassIndex(659518);
            a = new a();
        }

        private a() {
        }

        public final j1 a(String pattern) {
            List mutableListOf;
            Object removeLast;
            List list;
            List list2;
            j1 o;
            List list3;
            Object removeLast2;
            j1 o2;
            boolean z;
            Intrinsics.checkNotNullParameter(pattern, "pattern");
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new ArrayList());
            int length = pattern.length();
            String str = "";
            Character ch = null;
            int i = 0;
            boolean z2 = false;
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = pattern.charAt(i2);
                if (ch != null && charAt == ch.charValue()) {
                    i++;
                } else if (z2) {
                    if (charAt == '\'') {
                        List list4 = (List) CollectionsKt___CollectionsKt.last(mutableListOf);
                        if (list4 != null) {
                            if (str.length() == 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                str = "'";
                            }
                            list4.add(new e(str));
                        }
                        str = "";
                        z2 = false;
                    } else {
                        str = str + charAt;
                    }
                } else {
                    if (i > 0) {
                        List list5 = (List) CollectionsKt___CollectionsKt.last(mutableListOf);
                        if (list5 != null) {
                            Intrinsics.checkNotNull(ch);
                            o2 = m1.o(ch.charValue(), i);
                            list5.add(o2);
                        }
                        ch = null;
                        i = 0;
                    }
                    list3 = m1.a;
                    if (!list3.contains(Character.valueOf(charAt))) {
                        str = str + charAt;
                    } else {
                        if (!Intrinsics.areEqual(str, "")) {
                            List list6 = (List) CollectionsKt___CollectionsKt.last(mutableListOf);
                            if (list6 != null) {
                                list6.add(new e(str));
                            }
                            str = "";
                        }
                        if (charAt == '\'') {
                            str = "";
                            z2 = true;
                        } else if (charAt == '[') {
                            mutableListOf.add(new ArrayList());
                        } else if (charAt == ']') {
                            removeLast2 = CollectionsKt__MutableCollectionsKt.removeLast(mutableListOf);
                            List list7 = (List) removeLast2;
                            if (list7 != null) {
                                List list8 = (List) CollectionsKt___CollectionsKt.last(mutableListOf);
                                if (list8 != null) {
                                    list8.add(new c(new d(list7)));
                                }
                            } else {
                                throw new IllegalArgumentException("Unmatched closing bracket");
                            }
                        } else {
                            ch = Character.valueOf(charAt);
                            i = 1;
                        }
                    }
                }
            }
            if (i > 0 && (list2 = (List) CollectionsKt___CollectionsKt.last(mutableListOf)) != null) {
                Intrinsics.checkNotNull(ch);
                o = m1.o(ch.charValue(), i);
                list2.add(o);
            }
            if (!Intrinsics.areEqual(str, "") && (list = (List) CollectionsKt___CollectionsKt.last(mutableListOf)) != null) {
                list.add(new e(str));
            }
            removeLast = CollectionsKt__MutableCollectionsKt.removeLast(mutableListOf);
            List list9 = (List) removeLast;
            if (list9 != null) {
                return new d(list9);
            }
            throw new IllegalArgumentException("Unmatched opening bracket");
        }
    }
}
