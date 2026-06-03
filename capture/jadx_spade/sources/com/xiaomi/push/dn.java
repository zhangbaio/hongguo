package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class dn {
    static {
        Covode.recordClassIndex(655450);
    }

    public static final class a extends e {

        /* renamed from: a, reason: collision with other field name */
        private boolean f266a;

        /* renamed from: b, reason: collision with other field name */
        private boolean f267b;
        private boolean d;
        private boolean e;
        private int a = 0;

        /* renamed from: c, reason: collision with other field name */
        private boolean f268c = false;
        private int b = 0;
        private boolean f = false;

        /* renamed from: a, reason: collision with other field name */
        private List<String> f265a = Collections.emptyList();
        private int c = -1;

        static {
            Covode.recordClassIndex(655451);
        }

        /* renamed from: a, reason: collision with other method in class */
        public List<String> m279a() {
            return this.f265a;
        }

        /* renamed from: b, reason: collision with other method in class */
        public boolean m281b() {
            return this.f268c;
        }

        public int c() {
            return this.a;
        }

        public int d() {
            return this.b;
        }

        /* renamed from: e, reason: collision with other method in class */
        public boolean m284e() {
            return this.f;
        }

        public boolean f() {
            return this.e;
        }

        /* renamed from: c, reason: collision with other method in class */
        public boolean m282c() {
            return this.f267b;
        }

        /* renamed from: d, reason: collision with other method in class */
        public boolean m283d() {
            return this.d;
        }

        public int e() {
            return this.f265a.size();
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.c < 0) {
                b();
            }
            return this.c;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int i;
            int i2 = 0;
            if (m280a()) {
                i = c.b(1, c()) + 0;
            } else {
                i = 0;
            }
            if (m282c()) {
                i += c.a(2, m281b());
            }
            if (m283d()) {
                i += c.a(3, d());
            }
            if (f()) {
                i += c.a(4, m284e());
            }
            Iterator<String> it2 = m279a().iterator();
            while (it2.hasNext()) {
                i2 += c.a(it2.next());
            }
            int size = i + i2 + (m279a().size() * 1);
            this.c = size;
            return size;
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m280a() {
            return this.f266a;
        }

        public a a(int i) {
            this.f266a = true;
            this.a = i;
            return this;
        }

        public a b(int i) {
            this.d = true;
            this.b = i;
            return this;
        }

        public static a a(byte[] bArr) {
            return (a) new a().a(bArr);
        }

        public static a b(b bVar) {
            return new a().a(bVar);
        }

        public a b(boolean z) {
            this.e = true;
            this.f = z;
            return this;
        }

        public a a(String str) {
            if (str != null) {
                if (this.f265a.isEmpty()) {
                    this.f265a = new ArrayList();
                }
                this.f265a.add(str);
                return this;
            }
            throw null;
        }

        @Override // com.xiaomi.push.e
        public a a(b bVar) {
            while (true) {
                int m167a = bVar.m167a();
                if (m167a != 0) {
                    if (m167a != 8) {
                        if (m167a != 16) {
                            if (m167a != 24) {
                                if (m167a != 32) {
                                    if (m167a != 42) {
                                        if (!a(bVar, m167a)) {
                                            return this;
                                        }
                                    } else {
                                        a(bVar.m170a());
                                    }
                                } else {
                                    b(bVar.m173a());
                                }
                            } else {
                                b(bVar.m176b());
                            }
                        } else {
                            a(bVar.m173a());
                        }
                    } else {
                        a(bVar.c());
                    }
                } else {
                    return this;
                }
            }
        }

        public a a(boolean z) {
            this.f267b = true;
            this.f268c = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(c cVar) {
            if (m280a()) {
                cVar.m215b(1, c());
            }
            if (m282c()) {
                cVar.m207a(2, m281b());
            }
            if (m283d()) {
                cVar.m202a(3, d());
            }
            if (f()) {
                cVar.m207a(4, m284e());
            }
            Iterator<String> it2 = m279a().iterator();
            while (it2.hasNext()) {
                cVar.m206a(5, it2.next());
            }
        }
    }
}
