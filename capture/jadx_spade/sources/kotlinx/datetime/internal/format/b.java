package kotlinx.datetime.internal.format;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface b<Object, Field> extends kotlinx.datetime.internal.format.parser.a<Object, Field> {
    Field a(Object object);

    Field b(Object object);

    public static final class a {
        static {
            Covode.recordClassIndex(659590);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static <Object, Field> Field a(b<? super Object, Field> bVar, Object object) {
            Field a = bVar.a(object);
            if (a != null) {
                return a;
            }
            throw new IllegalStateException("Field " + bVar.getName() + " is not set");
        }
    }
}
