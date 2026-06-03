package fn6;

import com.bytedance.covode.number.Covode;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a {
    public final String a;
    public List<? extends Annotation> b;
    public final List<String> c;
    private final Set<String> d;
    public final List<SerialDescriptor> e;
    public final List<List<Annotation>> f;
    public final List<Boolean> g;

    static {
        Covode.recordClassIndex(659803);
    }

    public final void c(List<? extends Annotation> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.b = list;
    }

    public a(String serialName) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        this.a = serialName;
        this.b = CollectionsKt__CollectionsKt.emptyList();
        this.c = new ArrayList();
        this.d = new HashSet();
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new ArrayList();
    }

    public final void a(String elementName, SerialDescriptor descriptor, List<? extends Annotation> annotations, boolean z) {
        Intrinsics.checkNotNullParameter(elementName, "elementName");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        if (this.d.add(elementName)) {
            this.c.add(elementName);
            this.e.add(descriptor);
            this.f.add(annotations);
            this.g.add(Boolean.valueOf(z));
            return;
        }
        throw new IllegalArgumentException(("Element with name '" + elementName + "' is already registered in " + this.a).toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void b(a aVar, String str, SerialDescriptor serialDescriptor, List list, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        if ((i & 8) != 0) {
            z = false;
        }
        aVar.a(str, serialDescriptor, list, z);
    }
}
