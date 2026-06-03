package com.dragon.read.local.db;

import com.bytedance.covode.number.Covode;
import com.dragon.read.local.db.entity.RecordModel;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final a a;

    static {
        Covode.recordClassIndex(611515);
        a = new a();
    }

    private a() {
    }

    public static final void a(lr4.i iVar, RecordModel recordModel) {
        if (recordModel != null && iVar != null) {
            String coverUrl = recordModel.getCoverUrl();
            String str = "";
            if (coverUrl == null) {
                coverUrl = "";
            }
            iVar.c = coverUrl;
            String bookName = recordModel.getBookName();
            if (bookName == null) {
                bookName = "";
            }
            iVar.b = bookName;
            String author = recordModel.getAuthor();
            if (author != null) {
                str = author;
            }
            iVar.a = str;
            if (recordModel.getUpdateTime() > 0) {
                iVar.i = recordModel.getUpdateTime();
            }
            if (recordModel.getReadTime() > 0) {
                iVar.j = recordModel.getReadTime();
            }
            iVar.d = recordModel.getGenreType();
            iVar.e = recordModel.getTtsStatus();
            iVar.n = recordModel.isFinish();
            iVar.o = recordModel.getRecentReadCount();
            iVar.p = recordModel.getScore();
            iVar.q = recordModel.getSource();
            iVar.w = recordModel.getColorDominate();
            iVar.u = recordModel.isPubPay();
            iVar.y = recordModel.getPlatformBookId();
        }
    }
}
