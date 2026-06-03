package kotlinx.serialization.descriptors;

import com.bytedance.covode.number.Covode;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlinx.serialization.ExperimentalSerializationApi;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface SerialDescriptor {
    List<Annotation> getAnnotations();

    @ExperimentalSerializationApi
    List<Annotation> getElementAnnotations(int i);

    @ExperimentalSerializationApi
    SerialDescriptor getElementDescriptor(int i);

    @ExperimentalSerializationApi
    int getElementIndex(String str);

    @ExperimentalSerializationApi
    String getElementName(int i);

    int getElementsCount();

    d getKind();

    String getSerialName();

    @ExperimentalSerializationApi
    boolean isElementOptional(int i);

    boolean isInline();

    boolean isNullable();

    public static final class a {
        static {
            Covode.recordClassIndex(659820);
        }

        public static boolean b(SerialDescriptor serialDescriptor) {
            return false;
        }

        public static boolean c(SerialDescriptor serialDescriptor) {
            return false;
        }

        public static List<Annotation> a(SerialDescriptor serialDescriptor) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
    }
}
