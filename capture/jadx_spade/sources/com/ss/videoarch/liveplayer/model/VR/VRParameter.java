package com.ss.videoarch.liveplayer.model.VR;

import com.bytedance.covode.number.Covode;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class VRParameter {
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public float s;
    public int t;
    public int u;
    public int v;
    private final float a = 0.015625f;
    private final float b = 1.006289f;
    private final float c = 4.0f;
    private final float d = 0.2f;
    public float w = 0.015625f;
    private float x = 1.006289f;
    public float y = 4.0f;
    public float z = 0.2f;
    public float A = -1.0f;
    public float B = 1.1f;
    private float C = 100.0f;
    private float D = 0.7f;

    static {
        Covode.recordClassIndex(653065);
    }

    public int i() {
        return this.j + 1;
    }

    public boolean p() {
        if (this.e == 1) {
            return true;
        }
        return false;
    }

    public int b() {
        int i = this.p;
        if (i == 0 || i < 180) {
            return 180;
        }
        if (i > 360) {
            return 360;
        }
        return i;
    }

    DOF c() {
        int i = this.i;
        if (i != 0) {
            if (i != 1) {
                return DOF.UNKNOWN;
            }
            return DOF.SIX_DOF;
        }
        return DOF.THREE_DOF;
    }

    public int d() {
        if (this.h != 0) {
            return 360;
        }
        return 180;
    }

    public float f() {
        if (n() == 2) {
            return this.x;
        }
        return 1.0f;
    }

    public int k() {
        int i = this.g;
        if (i != 0) {
            if (i != 2) {
                return 360;
            }
            return 90;
        }
        return 180;
    }

    public int m() {
        int i = this.f;
        if (i == 0) {
            return 2;
        }
        if (i != 1) {
            if (i != 2) {
                return 1;
            }
            return 3;
        }
        return 4;
    }

    public int n() {
        int i = this.n;
        if (i == 1) {
            return 2;
        }
        if (i != 2) {
            return 1;
        }
        return 5;
    }

    public boolean q() {
        if (this.e == 1 && this.A != -1.0f) {
            return true;
        }
        return false;
    }

    Dimensional e() {
        int i = this.f;
        if (i != 0) {
            if (i != 1 && i != 2) {
                return Dimensional.UNKNOWN;
            }
            return Dimensional.THREE_DIMENSIONAL;
        }
        return Dimensional.TWO_DIMENSIONAL;
    }

    Layout g() {
        int i = this.f;
        if (i != 1) {
            if (i != 2) {
                return Layout.UNKNOWN;
            }
            return Layout.VERTICAL;
        }
        return Layout.HORIZONTAL;
    }

    ProjectionModel j() {
        int i = this.n;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return ProjectionModel.UNKNOWN;
                    }
                    return ProjectionModel.MESH;
                }
                return ProjectionModel.CMP;
            }
            return ProjectionModel.EAC;
        }
        return ProjectionModel.ERP;
    }

    ViewingAngle o() {
        int i = this.g;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return ViewingAngle.UNKNOWN;
                }
                return ViewingAngle.VIEWING_ANGLE_90;
            }
            return ViewingAngle.VIEWING_ANGLE_360;
        }
        return ViewingAngle.VIEWING_ANGLE_180;
    }

    public enum DOF {
        UNKNOWN,
        THREE_DOF,
        SIX_DOF;

        static {
            Covode.recordClassIndex(653066);
        }
    }

    public enum Dimensional {
        UNKNOWN,
        TWO_DIMENSIONAL,
        THREE_DIMENSIONAL;

        static {
            Covode.recordClassIndex(653067);
        }
    }

    public enum Layout {
        UNKNOWN,
        HORIZONTAL,
        VERTICAL;

        static {
            Covode.recordClassIndex(653068);
        }
    }

    public enum ViewingAngle {
        UNKNOWN,
        VIEWING_ANGLE_360,
        VIEWING_ANGLE_180,
        VIEWING_ANGLE_90;

        static {
            Covode.recordClassIndex(653070);
        }
    }

    public VRParameter() {
        r();
    }

    public int l() {
        int i = this.n;
        if (i == 2) {
            if (o() == ViewingAngle.VIEWING_ANGLE_90) {
                return 1;
            }
            return 5;
        }
        if (i == 1) {
            if (o() == ViewingAngle.VIEWING_ANGLE_360) {
                return 2;
            }
            o();
            ViewingAngle viewingAngle = ViewingAngle.UNKNOWN;
        }
        return 1;
    }

    public enum ProjectionModel {
        UNKNOWN,
        ERP,
        EAC,
        CMP,
        MESH;

        static {
            Covode.recordClassIndex(653069);
        }
    }

    public void r() {
        this.e = -1;
        this.o = -1;
        this.f = 0;
        this.g = 1;
        this.h = 1;
        this.p = -1;
        this.j = 0;
        this.k = 3;
        this.l = 1;
        this.q = 1;
        this.r = 1;
        this.s = 1.0f;
        this.m = 0;
        this.n = 0;
        this.t = 1;
        this.u = 1;
        this.w = 0.015625f;
        this.x = 1.006289f;
        this.v = 0;
        this.y = 4.0f;
        this.z = 0.2f;
        this.A = -1.0f;
        this.B = 1.1f;
        this.C = 100.0f;
        this.D = 0.7f;
    }

    public String toString() {
        return "VRParameter {Dimensional = " + e() + ", ViewingAngle = " + o() + ", Layout = " + g() + ", DOF = " + c() + ", ProjectionModel = " + j() + '}';
    }

    public void s(float f) {
        this.y = Math.min(4.0f, Math.max(1.0f, f));
    }

    public void t(float f) {
        this.z = Math.max(0.2f, Math.min(1.0f, f));
    }

    public void a(JSONObject jSONObject) {
        int i;
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.has("VR")) {
                if (this.e == -1) {
                    this.e = 1;
                }
                JSONObject jSONObject2 = new JSONObject(jSONObject.optString("VR"));
                this.j = jSONObject2.optInt("ScopicType");
                this.f = jSONObject2.optInt("ContentType");
                this.g = jSONObject2.optInt("FOV");
                if (jSONObject2.has("CMPFaceInnerPadding")) {
                    this.w = (float) jSONObject2.getDouble("CMPFaceInnerPadding");
                }
                if (jSONObject2.has("ExpandCoef")) {
                    this.x = (float) jSONObject2.getDouble("ExpandCoef");
                }
                if (this.o == -1) {
                    if (jSONObject2.has("BackgroundStickerEnable")) {
                        this.o = jSONObject2.optInt("BackgroundStickerEnable");
                    } else {
                        this.o = 0;
                    }
                }
                if (jSONObject2.has("DesireFov")) {
                    this.h = jSONObject2.optInt("DesireFov");
                } else if (this.o == 1) {
                    this.h = 1;
                } else {
                    this.h = this.g;
                }
                if (this.p == -1) {
                    if (jSONObject2.has("BackgroundTexSize")) {
                        this.p = jSONObject2.optInt("BackgroundTexSize");
                    } else {
                        this.p = 0;
                    }
                }
                if (jSONObject2.has("DOF")) {
                    this.i = jSONObject2.optInt("DOF");
                }
                if (jSONObject2.has("EnableTile")) {
                    this.m = jSONObject2.optInt("EnableTile");
                }
                if (jSONObject2.has("ProjectionModel")) {
                    this.n = jSONObject2.optInt("ProjectionModel");
                }
                if (jSONObject2.has("SensorEnableSmoother")) {
                    this.r = jSONObject2.optInt("SensorEnableSmoother");
                }
                if (jSONObject2.has("SensorSmoothFactor")) {
                    this.s = (float) jSONObject2.optDouble("SensorSmoothFactor");
                }
                if (jSONObject2.has("PanoOutTextureScale")) {
                    this.B = (float) jSONObject2.optDouble("PanoOutTextureScale");
                }
                if (jSONObject2.has("VsyncFps")) {
                    this.A = (float) jSONObject2.optDouble("VsyncFps");
                }
                if (jSONObject2.has("PerspecView")) {
                    this.C = (float) jSONObject2.optDouble("PerspecView");
                }
                if (jSONObject2.has("ViewPortRatio")) {
                    this.D = (float) jSONObject2.optDouble("ViewPortRatio");
                    return;
                }
                return;
            }
            if (this.e == -1) {
                i = 0;
                this.e = 0;
            } else {
                i = 0;
            }
            if (this.o == -1) {
                this.o = i;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public int[] h(int i, int i2) {
        double ceil;
        if (l() == 2 && k() == 180) {
            ceil = Math.ceil((this.C / 90.0f) * i2 * this.B);
        } else {
            ceil = Math.ceil((this.C / 180.0f) * i2 * this.B);
        }
        int i3 = (int) ceil;
        return new int[]{(int) Math.ceil(r5 * 1.0f * this.D), ((4 - (i3 % 4)) % 4) + i3};
    }
}
