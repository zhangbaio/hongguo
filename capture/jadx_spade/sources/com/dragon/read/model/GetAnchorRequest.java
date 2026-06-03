package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class GetAnchorRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("biz_param")
    public BizParam bizParam;

    @SerializedName("series_id")
    public String seriesId;

    @SerializedName("transfer_app_id")
    public int transferAppId;

    static {
        Covode.recordClassIndex(612108);
        fieldTypeClassRef = FieldType.class;
    }
}
