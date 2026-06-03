package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class BigInvitePopup implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("button_text")
    public String buttonText;
    public List<InviteCarouselSummary> carousel;
    public Reward reward;
    public String text;
    public String title;

    static {
        Covode.recordClassIndex(612024);
        fieldTypeClassRef = FieldType.class;
    }
}
