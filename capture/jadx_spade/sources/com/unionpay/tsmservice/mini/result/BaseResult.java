package com.unionpay.tsmservice.mini.result;

import android.os.Parcelable;
import com.bytedance.covode.number.Covode;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
abstract class BaseResult implements Parcelable {
    static {
        Covode.recordClassIndex(654925);
    }

    BaseResult() {
    }

    public abstract void initWithJSONObject(JSONObject jSONObject);

    public abstract JSONObject toJSONObject();
}
