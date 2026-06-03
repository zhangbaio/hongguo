package com.ttreader.tthtmlparser;

import com.bytedance.covode.number.Covode;
import com.ttreader.tthtmlparser.TTEpubDefinition;
import com.ttreader.tttext.IRunDelegate;
import com.ttreader.tttext.e;
import com.ttreader.tttext.g;
import com.ttreader.tttext.s;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTEpubUtils {
    static {
        Covode.recordClassIndex(654753);
    }

    public static void SetDpi(float f) {
        s.c(f);
    }

    public static float Dp2Px(float f) {
        return s.a(f);
    }

    public static float Px2Dp(float f) {
        return s.b(f);
    }

    public static boolean CheckLinkPressed(long j, int i) {
        TTEpubChapter FindChapterByInstance = TTEpubChapter.FindChapterByInstance(j);
        if (FindChapterByInstance == null) {
            return false;
        }
        return FindChapterByInstance.GetResourceManager().g(i).c();
    }

    public static boolean GetDelegateHide(long j, int i) {
        TTEpubChapter FindChapterByInstance = TTEpubChapter.FindChapterByInstance(j);
        if (FindChapterByInstance == null) {
            return false;
        }
        IRunDelegate h = FindChapterByInstance.GetResourceManager().h(i);
        if (h == null) {
            return true;
        }
        return h.Hide();
    }

    public static int[] GetFootnoteState(long j, int i) {
        int[] iArr = new int[2];
        TTEpubChapter FindChapterByInstance = TTEpubChapter.FindChapterByInstance(j);
        if (FindChapterByInstance == null) {
            iArr[0] = TTEpubDefinition.LinkStyle.kNone.ordinal();
            iArr[1] = 0;
        } else {
            e f = FindChapterByInstance.GetResourceManager().f(i);
            if (f == null) {
                iArr[0] = TTEpubDefinition.LinkStyle.kNone.ordinal();
            } else {
                iArr[0] = f.b().ordinal();
                iArr[1] = f.a();
            }
        }
        return iArr;
    }

    public static int[] GetLinkState(long j, int i) {
        int[] iArr = new int[3];
        TTEpubChapter FindChapterByInstance = TTEpubChapter.FindChapterByInstance(j);
        if (FindChapterByInstance == null) {
            iArr[0] = TTEpubDefinition.LinkStyle.kNone.ordinal();
            iArr[1] = 0;
            iArr[2] = 0;
        } else {
            g g = FindChapterByInstance.GetResourceManager().g(i);
            if (g == null) {
                iArr[0] = TTEpubDefinition.LinkStyle.kNone.ordinal();
            } else {
                iArr[0] = g.b().ordinal();
                iArr[1] = g.a();
                iArr[2] = g.d();
            }
        }
        return iArr;
    }

    public static float[] GetRunDelegateState(long j, int i) {
        IRunDelegate h;
        float f;
        float[] fArr = new float[4];
        TTEpubChapter FindChapterByInstance = TTEpubChapter.FindChapterByInstance(j);
        if (FindChapterByInstance != null && (h = FindChapterByInstance.GetResourceManager().h(i)) != null) {
            fArr[0] = Px2Dp(h.GetAdvance());
            fArr[1] = Px2Dp(h.GetAscent());
            fArr[2] = Px2Dp(h.GetDescent());
            if (h.Selectable()) {
                f = 1.0f;
            } else {
                f = 0.0f;
            }
            fArr[3] = f;
        }
        return fArr;
    }
}
