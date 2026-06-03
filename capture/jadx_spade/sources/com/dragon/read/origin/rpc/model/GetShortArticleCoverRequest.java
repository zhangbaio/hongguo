package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class GetShortArticleCoverRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public int category;

    @SerializedName("cover_type")
    public short coverType;

    @SerializedName("image_fmt_list")
    public List<String> imageFmtList;

    @SerializedName("page_count")
    public short pageCount;

    @SerializedName("page_index")
    public short pageIndex;

    @SerializedName("version_type")
    public short versionType;

    static {
        Covode.recordClassIndex(613150);
        fieldTypeClassRef = FieldType.class;
    }
}
