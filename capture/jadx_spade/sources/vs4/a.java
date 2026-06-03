package vs4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.util.DebugManager;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final a a;

    static {
        Covode.recordClassIndex(612528);
        a = new a();
    }

    private a() {
    }

    public static final boolean f() {
        return DebugManager.inst().isEnableNpsAllGenreThresholdDebug();
    }

    public static final long a() {
        if (!f()) {
            return 600000L;
        }
        return (long) (DebugManager.inst().getNpsAllGenreAudioConsumeTimeThreshold() * 60 * 1000);
    }

    public static final long b() {
        if (!f()) {
            return 600000L;
        }
        return (long) (DebugManager.inst().getNpsAllGenreReaderReadTimeThresholdMinute() * 60 * 1000);
    }

    public static final float c() {
        if (!f()) {
            return 0.2f;
        }
        return DebugManager.inst().getNpsAllGenreShortSeriesProgressThreshold();
    }

    public static final float d() {
        if (!f()) {
            return 0.2f;
        }
        return DebugManager.inst().getNpsAllGenreShortStoryProgressThreshold();
    }

    public static final long e() {
        if (!f()) {
            return 300000L;
        }
        return (long) (DebugManager.inst().getNpsAllGenreVideoConsumeTimeThresholdMinute() * 60 * 1000);
    }
}
