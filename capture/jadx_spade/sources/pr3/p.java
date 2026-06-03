package pr3;

import com.bytedance.covode.number.Covode;
import java.io.Serializable;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class p {
    public static final a d;
    public final String a;
    public final long b;
    public final Map<String, Serializable> c;

    static {
        Covode.recordClassIndex(598805);
        d = new a(null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return Intrinsics.areEqual(this.a, pVar.a) && this.b == pVar.b && Intrinsics.areEqual(this.c, pVar.c);
    }

    public int hashCode() {
        int hashCode = ((this.a.hashCode() * 31) + j.a(this.b)) * 31;
        Map<String, Serializable> map = this.c;
        return hashCode + (map == null ? 0 : map.hashCode());
    }

    public String toString() {
        return "TraceNode(nodeName=" + this.a + ", currentTime=" + this.b + ", extraInfo=" + this.c + ')';
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598806);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0046, code lost:
        
            if (r12.equals("video_detail_request_end") == false) goto L57;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:?, code lost:
        
            return "video_select";
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x00a6, code lost:
        
            if (r12.equals("video_episode_select") == false) goto L57;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00b0, code lost:
        
            if (r12.equals("video_drag") == false) goto L57;
         */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
        java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
         */
        /* JADX WARN: Removed duplicated region for block: B:53:0x00b5 A[ORIG_RETURN, RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.String a(java.lang.String r12) {
            /*
                r11 = this;
                java.lang.String r0 = "currentNode"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
                int r0 = r12.hashCode()
                java.lang.String r1 = "engine_renderStart"
                java.lang.String r2 = "business_invoke_engine_play"
                java.lang.String r3 = "video_detail_request_end"
                java.lang.String r4 = "player_fragment_create"
                java.lang.String r5 = "video_page_create"
                java.lang.String r6 = "engine_prepared"
                java.lang.String r7 = "engine_prepare"
                java.lang.String r8 = "video_detail_request_start"
                java.lang.String r9 = "start_play"
                java.lang.String r10 = "video_select"
                switch(r0) {
                    case -1618319752: goto La9;
                    case -1603450876: goto L9f;
                    case -1573262095: goto L96;
                    case -1476799617: goto L8d;
                    case -1315541880: goto L84;
                    case -1288156150: goto L7b;
                    case -1278134886: goto L74;
                    case -685138200: goto L6b;
                    case -9360064: goto L62;
                    case 94750088: goto L55;
                    case 203853933: goto L4a;
                    case 503644801: goto L42;
                    case 873519704: goto L32;
                    case 2119106729: goto L27;
                    default: goto L25;
                }
            L25:
                goto Lb5
            L27:
                boolean r12 = r12.equals(r2)
                if (r12 != 0) goto L2f
                goto Lb5
            L2f:
                r1 = r7
                goto Lb7
            L32:
                java.lang.String r0 = "video_model_request_start"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L3d
                goto Lb5
            L3d:
                java.lang.String r1 = "video_model_request_end"
                goto Lb7
            L42:
                boolean r12 = r12.equals(r3)
                if (r12 != 0) goto Lb3
                goto Lb5
            L4a:
                boolean r12 = r12.equals(r4)
                if (r12 != 0) goto L52
                goto Lb5
            L52:
                r1 = r8
                goto Lb7
            L55:
                java.lang.String r0 = "click"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L5f
                goto Lb5
            L5f:
                r1 = r5
                goto Lb7
            L62:
                boolean r12 = r12.equals(r10)
                if (r12 != 0) goto L69
                goto Lb5
            L69:
                r1 = r9
                goto Lb7
            L6b:
                boolean r12 = r12.equals(r5)
                if (r12 != 0) goto L72
                goto Lb5
            L72:
                r1 = r4
                goto Lb7
            L74:
                boolean r12 = r12.equals(r6)
                if (r12 != 0) goto Lb7
                goto Lb5
            L7b:
                boolean r12 = r12.equals(r7)
                if (r12 != 0) goto L82
                goto Lb5
            L82:
                r1 = r6
                goto Lb7
            L84:
                boolean r12 = r12.equals(r8)
                if (r12 != 0) goto L8b
                goto Lb5
            L8b:
                r1 = r3
                goto Lb7
            L8d:
                java.lang.String r0 = "hide_force_play_view"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto Lb7
                goto Lb5
            L96:
                boolean r12 = r12.equals(r9)
                if (r12 != 0) goto L9d
                goto Lb5
            L9d:
                r1 = r2
                goto Lb7
            L9f:
                java.lang.String r0 = "video_episode_select"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto Lb3
                goto Lb5
            La9:
                java.lang.String r0 = "video_drag"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto Lb3
                goto Lb5
            Lb3:
                r1 = r10
                goto Lb7
            Lb5:
                java.lang.String r1 = ""
            Lb7:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: pr3.p.a.a(java.lang.String):java.lang.String");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public p(String nodeName, long j, Map<String, ? extends Serializable> map) {
        Intrinsics.checkNotNullParameter(nodeName, "nodeName");
        this.a = nodeName;
        this.b = j;
        this.c = map;
    }
}
