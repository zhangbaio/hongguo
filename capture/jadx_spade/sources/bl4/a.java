package bl4;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.UseStatus;
import com.bytedance.kmp.reading.model.VideoContentType;
import com.bytedance.kmp.ugc.model.x30;
import com.dragon.read.kmp.utils.StringUtilsKt;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class a implements jd4.b {
    public static final int b;
    private boolean a;

    /* renamed from: bl4.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0007a {
        public static final /* synthetic */ int[] a;

        static {
            Covode.recordClassIndex(608043);
            int[] iArr = new int[VideoContentType.values().length];
            try {
                iArr[VideoContentType.ShortSeriesPlay.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VideoContentType.MotionComic.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[VideoContentType.TelePlay.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[VideoContentType.Movie.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[VideoContentType.PUGC.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            a = iArr;
        }
    }

    static {
        Covode.recordClassIndex(608042);
        b = 8;
    }

    public abstract String A();

    public abstract String C();

    public abstract org.jetbrains.compose.resources.b E();

    public abstract String F();

    public abstract String G();

    public abstract String I();

    public abstract List<String> J();

    public abstract String K();

    public abstract String L();

    public VideoContentType M() {
        return null;
    }

    public x30 N() {
        return null;
    }

    public abstract String y();

    public abstract String z();

    public final UseStatus H() {
        return UseStatus.OnlineStatus;
    }

    public boolean isShown() {
        return this.a;
    }

    private final String D() {
        Integer num;
        VideoContentType M = M();
        if (M != null) {
            num = Integer.valueOf(M.getValue());
        } else {
            num = null;
        }
        int value = VideoContentType.UnrealShortPlay.getValue();
        if (num != null && num.intValue() == value) {
            return "playlet";
        }
        int value2 = VideoContentType.UnrealMotionComic.getValue();
        if (num != null && num.intValue() == value2) {
            return "motion_comic";
        }
        return "";
    }

    public String x() {
        Integer num;
        String str;
        VideoContentType M = M();
        if (M != null) {
            num = Integer.valueOf(M.getValue());
        } else {
            num = null;
        }
        int value = VideoContentType.TelePlay.getValue();
        if (num != null && num.intValue() == value) {
            return "电视剧";
        }
        int value2 = VideoContentType.Movie.getValue();
        if (num != null && num.intValue() == value2) {
            return "电影";
        }
        x30 N = N();
        if (N == null || (str = N.a) == null) {
            return "";
        }
        return str;
    }

    public void setShown(boolean z) {
        this.a = z;
    }

    public ym4.a w(int i) {
        return v(i);
    }

    public final String B(VideoContentType videoContentType) {
        int i;
        if (videoContentType == null) {
            i = -1;
        } else {
            i = C0007a.a[videoContentType.ordinal()];
        }
        if (i != 1 && i != 2) {
            if (i != 3) {
                if (i != 4) {
                    if (i != 5) {
                        return "";
                    }
                    return "pugc_material";
                }
                return "movie";
            }
            return "teleplay";
        }
        return "series";
    }

    public final ym4.a v(int i) {
        ym4.k b2 = com.dragon.read.kmp.utils.k0.a.b();
        ym4.a aVar = new ym4.a();
        aVar.j(b2.n());
        aVar.g("rank", Integer.valueOf(i + 1));
        aVar.g("src_material_id", I());
        aVar.g("material_id", z());
        aVar.g("material_type", A());
        aVar.g("related_src_material_id", C());
        String takeIfNotEmpty = StringUtilsKt.takeIfNotEmpty(D());
        if (takeIfNotEmpty != null) {
            aVar.g("reserve_card_type", takeIfNotEmpty);
        }
        return aVar;
    }
}
