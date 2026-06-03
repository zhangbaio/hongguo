package vs4;

import android.content.SharedPreferences;
import com.bytedance.covode.number.Covode;
import com.dragon.read.NsCommonDepend;
import com.dragon.read.app.App;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.local.KvCacheMgr;
import com.dragon.read.nps.ui.NpsPopMemoryCache;
import com.dragon.read.rpc.model.GetUserResearchRequest;
import com.dragon.read.rpc.model.GetUserResearchRespData;
import com.dragon.read.rpc.model.GetUserResearchResponse;
import com.dragon.read.rpc.model.ResearchSceneType;
import com.dragon.read.rpc.model.UserResearchData;
import com.dragon.read.util.DebugManager;
import com.dragon.read.util.v6;
import com.ss.android.ugc.bytex.taskmonitor.proxy.CompletableDelegate;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class n {
    public static final n a;
    private static UserResearchData b;
    private static ResearchSceneType c;
    private static String d;
    private static boolean e;
    private static final SharedPreferences f;
    public static final int g;

    private n() {
    }

    public final String s() {
        return d;
    }

    public final UserResearchData t() {
        return b;
    }

    public final ResearchSceneType u() {
        return c;
    }

    private final boolean w() {
        if (!e) {
            z();
        }
        if (b != null) {
            return true;
        }
        return false;
    }

    public final boolean y() {
        return DebugManager.inst().isEnableNpsAllGenreSkipConsumeConditionDebug();
    }

    static {
        Covode.recordClassIndex(612548);
        a = new n();
        f = KvCacheMgr.getPublic(App.context(), "screen_ad_dialog_data_namespace");
        g = 8;
    }

    private final boolean x() {
        if (new Date(NsCommonDepend.IMPL.acctManager().currentTimeMillis()).getHours() < 18 && !DebugManager.inst().isEnableNpsTimeNoControlDebug()) {
            return false;
        }
        return true;
    }

    public final void h() {
        LogWrapper.info("NPS_GLOBAL | NPS_FETCHER", "清空NPS数据", new Object[0]);
        b = null;
        c = null;
        d = null;
        SharedPreferences cache = f;
        Intrinsics.checkNotNullExpressionValue(cache, "cache");
        SharedPreferences.Editor edit = cache.edit();
        edit.putString("nps_response_data_key", "");
        edit.apply();
        Intrinsics.checkNotNullExpressionValue(cache, "cache");
        SharedPreferences.Editor edit2 = cache.edit();
        edit2.putLong("nps_request_time_key", 0L);
        edit2.apply();
        Intrinsics.checkNotNullExpressionValue(cache, "cache");
        SharedPreferences.Editor edit3 = cache.edit();
        edit3.putInt("nps_scene_type_key", 0);
        edit3.apply();
    }

    private final void z() {
        boolean z;
        ObjectInputStream objectInputStream;
        boolean z2 = true;
        e = true;
        LogWrapper.info("NPS_GLOBAL | NPS_FETCHER", "尝试读取本地NPS数据", new Object[0]);
        SharedPreferences sharedPreferences = f;
        String string = sharedPreferences.getString("nps_response_data_key", "");
        int i = sharedPreferences.getInt("nps_scene_type_key", -1);
        ObjectInputStream objectInputStream2 = null;
        String string2 = sharedPreferences.getString("nps_book_id_key", null);
        long j = sharedPreferences.getLong("nps_request_time_key", 0L);
        if (string != null) {
            if (string.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                if (NsCommonDepend.IMPL.acctManager().currentTimeMillis() - j >= 86400000) {
                    LogWrapper.info("NPS_GLOBAL | NPS_FETCHER", "NPS数据保存超过24小时，放弃读取：" + j, new Object[0]);
                    return;
                }
                try {
                    try {
                        objectInputStream = new ObjectInputStream(new ByteArrayInputStream(b.a(string, 0)));
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    Object readObject = objectInputStream.readObject();
                    Intrinsics.checkNotNull(readObject, "null cannot be cast to non-null type com.dragon.read.rpc.model.UserResearchData");
                    b = (UserResearchData) readObject;
                    c = ResearchSceneType.findByValue(i);
                    if (string2 != null) {
                        if (string2.length() <= 0) {
                            z2 = false;
                        }
                        if (z2) {
                            d = string2;
                        }
                    }
                    LogWrapper.info("NPS_GLOBAL | NPS_FETCHER", "NPS数据读取成功，场景:" + c + " 数据:" + b + " bookId:" + d, new Object[0]);
                    try {
                        objectInputStream.close();
                        return;
                    } catch (IOException e3) {
                        e = e3;
                        LogWrapper.info("NPS_GLOBAL | NPS_FETCHER", "input流关闭异常：" + e.getMessage(), new Object[0]);
                        e.printStackTrace();
                        return;
                    }
                } catch (Exception e4) {
                    e = e4;
                    objectInputStream2 = objectInputStream;
                    LogWrapper.info("NPS_GLOBAL | NPS_FETCHER", "NPS数据读取异常：" + e.getMessage(), new Object[0]);
                    e.printStackTrace();
                    if (objectInputStream2 != null) {
                        try {
                            objectInputStream2.close();
                            return;
                        } catch (IOException e5) {
                            e = e5;
                            LogWrapper.info("NPS_GLOBAL | NPS_FETCHER", "input流关闭异常：" + e.getMessage(), new Object[0]);
                            e.printStackTrace();
                            return;
                        }
                    }
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    objectInputStream2 = objectInputStream;
                    if (objectInputStream2 != null) {
                        try {
                            objectInputStream2.close();
                        } catch (IOException e6) {
                            LogWrapper.info("NPS_GLOBAL | NPS_FETCHER", "input流关闭异常：" + e6.getMessage(), new Object[0]);
                            e6.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        }
        LogWrapper.info("NPS_GLOBAL | NPS_FETCHER", "本地数据为空，放弃读取", new Object[0]);
    }

    private final boolean A(List<? extends ResearchSceneType> list) {
        boolean z;
        ResearchSceneType researchSceneType;
        ResearchSceneType researchSceneType2 = ResearchSceneType.ReaderExist;
        if (list.contains(researchSceneType2) && w()) {
            UserResearchData userResearchData = b;
            if (userResearchData != null) {
                researchSceneType = userResearchData.scene;
            } else {
                researchSceneType = null;
            }
            if (researchSceneType == researchSceneType2) {
                z = true;
                LogWrapper.info("NPS_GLOBAL | NPS_FETCHER", "解除当前存在有效nps数据就不请求的限制？ " + z, new Object[0]);
                return z;
            }
        }
        z = false;
        LogWrapper.info("NPS_GLOBAL | NPS_FETCHER", "解除当前存在有效nps数据就不请求的限制？ " + z, new Object[0]);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(List list) {
        LogWrapper.info("NPS_GLOBAL | NPS_FETCHER", "DEBUG指定NPS类型[" + ResearchSceneType.findByValue(DebugManager.inst().getReaderNpsFetchControllerIndex()).name() + "]，跳过当前NPS请求，请求场景：" + list, new Object[0]);
    }

    public final boolean v(ResearchSceneType scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        LogWrapper.info("NPS_GLOBAL | NPS_FETCHER", "检查场景是否有NPS数据可展示：" + scene, new Object[0]);
        if (b == null) {
            LogWrapper.info("NPS_GLOBAL | NPS_FETCHER", "NPS数据为空", new Object[0]);
            return false;
        }
        if (scene != c) {
            LogWrapper.info("NPS_GLOBAL | NPS_FETCHER", "NPS场景不符合，返回null：" + c, new Object[0]);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(c cVar, Throwable th) {
        LogWrapper.error("NPS_GLOBAL | NPS_FETCHER", "【NPS数据拉取异常】: message = " + th.getMessage() + '\n' + v6.e(th) + ' ', new Object[0]);
        if (cVar != null) {
            cVar.a(false);
        }
        return Unit.INSTANCE;
    }

    public final Completable i(ResearchSceneType type, String str, c cVar) {
        ArrayList arrayListOf;
        Intrinsics.checkNotNullParameter(type, "type");
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(type);
        return l(this, arrayListOf, str, cVar, null, 8, null);
    }

    private final void B(final int i, final UserResearchData userResearchData, final String str) {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        LogWrapper.info("NPS_GLOBAL | NPS_FETCHER", "开始对NPS数据本地保存：" + i, new Object[0]);
        CompletableDelegate.fromAction(new Action() { // from class: vs4.m
            @Override // io.reactivex.functions.Action
            public final void run() {
                n.C(byteArrayOutputStream, userResearchData, str, i);
            }
        }).subscribeOn(Schedulers.io()).subscribe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(c cVar, String str, GetUserResearchResponse getUserResearchResponse) {
        UserResearchData userResearchData;
        String str2;
        UserResearchData userResearchData2;
        GetUserResearchRespData getUserResearchRespData;
        UserResearchData userResearchData3;
        GetUserResearchRespData getUserResearchRespData2;
        GetUserResearchRespData getUserResearchRespData3;
        UserResearchData userResearchData4;
        GetUserResearchRespData getUserResearchRespData4;
        ResearchSceneType researchSceneType = null;
        if (getUserResearchResponse != null && (getUserResearchRespData4 = getUserResearchResponse.data) != null) {
            userResearchData = getUserResearchRespData4.userResearchData;
        } else {
            userResearchData = null;
        }
        if (userResearchData == null) {
            LogWrapper.info("NPS_GLOBAL | NPS_FETCHER", "【NPS数据拉取结果为空】", new Object[0]);
            if (cVar != null) {
                cVar.a(false);
            }
            return Unit.INSTANCE;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("【拉取到NPS数据:");
        if (getUserResearchResponse != null && (getUserResearchRespData3 = getUserResearchResponse.data) != null && (userResearchData4 = getUserResearchRespData3.userResearchData) != null) {
            str2 = userResearchData4.researchTitle;
        } else {
            str2 = null;
        }
        sb.append(str2);
        sb.append((char) 12305);
        LogWrapper.info("NPS_GLOBAL | NPS_FETCHER", sb.toString(), new Object[0]);
        if (getUserResearchResponse != null && (getUserResearchRespData2 = getUserResearchResponse.data) != null) {
            userResearchData2 = getUserResearchRespData2.userResearchData;
        } else {
            userResearchData2 = null;
        }
        b = userResearchData2;
        if (getUserResearchResponse != null && (getUserResearchRespData = getUserResearchResponse.data) != null && (userResearchData3 = getUserResearchRespData.userResearchData) != null) {
            researchSceneType = userResearchData3.scene;
        }
        c = researchSceneType;
        d = str;
        if (researchSceneType != null) {
            n nVar = a;
            int value = researchSceneType.getValue();
            UserResearchData userResearchData5 = b;
            Intrinsics.checkNotNull(userResearchData5);
            nVar.B(value, userResearchData5, d);
        }
        if (cVar != null) {
            cVar.a(true);
        }
        com.dragon.read.nps.ui.h.a.a();
        NpsPopMemoryCache.a.a();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Ref$ObjectRef ref$ObjectRef, final String str, String str2, final c cVar) {
        LogWrapper.info("NPS_GLOBAL | NPS_FETCHER", "尝试拉取NPS场景信息：" + ref$ObjectRef.element + ", " + str + ", " + str2, new Object[0]);
        n nVar = a;
        if (!nVar.x()) {
            LogWrapper.info("NPS_GLOBAL | NPS_FETCHER", "当前不在NPS拉取时间范围内，6:00 PM ~ 0:00 PM，放弃拉取", new Object[0]);
            return;
        }
        if (nVar.w() && !nVar.A((List) ref$ObjectRef.element)) {
            LogWrapper.info("NPS_GLOBAL | NPS_FETCHER", "已有有效NPS数据，放弃拉取" + ref$ObjectRef.element, new Object[0]);
            return;
        }
        LogWrapper.info("NPS_GLOBAL | NPS_FETCHER", "【开始拉取NPS数据：" + ref$ObjectRef.element + ", " + str + (char) 12305, new Object[0]);
        GetUserResearchRequest getUserResearchRequest = new GetUserResearchRequest();
        getUserResearchRequest.scene = ResearchSceneType.Default;
        getUserResearchRequest.sceneList = (List) ref$ObjectRef.element;
        getUserResearchRequest.bookId = str;
        getUserResearchRequest.fromWhichToReader = str2;
        Observable o0 = g65.c.o0(getUserResearchRequest);
        final Function1 function1 = new Function1() { // from class: vs4.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit n;
                n = n.n(c.this, str, (GetUserResearchResponse) obj);
                return n;
            }
        };
        Consumer consumer = new Consumer() { // from class: vs4.j
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                n.o(Function1.this, obj);
            }
        };
        final Function1 function12 = new Function1() { // from class: vs4.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit p;
                p = n.p(c.this, (Throwable) obj);
                return p;
            }
        };
        o0.blockingSubscribe(consumer, new Consumer() { // from class: vs4.l
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                n.q(Function1.this, obj);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [T, java.util.ArrayList] */
    public final Completable j(final List<? extends ResearchSceneType> list, final String str, final c cVar, final String str2) {
        ?? arrayListOf;
        Intrinsics.checkNotNullParameter(list, "list");
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = list;
        if (DebugManager.inst().getReaderNpsFetchControllerIndex() != 0) {
            if (((List) ref$ObjectRef.element).contains(ResearchSceneType.findByValue(DebugManager.inst().getReaderNpsFetchControllerIndex()))) {
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(ResearchSceneType.findByValue(DebugManager.inst().getReaderNpsFetchControllerIndex()));
                ref$ObjectRef.element = arrayListOf;
                LogWrapper.info("NPS_GLOBAL | NPS_FETCHER", "DEBUG指定NPS类型[" + ResearchSceneType.findByValue(DebugManager.inst().getReaderNpsFetchControllerIndex()).name() + "]，跳过其他请求，请求场景：" + list, new Object[0]);
            } else {
                Completable fromAction = CompletableDelegate.fromAction(new Action() { // from class: vs4.g
                    @Override // io.reactivex.functions.Action
                    public final void run() {
                        n.r(list);
                    }
                });
                Intrinsics.checkNotNullExpressionValue(fromAction, "fromAction(...)");
                return fromAction;
            }
        }
        Completable subscribeOn = CompletableDelegate.fromAction(new Action() { // from class: vs4.h
            @Override // io.reactivex.functions.Action
            public final void run() {
                n.m(Ref$ObjectRef.this, str, str2, cVar);
            }
        }).subscribeOn(Schedulers.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "subscribeOn(...)");
        return subscribeOn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(ByteArrayOutputStream byteArrayOutputStream, UserResearchData userResearchData, String str, int i) {
        try {
            try {
                long currentTimeMillis = NsCommonDepend.IMPL.acctManager().currentTimeMillis();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                objectOutputStream.writeObject(userResearchData);
                objectOutputStream.flush();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                SharedPreferences cache = f;
                Intrinsics.checkNotNullExpressionValue(cache, "cache");
                SharedPreferences.Editor edit = cache.edit();
                edit.putString("nps_response_data_key", b.f(byteArray, 0));
                edit.apply();
                Intrinsics.checkNotNullExpressionValue(cache, "cache");
                SharedPreferences.Editor edit2 = cache.edit();
                edit2.putLong("nps_request_time_key", currentTimeMillis);
                edit2.apply();
                Intrinsics.checkNotNullExpressionValue(cache, "cache");
                SharedPreferences.Editor edit3 = cache.edit();
                edit3.putInt("nps_scene_type_key", i);
                edit3.apply();
                if (str != null) {
                    Intrinsics.checkNotNullExpressionValue(cache, "cache");
                    SharedPreferences.Editor edit4 = cache.edit();
                    edit4.putString("nps_book_id_key", str);
                    edit4.apply();
                } else {
                    Intrinsics.checkNotNullExpressionValue(cache, "cache");
                    SharedPreferences.Editor edit5 = cache.edit();
                    edit5.putString("nps_book_id_key", "");
                    edit5.apply();
                }
                LogWrapper.info("NPS_GLOBAL | NPS_FETCHER", "NPS数据保存成功：时间：" + currentTimeMillis + " 场景：" + i + " bookID:" + str + " 数据：" + userResearchData, new Object[0]);
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e2) {
                    LogWrapper.info("NPS_GLOBAL | NPS_FETCHER", "数据流关闭异常：" + e2.getMessage(), new Object[0]);
                    e2.printStackTrace();
                }
            } catch (Exception e3) {
                LogWrapper.info("NPS_GLOBAL | NPS_FETCHER", "NPS数据保存异常：" + e3.getMessage(), new Object[0]);
                e3.printStackTrace();
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e4) {
                    LogWrapper.info("NPS_GLOBAL | NPS_FETCHER", "数据流关闭异常：" + e4.getMessage(), new Object[0]);
                    e4.printStackTrace();
                }
            }
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e5) {
                LogWrapper.info("NPS_GLOBAL | NPS_FETCHER", "数据流关闭异常：" + e5.getMessage(), new Object[0]);
                e5.printStackTrace();
            }
            throw th;
        }
    }

    public static /* synthetic */ Completable k(n nVar, ResearchSceneType researchSceneType, String str, c cVar, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            cVar = null;
        }
        return nVar.i(researchSceneType, str, cVar);
    }

    public static /* synthetic */ Completable l(n nVar, List list, String str, c cVar, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            cVar = null;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        return nVar.j(list, str, cVar, str2);
    }
}
