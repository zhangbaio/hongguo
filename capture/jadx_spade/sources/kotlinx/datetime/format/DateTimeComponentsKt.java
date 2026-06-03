package kotlinx.datetime.format;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.MutablePropertyReference1Impl;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class DateTimeComponentsKt {
    private static final kotlinx.datetime.internal.format.p<v, String> a;
    private static final v b;

    public static final kotlinx.datetime.internal.format.p<v, String> b() {
        return a;
    }

    static {
        Covode.recordClassIndex(659455);
        a = new kotlinx.datetime.internal.format.p<>(new kotlinx.datetime.internal.format.u(new MutablePropertyReference1Impl() { // from class: kotlinx.datetime.format.DateTimeComponentsKt$timeZoneField$1
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((v) obj).d;
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((v) obj).d = (String) obj2;
            }
        }), null, null, null, 14, null);
        b = new v(null, null, null, null, 15, null);
    }
}
