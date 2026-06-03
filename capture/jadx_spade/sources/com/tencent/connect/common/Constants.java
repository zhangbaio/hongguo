package com.tencent.connect.common;

import com.bytedance.covode.number.Covode;
import java.io.File;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class Constants {
    public static String APP_SPECIFIC_ROOT;
    public static String KEY_ENABLE_SHOW_DOWNLOAD_URL;
    public static String KEY_GUILD_TYPE;
    public static String KEY_GUILD_URL;
    public static String KEY_PROXY_APPID;
    public static String KEY_QRCODE;
    public static String KEY_RESTORE_LANDSCAPE;
    public static String KEY_SCOPE;
    public static String QQ_SHARE_TEMP_DIR;
    public static String VALUE_GUILD_CREATE;
    public static String VALUE_GUILD_JOIN;

    public static class JumpUrlConstants {
        static {
            Covode.recordClassIndex(653266);
        }
    }

    static {
        Covode.recordClassIndex(653265);
        StringBuilder sb = new StringBuilder();
        sb.append("tencent");
        String str = File.separator;
        sb.append(str);
        sb.append("mobileqq");
        sb.append(str);
        sb.append("opensdk");
        APP_SPECIFIC_ROOT = sb.toString();
        QQ_SHARE_TEMP_DIR = "tmp";
        KEY_RESTORE_LANDSCAPE = "key_restore_landscape";
        KEY_SCOPE = "key_scope";
        KEY_QRCODE = "key_qrcode";
        KEY_ENABLE_SHOW_DOWNLOAD_URL = "key_enable_show_download_url";
        KEY_PROXY_APPID = "key_proxy_appid";
        KEY_GUILD_TYPE = "guild_type";
        KEY_GUILD_URL = "guild_url";
        VALUE_GUILD_CREATE = "create";
        VALUE_GUILD_JOIN = "join";
    }
}
