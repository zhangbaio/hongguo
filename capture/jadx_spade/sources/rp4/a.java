package rp4;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public final int a;

    static {
        Covode.recordClassIndex(609366);
    }

    public final a a(int i) {
        return new a(i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.a == ((a) obj).a;
    }

    public int hashCode() {
        return this.a;
    }

    public String toString() {
        return "StoryUiState(currentTheme=" + this.a + ')';
    }

    public a(int i) {
        this.a = i;
    }
}
