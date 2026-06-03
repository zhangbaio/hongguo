package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class AnchorData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("anchor_popup")
    public AnchorPopup anchorPopup;

    @SerializedName("app_name")
    public String appName;

    @SerializedName("button_text")
    public String buttonText;
    public String content;
    public String icon;
    public long id;
    public String schema;
    public int type;

    static {
        Covode.recordClassIndex(612006);
        fieldTypeClassRef = FieldType.class;
    }
}
