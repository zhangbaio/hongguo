package yq4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.saas.ugc.model.ImageData;
import com.dragon.read.saas.ugc.model.UgcVideoDetail;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import java.io.File;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface x {

    public interface d {
        void a(int i, a aVar);

        void onUploadStart();
    }

    public interface f {
        void a(long j);

        void b(int i, b bVar);

        void onUploadStart();
    }

    Single<e> a(String str, String str2, f fVar);

    Single<e> b(File file, d dVar);

    void c();

    void d(Disposable disposable);

    void tryDisposeUploadTask();

    public static final class a {
        public static final int c;
        public final ImageData a;
        public final c b;

        static {
            Covode.recordClassIndex(611394);
            c = 8;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public a() {
            /*
                r2 = this;
                r0 = 0
                r1 = 3
                r2.<init>(r0, r0, r1, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: yq4.x.a.<init>():void");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.a, aVar.a) && Intrinsics.areEqual(this.b, aVar.b);
        }

        public int hashCode() {
            ImageData imageData = this.a;
            int hashCode = (imageData == null ? 0 : imageData.hashCode()) * 31;
            c cVar = this.b;
            return hashCode + (cVar != null ? cVar.hashCode() : 0);
        }

        public String toString() {
            return "CommentImageDataWrapper(commentImageData=" + this.a + ", imageQualityData=" + this.b + ')';
        }

        public a(ImageData imageData, c cVar) {
            this.a = imageData;
            this.b = cVar;
        }

        public /* synthetic */ a(ImageData imageData, c cVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : imageData, (i & 2) != 0 ? null : cVar);
        }
    }

    public static final class b {
        public static final int c;
        public final UgcVideoDetail a;
        public final String b;

        static {
            Covode.recordClassIndex(611395);
            c = 8;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public b() {
            /*
                r2 = this;
                r0 = 0
                r1 = 3
                r2.<init>(r0, r0, r1, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: yq4.x.b.<init>():void");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics.areEqual(this.a, bVar.a) && Intrinsics.areEqual(this.b, bVar.b);
        }

        public int hashCode() {
            UgcVideoDetail ugcVideoDetail = this.a;
            int hashCode = (ugcVideoDetail == null ? 0 : ugcVideoDetail.hashCode()) * 31;
            String str = this.b;
            return hashCode + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "CommentVideoDataWrapper(commentVideoData=" + this.a + ", errorMsg=" + this.b + ')';
        }

        public b(UgcVideoDetail ugcVideoDetail, String str) {
            this.a = ugcVideoDetail;
            this.b = str;
        }

        public /* synthetic */ b(UgcVideoDetail ugcVideoDetail, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : ugcVideoDetail, (i & 2) != 0 ? null : str);
        }
    }

    public static final class e {
        public final boolean a;
        public final String b;
        public final int c;

        static {
            Covode.recordClassIndex(611399);
        }

        public e(boolean z, String msg, int i) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            this.a = z;
            this.b = msg;
            this.c = i;
        }
    }

    public static final class c {
        public final int a;
        public final int b;
        public final float c;

        static {
            Covode.recordClassIndex(611397);
        }

        public c() {
            this(0, 0, 0.0f, 7, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.a == cVar.a && this.b == cVar.b && Float.compare(this.c, cVar.c) == 0;
        }

        public int hashCode() {
            return (((this.a * 31) + this.b) * 31) + Float.floatToIntBits(this.c);
        }

        public String toString() {
            return "ImageQualityData(originPicWidth=" + this.a + ", originPicHeight=" + this.b + ", originPicByteSize=" + this.c + ')';
        }

        public c(int i, int i2, float f) {
            this.a = i;
            this.b = i2;
            this.c = f;
        }

        public /* synthetic */ c(int i, int i2, float f, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? 0.0f : f);
        }
    }
}
