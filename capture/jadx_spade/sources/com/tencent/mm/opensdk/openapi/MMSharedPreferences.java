package com.tencent.mm.opensdk.openapi;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class MMSharedPreferences implements SharedPreferences {
    private final ContentResolver cr;
    private final String[] columns = {"_id", "key", "type", "value"};
    private final HashMap<String, Object> values = new HashMap<>();
    private REditor editor = null;

    static {
        Covode.recordClassIndex(653456);
    }

    public MMSharedPreferences(Context context) {
        this.cr = context.getContentResolver();
    }

    private static Cursor com_tencent_mm_opensdk_openapi_MMSharedPreferences_android_content_ContentResolver_query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Result preInvoke = new HeliosApiHook().preInvoke(240004, "android/content/ContentResolver", "query", contentResolver, new Object[]{uri, strArr, str, strArr2, str2}, "android.database.Cursor", new ExtraInfo(false, "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;"));
        return preInvoke.isIntercept() ? (Cursor) preInvoke.getReturnValue() : contentResolver.query(uri, strArr, str, strArr2, str2);
    }

    private Object getValue(String str) {
        try {
            Cursor com_tencent_mm_opensdk_openapi_MMSharedPreferences_android_content_ContentResolver_query = com_tencent_mm_opensdk_openapi_MMSharedPreferences_android_content_ContentResolver_query(this.cr, a.a, this.columns, "key = ?", new String[]{str}, null);
            if (com_tencent_mm_opensdk_openapi_MMSharedPreferences_android_content_ContentResolver_query == null) {
                return null;
            }
            Object a = com_tencent_mm_opensdk_openapi_MMSharedPreferences_android_content_ContentResolver_query.moveToFirst() ? com.tencent.mm.opensdk.channel.a.a.a(com_tencent_mm_opensdk_openapi_MMSharedPreferences_android_content_ContentResolver_query.getInt(com_tencent_mm_opensdk_openapi_MMSharedPreferences_android_content_ContentResolver_query.getColumnIndex("type")), com_tencent_mm_opensdk_openapi_MMSharedPreferences_android_content_ContentResolver_query.getString(com_tencent_mm_opensdk_openapi_MMSharedPreferences_android_content_ContentResolver_query.getColumnIndex("value"))) : null;
            com_tencent_mm_opensdk_openapi_MMSharedPreferences_android_content_ContentResolver_query.close();
            return a;
        } catch (Exception e) {
            Log.e("MicroMsg.SDK.SharedPreferences", "getValue exception:" + e.getMessage());
            return null;
        }
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return getValue(str) != null;
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        if (this.editor == null) {
            this.editor = new REditor(this.cr);
        }
        return this.editor;
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        try {
            Cursor com_tencent_mm_opensdk_openapi_MMSharedPreferences_android_content_ContentResolver_query = com_tencent_mm_opensdk_openapi_MMSharedPreferences_android_content_ContentResolver_query(this.cr, a.a, this.columns, null, null, null);
            if (com_tencent_mm_opensdk_openapi_MMSharedPreferences_android_content_ContentResolver_query == null) {
                return null;
            }
            int columnIndex = com_tencent_mm_opensdk_openapi_MMSharedPreferences_android_content_ContentResolver_query.getColumnIndex("key");
            int columnIndex2 = com_tencent_mm_opensdk_openapi_MMSharedPreferences_android_content_ContentResolver_query.getColumnIndex("type");
            int columnIndex3 = com_tencent_mm_opensdk_openapi_MMSharedPreferences_android_content_ContentResolver_query.getColumnIndex("value");
            while (com_tencent_mm_opensdk_openapi_MMSharedPreferences_android_content_ContentResolver_query.moveToNext()) {
                this.values.put(com_tencent_mm_opensdk_openapi_MMSharedPreferences_android_content_ContentResolver_query.getString(columnIndex), com.tencent.mm.opensdk.channel.a.a.a(com_tencent_mm_opensdk_openapi_MMSharedPreferences_android_content_ContentResolver_query.getInt(columnIndex2), com_tencent_mm_opensdk_openapi_MMSharedPreferences_android_content_ContentResolver_query.getString(columnIndex3)));
            }
            com_tencent_mm_opensdk_openapi_MMSharedPreferences_android_content_ContentResolver_query.close();
            return this.values;
        } catch (Exception e) {
            Log.e("MicroMsg.SDK.SharedPreferences", "getAll exception:" + e.getMessage());
            return this.values;
        }
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        Object value = getValue(str);
        return (value == null || !(value instanceof Boolean)) ? z : ((Boolean) value).booleanValue();
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        Object value = getValue(str);
        return (value == null || !(value instanceof Float)) ? f : ((Float) value).floatValue();
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        Object value = getValue(str);
        return (value == null || !(value instanceof Integer)) ? i : ((Integer) value).intValue();
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        Object value = getValue(str);
        return (value == null || !(value instanceof Long)) ? j : ((Long) value).longValue();
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        Object value = getValue(str);
        return (value == null || !(value instanceof String)) ? str2 : (String) value;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        return null;
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    private static class REditor implements SharedPreferences.Editor {
        private ContentResolver cr;
        private Map<String, Object> values = new HashMap();
        private Set<String> remove = new HashSet();
        private boolean clear = false;

        static {
            Covode.recordClassIndex(653457);
        }

        public REditor(ContentResolver contentResolver) {
            this.cr = contentResolver;
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            this.clear = true;
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            this.values.put(str, Boolean.valueOf(z));
            this.remove.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f) {
            this.values.put(str, Float.valueOf(f));
            this.remove.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i) {
            this.values.put(str, Integer.valueOf(i));
            this.remove.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j) {
            this.values.put(str, Long.valueOf(j));
            this.remove.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, String str2) {
            this.values.put(str, str2);
            this.remove.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            return null;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            this.remove.add(str);
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x009a  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x00b1 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x003f A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:24:0x009c  */
        @Override // android.content.SharedPreferences.Editor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean commit() {
            /*
                r10 = this;
                android.content.ContentValues r0 = new android.content.ContentValues
                r0.<init>()
                boolean r1 = r10.clear
                r2 = 0
                if (r1 == 0) goto L14
                android.content.ContentResolver r1 = r10.cr
                android.net.Uri r3 = com.tencent.mm.opensdk.utils.a.a
                r4 = 0
                r1.delete(r3, r4, r4)
                r10.clear = r2
            L14:
                java.util.Set<java.lang.String> r1 = r10.remove
                java.util.Iterator r1 = r1.iterator()
            L1a:
                boolean r3 = r1.hasNext()
                java.lang.String r4 = "key = ?"
                r5 = 1
                if (r3 == 0) goto L35
                java.lang.Object r3 = r1.next()
                java.lang.String r3 = (java.lang.String) r3
                android.content.ContentResolver r6 = r10.cr
                android.net.Uri r7 = com.tencent.mm.opensdk.utils.a.a
                java.lang.String[] r5 = new java.lang.String[r5]
                r5[r2] = r3
                r6.delete(r7, r4, r5)
                goto L1a
            L35:
                java.util.Map<java.lang.String, java.lang.Object> r1 = r10.values
                java.util.Set r1 = r1.entrySet()
                java.util.Iterator r1 = r1.iterator()
            L3f:
                boolean r3 = r1.hasNext()
                if (r3 == 0) goto Lc4
                java.lang.Object r3 = r1.next()
                java.util.Map$Entry r3 = (java.util.Map.Entry) r3
                java.lang.Object r6 = r3.getValue()
                java.lang.String r7 = "MicroMsg.SDK.PluginProvider.Resolver"
                if (r6 != 0) goto L5a
                java.lang.String r8 = "unresolve failed, null value"
            L55:
                com.tencent.mm.opensdk.utils.Log.e(r7, r8)
                r7 = 0
                goto L98
            L5a:
                boolean r8 = r6 instanceof java.lang.Integer
                if (r8 == 0) goto L60
                r7 = 1
                goto L98
            L60:
                boolean r8 = r6 instanceof java.lang.Long
                if (r8 == 0) goto L66
                r7 = 2
                goto L98
            L66:
                boolean r8 = r6 instanceof java.lang.String
                if (r8 == 0) goto L6c
                r7 = 3
                goto L98
            L6c:
                boolean r8 = r6 instanceof java.lang.Boolean
                if (r8 == 0) goto L72
                r7 = 4
                goto L98
            L72:
                boolean r8 = r6 instanceof java.lang.Float
                if (r8 == 0) goto L78
                r7 = 5
                goto L98
            L78:
                boolean r8 = r6 instanceof java.lang.Double
                if (r8 == 0) goto L7e
                r7 = 6
                goto L98
            L7e:
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                java.lang.String r9 = "unresolve failed, unknown type="
                r8.append(r9)
                java.lang.Class r9 = r6.getClass()
                java.lang.String r9 = r9.toString()
                r8.append(r9)
                java.lang.String r8 = r8.toString()
                goto L55
            L98:
                if (r7 != 0) goto L9c
                r6 = 0
                goto Laf
            L9c:
                java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
                java.lang.String r8 = "type"
                r0.put(r8, r7)
                java.lang.String r6 = r6.toString()
                java.lang.String r7 = "value"
                r0.put(r7, r6)
                r6 = 1
            Laf:
                if (r6 == 0) goto L3f
                android.content.ContentResolver r6 = r10.cr
                android.net.Uri r7 = com.tencent.mm.opensdk.utils.a.a
                java.lang.String[] r8 = new java.lang.String[r5]
                java.lang.Object r3 = r3.getKey()
                java.lang.String r3 = (java.lang.String) r3
                r8[r2] = r3
                r6.update(r7, r0, r4, r8)
                goto L3f
            Lc4:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.opensdk.openapi.MMSharedPreferences.REditor.commit():boolean");
        }
    }
}
