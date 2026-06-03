package com.dragon.read.lib.community.depend.biz;

import com.bytedance.covode.number.Covode;
import com.dragon.read.saas.ugc.model.PositionInfoV2;
import java.io.Serializable;
import zq4.s;
import zq4.w;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface ICSSParaTextBlock extends w, Serializable {

    public static final class a {
        static {
            Covode.recordClassIndex(611426);
        }

        public static String a(ICSSParaTextBlock iCSSParaTextBlock) {
            return "";
        }
    }

    String createKey();

    String getBookId();

    String getChapterId();

    String getChapterVersion();

    @Override // zq4.w
    /* synthetic */ int getEndOffsetInPara();

    @Override // zq4.w
    /* synthetic */ int getEndParaId();

    String getImageUrl();

    PositionInfoV2 getPositionInfoV2();

    String getSelectedText();

    @Override // zq4.w
    /* synthetic */ int getStartOffsetInPara();

    @Override // zq4.w
    /* synthetic */ int getStartParaId();

    /* synthetic */ int getStartParaId(s sVar, String str);

    void setSelectedText(String str);
}
