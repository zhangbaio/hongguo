package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class EndChapterResourcesConf implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("channel_id")
    public long channelId;

    @SerializedName("default_zlink")
    public String defaultZlink;

    @SerializedName("install_schema")
    public String installSchema;

    @SerializedName("installed_btn_text")
    public String installedBtnText;

    @SerializedName("lynx_url")
    public String lynxUrl;

    @SerializedName("music_items")
    public List<MusicItem> musicItems;
    public String title;

    @SerializedName("uninstalled_btn_text")
    public String uninstalledBtnText;

    static {
        Covode.recordClassIndex(612081);
        fieldTypeClassRef = FieldType.class;
    }
}
