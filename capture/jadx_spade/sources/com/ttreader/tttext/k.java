package com.ttreader.tttext;

import android.graphics.Typeface;
import com.bytedance.covode.number.Covode;
import com.ttreader.tttext.TTTextDefinition;
import java.util.Objects;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class k {
    public final String a;
    public final Typeface b;
    public final TTTextDefinition.FontWeight c;
    public final TTTextDefinition.FontStyle d;

    static {
        Covode.recordClassIndex(654798);
    }

    public int hashCode() {
        return Objects.hash(this.b, this.c, this.d);
    }

    public String toString() {
        return "TTFont{family=" + this.a + ", face=" + this.b + ", font_weight=" + this.c + '}';
    }

    public k(Typeface typeface) {
        this("", typeface, TTTextDefinition.FontWeight.kNormal_400);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        if (this.c == kVar.c && this.d == kVar.d && Objects.equals(this.b, kVar.b)) {
            return true;
        }
        return false;
    }

    public k(String str, Typeface typeface) {
        this(str, typeface, TTTextDefinition.FontWeight.kNormal_400);
    }

    public k(String str, Typeface typeface, TTTextDefinition.FontWeight fontWeight) {
        this(str, typeface, fontWeight, TTTextDefinition.FontStyle.kNormal);
    }

    public k(String str, Typeface typeface, TTTextDefinition.FontWeight fontWeight, TTTextDefinition.FontStyle fontStyle) {
        this.a = str;
        this.b = typeface;
        this.c = fontWeight;
        this.d = fontStyle;
    }
}
