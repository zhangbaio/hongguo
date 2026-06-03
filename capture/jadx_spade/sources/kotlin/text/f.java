package kotlin.text;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class f {
    public static final b d;
    private static final f e;
    private static final f f;
    public final boolean a;
    public final a b;
    public final c c;

    public static final class a {
        public static final C0207a j;
        private static final a k;
        public final int a;
        public final int b;
        public final String c;
        public final String d;
        public final String e;
        public final String f;
        public final boolean g;
        public final boolean h;
        public final boolean i;

        /* renamed from: kotlin.text.f$a$a, reason: collision with other inner class name */
        public static final class C0207a {
            static {
                Covode.recordClassIndex(658754);
            }

            private C0207a() {
            }

            public /* synthetic */ C0207a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final a a() {
                return a.k;
            }
        }

        static {
            Covode.recordClassIndex(658752);
            j = new C0207a(null);
            k = new a(Integer.MAX_VALUE, Integer.MAX_VALUE, "  ", "", "", "");
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("BytesHexFormat(");
            sb.append('\n');
            b(sb, "    ").append('\n');
            sb.append(")");
            return sb.toString();
        }

        public final StringBuilder b(StringBuilder sb, String indent) {
            Intrinsics.checkNotNullParameter(sb, "sb");
            Intrinsics.checkNotNullParameter(indent, "indent");
            sb.append(indent);
            sb.append("bytesPerLine = ");
            sb.append(this.a);
            sb.append(",");
            sb.append('\n');
            sb.append(indent);
            sb.append("bytesPerGroup = ");
            sb.append(this.b);
            sb.append(",");
            sb.append('\n');
            sb.append(indent);
            sb.append("groupSeparator = \"");
            sb.append(this.c);
            sb.append("\",");
            sb.append('\n');
            sb.append(indent);
            sb.append("byteSeparator = \"");
            sb.append(this.d);
            sb.append("\",");
            sb.append('\n');
            sb.append(indent);
            sb.append("bytePrefix = \"");
            sb.append(this.e);
            sb.append("\",");
            sb.append('\n');
            sb.append(indent);
            sb.append("byteSuffix = \"");
            sb.append(this.f);
            sb.append("\"");
            return sb;
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0068, code lost:
        
            if (r4 != false) goto L29;
         */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0058  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public a(int r4, int r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9) {
            /*
                r3 = this;
                java.lang.String r0 = "groupSeparator"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                java.lang.String r0 = "byteSeparator"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                java.lang.String r0 = "bytePrefix"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
                java.lang.String r0 = "byteSuffix"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
                r3.<init>()
                r3.a = r4
                r3.b = r5
                r3.c = r6
                r3.d = r7
                r3.e = r8
                r3.f = r9
                r0 = 0
                r1 = 1
                r2 = 2147483647(0x7fffffff, float:NaN)
                if (r4 != r2) goto L2e
                if (r5 != r2) goto L2e
                r4 = 1
                goto L2f
            L2e:
                r4 = 0
            L2f:
                r3.g = r4
                int r4 = r8.length()
                if (r4 != 0) goto L39
                r4 = 1
                goto L3a
            L39:
                r4 = 0
            L3a:
                if (r4 == 0) goto L4f
                int r4 = r9.length()
                if (r4 != 0) goto L44
                r4 = 1
                goto L45
            L44:
                r4 = 0
            L45:
                if (r4 == 0) goto L4f
                int r4 = r7.length()
                if (r4 > r1) goto L4f
                r4 = 1
                goto L50
            L4f:
                r4 = 0
            L50:
                r3.h = r4
                boolean r4 = kotlin.text.g.a(r6)
                if (r4 != 0) goto L6a
                boolean r4 = kotlin.text.g.a(r7)
                if (r4 != 0) goto L6a
                boolean r4 = kotlin.text.g.a(r8)
                if (r4 != 0) goto L6a
                boolean r4 = kotlin.text.g.a(r9)
                if (r4 == 0) goto L6b
            L6a:
                r0 = 1
            L6b:
                r3.i = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.text.f.a.<init>(int, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
        }
    }

    public static final class c {
        public static final a h;
        private static final c i;
        public final String a;
        public final String b;
        public final boolean c;
        public final int d;
        public final boolean e;
        public final boolean f;
        public final boolean g;

        public static final class a {
            static {
                Covode.recordClassIndex(658758);
            }

            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final c a() {
                return c.i;
            }
        }

        static {
            Covode.recordClassIndex(658756);
            h = new a(null);
            i = new c("", "", false, 1);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("NumberHexFormat(");
            sb.append('\n');
            b(sb, "    ").append('\n');
            sb.append(")");
            return sb.toString();
        }

        public final StringBuilder b(StringBuilder sb, String indent) {
            Intrinsics.checkNotNullParameter(sb, "sb");
            Intrinsics.checkNotNullParameter(indent, "indent");
            sb.append(indent);
            sb.append("prefix = \"");
            sb.append(this.a);
            sb.append("\",");
            sb.append('\n');
            sb.append(indent);
            sb.append("suffix = \"");
            sb.append(this.b);
            sb.append("\",");
            sb.append('\n');
            sb.append(indent);
            sb.append("removeLeadingZeros = ");
            sb.append(this.c);
            sb.append(',');
            sb.append('\n');
            sb.append(indent);
            sb.append("minLength = ");
            sb.append(this.d);
            return sb;
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0045, code lost:
        
            if (r3 != false) goto L23;
         */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public c(java.lang.String r3, java.lang.String r4, boolean r5, int r6) {
            /*
                r2 = this;
                java.lang.String r0 = "prefix"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                java.lang.String r0 = "suffix"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                r2.<init>()
                r2.a = r3
                r2.b = r4
                r2.c = r5
                r2.d = r6
                int r5 = r3.length()
                r0 = 0
                r1 = 1
                if (r5 != 0) goto L1f
                r5 = 1
                goto L20
            L1f:
                r5 = 0
            L20:
                if (r5 == 0) goto L2f
                int r5 = r4.length()
                if (r5 != 0) goto L2a
                r5 = 1
                goto L2b
            L2a:
                r5 = 0
            L2b:
                if (r5 == 0) goto L2f
                r5 = 1
                goto L30
            L2f:
                r5 = 0
            L30:
                r2.e = r5
                if (r5 == 0) goto L38
                if (r6 != r1) goto L38
                r5 = 1
                goto L39
            L38:
                r5 = 0
            L39:
                r2.f = r5
                boolean r3 = kotlin.text.g.a(r3)
                if (r3 != 0) goto L47
                boolean r3 = kotlin.text.g.a(r4)
                if (r3 == 0) goto L48
            L47:
                r0 = 1
            L48:
                r2.g = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.text.f.c.<init>(java.lang.String, java.lang.String, boolean, int):void");
        }
    }

    public static final class b {
        static {
            Covode.recordClassIndex(658755);
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final f a() {
            return f.e;
        }
    }

    static {
        Covode.recordClassIndex(658750);
        d = new b(null);
        a.C0207a c0207a = a.j;
        a a2 = c0207a.a();
        c.a aVar = c.h;
        e = new f(false, a2, aVar.a());
        f = new f(true, c0207a.a(), aVar.a());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HexFormat(");
        sb.append('\n');
        sb.append("    upperCase = ");
        sb.append(this.a);
        sb.append(",");
        sb.append('\n');
        sb.append("    bytes = BytesHexFormat(");
        sb.append('\n');
        this.b.b(sb, "        ").append('\n');
        sb.append("    ),");
        sb.append('\n');
        sb.append("    number = NumberHexFormat(");
        sb.append('\n');
        this.c.b(sb, "        ").append('\n');
        sb.append("    )");
        sb.append('\n');
        sb.append(")");
        return sb.toString();
    }

    public f(boolean z, a bytes, c number) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(number, "number");
        this.a = z;
        this.b = bytes;
        this.c = number;
    }
}
