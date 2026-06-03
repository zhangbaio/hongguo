package com.dragon.read.nps;

import com.bytedance.covode.number.Covode;
import com.dragon.read.rpc.model.ResearchSceneType;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class NpsBookMallModel implements Serializable {
    public static final int $stable;
    public static final a Companion;
    private static final long serialVersionUID = -6537823437234L;
    private boolean isShown;
    private ResearchSceneType scene = ResearchSceneType.BookStoreMainFeed;

    public static final class a {
        static {
            Covode.recordClassIndex(612545);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(612544);
        Companion = new a(null);
        $stable = 8;
    }

    public final ResearchSceneType getScene() {
        return this.scene;
    }

    public final boolean isShown() {
        return this.isShown;
    }

    public final void setShown(boolean z) {
        this.isShown = z;
    }

    public final void setScene(ResearchSceneType sceneType) {
        Intrinsics.checkNotNullParameter(sceneType, "sceneType");
        this.scene = sceneType;
    }
}
