package com.dragon.read.component.shortvideo.api.model;

import com.bytedance.covode.number.Covode;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

@Target({ElementType.TYPE, ElementType.PARAMETER, ElementType.TYPE_USE})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.TYPE})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public @interface LoginGuideScene {
    public static final a Companion;

    static {
        Covode.recordClassIndex(598775);
        Companion = a.a;
    }

    public static final class a {
        static final /* synthetic */ a a;

        static {
            Covode.recordClassIndex(598776);
            a = new a();
        }

        private a() {
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
        java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
         */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0044 A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0047 A[ORIG_RETURN, RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.String a(java.lang.String r2) {
            /*
                r1 = this;
                java.lang.String r0 = "scene"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                int r0 = r2.hashCode()
                switch(r0) {
                    case -1425775204: goto L3a;
                    case -1363168855: goto L2e;
                    case -408413369: goto L25;
                    case 3321751: goto L19;
                    case 949444906: goto Ld;
                    default: goto Lc;
                }
            Lc:
                goto L47
            Ld:
                java.lang.String r0 = "collect"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L16
                goto L47
            L16:
                java.lang.String r2 = "collect_src_material"
                goto L49
            L19:
                java.lang.String r0 = "like"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L22
                goto L47
            L22:
                java.lang.String r2 = "like_src_material"
                goto L49
            L25:
                java.lang.String r0 = "cold_start"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L44
                goto L47
            L2e:
                java.lang.String r0 = "mine_tab"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L37
                goto L47
            L37:
                java.lang.String r2 = "mine_tab_guide"
                goto L49
            L3a:
                java.lang.String r0 = "ucenter_cold_start"
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L44
                goto L47
            L44:
                java.lang.String r2 = "coldstart_login_guide"
                goto L49
            L47:
                java.lang.String r2 = ""
            L49:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.component.shortvideo.api.model.LoginGuideScene.a.a(java.lang.String):java.lang.String");
        }
    }
}
