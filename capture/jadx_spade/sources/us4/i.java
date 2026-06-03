package us4;

import android.os.Bundle;
import com.bytedance.covode.number.Covode;
import com.ss.android.videoshop.entity.PlayEntity;
import com.ss.android.videoshop.mediaview.SimpleMediaView;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class i {
    static {
        Covode.recordClassIndex(612517);
    }

    public static final boolean f(SimpleMediaView simpleMediaView) {
        PlayEntity playEntity;
        if (simpleMediaView != null && (playEntity = simpleMediaView.getPlayEntity()) != null) {
            return e(playEntity);
        }
        return false;
    }

    public static final boolean e(PlayEntity playEntity) {
        Bundle bundle;
        if (playEntity != null && (bundle = playEntity.getBundle()) != null) {
            return bundle.getBoolean("has_next_video_chapter");
        }
        return false;
    }

    public static final String a(PlayEntity playEntity, String str) {
        Bundle bundle;
        String string;
        if (playEntity != null && (bundle = playEntity.getBundle()) != null && (string = bundle.getString("book_id")) != null) {
            return string;
        }
        return str;
    }

    public static final String b(SimpleMediaView simpleMediaView, String str) {
        PlayEntity playEntity;
        String a;
        if (simpleMediaView != null && (playEntity = simpleMediaView.getPlayEntity()) != null && (a = a(playEntity, str)) != null) {
            return a;
        }
        return str;
    }

    public static final String c(PlayEntity playEntity, String str) {
        Bundle bundle;
        String string;
        if (playEntity != null && (bundle = playEntity.getBundle()) != null && (string = bundle.getString("video_position")) != null) {
            return string;
        }
        return str;
    }

    public static final String d(SimpleMediaView simpleMediaView, String str) {
        PlayEntity playEntity;
        String c;
        if (simpleMediaView != null && (playEntity = simpleMediaView.getPlayEntity()) != null && (c = c(playEntity, str)) != null) {
            return c;
        }
        return str;
    }
}
