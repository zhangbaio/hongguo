package kotlinx.datetime.internal.format.parser;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class e<Receiver> {
    private final Integer a;
    public final String b;

    static {
        Covode.recordClassIndex(659640);
    }

    public /* synthetic */ e(Integer num, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(num, str);
    }

    public abstract g a(Receiver receiver, CharSequence charSequence, int i, int i2);

    public Integer b() {
        return this.a;
    }

    private e(Integer num, String str) {
        this.a = num;
        this.b = str;
    }
}
