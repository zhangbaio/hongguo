package com.ss.ttvideoengine.database;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface IKVStorage {
    boolean clear();

    String getString(String str);

    boolean putString(String str, String str2);

    boolean removeString(String str);

    /* renamed from: com.ss.ttvideoengine.database.IKVStorage$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$clear(IKVStorage iKVStorage) {
            throw new UnsupportedOperationException("Not implemented on this kv store");
        }

        public static String $default$getString(IKVStorage iKVStorage, String str) {
            throw new UnsupportedOperationException("Not implemented on this kv store");
        }

        public static boolean $default$removeString(IKVStorage iKVStorage, String str) {
            throw new UnsupportedOperationException("Not implemented on this kv store");
        }

        public static boolean $default$putString(IKVStorage iKVStorage, String str, String str2) {
            throw new UnsupportedOperationException("Not implemented on this kv store");
        }
    }
}
