package sk4;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d {
    static {
        Covode.recordClassIndex(607987);
    }

    public static final class a implements qk6.b {
        final /* synthetic */ c a;

        @Override // qk6.b
        public String a() {
            return this.a.a();
        }

        @Override // qk6.b
        public void b() {
            this.a.b();
        }

        @Override // qk6.b
        public boolean interceptAutoPlayNext() {
            return this.a.interceptAutoPlayNext();
        }

        @Override // qk6.b
        public rk6.a c() {
            uk4.b c = this.a.c();
            if (c != null) {
                return uk4.d.a(c);
            }
            return null;
        }

        a(c cVar) {
            this.a = cVar;
        }
    }

    public static final qk6.b a(c cVar) {
        if (cVar != null) {
            return new a(cVar);
        }
        return null;
    }
}
