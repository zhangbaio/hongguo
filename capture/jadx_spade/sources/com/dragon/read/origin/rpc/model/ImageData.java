package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ImageData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("additional_images")
    public List<ImageData> additionalImages;

    @SerializedName("aigc_image_id")
    public String aigcImageId;

    @SerializedName("cover_template_params")
    public Map<String, String> coverTemplateParams;

    @SerializedName("cover_type")
    public UgcCoverType coverType;

    @SerializedName("dynamic_url")
    public String dynamicUrl;

    @SerializedName("expand_web_url")
    public String expandWebUrl;
    public Map<String, String> extra;
    public String format;
    public int height;

    @SerializedName("horiz_web_url")
    public String horizWebUrl;
    public String id;

    @SerializedName("image_color")
    public String imageColor;

    @SerializedName("image_name")
    public String imageName;

    @SerializedName("image_type")
    public ImageType imageType;

    @SerializedName("picture_edit_type")
    public PictureEditType pictureEditType;

    @SerializedName("thumb_nails")
    public List<ImageData> thumbNails;

    @SerializedName("web_uri")
    public String webUri;

    @SerializedName("web_url")
    public String webUrl;
    public int width;

    static {
        Covode.recordClassIndex(613189);
        fieldTypeClassRef = FieldType.class;
    }
}
