package kotlin.properties;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class Delegates {
    public static final Delegates INSTANCE;

    static {
        Covode.recordClassIndex(658594);
        INSTANCE = new Delegates();
    }

    private Delegates() {
    }

    public final <T> ReadWriteProperty<Object, T> notNull() {
        return new kotlin.properties.a();
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> extends ObservableProperty<T> {
        final /* synthetic */ Function3<KProperty<?>, T, T, Unit> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(T t, Function3<? super KProperty<?>, ? super T, ? super T, Unit> function3) {
            super(t);
            this.a = function3;
        }

        @Override // kotlin.properties.ObservableProperty
        protected void afterChange(KProperty<?> property, T t, T t2) {
            Intrinsics.checkNotNullParameter(property, "property");
            this.a.invoke(property, t, t2);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class b<T> extends ObservableProperty<T> {
        final /* synthetic */ Function3<KProperty<?>, T, T, Boolean> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(T t, Function3<? super KProperty<?>, ? super T, ? super T, Boolean> function3) {
            super(t);
            this.a = function3;
        }

        @Override // kotlin.properties.ObservableProperty
        protected boolean beforeChange(KProperty<?> property, T t, T t2) {
            Intrinsics.checkNotNullParameter(property, "property");
            return this.a.invoke(property, t, t2).booleanValue();
        }
    }

    public final <T> ReadWriteProperty<Object, T> observable(T t, Function3<? super KProperty<?>, ? super T, ? super T, Unit> onChange) {
        Intrinsics.checkNotNullParameter(onChange, "onChange");
        return new a(t, onChange);
    }

    public final <T> ReadWriteProperty<Object, T> vetoable(T t, Function3<? super KProperty<?>, ? super T, ? super T, Boolean> onChange) {
        Intrinsics.checkNotNullParameter(onChange, "onChange");
        return new b(t, onChange);
    }
}
