package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* renamed from: com.xiaomi.push.do, reason: invalid class name */
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class Cdo {
    static {
        Covode.recordClassIndex(655452);
    }

    /* renamed from: com.xiaomi.push.do$a */
    public static final class a extends com.xiaomi.push.e {

        /* renamed from: a, reason: collision with other field name */
        private boolean f271a;

        /* renamed from: b, reason: collision with other field name */
        private boolean f274b;

        /* renamed from: c, reason: collision with other field name */
        private boolean f277c;

        /* renamed from: d, reason: collision with other field name */
        private boolean f279d;

        /* renamed from: e, reason: collision with other field name */
        private boolean f281e;

        /* renamed from: f, reason: collision with other field name */
        private boolean f282f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean k;
        private boolean l;
        private boolean m;
        private int a = 0;

        /* renamed from: a, reason: collision with other field name */
        private long f269a = 0;

        /* renamed from: a, reason: collision with other field name */
        private String f270a = "";

        /* renamed from: b, reason: collision with other field name */
        private String f273b = "";

        /* renamed from: c, reason: collision with other field name */
        private String f276c = "";

        /* renamed from: d, reason: collision with other field name */
        private String f278d = "";

        /* renamed from: e, reason: collision with other field name */
        private String f280e = "";
        private int b = 1;
        private int c = 0;
        private int d = 0;
        private String f = "";

        /* renamed from: b, reason: collision with other field name */
        private long f272b = 0;

        /* renamed from: c, reason: collision with other field name */
        private long f275c = 0;
        private int e = -1;

        static {
            Covode.recordClassIndex(655453);
        }

        /* renamed from: a, reason: collision with other method in class */
        public long m285a() {
            return this.f269a;
        }

        /* renamed from: b, reason: collision with other method in class */
        public long m289b() {
            return this.f272b;
        }

        public int c() {
            return this.a;
        }

        public int d() {
            return this.b;
        }

        public int e() {
            return this.c;
        }

        public int f() {
            return this.d;
        }

        public boolean g() {
            return this.g;
        }

        public boolean h() {
            return this.h;
        }

        public boolean i() {
            return this.i;
        }

        public boolean j() {
            return this.j;
        }

        public boolean k() {
            return this.k;
        }

        public boolean l() {
            return this.l;
        }

        public boolean m() {
            return this.m;
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m288a() {
            return this.f271a;
        }

        /* renamed from: a, reason: collision with other method in class */
        public a m286a() {
            this.f282f = false;
            this.f278d = "";
            return this;
        }

        /* renamed from: c, reason: collision with other method in class */
        public long m292c() {
            return this.f275c;
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.e < 0) {
                b();
            }
            return this.e;
        }

        /* renamed from: e, reason: collision with other method in class */
        public String m297e() {
            return this.f280e;
        }

        /* renamed from: f, reason: collision with other method in class */
        public String m299f() {
            return this.f;
        }

        /* renamed from: d, reason: collision with other method in class */
        public String m295d() {
            return this.f278d;
        }

        /* renamed from: e, reason: collision with other method in class */
        public boolean m298e() {
            return this.f281e;
        }

        /* renamed from: f, reason: collision with other method in class */
        public boolean m300f() {
            return this.f282f;
        }

        /* renamed from: b, reason: collision with other method in class */
        public String m290b() {
            return this.f273b;
        }

        /* renamed from: d, reason: collision with other method in class */
        public boolean m296d() {
            return this.f279d;
        }

        /* renamed from: b, reason: collision with other method in class */
        public boolean m291b() {
            return this.f274b;
        }

        /* renamed from: c, reason: collision with other method in class */
        public String m293c() {
            return this.f276c;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int i = 0;
            if (m288a()) {
                i = 0 + com.xiaomi.push.c.a(1, c());
            }
            if (m291b()) {
                i += com.xiaomi.push.c.b(2, m285a());
            }
            if (m294c()) {
                i += com.xiaomi.push.c.a(3, m287a());
            }
            if (m296d()) {
                i += com.xiaomi.push.c.a(4, m290b());
            }
            if (m298e()) {
                i += com.xiaomi.push.c.a(5, m293c());
            }
            if (m300f()) {
                i += com.xiaomi.push.c.a(6, m295d());
            }
            if (g()) {
                i += com.xiaomi.push.c.a(7, m297e());
            }
            if (h()) {
                i += com.xiaomi.push.c.a(8, d());
            }
            if (i()) {
                i += com.xiaomi.push.c.a(9, e());
            }
            if (j()) {
                i += com.xiaomi.push.c.a(10, f());
            }
            if (k()) {
                i += com.xiaomi.push.c.a(11, m299f());
            }
            if (l()) {
                i += com.xiaomi.push.c.b(12, m289b());
            }
            if (m()) {
                i += com.xiaomi.push.c.b(13, m292c());
            }
            this.e = i;
            return i;
        }

        /* renamed from: c, reason: collision with other method in class */
        public boolean m294c() {
            return this.f277c;
        }

        /* renamed from: a, reason: collision with other method in class */
        public String m287a() {
            return this.f270a;
        }

        public a b(int i) {
            this.h = true;
            this.b = i;
            return this;
        }

        public a d(int i) {
            this.j = true;
            this.d = i;
            return this;
        }

        public a e(String str) {
            this.g = true;
            this.f280e = str;
            return this;
        }

        public a f(String str) {
            this.k = true;
            this.f = str;
            return this;
        }

        public a b(long j) {
            this.l = true;
            this.f272b = j;
            return this;
        }

        public a c(int i) {
            this.i = true;
            this.c = i;
            return this;
        }

        public a d(String str) {
            this.f282f = true;
            this.f278d = str;
            return this;
        }

        public a a(int i) {
            this.f271a = true;
            this.a = i;
            return this;
        }

        public a b(String str) {
            this.f279d = true;
            this.f273b = str;
            return this;
        }

        public a c(long j) {
            this.m = true;
            this.f275c = j;
            return this;
        }

        public a a(long j) {
            this.f274b = true;
            this.f269a = j;
            return this;
        }

        public a c(String str) {
            this.f281e = true;
            this.f276c = str;
            return this;
        }

        public a a(String str) {
            this.f277c = true;
            this.f270a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public a a(com.xiaomi.push.b bVar) {
            while (true) {
                int m167a = bVar.m167a();
                switch (m167a) {
                    case 0:
                        return this;
                    case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                        a(bVar.m176b());
                        break;
                    case 16:
                        a(bVar.m177b());
                        break;
                    case ConstantsAPI.COMMAND_OPEN_BUSINESS_VIEW /* 26 */:
                        a(bVar.m170a());
                        break;
                    case ConstantsAPI.COMMAND_FINDER_OPEN_PROFILE /* 34 */:
                        b(bVar.m170a());
                        break;
                    case 42:
                        c(bVar.m170a());
                        break;
                    case 50:
                        d(bVar.m170a());
                        break;
                    case 58:
                        e(bVar.m170a());
                        break;
                    case 64:
                        b(bVar.m176b());
                        break;
                    case 72:
                        c(bVar.m176b());
                        break;
                    case 80:
                        d(bVar.m176b());
                        break;
                    case 90:
                        f(bVar.m170a());
                        break;
                    case 96:
                        b(bVar.m177b());
                        break;
                    case 104:
                        c(bVar.m177b());
                        break;
                    default:
                        if (!a(bVar, m167a)) {
                            return this;
                        }
                        break;
                }
            }
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m288a()) {
                cVar.m202a(1, c());
            }
            if (m291b()) {
                cVar.m216b(2, m285a());
            }
            if (m294c()) {
                cVar.m206a(3, m287a());
            }
            if (m296d()) {
                cVar.m206a(4, m290b());
            }
            if (m298e()) {
                cVar.m206a(5, m293c());
            }
            if (m300f()) {
                cVar.m206a(6, m295d());
            }
            if (g()) {
                cVar.m206a(7, m297e());
            }
            if (h()) {
                cVar.m202a(8, d());
            }
            if (i()) {
                cVar.m202a(9, e());
            }
            if (j()) {
                cVar.m202a(10, f());
            }
            if (k()) {
                cVar.m206a(11, m299f());
            }
            if (l()) {
                cVar.m216b(12, m289b());
            }
            if (m()) {
                cVar.m216b(13, m292c());
            }
        }
    }

    /* renamed from: com.xiaomi.push.do$b */
    public static final class b extends com.xiaomi.push.e {

        /* renamed from: a, reason: collision with other field name */
        private boolean f283a;

        /* renamed from: c, reason: collision with other field name */
        private boolean f285c;

        /* renamed from: d, reason: collision with other field name */
        private boolean f286d;
        private boolean e;

        /* renamed from: b, reason: collision with other field name */
        private boolean f284b = false;
        private int a = 0;
        private int b = 0;
        private int c = 0;
        private int d = -1;

        static {
            Covode.recordClassIndex(655454);
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m301a() {
            return this.f284b;
        }

        /* renamed from: b, reason: collision with other method in class */
        public boolean m302b() {
            return this.f283a;
        }

        public int c() {
            return this.a;
        }

        public int d() {
            return this.b;
        }

        public int e() {
            return this.c;
        }

        /* renamed from: d, reason: collision with other method in class */
        public boolean m304d() {
            return this.f286d;
        }

        /* renamed from: e, reason: collision with other method in class */
        public boolean m305e() {
            return this.e;
        }

        /* renamed from: c, reason: collision with other method in class */
        public boolean m303c() {
            return this.f285c;
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.d < 0) {
                b();
            }
            return this.d;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int i = 0;
            if (m302b()) {
                i = 0 + com.xiaomi.push.c.a(1, m301a());
            }
            if (m303c()) {
                i += com.xiaomi.push.c.a(3, c());
            }
            if (m304d()) {
                i += com.xiaomi.push.c.a(4, d());
            }
            if (m305e()) {
                i += com.xiaomi.push.c.a(5, e());
            }
            this.d = i;
            return i;
        }

        public b a(int i) {
            this.f285c = true;
            this.a = i;
            return this;
        }

        public b b(int i) {
            this.f286d = true;
            this.b = i;
            return this;
        }

        public b c(int i) {
            this.e = true;
            this.c = i;
            return this;
        }

        public static b a(byte[] bArr) {
            return (b) new b().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public b a(com.xiaomi.push.b bVar) {
            while (true) {
                int m167a = bVar.m167a();
                if (m167a != 0) {
                    if (m167a != 8) {
                        if (m167a != 24) {
                            if (m167a != 32) {
                                if (m167a != 40) {
                                    if (!a(bVar, m167a)) {
                                        return this;
                                    }
                                } else {
                                    c(bVar.m176b());
                                }
                            } else {
                                b(bVar.m176b());
                            }
                        } else {
                            a(bVar.m176b());
                        }
                    } else {
                        a(bVar.m173a());
                    }
                } else {
                    return this;
                }
            }
        }

        public b a(boolean z) {
            this.f283a = true;
            this.f284b = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m302b()) {
                cVar.m207a(1, m301a());
            }
            if (m303c()) {
                cVar.m202a(3, c());
            }
            if (m304d()) {
                cVar.m202a(4, d());
            }
            if (m305e()) {
                cVar.m202a(5, e());
            }
        }
    }

    /* renamed from: com.xiaomi.push.do$c */
    public static final class c extends com.xiaomi.push.e {

        /* renamed from: a, reason: collision with other field name */
        private boolean f288a;

        /* renamed from: b, reason: collision with other field name */
        private boolean f289b;

        /* renamed from: c, reason: collision with other field name */
        private boolean f290c;

        /* renamed from: d, reason: collision with other field name */
        private boolean f291d;

        /* renamed from: e, reason: collision with other field name */
        private boolean f292e;

        /* renamed from: f, reason: collision with other field name */
        private boolean f293f;

        /* renamed from: a, reason: collision with other field name */
        private String f287a = "";
        private String b = "";
        private String c = "";
        private String d = "";
        private String e = "";
        private String f = "";
        private int a = -1;

        static {
            Covode.recordClassIndex(655455);
        }

        /* renamed from: a, reason: collision with other method in class */
        public String m306a() {
            return this.f287a;
        }

        /* renamed from: b, reason: collision with other method in class */
        public String m308b() {
            return this.b;
        }

        public String c() {
            return this.c;
        }

        public String d() {
            return this.d;
        }

        public String e() {
            return this.e;
        }

        public String f() {
            return this.f;
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.a < 0) {
                b();
            }
            return this.a;
        }

        /* renamed from: b, reason: collision with other method in class */
        public boolean m309b() {
            return this.f289b;
        }

        /* renamed from: c, reason: collision with other method in class */
        public boolean m310c() {
            return this.f290c;
        }

        /* renamed from: d, reason: collision with other method in class */
        public boolean m311d() {
            return this.f291d;
        }

        /* renamed from: e, reason: collision with other method in class */
        public boolean m312e() {
            return this.f292e;
        }

        /* renamed from: f, reason: collision with other method in class */
        public boolean m313f() {
            return this.f293f;
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m307a() {
            return this.f288a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int i = 0;
            if (m307a()) {
                i = 0 + com.xiaomi.push.c.a(1, m306a());
            }
            if (m309b()) {
                i += com.xiaomi.push.c.a(2, m308b());
            }
            if (m310c()) {
                i += com.xiaomi.push.c.a(3, c());
            }
            if (m311d()) {
                i += com.xiaomi.push.c.a(4, d());
            }
            if (m312e()) {
                i += com.xiaomi.push.c.a(5, e());
            }
            if (m313f()) {
                i += com.xiaomi.push.c.a(6, f());
            }
            this.a = i;
            return i;
        }

        public c a(String str) {
            this.f288a = true;
            this.f287a = str;
            return this;
        }

        public c b(String str) {
            this.f289b = true;
            this.b = str;
            return this;
        }

        public c c(String str) {
            this.f290c = true;
            this.c = str;
            return this;
        }

        public c d(String str) {
            this.f291d = true;
            this.d = str;
            return this;
        }

        public c e(String str) {
            this.f292e = true;
            this.e = str;
            return this;
        }

        public c f(String str) {
            this.f293f = true;
            this.f = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public c a(com.xiaomi.push.b bVar) {
            while (true) {
                int m167a = bVar.m167a();
                if (m167a != 0) {
                    if (m167a != 10) {
                        if (m167a != 18) {
                            if (m167a != 26) {
                                if (m167a != 34) {
                                    if (m167a != 42) {
                                        if (m167a != 50) {
                                            if (!a(bVar, m167a)) {
                                                return this;
                                            }
                                        } else {
                                            f(bVar.m170a());
                                        }
                                    } else {
                                        e(bVar.m170a());
                                    }
                                } else {
                                    d(bVar.m170a());
                                }
                            } else {
                                c(bVar.m170a());
                            }
                        } else {
                            b(bVar.m170a());
                        }
                    } else {
                        a(bVar.m170a());
                    }
                } else {
                    return this;
                }
            }
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m307a()) {
                cVar.m206a(1, m306a());
            }
            if (m309b()) {
                cVar.m206a(2, m308b());
            }
            if (m310c()) {
                cVar.m206a(3, c());
            }
            if (m311d()) {
                cVar.m206a(4, d());
            }
            if (m312e()) {
                cVar.m206a(5, e());
            }
            if (m313f()) {
                cVar.m206a(6, f());
            }
        }
    }

    /* renamed from: com.xiaomi.push.do$d */
    public static final class d extends com.xiaomi.push.e {

        /* renamed from: a, reason: collision with other field name */
        private boolean f295a;

        /* renamed from: c, reason: collision with other field name */
        private boolean f297c;
        private boolean d;
        private boolean e;

        /* renamed from: b, reason: collision with other field name */
        private boolean f296b = false;

        /* renamed from: a, reason: collision with other field name */
        private String f294a = "";
        private String b = "";
        private String c = "";
        private int a = -1;

        static {
            Covode.recordClassIndex(655456);
        }

        /* renamed from: a, reason: collision with other method in class */
        public String m314a() {
            return this.f294a;
        }

        /* renamed from: b, reason: collision with other method in class */
        public String m316b() {
            return this.b;
        }

        public String c() {
            return this.c;
        }

        public boolean d() {
            return this.d;
        }

        public boolean e() {
            return this.e;
        }

        /* renamed from: b, reason: collision with other method in class */
        public boolean m317b() {
            return this.f295a;
        }

        /* renamed from: c, reason: collision with other method in class */
        public boolean m318c() {
            return this.f297c;
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.a < 0) {
                b();
            }
            return this.a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int i = 0;
            if (m317b()) {
                i = 0 + com.xiaomi.push.c.a(1, m315a());
            }
            if (m318c()) {
                i += com.xiaomi.push.c.a(2, m314a());
            }
            if (d()) {
                i += com.xiaomi.push.c.a(3, m316b());
            }
            if (e()) {
                i += com.xiaomi.push.c.a(4, c());
            }
            this.a = i;
            return i;
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m315a() {
            return this.f296b;
        }

        public d a(String str) {
            this.f297c = true;
            this.f294a = str;
            return this;
        }

        public d b(String str) {
            this.d = true;
            this.b = str;
            return this;
        }

        public d c(String str) {
            this.e = true;
            this.c = str;
            return this;
        }

        public static d a(byte[] bArr) {
            return (d) new d().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public d a(com.xiaomi.push.b bVar) {
            while (true) {
                int m167a = bVar.m167a();
                if (m167a != 0) {
                    if (m167a != 8) {
                        if (m167a != 18) {
                            if (m167a != 26) {
                                if (m167a != 34) {
                                    if (!a(bVar, m167a)) {
                                        return this;
                                    }
                                } else {
                                    c(bVar.m170a());
                                }
                            } else {
                                b(bVar.m170a());
                            }
                        } else {
                            a(bVar.m170a());
                        }
                    } else {
                        a(bVar.m173a());
                    }
                } else {
                    return this;
                }
            }
        }

        public d a(boolean z) {
            this.f295a = true;
            this.f296b = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m317b()) {
                cVar.m207a(1, m315a());
            }
            if (m318c()) {
                cVar.m206a(2, m314a());
            }
            if (d()) {
                cVar.m206a(3, m316b());
            }
            if (e()) {
                cVar.m206a(4, c());
            }
        }
    }

    /* renamed from: com.xiaomi.push.do$e */
    public static final class e extends com.xiaomi.push.e {

        /* renamed from: a, reason: collision with other field name */
        private com.xiaomi.push.a f298a;

        /* renamed from: a, reason: collision with other field name */
        private boolean f301a;

        /* renamed from: b, reason: collision with other field name */
        private com.xiaomi.push.a f302b;

        /* renamed from: b, reason: collision with other field name */
        private boolean f304b;

        /* renamed from: c, reason: collision with other field name */
        private boolean f306c;
        private int d;

        /* renamed from: d, reason: collision with other field name */
        private boolean f308d;
        private int e;

        /* renamed from: e, reason: collision with other field name */
        private boolean f310e;

        /* renamed from: f, reason: collision with other field name */
        private boolean f311f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean k;
        private boolean l;
        private boolean m;
        private int a = 0;

        /* renamed from: a, reason: collision with other field name */
        private String f300a = "";

        /* renamed from: b, reason: collision with other field name */
        private String f303b = "";

        /* renamed from: c, reason: collision with other field name */
        private String f305c = "";
        private int b = 0;

        /* renamed from: d, reason: collision with other field name */
        private String f307d = "";

        /* renamed from: e, reason: collision with other field name */
        private String f309e = "";
        private String f = "";

        /* renamed from: a, reason: collision with other field name */
        private b f299a = null;
        private int c = 0;

        static {
            Covode.recordClassIndex(655457);
        }

        /* renamed from: a, reason: collision with other method in class */
        public com.xiaomi.push.a m319a() {
            return this.f298a;
        }

        /* renamed from: b, reason: collision with other method in class */
        public com.xiaomi.push.a m323b() {
            return this.f302b;
        }

        public int c() {
            return this.a;
        }

        public int d() {
            return this.b;
        }

        public int e() {
            return this.c;
        }

        public int f() {
            return this.d;
        }

        public boolean g() {
            return this.g;
        }

        public boolean h() {
            return this.h;
        }

        public boolean i() {
            return this.i;
        }

        public boolean j() {
            return this.j;
        }

        public boolean k() {
            return this.k;
        }

        public boolean l() {
            return this.l;
        }

        public boolean m() {
            return this.m;
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m322a() {
            return this.f301a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m322a()) {
                cVar.m215b(1, c());
            }
            if (m325b()) {
                cVar.m206a(2, m321a());
            }
            if (m327c()) {
                cVar.m206a(3, m324b());
            }
            if (m329d()) {
                cVar.m206a(4, m326c());
            }
            if (m331e()) {
                cVar.m202a(5, d());
            }
            if (m333f()) {
                cVar.m206a(6, m328d());
            }
            if (g()) {
                cVar.m206a(7, m330e());
            }
            if (h()) {
                cVar.m206a(8, m332f());
            }
            if (i()) {
                cVar.m205a(9, (com.xiaomi.push.e) m320a());
            }
            if (j()) {
                cVar.m202a(10, e());
            }
            if (k()) {
                cVar.m204a(11, m319a());
            }
            if (l()) {
                cVar.m204a(12, m323b());
            }
            if (m()) {
                cVar.m202a(13, f());
            }
        }

        /* renamed from: a, reason: collision with other method in class */
        public b m320a() {
            return this.f299a;
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.e < 0) {
                b();
            }
            return this.e;
        }

        /* renamed from: e, reason: collision with other method in class */
        public String m330e() {
            return this.f309e;
        }

        /* renamed from: f, reason: collision with other method in class */
        public String m332f() {
            return this.f;
        }

        /* renamed from: c, reason: collision with other method in class */
        public String m326c() {
            return this.f305c;
        }

        /* renamed from: d, reason: collision with other method in class */
        public String m328d() {
            return this.f307d;
        }

        /* renamed from: e, reason: collision with other method in class */
        public boolean m331e() {
            return this.f310e;
        }

        /* renamed from: f, reason: collision with other method in class */
        public boolean m333f() {
            return this.f311f;
        }

        public e() {
            com.xiaomi.push.a aVar = com.xiaomi.push.a.a;
            this.f298a = aVar;
            this.f302b = aVar;
            this.d = 0;
            this.e = -1;
        }

        /* renamed from: b, reason: collision with other method in class */
        public String m324b() {
            return this.f303b;
        }

        /* renamed from: c, reason: collision with other method in class */
        public boolean m327c() {
            return this.f306c;
        }

        /* renamed from: d, reason: collision with other method in class */
        public boolean m329d() {
            return this.f308d;
        }

        /* renamed from: b, reason: collision with other method in class */
        public boolean m325b() {
            return this.f304b;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int i = 0;
            if (m322a()) {
                i = 0 + com.xiaomi.push.c.b(1, c());
            }
            if (m325b()) {
                i += com.xiaomi.push.c.a(2, m321a());
            }
            if (m327c()) {
                i += com.xiaomi.push.c.a(3, m324b());
            }
            if (m329d()) {
                i += com.xiaomi.push.c.a(4, m326c());
            }
            if (m331e()) {
                i += com.xiaomi.push.c.a(5, d());
            }
            if (m333f()) {
                i += com.xiaomi.push.c.a(6, m328d());
            }
            if (g()) {
                i += com.xiaomi.push.c.a(7, m330e());
            }
            if (h()) {
                i += com.xiaomi.push.c.a(8, m332f());
            }
            if (i()) {
                i += com.xiaomi.push.c.a(9, (com.xiaomi.push.e) m320a());
            }
            if (j()) {
                i += com.xiaomi.push.c.a(10, e());
            }
            if (k()) {
                i += com.xiaomi.push.c.a(11, m319a());
            }
            if (l()) {
                i += com.xiaomi.push.c.a(12, m323b());
            }
            if (m()) {
                i += com.xiaomi.push.c.a(13, f());
            }
            this.e = i;
            return i;
        }

        /* renamed from: a, reason: collision with other method in class */
        public String m321a() {
            return this.f300a;
        }

        public e b(int i) {
            this.f310e = true;
            this.b = i;
            return this;
        }

        public e c(int i) {
            this.j = true;
            this.c = i;
            return this;
        }

        public e d(int i) {
            this.m = true;
            this.d = i;
            return this;
        }

        public e e(String str) {
            this.g = true;
            this.f309e = str;
            return this;
        }

        public e f(String str) {
            this.h = true;
            this.f = str;
            return this;
        }

        public e b(com.xiaomi.push.a aVar) {
            this.l = true;
            this.f302b = aVar;
            return this;
        }

        public e c(String str) {
            this.f308d = true;
            this.f305c = str;
            return this;
        }

        public e d(String str) {
            this.f311f = true;
            this.f307d = str;
            return this;
        }

        public e a(int i) {
            this.f301a = true;
            this.a = i;
            return this;
        }

        public e b(String str) {
            this.f306c = true;
            this.f303b = str;
            return this;
        }

        public e a(com.xiaomi.push.a aVar) {
            this.k = true;
            this.f298a = aVar;
            return this;
        }

        public e a(b bVar) {
            if (bVar != null) {
                this.i = true;
                this.f299a = bVar;
                return this;
            }
            throw null;
        }

        @Override // com.xiaomi.push.e
        public e a(com.xiaomi.push.b bVar) {
            while (true) {
                int m167a = bVar.m167a();
                switch (m167a) {
                    case 0:
                        return this;
                    case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                        a(bVar.c());
                        break;
                    case 18:
                        a(bVar.m170a());
                        break;
                    case ConstantsAPI.COMMAND_OPEN_BUSINESS_VIEW /* 26 */:
                        b(bVar.m170a());
                        break;
                    case ConstantsAPI.COMMAND_FINDER_OPEN_PROFILE /* 34 */:
                        c(bVar.m170a());
                        break;
                    case 40:
                        b(bVar.m176b());
                        break;
                    case 50:
                        d(bVar.m170a());
                        break;
                    case 58:
                        e(bVar.m170a());
                        break;
                    case 66:
                        f(bVar.m170a());
                        break;
                    case 74:
                        b bVar2 = new b();
                        bVar.a(bVar2);
                        a(bVar2);
                        break;
                    case 80:
                        c(bVar.m176b());
                        break;
                    case 90:
                        a(bVar.m169a());
                        break;
                    case 98:
                        b(bVar.m169a());
                        break;
                    case 104:
                        d(bVar.m176b());
                        break;
                    default:
                        if (!a(bVar, m167a)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public e a(String str) {
            this.f304b = true;
            this.f300a = str;
            return this;
        }
    }

    /* renamed from: com.xiaomi.push.do$f */
    public static final class f extends com.xiaomi.push.e {

        /* renamed from: a, reason: collision with other field name */
        private boolean f314a;

        /* renamed from: b, reason: collision with other field name */
        private boolean f315b;
        private boolean c;

        /* renamed from: a, reason: collision with other field name */
        private String f313a = "";
        private String b = "";

        /* renamed from: a, reason: collision with other field name */
        private b f312a = null;
        private int a = -1;

        static {
            Covode.recordClassIndex(655458);
        }

        /* renamed from: a, reason: collision with other method in class */
        public b m334a() {
            return this.f312a;
        }

        /* renamed from: b, reason: collision with other method in class */
        public String m337b() {
            return this.b;
        }

        public boolean c() {
            return this.c;
        }

        /* renamed from: b, reason: collision with other method in class */
        public boolean m338b() {
            return this.f315b;
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.a < 0) {
                b();
            }
            return this.a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int i = 0;
            if (m336a()) {
                i = 0 + com.xiaomi.push.c.a(1, m335a());
            }
            if (m338b()) {
                i += com.xiaomi.push.c.a(2, m337b());
            }
            if (c()) {
                i += com.xiaomi.push.c.a(3, (com.xiaomi.push.e) m334a());
            }
            this.a = i;
            return i;
        }

        /* renamed from: a, reason: collision with other method in class */
        public String m335a() {
            return this.f313a;
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m336a() {
            return this.f314a;
        }

        public f a(String str) {
            this.f314a = true;
            this.f313a = str;
            return this;
        }

        public f b(String str) {
            this.f315b = true;
            this.b = str;
            return this;
        }

        public static f a(byte[] bArr) {
            return (f) new f().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public f a(com.xiaomi.push.b bVar) {
            while (true) {
                int m167a = bVar.m167a();
                if (m167a != 0) {
                    if (m167a != 10) {
                        if (m167a != 18) {
                            if (m167a != 26) {
                                if (!a(bVar, m167a)) {
                                    return this;
                                }
                            } else {
                                b bVar2 = new b();
                                bVar.a(bVar2);
                                a(bVar2);
                            }
                        } else {
                            b(bVar.m170a());
                        }
                    } else {
                        a(bVar.m170a());
                    }
                } else {
                    return this;
                }
            }
        }

        public f a(b bVar) {
            if (bVar != null) {
                this.c = true;
                this.f312a = bVar;
                return this;
            }
            throw null;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m336a()) {
                cVar.m206a(1, m335a());
            }
            if (m338b()) {
                cVar.m206a(2, m337b());
            }
            if (c()) {
                cVar.m205a(3, (com.xiaomi.push.e) m334a());
            }
        }
    }

    /* renamed from: com.xiaomi.push.do$g */
    public static final class g extends com.xiaomi.push.e {

        /* renamed from: a, reason: collision with other field name */
        private boolean f317a;

        /* renamed from: b, reason: collision with other field name */
        private boolean f318b;

        /* renamed from: c, reason: collision with other field name */
        private boolean f319c;

        /* renamed from: a, reason: collision with other field name */
        private String f316a = "";
        private String b = "";
        private String c = "";
        private int a = -1;

        static {
            Covode.recordClassIndex(655459);
        }

        /* renamed from: a, reason: collision with other method in class */
        public String m339a() {
            return this.f316a;
        }

        /* renamed from: b, reason: collision with other method in class */
        public String m341b() {
            return this.b;
        }

        public String c() {
            return this.c;
        }

        /* renamed from: b, reason: collision with other method in class */
        public boolean m342b() {
            return this.f318b;
        }

        /* renamed from: c, reason: collision with other method in class */
        public boolean m343c() {
            return this.f319c;
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.a < 0) {
                b();
            }
            return this.a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int i = 0;
            if (m340a()) {
                i = 0 + com.xiaomi.push.c.a(1, m339a());
            }
            if (m342b()) {
                i += com.xiaomi.push.c.a(2, m341b());
            }
            if (m343c()) {
                i += com.xiaomi.push.c.a(3, c());
            }
            this.a = i;
            return i;
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m340a() {
            return this.f317a;
        }

        public g a(String str) {
            this.f317a = true;
            this.f316a = str;
            return this;
        }

        public g b(String str) {
            this.f318b = true;
            this.b = str;
            return this;
        }

        public g c(String str) {
            this.f319c = true;
            this.c = str;
            return this;
        }

        public static g a(byte[] bArr) {
            return (g) new g().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public g a(com.xiaomi.push.b bVar) {
            while (true) {
                int m167a = bVar.m167a();
                if (m167a != 0) {
                    if (m167a != 10) {
                        if (m167a != 18) {
                            if (m167a != 26) {
                                if (!a(bVar, m167a)) {
                                    return this;
                                }
                            } else {
                                c(bVar.m170a());
                            }
                        } else {
                            b(bVar.m170a());
                        }
                    } else {
                        a(bVar.m170a());
                    }
                } else {
                    return this;
                }
            }
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m340a()) {
                cVar.m206a(1, m339a());
            }
            if (m342b()) {
                cVar.m206a(2, m341b());
            }
            if (m343c()) {
                cVar.m206a(3, c());
            }
        }
    }

    /* renamed from: com.xiaomi.push.do$h */
    public static final class h extends com.xiaomi.push.e {

        /* renamed from: a, reason: collision with other field name */
        private boolean f321a;

        /* renamed from: b, reason: collision with other field name */
        private boolean f322b;
        private int a = 0;

        /* renamed from: a, reason: collision with other field name */
        private String f320a = "";
        private int b = -1;

        static {
            Covode.recordClassIndex(655460);
        }

        /* renamed from: a, reason: collision with other method in class */
        public String m344a() {
            return this.f320a;
        }

        /* renamed from: b, reason: collision with other method in class */
        public boolean m346b() {
            return this.f322b;
        }

        public int c() {
            return this.a;
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.b < 0) {
                b();
            }
            return this.b;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int i = 0;
            if (m345a()) {
                i = 0 + com.xiaomi.push.c.a(1, c());
            }
            if (m346b()) {
                i += com.xiaomi.push.c.a(2, m344a());
            }
            this.b = i;
            return i;
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m345a() {
            return this.f321a;
        }

        public h a(int i) {
            this.f321a = true;
            this.a = i;
            return this;
        }

        public static h a(byte[] bArr) {
            return (h) new h().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public h a(com.xiaomi.push.b bVar) {
            while (true) {
                int m167a = bVar.m167a();
                if (m167a != 0) {
                    if (m167a != 8) {
                        if (m167a != 18) {
                            if (!a(bVar, m167a)) {
                                return this;
                            }
                        } else {
                            a(bVar.m170a());
                        }
                    } else {
                        a(bVar.m176b());
                    }
                } else {
                    return this;
                }
            }
        }

        public h a(String str) {
            this.f322b = true;
            this.f320a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m345a()) {
                cVar.m202a(1, c());
            }
            if (m346b()) {
                cVar.m206a(2, m344a());
            }
        }
    }

    /* renamed from: com.xiaomi.push.do$i */
    public static final class i extends com.xiaomi.push.e {

        /* renamed from: a, reason: collision with other field name */
        private boolean f324a;

        /* renamed from: a, reason: collision with other field name */
        private com.xiaomi.push.a f323a = com.xiaomi.push.a.a;
        private int a = -1;

        static {
            Covode.recordClassIndex(655461);
        }

        /* renamed from: a, reason: collision with other method in class */
        public com.xiaomi.push.a m347a() {
            return this.f323a;
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.a < 0) {
                b();
            }
            return this.a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int i = 0;
            if (m348a()) {
                i = 0 + com.xiaomi.push.c.a(1, m347a());
            }
            this.a = i;
            return i;
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m348a() {
            return this.f324a;
        }

        public i a(com.xiaomi.push.a aVar) {
            this.f324a = true;
            this.f323a = aVar;
            return this;
        }

        public static i a(byte[] bArr) {
            return (i) new i().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public i a(com.xiaomi.push.b bVar) {
            while (true) {
                int m167a = bVar.m167a();
                if (m167a != 0) {
                    if (m167a != 10) {
                        if (!a(bVar, m167a)) {
                            return this;
                        }
                    } else {
                        a(bVar.m169a());
                    }
                } else {
                    return this;
                }
            }
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m348a()) {
                cVar.m204a(1, m347a());
            }
        }
    }

    /* renamed from: com.xiaomi.push.do$j */
    public static final class j extends com.xiaomi.push.e {

        /* renamed from: a, reason: collision with other field name */
        private boolean f327a;
        private boolean b;

        /* renamed from: a, reason: collision with other field name */
        private com.xiaomi.push.a f325a = com.xiaomi.push.a.a;

        /* renamed from: a, reason: collision with other field name */
        private b f326a = null;
        private int a = -1;

        static {
            Covode.recordClassIndex(655462);
        }

        /* renamed from: a, reason: collision with other method in class */
        public com.xiaomi.push.a m349a() {
            return this.f325a;
        }

        /* renamed from: b, reason: collision with other method in class */
        public boolean m352b() {
            return this.b;
        }

        /* renamed from: a, reason: collision with other method in class */
        public b m350a() {
            return this.f326a;
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.a < 0) {
                b();
            }
            return this.a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int i = 0;
            if (m351a()) {
                i = 0 + com.xiaomi.push.c.a(1, m349a());
            }
            if (m352b()) {
                i += com.xiaomi.push.c.a(2, (com.xiaomi.push.e) m350a());
            }
            this.a = i;
            return i;
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m351a() {
            return this.f327a;
        }

        public static j a(byte[] bArr) {
            return (j) new j().a(bArr);
        }

        public j a(com.xiaomi.push.a aVar) {
            this.f327a = true;
            this.f325a = aVar;
            return this;
        }

        @Override // com.xiaomi.push.e
        public j a(com.xiaomi.push.b bVar) {
            while (true) {
                int m167a = bVar.m167a();
                if (m167a != 0) {
                    if (m167a != 10) {
                        if (m167a != 18) {
                            if (!a(bVar, m167a)) {
                                return this;
                            }
                        } else {
                            b bVar2 = new b();
                            bVar.a(bVar2);
                            a(bVar2);
                        }
                    } else {
                        a(bVar.m169a());
                    }
                } else {
                    return this;
                }
            }
        }

        public j a(b bVar) {
            if (bVar != null) {
                this.b = true;
                this.f326a = bVar;
                return this;
            }
            throw null;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m351a()) {
                cVar.m204a(1, m349a());
            }
            if (m352b()) {
                cVar.m205a(2, (com.xiaomi.push.e) m350a());
            }
        }
    }

    /* renamed from: com.xiaomi.push.do$k */
    public static final class k extends com.xiaomi.push.e {

        /* renamed from: a, reason: collision with other field name */
        private boolean f330a;

        /* renamed from: b, reason: collision with other field name */
        private boolean f333b;
        private boolean c;
        private boolean d;
        private boolean e;
        private boolean g;

        /* renamed from: a, reason: collision with other field name */
        private String f329a = "";

        /* renamed from: b, reason: collision with other field name */
        private String f332b = "";

        /* renamed from: a, reason: collision with other field name */
        private long f328a = 0;

        /* renamed from: b, reason: collision with other field name */
        private long f331b = 0;
        private boolean f = false;
        private int a = 0;
        private int b = -1;

        static {
            Covode.recordClassIndex(655463);
        }

        /* renamed from: a, reason: collision with other method in class */
        public long m353a() {
            return this.f328a;
        }

        /* renamed from: b, reason: collision with other method in class */
        public long m356b() {
            return this.f331b;
        }

        public int c() {
            return this.a;
        }

        public boolean d() {
            return this.d;
        }

        public boolean e() {
            return this.f;
        }

        public boolean f() {
            return this.e;
        }

        public boolean g() {
            return this.g;
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m355a() {
            return this.f330a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m355a()) {
                cVar.m206a(1, m354a());
            }
            if (m358b()) {
                cVar.m206a(2, m357b());
            }
            if (m359c()) {
                cVar.m203a(3, m353a());
            }
            if (d()) {
                cVar.m203a(4, m356b());
            }
            if (f()) {
                cVar.m207a(5, e());
            }
            if (g()) {
                cVar.m202a(6, c());
            }
        }

        /* renamed from: c, reason: collision with other method in class */
        public boolean m359c() {
            return this.c;
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.b < 0) {
                b();
            }
            return this.b;
        }

        /* renamed from: b, reason: collision with other method in class */
        public String m357b() {
            return this.f332b;
        }

        /* renamed from: b, reason: collision with other method in class */
        public boolean m358b() {
            return this.f333b;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int i = 0;
            if (m355a()) {
                i = 0 + com.xiaomi.push.c.a(1, m354a());
            }
            if (m358b()) {
                i += com.xiaomi.push.c.a(2, m357b());
            }
            if (m359c()) {
                i += com.xiaomi.push.c.a(3, m353a());
            }
            if (d()) {
                i += com.xiaomi.push.c.a(4, m356b());
            }
            if (f()) {
                i += com.xiaomi.push.c.a(5, e());
            }
            if (g()) {
                i += com.xiaomi.push.c.a(6, c());
            }
            this.b = i;
            return i;
        }

        /* renamed from: a, reason: collision with other method in class */
        public String m354a() {
            return this.f329a;
        }

        public k a(int i) {
            this.g = true;
            this.a = i;
            return this;
        }

        public k b(long j) {
            this.d = true;
            this.f331b = j;
            return this;
        }

        public static k a(byte[] bArr) {
            return (k) new k().a(bArr);
        }

        public k b(String str) {
            this.f333b = true;
            this.f332b = str;
            return this;
        }

        public k a(long j) {
            this.c = true;
            this.f328a = j;
            return this;
        }

        @Override // com.xiaomi.push.e
        public k a(com.xiaomi.push.b bVar) {
            while (true) {
                int m167a = bVar.m167a();
                if (m167a != 0) {
                    if (m167a != 10) {
                        if (m167a != 18) {
                            if (m167a != 24) {
                                if (m167a != 32) {
                                    if (m167a != 40) {
                                        if (m167a != 48) {
                                            if (!a(bVar, m167a)) {
                                                return this;
                                            }
                                        } else {
                                            a(bVar.m176b());
                                        }
                                    } else {
                                        a(bVar.m173a());
                                    }
                                } else {
                                    b(bVar.m168a());
                                }
                            } else {
                                a(bVar.m168a());
                            }
                        } else {
                            b(bVar.m170a());
                        }
                    } else {
                        a(bVar.m170a());
                    }
                } else {
                    return this;
                }
            }
        }

        public k a(String str) {
            this.f330a = true;
            this.f329a = str;
            return this;
        }

        public k a(boolean z) {
            this.e = true;
            this.f = z;
            return this;
        }
    }
}
