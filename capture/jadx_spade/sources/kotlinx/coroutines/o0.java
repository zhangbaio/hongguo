package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class o0 implements x0 {
    private final boolean a;

    static {
        Covode.recordClassIndex(658968);
    }

    @Override // kotlinx.coroutines.x0
    public j1 a() {
        return null;
    }

    @Override // kotlinx.coroutines.x0
    public boolean isActive() {
        return this.a;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Empty{");
        if (isActive()) {
            str = "Active";
        } else {
            str = "New";
        }
        sb.append(str);
        sb.append('}');
        return sb.toString();
    }

    public o0(boolean z) {
        this.a = z;
    }
}
