package is4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.SparseBooleanArray;
import com.bytedance.covode.number.Covode;
import com.dragon.read.app.App;
import com.dragon.read.base.ssconfig.template.KmpRecentRead;
import com.dragon.read.base.util.ListUtils;
import com.dragon.read.base.util.LogHelper;
import com.dragon.read.base.util.LogInfoUtils;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.component.biz.api.NsBookmallApi;
import com.dragon.read.kmp.bookmall.floatview.FloatViewShowManager;
import com.dragon.read.kmp.bookmall.floatview.controller.task.FloatViewTaskHelper;
import com.dragon.read.local.CacheWrapper;
import com.dragon.read.pages.main.recentread.j0;
import com.dragon.read.rpc.model.GetMessageResultType;
import com.dragon.read.rpc.model.GetMessageType;
import com.dragon.read.rpc.model.MessageGroup;
import com.dragon.read.rpc.model.MessageType;
import com.dragon.read.rpc.model.MsgApiERR;
import com.dragon.read.rpc.model.SyncAllRequest;
import com.dragon.read.rpc.model.SyncAllResponse;
import com.dragon.read.rpc.model.SyncData;
import com.dragon.read.rpc.model.SyncMsgBody;
import com.dragon.read.rpc.model.SyncParam;
import com.dragon.read.rpc.rpc.MsgApiService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import qo3.l0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class e {
    private static final LogHelper d;
    private SparseBooleanArray a = new SparseBooleanArray();
    private final SharedPreferences b = CacheWrapper.h(App.context(), "msg_config");
    private Map<MessageType, List<SyncMsgBody>> c = new HashMap();

    public static e g() {
        return f.a;
    }

    interface f {
        public static final e a;

        static {
            Covode.recordClassIndex(612348);
            a = new e();
        }
    }

    static {
        Covode.recordClassIndex(612347);
        d = new LogHelper("MsgManager");
    }

    private boolean j() {
        if (!this.a.get(0) || !this.a.get(1)) {
            return false;
        }
        return true;
    }

    public void q() {
        LogWrapper.info("MARKET_DEBUG | MsgManager", "start_sync", new Object[0]);
        r(0, new ArrayList());
        r(1, new ArrayList());
    }

    private void s() {
        if (KmpRecentRead.b().enable) {
            FloatViewTaskHelper.a.n(false);
            if (FloatViewShowManager.a.hasShown()) {
                return;
            }
            FloatViewTaskHelper.p(new Function1() { // from class: is4.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit k;
                    k = e.k((Boolean) obj);
                    return k;
                }
            }, new Function1() { // from class: is4.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit l;
                    l = e.l((Throwable) obj);
                    return l;
                }
            });
            return;
        }
        l0 m = NsBookmallApi.IMPL.managerService().recentReadManager().m();
        m.f(false);
        if (!m.g() && !j0.a.p0()) {
            m.k().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d());
        }
    }

    class c implements Function<SyncAllResponse, List<SyncData>> {
        c() {
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<SyncData> apply(SyncAllResponse syncAllResponse) throws Exception {
            MsgApiERR msgApiERR;
            if (syncAllResponse != null && syncAllResponse.code == MsgApiERR.SUCCESS && !ListUtils.isEmpty(syncAllResponse.data)) {
                return syncAllResponse.data;
            }
            i iVar = i.a;
            if (syncAllResponse != null) {
                msgApiERR = syncAllResponse.code;
            } else {
                msgApiERR = null;
            }
            iVar.n(msgApiERR, null);
            return null;
        }
    }

    class d implements Consumer<Boolean> {
        d() {
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Boolean bool) throws Exception {
            if (bool.booleanValue()) {
                App.sendLocalBroadcast(new Intent(NsBookmallApi.ACTION_SHOW_LATEST_READ_FLOATING_VIEW));
            }
        }
    }

    /* renamed from: is4.e$e, reason: collision with other inner class name */
    class C0193e implements Comparator<SyncMsgBody> {
        C0193e() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(SyncMsgBody syncMsgBody, SyncMsgBody syncMsgBody2) {
            long j = syncMsgBody.createTime;
            long j2 = syncMsgBody2.createTime;
            if (j < j2) {
                return 1;
            }
            if (j == j2) {
                return 0;
            }
            return -1;
        }
    }

    class b implements Consumer<Throwable> {
        final /* synthetic */ int a;
        final /* synthetic */ List b;

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            i.a.n(null, th);
            e.this.m(this.a, this.b);
        }

        b(int i, List list) {
            this.a = i;
            this.b = list;
        }
    }

    public List<SyncMsgBody> i(MessageType messageType) {
        Map<MessageType, List<SyncMsgBody>> map = this.c;
        if (map != null && messageType != null) {
            return map.get(messageType);
        }
        return null;
    }

    public void n(MessageType messageType) {
        Map<MessageType, List<SyncMsgBody>> map = this.c;
        if (map != null && messageType != null) {
            map.remove(messageType);
        }
    }

    public void p(List list) {
        Collections.sort(list, new C0193e());
    }

    private void f(MessageType messageType) {
        if (messageType == null) {
            return;
        }
        Intent intent = new Intent("action_reading_msg_sync");
        LogWrapper.info("ProduceIncome", "发送广播", new Object[0]);
        intent.putExtra("key_msg_type", (Serializable) messageType);
        App.sendLocalBroadcast(intent);
    }

    private long h(int i) {
        return this.b.getLong("key.last.seq." + i, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit k(Boolean bool) {
        if (bool.booleanValue()) {
            App.sendLocalBroadcast(new Intent(NsBookmallApi.ACTION_SHOW_LATEST_READ_FLOATING_VIEW));
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit l(Throwable th) {
        d.e("获取话题弹窗与继续阅读弹窗优先级失败, error = %s", new Object[]{LogInfoUtils.getErrorInfo(th)});
        return null;
    }

    class a implements Consumer<List<SyncData>> {
        final /* synthetic */ int a;
        final /* synthetic */ List b;
        final /* synthetic */ SyncParam c;

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(List<SyncData> list) throws Exception {
            if (!ListUtils.isEmpty(list)) {
                SyncData syncData = null;
                long j = Long.MIN_VALUE;
                for (SyncData syncData2 : list) {
                    if (syncData2.dataType == GetMessageType.findByValue(this.a)) {
                        if (syncData2.messageCode != GetMessageResultType.SUCCESS) {
                            syncData = syncData2;
                        } else {
                            e.this.o(this.a, syncData2.maxSeq);
                            j = syncData2.maxSeq;
                            e.d.i("MsgManager, data type = %s, data is %s", new Object[]{syncData2.dataType, syncData2.newData});
                            if (!ListUtils.isEmpty(syncData2.newData)) {
                                this.b.addAll(syncData2.newData);
                            }
                            if (syncData2.hasMore) {
                                i iVar = i.a;
                                iVar.i(this.c, syncData, list, j);
                                iVar.h(this.c, syncData2, list);
                                e.this.r(this.a, this.b);
                                return;
                            }
                        }
                    }
                }
                i iVar2 = i.a;
                iVar2.i(this.c, syncData, list, j);
                iVar2.m(this.b.size());
            }
            e.this.m(this.a, this.b);
        }

        a(int i, List list, SyncParam syncParam) {
            this.a = i;
            this.b = list;
            this.c = syncParam;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(int i, long j) {
        this.b.edit().putLong("key.last.seq." + i, j).apply();
    }

    public void r(int i, List<MessageGroup> list) {
        SyncAllRequest syncAllRequest = new SyncAllRequest();
        syncAllRequest.synclist = new ArrayList();
        SyncParam syncParam = new SyncParam();
        syncParam.dataType = i;
        syncParam.minSeq = h(i);
        syncParam.maxSeq = Long.MAX_VALUE;
        syncAllRequest.synclist.add(syncParam);
        MsgApiService.syncAllRxJava(syncAllRequest).map(new c()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(i, list, syncParam), new b(i, list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(int i, List<MessageGroup> list) {
        LogHelper logHelper = d;
        logHelper.i("postMessageGroupList, dataType is: %s, messageGroupList is: %s", new Object[]{Integer.valueOf(i), list});
        this.a.append(i, true);
        if (!j()) {
            if (ListUtils.isEmpty(list)) {
                logHelper.i("syncAll messageGroupList is null or empty", new Object[0]);
                return;
            }
            logHelper.i("syncAll 消息收到两次之后合并才发送广播", new Object[0]);
            for (MessageGroup messageGroup : list) {
                List<SyncMsgBody> list2 = this.c.get(messageGroup.type);
                if (list2 == null) {
                    list2 = new ArrayList<>();
                }
                list2.addAll(messageGroup.data);
                this.c.put(messageGroup.type, list2);
                i.a.l(messageGroup.type, list2.size());
            }
            return;
        }
        if (ListUtils.isEmpty(list) && this.c.isEmpty()) {
            logHelper.i("syncAll messageGroupList is null or empty", new Object[0]);
            s();
            return;
        }
        logHelper.i("syncAll 消息收到两次, 合并消息发送广播", new Object[0]);
        for (MessageGroup messageGroup2 : list) {
            List<SyncMsgBody> list3 = this.c.get(messageGroup2.type);
            if (list3 == null) {
                list3 = new ArrayList<>();
            }
            list3.addAll(messageGroup2.data);
            this.c.put(messageGroup2.type, list3);
            i.a.l(messageGroup2.type, list3.size());
        }
        for (Map.Entry<MessageType, List<SyncMsgBody>> entry : this.c.entrySet()) {
            p(entry.getValue());
            n.c().l(entry.getValue(), entry.getKey());
            d.i("broadcastMsgEvent发送消息广播, 当前msgType为: %s", new Object[]{entry.getKey()});
            f(entry.getKey());
        }
        this.a.clear();
        if (ListUtils.isEmpty(this.c.get(MessageType.OUT_BOOK_TOPIC_EMPTY_REPLY))) {
            s();
        }
    }
}
