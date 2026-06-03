package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class UgcSticker implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("add_context")
    public String addContext;

    @SerializedName("bg_color")
    public String bgColor;

    @SerializedName("can_worn")
    public boolean canWorn;

    @SerializedName("id")
    public int iD;
    public String name;

    @SerializedName("small_url")
    public String smallUrl;

    @SerializedName("sticker_type")
    public UgcStickerType stickerType;
    public String url;

    static {
        Covode.recordClassIndex(613523);
        fieldTypeClassRef = FieldType.class;
    }
}
