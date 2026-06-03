package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class infoData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public Award award;
    public List<Award> awards;

    @SerializedName("book_list")
    public List<RecommendBook> bookList;
    public Map<String, String> libra;

    @SerializedName("short_video_list")
    public List<ShortVideo> shortVideoList;

    static {
        Covode.recordClassIndex(612309);
        fieldTypeClassRef = FieldType.class;
    }
}
