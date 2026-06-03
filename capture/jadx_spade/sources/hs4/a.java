package hs4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.NsCommonDepend;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final int k;
    public final String a;
    public final int b;
    public int c;
    public String d;
    public String e;
    public final int f;
    public int g;
    public final String h;
    public final Map<String, Serializable> i;
    public boolean j;

    static {
        Covode.recordClassIndex(612335);
        k = 8;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(String bizTag, int i, int i2, String str, String str2, int i3) {
        this(bizTag, i, i2, str, str2, i3, 0, null, null, 448, null);
        Intrinsics.checkNotNullParameter(bizTag, "bizTag");
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("biz_tag", this.a);
        jSONObject.putOpt("bind_times", Integer.valueOf(this.c));
        jSONObject.putOpt("tab_type", Integer.valueOf(this.b));
        jSONObject.putOpt("cover_type", this.d);
        jSONObject.putOpt("genre_type", this.e);
        jSONObject.putOpt("image_origin", Integer.valueOf(this.g));
        jSONObject.putOpt("rank", Integer.valueOf(this.f));
        jSONObject.putOpt("image_compress_key", this.h);
        for (Map.Entry<String, Serializable> entry : this.i.entrySet()) {
            jSONObject.putOpt(entry.getKey(), entry.getValue());
        }
        return jSONObject;
    }

    public final Map<String, Object> b() {
        boolean z;
        HashMap hashMap = new HashMap();
        hashMap.put("tab_type", String.valueOf(this.b));
        String str = this.d;
        if (str == null) {
            str = "unknown";
        }
        hashMap.put("cover_type", str);
        hashMap.put("is_mall_stagger_img", String.valueOf(NsCommonDepend.IMPL.isMallStaggerImg(this.a)));
        hashMap.put("biz_tag", this.a);
        String str2 = this.h;
        if (str2 != null && str2.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            hashMap.put("image_compress_key", this.h);
        }
        for (Map.Entry<String, Serializable> entry : this.i.entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue().toString());
        }
        return hashMap;
    }

    public a(String bizTag, int i, int i2, String str, String str2, int i3, int i4, String str3, Map<String, Serializable> extra) {
        Intrinsics.checkNotNullParameter(bizTag, "bizTag");
        Intrinsics.checkNotNullParameter(extra, "extra");
        this.a = bizTag;
        this.b = i;
        this.c = i2;
        this.d = str;
        this.e = str2;
        this.f = i3;
        this.g = i4;
        this.h = str3;
        this.i = extra;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ a(java.lang.String r10, int r11, int r12, java.lang.String r13, java.lang.String r14, int r15, int r16, java.lang.String r17, java.util.Map r18, int r19, kotlin.jvm.internal.DefaultConstructorMarker r20) {
        /*
            r9 = this;
            r0 = r19
            r1 = r0 & 2
            if (r1 == 0) goto L8
            r1 = -1
            goto L9
        L8:
            r1 = r11
        L9:
            r2 = r0 & 4
            r3 = 0
            if (r2 == 0) goto L10
            r2 = 0
            goto L11
        L10:
            r2 = r12
        L11:
            r4 = r0 & 8
            r5 = 0
            if (r4 == 0) goto L18
            r4 = r5
            goto L19
        L18:
            r4 = r13
        L19:
            r6 = r0 & 16
            if (r6 == 0) goto L1f
            r6 = r5
            goto L20
        L1f:
            r6 = r14
        L20:
            r7 = r0 & 32
            if (r7 == 0) goto L25
            goto L26
        L25:
            r3 = r15
        L26:
            r7 = r0 & 64
            if (r7 == 0) goto L2c
            r7 = 1
            goto L2e
        L2c:
            r7 = r16
        L2e:
            r8 = r0 & 128(0x80, float:1.8E-43)
            if (r8 == 0) goto L33
            goto L35
        L33:
            r5 = r17
        L35:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L3f
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            goto L41
        L3f:
            r0 = r18
        L41:
            r11 = r9
            r12 = r10
            r13 = r1
            r14 = r2
            r15 = r4
            r16 = r6
            r17 = r3
            r18 = r7
            r19 = r5
            r20 = r0
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: hs4.a.<init>(java.lang.String, int, int, java.lang.String, java.lang.String, int, int, java.lang.String, java.util.Map, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
