package com.ss.videoarch.liveplayer;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import java.util.Set;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class i {
    static {
        Covode.recordClassIndex(652936);
    }

    static String a(String str, String str2, String str3) {
        String queryParameter;
        Uri parse = Uri.parse(str);
        Uri.Builder buildUpon = parse.buildUpon();
        Set<String> queryParameterNames = parse.getQueryParameterNames();
        if (queryParameterNames.contains(str2)) {
            buildUpon.clearQuery();
            for (String str4 : queryParameterNames) {
                if (TextUtils.equals(str4, str2)) {
                    queryParameter = str3;
                } else {
                    queryParameter = parse.getQueryParameter(str4);
                }
                buildUpon.appendQueryParameter(str4, queryParameter);
            }
        } else {
            buildUpon.appendQueryParameter(str2, str3);
        }
        return buildUpon.build().toString();
    }
}
