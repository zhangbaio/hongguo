package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class SetAdFreeData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("is_pop_up")
    public boolean isPopUp;

    @SerializedName("popup_info")
    public AdFreePopupInfo popupInfo;
    public String schema;

    static {
        Covode.recordClassIndex(612241);
        fieldTypeClassRef = FieldType.class;
    }
}
