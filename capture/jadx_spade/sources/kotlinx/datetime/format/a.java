package kotlinx.datetime.format;

import bn6.e;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.DateTimeFormatException;
import kotlinx.datetime.internal.format.parser.ParseException;
import kotlinx.datetime.internal.format.parser.c;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class a<T, U extends kotlinx.datetime.internal.format.parser.c<U>> implements x<T> {
    static {
        Covode.recordClassIndex(659432);
    }

    private a() {
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract kotlinx.datetime.internal.format.f<U> b();

    public abstract U c();

    public abstract U d(T t);

    public abstract T e(U u);

    @Override // kotlinx.datetime.format.x
    public String format(T t) {
        StringBuilder sb = new StringBuilder();
        e.a.a(b().b(), d(t), sb, false, 4, null);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.datetime.format.x
    public T a(CharSequence input) {
        String str;
        Intrinsics.checkNotNullParameter(input, "input");
        try {
            try {
                return (T) e(kotlinx.datetime.internal.format.parser.n.c(kotlinx.datetime.internal.format.parser.n.a(b().a()), input, c(), 0, 4, null));
            } catch (IllegalArgumentException e) {
                String message = e.getMessage();
                if (message == null) {
                    str = "The value parsed from '" + ((Object) input) + "' is invalid";
                } else {
                    str = message + " (when parsing '" + ((Object) input) + "')";
                }
                throw new DateTimeFormatException(str, e);
            }
        } catch (ParseException e2) {
            throw new DateTimeFormatException("Failed to parse value from '" + ((Object) input) + '\'', e2);
        }
    }
}
