package pl4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.rpc.kmp.community.model.ProfileTab;
import kotlin.jvm.internal.Intrinsics;
import wl4.b;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a extends b {
    public static final int f;
    private String e;

    static {
        Covode.recordClassIndex(608143);
        f = 8;
    }

    @Override // wl4.b, wl4.a
    public boolean d() {
        return true;
    }

    @Override // wl4.b, wl4.a
    public String g() {
        return "smart_hot_desc";
    }

    @Override // wl4.b, wl4.a
    public ProfileTab e() {
        return ProfileTab.Select;
    }

    @Override // wl4.b, wl4.a
    public String a() {
        String str = this.e;
        this.e = null;
        return str;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(String str, String actorName) {
        super(true, actorName);
        Intrinsics.checkNotNullParameter(actorName, "actorName");
        this.e = str;
    }
}
