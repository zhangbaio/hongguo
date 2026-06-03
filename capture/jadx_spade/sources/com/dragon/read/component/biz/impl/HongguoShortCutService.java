package com.dragon.read.component.biz.impl;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.util.Pair;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.ssconfig.template.ShortcutOptConfig;
import com.dragon.read.component.biz.impl.brickservice.BsShortCutService;
import com.dragon.read.local.db.entity.RecordModel;
import com.dragon.read.pages.bookshelf.model.BookType;
import dv4.a;
import io.reactivex.Single;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import ny4.e;
import ny4.n;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class HongguoShortCutService implements BsShortCutService {
    public static final int $stable = 0;

    static {
        Covode.recordClassIndex(588084);
    }

    public int getOptMsgCountToHandleSimpleTextId() {
        return BsShortCutService.b.c(this);
    }

    public int getOptRecentShortVideoIconResId() {
        return BsShortCutService.b.d(this);
    }

    public int getOptShortRecommendSimpleTextId() {
        return BsShortCutService.b.e(this);
    }

    public String getRankingListPageSchema() {
        return BsShortCutService.b.g(this);
    }

    public boolean isShowShortcutOptimizedIcon() {
        return BsShortCutService.b.i(this);
    }

    public boolean isShowShortcutSimpleText() {
        return BsShortCutService.b.j(this);
    }

    public Single<RecordModel> getRecentBookSingle() {
        if (ShortcutOptConfig.a.a().enable) {
            Single<RecordModel> just = Single.just(new RecordModel("", BookType.READ));
            Intrinsics.checkNotNull(just);
            return just;
        }
        return n.a.k();
    }

    public Single<Pair<Boolean, a>> getRecentSeriesSingle() {
        if (ShortcutOptConfig.a.a().enable) {
            return n.a.s();
        }
        Single<Pair<Boolean, a>> just = Single.just(new Pair(Boolean.FALSE, null));
        Intrinsics.checkNotNull(just);
        return just;
    }

    public Intent getShortRecommendShortCutIntent(Context context) {
        return BsShortCutService.b.h(this, context);
    }

    public void updateShortVideoRecord(a record) {
        Intrinsics.checkNotNullParameter(record, "record");
        if (ShortcutOptConfig.a.a().enable) {
            ny4.a.f().g(record);
        }
    }

    public int getOptShortcutIcon(int i, int i2) {
        return BsShortCutService.b.f(this, i, i2);
    }

    public boolean addRecentShortCutItem(List<ShortcutInfo> list, Context context, e.d dVar) {
        return BsShortCutService.b.a(this, list, context, dVar);
    }

    public boolean addRecommendShortCutItem(List<ShortcutInfo> list, Context context, e.d dVar) {
        return BsShortCutService.b.b(this, list, context, dVar);
    }

    public void addReadShortCutItem(List<ShortcutInfo> list, Context activity, e.d dVar) {
        Object second;
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (dVar == null) {
            return;
        }
        if (ShortcutOptConfig.a.a().enable) {
            Pair pair = dVar.f;
            if (pair != null && ((Boolean) pair.first).booleanValue() && (second = dVar.f.second) != null) {
                n nVar = n.a;
                Intrinsics.checkNotNullExpressionValue(second, "second");
                ShortcutInfo n = nVar.n(activity, (a) second);
                if (n != null) {
                    list.add(n);
                    return;
                }
                return;
            }
            ShortcutInfo t = n.a.t(activity, dVar.g);
            if (t != null) {
                list.add(t);
                return;
            }
            return;
        }
        RecordModel bookRecord = dVar.e;
        if (bookRecord != null) {
            n nVar2 = n.a;
            Intrinsics.checkNotNullExpressionValue(bookRecord, "bookRecord");
            ShortcutInfo h = nVar2.h(activity, bookRecord);
            if (h != null) {
                list.add(h);
                return;
            }
            return;
        }
        ShortcutInfo e = n.a.e(activity, dVar.g);
        if (e != null) {
            list.add(e);
        }
    }
}
