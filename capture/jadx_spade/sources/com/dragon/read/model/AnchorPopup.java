package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class AnchorPopup implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String author;

    @SerializedName("button_text")
    public String buttonText;
    public String name;

    @SerializedName("thumb_url")
    public String thumbUrl;

    static {
        Covode.recordClassIndex(612008);
        fieldTypeClassRef = FieldType.class;
    }
}
