package kotlinx.datetime.format;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.MutablePropertyReference1Impl;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class DateFields {
    public static final DateFields a;
    private static final kotlinx.datetime.internal.format.p<g, Integer> b;
    private static final kotlinx.datetime.internal.format.x<g> c;
    private static final kotlinx.datetime.internal.format.x<g> d;
    private static final kotlinx.datetime.internal.format.x<g> e;

    private DateFields() {
    }

    public final kotlinx.datetime.internal.format.x<g> a() {
        return d;
    }

    public final kotlinx.datetime.internal.format.x<g> b() {
        return e;
    }

    public final kotlinx.datetime.internal.format.x<g> c() {
        return c;
    }

    public final kotlinx.datetime.internal.format.p<g, Integer> d() {
        return b;
    }

    static {
        Covode.recordClassIndex(659448);
        a = new DateFields();
        b = new kotlinx.datetime.internal.format.p<>(new kotlinx.datetime.internal.format.u(new MutablePropertyReference1Impl() { // from class: kotlinx.datetime.format.DateFields$year$1
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((g) obj).e();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((g) obj).m((Integer) obj2);
            }
        }), null, null, null, 14, null);
        c = new kotlinx.datetime.internal.format.x<>(new kotlinx.datetime.internal.format.u(new MutablePropertyReference1Impl() { // from class: kotlinx.datetime.format.DateFields$month$1
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((g) obj).w();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((g) obj).j((Integer) obj2);
            }
        }), 1, 12, null, null, null, 56, null);
        d = new kotlinx.datetime.internal.format.x<>(new kotlinx.datetime.internal.format.u(new MutablePropertyReference1Impl() { // from class: kotlinx.datetime.format.DateFields$dayOfMonth$1
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((g) obj).n();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((g) obj).v((Integer) obj2);
            }
        }), 1, 31, null, null, null, 56, null);
        e = new kotlinx.datetime.internal.format.x<>(new kotlinx.datetime.internal.format.u(new MutablePropertyReference1Impl() { // from class: kotlinx.datetime.format.DateFields$isoDayOfWeek$1
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((g) obj).a();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((g) obj).g((Integer) obj2);
            }
        }), 1, 7, null, null, null, 56, null);
    }
}
