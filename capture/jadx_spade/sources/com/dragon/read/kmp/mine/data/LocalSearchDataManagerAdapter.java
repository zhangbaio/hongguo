package com.dragon.read.kmp.mine.data;

import com.bytedance.covode.number.Covode;
import com.dragon.read.local.db.entity.RecordModel;
import com.dragon.read.util.BookUtils;
import com.dragon.read.util.RealBookType;
import com.dragon.read.util.c0;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class LocalSearchDataManagerAdapter {
    public static final LocalSearchDataManagerAdapter a;

    static {
        Covode.recordClassIndex(607680);
        a = new LocalSearchDataManagerAdapter();
    }

    private LocalSearchDataManagerAdapter() {
    }

    public final Object c(Continuation<? super List<? extends b>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new LocalSearchDataManagerAdapter$getBookHistorySearchModels$2(null), continuation);
    }

    private final boolean d(RecordModel recordModel) {
        RealBookType l = c0.l(recordModel);
        if (BookUtils.isBreakUpdate(recordModel.getCreationStatus()) && c0.g(l)) {
            return true;
        }
        return false;
    }

    public final a a(RecordModel recordModel) {
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(recordModel, "recordModel");
        a aVar = new a();
        aVar.h = recordModel.getBookId();
        String genre = recordModel.getGenre();
        Intrinsics.checkNotNullExpressionValue(genre, "getGenre(...)");
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(genre);
        aVar.n = intOrNull;
        aVar.o = Integer.valueOf(recordModel.getGenreType());
        aVar.p = recordModel.getSerialCount();
        aVar.q = recordModel.getChapterIndex();
        aVar.r = recordModel.getBookType().getValue();
        aVar.s = recordModel.getPagerProgressRatio();
        aVar.t = recordModel.getCreationStatus();
        aVar.u = recordModel.isFinish();
        aVar.v = d(recordModel);
        aVar.e = recordModel.getProgressPercent();
        return aVar;
    }

    public final b b(com.dragon.read.pages.video.model.a videoHistoryModel) {
        Intrinsics.checkNotNullParameter(videoHistoryModel, "videoHistoryModel");
        b bVar = new b();
        dv4.a aVar = videoHistoryModel.a;
        bVar.h = videoHistoryModel.getId();
        bVar.k = aVar.x;
        bVar.a = aVar.l;
        bVar.b = aVar.F;
        bVar.c = aVar.t;
        bVar.d = aVar.z;
        bVar.f = aVar.E;
        bVar.g = aVar.y;
        bVar.i = aVar.n;
        bVar.j = aVar.o;
        bVar.e = videoHistoryModel.getProgressPercent();
        bVar.l = videoHistoryModel.a.S;
        return bVar;
    }
}
