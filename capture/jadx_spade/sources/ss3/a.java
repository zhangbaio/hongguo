package ss3;

import androidx.compose.animation.m;
import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.data.ugc.AlbumDetailModel;
import io.reactivex.Observable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import seriessdk.com.dragon.read.saas.rpc.model.GetVideoAlbumDetailRequest;
import seriessdk.com.dragon.read.saas.rpc.model.GetVideoAlbumDetailResponse;
import seriessdk.com.dragon.read.saas.rpc.model.GetVideoDetailRequest;
import seriessdk.com.dragon.read.saas.rpc.model.GetVideoDetailResponse;
import seriessdk.com.dragon.read.saas.rpc.model.GetVideoModelRequest;
import seriessdk.com.dragon.read.saas.rpc.model.GetVideoModelResponse;
import seriessdk.com.dragon.read.saas.rpc.model.MGetVideoDetailResponse;
import seriessdk.com.dragon.read.saas.rpc.model.MGetVideoDetailV2Request;
import seriessdk.com.dragon.read.saas.rpc.model.MGetVideoModelResponse;
import seriessdk.com.dragon.read.saas.rpc.model.MGetVideoModelV2Request;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface a {
    AlbumDetailModel a(String str, GetVideoAlbumDetailResponse getVideoAlbumDetailResponse);

    Observable<GetVideoAlbumDetailResponse> b(GetVideoAlbumDetailRequest getVideoAlbumDetailRequest);

    Observable<GetVideoDetailResponse> c(GetVideoDetailRequest getVideoDetailRequest);

    Observable<MGetVideoDetailResponse> d(MGetVideoDetailV2Request mGetVideoDetailV2Request);

    Observable<MGetVideoModelResponse> e(MGetVideoModelV2Request mGetVideoModelV2Request, C0268a c0268a);

    Observable<GetVideoModelResponse> f(GetVideoModelRequest getVideoModelRequest);

    /* renamed from: ss3.a$a, reason: collision with other inner class name */
    public static final class C0268a {
        public String a;
        public boolean b;

        static {
            Covode.recordClassIndex(599067);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C0268a() {
            this(null, false, 3, 0 == true ? 1 : 0);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0268a)) {
                return false;
            }
            C0268a c0268a = (C0268a) obj;
            return Intrinsics.areEqual(this.a, c0268a.a) && this.b == c0268a.b;
        }

        public int hashCode() {
            String str = this.a;
            return ((str == null ? 0 : str.hashCode()) * 31) + m.a(this.b);
        }

        public String toString() {
            return "MultiVideoModelRequestExtraData(videoId=" + this.a + ", isOnlyVideoId=" + this.b + ')';
        }

        public C0268a(String str, boolean z) {
            this.a = str;
            this.b = z;
        }

        public /* synthetic */ C0268a(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? false : z);
        }
    }
}
