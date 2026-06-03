package kotlinx.datetime.format;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.MutablePropertyReference1Impl;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class TimeFields {
    public static final TimeFields a;
    private static final kotlinx.datetime.internal.format.x<g1> b;
    private static final kotlinx.datetime.internal.format.x<g1> c;
    private static final kotlinx.datetime.internal.format.x<g1> d;
    private static final kotlinx.datetime.internal.format.p<g1, an6.a> e;
    private static final kotlinx.datetime.internal.format.p<g1, AmPmMarker> f;
    private static final kotlinx.datetime.internal.format.x<g1> g;

    private TimeFields() {
    }

    public final kotlinx.datetime.internal.format.p<g1, an6.a> a() {
        return e;
    }

    public final kotlinx.datetime.internal.format.x<g1> b() {
        return b;
    }

    public final kotlinx.datetime.internal.format.x<g1> c() {
        return c;
    }

    public final kotlinx.datetime.internal.format.x<g1> d() {
        return d;
    }

    static {
        Covode.recordClassIndex(659514);
        a = new TimeFields();
        b = new kotlinx.datetime.internal.format.x<>(new kotlinx.datetime.internal.format.u(new MutablePropertyReference1Impl() { // from class: kotlinx.datetime.format.TimeFields$hour$1
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((g1) obj).x();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((g1) obj).C((Integer) obj2);
            }
        }), 0, 23, null, null, null, 56, null);
        c = new kotlinx.datetime.internal.format.x<>(new kotlinx.datetime.internal.format.u(new MutablePropertyReference1Impl() { // from class: kotlinx.datetime.format.TimeFields$minute$1
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((g1) obj).k();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((g1) obj).B((Integer) obj2);
            }
        }), 0, 59, null, null, null, 56, null);
        d = new kotlinx.datetime.internal.format.x<>(new kotlinx.datetime.internal.format.u(new MutablePropertyReference1Impl() { // from class: kotlinx.datetime.format.TimeFields$second$1
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((g1) obj).i();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((g1) obj).b((Integer) obj2);
            }
        }), 0, 59, null, 0, null, 40, null);
        e = new kotlinx.datetime.internal.format.p<>(new kotlinx.datetime.internal.format.u(new MutablePropertyReference1Impl() { // from class: kotlinx.datetime.format.TimeFields$fractionOfSecond$1
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((g1) obj).l();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((g1) obj).f((an6.a) obj2);
            }
        }), null, new an6.a(0, 9), null, 10, null);
        f = new kotlinx.datetime.internal.format.p<>(new kotlinx.datetime.internal.format.u(new MutablePropertyReference1Impl() { // from class: kotlinx.datetime.format.TimeFields$amPm$1
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((g1) obj).s();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((g1) obj).h((AmPmMarker) obj2);
            }
        }), null, null, null, 14, null);
        g = new kotlinx.datetime.internal.format.x<>(new kotlinx.datetime.internal.format.u(new MutablePropertyReference1Impl() { // from class: kotlinx.datetime.format.TimeFields$hourOfAmPm$1
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((g1) obj).p();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((g1) obj).t((Integer) obj2);
            }
        }), 1, 12, null, null, null, 56, null);
    }
}
