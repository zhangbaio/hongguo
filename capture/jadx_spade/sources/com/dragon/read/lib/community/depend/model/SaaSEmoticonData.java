package com.dragon.read.lib.community.depend.model;

import com.bytedance.covode.number.Covode;
import com.dragon.read.saas.ugc.model.ImageData;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class SaaSEmoticonData implements Serializable {
    private static final long serialVersionUID = 0;

    @SerializedName("has_more")
    public boolean hasMore;

    @SerializedName("info_list")
    public List<ImageData> infoList;

    @SerializedName("next_offset")
    public int nextOffset;
    public String source;

    static {
        Covode.recordClassIndex(611451);
    }
}
