package kotlinx.datetime.format;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface y {

    public interface b extends a, d {
    }

    public interface c extends b, e {
        void o();
    }

    void q(String str);

    public interface d extends y {
        void d(int i, int i2);

        void p(int i);

        void r(x<zm6.j> xVar);

        void v(Padding padding);

        void w(Padding padding);

        void x(Padding padding);

        public static final class a {
            static {
                Covode.recordClassIndex(659468);
            }

            public static void d(d dVar, int i) {
                dVar.d(i, i);
            }

            public static /* synthetic */ void a(d dVar, Padding padding, int i, Object obj) {
                if (obj == null) {
                    if ((i & 1) != 0) {
                        padding = Padding.ZERO;
                    }
                    dVar.x(padding);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hour");
            }

            public static /* synthetic */ void b(d dVar, Padding padding, int i, Object obj) {
                if (obj == null) {
                    if ((i & 1) != 0) {
                        padding = Padding.ZERO;
                    }
                    dVar.v(padding);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: minute");
            }

            public static /* synthetic */ void c(d dVar, Padding padding, int i, Object obj) {
                if (obj == null) {
                    if ((i & 1) != 0) {
                        padding = Padding.ZERO;
                    }
                    dVar.w(padding);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: second");
            }
        }
    }

    public interface a extends y {
        void a(Padding padding);

        void e(MonthNames monthNames);

        void g(int i);

        void l(Padding padding);

        void m(Padding padding);

        void u(x<kotlinx.datetime.c> xVar);

        void y(DayOfWeekNames dayOfWeekNames);

        /* renamed from: kotlinx.datetime.format.y$a$a, reason: collision with other inner class name */
        public static final class C0226a {
            static {
                Covode.recordClassIndex(659462);
            }

            public static /* synthetic */ void a(a aVar, Padding padding, int i, Object obj) {
                if (obj == null) {
                    if ((i & 1) != 0) {
                        padding = Padding.ZERO;
                    }
                    aVar.m(padding);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dayOfMonth");
            }

            public static /* synthetic */ void b(a aVar, Padding padding, int i, Object obj) {
                if (obj == null) {
                    if ((i & 1) != 0) {
                        padding = Padding.ZERO;
                    }
                    aVar.a(padding);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: monthNumber");
            }

            public static /* synthetic */ void c(a aVar, Padding padding, int i, Object obj) {
                if (obj == null) {
                    if ((i & 1) != 0) {
                        padding = Padding.ZERO;
                    }
                    aVar.l(padding);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: year");
            }
        }
    }

    public interface e extends y {
        void A(Padding padding);

        void h(Padding padding);

        void j(x<zm6.o> xVar);

        void n(Padding padding);

        public static final class a {
            static {
                Covode.recordClassIndex(659470);
            }

            public static /* synthetic */ void a(e eVar, Padding padding, int i, Object obj) {
                if (obj == null) {
                    if ((i & 1) != 0) {
                        padding = Padding.ZERO;
                    }
                    eVar.A(padding);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: offsetHours");
            }

            public static /* synthetic */ void b(e eVar, Padding padding, int i, Object obj) {
                if (obj == null) {
                    if ((i & 1) != 0) {
                        padding = Padding.ZERO;
                    }
                    eVar.h(padding);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: offsetMinutesOfHour");
            }

            public static /* synthetic */ void c(e eVar, Padding padding, int i, Object obj) {
                if (obj == null) {
                    if ((i & 1) != 0) {
                        padding = Padding.ZERO;
                    }
                    eVar.n(padding);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: offsetSecondsOfMinute");
            }
        }
    }
}
