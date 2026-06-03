package com.ss.ttm.player;

import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.ttm.vcshared.VCBaseKitLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class TTPlayerLibLoader {
    private static boolean IsErrored;
    private static final String TAG;
    private static ILibraryLoader mDebugLibraryLoader;
    private static ILibraryLoader mDefaultLibLoader;
    private static String mErrorInfo;
    private static boolean mLibraryLoaded;
    private static ILibraryLoader mLibraryLoader;
    private static int mVersion;
    private static String playerLibName;

    public static String getErrorInfo() {
        return mErrorInfo;
    }

    public static String getPlayerLibName() {
        return playerLibName;
    }

    public static boolean isError() {
        return IsErrored;
    }

    static {
        Covode.recordClassIndex(652188);
        TAG = TTPlayerLibLoader.class.getSimpleName();
        mDefaultLibLoader = new DefaultLibraryLoader();
        mLibraryLoaded = false;
        IsErrored = false;
        mErrorInfo = null;
        mVersion = 0;
        playerLibName = "";
    }

    public static final synchronized void loadLibrary() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z20;
        boolean z21;
        boolean z22;
        synchronized (TTPlayerLibLoader.class) {
            try {
                if (mVersion == 0) {
                    mVersion = TTPlayerConfiger.getValue(13, 0) / 1000;
                }
                VCBaseKitLoader.loadLibrary();
                Log.d(TAG, "pgo player setting = " + TTPlayerConfiger.getValue(76, ""));
                if (mVersion == 2925) {
                    z = true;
                } else {
                    z = false;
                }
                if (TTPlayerConfiger.getValue(3, false)) {
                    if (!z) {
                        if (!TTPlayerConfiger.getValue(30, false)) {
                            System.loadLibrary("c++_shared");
                        }
                        if (!TTPlayerConfiger.getValue(28, false)) {
                            loadPlayerlibrary("ttcrypto");
                            loadPlayerlibrary("ttboringssl");
                        }
                        loadPlayerlibrary("ByteVC1_dec");
                        loadPlayerlibrary("byteVC2dec");
                        loadPlayerlibrary("ttffmpeg");
                    }
                    if (TTPlayerConfiger.getValue(29, false)) {
                        if (!loadPlayerlibrary("ttmplayerbeta")) {
                            if (!loadPlayerlibrary("ttmplayer")) {
                                z22 = true;
                            } else {
                                z22 = false;
                            }
                            IsErrored = z22;
                        } else {
                            playerLibName = "ttmplayerbeta";
                        }
                    } else if (TTPlayerConfiger.getValue(76, "").equals("default")) {
                        if (!loadPlayerlibrary("ttmplayerdef")) {
                            if (!loadPlayerlibrary("ttmplayer")) {
                                z21 = true;
                            } else {
                                z21 = false;
                            }
                            IsErrored = z21;
                        } else {
                            playerLibName = "ttmplayerdef";
                        }
                    } else if (TTPlayerConfiger.getValue(76, "").equals("pgo")) {
                        if (!loadPlayerlibrary("ttmplayerpgo")) {
                            if (!loadPlayerlibrary("ttmplayer")) {
                                z20 = true;
                            } else {
                                z20 = false;
                            }
                            IsErrored = z20;
                        } else {
                            playerLibName = "ttmplayerpgo";
                        }
                    } else if (TTPlayerConfiger.getValue(76, "").equals("bytepgo")) {
                        if (!loadPlayerlibrary("ttmplayerbytepgo")) {
                            if (!loadPlayerlibrary("ttmplayer")) {
                                z19 = true;
                            } else {
                                z19 = false;
                            }
                            IsErrored = z19;
                        } else {
                            playerLibName = "ttmplayerbytepgo";
                        }
                    } else if (TTPlayerConfiger.getValue(76, "").equals("o3")) {
                        if (!loadPlayerlibrary("ttmplayero3")) {
                            if (!loadPlayerlibrary("ttmplayer")) {
                                z18 = true;
                            } else {
                                z18 = false;
                            }
                            IsErrored = z18;
                        } else {
                            playerLibName = "ttmplayero3";
                        }
                    } else if (!loadPlayerlibrary("ttmplayer")) {
                        IsErrored = true;
                    }
                    if (!IsErrored && playerLibName.isEmpty()) {
                        playerLibName = "ttmplayer";
                    }
                    if (!IsErrored) {
                        loadLibs(new ArrayList(Arrays.asList("ttmpaflns")), true);
                        if (TTPlayerConfiger.getValue(83, true)) {
                            loadLibs(new ArrayList(Arrays.asList("ttmpaflna")), true);
                        }
                        if (TTPlayerConfiger.getValue(78, false)) {
                            loadLibs(new ArrayList(Arrays.asList("ttmaudioprocess")), true);
                        }
                    }
                } else {
                    ArrayList arrayList = new ArrayList();
                    if (!z) {
                        if (!TTPlayerConfiger.getValue(30, false)) {
                            arrayList.add("c++_shared");
                        }
                        if (!TTPlayerConfiger.getValue(28, false)) {
                            arrayList.add("ttcrypto");
                            arrayList.add("ttboringssl");
                        }
                        arrayList.add("ByteVC1_dec");
                        arrayList.add("byteVC2dec");
                        arrayList.add("ttffmpeg");
                    }
                    if (TTPlayerConfiger.getValue(29, false)) {
                        if (!loadLibs(arrayList, false)) {
                            z15 = true;
                        } else {
                            z15 = false;
                        }
                        IsErrored = z15;
                        if (!z15) {
                            arrayList.clear();
                            arrayList.add("ttmplayerbeta");
                            if (!loadLibs(arrayList, true)) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            IsErrored = z16;
                            if (!z16) {
                                playerLibName = "ttmplayerbeta";
                            } else {
                                arrayList.clear();
                                arrayList.add("ttmplayer");
                                if (!loadLibs(arrayList, true)) {
                                    z17 = true;
                                } else {
                                    z17 = false;
                                }
                                IsErrored = z17;
                            }
                        }
                    } else if (TTPlayerConfiger.getValue(76, "").equals("default")) {
                        if (!loadLibs(arrayList, false)) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        IsErrored = z12;
                        if (!z12) {
                            arrayList.clear();
                            arrayList.add("ttmplayerdef");
                            if (!loadLibs(arrayList, true)) {
                                z13 = true;
                            } else {
                                z13 = false;
                            }
                            IsErrored = z13;
                            if (!z13) {
                                playerLibName = "ttmplayerdef";
                            } else {
                                arrayList.clear();
                                arrayList.add("ttmplayer");
                                if (!loadLibs(arrayList, true)) {
                                    z14 = true;
                                } else {
                                    z14 = false;
                                }
                                IsErrored = z14;
                            }
                        }
                    } else if (TTPlayerConfiger.getValue(76, "").equals("pgo")) {
                        if (!loadLibs(arrayList, false)) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        IsErrored = z9;
                        if (!z9) {
                            arrayList.clear();
                            arrayList.add("ttmplayerpgo");
                            if (!loadLibs(arrayList, true)) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            IsErrored = z10;
                            if (!z10) {
                                playerLibName = "ttmplayerpgo";
                            } else {
                                arrayList.clear();
                                arrayList.add("ttmplayer");
                                if (!loadLibs(arrayList, true)) {
                                    z11 = true;
                                } else {
                                    z11 = false;
                                }
                                IsErrored = z11;
                            }
                        }
                    } else if (TTPlayerConfiger.getValue(76, "").equals("bytepgo")) {
                        if (!loadLibs(arrayList, false)) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        IsErrored = z6;
                        if (!z6) {
                            arrayList.clear();
                            arrayList.add("ttmplayerbytepgo");
                            if (!loadLibs(arrayList, true)) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            IsErrored = z7;
                            if (!z7) {
                                playerLibName = "ttmplayerbytepgo";
                            } else {
                                arrayList.clear();
                                arrayList.add("ttmplayer");
                                if (!loadLibs(arrayList, true)) {
                                    z8 = true;
                                } else {
                                    z8 = false;
                                }
                                IsErrored = z8;
                            }
                        }
                    } else if (TTPlayerConfiger.getValue(76, "").equals("o3")) {
                        if (!loadLibs(arrayList, false)) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        IsErrored = z3;
                        if (!z3) {
                            arrayList.clear();
                            arrayList.add("ttmplayero3");
                            if (!loadLibs(arrayList, true)) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            IsErrored = z4;
                            if (!z4) {
                                playerLibName = "ttmplayero3";
                            } else {
                                arrayList.clear();
                                arrayList.add("ttmplayer");
                                if (!loadLibs(arrayList, true)) {
                                    z5 = true;
                                } else {
                                    z5 = false;
                                }
                                IsErrored = z5;
                            }
                        }
                    } else {
                        arrayList.add("ttmplayer");
                        if (!loadLibs(arrayList, false)) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        IsErrored = z2;
                    }
                    if (!IsErrored && playerLibName.isEmpty()) {
                        playerLibName = "ttmplayer";
                    }
                    if (!IsErrored) {
                        loadLibs(new ArrayList(Arrays.asList("ttmpaflns")), true);
                        if (TTPlayerConfiger.getValue(83, true)) {
                            loadLibs(new ArrayList(Arrays.asList("ttmpaflna")), true);
                        }
                        if (TTPlayerConfiger.getValue(78, false)) {
                            loadLibs(new ArrayList(Arrays.asList("ttmaudioprocess")), true);
                        }
                    }
                }
            } catch (Throwable th) {
                IsErrored = true;
                th.printStackTrace();
                mErrorInfo = "load default library error." + th.toString();
            }
        }
    }

    public static final void setDebugLibraryLoader(ILibraryLoader iLibraryLoader) {
        mDebugLibraryLoader = iLibraryLoader;
    }

    public static final void setLibraryLoader(ILibraryLoader iLibraryLoader) {
        mLibraryLoader = iLibraryLoader;
    }

    private static class DefaultLibraryLoader implements ILibraryLoader {
        static {
            Covode.recordClassIndex(652189);
        }

        private DefaultLibraryLoader() {
        }

        @Override // com.ss.ttm.player.ILibraryLoader
        public boolean onLoadNativeLibs(List<String> list) {
            for (String str : list) {
                try {
                    System.loadLibrary(str);
                    Log.d(TTPlayerLibLoader.TAG, "main load " + str + " done");
                } catch (Throwable th) {
                    String unused = TTPlayerLibLoader.mErrorInfo = th.getMessage();
                    Log.d(TTPlayerLibLoader.TAG, "main load lib failed = " + str + ",error:" + TTPlayerLibLoader.mErrorInfo);
                    return false;
                }
            }
            return true;
        }
    }

    private static boolean loadPlayerlibrary(String str) {
        String str2;
        try {
            TTPlayerConfiger.setLibraryName("lib" + str + ".so");
            TTPlayerConfiger.checkDebugTTPlayerLib();
            str2 = TTPlayerConfiger.getPlayerLibraryPath();
            if (str2 != null && !new PolarisFileWrapper(str2).exists()) {
                str2 = null;
            }
            if (str2 != null) {
                if (mDebugLibraryLoader != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(str2);
                    Log.d(TAG, "load library path = " + str2);
                    mDebugLibraryLoader.onLoadNativeLibs(arrayList);
                } else {
                    System.load(str2);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            mErrorInfo = "load path library error." + th.toString();
            str2 = null;
        }
        if (str2 == null) {
            try {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(str);
                loadLibs(arrayList2, true);
                mErrorInfo = null;
            } catch (Throwable unused) {
                Log.e(TAG, "load lib failed name = " + str);
                return false;
            }
        }
        return true;
    }

    private static boolean loadLibs(List<String> list, boolean z) {
        boolean z2 = mLibraryLoaded;
        if ((!z) & z2) {
            return z2;
        }
        ILibraryLoader iLibraryLoader = mLibraryLoader;
        if (iLibraryLoader != null) {
            try {
                mLibraryLoaded = iLibraryLoader.onLoadNativeLibs(list);
            } catch (Throwable th) {
                mErrorInfo = th.getMessage();
            }
        } else {
            mLibraryLoaded = mDefaultLibLoader.onLoadNativeLibs(list);
        }
        return mLibraryLoaded;
    }
}
