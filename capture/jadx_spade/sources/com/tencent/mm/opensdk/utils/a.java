package com.tencent.mm.opensdk.utils;

import android.net.Uri;
import android.provider.BaseColumns;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a implements BaseColumns {
    public static final Uri a;

    static {
        Covode.recordClassIndex(653475);
        a = Uri.parse("content://com.tencent.mm.sdk.plugin.provider/sharedpref");
    }
}
