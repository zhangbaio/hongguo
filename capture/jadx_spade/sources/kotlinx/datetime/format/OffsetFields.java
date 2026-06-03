package kotlinx.datetime.format;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class OffsetFields {
    public static final OffsetFields a;
    private static final OffsetFields$sign$1 b;
    private static final kotlinx.datetime.internal.format.x<o1> c;
    private static final kotlinx.datetime.internal.format.x<o1> d;
    private static final kotlinx.datetime.internal.format.x<o1> e;

    private OffsetFields() {
    }

    public final kotlinx.datetime.internal.format.x<o1> a() {
        return d;
    }

    public final kotlinx.datetime.internal.format.x<o1> b() {
        return e;
    }

    public final kotlinx.datetime.internal.format.x<o1> c() {
        return c;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [kotlinx.datetime.format.OffsetFields$sign$1, kotlinx.datetime.internal.format.l] */
    static {
        Covode.recordClassIndex(659507);
        a = new OffsetFields();
        ?? r0 = new kotlinx.datetime.internal.format.l<o1>() { // from class: kotlinx.datetime.format.OffsetFields$sign$1
            public final kotlinx.datetime.internal.format.u<o1, Boolean> a = new kotlinx.datetime.internal.format.u<>(new MutablePropertyReference1Impl() { // from class: kotlinx.datetime.format.OffsetFields$sign$1$isNegative$1
                @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj) {
                    return ((o1) obj).isNegative();
                }

                @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
                public void set(Object obj, Object obj2) {
                    ((o1) obj).q((Boolean) obj2);
                }
            });

            @Override // kotlinx.datetime.internal.format.l
            public /* bridge */ /* synthetic */ kotlinx.datetime.internal.format.b<o1, Boolean> isNegative() {
                return this.a;
            }

            @Override // kotlinx.datetime.internal.format.l
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public boolean a(o1 obj) {
                int i;
                int i2;
                int i3;
                Intrinsics.checkNotNullParameter(obj, "obj");
                Integer y = obj.y();
                if (y != null) {
                    i = y.intValue();
                } else {
                    i = 0;
                }
                if (i != 0) {
                    return false;
                }
                Integer z = obj.z();
                if (z != null) {
                    i2 = z.intValue();
                } else {
                    i2 = 0;
                }
                if (i2 != 0) {
                    return false;
                }
                Integer d2 = obj.d();
                if (d2 != null) {
                    i3 = d2.intValue();
                } else {
                    i3 = 0;
                }
                if (i3 != 0) {
                    return false;
                }
                return true;
            }
        };
        b = r0;
        c = new kotlinx.datetime.internal.format.x<>(new kotlinx.datetime.internal.format.u(new MutablePropertyReference1Impl() { // from class: kotlinx.datetime.format.OffsetFields$totalHoursAbs$1
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((o1) obj).y();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((o1) obj).c((Integer) obj2);
            }
        }), 0, 18, null, 0, r0, 8, null);
        d = new kotlinx.datetime.internal.format.x<>(new kotlinx.datetime.internal.format.u(new MutablePropertyReference1Impl() { // from class: kotlinx.datetime.format.OffsetFields$minutesOfHour$1
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((o1) obj).z();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((o1) obj).r((Integer) obj2);
            }
        }), 0, 59, null, 0, r0, 8, null);
        e = new kotlinx.datetime.internal.format.x<>(new kotlinx.datetime.internal.format.u(new MutablePropertyReference1Impl() { // from class: kotlinx.datetime.format.OffsetFields$secondsOfMinute$1
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((o1) obj).d();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((o1) obj).A((Integer) obj2);
            }
        }), 0, 59, null, 0, r0, 8, null);
    }
}
