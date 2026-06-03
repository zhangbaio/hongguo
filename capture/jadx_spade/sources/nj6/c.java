package nj6;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.covode.number.Covode;
import com.ss.videoarch.strategy.IAppInfoBundle;
import com.ss.videoarch.strategy.dataCenter.strategyData.model.SessionCacheInfos;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class c extends a {
    public static String a;
    public static final String b;
    public static final String c;
    public static Map<String, IAppInfoBundle> d;
    public static Map<String, SessionCacheInfos> e;
    private static SharedPreferences f;
    private static String g;
    private static long h;
    private static Context i;
    public static e j;

    public static int g() {
        e.clear();
        Context context = i;
        if (context == null) {
            return -1;
        }
        if (f == null) {
            f = context.getSharedPreferences(g, 0);
        }
        SharedPreferences sharedPreferences = f;
        if (sharedPreferences != null) {
            try {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.clear();
                edit.commit();
                h = 0L;
            } catch (Exception unused) {
                return -1;
            }
        }
        return 0;
    }

    public static List<SessionCacheInfos> h() {
        ArrayList arrayList = new ArrayList();
        Context context = i;
        if (context == null) {
            return arrayList;
        }
        if (f == null) {
            f = context.getSharedPreferences(g, 0);
        }
        SharedPreferences sharedPreferences = f;
        if (sharedPreferences != null) {
            Iterator<Map.Entry<String, ?>> it2 = sharedPreferences.getAll().entrySet().iterator();
            while (it2.hasNext()) {
                String str = (String) it2.next().getValue();
                if (!TextUtils.isEmpty(str)) {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.decode(str.getBytes(), 0));
                    new SessionCacheInfos();
                    try {
                        SessionCacheInfos sessionCacheInfos = (SessionCacheInfos) new ObjectInputStream(byteArrayInputStream).readObject();
                        if (sessionCacheInfos != null) {
                            arrayList.add(sessionCacheInfos);
                        }
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    } catch (ClassNotFoundException e3) {
                        e3.printStackTrace();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            }
        }
        return arrayList;
    }

    static {
        Covode.recordClassIndex(653126);
        a = "history_info";
        b = "CREATE TABLE IF NOT EXISTS " + a + " (session_id text not null ,domain text ,play_time integer ,first_frame_download_speed integer ,first_frame_network text ,expand_value text,update_time text ,create_time timestamp not null default (datetime('now','localtime')))";
        c = "CREATE TRIGGER delete_till INSERT ON " + a + " WHEN (select count(*) from " + a + ") > " + lj6.a.m().s.h + " BEGIN  DELETE FROM " + a + " WHERE update_time IN (SELECT update_time FROM " + a + " ORDER BY update_time limit (select count(*) -30 from " + a + ")) ; END ";
        d = new ConcurrentHashMap();
        e = new ConcurrentHashMap();
        g = "live_stream_strategy_hisinfo";
        h = 0L;
        j = new e();
    }

    public static void j(Context context) {
        i = context;
    }

    public static int f(SessionCacheInfos sessionCacheInfos) {
        Context context;
        if (sessionCacheInfos == null || (context = i) == null) {
            return -1;
        }
        if (f == null) {
            f = context.getSharedPreferences(g, 0);
        }
        SharedPreferences sharedPreferences = f;
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                new ObjectOutputStream(byteArrayOutputStream).writeObject(sessionCacheInfos);
                edit.putString(String.valueOf(h), new String(Base64.encode(byteArrayOutputStream.toByteArray(), 0)));
                edit.commit();
                h++;
            } catch (IOException e2) {
                e2.printStackTrace();
                return -1;
            }
        }
        return 0;
    }

    public static long i(List<SessionCacheInfos> list) {
        if (list != null && list.size() > 0) {
            String[] strArr = {"session_id"};
            ArrayList arrayList = new ArrayList();
            for (SessionCacheInfos sessionCacheInfos : list) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("domain", sessionCacheInfos.mDomain);
                contentValues.put("session_id", sessionCacheInfos.mSessionId);
                contentValues.put("first_frame_network", sessionCacheInfos.mNetwork);
                contentValues.put("first_frame_download_speed", Long.valueOf(sessionCacheInfos.mDownloadSpeed));
                contentValues.put("play_time", Long.valueOf(sessionCacheInfos.mPlayTime));
                contentValues.put("update_time", sessionCacheInfos.mUpdate);
                arrayList.add(contentValues);
            }
            return a.e(a, strArr, arrayList);
        }
        return -1L;
    }
}
