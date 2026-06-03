package vs4;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.covode.number.Covode;
import com.dragon.read.NsCommonDepend;
import com.dragon.read.app.ActivityRecordManager;
import com.dragon.read.base.Args;
import com.dragon.read.nps.ui.NpsFeedbackDialogFragment;
import com.dragon.read.nps.ui.NpsPopDialogFragment;
import com.dragon.read.nps.ui.NpsPopMemoryCache;
import com.dragon.read.rpc.model.UserResearchData;
import com.dragon.read.widget.BottomPopupContainerActivity;
import com.dragon.reader.lib.ReaderClient;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f {
    public static final f a;

    public interface a {
        void a();
    }

    static {
        Covode.recordClassIndex(612546);
        a = new f();
    }

    private f() {
    }

    public static final class c implements NpsPopDialogFragment.a {
        final /* synthetic */ UserResearchData a;

        @Override // com.dragon.read.nps.ui.NpsPopDialogFragment.a
        public void onCommit() {
        }

        @Override // com.dragon.read.nps.ui.NpsPopDialogFragment.a
        public Args h() {
            return new Args();
        }

        @Override // com.dragon.read.nps.ui.NpsPopDialogFragment.a
        public long a() {
            Long todayReadingTime = NsCommonDepend.IMPL.getTodayReadingTime();
            Intrinsics.checkNotNullExpressionValue(todayReadingTime, "getTodayReadingTime(...)");
            return todayReadingTime.longValue();
        }

        @Override // com.dragon.read.nps.ui.NpsPopDialogFragment.a
        public long b() {
            Long todayAudioTime = NsCommonDepend.IMPL.getTodayAudioTime();
            Intrinsics.checkNotNullExpressionValue(todayAudioTime, "getTodayAudioTime(...)");
            return todayAudioTime.longValue();
        }

        @Override // com.dragon.read.nps.ui.NpsPopDialogFragment.a
        public String getPosition() {
            Integer num = this.a.scene;
            if (num == null) {
                num = 0;
            }
            return p.a.a().get(num);
        }

        c(UserResearchData userResearchData) {
            this.a = userResearchData;
        }
    }

    public static final class d implements BottomPopupContainerActivity.b {
        final /* synthetic */ UserResearchData a;
        final /* synthetic */ ReaderClient b;
        final /* synthetic */ Ref$ObjectRef<NpsPopDialogFragment.a> c;
        final /* synthetic */ boolean d;
        final /* synthetic */ a e;

        public boolean a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return false;
        }

        public void onCreate(Bundle bundle) {
        }

        public void onDestroy() {
            a aVar = this.e;
            if (aVar != null) {
                aVar.a();
            }
            NpsPopMemoryCache.a.a();
            r rVar = r.a;
            rVar.w();
            rVar.a();
        }

        public Fragment c(BottomPopupContainerActivity.c listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            return new NpsPopDialogFragment(this.a, this.b, this.c.element, this.d);
        }

        public void b(BottomPopupContainerActivity activity, Bundle bundle) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            FrameLayout frameLayout = (FrameLayout) activity.findViewById(2131820917);
            if (frameLayout != null) {
                frameLayout.setFitsSystemWindows(false);
            }
        }

        d(UserResearchData userResearchData, ReaderClient readerClient, Ref$ObjectRef<NpsPopDialogFragment.a> ref$ObjectRef, boolean z, a aVar) {
            this.a = userResearchData;
            this.b = readerClient;
            this.c = ref$ObjectRef;
            this.d = z;
            this.e = aVar;
        }
    }

    public static final class b implements BottomPopupContainerActivity.b {
        final /* synthetic */ UserResearchData a;
        final /* synthetic */ NpsFeedbackDialogFragment.a b;

        public boolean a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return false;
        }

        public void b(BottomPopupContainerActivity activity, Bundle bundle) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(bundle, "bundle");
        }

        public void onCreate(Bundle bundle) {
        }

        public void onDestroy() {
        }

        public Fragment c(BottomPopupContainerActivity.c listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            return new NpsFeedbackDialogFragment(this.a, this.b);
        }

        b(UserResearchData userResearchData, NpsFeedbackDialogFragment.a aVar) {
            this.a = userResearchData;
            this.b = aVar;
        }
    }

    public final void a(UserResearchData data, NpsFeedbackDialogFragment.a npsListener) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(npsListener, "npsListener");
        b bVar = new b(data, npsListener);
        Intent intent = new Intent(ActivityRecordManager.inst().getCurrentActivity(), (Class<?>) BottomPopupContainerActivity.class);
        BottomPopupContainerActivity.i.a(bVar);
        intent.addFlags(268435456);
        Activity currentActivity = ActivityRecordManager.inst().getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.startActivity(intent);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v3, types: [T, vs4.f$c] */
    public final boolean b(UserResearchData data, ReaderClient readerClient, NpsPopDialogFragment.a aVar, a aVar2, boolean z) {
        Intrinsics.checkNotNullParameter(data, "data");
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = aVar;
        if (aVar == 0) {
            ref$ObjectRef.element = new c(data);
        }
        if (readerClient != null) {
            r.a.l();
        }
        d dVar = new d(data, readerClient, ref$ObjectRef, z, aVar2);
        Intent intent = new Intent(ActivityRecordManager.inst().getCurrentActivity(), (Class<?>) BottomPopupContainerActivity.class);
        BottomPopupContainerActivity.i.a(dVar);
        intent.addFlags(268435456);
        Activity currentActivity = ActivityRecordManager.inst().getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.startActivity(intent);
            return true;
        }
        return true;
    }

    public static /* synthetic */ boolean c(f fVar, UserResearchData userResearchData, ReaderClient readerClient, NpsPopDialogFragment.a aVar, a aVar2, boolean z, int i, Object obj) {
        NpsPopDialogFragment.a aVar3;
        a aVar4;
        boolean z2;
        if ((i & 4) != 0) {
            aVar3 = null;
        } else {
            aVar3 = aVar;
        }
        if ((i & 8) != 0) {
            aVar4 = null;
        } else {
            aVar4 = aVar2;
        }
        if ((i & 16) != 0) {
            z2 = false;
        } else {
            z2 = z;
        }
        return fVar.b(userResearchData, readerClient, aVar3, aVar4, z2);
    }
}
