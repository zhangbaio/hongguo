package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;
import l3.a;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class WXMusicVideoObject implements WXMediaMessage.IMediaObject {
    public String albumName;
    public int duration;
    public String hdAlbumThumbFileHash;
    public String hdAlbumThumbFilePath;
    public String identification;
    public long issueDate;
    public String musicDataUrl;
    public String musicGenre;
    public String musicOperationUrl;
    public String musicUrl;
    public WXMusicVipInfo musicVipInfo;
    public String singerName;
    public String songLyric;

    static {
        Covode.recordClassIndex(653432);
    }

    private int getFileSize(String str) {
        return b.a(str);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        String str;
        if (b.b(this.musicUrl) || this.musicUrl.length() > 10240) {
            str = "musicUrl.length exceeds the limit";
        } else if (b.b(this.musicDataUrl) || this.musicDataUrl.length() > 10240) {
            str = "musicDataUrl.length exceeds the limit";
        } else if (b.b(this.singerName) || this.singerName.length() > 1024) {
            str = "singerName.length exceeds the limit";
        } else if (!b.b(this.songLyric) && this.songLyric.length() > 32768) {
            str = "songLyric.length exceeds the limit";
        } else if (!b.b(this.hdAlbumThumbFilePath) && this.hdAlbumThumbFilePath.length() > 1024) {
            str = "hdAlbumThumbFilePath.length exceeds the limit";
        } else if (!b.b(this.hdAlbumThumbFilePath) && getFileSize(this.hdAlbumThumbFilePath) > 10485760) {
            str = "hdAlbumThumbFilePath file length exceeds the limit";
        } else if (!b.b(this.musicGenre) && this.musicGenre.length() > 1024) {
            str = "musicGenre.length exceeds the limit";
        } else if (!b.b(this.identification) && this.identification.length() > 1024) {
            str = "identification.length exceeds the limit";
        } else {
            if (b.b(this.musicOperationUrl) || this.musicOperationUrl.length() <= 10240) {
                return true;
            }
            str = "musicOperationUrl.length exceeds the limit";
        }
        Log.e("MicroMsg.SDK.WXMusicVideoObject", str);
        return false;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        bundle.putString("_wxmusicvideoobject_musicUrl", this.musicUrl);
        bundle.putString("_wxmusicvideoobject_musicDataUrl", this.musicDataUrl);
        bundle.putString("_wxmusicvideoobject_singerName", this.singerName);
        bundle.putString("_wxmusicvideoobject_songLyric", this.songLyric);
        bundle.putString("_wxmusicvideoobject_hdAlbumThumbFilePath", this.hdAlbumThumbFilePath);
        bundle.putString("_wxmusicvideoobject_albumName", this.albumName);
        bundle.putString("_wxmusicvideoobject_musicGenre", this.musicGenre);
        bundle.putLong("_wxmusicvideoobject_issueDate", this.issueDate);
        bundle.putString("_wxmusicvideoobject_identification", this.identification);
        bundle.putInt("_wxmusicvideoobject_duration", this.duration);
        bundle.putString("_wxmusicvideoobject_musicOperationUrl", this.musicOperationUrl);
        WXMusicVipInfo wXMusicVipInfo = this.musicVipInfo;
        if (wXMusicVipInfo != null) {
            bundle.putString("_wxmusicvideoobject_musicVipInfo", wXMusicVipInfo.getClass().getName());
            this.musicVipInfo.serialize(bundle);
        }
        bundle.putString("_wxmusicvideoobject_hdAlbumThumbFileHash", this.hdAlbumThumbFileHash);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 76;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        this.musicUrl = bundle.getString("_wxmusicvideoobject_musicUrl");
        this.musicDataUrl = bundle.getString("_wxmusicvideoobject_musicDataUrl");
        this.singerName = bundle.getString("_wxmusicvideoobject_singerName");
        this.songLyric = bundle.getString("_wxmusicvideoobject_songLyric");
        this.hdAlbumThumbFilePath = bundle.getString("_wxmusicvideoobject_hdAlbumThumbFilePath");
        this.albumName = bundle.getString("_wxmusicvideoobject_albumName");
        this.musicGenre = bundle.getString("_wxmusicvideoobject_musicGenre");
        this.issueDate = bundle.getLong("_wxmusicvideoobject_issueDate", 0L);
        this.identification = bundle.getString("_wxmusicvideoobject_identification");
        this.duration = bundle.getInt("_wxmusicvideoobject_duration", 0);
        this.musicOperationUrl = bundle.getString("_wxmusicvideoobject_musicOperationUrl");
        String string = bundle.getString("_wxmusicvideoobject_musicVipInfo");
        if (string != null) {
            try {
                WXMusicVipInfo wXMusicVipInfo = (WXMusicVipInfo) a.q(string).newInstance();
                this.musicVipInfo = wXMusicVipInfo;
                wXMusicVipInfo.unserialize(bundle);
            } catch (Exception e) {
                Log.e("MicroMsg.SDK.WXMusicVideoObject", "get WXSceneDataObject from bundle failed: unknown vipInfoObjectStr " + string + ", ex = " + e.getMessage());
            }
        }
        this.hdAlbumThumbFileHash = bundle.getString("_wxmusicvideoobject_hdAlbumThumbFileHash");
    }
}
