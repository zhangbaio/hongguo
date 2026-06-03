package zm4;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f {
    public static final a c;
    public static final int d;
    public final String a;
    private final Map<String, String> b;

    static {
        Covode.recordClassIndex(608712);
        c = new a(null);
        d = 8;
    }

    public f(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.a = url;
        this.b = new LinkedHashMap();
    }

    public final String b(boolean z) {
        String str;
        String a2;
        if (this.b.isEmpty()) {
            return this.a;
        }
        StringBuilder sb = new StringBuilder();
        String str2 = this.a;
        boolean z2 = true;
        for (Map.Entry<String, String> entry : this.b.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (z2 && StringsKt__StringsJVMKt.endsWith$default(this.a, ".html", false, 2, null)) {
                str = "?";
            } else {
                str = "&";
            }
            if (z && (a2 = c.a(value)) != null) {
                value = a2;
            }
            sb.append(str);
            sb.append(key);
            sb.append("=");
            sb.append(value);
            z2 = false;
        }
        return str2 + ((Object) sb);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(608713);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(String str) {
            boolean z;
            List listOf;
            boolean z2;
            int checkRadix;
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < str.length(); i++) {
                    char charAt = str.charAt(i);
                    boolean z3 = true;
                    if ('a' <= charAt && charAt < '{') {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        if ('A' <= charAt && charAt < '[') {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (!z2) {
                            if ('0' > charAt || charAt >= ':') {
                                z3 = false;
                            }
                            if (!z3 && charAt != '-' && charAt != '_' && charAt != '.' && charAt != '~') {
                                StringBuilder sb = new StringBuilder();
                                sb.append('%');
                                checkRadix = CharsKt__CharJVMKt.checkRadix(16);
                                String num = Integer.toString(charAt, checkRadix);
                                Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
                                String upperCase = StringsKt__StringsKt.padStart(num, 2, '0').toUpperCase(Locale.ROOT);
                                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                                sb.append(upperCase);
                                listOf = CollectionsKt__CollectionsJVMKt.listOf(sb.toString());
                                CollectionsKt__MutableCollectionsKt.addAll(arrayList, listOf);
                            }
                        }
                    }
                    listOf = CollectionsKt__CollectionsJVMKt.listOf(String.valueOf(charAt));
                    CollectionsKt__MutableCollectionsKt.addAll(arrayList, listOf);
                }
                return CollectionsKt___CollectionsKt.joinToString$default(arrayList, "", null, null, 0, null, null, 62, null);
            }
            return null;
        }
    }

    public final f a(String key, String str) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (str != null) {
            this.b.put(key, str);
        }
        return this;
    }
}
