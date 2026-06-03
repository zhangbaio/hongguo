package com.dragon.read.component.shortvideo.brickservice;

import androidx.compose.animation.m;
import br3.e;
import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ServiceManager;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface BSConfigService extends IService {
    public static final a Companion;

    static {
        Covode.recordClassIndex(598956);
        Companion = a.a;
    }

    String detailTagJumpModuleName(String str);

    boolean enableDetailCategoryConfigColdStartExposure();

    boolean enableFQNewUserOpt();

    boolean enableFullScreenLoginAnimOpt();

    boolean enableNewUserOpt();

    boolean enableNewUserOptV711();

    boolean enableOnlyPreloadSeriesXml();

    boolean enableReportShowTabOnHotStart();

    void exposeConfigEnterSinglePlayer();

    void exposeConfigOnColdStart();

    e<?> getNpsSeriesDataProvider();

    c getVideoCollectToastConfig();

    boolean ifSeriesDeliverUserRevert();

    boolean isItemActionThickStyle();

    boolean isShortSeriesNeedBold();

    boolean isSupportResolutionAction();

    boolean isSupportUgcCollect();

    public static final class a {
        static final /* synthetic */ a a;
        private static final BSConfigService b;

        private a() {
        }

        public final BSConfigService a() {
            return b;
        }

        static {
            Covode.recordClassIndex(598957);
            a = new a();
            b = (BSConfigService) ServiceManager.getService(BSConfigService.class);
        }
    }

    public static final class b {
        static {
            Covode.recordClassIndex(598958);
        }

        public static boolean a(BSConfigService bSConfigService) {
            return false;
        }

        public static c b(BSConfigService bSConfigService) {
            boolean z = false;
            return new c(z, z, 3, null);
        }
    }

    public static final class c {
        public final boolean a;
        public final boolean b;

        static {
            Covode.recordClassIndex(598959);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public c() {
            /*
                r3 = this;
                r0 = 3
                r1 = 0
                r2 = 0
                r3.<init>(r2, r2, r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.component.shortvideo.brickservice.BSConfigService.c.<init>():void");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.a == cVar.a && this.b == cVar.b;
        }

        public int hashCode() {
            return (m.a(this.a) * 31) + m.a(this.b);
        }

        public String toString() {
            return "VideoCollectToastConfigV629(enable=" + this.a + ", enableButton=" + this.b + ')';
        }

        public c(boolean z, boolean z2) {
            this.a = z;
            this.b = z2;
        }

        public /* synthetic */ c(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2);
        }
    }
}
