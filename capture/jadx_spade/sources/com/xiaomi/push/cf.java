package com.xiaomi.push;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.dragon.read.app.PrivacyMgr;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.util.DebugManager;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class cf {
    protected static Context a;

    /* renamed from: a, reason: collision with other field name */
    private static a f186a;

    /* renamed from: a, reason: collision with other field name */
    private static cf f187a;

    /* renamed from: a, reason: collision with other field name */
    protected static boolean f188a;
    protected static final Map<String, cb> b;
    private static String c;
    private static String d;

    /* renamed from: a, reason: collision with other field name */
    private long f189a;

    /* renamed from: a, reason: collision with other field name */
    private ce f190a;

    /* renamed from: a, reason: collision with other field name */
    protected b f191a;

    /* renamed from: a, reason: collision with other field name */
    private String f192a;

    /* renamed from: a, reason: collision with other field name */
    protected final Map<String, cc> f193a;

    /* renamed from: b, reason: collision with other field name */
    private final long f194b;

    /* renamed from: b, reason: collision with other field name */
    private String f195b;

    /* renamed from: c, reason: collision with other field name */
    private long f196c;

    public interface a {
        cf a(Context context, ce ceVar, b bVar, String str);
    }

    public interface b {
        String a(String str);
    }

    private String f() {
        return "host_fallbacks";
    }

    protected String b() {
        return "resolver.msg.xiaomi.net";
    }

    /* renamed from: a, reason: collision with other method in class */
    public cb m233a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the url is empty");
        }
        return a(new URL(str).getHost(), true);
    }

    public cb a(String str, boolean z) {
        cb e;
        com.xiaomi.channel.commonutils.logger.b.b("HostManager", "-->getFallbacksByHost(): host=", str, ", fetchRemoteIfNeed=", Boolean.valueOf(z));
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        if (!this.f190a.a(str)) {
            return null;
        }
        cb c2 = c(str);
        return (c2 == null || !c2.b()) ? (z && at.m155a(a) && (e = e(str)) != null) ? e : new cb(str, c2) { // from class: com.xiaomi.push.cf.2
            cb a;
            final /* synthetic */ cb b;

            @Override // com.xiaomi.push.cb
            public boolean b() {
                return false;
            }

            @Override // com.xiaomi.push.cb
            public synchronized ArrayList<String> a(boolean z2) {
                ArrayList<String> arrayList;
                arrayList = new ArrayList<>();
                cb cbVar = this.a;
                if (cbVar != null) {
                    arrayList.addAll(cbVar.a(true));
                }
                Map<String, cb> map = cf.b;
                synchronized (map) {
                    cb cbVar2 = map.get(((cb) this).f183b);
                    if (cbVar2 != null) {
                        Iterator<String> it2 = cbVar2.a(true).iterator();
                        while (it2.hasNext()) {
                            String next = it2.next();
                            if (arrayList.indexOf(next) == -1) {
                                arrayList.add(next);
                            }
                        }
                        arrayList.remove(((cb) this).f183b);
                        arrayList.add(((cb) this).f183b);
                    }
                }
                return arrayList;
            }

            @Override // com.xiaomi.push.cb
            public synchronized void a(String str2, ca caVar) {
                cb cbVar = this.a;
                if (cbVar != null) {
                    cbVar.a(str2, caVar);
                }
            }

            {
                this.b = c2;
                this.a = c2;
                ((cb) this).f183b = ((cb) this).f183b;
                if (c2 != null) {
                    this.f = c2.f;
                }
            }
        } : c2;
    }

    protected String a(ArrayList<String> arrayList, String str, String str2, boolean z) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<as> arrayList3 = new ArrayList();
        arrayList3.add(new aq("type", str));
        if (str.equals("wap")) {
            arrayList3.add(new aq("conpt", a(at.m151a(a))));
        }
        if (z) {
            arrayList3.add(new aq("reserved", "1"));
        }
        arrayList3.add(new aq("uuid", str2));
        arrayList3.add(new aq("list", ba.a(arrayList, ",")));
        arrayList3.add(new aq("countrycode", com.xiaomi.push.service.b.a(a).b()));
        arrayList3.add(new aq("push_sdk_vc", String.valueOf(50906)));
        String b2 = b();
        cb c2 = c(b2);
        String format = String.format(Locale.US, "https://%1$s/gslb/?ver=5.0", b2);
        if (c2 == null) {
            arrayList2.add(format);
            Map<String, cb> map = b;
            synchronized (map) {
                cb cbVar = map.get(b2);
                if (cbVar != null) {
                    Iterator<String> it2 = cbVar.a(true).iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(String.format(Locale.US, "https://%1$s/gslb/?ver=5.0", it2.next()));
                    }
                }
            }
        } else {
            arrayList2 = c2.a(format);
        }
        Iterator<String> it4 = arrayList2.iterator();
        IOException e = null;
        while (it4.hasNext()) {
            Uri.Builder buildUpon = Uri.parse(it4.next()).buildUpon();
            for (as asVar : arrayList3) {
                buildUpon.appendQueryParameter(asVar.a(), asVar.b());
            }
            try {
                b bVar = this.f191a;
                if (bVar == null) {
                    return at.a(a, new URL(buildUpon.toString()));
                }
                return bVar.a(buildUpon.toString());
            } catch (IOException e2) {
                e = e2;
            }
        }
        if (e == null) {
            return null;
        }
        com.xiaomi.channel.commonutils.logger.b.m54a("network exception: " + e.getMessage());
        throw e;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m235a() {
        synchronized (this.f193a) {
            this.f193a.clear();
        }
    }

    public void a(String str, cb cbVar) {
        if (TextUtils.isEmpty(str) || cbVar == null) {
            throw new IllegalArgumentException("the argument is invalid " + str + ", " + cbVar);
        }
        if (this.f190a.a(str)) {
            synchronized (this.f193a) {
                m237a();
                if (this.f193a.containsKey(str)) {
                    this.f193a.get(str).a(cbVar);
                } else {
                    cc ccVar = new cc(str);
                    ccVar.a(cbVar);
                    this.f193a.put(str, ccVar);
                }
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    protected boolean m237a() {
        synchronized (this.f193a) {
            if (f188a) {
                return true;
            }
            f188a = true;
            this.f193a.clear();
            try {
                String d2 = d();
                if (!TextUtils.isEmpty(d2)) {
                    m239b(d2);
                    com.xiaomi.channel.commonutils.logger.b.b("loading the new hosts succeed");
                    return true;
                }
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.m54a("load bucket failure: " + th.getMessage());
            }
            return false;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    protected JSONObject m234a() {
        JSONObject jSONObject;
        synchronized (this.f193a) {
            jSONObject = new JSONObject();
            jSONObject.put("ver", 2);
            JSONArray jSONArray = new JSONArray();
            Iterator<cc> it2 = this.f193a.values().iterator();
            while (it2.hasNext()) {
                jSONArray.put(it2.next().m228a());
            }
            jSONObject.put("data", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            Iterator<cb> it4 = b.values().iterator();
            while (it4.hasNext()) {
                jSONArray2.put(it4.next().m223a());
            }
            jSONObject.put("reserved", jSONArray2);
        }
        return jSONObject;
    }

    static {
        Covode.recordClassIndex(655408);
        b = new HashMap();
        f188a = false;
    }

    public static synchronized cf a() {
        cf cfVar;
        synchronized (cf.class) {
            cfVar = f187a;
            if (cfVar == null) {
                throw new IllegalStateException("the host manager is not initialized yet.");
            }
        }
        return cfVar;
    }

    private String g() {
        try {
            PackageInfo INVOKEVIRTUAL_com_xiaomi_push_cf_com_dragon_read_resource_PackageManagerAop_getPackageInfo = INVOKEVIRTUAL_com_xiaomi_push_cf_com_dragon_read_resource_PackageManagerAop_getPackageInfo(a.getPackageManager(), a.getPackageName(), 16384);
            if (INVOKEVIRTUAL_com_xiaomi_push_cf_com_dragon_read_resource_PackageManagerAop_getPackageInfo != null) {
                return INVOKEVIRTUAL_com_xiaomi_push_cf_com_dragon_read_resource_PackageManagerAop_getPackageInfo.versionName;
            }
            return "0";
        } catch (Exception unused) {
            return "0";
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    static String m231a() {
        if (a == null) {
            return "unknown";
        }
        try {
            au m148a = at.m148a();
            if (m148a == null) {
                return "unknown";
            }
            if (m148a.a() == 1) {
                return "WIFI-UNKNOWN";
            }
            return m148a.m158a() + "-" + m148a.m160b();
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    protected String e() {
        if ("com.xiaomi.xmsf".equals(c)) {
            return c;
        }
        return c + ":pushservice";
    }

    /* renamed from: b, reason: collision with other method in class */
    public void m238b() {
        ArrayList<String> arrayList;
        synchronized (this.f193a) {
            m237a();
            arrayList = new ArrayList<>(this.f193a.keySet());
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                cc ccVar = this.f193a.get(arrayList.get(size));
                if (ccVar != null && ccVar.a() != null) {
                    arrayList.remove(size);
                }
            }
        }
        ArrayList<cb> a2 = a(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            if (a2.get(i) != null) {
                a(arrayList.get(i), a2.get(i));
            }
        }
    }

    public String c() {
        StringBuilder sb = new StringBuilder();
        synchronized (this.f193a) {
            for (Map.Entry<String, cc> entry : this.f193a.entrySet()) {
                sb.append(entry.getKey());
                sb.append(":\n");
                sb.append(entry.getValue().toString());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    /* renamed from: d, reason: collision with other method in class */
    public void m241d() {
        String str;
        String e = e();
        try {
            PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(a.getFilesDir(), e);
            if (polarisFileWrapper.exists()) {
                boolean delete = polarisFileWrapper.delete();
                StringBuilder sb = new StringBuilder();
                sb.append("Delete old host fallbacks file ");
                sb.append(e);
                if (delete) {
                    str = " successful.";
                } else {
                    str = " failed.";
                }
                sb.append(str);
                com.xiaomi.channel.commonutils.logger.b.m54a(sb.toString());
            } else {
                com.xiaomi.channel.commonutils.logger.b.b("Old host fallbacks file " + e + " does not exist.");
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m54a("Delete old host fallbacks file " + e + " error: " + e2.getMessage());
        }
    }

    /* renamed from: c, reason: collision with other method in class */
    public void m240c() {
        FileOutputStream fileOutputStream;
        Closeable closeable;
        BufferedOutputStream bufferedOutputStream;
        Exception e;
        synchronized (this.f193a) {
            BufferedOutputStream bufferedOutputStream2 = null;
            try {
                try {
                    String jSONObject = m234a().toString();
                    com.xiaomi.channel.commonutils.logger.b.b("persist host fallbacks = " + jSONObject);
                    if (!TextUtils.isEmpty(jSONObject)) {
                        fileOutputStream = a.openFileOutput(f(), 0);
                        try {
                            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                            try {
                                bufferedOutputStream.write(h.b(m232a(), jSONObject.getBytes(StandardCharsets.UTF_8)));
                                bufferedOutputStream.flush();
                                bufferedOutputStream2 = bufferedOutputStream;
                            } catch (Exception e2) {
                                e = e2;
                                com.xiaomi.channel.commonutils.logger.b.m54a("persist bucket failure: " + e.getMessage());
                                v.a(bufferedOutputStream);
                                v.a(fileOutputStream);
                            }
                        } catch (Exception e3) {
                            e = e3;
                            bufferedOutputStream = null;
                            e = e;
                            com.xiaomi.channel.commonutils.logger.b.m54a("persist bucket failure: " + e.getMessage());
                            v.a(bufferedOutputStream);
                            v.a(fileOutputStream);
                        } catch (Throwable th) {
                            th = th;
                            closeable = null;
                            th = th;
                            v.a(closeable);
                            v.a(fileOutputStream);
                            throw th;
                        }
                    } else {
                        fileOutputStream = null;
                    }
                    v.a(bufferedOutputStream2);
                } catch (Throwable th2) {
                    th = th2;
                    v.a(closeable);
                    v.a(fileOutputStream);
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                fileOutputStream = null;
                bufferedOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                closeable = null;
            }
            v.a(fileOutputStream);
        }
    }

    protected String d() {
        BufferedInputStream bufferedInputStream;
        PolarisFileInputStreamWrapper polarisFileInputStreamWrapper;
        PolarisFileWrapper polarisFileWrapper;
        try {
            polarisFileWrapper = new PolarisFileWrapper(a.getFilesDir(), f());
        } catch (Throwable th) {
            th = th;
            bufferedInputStream = null;
            polarisFileInputStreamWrapper = null;
        }
        if (polarisFileWrapper.isFile()) {
            polarisFileInputStreamWrapper = new PolarisFileInputStreamWrapper(polarisFileWrapper);
            try {
                bufferedInputStream = new BufferedInputStream(polarisFileInputStreamWrapper);
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream = null;
            }
            try {
                String str = new String(h.a(m232a(), v.a((InputStream) bufferedInputStream)), StandardCharsets.UTF_8);
                com.xiaomi.channel.commonutils.logger.b.b("load host fallbacks = " + str);
                return str;
            } catch (Throwable th3) {
                th = th3;
                try {
                    com.xiaomi.channel.commonutils.logger.b.m54a("load host exception " + th.getMessage());
                    return null;
                } finally {
                    v.a((Closeable) bufferedInputStream);
                    v.a((Closeable) polarisFileInputStreamWrapper);
                }
            }
        }
        v.a((Closeable) null);
        v.a((Closeable) null);
        return null;
    }

    /* renamed from: e, reason: collision with other method in class */
    public void m242e() {
        String next;
        synchronized (this.f193a) {
            Iterator<cc> it2 = this.f193a.values().iterator();
            while (it2.hasNext()) {
                it2.next().a(true);
            }
            while (true) {
                for (boolean z = false; !z; z = true) {
                    Iterator<String> it4 = this.f193a.keySet().iterator();
                    while (it4.hasNext()) {
                        next = it4.next();
                        if (this.f193a.get(next).m227a().isEmpty()) {
                            break;
                        }
                    }
                }
                this.f193a.remove(next);
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    private byte[] m232a() {
        return az.m166a(a.getPackageName() + "_key_salt");
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m236a(String str) {
        this.f195b = str;
    }

    public cb b(String str) {
        return a(str, true);
    }

    public static synchronized void a(a aVar) {
        synchronized (cf.class) {
            f186a = aVar;
            f187a = null;
        }
    }

    public cb d(String str) {
        cb cbVar;
        Map<String, cb> map = b;
        synchronized (map) {
            cbVar = map.get(str);
        }
        return cbVar;
    }

    protected cb c(String str) {
        cc ccVar;
        cb a2;
        synchronized (this.f193a) {
            m237a();
            ccVar = this.f193a.get(str);
        }
        if (ccVar != null && (a2 = ccVar.a()) != null) {
            return a2;
        }
        return null;
    }

    static String a(String str) {
        try {
            int length = str.length();
            byte[] bytes = str.getBytes("UTF-8");
            for (int i = 0; i < bytes.length; i++) {
                byte b2 = bytes[i];
                int i2 = b2 & 240;
                if (i2 != 240) {
                    bytes[i] = (byte) (((b2 & 15) ^ ((byte) (((b2 >> 4) + length) & 15))) | i2);
                }
            }
            return new String(bytes);
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    protected cb e(String str) {
        if (System.currentTimeMillis() - this.f196c > this.f189a * 60 * 1000) {
            this.f196c = System.currentTimeMillis();
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str);
            cb cbVar = a(arrayList).get(0);
            if (cbVar != null) {
                this.f189a = 0L;
                return cbVar;
            }
            long j = this.f189a;
            if (j < 15) {
                this.f189a = j + 1;
                return null;
            }
            return null;
        }
        return null;
    }

    /* renamed from: b, reason: collision with other method in class */
    protected void m239b(String str) {
        synchronized (this.f193a) {
            this.f193a.clear();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("ver") == 2) {
                JSONArray optJSONArray = jSONObject.optJSONArray("data");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        cc a2 = new cc().a(optJSONArray.getJSONObject(i));
                        this.f193a.put(a2.m226a(), a2);
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("reserved");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject jSONObject2 = optJSONArray2.getJSONObject(i2);
                        String optString = jSONObject2.optString("host");
                        if (!TextUtils.isEmpty(optString)) {
                            try {
                                cb a3 = new cb(optString).a(jSONObject2);
                                b.put(a3.f183b, a3);
                                com.xiaomi.channel.commonutils.logger.b.m54a("load local reserved host for " + a3.f183b);
                            } catch (JSONException unused) {
                                com.xiaomi.channel.commonutils.logger.b.m54a("parse reserved host fail.");
                            }
                        }
                    }
                }
            } else {
                throw new JSONException("Bad version");
            }
        }
    }

    private ArrayList<cb> a(ArrayList<String> arrayList) {
        String str;
        long j;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        m242e();
        synchronized (this.f193a) {
            m237a();
            for (String str2 : this.f193a.keySet()) {
                if (!arrayList.contains(str2)) {
                    arrayList.add(str2);
                }
            }
        }
        Map<String, cb> map = b;
        synchronized (map) {
            for (Object obj : map.values().toArray()) {
                cb cbVar = (cb) obj;
                if (!cbVar.b()) {
                    b.remove(cbVar.f183b);
                }
            }
        }
        if (!arrayList.contains(b())) {
            arrayList.add(b());
        }
        ArrayList<cb> arrayList2 = new ArrayList<>(arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList2.add(null);
        }
        try {
            if (at.d(a)) {
                str = "wifi";
            } else {
                str = "wap";
            }
            String a2 = a(arrayList, str, this.f192a, true);
            if (!TextUtils.isEmpty(a2)) {
                JSONObject jSONObject3 = new JSONObject(a2);
                com.xiaomi.channel.commonutils.logger.b.b(a2);
                if ("OK".equalsIgnoreCase(jSONObject3.getString("S"))) {
                    JSONObject jSONObject4 = jSONObject3.getJSONObject("R");
                    String string = jSONObject4.getString("province");
                    String string2 = jSONObject4.getString("city");
                    String string3 = jSONObject4.getString("isp");
                    String string4 = jSONObject4.getString("ip");
                    String string5 = jSONObject4.getString("country");
                    JSONObject jSONObject5 = jSONObject4.getJSONObject(str);
                    com.xiaomi.channel.commonutils.logger.b.c("get bucket: net=" + string3 + ", hosts=" + jSONObject5.toString());
                    int i2 = 0;
                    while (i2 < arrayList.size()) {
                        String str3 = arrayList.get(i2);
                        JSONArray optJSONArray = jSONObject5.optJSONArray(str3);
                        if (optJSONArray == null) {
                            com.xiaomi.channel.commonutils.logger.b.m54a("no bucket found for " + str3);
                            jSONObject = jSONObject5;
                        } else {
                            cb cbVar2 = new cb(str3);
                            int i3 = 0;
                            while (i3 < optJSONArray.length()) {
                                String string6 = optJSONArray.getString(i3);
                                if (!TextUtils.isEmpty(string6)) {
                                    jSONObject2 = jSONObject5;
                                    cbVar2.a(new ci(string6, optJSONArray.length() - i3));
                                } else {
                                    jSONObject2 = jSONObject5;
                                }
                                i3++;
                                jSONObject5 = jSONObject2;
                            }
                            jSONObject = jSONObject5;
                            arrayList2.set(i2, cbVar2);
                            cbVar2.g = string5;
                            cbVar2.c = string;
                            cbVar2.e = string3;
                            cbVar2.f = string4;
                            cbVar2.d = string2;
                            if (jSONObject4.has("stat-percent")) {
                                cbVar2.a(jSONObject4.getDouble("stat-percent"));
                            }
                            if (jSONObject4.has("stat-domain")) {
                                cbVar2.b(jSONObject4.getString("stat-domain"));
                            }
                            if (jSONObject4.has("ttl")) {
                                cbVar2.a(jSONObject4.getInt("ttl") * 1000);
                            }
                            m236a(cbVar2.a());
                        }
                        i2++;
                        jSONObject5 = jSONObject;
                    }
                    JSONObject optJSONObject = jSONObject4.optJSONObject("reserved");
                    if (optJSONObject != null) {
                        if (jSONObject4.has("reserved-ttl")) {
                            j = jSONObject4.getInt("reserved-ttl") * 1000;
                        } else {
                            j = 604800000;
                        }
                        Iterator<String> keys = optJSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            JSONArray optJSONArray2 = optJSONObject.optJSONArray(next);
                            if (optJSONArray2 == null) {
                                com.xiaomi.channel.commonutils.logger.b.m54a("no bucket found for " + next);
                            } else {
                                cb cbVar3 = new cb(next);
                                cbVar3.a(j);
                                for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                                    String string7 = optJSONArray2.getString(i4);
                                    if (!TextUtils.isEmpty(string7)) {
                                        cbVar3.a(new ci(string7, optJSONArray2.length() - i4));
                                    }
                                }
                                Map<String, cb> map2 = b;
                                synchronized (map2) {
                                    if (this.f190a.a(next)) {
                                        map2.put(next, cbVar3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m54a("failed to get bucket " + e.getMessage());
        }
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            cb cbVar4 = arrayList2.get(i5);
            if (cbVar4 != null) {
                a(arrayList.get(i5), cbVar4);
            }
        }
        m240c();
        return arrayList2;
    }

    public static void a(String str, String str2) {
        Map<String, cb> map = b;
        cb cbVar = map.get(str);
        synchronized (map) {
            if (cbVar == null) {
                cb cbVar2 = new cb(str);
                cbVar2.a(604800000L);
                cbVar2.m224a(str2);
                map.put(str, cbVar2);
            } else {
                cbVar.m224a(str2);
            }
        }
    }

    @Proxy("getPackageInfo")
    @TargetClass("android.content.pm.PackageManager")
    public static PackageInfo INVOKEVIRTUAL_com_xiaomi_push_cf_com_dragon_read_resource_PackageManagerAop_getPackageInfo(PackageManager packageManager, String packageName, int i) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        if (x55.a.a()) {
            PackageInfo INVOKEVIRTUAL_com_xiaomi_push_cf_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo = INVOKEVIRTUAL_com_xiaomi_push_cf_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(packageManager, packageName, i);
            Intrinsics.checkNotNull(INVOKEVIRTUAL_com_xiaomi_push_cf_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo, "null cannot be cast to non-null type android.content.pm.PackageInfo");
            return INVOKEVIRTUAL_com_xiaomi_push_cf_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo;
        }
        x55.b bVar = x55.b.a;
        PackageInfo f = bVar.f(packageName, i);
        if (f != null) {
            return f;
        }
        PackageInfo INVOKEVIRTUAL_com_xiaomi_push_cf_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2 = INVOKEVIRTUAL_com_xiaomi_push_cf_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(packageManager, packageName, i);
        Intrinsics.checkNotNull(INVOKEVIRTUAL_com_xiaomi_push_cf_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2, "null cannot be cast to non-null type android.content.pm.PackageInfo");
        bVar.c(packageName, i, INVOKEVIRTUAL_com_xiaomi_push_cf_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2);
        return INVOKEVIRTUAL_com_xiaomi_push_cf_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2;
    }

    @Proxy("getPackageInfo")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.pm.PackageManager")
    public static PackageInfo INVOKEVIRTUAL_com_xiaomi_push_cf_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(PackageManager packageManager, String str, int i) {
        if (!PrivacyMgr.inst().hasConfirmedAndNotBasic() && !lz4.a.a(str)) {
            return null;
        }
        if (DebugManager.isDebugBuild() && DebugManager.inst().isComplianceLogEnable()) {
            LogWrapper.info("getPackageInfo", "getPackageInfo(" + str + ") " + Log.getStackTraceString(new Exception()), new Object[0]);
        }
        return packageManager.getPackageInfo(str, i);
    }

    protected cf(Context context, ce ceVar, b bVar, String str) {
        this(context, ceVar, bVar, str, null, null);
    }

    protected cf(Context context, ce ceVar, b bVar, String str, String str2, String str3) {
        this.f193a = new HashMap();
        this.f192a = "0";
        this.f189a = 0L;
        this.f194b = 15L;
        this.f196c = 0L;
        this.f195b = "isp_prov_city_country_ip";
        this.f191a = bVar;
        if (ceVar == null) {
            this.f190a = new ce() { // from class: com.xiaomi.push.cf.1
                @Override // com.xiaomi.push.ce
                public boolean a(String str4) {
                    return true;
                }
            };
        } else {
            this.f190a = ceVar;
        }
        this.f192a = str;
        c = str2 == null ? context.getPackageName() : str2;
        d = str3 == null ? g() : str3;
    }

    public static synchronized void a(Context context, ce ceVar, b bVar, String str, String str2, String str3) {
        synchronized (cf.class) {
            Context applicationContext = context.getApplicationContext();
            a = applicationContext;
            if (applicationContext == null) {
                a = context;
            }
            if (f187a == null) {
                a aVar = f186a;
                if (aVar == null) {
                    f187a = new cf(context, ceVar, bVar, str, str2, str3);
                } else {
                    f187a = aVar.a(context, ceVar, bVar, str);
                }
            }
        }
    }
}
