package us4;

import android.os.Bundle;
import com.bytedance.covode.number.Covode;
import com.dragon.read.app.App;
import com.dragon.read.rpc.model.VideoContentType;
import com.ss.android.videoshop.mediaview.SimpleMediaView;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class e {
    static {
        Covode.recordClassIndex(612511);
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[VideoContentType.values().length];
            a = iArr;
            try {
                iArr[VideoContentType.TelePlay.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[VideoContentType.Movie.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[VideoContentType.ShortSeriesPlay.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[VideoContentType.ScenePlay.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static String c(SimpleMediaView simpleMediaView) {
        if ("position_book_mall_stagger".equals(a(simpleMediaView))) {
            return "position_book_mall_stagger";
        }
        return "";
    }

    public static boolean d(SimpleMediaView simpleMediaView) {
        return "position_book_detail".equals(a(simpleMediaView));
    }

    public static boolean e(SimpleMediaView simpleMediaView) {
        return "position_book_mall".equals(a(simpleMediaView));
    }

    public static String a(SimpleMediaView simpleMediaView) {
        String str;
        Bundle bundle;
        if (simpleMediaView == null) {
            return "";
        }
        if (simpleMediaView.getPlayEntity() == null || (bundle = simpleMediaView.getPlayEntity().getBundle()) == null) {
            str = "";
        } else {
            str = (String) bundle.get("video_position");
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public static String b(VideoContentType videoContentType, boolean z) {
        if (videoContentType == null) {
            return "";
        }
        int i = a.a[videoContentType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4 || !z) {
                        return "";
                    }
                    return App.context().getResources().getString(2131107997);
                }
                return App.context().getResources().getString(2131107997);
            }
            return App.context().getResources().getString(2131107999);
        }
        return App.context().getResources().getString(2131108000);
    }
}
