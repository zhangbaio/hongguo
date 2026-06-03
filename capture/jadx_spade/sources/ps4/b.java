package ps4;

import com.bytedance.covode.number.Covode;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.dragon.read.base.util.LogHelper;
import com.dragon.read.util.u1;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    public static final b a;
    private static final Lazy b;
    public static final int c;

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LogHelper e() {
        return new LogHelper("CommentManager");
    }

    private final LogHelper d() {
        return (LogHelper) b.getValue();
    }

    static {
        Lazy lazy;
        Covode.recordClassIndex(612441);
        a = new b();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: ps4.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                LogHelper e;
                e = b.e();
                return e;
            }
        });
        b = lazy;
        c = 8;
    }

    private final String c(List<Header> list) {
        for (Header header : list) {
            if (header != null && StringsKt__StringsJVMKt.equals("Content-Encoding", header.getName(), true)) {
                if (header.getValue() == null) {
                    return "";
                }
                String value = header.getValue();
                Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
                return StringsKt__StringsKt.trim((CharSequence) value).toString();
            }
        }
        return "";
    }

    private final JSONObject b(TypedOutput typedOutput, List<Header> list) {
        try {
            if (StringsKt__StringsJVMKt.equals("gzip", c(list), true)) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                typedOutput.writeTo(byteArrayOutputStream);
                byte[] a2 = u1.a(byteArrayOutputStream.toByteArray());
                Intrinsics.checkNotNullExpressionValue(a2, "decompress(...)");
                Charset forName = Charset.forName("utf-8");
                Intrinsics.checkNotNullExpressionValue(forName, "forName(...)");
                JSONObject jSONObject = new JSONObject(new String(a2, forName));
                byteArrayOutputStream.close();
                return jSONObject;
            }
            if (typedOutput instanceof TypedByteArray) {
                byte[] bytes = ((TypedByteArray) typedOutput).getBytes();
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                Charset forName2 = Charset.forName("utf-8");
                Intrinsics.checkNotNullExpressionValue(forName2, "forName(...)");
                return new JSONObject(new String(bytes, forName2));
            }
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            typedOutput.writeTo(byteArrayOutputStream2);
            byte[] byteArray = byteArrayOutputStream2.toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
            Charset forName3 = Charset.forName("utf-8");
            Intrinsics.checkNotNullExpressionValue(forName3, "forName(...)");
            String str = new String(byteArray, forName3);
            byteArrayOutputStream2.close();
            return new JSONObject(str);
        } catch (Throwable th) {
            d().e("[bodyToJSON] " + th.getMessage(), new Object[0]);
            return new JSONObject();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0052 A[Catch: all -> 0x00c9, TryCatch #1 {all -> 0x00c9, blocks: (B:8:0x001d, B:10:0x0023, B:12:0x002c, B:14:0x0046, B:19:0x0052, B:21:0x005e, B:26:0x006a, B:28:0x0076, B:41:0x00a8, B:31:0x0086, B:34:0x0091, B:39:0x009c), top: B:7:0x001d, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006a A[Catch: all -> 0x00c9, TryCatch #1 {all -> 0x00c9, blocks: (B:8:0x001d, B:10:0x0023, B:12:0x002c, B:14:0x0046, B:19:0x0052, B:21:0x005e, B:26:0x006a, B:28:0x0076, B:41:0x00a8, B:31:0x0086, B:34:0x0091, B:39:0x009c), top: B:7:0x001d, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0076 A[Catch: all -> 0x00c9, TRY_LEAVE, TryCatch #1 {all -> 0x00c9, blocks: (B:8:0x001d, B:10:0x0023, B:12:0x002c, B:14:0x0046, B:19:0x0052, B:21:0x005e, B:26:0x006a, B:28:0x0076, B:41:0x00a8, B:31:0x0086, B:34:0x0091, B:39:0x009c), top: B:7:0x001d, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(java.lang.String r6, java.util.List<com.bytedance.retrofit2.client.Header> r7, com.bytedance.retrofit2.client.Request r8) {
        /*
            r5 = this;
            java.lang.String r0 = "headers"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "request"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            if (r6 == 0) goto Lea
            r0 = 2
            r1 = 0
            java.lang.String r2 = "/novel/commentapi/"
            r3 = 0
            boolean r6 = kotlin.text.StringsKt.contains$default(r6, r2, r3, r0, r1)
            if (r6 == 0) goto Lea
            com.bytedance.retrofit2.mime.TypedOutput r6 = r8.getBody()
            if (r6 == 0) goto Lea
            java.lang.String r8 = r6.mimeType()     // Catch: java.lang.Throwable -> Lc9
            if (r8 == 0) goto Lea
            java.lang.String r0 = "json"
            r1 = 1
            boolean r8 = kotlin.text.StringsKt.contains(r8, r0, r1)     // Catch: java.lang.Throwable -> Lc9
            if (r8 == 0) goto Lea
            ps4.b r8 = ps4.b.a     // Catch: java.lang.Throwable -> Lc9
            org.json.JSONObject r6 = r8.b(r6, r7)     // Catch: java.lang.Throwable -> Lc9
            java.lang.String r8 = "comment_source"
            java.lang.String r8 = r6.optString(r8)     // Catch: java.lang.Throwable -> Lc9
            java.lang.String r0 = "server_channel"
            java.lang.String r0 = r6.optString(r0)     // Catch: java.lang.Throwable -> Lc9
            java.lang.String r2 = "business_param"
            org.json.JSONObject r6 = r6.optJSONObject(r2)     // Catch: java.lang.Throwable -> Lc9
            if (r8 == 0) goto L4f
            int r2 = r8.length()     // Catch: java.lang.Throwable -> Lc9
            if (r2 != 0) goto L4d
            goto L4f
        L4d:
            r2 = 0
            goto L50
        L4f:
            r2 = 1
        L50:
            if (r2 != 0) goto L5c
            com.bytedance.retrofit2.client.Header r2 = new com.bytedance.retrofit2.client.Header     // Catch: java.lang.Throwable -> Lc9
            java.lang.String r4 = "comment-source"
            r2.<init>(r4, r8)     // Catch: java.lang.Throwable -> Lc9
            r7.add(r2)     // Catch: java.lang.Throwable -> Lc9
        L5c:
            if (r0 == 0) goto L67
            int r8 = r0.length()     // Catch: java.lang.Throwable -> Lc9
            if (r8 != 0) goto L65
            goto L67
        L65:
            r8 = 0
            goto L68
        L67:
            r8 = 1
        L68:
            if (r8 != 0) goto L74
            com.bytedance.retrofit2.client.Header r8 = new com.bytedance.retrofit2.client.Header     // Catch: java.lang.Throwable -> Lc9
            java.lang.String r2 = "server-channel"
            r8.<init>(r2, r0)     // Catch: java.lang.Throwable -> Lc9
            r7.add(r8)     // Catch: java.lang.Throwable -> Lc9
        L74:
            if (r6 == 0) goto Lea
            com.dragon.read.saas.ugc.model.UgcCommentChannelEnum r8 = com.dragon.read.saas.ugc.model.UgcCommentChannelEnum.NovelItemCount     // Catch: java.lang.Throwable -> Lc9
            int r8 = r8.getValue()     // Catch: java.lang.Throwable -> Lc9
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch: java.lang.Throwable -> Lc9
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r8)     // Catch: java.lang.Throwable -> Lc9
            if (r8 == 0) goto Lea
            java.lang.String r8 = "req_type"
            int r6 = r6.optInt(r8, r3)     // Catch: java.lang.Throwable -> La7
            java.lang.String r8 = "x-tt-request-tag"
            if (r6 != r1) goto L9c
            com.bytedance.retrofit2.client.Header r6 = new com.bytedance.retrofit2.client.Header     // Catch: java.lang.Throwable -> La7
            java.lang.String r0 = "novel_preload=1"
            r6.<init>(r8, r0)     // Catch: java.lang.Throwable -> La7
            r7.add(r6)     // Catch: java.lang.Throwable -> La7
            goto Lea
        L9c:
            com.bytedance.retrofit2.client.Header r6 = new com.bytedance.retrofit2.client.Header     // Catch: java.lang.Throwable -> La7
            java.lang.String r0 = "novel_preload=0"
            r6.<init>(r8, r0)     // Catch: java.lang.Throwable -> La7
            r7.add(r6)     // Catch: java.lang.Throwable -> La7
            goto Lea
        La7:
            r6 = move-exception
            ps4.b r7 = ps4.b.a     // Catch: java.lang.Throwable -> Lc9
            com.dragon.read.base.util.LogHelper r7 = r7.d()     // Catch: java.lang.Throwable -> Lc9
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc9
            r8.<init>()     // Catch: java.lang.Throwable -> Lc9
            java.lang.String r0 = "[bodyToJSON] "
            r8.append(r0)     // Catch: java.lang.Throwable -> Lc9
            java.lang.String r6 = r6.getMessage()     // Catch: java.lang.Throwable -> Lc9
            r8.append(r6)     // Catch: java.lang.Throwable -> Lc9
            java.lang.String r6 = r8.toString()     // Catch: java.lang.Throwable -> Lc9
            java.lang.Object[] r8 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> Lc9
            r7.e(r6, r8)     // Catch: java.lang.Throwable -> Lc9
            goto Lea
        Lc9:
            r6 = move-exception
            ps4.b r7 = ps4.b.a
            com.dragon.read.base.util.LogHelper r7 = r7.d()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "[tryAppendCommentHeader] "
            r8.append(r0)
            java.lang.String r6 = r6.getMessage()
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            java.lang.Object[] r8 = new java.lang.Object[r3]
            r7.e(r6, r8)
        Lea:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ps4.b.f(java.lang.String, java.util.List, com.bytedance.retrofit2.client.Request):void");
    }
}
