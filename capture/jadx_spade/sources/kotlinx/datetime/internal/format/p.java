package kotlinx.datetime.internal.format;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class p<Target, Type> extends a<Target, Type> {
    private final b<Target, Type> a;
    private final String b;
    private final Type c;
    private final l<Target> d;

    static {
        Covode.recordClassIndex(659605);
    }

    @Override // kotlinx.datetime.internal.format.m
    public Type a() {
        return this.c;
    }

    @Override // kotlinx.datetime.internal.format.m
    public b<Target, Type> b() {
        return this.a;
    }

    @Override // kotlinx.datetime.internal.format.m
    public String getName() {
        return this.b;
    }

    @Override // kotlinx.datetime.internal.format.m
    public l<Target> getSign() {
        return this.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public p(b<? super Target, Type> accessor, String name, Type type, l<? super Target> lVar) {
        Intrinsics.checkNotNullParameter(accessor, "accessor");
        Intrinsics.checkNotNullParameter(name, "name");
        this.a = accessor;
        this.b = name;
        this.c = type;
        this.d = lVar;
    }

    public /* synthetic */ p(b bVar, String str, Object obj, l lVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bVar, (i & 2) != 0 ? bVar.getName() : str, (i & 4) != 0 ? null : obj, (i & 8) != 0 ? null : lVar);
    }
}
