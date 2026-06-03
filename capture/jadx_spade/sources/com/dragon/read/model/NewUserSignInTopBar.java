package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class NewUserSignInTopBar implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("icon_type")
    public String iconType;

    @SerializedName("need_enqueue")
    public boolean needEnqueue;

    @SerializedName("notify_type")
    public String notifyType;

    @SerializedName("popup_type")
    public String popupType;
    public String subtitle;
    public String title;

    static {
        Covode.recordClassIndex(612163);
        fieldTypeClassRef = FieldType.class;
    }
}
