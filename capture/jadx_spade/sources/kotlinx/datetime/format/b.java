package kotlinx.datetime.format;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.format.b;
import kotlinx.datetime.internal.format.OptionalFormatStructure;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface b<Target, ActualSelf extends b<Target, ActualSelf>> extends y {
    kotlinx.datetime.internal.format.d<Target> f();

    ActualSelf k();

    void s(String str, Function1<? super ActualSelf, Unit> function1);

    void t(Function1<? super ActualSelf, Unit>[] function1Arr, Function1<? super ActualSelf, Unit> function1);

    public static final class a {
        static {
            Covode.recordClassIndex(659434);
        }

        public static <Target, ActualSelf extends b<Target, ActualSelf>> kotlinx.datetime.internal.format.f<Target> c(b<Target, ActualSelf> bVar) {
            return new kotlinx.datetime.internal.format.f<>(bVar.f().b().a);
        }

        public static <Target, ActualSelf extends b<Target, ActualSelf>> void d(b<Target, ActualSelf> bVar, String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            bVar.f().a(new kotlinx.datetime.internal.format.j(value));
        }

        public static <Target, ActualSelf extends b<Target, ActualSelf>> void b(b<Target, ActualSelf> bVar, String onZero, Function1<? super ActualSelf, Unit> format) {
            Intrinsics.checkNotNullParameter(onZero, "onZero");
            Intrinsics.checkNotNullParameter(format, "format");
            kotlinx.datetime.internal.format.d<Target> f = bVar.f();
            ActualSelf k = bVar.k();
            format.invoke(k);
            Unit unit = Unit.INSTANCE;
            f.a(new OptionalFormatStructure(onZero, k.f().b()));
        }

        public static <Target, ActualSelf extends b<Target, ActualSelf>> void a(b<Target, ActualSelf> bVar, Function1<? super ActualSelf, Unit>[] otherFormats, Function1<? super ActualSelf, Unit> mainFormat) {
            Intrinsics.checkNotNullParameter(otherFormats, "otherFormats");
            Intrinsics.checkNotNullParameter(mainFormat, "mainFormat");
            ArrayList arrayList = new ArrayList(otherFormats.length);
            for (Function1<? super ActualSelf, Unit> function1 : otherFormats) {
                ActualSelf k = bVar.k();
                function1.invoke(k);
                arrayList.add(k.f().b());
            }
            ActualSelf k2 = bVar.k();
            mainFormat.invoke(k2);
            bVar.f().a(new kotlinx.datetime.internal.format.c(k2.f().b(), arrayList));
        }
    }
}
