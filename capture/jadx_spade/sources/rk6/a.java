package rk6;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a {
    public String a;
    public String b;
    public String[] c;
    public boolean d;
    public int e;
    public InterfaceC0256a f;
    public String g;
    public b h;
    public int i;
    public int j;
    public String k;
    public String l;

    /* renamed from: rk6.a$a, reason: collision with other inner class name */
    public interface InterfaceC0256a {
        void startPlay();
    }

    static {
        Covode.recordClassIndex(655841);
    }

    public a(String str, String str2, b bVar) {
        this.i = -1;
        this.k = "other";
        this.a = str;
        this.g = str2;
        this.h = bVar;
    }

    public a(String str, String str2, String str3, b bVar) {
        this(str, str3, bVar);
        this.b = str2;
    }
}
