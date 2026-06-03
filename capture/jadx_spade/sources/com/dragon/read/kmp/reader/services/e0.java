package com.dragon.read.kmp.reader.services;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.ui.util.ScreenUtils;
import com.dragon.read.base.util.AppUtils;
import com.dragon.read.component.biz.api.NsReaderServiceApi;
import com.dragon.read.reader.ui.ReaderActivity;
import com.dragon.read.util.kotlin.UIKt;
import com.dragon.read.util.t4;
import com.dragon.reader.lib.ReaderClient;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e0 implements n {
    public static final e0 a;

    static {
        Covode.recordClassIndex(608562);
        a = new e0();
    }

    private e0() {
    }

    @Override // com.dragon.read.kmp.reader.services.n
    public int getTheme() {
        return NsReaderServiceApi.IMPL.readerInitConfigService().n().f();
    }

    @Override // com.dragon.read.kmp.reader.services.n
    public int h5() {
        return NsReaderServiceApi.IMPL.readerInitConfigService().n().a();
    }

    @Override // com.dragon.read.kmp.reader.services.n
    public int r6() {
        return UIKt.getDp(44) + ScreenUtils.getStatusBarHeight(AppUtils.context());
    }

    @Override // com.dragon.read.kmp.reader.services.n
    public boolean z4() {
        Context context;
        cm4.i a2 = xf4.e.p3.a().readerLifecycleService().O().a();
        if (a2 != null) {
            context = a2.b();
        } else {
            context = null;
        }
        if (context == null || !(context instanceof ReaderActivity)) {
            return false;
        }
        t4 t4Var = t4.a;
        ReaderClient readerClient = ((ReaderActivity) context).getReaderClient();
        if (readerClient == null) {
            return false;
        }
        return t4Var.f(readerClient);
    }
}
