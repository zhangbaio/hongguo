package kotlinx.datetime.internal.format;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class f<T> extends h<T> {
    private final bn6.e<T> b;
    private final kotlinx.datetime.internal.format.parser.u<T> c;

    static {
        Covode.recordClassIndex(659594);
    }

    @Override // kotlinx.datetime.internal.format.h, kotlinx.datetime.internal.format.n
    public kotlinx.datetime.internal.format.parser.u<T> a() {
        return this.c;
    }

    @Override // kotlinx.datetime.internal.format.h, kotlinx.datetime.internal.format.n
    public bn6.e<T> b() {
        return this.b;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(List<? extends q<? super T>> formats) {
        super(formats);
        Intrinsics.checkNotNullParameter(formats, "formats");
        this.b = super.b();
        this.c = super.a();
    }
}
