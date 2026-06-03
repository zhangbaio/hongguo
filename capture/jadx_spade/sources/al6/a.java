package al6;

import com.bytedance.covode.number.Covode;
import com.xs.fm.player.sdk.component.event.monior.evetnmonitor.BeforeTrackerData;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a {
    private static final bl6.a a;
    private static long b;
    private static String c;
    private static BeforeTrackerData d;
    public static final a e;

    private a() {
    }

    public final void b() {
        d = null;
        b = 0L;
    }

    static {
        Covode.recordClassIndex(655895);
        e = new a();
        a = new bl6.a("PlayBeforeTrackMonitor");
        c = "";
    }

    public final BeforeTrackerData a() {
        BeforeTrackerData beforeTrackerData = new BeforeTrackerData();
        d = beforeTrackerData;
        beforeTrackerData.setJumpAudioPageTime(b);
        BeforeTrackerData beforeTrackerData2 = d;
        if (beforeTrackerData2 != null) {
            beforeTrackerData2.setOpenAudioPageFrom(c);
        }
        a.d("copyBeforeTrackerData " + d, new Object[0]);
        return d;
    }
}
