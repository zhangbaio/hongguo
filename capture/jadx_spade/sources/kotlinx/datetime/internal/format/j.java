package kotlinx.datetime.internal.format;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class j<T> implements q<T> {
    public final String a;

    static {
        Covode.recordClassIndex(659598);
    }

    @Override // kotlinx.datetime.internal.format.n
    public bn6.e<T> b() {
        return new bn6.c(this.a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "ConstantFormatStructure(" + this.a + ')';
    }

    @Override // kotlinx.datetime.internal.format.n
    public kotlinx.datetime.internal.format.parser.u<T> a() {
        boolean z;
        String str;
        boolean z2;
        List build;
        if (this.a.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            build = CollectionsKt__CollectionsKt.emptyList();
        } else {
            List createListBuilder = CollectionsKt__CollectionsJVMKt.createListBuilder();
            String str2 = "";
            if (an6.f.b(this.a.charAt(0))) {
                String str3 = this.a;
                int length = str3.length();
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    if (!an6.f.b(str3.charAt(i))) {
                        str3 = str3.substring(0, i);
                        Intrinsics.checkNotNullExpressionValue(str3, "substring(...)");
                        break;
                    }
                    i++;
                }
                createListBuilder.add(new kotlinx.datetime.internal.format.parser.k(CollectionsKt__CollectionsJVMKt.listOf(new kotlinx.datetime.internal.format.parser.b(str3))));
                String str4 = this.a;
                int length2 = str4.length();
                int i2 = 0;
                while (true) {
                    if (i2 >= length2) {
                        str = "";
                        break;
                    }
                    if (!an6.f.b(str4.charAt(i2))) {
                        str = str4.substring(i2);
                        Intrinsics.checkNotNullExpressionValue(str, "substring(...)");
                        break;
                    }
                    i2++;
                }
            } else {
                str = this.a;
            }
            if (str.length() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                if (an6.f.b(str.charAt(str.length() - 1))) {
                    int lastIndex = StringsKt__StringsKt.getLastIndex(str);
                    while (true) {
                        if (-1 >= lastIndex) {
                            break;
                        }
                        if (!an6.f.b(str.charAt(lastIndex))) {
                            str2 = str.substring(0, lastIndex + 1);
                            Intrinsics.checkNotNullExpressionValue(str2, "substring(...)");
                            break;
                        }
                        lastIndex--;
                    }
                    createListBuilder.add(new kotlinx.datetime.internal.format.parser.x(str2));
                    int lastIndex2 = StringsKt__StringsKt.getLastIndex(str);
                    while (true) {
                        if (-1 >= lastIndex2) {
                            break;
                        }
                        if (!an6.f.b(str.charAt(lastIndex2))) {
                            str = str.substring(lastIndex2 + 1);
                            Intrinsics.checkNotNullExpressionValue(str, "substring(...)");
                            break;
                        }
                        lastIndex2--;
                    }
                    createListBuilder.add(new kotlinx.datetime.internal.format.parser.k(CollectionsKt__CollectionsJVMKt.listOf(new kotlinx.datetime.internal.format.parser.b(str))));
                } else {
                    createListBuilder.add(new kotlinx.datetime.internal.format.parser.x(str));
                }
            }
            build = CollectionsKt__CollectionsJVMKt.build(createListBuilder);
        }
        return new kotlinx.datetime.internal.format.parser.u<>(build, CollectionsKt__CollectionsKt.emptyList());
    }

    public j(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        this.a = string;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof j) && Intrinsics.areEqual(this.a, ((j) obj).a)) {
            return true;
        }
        return false;
    }
}
