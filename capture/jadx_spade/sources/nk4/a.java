package nk4;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.VideoContentType;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final a a;

    /* renamed from: nk4.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0245a {
        public static final /* synthetic */ int[] a;

        static {
            Covode.recordClassIndex(607903);
            int[] iArr = new int[VideoContentType.values().length];
            try {
                iArr[VideoContentType.ExpertRecommendBook.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VideoContentType.ShortSeriesPlay.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[VideoContentType.ScenePlay.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[VideoContentType.PPTRecommendBook.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[VideoContentType.Movie.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[VideoContentType.TelePlay.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[VideoContentType.ShortPlay.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[VideoContentType.DropMaterial.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[VideoContentType.PUGC.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[VideoContentType.Album.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[VideoContentType.MotionComic.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            a = iArr;
        }
    }

    static {
        Covode.recordClassIndex(607902);
        a = new a();
    }

    private a() {
    }

    public final String a(VideoContentType videoContentType) {
        if (videoContentType != null) {
            switch (C0245a.a[videoContentType.ordinal()]) {
            }
            return "";
        }
        return "";
    }
}
