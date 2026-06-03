package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class IconConf implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("background_icon")
    public String backgroundIcon;

    @SerializedName("button_icon")
    public String buttonIcon;

    @SerializedName("major_icon")
    public String majorIcon;

    @SerializedName("sub_icon")
    public String subIcon;

    static {
        Covode.recordClassIndex(612122);
        fieldTypeClassRef = FieldType.class;
    }
}
