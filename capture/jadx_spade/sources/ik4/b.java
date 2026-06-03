package ik4;

import androidx.collection.LruCache;
import com.bytedance.covode.number.Covode;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.kmp.network.NetError;
import com.bytedance.kmp.network.Protocol;
import com.bytedance.kmp.network.f;
import com.bytedance.kmp.network.nqe.EffectiveConnectionType;
import com.bytedance.kmp.network.response.e;
import com.bytedance.kmp.network.response.i;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.dragon.read.kmp.network.INetworkApi;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okio.BufferedSink;
import okio.Okio;
import okio.Sink;
import okio.Source;
import zn0.d;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b implements com.bytedance.kmp.network.c {
    public static final a a;
    private static final LruCache<String, INetworkApi> b;
    private static final HashMap<Integer, Call<?>> c;

    public static final class a {
        static {
            Covode.recordClassIndex(607861);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void A9(com.bytedance.kmp.network.nqe.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    public static final class c implements TypedOutput {
        final /* synthetic */ d a;

        public String fileName() {
            return "";
        }

        public String md5Stub() {
            return "";
        }

        public long length() {
            return this.a.a();
        }

        public String mimeType() {
            String b = this.a.b();
            if (b == null) {
                return "";
            }
            return b;
        }

        c(d dVar) {
            this.a = dVar;
        }

        public void writeTo(OutputStream outputStream) {
            BufferedSink bufferedSink;
            Sink sink;
            if (outputStream != null && (sink = Okio.sink(outputStream)) != null) {
                bufferedSink = Okio.buffer(sink);
            } else {
                bufferedSink = null;
            }
            this.a.c(bufferedSink);
            if (bufferedSink != null) {
                bufferedSink.flush();
            }
        }
    }

    /* renamed from: ik4.b$b, reason: collision with other inner class name */
    private static final class C0169b extends e {
        public final TypedInput a;

        static {
            Covode.recordClassIndex(607862);
        }

        public long d() {
            TypedInput typedInput = this.a;
            if (typedInput != null) {
                return typedInput.length();
            }
            return 0L;
        }

        public Source a() {
            InputStream in;
            TypedInput typedInput = this.a;
            if (typedInput != null && (in = typedInput.in()) != null) {
                return Okio.source(in);
            }
            return null;
        }

        public C0169b(TypedInput typedInput) {
            this.a = typedInput;
        }
    }

    static {
        Covode.recordClassIndex(607860);
        a = new a(null);
        b = new LruCache<>(10);
        c = new HashMap<>();
    }

    private final TypedOutput J0(d dVar) {
        if (dVar == null) {
            return null;
        }
        return new c(dVar);
    }

    public Object u9(Continuation<? super com.bytedance.kmp.network.nqe.b> continuation) {
        return new com.bytedance.kmp.network.nqe.b((EffectiveConnectionType) null, (com.bytedance.kmp.network.nqe.d) null, (com.bytedance.kmp.network.nqe.c) null, (com.bytedance.kmp.network.nqe.c) null, 15, (DefaultConstructorMarker) null);
    }

    private final com.bytedance.kmp.network.b F0(Header header) {
        com.bytedance.kmp.network.b bVar = new com.bytedance.kmp.network.b();
        String name = header.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        bVar.a(name);
        String value = header.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        bVar.b(value);
        return bVar;
    }

    private final NetError z0(int i, TypedInput typedInput) {
        NetError netError = new NetError();
        netError.setTtnetStatusCode(i);
        if (typedInput != null) {
            byte[] bArr = new byte[(int) typedInput.length()];
            typedInput.in().read(bArr);
            netError.setErrorRespBody(bArr);
            netError.setErrorMessage(new String(bArr, Charsets.UTF_8));
        }
        return netError;
    }

    public Object P6(zn0.c cVar, Continuation<? super com.bytedance.kmp.network.response.d> continuation) {
        TypedOutput typedOutput;
        Call<TypedInput> post;
        HashMap<Integer, Call<?>> hashMap;
        NetError z0;
        Map<String, Object> emptyMap;
        String addCommonParams = NetworkParams.addCommonParams(cVar.a, true, (RetrofitMetrics) null);
        if (addCommonParams == null) {
            addCommonParams = cVar.a;
        }
        LruCache<String, INetworkApi> lruCache = b;
        INetworkApi iNetworkApi = (INetworkApi) lruCache.get(addCommonParams);
        if (iNetworkApi == null) {
            Object createSsService = RetrofitUtils.createSsService(addCommonParams, INetworkApi.class);
            INetworkApi iNetworkApi2 = (INetworkApi) createSsService;
            Intrinsics.checkNotNull(iNetworkApi2);
            lruCache.put(addCommonParams, iNetworkApi2);
            Intrinsics.checkNotNullExpressionValue(createSsService, "also(...)");
            iNetworkApi = iNetworkApi2;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(cVar.c);
        linkedHashMap.put("X-Xs-From-Web", "0");
        if (Intrinsics.areEqual(cVar.b, "GET")) {
            Set<Map.Entry> entrySet = linkedHashMap.entrySet();
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(entrySet, 10));
            for (Map.Entry entry : entrySet) {
                arrayList.add(new Header((String) entry.getKey(), (String) entry.getValue()));
            }
            emptyMap = MapsKt__MapsKt.emptyMap();
            post = iNetworkApi.get(addCommonParams, true, arrayList, emptyMap);
        } else {
            Set<Map.Entry> entrySet2 = linkedHashMap.entrySet();
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(entrySet2, 10));
            for (Map.Entry entry2 : entrySet2) {
                arrayList2.add(new Header((String) entry2.getKey(), (String) entry2.getValue()));
            }
            d dVar = cVar.d;
            if (dVar != null) {
                typedOutput = J0(dVar);
            } else {
                typedOutput = null;
            }
            post = iNetworkApi.post(addCommonParams, true, arrayList2, typedOutput);
        }
        int hashCode = cVar.hashCode();
        synchronized (this) {
            Integer boxInt = Boxing.boxInt(hashCode);
            hashMap = c;
            hashMap.put(boxInt, post);
            Unit unit = Unit.INSTANCE;
        }
        try {
            SsResponse execute = post.execute();
            synchronized (this) {
                hashMap.remove(Boxing.boxInt(hashCode));
            }
            Protocol protocol = Protocol.UNKNOWN;
            String message = execute.message();
            if (message == null) {
                message = "";
            }
            String str = message;
            int code = execute.code();
            List<Header> headers = execute.headers();
            Intrinsics.checkNotNullExpressionValue(headers, "headers(...)");
            ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(headers, 10));
            for (Header header : headers) {
                Intrinsics.checkNotNull(header);
                arrayList3.add(F0(header));
            }
            C0169b c0169b = new C0169b((TypedInput) execute.body());
            if (execute.isSuccessful()) {
                z0 = null;
            } else {
                z0 = z0(execute.code(), execute.errorBody());
            }
            return new com.bytedance.kmp.network.response.d(cVar, protocol, str, code, arrayList3, c0169b, z0, (f) null);
        } catch (Throwable th) {
            synchronized (this) {
                c.remove(Boxing.boxInt(hashCode));
                throw th;
            }
        }
    }

    public Object G4(zn0.c cVar, i iVar, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }
}
