package fj6;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.ss.texturerender.effect.PureColorDetector;
import com.ss.ttm.player.MediaPlayer;
import com.ss.videoarch.liveplayer.ILiveListener;
import com.ss.videoarch.liveplayer.ILiveSettingBundle;
import com.ss.videoarch.liveplayer.VideoLiveManager;
import com.ss.videoarch.liveplayer.u;
import com.ss.videoarch.liveplayer.utils.e;
import com.ss.videoarch.strategy.LiveStrategyManager;
import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import zi6.f;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class c extends e implements Handler.Callback {
    private static AtomicLong Ch;
    private static AtomicLong Dh;
    private static AtomicLong Eh;
    private static AtomicLong Fh;
    private static AtomicLong Gh;
    private static AtomicLong Hh;
    private static AtomicLong Ih;
    private static AtomicLong Jh;
    public static HashMap<String, Integer> Kh;
    private String A;
    public int A6;
    private int A7;
    public int A8;
    private String A9;
    public long Aa;
    public int Ab;
    private long Ac;
    private long Ad;
    private volatile long Ae;
    public boolean Af;
    private long Ag;
    private int Ah;
    private int B;
    public int B6;
    private long B7;
    public String B8;
    public int B9;
    public long Ba;
    public int Bb;
    private long Bc;
    private long Bd;
    public String Be;
    public long Bf;
    private long Bg;
    private List<String> Bh;
    private int C;
    public int C6;
    private long C7;
    public int C8;
    private int C9;
    public long Ca;
    public int Cb;
    private long Cc;
    private long Cd;
    public float Ce;
    public int Cf;
    private AtomicBoolean Cg;
    private String D;
    public int D6;
    private long D7;
    public int D8;
    private String D9;
    public long Da;
    public String Db;
    private long Dc;
    private long Dd;
    public int De;
    public int Df;
    private ArrayList<JSONObject> Dg;
    private String E;
    public int E6;
    private long E7;
    public int E8;
    public String E9;
    public long Ea;
    public boolean Eb;
    private long Ec;
    private long Ed;
    public int Ee;
    public String Ef;
    public int Eg;
    private String F;
    public int F6;
    public boolean F7;
    public int F8;
    private String F9;
    private int Fa;
    public int Fb;
    private long Fc;
    private long Fd;
    public int Fe;
    public String Ff;
    public int Fg;
    private String G;
    public int G6;
    private int G7;
    private int G8;
    public boolean G9;
    private long Ga;
    public long Gb;
    private long Gc;
    private long Gd;
    public int Ge;
    public int Gf;
    public boolean Gg;
    private String H;
    public String H0;
    public int H1;
    public int H2;
    public int H3;
    public int H4;
    public String H5;
    public int H6;
    private int H7;
    private String H8;
    public boolean H9;
    public long Ha;
    public long Hb;
    private long Hc;
    private long Hd;
    public int He;
    public int Hf;
    public int Hg;
    private int I;
    public float I6;
    private int I7;
    public int I8;
    public JSONObject I9;
    public long Ia;
    public long Ib;
    private long Ic;
    private long Id;
    public int Ie;
    public long If;
    private int Ig;
    private int J;
    public int J6;
    private int J7;
    private ArrayList<Long> J8;
    public JSONObject J9;
    public int Ja;
    public long Jb;
    private long Jc;
    private long Jd;
    public long Je;
    public int Jf;
    private int Jg;
    private int K;
    public String K6;
    private int K7;
    private ArrayList<Long> K8;
    public JSONObject K9;
    public int Ka;
    public int Kb;
    private long Kc;
    private long Kd;
    public int Ke;
    public long Kf;
    public String Kg;
    private int L;
    public int L0;
    public int L1;
    public String L6;
    private int L7;
    private ArrayList<Long> L8;
    public int L9;
    public int La;
    public long Lb;
    private long Lc;
    private long Ld;
    public String Le;
    public long Lf;
    public float Lg;
    private int M;
    public float M2;
    public int M3;
    public String M6;
    private long M7;
    private ArrayList<Long> M8;
    public JSONObject M9;
    public int Ma;
    public long Mb;
    private long Mc;
    public long Md;
    public int Me;
    public long Mf;
    public float Mg;
    private String N;
    public String N6;
    private long N7;
    private ArrayList<Integer> N8;
    public int N9;
    public int Na;
    public String Nb;
    private long Nc;
    public ej6.a Nd;
    public String Ne;
    public int Nf;
    public int Ng;
    private String O;
    public String O6;
    private long O7;
    private long O8;
    private String O9;
    public int Oa;
    public String Ob;
    private long Oc;
    public int Od;
    public int Oe;
    public int Of;
    private String Og;
    private String P;
    public int P0;
    public int P1;
    public int P2;
    public int P3;
    private String P6;
    private long P7;
    private String P8;
    private String P9;
    public int Pa;
    public String Pb;
    private long Pc;
    public int Pd;
    public int Pe;
    public long Pf;
    private String Pg;
    public int Q;
    public String Q6;
    private long Q7;
    private String Q8;
    public String Q9;
    public int Qa;
    public int Qb;
    private long Qc;
    public int Qd;
    public int Qe;
    public long Qf;
    public int Qg;
    public boolean R;
    public String R6;
    private long R7;
    private JSONObject R8;
    public String R9;
    public int Ra;
    public int Rb;
    private long Rc;
    public int Rd;
    public int Re;
    public long Rf;
    public int Rg;
    private String S;
    public int S6;
    private long S7;
    private ArrayList<Integer> S8;
    public String S9;
    public int Sa;
    public int Sb;
    private long Sc;
    public String Sd;
    public int Se;
    public long Sf;
    private String Sg;
    public int T;
    public int T1;
    public float T2;
    public int T6;
    private int T7;
    private ArrayList<Integer> T8;
    public boolean T9;
    public List<String> Ta;
    public boolean Tb;
    private long Tc;
    public long Td;
    public int Te;
    public long Tf;
    private String Tg;
    public int U;
    public long U6;
    private int U7;
    private ArrayList<Long> U8;
    public String U9;
    private final int Ua;
    public int Ub;
    private long Uc;
    public long Ud;
    public String Ue;
    public long Uf;
    public int Ug;
    public int V;
    public int V1;
    public float V2;
    public int V3;
    public String V4;
    public long V6;
    public int V7;
    private String V8;
    public boolean V9;
    private final int Va;
    public int Vb;
    private long Vc;
    public String Vd;
    public int Ve;
    public long Vf;
    public String Vg;
    public boolean W;
    private long W6;
    private boolean W7;
    private String W8;
    public String W9;
    private final int Wa;
    public String Wb;
    private long Wc;
    public int Wd;
    public String We;
    public long Wf;
    public String Wg;
    public boolean X;
    private long X6;
    public int X7;
    private String X8;
    public String X9;
    private final int Xa;
    public Map<String, String> Xb;
    private long Xc;
    public long Xd;
    public List<String> Xe;
    public long Xf;
    public String Xg;
    private boolean Y;
    public int Y6;
    private boolean Y7;
    private String Y8;
    public String Y9;
    private final int Ya;
    public String Yb;
    private long Yc;
    public int Yd;
    public String Ye;
    public int Yf;
    public int Yg;
    public String Z;
    public int Z6;
    private boolean Z7;
    private boolean Z8;
    public ArrayList<String> Z9;
    private LinkedBlockingQueue<Long> Za;
    public int Zb;
    private long Zc;
    public int Zd;
    public String Ze;
    public int Zf;
    private ArrayList<JSONObject> Zg;
    public int a;
    public int a7;
    private boolean a8;
    private ILiveSettingBundle a9;
    public boolean aa;
    private final int ab;
    public int ac;
    private long ad;
    public int ae;
    public boolean af;
    public String ag;
    public String ah;
    private Context b;
    public boolean b1;
    public int b2;
    private boolean b7;
    public long b8;
    public boolean b9;
    public boolean ba;
    private final int bb;
    public float bc;
    private long bd;
    public int be;
    public int bf;
    public String bg;
    private long bh;
    private Handler c;
    private boolean c7;
    public boolean c8;
    public int c9;
    public String ca;
    private int cb;
    public float cc;
    private long cd;
    public String ce;
    public int cf;
    public boolean cg;
    private long ch;
    private ILiveListener d;
    public long d7;
    private long d8;
    public int d9;
    public String da;
    private int db;
    public int dc;
    private long dd;
    public String de;
    public long df;
    public List<Long> dg;
    private long dh;
    private d e;
    private long e7;
    private long e8;
    public int e9;
    public String ea;
    private long eb;
    public int ec;
    private long ed;
    public long ee;
    public long ef;
    public int eg;
    private long eh;
    private VideoLiveManager f;
    private String f7;
    private long f8;
    public int f9;
    public long fa;
    private int fb;
    public int fc;
    private long fd;
    public int fe;
    public int ff;
    public int fg;
    private long fh;
    private long g;
    private long g7;
    public b g8;
    public int g9;
    public int ga;
    private int gb;
    public int gc;
    private long gd;
    public long ge;
    public long gf;
    public int gg;
    private long gh;
    private boolean h;
    public long h7;
    public int h8;
    public String h9;
    public int ha;
    private int hb;
    public long hc;
    private long hd;
    public long he;
    public int hf;
    public int hg;
    private long hh;
    private long i;
    public int i7;
    private org.apache.commons.net.ntp.a i8;
    public boolean i9;
    public String ia;
    private int ib;
    public int ic;
    private long id;
    public int ie;

    /* renamed from: if, reason: not valid java name */
    public int f1040if;
    public int ig;
    private long ih;
    public String j;
    private int j7;
    private InetAddress j8;
    public int j9;
    public boolean ja;
    private int jb;
    public d jc;
    private long jd;
    public int je;
    public int jf;
    public float jg;
    private long jh;
    public String k;
    public boolean k0;
    public int k1;
    private long k7;
    private a k8;
    public int k9;
    public int ka;
    private int kb;
    public boolean kc;
    private long kd;
    public long ke;
    public String kf;
    public int kg;
    private long kh;
    public String l;
    private long l7;
    private final long l8;
    public int l9;
    public int la;
    private int lb;
    public long lc;
    private long ld;
    public long le;
    public int lf;
    public long lg;
    private long lh;
    private String m;
    private long m7;
    private boolean m8;
    public boolean m9;
    public String ma;
    private LinkedBlockingQueue<Integer> mb;
    public long mc;
    private long md;

    /* renamed from: me, reason: collision with root package name */
    public long f1042me;
    private boolean mf;
    public long mg;
    private long mh;
    private String n;
    private long n7;
    private int n8;
    public int n9;
    public long na;
    private String nb;
    public long nc;
    private long nd;
    public long ne;
    private int nf;
    public boolean ng;
    public int nh;
    private JSONObject o;
    private long o7;
    private int o8;
    public int o9;
    public long oa;
    private List<String> ob;
    private int oc;
    private long od;
    public int oe;
    private long of;
    private long og;
    public long oh;
    private String p;
    private long p7;
    private String p8;
    public long p9;
    public long pa;
    private List<String> pb;
    private long pc;
    private long pd;
    public int pe;
    private JSONObject pf;
    private long pg;
    public long ph;
    public String q;
    private long q7;
    private boolean q8;
    public long q9;
    public long qa;
    public int qb;
    private long qc;
    private long qd;
    public String qe;
    private List<Long> qf;
    public int qg;
    private int qh;
    public String r;
    private long r7;
    public String r8;
    public String r9;
    public long ra;
    private List<String> rb;
    private long rc;
    public int rd;
    public String re;
    private List<Long> rf;
    public long rg;
    public long rh;
    public String s;
    private long s7;
    public int s8;
    public int s9;
    public long sa;
    private List<String> sb;
    private long sc;
    public int sd;
    private long se;
    private List<Long> sf;
    public long sg;
    private Queue<PureColorDetector.a> sh;
    public String t;
    private long t7;
    public int t8;
    public boolean t9;
    public long ta;
    private List<String> tb;
    private long tc;
    public int td;
    public int te;
    private List<Long> tf;
    private boolean tg;
    public boolean th;
    private boolean u;
    private long u7;
    public long u8;
    public boolean u9;
    public long ua;
    private List<String> ub;
    private long uc;
    private long ud;
    public int ue;
    private List<Long> uf;
    private int ug;
    public String uh;
    public String v;
    public int v1;
    public int v2;
    private int v7;
    public int v8;
    public boolean v9;
    public String va;
    public d vb;
    private long vc;
    private long vd;
    public int ve;
    private List<Double> vf;
    private long vg;
    public int vh;
    public boolean w;
    public long w6;
    private int w7;
    public int w8;
    public float w9;
    public int wa;
    public int wb;
    private long wc;
    private long wd;
    public StringBuilder we;
    private List<Integer> wf;
    private long wg;
    public int wh;
    private long x;
    public int x1;
    public int x2;
    public long x6;
    private int x7;
    public int x8;
    public long x9;
    public boolean xa;
    public int xb;
    private int xc;
    private long xd;
    public long xe;
    public int xf;
    private long xg;
    public int xh;
    public String y;
    public int y1;
    public int y2;
    public int y6;
    private int y7;
    public int y8;
    private String y9;
    public long ya;
    public int yb;
    private int yc;
    private long yd;
    public ArrayList<Integer> ye;
    private int yf;
    private long yg;
    public int yh;
    public int z;
    public int z6;
    private int z7;
    public int z8;
    public String z9;
    public long za;
    public int zb;
    private String zc;
    private long zd;
    private volatile long ze;
    public HashMap<String, Integer> zf;
    private long zg;
    public int zh;

    public void C() {
        this.Z7 = true;
    }

    public void D() {
        this.a8 = true;
    }

    public void E() {
        this.Y7 = true;
    }

    public void P1() {
        this.Rg = -1;
    }

    public int b0() {
        return (int) this.n7;
    }

    public JSONObject w() {
        this.f.getVideoCodecType();
        this.f.getIpFromPlayer();
        float volume = this.f.getVolume();
        float maxVolume = this.f.getMaxVolume();
        float f = maxVolume != 0.0f ? volume / maxVolume : -1.0f;
        boolean z = this.k0;
        int i = 0;
        if ("bytevc2".equals(this.Z)) {
            z = false;
        }
        try {
            JSONObject put = new JSONObject().put("trans_tpl", this.f.getCurrentTransmittedTemplateName()).put("report_version", "5").put("live_sdk_version", "1.10.227.4-aweme").put("product_line", "live").put("client_timestamp", System.currentTimeMillis());
            String str = this.v;
            String str2 = "-1";
            if (str == null) {
                str = "-1";
            }
            JSONObject put2 = put.put("player_sdk_version", str);
            String str3 = this.q;
            if (str3 == null) {
                str3 = "-1";
            }
            JSONObject put3 = put2.put("project_key", str3);
            String str4 = this.j;
            if (str4 == null) {
                str4 = "none";
            }
            JSONObject put4 = put3.put("live_stream_enter_method", str4);
            String str5 = this.k;
            if (str5 == null) {
                str5 = "none";
            }
            JSONObject put5 = put4.put("live_stream_enter_action", str5);
            String str6 = this.l;
            if (str6 == null) {
                str6 = "none";
            }
            JSONObject put6 = put5.put("live_stream_enter_method_subtag", str6);
            String str7 = this.r;
            if (str7 != null) {
                str2 = str7;
            }
            JSONObject put7 = put6.put("cdn_play_url", str2);
            String str8 = this.t;
            if (str8 == null) {
                str8 = "none";
            }
            JSONObject put8 = put7.put("cdn_ip", str8).put("request_url", this.Wb).put("ip_from_player_core", this.u ? 1 : 0).put("is_preview", this.w ? 1 : 0).put("open_dns_optimizer", this.R ? 1 : 0).put("hit_node_optimize", this.W ? 1 : 0).put("evaluator_symbol", this.S).put("lss_response_cost", this.T).put("lss_first_response_cost", this.U).put("lss_response_status_code", this.V).put("remote_sorted", this.X ? 1 : 0).put("common_tag", this.m).put("codec_type", this.Z).put("codec_name", this.H0).put("hardware_decode", z ? 1 : 0).put("sharp", this.Y7 ? 1 : 0).put("enable_skip_on_buffering_end", this.k1).put("enable_latency_network_adapt", this.P0).put("enable_hurry", this.b1 ? 1 : 0).put("hurry_time", this.v1).put("hurry_type", this.x1).put("hurry_interval", this.y1).put("hurry_once_max", this.H1).put("hurry_cache_type", this.P1).put("hurry_skip_start", this.L1).put("hurry_stop_type", this.V2).put("min_buffer_stop_drop", this.H3).put("max_drop_frame_time_cost", this.M3).put("enable_fix_pts_shift", this.P3).put("hurry_delay_inc_threshold", this.V3).put("catch_speed", new DecimalFormat("0.00").format(this.M2)).put("slow_play_time", this.P2).put("slow_speed", new DecimalFormat("0.00").format(this.T2)).put("first_screen", this.b7 ? 1 : 0).put("enable_httpDns", this.b9 ? 1 : 0).put("enable_ntp", this.s8).put("enable_media_codec_async", this.c9).put("default_codec_id", this.d9).put("url_ability", this.h9).put("max_cache_seconds", this.j9).put("enable_fast_open", this.n9).put("enable_mdl", this.v8).put("enable_p2p", this.w8).put("p2p_loader_type", this.z8).put("used_p2p", this.x8);
            String str9 = this.B8;
            if (str9 == null) {
                str9 = "none";
            }
            JSONObject put9 = put8.put("mdl_version", str9).put("enable_mdl_proto", this.C8).put("enable_low_latency_flv", this.Sa).put("open_strategy_sdk", this.De).put("enable_strategy_node_opt", this.Ee).put("enable_strategy_httpDNS", this.Fe).put("enable_strategy_httpDNS_by_localDNS_timeout", this.Ge).put("enable_strategy_ipv6", this.He).put("hit_strategy_opt", this.Ke);
            String str10 = this.e.x1;
            if (str10 == null) {
                str10 = "none";
            }
            JSONObject put10 = put9.put("dns_ip", str10).put("in_main_looper", this.o9).put("start_play_buffer_threshold", this.w6).put("buffering_start_idl_time", this.J6).put("enable_change_start_play_buffer_advance", this.F6).put("fast_open_gop_cache", this.z6).put("used_predict_gop_cache", this.A6).put("buffering_end_ignore_video", this.B6).put("start_direct_after_prepared", this.C6).put("check_buffering_end_advance", this.D6).put("channel_id", this.e.m1).put("sei_delay", this.e.g1).put("sei_source", this.e.k1).put("sub_scene", this.e.p1).put("chip_board", this.O9).put("chip_hardware", this.P9).put("width", this.D8).put("height", this.E8).put("settings_info", this.Q9).put("ttnet_nqe_info", this.R9).put("play_format", this.ja ? "llash" : this.P6).put("play_protocol", this.z9).put("protocol_downgraded", this.C9).put("protocol_degrade_reason", this.D9).put("url_set_method", this.f.getUrlSettingMethod()).put("enable_resolution_auto_degrade", this.T9 ? 1 : 0).put("has_abr_info", this.V9).put("quic_load_succ", this.B9).put("link_info", this.P).put("used_texturerender", this.v9 ? 1 : 0).put("settings_res", this.W9).put("start_up_res", this.Y9).put("is_too_large_av_diff", this.e.F2).put("stall_retry_time_interval", this.b8).put("is_too_large_av_diff", this.e.F2).put("enable_rtc_play", O()).put("enable_rts_quic", this.yb).put("enable_mini_sdp", this.xb).put("rtc_play_fallback", this.zb).put("fallback_type", this.Kb).put("mute_audio", this.ac).put("player_volume_setting", this.cc).put("enable_liveio_play", this.y8).put("liveio_play", this.Od).put("liveio_p2p", this.Pd).put("liveio_p2p_upload", this.A8).put("liveio_demuxer", this.Qd).put("liveio_rtm_vmtp", this.Rd).put("enable_pcdn_rts", this.Wd).put("pcdn_rts_sdk_available", this.Xd).put("pcdn_rts_play", this.Yd).put("timer_version", this.Na).put("is_background", this.ue).put("duration_of_start_auto_speed", this.y6).put("redirect_ip", this.Be).put("request_id", this.Yb).put("backup_to_origin", this.Se).put("enable_strategy_performance_optimization", this.Ie).put("strategy_start_up_delay", this.Je).put("udp_probe_result", this.Ve).put("udp_probe_info", this.We).put("quic_fallback_tcp", this.Te).put("enable_global_volume_balance", this.G6).put("volume_balance_type", this.H6).put("volume_balance_targetlufs", this.I6).put("enable_strategy_trans_params", this.Me).put("enable_use_pty", this.Qe).put("enable_start_init_pty", this.Re).put("external_res", this.X9).put("enable_lower_res", this.aa ? 1 : 0).put("enable_low_res_startplay", this.ba ? 1 : 0).put("volume_setting", f).put("cert_verify_failed", this.e.R1).put("cert_verify_detail", this.e.S1).put("redirect_url", this.e.T1).put("enable_preplay_smooth_switch", this.Af).put("live_stream_strategy_startup_bitrate_predict", this.Ef).put("live_stream_strategy_smooth_switch_probe_bitrate", this.Ff).put("liveplayer_hash_code", this.f.getHashCode()).put("sei_ver", this.e.l1).put("fallback_from_hdr_to_sdr", this.Yf).put("cae_category", this.qg);
            if (this.f.getPreplayType() != 0) {
                i = 1;
            }
            JSONObject put11 = put10.put("is_preplay", i).put("preplay_type", this.f.getPreplayType()).put("transport_type", this.Q6).put("biz_session_id", TextUtils.isEmpty(this.O6) ? "none" : this.O6).put("scene_tags", this.o).put("business_type", this.p).put("pcdn_isolation_name", this.ce).put("multipath_network_type", this.ee).put("unstable_network_status", VideoLiveManager.sNetworkStatus).put("device_policy_ids", this.uh);
            if (this.Cf == 1) {
                put11.put("dynamic_open_texturerender", 1);
            }
            if (!this.ca.equals("none")) {
                put11.put("abr_default_res", this.ca);
            }
            ArrayList<Integer> arrayList = this.ye;
            if (arrayList != null && !arrayList.isEmpty()) {
                put11.put("ab_group_id", new JSONArray((Collection) this.ye));
            }
            if (this.y8 == 1) {
                put11.put("liveio_error_msg", this.Sd);
                put11.put("liveio_version", this.Vd);
            }
            if (g0()) {
                put11.put("rtc_get_width", this.f.getVideoWidth());
                put11.put("rtc_get_height", this.f.getVideoHeight());
            }
            put11.put("live_stream_session_id", this.L6);
            put11.put("live_vv_session_id", this.N6);
            if (this.W9.equals("auto")) {
                put11.put("auto_res", this.da);
            }
            if (this.f.getEnableTexturerender() == 1) {
                put11.put("texturerender_error", this.s9);
            }
            if (this.f.getEnableSR() == 1 && this.f.getEnableTexturerender() == 1) {
                if (this.f.getSRUsed()) {
                    float sRScaleFloatType = this.f.getSRScaleFloatType();
                    put11.put("sr_width", (int) (this.D8 * sRScaleFloatType));
                    put11.put("sr_height", (int) (this.E8 * sRScaleFloatType));
                    this.t9 = true;
                } else {
                    put11.put("sr_width", this.D8).put("sr_height", this.E8);
                }
            }
            VideoLiveManager videoLiveManager = this.f;
            if (videoLiveManager.mEnableGaussicanBlur == 1 && videoLiveManager.isUsedGaussicanBlur()) {
                put11.put("used_gaussican_blur", 1);
                put11.put("gaussican_blur_strength", this.Ce);
            }
            VideoLiveManager videoLiveManager2 = this.f;
            if (videoLiveManager2.mEnableLutFilter == 1 && videoLiveManager2.isUsedLutFilter()) {
                put11.put("used_lut_filter", 1);
            }
            VideoLiveManager videoLiveManager3 = this.f;
            if (videoLiveManager3.mEnableSharpen == 1 && videoLiveManager3.getEnableTexturerender() == 1 && this.f.isUsedSharpen()) {
                this.u9 = true;
            }
            if (this.T9 || this.V9) {
                put11.put("abr_strategy", this.U9).put("default_res_bitrate", this.ga).put("stall_count_rad", this.wa);
            }
            String str11 = this.P6;
            if (str11 != null && TextUtils.equals(str11, "cmaf")) {
                put11.put("cmaf_audio_min_seq_no", this.e.O).put("cmaf_video_min_seq_no", this.e.N).put("cmaf_audio_max_seq_no", this.e.Q).put("cmaf_video_max_seq_no", this.e.P).put("cmaf_audio_req_seq_no", this.e.S).put("cmaf_video_req_seq_no", this.e.R).put("cmaf_audio_hit_push", this.e.T).put("cmaf_video_hit_push", this.e.U).put("cmaf_mpd_cached", this.e.V);
            }
            if (TextUtils.equals(this.z9, "quic") || TextUtils.equals(this.z9, "h2q")) {
                put11.put("quic_report_cctk_frame_data", this.e.i2);
            }
            if (TextUtils.equals(this.z9, "quic") || TextUtils.equals(this.z9, "quicu") || TextUtils.equals(this.z9, "h2q") || TextUtils.equals(this.z9, "h2qu")) {
                put11.put("quic_config_cached", this.e.K1).put("quic_CHLO_count", this.e.L1).put("quic_connection_id", this.e.Q1);
            }
            if (TextUtils.equals(this.z9, "h2") || TextUtils.equals(this.z9, "h2q") || TextUtils.equals(this.z9, "h2qu")) {
                put11.put("h2_context_start_cost", this.e.V1);
                put11.put("h2_reused", this.e.W1);
                put11.put("h2_race_result", this.e.G1);
                put11.put("h2_negotiate_protocol", this.e.E1);
                put11.put("h2_push_url_list", this.e.F1);
                put11.put("h2_pushed_stream_count", this.e.H1);
            }
            if (this.f.mEnableRadioLiveDisableRender == 1) {
                put11.put("disable_video_render", this.Zb);
            }
            int i2 = this.l9;
            if (i2 > 0) {
                put11.put("tsl_timeshift", i2);
            }
            Map<String, String> map = this.Xb;
            if (map != null) {
                Iterator<Map.Entry<String, String>> it2 = map.entrySet().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Map.Entry<String, String> next = it2.next();
                    if (next.getKey().equals("Host")) {
                        put11.put("headers_host", next.getValue().replace(" ", ""));
                        break;
                    }
                }
            }
            int i3 = this.fc;
            if (i3 != -1) {
                put11.put("fcdn_res_type", i3);
            }
            int i4 = this.gc;
            if (i4 != -1) {
                put11.put("fcdn_trans_strategy", i4);
            }
            if (!TextUtils.isEmpty(this.z9) && (this.z9.equals("quic") || this.z9.equals("quicu") || this.z9.equals("h2q") || this.z9.equals("h2qu"))) {
                put11.put("ttquic_sdk_version", this.e.B1);
                put11.put("quic_rej_count", this.e.D1);
                put11.put("quic_rej_reasons", this.e.C1);
            }
            if (TextUtils.equals(this.P6, "cmaf")) {
                J1(put11);
            }
            if (this.d7 != 0) {
                put11.put("play_time_axis", System.currentTimeMillis() - this.d7);
            } else {
                put11.put("play_time_axis", -1);
            }
            int i5 = this.Rg;
            if (i5 != -1) {
                put11.put("reporting_priority", i5);
            }
            if (this.wh != 1) {
                put11.put("protocol_downgraded", this.C9).put("push_client_sdk_version", this.D).put("push_client_platform", this.E).put("push_client_os_version", this.F).put("push_client_model", this.G).put("push_client_start_time", this.H).put("push_client_is_hardware_encode", this.I).put("push_client_min_bitrate", this.J).put("push_client_max_bitrate", this.K).put("push_client_default_bitrate", this.L).put("push_client_push_protocol", this.N).put("push_client_qid", this.O).put("push_client_hit_node_optimize", this.M);
            }
            return put11;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(156:(4:6|(1:8)|9|(1:404)(3:13|14|(154:22|23|(3:25|(1:27)(1:389)|28)(2:390|(1:399)(3:394|(1:396)(1:398)|397))|29|(2:31|(1:33)(1:387))(1:388)|34|(1:36)(1:386)|37|(2:39|(1:41)(1:384))(1:385)|42|(1:46)|47|48|(1:383)(2:52|(140:54|55|56|(6:58|59|(3:61|(2:63|64)(1:66)|65)|67|68|(134:70|71|(1:73)(1:378)|74|(1:76)(1:377)|77|(4:79|(1:81)|82|83)(1:376)|84|(1:86)(1:375)|87|(1:89)(1:374)|90|(1:92)(1:373)|93|94|(1:96)|97|(1:99)(1:372)|100|(1:102)(1:371)|103|(1:105)(1:370)|106|(1:108)(1:369)|109|(1:111)(1:368)|112|(1:114)(1:367)|115|(1:117)(1:366)|118|(1:120)(1:365)|121|(1:123)(1:364)|124|(1:126)(1:363)|127|(1:129)(1:362)|130|(1:132)(1:361)|133|(5:135|136|137|(2:140|138)|141)|146|(4:351|352|(2:355|353)|356)|148|(1:150)|151|(2:348|(1:350))|155|(2:157|(1:159))|160|(4:162|(1:(2:165|(1:167)(1:344))(1:345))(1:346)|168|(79:170|171|(1:173)(1:343)|174|175|(1:177)(1:342)|178|(1:180)|181|(1:183)|(1:185)|186|(1:188)|189|(1:191)|192|(1:194)|195|(1:197)|198|(1:200)|201|(1:203)|204|(1:206)|207|208|(3:332|333|(1:335))|210|211|212|213|(1:215)|216|217|(1:219)(4:317|(1:319)|320|(1:322)(3:323|(1:325)(1:327)|326))|220|221|(2:227|(2:229|(1:231)))|232|(5:234|235|(3:237|238|(2:240|241))(1:243)|242|241)|244|(2:246|(1:248))|249|(1:251)|252|(1:254)|255|(1:257)|258|(1:260)|261|(1:263)|264|(1:316)|268|(1:315)|272|(1:314)|278|(1:280)|281|(1:283)|284|(3:286|(1:288)(1:290)|289)|291|(1:293)|294|(1:298)|299|(1:301)|302|(1:304)|305|(1:307)|308|(1:310)|311|313))|347|171|(0)(0)|174|175|(0)(0)|178|(0)|181|(0)|(0)|186|(0)|189|(0)|192|(0)|195|(0)|198|(0)|201|(0)|204|(0)|207|208|(0)|210|211|212|213|(0)|216|217|(0)(0)|220|221|(3:223|227|(0))|232|(0)|244|(0)|249|(0)|252|(0)|255|(0)|258|(0)|261|(0)|264|(1:266)|316|268|(1:270)|315|272|(1:274)|314|278|(0)|281|(0)|284|(0)|291|(0)|294|(2:296|298)|299|(0)|302|(0)|305|(0)|308|(0)|311|313)(1:379))(1:381)|380|71|(0)(0)|74|(0)(0)|77|(0)(0)|84|(0)(0)|87|(0)(0)|90|(0)(0)|93|94|(0)|97|(0)(0)|100|(0)(0)|103|(0)(0)|106|(0)(0)|109|(0)(0)|112|(0)(0)|115|(0)(0)|118|(0)(0)|121|(0)(0)|124|(0)(0)|127|(0)(0)|130|(0)(0)|133|(0)|146|(0)|148|(0)|151|(1:153)|348|(0)|155|(0)|160|(0)|347|171|(0)(0)|174|175|(0)(0)|178|(0)|181|(0)|(0)|186|(0)|189|(0)|192|(0)|195|(0)|198|(0)|201|(0)|204|(0)|207|208|(0)|210|211|212|213|(0)|216|217|(0)(0)|220|221|(0)|232|(0)|244|(0)|249|(0)|252|(0)|255|(0)|258|(0)|261|(0)|264|(0)|316|268|(0)|315|272|(0)|314|278|(0)|281|(0)|284|(0)|291|(0)|294|(0)|299|(0)|302|(0)|305|(0)|308|(0)|311|313))|382|55|56|(0)(0)|380|71|(0)(0)|74|(0)(0)|77|(0)(0)|84|(0)(0)|87|(0)(0)|90|(0)(0)|93|94|(0)|97|(0)(0)|100|(0)(0)|103|(0)(0)|106|(0)(0)|109|(0)(0)|112|(0)(0)|115|(0)(0)|118|(0)(0)|121|(0)(0)|124|(0)(0)|127|(0)(0)|130|(0)(0)|133|(0)|146|(0)|148|(0)|151|(0)|348|(0)|155|(0)|160|(0)|347|171|(0)(0)|174|175|(0)(0)|178|(0)|181|(0)|(0)|186|(0)|189|(0)|192|(0)|195|(0)|198|(0)|201|(0)|204|(0)|207|208|(0)|210|211|212|213|(0)|216|217|(0)(0)|220|221|(0)|232|(0)|244|(0)|249|(0)|252|(0)|255|(0)|258|(0)|261|(0)|264|(0)|316|268|(0)|315|272|(0)|314|278|(0)|281|(0)|284|(0)|291|(0)|294|(0)|299|(0)|302|(0)|305|(0)|308|(0)|311|313)(1:403)))(1:406)|22|23|(0)(0)|29|(0)(0)|34|(0)(0)|37|(0)(0)|42|(2:44|46)|47|48|(1:50)|383|382|55|56|(0)(0)|380|71|(0)(0)|74|(0)(0)|77|(0)(0)|84|(0)(0)|87|(0)(0)|90|(0)(0)|93|94|(0)|97|(0)(0)|100|(0)(0)|103|(0)(0)|106|(0)(0)|109|(0)(0)|112|(0)(0)|115|(0)(0)|118|(0)(0)|121|(0)(0)|124|(0)(0)|127|(0)(0)|130|(0)(0)|133|(0)|146|(0)|148|(0)|151|(0)|348|(0)|155|(0)|160|(0)|347|171|(0)(0)|174|175|(0)(0)|178|(0)|181|(0)|(0)|186|(0)|189|(0)|192|(0)|195|(0)|198|(0)|201|(0)|204|(0)|207|208|(0)|210|211|212|213|(0)|216|217|(0)(0)|220|221|(0)|232|(0)|244|(0)|249|(0)|252|(0)|255|(0)|258|(0)|261|(0)|264|(0)|316|268|(0)|315|272|(0)|314|278|(0)|281|(0)|284|(0)|291|(0)|294|(0)|299|(0)|302|(0)|305|(0)|308|(0)|311|313) */
    /* JADX WARN: Can't wrap try/catch for region: R(165:0|1|(1:3)|4|(4:6|(1:8)|9|(1:404)(3:13|14|(154:22|23|(3:25|(1:27)(1:389)|28)(2:390|(1:399)(3:394|(1:396)(1:398)|397))|29|(2:31|(1:33)(1:387))(1:388)|34|(1:36)(1:386)|37|(2:39|(1:41)(1:384))(1:385)|42|(1:46)|47|48|(1:383)(2:52|(140:54|55|56|(6:58|59|(3:61|(2:63|64)(1:66)|65)|67|68|(134:70|71|(1:73)(1:378)|74|(1:76)(1:377)|77|(4:79|(1:81)|82|83)(1:376)|84|(1:86)(1:375)|87|(1:89)(1:374)|90|(1:92)(1:373)|93|94|(1:96)|97|(1:99)(1:372)|100|(1:102)(1:371)|103|(1:105)(1:370)|106|(1:108)(1:369)|109|(1:111)(1:368)|112|(1:114)(1:367)|115|(1:117)(1:366)|118|(1:120)(1:365)|121|(1:123)(1:364)|124|(1:126)(1:363)|127|(1:129)(1:362)|130|(1:132)(1:361)|133|(5:135|136|137|(2:140|138)|141)|146|(4:351|352|(2:355|353)|356)|148|(1:150)|151|(2:348|(1:350))|155|(2:157|(1:159))|160|(4:162|(1:(2:165|(1:167)(1:344))(1:345))(1:346)|168|(79:170|171|(1:173)(1:343)|174|175|(1:177)(1:342)|178|(1:180)|181|(1:183)|(1:185)|186|(1:188)|189|(1:191)|192|(1:194)|195|(1:197)|198|(1:200)|201|(1:203)|204|(1:206)|207|208|(3:332|333|(1:335))|210|211|212|213|(1:215)|216|217|(1:219)(4:317|(1:319)|320|(1:322)(3:323|(1:325)(1:327)|326))|220|221|(2:227|(2:229|(1:231)))|232|(5:234|235|(3:237|238|(2:240|241))(1:243)|242|241)|244|(2:246|(1:248))|249|(1:251)|252|(1:254)|255|(1:257)|258|(1:260)|261|(1:263)|264|(1:316)|268|(1:315)|272|(1:314)|278|(1:280)|281|(1:283)|284|(3:286|(1:288)(1:290)|289)|291|(1:293)|294|(1:298)|299|(1:301)|302|(1:304)|305|(1:307)|308|(1:310)|311|313))|347|171|(0)(0)|174|175|(0)(0)|178|(0)|181|(0)|(0)|186|(0)|189|(0)|192|(0)|195|(0)|198|(0)|201|(0)|204|(0)|207|208|(0)|210|211|212|213|(0)|216|217|(0)(0)|220|221|(3:223|227|(0))|232|(0)|244|(0)|249|(0)|252|(0)|255|(0)|258|(0)|261|(0)|264|(1:266)|316|268|(1:270)|315|272|(1:274)|314|278|(0)|281|(0)|284|(0)|291|(0)|294|(2:296|298)|299|(0)|302|(0)|305|(0)|308|(0)|311|313)(1:379))(1:381)|380|71|(0)(0)|74|(0)(0)|77|(0)(0)|84|(0)(0)|87|(0)(0)|90|(0)(0)|93|94|(0)|97|(0)(0)|100|(0)(0)|103|(0)(0)|106|(0)(0)|109|(0)(0)|112|(0)(0)|115|(0)(0)|118|(0)(0)|121|(0)(0)|124|(0)(0)|127|(0)(0)|130|(0)(0)|133|(0)|146|(0)|148|(0)|151|(1:153)|348|(0)|155|(0)|160|(0)|347|171|(0)(0)|174|175|(0)(0)|178|(0)|181|(0)|(0)|186|(0)|189|(0)|192|(0)|195|(0)|198|(0)|201|(0)|204|(0)|207|208|(0)|210|211|212|213|(0)|216|217|(0)(0)|220|221|(0)|232|(0)|244|(0)|249|(0)|252|(0)|255|(0)|258|(0)|261|(0)|264|(0)|316|268|(0)|315|272|(0)|314|278|(0)|281|(0)|284|(0)|291|(0)|294|(0)|299|(0)|302|(0)|305|(0)|308|(0)|311|313))|382|55|56|(0)(0)|380|71|(0)(0)|74|(0)(0)|77|(0)(0)|84|(0)(0)|87|(0)(0)|90|(0)(0)|93|94|(0)|97|(0)(0)|100|(0)(0)|103|(0)(0)|106|(0)(0)|109|(0)(0)|112|(0)(0)|115|(0)(0)|118|(0)(0)|121|(0)(0)|124|(0)(0)|127|(0)(0)|130|(0)(0)|133|(0)|146|(0)|148|(0)|151|(0)|348|(0)|155|(0)|160|(0)|347|171|(0)(0)|174|175|(0)(0)|178|(0)|181|(0)|(0)|186|(0)|189|(0)|192|(0)|195|(0)|198|(0)|201|(0)|204|(0)|207|208|(0)|210|211|212|213|(0)|216|217|(0)(0)|220|221|(0)|232|(0)|244|(0)|249|(0)|252|(0)|255|(0)|258|(0)|261|(0)|264|(0)|316|268|(0)|315|272|(0)|314|278|(0)|281|(0)|284|(0)|291|(0)|294|(0)|299|(0)|302|(0)|305|(0)|308|(0)|311|313)(1:403)))(1:406)|405|14|(1:16)|20|22|23|(0)(0)|29|(0)(0)|34|(0)(0)|37|(0)(0)|42|(2:44|46)|47|48|(1:50)|383|382|55|56|(0)(0)|380|71|(0)(0)|74|(0)(0)|77|(0)(0)|84|(0)(0)|87|(0)(0)|90|(0)(0)|93|94|(0)|97|(0)(0)|100|(0)(0)|103|(0)(0)|106|(0)(0)|109|(0)(0)|112|(0)(0)|115|(0)(0)|118|(0)(0)|121|(0)(0)|124|(0)(0)|127|(0)(0)|130|(0)(0)|133|(0)|146|(0)|148|(0)|151|(0)|348|(0)|155|(0)|160|(0)|347|171|(0)(0)|174|175|(0)(0)|178|(0)|181|(0)|(0)|186|(0)|189|(0)|192|(0)|195|(0)|198|(0)|201|(0)|204|(0)|207|208|(0)|210|211|212|213|(0)|216|217|(0)(0)|220|221|(0)|232|(0)|244|(0)|249|(0)|252|(0)|255|(0)|258|(0)|261|(0)|264|(0)|316|268|(0)|315|272|(0)|314|278|(0)|281|(0)|284|(0)|291|(0)|294|(0)|299|(0)|302|(0)|305|(0)|308|(0)|311|313|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:329:0x0f5e, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:330:0x0f62, code lost:
    
        r5 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:340:0x0f60, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x060d  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x077e  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x078d  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0937  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0944 A[Catch: JSONException -> 0x143d, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0953 A[Catch: JSONException -> 0x143d, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0962 A[Catch: JSONException -> 0x143d, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0971 A[Catch: JSONException -> 0x143d, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0a6a  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0b64  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0ba0 A[Catch: JSONException -> 0x143d, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0bd8 A[Catch: JSONException -> 0x143d, TRY_LEAVE, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0c44 A[Catch: JSONException -> 0x143d, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0c4d A[Catch: JSONException -> 0x143d, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0c6f A[Catch: JSONException -> 0x143d, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0cb8 A[Catch: JSONException -> 0x143d, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0d4f A[Catch: JSONException -> 0x143d, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0d62 A[Catch: JSONException -> 0x143d, TRY_ENTER, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0d7b A[Catch: JSONException -> 0x143d, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0e6c A[Catch: JSONException -> 0x143d, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0e82 A[Catch: JSONException -> 0x143d, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0e8b A[Catch: JSONException -> 0x143d, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0eca A[Catch: JSONException -> 0x143d, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0ed5 A[Catch: JSONException -> 0x143d, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0edf A[Catch: JSONException -> 0x143d, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0eea A[Catch: JSONException -> 0x143d, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0ef3 A[Catch: JSONException -> 0x143d, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0f07 A[Catch: JSONException -> 0x143d, TRY_LEAVE, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0f6a A[Catch: JSONException -> 0x143d, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0f97 A[Catch: JSONException -> 0x143d, TRY_ENTER, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:223:0x1045 A[Catch: JSONException -> 0x143d, TRY_ENTER, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:229:0x10be A[Catch: JSONException -> 0x143d, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:234:0x112b A[Catch: JSONException -> 0x143d, TRY_LEAVE, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:246:0x11f9 A[Catch: JSONException -> 0x143d, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:251:0x121a A[Catch: JSONException -> 0x143d, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:254:0x1241 A[Catch: JSONException -> 0x143d, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:257:0x124a A[Catch: JSONException -> 0x143d, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0079 A[Catch: JSONException -> 0x143d, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:260:0x1253 A[Catch: JSONException -> 0x143d, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:263:0x125d A[Catch: JSONException -> 0x143d, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:266:0x1277 A[Catch: JSONException -> 0x143d, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:270:0x12d0 A[Catch: JSONException -> 0x143d, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:274:0x130f A[Catch: JSONException -> 0x143d, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:280:0x1337 A[Catch: JSONException -> 0x143d, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:283:0x1344 A[Catch: JSONException -> 0x143d, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:286:0x1392  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x13a9 A[Catch: JSONException -> 0x143d, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:296:0x13d9 A[Catch: JSONException -> 0x143d, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:301:0x13fb A[Catch: JSONException -> 0x143d, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:304:0x140a A[Catch: JSONException -> 0x143d, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:307:0x1416 A[Catch: JSONException -> 0x143d, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:310:0x142e A[Catch: JSONException -> 0x143d, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:317:0x0ffb A[Catch: JSONException -> 0x143d, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c6 A[Catch: JSONException -> 0x143d, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:332:0x0f28 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:342:0x0d69 A[Catch: JSONException -> 0x143d, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:343:0x0d55  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x0c61 A[Catch: JSONException -> 0x143d, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:351:0x0c23 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:361:0x0bcc  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x0b66 A[Catch: JSONException -> 0x143d, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:363:0x0a6c  */
    /* JADX WARN: Removed duplicated region for block: B:364:0x0974  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x0965  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x0956  */
    /* JADX WARN: Removed duplicated region for block: B:367:0x0947  */
    /* JADX WARN: Removed duplicated region for block: B:368:0x0939  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x078f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e7 A[Catch: JSONException -> 0x143d, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:370:0x0780  */
    /* JADX WARN: Removed duplicated region for block: B:371:0x060f  */
    /* JADX WARN: Removed duplicated region for block: B:372:0x0602  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x0574  */
    /* JADX WARN: Removed duplicated region for block: B:374:0x0561  */
    /* JADX WARN: Removed duplicated region for block: B:375:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:377:0x0244 A[Catch: JSONException -> 0x143d, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:378:0x0236 A[Catch: JSONException -> 0x143d, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:381:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:386:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:390:0x0094 A[Catch: JSONException -> 0x143d, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0108 A[Catch: JSONException -> 0x143d, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0232 A[Catch: JSONException -> 0x143d, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0252 A[Catch: JSONException -> 0x143d, TryCatch #3 {JSONException -> 0x143d, blocks: (B:23:0x0073, B:25:0x0079, B:27:0x0084, B:28:0x008f, B:29:0x00c2, B:31:0x00c6, B:33:0x00ca, B:34:0x00df, B:36:0x00e7, B:37:0x0102, B:39:0x0108, B:41:0x0122, B:42:0x013e, B:44:0x0142, B:46:0x014a, B:47:0x015c, B:50:0x0176, B:52:0x017a, B:54:0x01a0, B:55:0x01aa, B:59:0x01b8, B:61:0x01e1, B:63:0x01f3, B:65:0x0204, B:68:0x020d, B:70:0x0217, B:71:0x022e, B:73:0x0232, B:74:0x023e, B:77:0x024a, B:79:0x0252, B:81:0x025d, B:83:0x0272, B:84:0x0280, B:87:0x02c6, B:90:0x0562, B:93:0x0575, B:97:0x05b2, B:100:0x0603, B:103:0x0610, B:106:0x0781, B:109:0x0790, B:112:0x093a, B:114:0x0944, B:115:0x0949, B:117:0x0953, B:118:0x0958, B:120:0x0962, B:121:0x0967, B:123:0x0971, B:124:0x0976, B:127:0x0a6d, B:130:0x0b6c, B:132:0x0ba0, B:133:0x0bce, B:135:0x0bd8, B:145:0x0bfc, B:146:0x0bff, B:148:0x0c40, B:150:0x0c44, B:151:0x0c49, B:153:0x0c4d, B:155:0x0c66, B:157:0x0c6f, B:159:0x0c8c, B:160:0x0cad, B:162:0x0cb8, B:168:0x0cce, B:170:0x0cf4, B:171:0x0d37, B:173:0x0d4f, B:174:0x0d56, B:177:0x0d62, B:178:0x0d6d, B:180:0x0d7b, B:181:0x0e0b, B:183:0x0e6c, B:185:0x0e82, B:186:0x0e87, B:188:0x0e8b, B:189:0x0ec6, B:191:0x0eca, B:192:0x0ecf, B:194:0x0ed5, B:195:0x0eda, B:197:0x0edf, B:198:0x0ee4, B:200:0x0eea, B:201:0x0eef, B:203:0x0ef3, B:204:0x0efe, B:206:0x0f07, B:213:0x0f66, B:215:0x0f6a, B:216:0x0f7f, B:219:0x0f97, B:220:0x103d, B:223:0x1045, B:225:0x104b, B:227:0x1053, B:229:0x10be, B:231:0x111c, B:232:0x1121, B:234:0x112b, B:238:0x1137, B:240:0x113f, B:241:0x1156, B:242:0x1145, B:244:0x11f5, B:246:0x11f9, B:248:0x120b, B:249:0x1216, B:251:0x121a, B:252:0x123d, B:254:0x1241, B:255:0x1246, B:257:0x124a, B:258:0x124f, B:260:0x1253, B:261:0x1259, B:263:0x125d, B:264:0x126d, B:266:0x1277, B:268:0x12c6, B:270:0x12d0, B:272:0x1305, B:274:0x130f, B:276:0x1319, B:278:0x132f, B:280:0x1337, B:281:0x133c, B:283:0x1344, B:284:0x138e, B:289:0x1399, B:291:0x13a4, B:293:0x13a9, B:294:0x13c8, B:296:0x13d9, B:298:0x13dd, B:299:0x13f3, B:301:0x13fb, B:302:0x1402, B:304:0x140a, B:305:0x1411, B:307:0x1416, B:308:0x1429, B:310:0x142e, B:311:0x1433, B:314:0x1323, B:315:0x12d8, B:316:0x1281, B:317:0x0ffb, B:319:0x0fff, B:320:0x100d, B:322:0x101f, B:323:0x1027, B:325:0x1031, B:326:0x103a, B:327:0x1036, B:331:0x0f63, B:342:0x0d69, B:348:0x0c55, B:350:0x0c61, B:360:0x0c3d, B:362:0x0b66, B:377:0x0244, B:378:0x0236, B:387:0x00d8, B:389:0x008b, B:390:0x0094, B:392:0x0098, B:394:0x00a0, B:396:0x00ad, B:397:0x00b8, B:398:0x00b4, B:137:0x0bdd, B:138:0x0be6, B:140:0x0bec, B:352:0x0c23, B:353:0x0c27, B:355:0x0c2d), top: B:22:0x0073, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0560  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0572  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x05b1  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0600  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void t1(java.lang.String r44) {
        /*
            Method dump skipped, instructions count: 5187
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: fj6.c.t1(java.lang.String):void");
    }

    private void O1() {
        this.oa = 0L;
        this.pa = 0L;
    }

    public long L() {
        return this.e.g1;
    }

    public long Q() {
        return this.e.b1;
    }

    public void R0() {
        S0("retry");
    }

    public long V() {
        return System.currentTimeMillis() - this.d7;
    }

    public long W() {
        return this.e.u0;
    }

    public String Y() {
        return this.e.T1;
    }

    private int K() {
        VideoLiveManager videoLiveManager = this.f;
        if (videoLiveManager != null) {
            return videoLiveManager.getCallPreloadFuncState();
        }
        return -1;
    }

    private int O() {
        VideoLiveManager videoLiveManager = this.f;
        if (videoLiveManager != null) {
            return videoLiveManager.getEnableRtsPlay();
        }
        return 0;
    }

    private int X() {
        VideoLiveManager videoLiveManager = this.f;
        if (videoLiveManager != null) {
            return videoLiveManager.getPreloadState();
        }
        return -1;
    }

    public void H() {
        d dVar;
        VideoLiveManager videoLiveManager = this.f;
        if (videoLiveManager != null && (dVar = this.e) != null) {
            videoLiveManager.getLogInfo(dVar, 8);
        }
    }

    public void I() {
        d dVar;
        VideoLiveManager videoLiveManager = this.f;
        if (videoLiveManager != null && (dVar = this.e) != null) {
            videoLiveManager.getLogInfo(dVar, 9);
        }
    }

    public long M() {
        long j = this.o7;
        if (this.F7) {
            return j + (System.currentTimeMillis() - this.k7);
        }
        return j;
    }

    public void M0() {
        if (!g0()) {
            return;
        }
        this.vb.j2 = System.currentTimeMillis();
    }

    public String N() {
        if (this.ja) {
            return "llash";
        }
        return this.P6;
    }

    public void Q1() {
        this.vb.a();
        this.wb = 0;
    }

    public void d2() {
        this.c8 = true;
        this.d8 = System.currentTimeMillis();
    }

    public boolean g0() {
        VideoLiveManager videoLiveManager = this.f;
        if (videoLiveManager != null) {
            return videoLiveManager.isRtcPlayAvailable();
        }
        return false;
    }

    public boolean h0() {
        VideoLiveManager videoLiveManager = this.f;
        if (videoLiveManager != null) {
            return videoLiveManager.isRtmSessionStopEnable();
        }
        return false;
    }

    public boolean i0() {
        VideoLiveManager videoLiveManager = this.f;
        if (videoLiveManager != null) {
            return videoLiveManager.isRtmv3();
        }
        return false;
    }

    public void l1() {
        d dVar = this.jc;
        if (dVar != null) {
            dVar.i1 = this.e.g1;
        }
    }

    public boolean q() {
        VideoLiveManager videoLiveManager = this.f;
        if (videoLiveManager == null) {
            return false;
        }
        return videoLiveManager.canPlayingLogUpload();
    }

    public void v0() {
        d dVar = this.e;
        if (dVar != null) {
            dVar.z2 = System.currentTimeMillis();
        }
    }

    private String J() {
        cj6.b bVar;
        VideoLiveManager videoLiveManager = this.f;
        if (videoLiveManager == null || (bVar = videoLiveManager.mAlgoSeiFunction) == null || !(bVar instanceof cj6.c)) {
            return "none";
        }
        try {
            return ((cj6.c) bVar).f();
        } catch (Exception unused) {
            com.ss.videoarch.liveplayer.log.a.b("getSeiReportStr", "parseSEI err");
            return "none";
        }
    }

    private void M1() {
        u2();
        com.ss.videoarch.liveplayer.log.a.c("zdh", "update session series");
        if (this.h) {
            this.c.sendEmptyMessageDelayed(102, 5000L);
        }
    }

    public void G1() {
        this.t8 = 1;
        this.s8 = 1;
        if (this.k8 == null) {
            a aVar = new a(this);
            this.k8 = aVar;
            aVar.b(104, 0L);
        }
    }

    public void L0() {
        if (!g0()) {
            return;
        }
        d dVar = this.vb;
        if (dVar.q == 0) {
            dVar.q = System.currentTimeMillis();
        }
    }

    public void Q0() {
        d dVar = this.jc;
        if (dVar != null) {
            dVar.t = System.currentTimeMillis();
        }
        if (this.b7) {
            return;
        }
        this.e.t = System.currentTimeMillis();
    }

    public String d0() {
        int i = this.e.C2;
        if (i == -1) {
            return "no stream";
        }
        if (i == 0) {
            return "video stream";
        }
        if (i == 1) {
            return "audio stream";
        }
        if (i == 2) {
            return "both stream";
        }
        return "none";
    }

    public void j2() {
        this.e.b = System.currentTimeMillis();
        d dVar = this.jc;
        if (dVar != null) {
            dVar.b = System.currentTimeMillis();
        }
        this.vb.b = System.currentTimeMillis();
    }

    public void o0() {
        if (this.Cg.compareAndSet(true, false)) {
            this.Ag = 0L;
            this.Bg = 0L;
        }
    }

    public void p0() {
        if (this.Cg.compareAndSet(false, true)) {
            this.Ag = 0L;
            this.Bg = System.currentTimeMillis();
        }
    }

    public void p2() {
        long j = this.g;
        if (g0()) {
            j = this.se;
        }
        this.c.sendEmptyMessageDelayed(101, j);
    }

    public void w0() {
        if (this.b7) {
            return;
        }
        this.e.c = System.currentTimeMillis();
        d dVar = this.jc;
        if (dVar != null) {
            dVar.c = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f0() {
        int i;
        NetworkInfo j = hj6.d.j(this.b);
        if (j != null && j.isAvailable()) {
            i = j.getType();
        } else {
            i = -1;
        }
        if (i != -1) {
            if (i != this.o8) {
                this.o8 = i;
                return true;
            }
            return false;
        }
        this.o8 = i;
        return true;
    }

    public void A0() {
        this.c8 = false;
        com.ss.videoarch.liveplayer.log.a.c("LiveLoggerService", "recover from error time " + (System.currentTimeMillis() - this.d8));
        if (this.d8 != 0) {
            this.e8++;
            this.f8 += System.currentTimeMillis() - this.d8;
        }
    }

    public void S1() {
        int i;
        LinkedBlockingQueue<Long> linkedBlockingQueue = this.Za;
        if (linkedBlockingQueue != null) {
            linkedBlockingQueue.clear();
            this.Za = null;
        }
        int i2 = this.kb;
        if (i2 != -1 && (i = this.lb) != -1) {
            this.gb += (i - i2) + 1;
            this.kb = -1;
            this.lb = -1;
        }
        this.cb = -1;
        this.db = -1;
        this.eb = -1L;
        this.fb = -1;
    }

    public void Z() {
        if (g0() && !i0()) {
            if (!this.Eb) {
                com.ss.videoarch.liveplayer.log.a.f("[RTM_PLAY]", "no need to getRtmPlayerStopInfo");
                return;
            }
            if (TextUtils.equals("none", this.Ob) || TextUtils.isEmpty(this.Ob)) {
                String rtcStopInfo = this.f.getRtcStopInfo();
                if (!TextUtils.isEmpty(rtcStopInfo)) {
                    b1(rtcStopInfo);
                }
            }
        }
    }

    public void n() {
        d dVar = this.e;
        long j = dVar.r;
        if (j > 0 && dVar.q > 0) {
            this.j7 = 0;
            return;
        }
        if (j > 0 && dVar.q <= 0) {
            this.j7 = 1;
        } else if (j <= 0 && dVar.q > 0) {
            this.j7 = 2;
        } else {
            this.j7 = 3;
        }
    }

    public void o() {
        long j = this.nc;
        if (j > 0 && this.mc > 0) {
            this.xc = 0;
            return;
        }
        if (j > 0 && this.mc <= 0) {
            this.xc = 1;
        } else if (j <= 0 && this.mc > 0) {
            this.xc = 2;
        } else {
            this.xc = 3;
        }
    }

    public void o2() {
        a aVar;
        if (this.h) {
            return;
        }
        long j = this.g;
        if (g0()) {
            j = this.se;
        }
        this.c.sendEmptyMessageDelayed(101, j);
        if (this.i9) {
            this.c.sendEmptyMessageDelayed(102, 5000L);
        }
        if (this.t8 == 1 && !this.q8 && (aVar = this.k8) != null) {
            aVar.b(103, 0L);
            this.q8 = true;
        }
        this.h = true;
    }

    public void q1() {
        this.nf++;
        if (this.pf == null) {
            this.pf = new JSONObject();
        }
        this.of = System.currentTimeMillis();
        com.ss.videoarch.liveplayer.log.a.a("LiveLoggerService", "silence start: " + this.of);
    }

    public void u1() {
        JSONObject x = x();
        if (x != null) {
            try {
                x.put("event_key", "stop_when_prepared").put("liveio_prepare", this.f.mForbidLiveIOPrepareWhenPreparing).put("httpio_prepare", this.f.mForbidHttpIOPrepareWhenPreparing);
                B0(x, "live_client_monitor_log");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    static {
        Covode.recordClassIndex(653043);
        Ch = new AtomicLong(0L);
        Dh = new AtomicLong(0L);
        Eh = new AtomicLong(0L);
        Fh = new AtomicLong(0L);
        Gh = new AtomicLong(0L);
        Hh = new AtomicLong(0L);
        Ih = new AtomicLong(0L);
        Jh = new AtomicLong(0L);
        Kh = new HashMap<>();
    }

    private void R1() {
        d dVar;
        if (this.ic != 0 && (dVar = this.jc) != null) {
            this.kc = false;
            this.mg = 0L;
            this.pg = 0L;
            this.vc = 0L;
            this.wc = 0L;
            this.pc = 0L;
            this.qc = 0L;
            this.lc = 0L;
            this.mc = 0L;
            this.nc = 0L;
            this.rc = 0L;
            this.sc = 0L;
            this.tc = 0L;
            this.uc = 0L;
            this.xc = -1;
            this.yc = 0;
            this.zc = "none";
            this.Gg = false;
            dVar.a();
            this.kg = 0;
            this.Ud = 0L;
            this.bh = 0L;
            this.ch = 0L;
            this.dh = -1L;
            this.eh = -1L;
            this.fh = -1L;
            this.gh = -1L;
            this.hh = 0L;
            this.ih = 0L;
            this.jh = 0L;
            this.kh = 0L;
            this.lh = 0L;
            this.mh = 0L;
            this.nh = -1;
            this.qh = 0;
            this.ah = "none";
        }
    }

    private long m() {
        long j;
        VideoLiveManager videoLiveManager = this.f;
        if (videoLiveManager == null || videoLiveManager.getPreplayType() == 0) {
            return 0L;
        }
        long j2 = this.i;
        if (j2 == 0) {
            j2 = System.currentTimeMillis();
        }
        if (videoLiveManager.getPreplayType() == 3) {
            d dVar = this.e;
            if (dVar != null) {
                long j3 = dVar.o;
                if (j3 > 0 && j2 > j3) {
                    return j2 - j3;
                }
            }
            return 0L;
        }
        if (this.b7) {
            long j4 = this.d7;
            if (j2 <= j4) {
                return 0L;
            }
            return j2 - j4;
        }
        d dVar2 = this.e;
        if (dVar2 != null) {
            j = dVar2.o;
        } else {
            j = 0;
        }
        if (j == 0 || j > j2) {
            return 0L;
        }
        return j2 - j;
    }

    private void p() {
        if (this.nh == 1) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.lc;
        long j = this.bh + this.ch;
        long j2 = currentTimeMillis - j;
        com.ss.videoarch.liveplayer.log.a.a("LiveLoggerService", "sessionPlayTime:" + currentTimeMillis + "totaliotime:" + j + "diff:" + j2);
        if (currentTimeMillis > 0 && j > 0 && Math.abs(j2) <= 1000) {
            long j3 = this.bh;
            long j4 = (j2 * j3) / j;
            this.bh = j3 + j4;
            this.ch += j2 - j4;
            return;
        }
        this.nh = 2;
    }

    private void u2() {
        d dVar;
        VideoLiveManager videoLiveManager = this.f;
        if (videoLiveManager != null && (dVar = this.e) != null) {
            videoLiveManager.getLogInfo(dVar, 3);
            if (this.J8 == null) {
                this.J8 = new ArrayList<>();
                this.L8 = new ArrayList<>();
                this.K8 = new ArrayList<>();
            }
            this.J8.add(Long.valueOf((long) this.e.Q0));
            this.L8.add(Long.valueOf(this.e.a1));
            this.K8.add(Long.valueOf(this.e.R0));
            if (this.Z8) {
                if (this.T8 == null) {
                    this.T8 = new ArrayList<>();
                    this.S8 = new ArrayList<>();
                }
                this.T8.add(Integer.valueOf(this.e.o1));
                this.S8.add(Integer.valueOf(this.e.n1));
            }
        }
    }

    public JSONObject T() {
        Long l = 0L;
        ArrayList<Long> arrayList = this.K8;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<Long> it2 = this.K8.iterator();
            while (it2.hasNext()) {
                l = Long.valueOf(l.longValue() + it2.next().longValue());
            }
            l = Long.valueOf(l.longValue() / this.K8.size());
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String str = this.r;
            if (str == null) {
                str = "-1";
            }
            JSONObject put = jSONObject.put("cdn_play_url", str);
            String str2 = this.t;
            if (str2 == null) {
                str2 = "none";
            }
            return put.put("cdn_ip", str2).put("pull_stream_bitrate", l);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public JSONObject U() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("PLAY-SessionID", this.N6);
        jSONObject.put("stallTotalCount", b0());
        jSONObject.put("retryTotalCount", this.V7);
        jSONObject.put("firstFrameDownloadSpeed", Q());
        jSONObject.put("nqeInfo", this.S9);
        jSONObject.put("domain", this.Ye);
        jSONObject.put("playTime", V());
        jSONObject.put("cdnIp", this.t);
        jSONObject.put("errorCode", this.i7);
        jSONObject.put("hasFirstFrame", this.b7);
        jSONObject.put("ipFromPlayerCore", this.u);
        jSONObject.put("downloadSpeed", this.e.R0);
        return jSONObject;
    }

    public void V0() {
        if (this.f == null) {
            return;
        }
        try {
            JSONObject w = w();
            if (w == null) {
                return;
            }
            w.put("event_key", "pull_restart").put("stream_data", this.r9).put("cmd", this.Sg).put("mode", this.Tg);
            B0(w, "live_client_monitor_log");
            long j = this.h7;
            if (j > 0) {
                this.h7 = j + 1;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void e0() {
        Kh.put("playing", 1);
        Kh.put("play_stop", 4);
        Kh.put("start_play", 8);
        Kh.put("first_frame", 4096);
        Kh.put("session_stop", 64);
        Kh.put("pull_restart_recmd", 128);
        Kh.put("pull_restart", 8192);
        Kh.put("pull_restart_success", 256);
        Kh.put("demux_stall", Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_APPID));
        Kh.put("retry", 1024);
        Kh.put("play_error", 2048);
        Kh.put("vqscore_report", 16384);
        Kh.put("session_start", 2);
        Kh.put("session_first_frame", 16);
        Kh.put("stream_abnormal", 32);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0() {
        org.apache.commons.net.ntp.a aVar = this.i8;
        if (aVar == null) {
            return;
        }
        org.apache.commons.net.ntp.d dVar = null;
        try {
            aVar.b();
            InetAddress inetAddress = this.j8;
            if (inetAddress != null) {
                dVar = this.i8.d(inetAddress);
            }
        } catch (SocketException e) {
            e.printStackTrace();
            return;
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        if (dVar == null) {
            return;
        }
        long time = dVar.b().a().getTime();
        long time2 = dVar.b().e().getTime();
        long time3 = dVar.b().d().getTime();
        long currentTimeMillis = System.currentTimeMillis();
        this.u8 = ((time2 - time) + (time3 - currentTimeMillis)) / 2;
        com.ss.videoarch.liveplayer.log.a.a("zdh", "ori:" + time + " rec:" + time2 + " trans:" + time3 + " destTs:" + currentTimeMillis + " diff:" + this.u8);
    }

    public JSONObject x() {
        int i;
        int i2;
        String str;
        this.f.getVideoCodecType();
        this.f.getIpFromPlayer();
        boolean z = this.k0;
        int i3 = 0;
        if ("bytevc2".equals(this.Z)) {
            z = false;
        }
        try {
            JSONObject put = new JSONObject().put("report_version", "5").put("live_sdk_version", "1.10.227.4-aweme").put("product_line", "live").put("client_timestamp", System.currentTimeMillis());
            String str2 = this.v;
            String str3 = "-1";
            if (str2 == null) {
                str2 = "-1";
            }
            JSONObject put2 = put.put("player_sdk_version", str2);
            String str4 = this.q;
            if (str4 == null) {
                str4 = "-1";
            }
            JSONObject put3 = put2.put("project_key", str4);
            String str5 = this.r;
            if (str5 != null) {
                str3 = str5;
            }
            JSONObject put4 = put3.put("cdn_play_url", str3);
            String str6 = this.t;
            String str7 = "none";
            if (str6 == null) {
                str6 = "none";
            }
            JSONObject put5 = put4.put("cdn_ip", str6).put("request_url", this.Wb);
            if (this.w) {
                i = 1;
            } else {
                i = 0;
            }
            JSONObject put6 = put5.put("is_preview", i);
            if (z) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            JSONObject put7 = put6.put("hardware_decode", i2);
            if (this.b7) {
                i3 = 1;
            }
            JSONObject put8 = put7.put("first_screen", i3);
            String str8 = this.e.x1;
            if (str8 != null) {
                str7 = str8;
            }
            JSONObject put9 = put8.put("dns_ip", str7).put("sub_scene", this.e.p1).put("width", this.D8).put("height", this.E8).put("ttnet_nqe_info", this.R9);
            if (this.ja) {
                str = "llash";
            } else {
                str = this.P6;
            }
            return put9.put("play_format", str).put("live_stream_session_id", this.L6).put("live_vv_session_id", this.N6);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private JSONObject b() {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONArray jSONArray3;
        JSONArray jSONArray4;
        JSONArray jSONArray5;
        u2();
        try {
            JSONObject put = new JSONObject().put("start_time", this.e.a).put("duration", System.currentTimeMillis() - this.e.a).put("render_fps_series", new JSONArray((Collection) this.J8)).put("download_bitrate_series", new JSONArray((Collection) this.K8)).put("play_buffer_series", new JSONArray((Collection) this.L8)).put("speed_switch_series", this.H5).put("video_stall_series", this.Q8).put("audio_stall_series", this.P8);
            if (this.S8 == null) {
                jSONArray = new JSONArray();
            } else {
                jSONArray = new JSONArray((Collection) this.S8);
            }
            JSONObject put2 = put.put("push_bitrate_series", jSONArray);
            if (this.T8 == null) {
                jSONArray2 = new JSONArray();
            } else {
                jSONArray2 = new JSONArray((Collection) this.T8);
            }
            JSONObject put3 = put2.put("push_fps_series", jSONArray2);
            if (this.M8 == null) {
                jSONArray3 = new JSONArray();
            } else {
                jSONArray3 = new JSONArray((Collection) this.M8);
            }
            JSONObject put4 = put3.put("stall_series", jSONArray3);
            if (this.N8 == null) {
                jSONArray4 = new JSONArray();
            } else {
                jSONArray4 = new JSONArray((Collection) this.N8);
            }
            JSONObject put5 = put4.put("stall_buffer_series", jSONArray4);
            JSONObject jSONObject = this.R8;
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            JSONObject put6 = put5.put("error_series", jSONObject);
            if (this.U8 == null) {
                jSONArray5 = new JSONArray();
            } else {
                jSONArray5 = new JSONArray((Collection) this.U8);
            }
            return put6.put("push_stall_series", jSONArray5).put("push_video_stall_series", this.W8).put("push_audio_stall_series", this.V8).put("quicu_audio_drop_series", this.X8).put("quicu_video_drop_series", this.Y8);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void E0() {
        d dVar;
        int i;
        int i2;
        VideoLiveManager videoLiveManager = this.f;
        if (videoLiveManager != null && (dVar = this.e) != null) {
            int i3 = 1;
            this.hf = 1;
            videoLiveManager.getLogInfo(dVar, 10);
            JSONObject w = w();
            if (w != null) {
                try {
                    JSONObject put = w.put("event_key", "first_frame_live");
                    if (this.b7) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    JSONObject put2 = put.put("is_stream_received", i).put("is_stream_received_live", this.hf).put("audio_live_open", this.e.I2).put("video_live_open", this.e.J2).put("audio_live_connect_end", this.e.K2).put("video_live_connect_end", this.e.L2).put("first_live_audio_packet_end", this.e.M2).put("first_live_video_packet_end", this.e.N2).put("first_live_audio_frame_render_end", this.e.O2).put("first_live_video_frame_render_end", this.e.P2).put("enable_preload", this.bf);
                    if (this.df == 1) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    JSONObject put3 = put2.put("audioHttpxRequestCached", i2);
                    if (this.ef != 1) {
                        i3 = 0;
                    }
                    JSONObject put4 = put3.put("videoHttpxRequestCached", i3).put("audioCachedNum", this.e.Q2).put("videoCachedNum", this.e.R2).put("preload_init_error", this.cf).put("preload_result", this.ff).put("preload_resolution", this.kf).put("play_use_preload_resolution", this.lf).put("preload_visit_timedelta", this.gf).put("start", this.e.a).put("sdk_dns_analysis_end", this.e.b).put("http_req_finish_time", this.e.m0).put("http_res_finish_time", this.e.n0).put("first_video_package_end", this.e.m).put("first_audio_package_end", this.e.n).put("first_video_frame_decode_end", this.e.o).put("first_audio_frame_decode_end", this.e.p).put("first_frame_from_player_core", this.e.s).put("first_frame_render_end", this.e.q).put("video_param_send_outlet_time", this.e.q1).put("first_video_frame_send_outlet_time", this.e.r1).put("video_first_pkt_pts", this.e.h0).put("audio_first_pkt_pts", this.e.j0).put("video_buffer_time", this.e.Z0).put("audio_buffer_time", this.e.a1).put("download_speed", this.e.R0).put("suggest_format", this.y9).put("suggest_protocol", this.A9);
                    d dVar2 = this.e;
                    JSONObject put5 = put4.put("first_live_frame_time", dVar2.P2 - dVar2.a).put("cache_hit", this.f1040if).put("preload_task_state", this.jf).put("cache_open_start_time", this.e.Y2).put("cache_open_end_time", this.e.Z2).put("cache_read_eof_time", this.e.a3).put("live_open_start_time", this.e.b3).put("live_open_end_time", this.e.c3).put("live_read_first_pkt_time", this.e.d3);
                    d dVar3 = this.e;
                    JSONObject put6 = put5.put("cache_open_cost", dVar3.Z2 - dVar3.Y2);
                    d dVar4 = this.e;
                    JSONObject put7 = put6.put("cache_consume_cost", dVar4.a3 - dVar4.Y2);
                    d dVar5 = this.e;
                    JSONObject put8 = put7.put("live_open_cost", dVar5.c3 - dVar5.b3);
                    d dVar6 = this.e;
                    JSONObject put9 = put8.put("cache_live_hole", dVar6.c3 - dVar6.a3);
                    d dVar7 = this.e;
                    JSONObject put10 = put9.put("cache_live_read_diff", dVar7.d3 - dVar7.a3);
                    d dVar8 = this.e;
                    put10.put("cache_live_render_diff", dVar8.P2 - dVar8.q).put("buffer_stall_time", this.o7).put("buffer_stall_count", this.n7).put("video_decode_stall_time", this.Bc).put("video_decode_stall_count", this.Ac).put("audio_decode_stall_time", this.Dc).put("audio_decode_stall_count", this.Cc).put("video_render_stall_time", this.C7).put("video_render_stall_count", this.B7).put("audio_render_stall_time", this.E7).put("audio_render_stall_count", this.D7);
                    B0(w, "live_client_monitor_log");
                    long j = this.h7;
                    if (j > 0) {
                        this.h7 = j + 1;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public JSONObject c0() {
        String str;
        String str2;
        String str3;
        int i;
        int i2;
        String str4;
        String str5;
        boolean sRState;
        boolean sharpenState;
        int i3;
        d dVar = new d();
        int i4 = 1;
        this.f.getLogInfo(dVar, 1);
        String str6 = "none";
        if (this.f.getSRUsed()) {
            if (this.f.getSRAlType() == 0) {
                str = "2x";
            } else if (this.f.getSRAlType() != 4) {
                str = "none";
            } else {
                str = "1.5x";
            }
            this.t9 = true;
        } else {
            str = "0";
        }
        String playerInternalState = this.f.getPlayerInternalState();
        JSONObject pushStreamInfo = this.f.getPushStreamInfo();
        if (pushStreamInfo == null) {
            str2 = "none";
            str3 = str2;
        } else {
            str3 = pushStreamInfo.optString("push_client_resolution");
            str2 = pushStreamInfo.optString("push_client_codec_type");
        }
        try {
            JSONObject put = new JSONObject().put("playing_time:", System.currentTimeMillis() - this.d7).put("live_sdk_version:", "1.10.227.4-aweme");
            String str7 = this.v;
            String str8 = "-1";
            if (str7 == null) {
                str7 = "-1";
            }
            JSONObject put2 = put.put("player_sdk_version:", str7);
            String str9 = this.t;
            if (str9 != null) {
                str8 = str9;
            }
            JSONObject put3 = put2.put("cdn_ip:", str8).put("push_client_sdk_version:", this.D).put("push_client_platform:", this.E).put("push_client_model:", this.G).put("push_client_os_version:", this.F).put("push_client_is_hardware_encode:", this.I).put("push_client_push_protocol:", this.N).put("push_client_qid:", this.O).put("push_client_bitrate:", this.e.n1).put("push_client_fps:", this.e.o1);
            int i5 = 0;
            if (this.W) {
                i = 1;
            } else {
                i = 0;
            }
            JSONObject put4 = put3.put("Hit_Node_Optimizer:", i).put("Evaluator_Symbol:", this.S);
            if (this.X) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            JSONObject put5 = put4.put("Is_Remote_Sorted:", i2).put("Stall_Total_Count:", this.n7).put("Stall_Total_Time:", this.o7);
            long j = this.m7;
            if (j == -1) {
                str4 = "no stall";
            } else if (j == 0) {
                str4 = "network stall";
            } else {
                str4 = "decode stall";
            }
            JSONObject put6 = put5.put("Stall_Reason:", str4).put("audio_Render_Stall_Total_Count：", this.D7).put("audio_Render_Stall_Total_Time：", this.E7).put("video_Render_Stall_Total_Count：", this.B7).put("video_Render_Stall_Total_Time：", this.C7);
            d dVar2 = this.e;
            JSONObject put7 = put6.put("first_frame_time:", dVar2.q - dVar2.a);
            d dVar3 = this.e;
            JSONObject put8 = put7.put("first_live_frame_time: ", dVar3.P2 - dVar3.a).put("video_Buffer_Time:", dVar.Z0).put("audio_Buffer_Time:", dVar.a1).put("delay:", this.e.g1).put("render_fps:", dVar.Q0).put("sei_source:", this.e.k1).put("download_Speed:", dVar.R0).put("Error_Code:", this.i7).put("HardDecode:", this.k0).put("domain:", this.Ye).put("sr_type:", str).put("push_client_resolution:", str3).put("push_client_codec_type:", str2).put("Codec_Type:", this.Z).put("Codec_Name:", this.H0);
            if (this.x8 == 1) {
                str6 = "PCDN";
            } else if (this.v8 == 1) {
                str6 = "Http-CDN";
            }
            JSONObject put9 = put8.put("MDL_Vendor:", str6).put("audio_Buffer_Time_On_First_Frame:", this.e.d1).put("waiting_Time_After_First_Frame:", this.e.e1).put("dns_ip:", this.e.x1);
            if (TextUtils.isEmpty(this.s)) {
                str5 = this.r;
            } else {
                str5 = this.s;
            }
            JSONObject put10 = put9.put("url:", str5).put("width:", this.D8).put("height:", this.E8).put("resolution:", dVar.y1).put("play_format:", this.P6).put("play_protocol:", this.z9).put("settings_res:", this.W9);
            if (!this.T9) {
                i4 = 0;
            }
            JSONObject put11 = put10.put("enable_resolution_auto_degrade:", i4);
            VideoLiveManager videoLiveManager = this.f;
            if (videoLiveManager == null) {
                sRState = false;
            } else {
                sRState = videoLiveManager.getSRState();
            }
            JSONObject put12 = put11.put("is_use_sr", sRState);
            VideoLiveManager videoLiveManager2 = this.f;
            if (videoLiveManager2 == null) {
                sharpenState = false;
            } else {
                sharpenState = videoLiveManager2.getSharpenState();
            }
            JSONObject put13 = put12.put("is_use_sharpen", sharpenState).put("enable_volume_balance", this.G6).put("volume_balance_type", this.H6);
            VideoLiveManager videoLiveManager3 = this.f;
            if (videoLiveManager3 != null) {
                i3 = videoLiveManager3.getIntValueInner(554, 0);
            } else {
                i3 = 0;
            }
            JSONObject put14 = put13.put("samplerate", i3);
            VideoLiveManager videoLiveManager4 = this.f;
            if (videoLiveManager4 != null) {
                i5 = videoLiveManager4.getIntValueInner(553, 0);
            }
            JSONObject put15 = put14.put("channels", i5).put("sei_bitrate", this.e.n1).put("player_state:", playerInternalState).put("enable_fast_first_frame", this.N9);
            if (TextUtils.equals(this.A9, "quicu")) {
                put15.put("audio_quicu_frame_drop_time:", this.Vc).put("video_quicu_frame_drop_time:", this.Xc).put("audio_quicu_frame_drop_count:", this.Uc).put("video_quicu_frame_drop_count:", this.Wc);
            }
            return put15;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void o1() {
        boolean z;
        long currentTimeMillis;
        long j;
        long j2;
        boolean z2;
        long j3;
        long j4;
        long j5;
        int i;
        long j6;
        int i2;
        int i3;
        int i4;
        long j7;
        long j8;
        long j9;
        int i5;
        long j10;
        long j11;
        JSONObject jSONObject;
        long j12;
        JSONObject a0;
        if (this.ic != 0 && this.jc != null) {
            if (this.zh == 1) {
                this.c.removeMessages(101);
            }
            this.f.getSessionlogInfo(this.jc);
            JSONObject w = w();
            if (this.b7 && !this.c7) {
                this.M6 = this.L6;
                this.c7 = true;
                z = true;
            } else {
                z = false;
            }
            if (!this.kc) {
                L1(w, 0, 0);
            }
            if (this.kc) {
                j = System.currentTimeMillis() - this.mc;
                currentTimeMillis = 0;
            } else {
                currentTimeMillis = System.currentTimeMillis() - this.lc;
                j = 0;
            }
            if (this.kc) {
                if (this.ng) {
                    j2 = this.pg + (System.currentTimeMillis() - this.mg);
                } else {
                    j2 = this.pg;
                }
            } else {
                j2 = 0;
            }
            this.oc++;
            long j13 = this.vc;
            if (j13 > 0) {
                j4 = j13 - this.mc;
                z2 = z;
                j3 = this.wc - j13;
            } else {
                z2 = z;
                j3 = 0;
                j4 = 0;
            }
            if (this.F7) {
                this.pc++;
                if (this.k7 >= this.lc) {
                    j5 = j2;
                    this.qc += System.currentTimeMillis() - this.k7;
                } else {
                    j5 = j2;
                    this.qc += System.currentTimeMillis() - this.lc;
                }
            } else {
                j5 = j2;
            }
            o();
            if ((this.Q6.equals("cellular") && this.e.i3 == -1) || this.e.h3 != -1) {
                this.U6 += this.jc.u0;
                this.V6 += j;
            }
            d dVar = this.jc;
            long j14 = dVar.u0;
            long j15 = dVar.v0;
            if (w != null) {
                try {
                    JSONObject put = w.put("event_key", "session_stop").put("index", this.oc).put("socket_err_code", this.e.J1).put("socket_err_type", this.e.I1).put("stop_time", System.currentTimeMillis()).put("play_time", j);
                    if (this.kc) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    JSONObject put2 = put.put("is_stream_received", i).put("render_fail_type", this.xc).put("code", this.yc).put("stall_count", this.pc).put("stall_time", this.qc).put("audio_render_stall_count", this.tc).put("audio_render_stall_time", this.uc).put("video_render_stall_count", this.rc).put("video_render_stall_time", this.sc).put("start", this.lc).put("sdk_dns_analysis_end", this.jc.b).put("player_dns_analysis_end", this.e.d).put("http_req_finish_time", this.jc.m0).put("http_res_finish_time", this.jc.n0).put("tcp_first_package_end", this.e.l).put("first_video_package_end", this.jc.m).put("first_audio_package_end", this.jc.n).put("first_video_frame_decode_end", this.jc.o).put("first_audio_frame_decode_end", this.jc.p).put("video_device_open_start", this.jc.u).put("video_device_open_end", this.jc.v).put("audio_device_open_start", this.jc.w).put("audio_device_open_end", this.jc.x).put("video_device_wait_start", this.jc.v1).put("video_device_wait_end", this.jc.w1).put("find_stream_info_start", this.jc.t1).put("find_stream_info_end", this.jc.u1).put("video_param_send_outlet_time", this.jc.q1).put("first_video_frame_send_outlet_time", this.jc.r1).put("first_frame_render_end", this.mc).put("first_audio_frame_end", this.nc).put("prepare_end", this.jc.t).put("prepare_block_end", this.jc.c).put("video_first_pkt_pos", this.jc.g0).put("video_first_pkt_pts", this.jc.h0).put("audio_first_pkt_pos", this.jc.i0).put("audio_first_pkt_pts", this.jc.j0).put("video_render_type", this.jc.s1).put("download_speed", this.jc.b1).put("video_buffer_time", this.jc.c1).put("audio_buffer_time", this.jc.d1);
                    if (this.jc.e1 > 0) {
                        j6 = this.e.e1;
                    } else {
                        j6 = -this.e.e1;
                    }
                    JSONObject put3 = put2.put("wait_time", j6);
                    if (this.jc.e1 >= 0) {
                        i2 = 0;
                    } else {
                        i2 = 1;
                    }
                    JSONObject put4 = put3.put("is_waiting", i2).put("first_stall_time", j4).put("first_stall_duration", j3).put("play_time_on_no_frame", currentTimeMillis);
                    String str = this.A;
                    if (str == null) {
                        str = "none";
                    }
                    JSONObject put5 = put4.put("sdk_params", str).put("total_download_size", j14).put("drop_audio_pts_diff", this.jc.k0).put("drop_audio_cost", this.jc.l0);
                    if (this.t9) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    JSONObject put6 = put5.put("sr_used", i3);
                    if (this.u9) {
                        i4 = 1;
                    } else {
                        i4 = 0;
                    }
                    JSONObject put7 = put6.put("sharpen_used", i4).put("network_timeout", this.Ja).put("suggest_format", this.y9).put("suggest_protocol", this.A9).put("suggest_access_code", this.F9).put("first_sei_delay", this.jc.i1).put("room_play_time_ms", j5).put("error_msg", this.zc).put("play_size", j15);
                    if (this.Od > 0) {
                        j7 = this.jc.w0;
                    } else {
                        j7 = 0;
                    }
                    JSONObject put8 = put7.put("http_flow_size", j7);
                    if (this.Od > 0) {
                        j8 = this.jc.x0;
                    } else {
                        j8 = 0;
                    }
                    JSONObject put9 = put8.put("p2p_flow_size", j8);
                    if (this.Od > 0) {
                        j9 = this.jc.z0;
                    } else {
                        j9 = 0;
                    }
                    JSONObject put10 = put9.put("p2p_mobile_flow_size", j9).put("httpio_play_time", this.jc.A0).put("p2pio_play_time", this.jc.B0).put("multipath_cellular_flow_size", this.jc.F0).put("multipath_running_status", this.jc.E0).put("switch_cellular_reason", this.jc.h3).put("switch_cellular_detail", this.jc.j3).put("switch_cellular_result", this.jc.l3).put("switch_default_reason", this.jc.i3).put("switch_default_detail", this.jc.k3).put("switch_default_result", this.jc.m3).put("cellular_total_download_size", this.U6).put("cellular_play_time", this.V6).put("event_key_index", Hh.incrementAndGet());
                    if (z2) {
                        i5 = 1;
                    } else {
                        i5 = 0;
                    }
                    JSONObject put11 = put10.put("is_first_play", i5).put("p2p_flv_detail", this.ah).put("svc_play", this.Ug);
                    if (this.Od > 0) {
                        j10 = this.jc.G0;
                    } else {
                        j10 = 0;
                    }
                    JSONObject put12 = put11.put("http_patch_dts_size", j10);
                    if (this.Od > 0) {
                        j11 = this.jc.H0;
                    } else {
                        j11 = 0;
                    }
                    put12.put("http_substream_size", j11);
                    if (this.r == null) {
                        jSONObject = w;
                        jSONObject.put("tcp_connect_end", this.jc.f);
                    } else {
                        jSONObject = w;
                        if ("kcp".equals(this.z9)) {
                            j12 = this.jc.d;
                        } else {
                            j12 = this.jc.f;
                        }
                        jSONObject.put("tcp_connect_end", j12);
                    }
                    j(jSONObject);
                    if (g0()) {
                        G(jSONObject);
                    }
                    this.h7++;
                    B0(jSONObject, "live_client_monitor_log");
                    this.Hg++;
                    if (this.Fg > 0 && ((this.Dg.size() < this.Eg || this.Gg) && (a0 = a0(jSONObject)) != null)) {
                        this.Dg.add(a0);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            R1();
        }
    }

    private static class a {
        private HandlerThread a;
        private Handler b;

        static {
            Covode.recordClassIndex(653044);
        }

        public a(c cVar) {
            HandlerThread handlerThread = new HandlerThread("DnsHandlerThread");
            this.a = handlerThread;
            handlerThread.start();
            this.b = new C0155a(this.a.getLooper(), cVar);
        }

        /* renamed from: fj6.c$a$a, reason: collision with other inner class name */
        class C0155a extends HandlerDelegate {
            final /* synthetic */ c c;

            public void handleMessage(Message message) {
                String str;
                if (message != null && (str = this.c.r8) != null && !str.equals("null")) {
                    if ((message.what == 104 && this.c.o8 == -1) || this.c.f0() || this.c.j8 == null) {
                        try {
                            c cVar = this.c;
                            cVar.j8 = InetAddress.getByName(cVar.r8);
                        } catch (UnknownHostException e) {
                            this.c.j8 = null;
                            e.printStackTrace();
                        }
                    }
                    if (message.what == 103) {
                        this.c.k0();
                        if (this.c.q8) {
                            a.this.b.sendEmptyMessageDelayed(103, 300000L);
                        }
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0155a(Looper looper, c cVar) {
                super(looper);
                this.c = cVar;
            }
        }

        public void b(int i, long j) {
            Handler handler;
            if (this.a != null && (handler = this.b) != null) {
                if (j == 0) {
                    handler.sendEmptyMessage(i);
                } else {
                    handler.sendEmptyMessageDelayed(i, j);
                }
            }
        }
    }

    public void S0(String str) {
        this.D9 = str;
        this.C9 = 1;
    }

    public void W1(String str) {
        if (str != null) {
            this.m = str;
        }
    }

    public void Y1(String str) {
        if (str != null) {
            this.S = str;
        }
    }

    public void i(PureColorDetector.a aVar) {
        this.sh.offer(aVar);
    }

    public void k2(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.o = jSONObject;
        }
    }

    public void T1(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.p = str;
        }
    }

    public void V1(int i) {
        boolean z;
        int i2 = 0;
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        this.W7 = z;
        if (i <= 0) {
            i2 = -1;
        }
        this.X7 = i2;
    }

    public void X1(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.n = str;
        }
    }

    public void e2(long j) {
        if (j >= 2000) {
            this.g = j;
        }
    }

    public void i2(long j) {
        if (j >= 2000) {
            this.se = j;
        }
    }

    public void n2(long j) {
        d dVar = this.e;
        if (dVar != null) {
            dVar.e1 = j;
        }
        d dVar2 = this.jc;
        if (dVar2 != null) {
            dVar2.e1 = j;
        }
    }

    public void t0(long j) {
        this.e.r = j;
        if (this.ic == 1) {
            this.nc = j;
        }
    }

    public void v2(long j) {
        this.Zg.add(v(j));
    }

    private void j(JSONObject jSONObject) throws JSONException {
        long streamVersion = this.f.getStreamVersion();
        if (streamVersion >= 0) {
            jSONObject.put("stream_version", streamVersion);
        }
    }

    private void k(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put("app_session_uuid", VideoLiveManager.sAppSessionUUID).put("event_index", VideoLiveManager.sUploadLogEventIndex.incrementAndGet());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void a(String str) {
        if (this.zf == null) {
            this.zf = new HashMap<>();
        }
        this.zf.put(str, 1);
    }

    public void c2(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.I9 = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void f2(int i) {
        if (i == 1 && this.i == 0) {
            this.i = System.currentTimeMillis();
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        if (101 == i) {
            H1(false, 0L, 0L, 0L, 0L, 0L);
        }
        if (102 == i) {
            M1();
            return true;
        }
        return true;
    }

    public long l(JSONArray jSONArray) throws JSONException {
        long j = 0;
        for (int i = 0; i < jSONArray.length(); i++) {
            j += jSONArray.getInt(i);
        }
        return j;
    }

    public void v1(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            B0(w().put("event_key", "strategy_report").put("report_info", jSONObject), "live_client_monitor_log");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void K1(JSONObject jSONObject) throws JSONException {
        if (TextUtils.equals(this.z9, "quic") || TextUtils.equals(this.z9, "quicu")) {
            jSONObject.put("quic_open_result", this.e.M1);
            com.ss.videoarch.liveplayer.log.a.c("LiveLoggerService", "quic_open_result = " + this.e.M1);
        }
    }

    public void F(long j) {
        if (this.Za == null) {
            this.Za = new LinkedBlockingQueue<>(600);
        }
        if (this.Za.remainingCapacity() == 0 && this.Za.size() > 0) {
            this.Za.poll();
        }
        this.Za.offer(Long.valueOf(j));
    }

    public void G0(String str) {
        VideoLiveManager videoLiveManager = this.f;
        if (videoLiveManager == null) {
            return;
        }
        videoLiveManager.getLogInfo(this.e, 2);
        JSONObject w = w();
        if (w != null) {
            try {
                w.put("event_key", "illegal_call").put("api_name", str);
                K1(w);
                B0(w, "live_client_monitor_log");
                long j = this.h7;
                if (j > 0) {
                    this.h7 = j + 1;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONObject P(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put("start_play_time", this.e.a).put("sdk_dns_analysis_end", this.e.b).put("first_frame_render_end", this.e.q).put("retry_count", this.V7);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    public void a1(String str) {
        if (this.f != null && str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                com.ss.videoarch.liveplayer.log.a.c("LiveLoggerService", "recv event notify: " + jSONObject);
                t2(jSONObject);
            } catch (Exception e) {
                com.ss.videoarch.liveplayer.log.a.b("LiveLoggerService", "recv event notify error occurs error:" + e.toString());
            }
        }
    }

    public void b1(String str) {
        if (this.f == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (str != null) {
                jSONObject.put("product_line", "rts");
                jSONObject.put("rtc_trace_info", str);
                if (!str.isEmpty() && str.contains("rts_play_stop")) {
                    this.Ob = new JSONObject(str).optString("event_message");
                }
            }
            B0(jSONObject, "live_webrtc_monitor_log");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void c1(String str) {
        if (this.f == null) {
            return;
        }
        try {
            JSONObject w = w();
            w.put("event_key", "recved_spspps").put("spspps", str);
            B0(w, "live_client_monitor_log");
            long j = this.h7;
            if (j > 0) {
                this.h7 = j + 1;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void d1(String str) {
        if (this.f == null) {
            return;
        }
        this.Ah++;
        this.Bh.add("spspps:" + str + "received_time:" + System.currentTimeMillis());
    }

    public void m2(ILiveSettingBundle iLiveSettingBundle) {
        this.a9 = iLiveSettingBundle;
        if (iLiveSettingBundle != null) {
            this.ic = ((Integer) iLiveSettingBundle.getSettingsValueForKey("live_sdk_should_report_session_stop", 0)).intValue();
            com.ss.videoarch.liveplayer.log.a.c("LiveLoggerService", "enable report sessionstop: " + this.ic);
            if (this.ic == 1) {
                this.jc = new d();
            }
        }
    }

    public boolean r2(int i) {
        d dVar;
        VideoLiveManager videoLiveManager = this.f;
        if (videoLiveManager != null && this.d != null && (dVar = this.e) != null) {
            if (i == 1) {
                this.vg = dVar.v0;
                this.wg = dVar.N0;
                this.xg = dVar.u0;
                this.yg = dVar.P0;
                this.Ha = dVar.O0;
            }
            videoLiveManager.getLogInfo(dVar, i);
            return true;
        }
        return false;
    }

    public void t(String str) {
        if (this.h) {
            this.h = false;
            this.c.removeCallbacksAndMessages(null);
            a aVar = this.k8;
            if (aVar != null) {
                aVar.b.removeCallbacksAndMessages(null);
            }
            this.q8 = false;
        }
        S1();
        t1(str);
        N1(true);
        P1();
    }

    public void u0(String str) {
        JSONObject w;
        if (this.f != null && (w = w()) != null) {
            try {
                w.put("event_key", "call_not_in_main_thread").put("api_name", str);
                B0(w, "live_client_monitor_log");
                long j = this.h7;
                if (j > 0) {
                    this.h7 = j + 1;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean B(JSONObject jSONObject) {
        Integer num;
        ILiveSettingBundle iLiveSettingBundle = this.a9;
        if (iLiveSettingBundle != null && jSONObject != null) {
            try {
                if (!this.tg) {
                    boolean booleanValue = ((Boolean) iLiveSettingBundle.getSettingsValueForKey("live_setting_applog_key", Boolean.FALSE)).booleanValue();
                    this.tg = booleanValue;
                    if (!booleanValue) {
                        return false;
                    }
                }
                if (this.vh == 1) {
                    return true;
                }
                if (this.ug == 0) {
                    this.ug = ((Integer) iLiveSettingBundle.getSettingsValueForKey("live_setting_enable_applog_event_key", 0)).intValue();
                }
                if (this.ug == 0) {
                    return true;
                }
                Object obj = jSONObject.get("event_key");
                if (obj != null && (obj instanceof String) && (num = Kh.get(obj)) != null) {
                    if ((num.intValue() & this.ug) > 0) {
                        return true;
                    }
                }
            } catch (Throwable th) {
                com.ss.videoarch.liveplayer.log.a.b("LiveLoggerService", "report ex=" + th);
            }
        }
        return false;
    }

    private void I0(boolean z) {
        String str;
        int i;
        int i2;
        if (this.v8 == 1) {
            gj6.b c = gj6.b.c();
            if (z) {
                i2 = 8013;
            } else {
                i2 = 8014;
            }
            c.j(i2, this.L6, -1);
        }
        if (this.y8 == 1) {
            f t = f.t();
            if (z) {
                i = 1008;
            } else {
                i = 1009;
            }
            t.F(i, this.f.getLiveIOSessionId(), -1L);
        }
        JSONObject w = w();
        if (w != null) {
            try {
                JSONObject put = w.put("event_key", "link");
                if (z) {
                    str = "start";
                } else {
                    str = "end";
                }
                put.put("info", str);
                B0(w, "live_client_monitor_log");
                long j = this.h7;
                if (j > 0) {
                    this.h7 = j + 1;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private JSONObject v(long j) {
        long j2;
        JSONObject jSONObject = new JSONObject();
        if (this.kc) {
            j2 = System.currentTimeMillis() - this.mc;
        } else {
            j2 = 0;
        }
        try {
            if (this.nh == 1) {
                jSONObject.put("exception_code", 1);
            } else {
                jSONObject.put("exception_code", 3);
            }
            jSONObject.put("httpio_play_time", j2);
            jSONObject.put("p2pio_play_time", 0);
            jSONObject.put("group_id", 0);
            jSONObject.put("group_reason", 0);
            jSONObject.put("group_enter_reason", 0);
            jSONObject.put("p2p_onlines", 0);
            jSONObject.put("http_flow_size", j);
            jSONObject.put("p2p_flow_size", 0);
            jSONObject.put("p2p_mobile_flow_size", 0);
            jSONObject.put("buffer_not_satify_p2p_times", 0);
            jSONObject.put("buffer_not_satify_p2p_value", 0);
            jSONObject.put("first_time_h2p_buffer", 0);
            jSONObject.put("http_patch_dts_size", 0);
            jSONObject.put("http_substream_size", 0);
            jSONObject.put("session_id", this.L6);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public void D0(int i) {
        VideoLiveManager videoLiveManager;
        if (!this.b7 && (videoLiveManager = this.f) != null) {
            videoLiveManager.getLogInfo(this.e, 2);
            JSONObject w = w();
            if (w != null) {
                try {
                    w.put("event_key", "first_frame_failed").put("start_time", System.currentTimeMillis()).put("reason", i);
                    K1(w);
                    B0(w, "live_client_monitor_log");
                    long j = this.h7;
                    if (j > 0) {
                        this.h7 = j + 1;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void X0(int i) {
        long currentTimeMillis;
        long j;
        VideoLiveManager videoLiveManager = this.f;
        if (videoLiveManager == null) {
            return;
        }
        try {
            videoLiveManager.getLogInfo(this.e, 0);
            JSONObject y = y(this.e, 0L, this.Y, i);
            if (y == null) {
                return;
            }
            if (i == -1) {
                if (!this.b7) {
                    currentTimeMillis = System.currentTimeMillis();
                    j = this.e.a;
                } else if (this.lc > 0) {
                    currentTimeMillis = System.currentTimeMillis();
                    j = this.lc;
                }
                i = (int) (currentTimeMillis - j);
            }
            y.put("event_key", "pull_restart_success").put("stall_time", i).put("start", this.lc).put("cmd", this.Sg).put("mode", this.Tg);
            B0(y, "live_client_monitor_log");
            long j2 = this.h7;
            if (j2 > 0) {
                this.h7 = j2 + 1;
            }
            this.Tg = "";
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void g1(int i) {
        this.U7++;
        this.V7++;
        this.f.getLogInfo(this.e, 2);
        JSONObject w = w();
        n();
        if (w != null) {
            try {
                w.put("event_key", "retry").put("reason", this.i7).put("code", i).put("socket_err_code", this.e.J1).put("socket_err_type", this.e.I1).put("render_fail_type", this.j7);
                K1(w);
                B0(w, "live_client_monitor_log");
                o0();
                long j = this.h7;
                if (j > 0) {
                    this.h7 = j + 1;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void h1(int i) {
        if (i == 1) {
            if (this.b7 && !this.ng) {
                this.lg = System.currentTimeMillis();
                this.mg = System.currentTimeMillis();
            }
            this.ng = true;
        }
        if (i == 2) {
            if (this.b7 && this.lg > 0 && this.mg > 0 && this.ng) {
                this.og += System.currentTimeMillis() - this.lg;
                this.pg += System.currentTimeMillis() - this.mg;
            }
            this.ng = false;
        }
    }

    public void p1(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("start_time", this.of);
            jSONObject.put("duration", System.currentTimeMillis() - this.of);
            jSONObject.put("average_db", i);
            com.ss.videoarch.liveplayer.log.a.a("LiveLoggerService", "silence end: " + jSONObject);
            JSONObject jSONObject2 = this.pf;
            if (jSONObject2 != null) {
                jSONObject2.put(String.valueOf(this.nf), jSONObject);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void s2(String str) {
        if (str == null) {
            com.ss.videoarch.liveplayer.log.a.a("LiveLoggerService", "no p2pinfo, sessionid:" + this.L6);
            return;
        }
        try {
            JSONObject u = u(new JSONArray(str));
            if (u != null && this.nh != 1) {
                this.ah = u.toString();
                this.Zg.add(new JSONObject(this.ah));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void J1(JSONObject jSONObject) throws JSONException {
        String str;
        String str2;
        String str3;
        if (TextUtils.equals(this.P6, "cmaf")) {
            String str4 = "";
            if (TextUtils.isEmpty(this.e.I)) {
                str = "";
            } else {
                str = this.e.I;
            }
            jSONObject.put("cmaf_video_request_log", str);
            if (TextUtils.isEmpty(this.e.J)) {
                str2 = "";
            } else {
                str2 = this.e.J;
            }
            jSONObject.put("cmaf_audio_request_log", str2);
            com.ss.videoarch.liveplayer.log.a.c("LiveLoggerService", "cmaf_video_request_log = " + this.e.I + "\tcmaf_audio_request_log = " + this.e.J);
            if (TextUtils.isEmpty(this.e.K)) {
                str3 = "";
            } else {
                str3 = this.e.K;
            }
            jSONObject.put("cmaf_video_req_no_series", str3);
            if (!TextUtils.isEmpty(this.e.L)) {
                str4 = this.e.L;
            }
            jSONObject.put("cmaf_audio_req_no_series", str4);
            com.ss.videoarch.liveplayer.log.a.c("LiveLoggerService", "cmaf_video_req_no_series = " + this.e.K + "\tcmaf_audio_req_no_series = " + this.e.L);
        }
    }

    private JSONObject a0(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (jSONObject.has("total_download_size")) {
                jSONObject2.put("total_download_size", jSONObject.get("total_download_size"));
            }
            if (jSONObject.has("play_size")) {
                jSONObject2.put("play_size", jSONObject.get("play_size"));
            }
            if (jSONObject.has("play_time")) {
                jSONObject2.put("play_time", jSONObject.get("play_time"));
            }
            if (jSONObject.has("http_flow_size")) {
                jSONObject2.put("http_flow_size", jSONObject.get("http_flow_size"));
            }
            if (jSONObject.has("p2p_flow_size")) {
                jSONObject2.put("p2p_flow_size", jSONObject.get("p2p_flow_size"));
            }
            if (jSONObject.has("p2p_mobile_flow_size")) {
                jSONObject2.put("p2p_mobile_flow_size", jSONObject.get("p2p_mobile_flow_size"));
            }
            if (jSONObject.has("ab_group_id")) {
                jSONObject2.put("ab_group_id", jSONObject.get("ab_group_id"));
            }
            if (jSONObject.has("live_stream_session_id")) {
                jSONObject2.put("session_id", jSONObject.get("live_stream_session_id"));
            }
            jSONObject2.put("client_timestamp", jSONObject.get("client_timestamp"));
            return jSONObject2;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void F0(String str) {
        JSONObject w;
        if (str == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("skip_duraion")) {
                this.T1 += jSONObject.optInt("skip_duraion", 0);
            }
            if (jSONObject.has("skip_audio_time")) {
                this.V1 += jSONObject.optInt("skip_audio_time", 0);
            }
            if (jSONObject.has("skip_video_time")) {
                this.b2 += jSONObject.optInt("skip_video_time", 0);
            }
            if (jSONObject.has("av_skip_end_diff")) {
                this.x2 = jSONObject.optInt("av_skip_end_diff", 0);
            }
            if (jSONObject.has("av_skip_end_pts_diff")) {
                this.y2 = jSONObject.optInt("av_skip_end_pts_diff", 0);
            }
            this.v2++;
            if (this.f != null && this.H2 != 0 && (w = w()) != null) {
                w.put("event_key", "skip_data_info");
                a2(w, jSONObject);
                B0(w, "live_client_monitor_log");
                long j = this.h7;
                if (j > 0) {
                    this.h7 = j + 1;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void j0(int i) {
        this.H4++;
        StringBuilder sb = new StringBuilder();
        sb.append(this.V4);
        sb.append(",");
        double d = i / 1000.0d;
        sb.append(d);
        sb.append(":");
        sb.append(System.currentTimeMillis());
        this.V4 = sb.toString();
        if (this.H5.equals("none")) {
            this.H5 = (System.currentTimeMillis() - R(101, 0L)) + ":" + d;
            return;
        }
        this.H5 += "," + (System.currentTimeMillis() - R(101, 0L)) + ":" + d;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x007c A[Catch: JSONException -> 0x0082, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0082, blocks: (B:4:0x000e, B:7:0x0030, B:9:0x0060, B:13:0x006c, B:15:0x007c), top: B:3:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void k1(com.ss.videoarch.liveplayer.log.LiveError r5) {
        /*
            r4 = this;
            com.ss.videoarch.liveplayer.VideoLiveManager r0 = r4.f
            fj6.d r1 = r4.e
            r2 = 2
            r0.getLogInfo(r1, r2)
            org.json.JSONObject r0 = r4.w()
            if (r0 == 0) goto L86
            java.lang.String r1 = "event_key"
            java.lang.String r2 = "prepare_result"
            org.json.JSONObject r1 = r0.put(r1, r2)     // Catch: org.json.JSONException -> L82
            java.lang.String r2 = "error_msg"
            java.lang.String r3 = r5.getInfoJSON()     // Catch: org.json.JSONException -> L82
            org.json.JSONObject r1 = r1.put(r2, r3)     // Catch: org.json.JSONException -> L82
            java.lang.String r2 = "result"
            int r5 = r5.code     // Catch: org.json.JSONException -> L82
            org.json.JSONObject r5 = r1.put(r2, r5)     // Catch: org.json.JSONException -> L82
            java.lang.String r1 = "sdk_params"
            java.lang.String r2 = r4.A     // Catch: org.json.JSONException -> L82
            if (r2 != 0) goto L30
            java.lang.String r2 = "none"
        L30:
            org.json.JSONObject r5 = r5.put(r1, r2)     // Catch: org.json.JSONException -> L82
            java.lang.String r1 = "stream_type"
            fj6.d r2 = r4.e     // Catch: org.json.JSONException -> L82
            int r2 = r2.C2     // Catch: org.json.JSONException -> L82
            org.json.JSONObject r5 = r5.put(r1, r2)     // Catch: org.json.JSONException -> L82
            java.lang.String r1 = "suggest_format"
            java.lang.String r2 = r4.y9     // Catch: org.json.JSONException -> L82
            org.json.JSONObject r5 = r5.put(r1, r2)     // Catch: org.json.JSONException -> L82
            java.lang.String r1 = "suggest_protocol"
            java.lang.String r2 = r4.A9     // Catch: org.json.JSONException -> L82
            org.json.JSONObject r5 = r5.put(r1, r2)     // Catch: org.json.JSONException -> L82
            java.lang.String r1 = "suggest_access_code"
            java.lang.String r2 = r4.F9     // Catch: org.json.JSONException -> L82
            org.json.JSONObject r5 = r5.put(r1, r2)     // Catch: org.json.JSONException -> L82
            java.lang.String r1 = "nnsr_enabled"
            com.ss.videoarch.liveplayer.VideoLiveManager r2 = r4.f     // Catch: org.json.JSONException -> L82
            boolean r2 = r2.getSRState()     // Catch: org.json.JSONException -> L82
            if (r2 != 0) goto L6b
            com.ss.videoarch.liveplayer.VideoLiveManager r2 = r4.f     // Catch: org.json.JSONException -> L82
            boolean r2 = r2.getSharpenState()     // Catch: org.json.JSONException -> L82
            if (r2 == 0) goto L69
            goto L6b
        L69:
            r2 = 0
            goto L6c
        L6b:
            r2 = 1
        L6c:
            r5.put(r1, r2)     // Catch: org.json.JSONException -> L82
            java.lang.String r5 = "live_client_monitor_log"
            r4.B0(r0, r5)     // Catch: org.json.JSONException -> L82
            long r0 = r4.h7     // Catch: org.json.JSONException -> L82
            r2 = 0
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 <= 0) goto L86
            r2 = 1
            long r0 = r0 + r2
            r4.h7 = r0     // Catch: org.json.JSONException -> L82
            goto L86
        L82:
            r5 = move-exception
            r5.printStackTrace()
        L86:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fj6.c.k1(com.ss.videoarch.liveplayer.log.LiveError):void");
    }

    public void m0(boolean z) {
        long currentTimeMillis;
        long j;
        int i;
        int i2;
        if (this.f != null && this.d != null) {
            if (this.e.q > this.qa) {
                currentTimeMillis = System.currentTimeMillis();
                j = this.e.q;
            } else {
                currentTimeMillis = System.currentTimeMillis();
                j = this.qa;
            }
            long j2 = currentTimeMillis - j;
            if (this.ua > 0) {
                if (this.ka > this.na) {
                    i2 = 3;
                } else {
                    i2 = 4;
                }
                this.la = i2;
            }
            try {
                JSONObject w = w();
                JSONObject put = w.put("event_key", "abr_session").put("current_resolution", this.da).put("current_bitrate", this.ka).put("previous_resolution", this.ma).put("previous_bitrate", this.na).put("stall_count", this.oa).put("stall_time", this.pa).put("startup_type", this.la).put("play_time", j2).put("switch_cost", this.ua).put("abr_switch_info", this.va).put("is_last", z);
                if (z) {
                    i = this.ha + 1;
                } else {
                    i = this.ha;
                }
                put.put("abr_switch_count", i);
                B0(w, "live_client_monitor_log");
                long j3 = this.h7;
                if (j3 > 0) {
                    this.h7 = j3 + 1;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            o0();
            O1();
            this.qa = System.currentTimeMillis();
        }
    }

    public void z1(String str) {
        if (str == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("sdk_version")) {
                this.D = jSONObject.getString("sdk_version");
            }
            if (jSONObject.has("platform")) {
                this.E = jSONObject.getString("platform");
            }
            if (jSONObject.has("os_version")) {
                this.F = jSONObject.getString("os_version");
            }
            if (jSONObject.has("model")) {
                this.G = jSONObject.getString("model");
            }
            if (jSONObject.has("start_time")) {
                this.H = jSONObject.getString("start_time");
            }
            if (jSONObject.has("is_hardware_encode")) {
                this.I = jSONObject.getInt("is_hardware_encode");
            }
            if (jSONObject.has("min_bitrate")) {
                this.J = jSONObject.getInt("min_bitrate");
            }
            if (jSONObject.has("max_bitrate")) {
                this.K = jSONObject.getInt("max_bitrate");
            }
            if (jSONObject.has("default_bitrate")) {
                this.L = jSONObject.getInt("default_bitrate");
            }
            if (jSONObject.has("hit_node_optimize")) {
                this.M = jSONObject.getInt("hit_node_optimize");
            }
            if (jSONObject.has("push_protocol")) {
                this.N = jSONObject.getString("push_protocol");
            }
            if (jSONObject.has("qId")) {
                this.O = jSONObject.getString("qId");
            }
            if (jSONObject.has("link_info")) {
                this.P = jSONObject.getString("link_info");
            }
            if (jSONObject.has("h_id")) {
                this.fc = jSONObject.getInt("h_id");
            }
            if (jSONObject.has("s_id")) {
                this.gc = jSONObject.getInt("s_id");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void G(JSONObject jSONObject) {
        if (h0() && jSONObject != null) {
            try {
                this.f.getRTMSessionLogInfo(this.vb);
                jSONObject.put("start_time", this.e.a).put("sdk_session_start", this.vb.j2).put("sdk_dns_end", this.vb.b).put("rtm_init_end", this.vb.k2).put("rtm_signal_offer_created", this.vb.l2).put("rtm_signal_dns_analysis_end", this.vb.m2).put("rtm_signal_transport_connected", this.vb.n2).put("rtm_signal_offer_sent", this.vb.p2).put("rtm_signal_answer_received", this.vb.q2).put("rtm_signal_answer_updated", this.vb.r2).put("rtc_start_end", this.vb.u2).put("rtm_data_ice_connect_start", this.vb.s2).put("rtm_data_ice_connected", this.vb.t2).put("rtm_data_first_video_packet", this.vb.m).put("rtm_data_first_audio_packet", this.vb.n).put("rtm_data_first_video_frame_end", this.vb.v2).put("rtm_data_first_audio_frame_end", this.vb.w2).put("rtm_data_first_video_frame_decode_start", this.vb.x2).put("rtm_data_first_audio_frame_decode_start", this.vb.y2).put("rtm_data_first_video_frame_decoded", this.vb.o).put("rtm_data_first_video_frame_rendered", this.vb.q).put("rtm_first_frame_time_info", this.vb.B2).put("sdk_session_stop", System.currentTimeMillis()).put("retry", this.V7).put("error_code", this.wb);
                if (!TextUtils.isEmpty(this.Vg)) {
                    jSONObject.put("server_expr_tag", this.Vg);
                }
                if (!TextUtils.isEmpty(this.Wg)) {
                    jSONObject.put("server_expr_id", this.Wg);
                }
                VideoLiveManager videoLiveManager = this.f;
                if (videoLiveManager != null) {
                    videoLiveManager.onRTMLog(5, "report rtm_session_stop rtm_first_frame_time_info: " + this.vb.B2);
                }
            } catch (JSONException e) {
                this.f.onRTMLog(6, "fixRtmSessionStopInfo error msg: " + e.toString());
            }
        }
    }

    private void t2(JSONObject jSONObject) {
        if (jSONObject.has("event_message")) {
            String optString = jSONObject.optString("event_message");
            com.ss.videoarch.liveplayer.log.a.c("LiveLoggerService", "eventMessage:" + optString);
            if (!TextUtils.isEmpty(optString) && jSONObject.has("phase_timestamp")) {
                if (TextUtils.equals("dns resolved", optString)) {
                    if (jSONObject.has("request_ip")) {
                        String optString2 = jSONObject.optString("request_ip");
                        if (!optString2.equals(this.Db)) {
                            this.t = optString2;
                            this.Fb = 0;
                        } else {
                            this.Fb = 1;
                        }
                    }
                    this.Gb = Long.parseLong(jSONObject.optString("phase_timestamp"));
                    com.ss.videoarch.liveplayer.log.a.c("LiveLoggerService", "mRtcDnsTimeStamp:" + this.Gb);
                    return;
                }
                if (!TextUtils.equals("tcp connected", optString) && !TextUtils.equals("quic connected", optString) && !TextUtils.equals("send request", optString)) {
                    if (TextUtils.equals("tls handshaked", optString)) {
                        this.Ib = Long.parseLong(jSONObject.optString("phase_timestamp"));
                        com.ss.videoarch.liveplayer.log.a.c("LiveLoggerService", "mRtcTlsHandshakedTimeStamp:" + this.Ib);
                        return;
                    }
                    if (TextUtils.equals("response received", optString) || TextUtils.equals("remote answer got", optString)) {
                        this.Jb = Long.parseLong(jSONObject.optString("phase_timestamp"));
                        com.ss.videoarch.liveplayer.log.a.c("LiveLoggerService", "mRtcTcpFirstPackageTimeStamp:" + this.Jb);
                        return;
                    }
                    return;
                }
                this.Hb = Long.parseLong(jSONObject.optString("phase_timestamp"));
                com.ss.videoarch.liveplayer.log.a.c("LiveLoggerService", "mRtcTcpConnectTimeStamp:" + this.Hb);
            }
        }
    }

    private JSONObject u(JSONArray jSONArray) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        long j;
        long j2;
        String str;
        String str2;
        JSONObject jSONObject3 = new JSONObject();
        int i = 0;
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        while (true) {
            try {
                jSONObject2 = jSONObject3;
                long j6 = j5;
                j = j4;
                j2 = j3;
                if (i < jSONArray.length()) {
                    str2 = "first_time_h2p_buffer";
                    try {
                        JSONObject jSONObject4 = jSONArray.getJSONObject(i);
                        int intValue = ((Integer) com.ss.videoarch.liveplayer.utils.d.d(jSONObject4, Integer.valueOf(this.nh), "exception_code")).intValue();
                        this.nh = intValue;
                        str = "exception_code";
                        if (intValue == 1) {
                            break;
                        }
                        long longValue = ((Long) com.ss.videoarch.liveplayer.utils.d.d(jSONObject4, 0L, "httpio_play_time")).longValue();
                        long longValue2 = ((Long) com.ss.videoarch.liveplayer.utils.d.d(jSONObject4, 0L, "p2pio_play_time")).longValue();
                        long longValue3 = ((Long) com.ss.videoarch.liveplayer.utils.d.d(jSONObject4, -1L, "group_id")).longValue();
                        long longValue4 = ((Long) com.ss.videoarch.liveplayer.utils.d.d(jSONObject4, -1L, "group_reason")).longValue();
                        int i2 = i;
                        long longValue5 = ((Long) com.ss.videoarch.liveplayer.utils.d.d(jSONObject4, -1L, "group_enter_reason")).longValue();
                        long longValue6 = ((Long) com.ss.videoarch.liveplayer.utils.d.d(jSONObject4, -1L, "p2p_onlines")).longValue();
                        long longValue7 = ((Long) com.ss.videoarch.liveplayer.utils.d.d(jSONObject4, 0L, "http_flow_size")).longValue();
                        long longValue8 = ((Long) com.ss.videoarch.liveplayer.utils.d.d(jSONObject4, 0L, "p2p_flow_size")).longValue();
                        long longValue9 = ((Long) com.ss.videoarch.liveplayer.utils.d.d(jSONObject4, 0L, "p2p_mobile_flow_size")).longValue();
                        long longValue10 = ((Long) com.ss.videoarch.liveplayer.utils.d.d(jSONObject4, 0L, "buffer_not_satify_p2p_times")).longValue();
                        long longValue11 = ((Long) com.ss.videoarch.liveplayer.utils.d.d(jSONObject4, 0L, "buffer_not_satify_p2p_value")).longValue();
                        long longValue12 = ((Long) com.ss.videoarch.liveplayer.utils.d.d(jSONObject4, 0L, str2)).longValue();
                        long j7 = longValue + longValue2;
                        long j8 = j2 + longValue;
                        long j9 = j + longValue2;
                        this.hh += longValue7;
                        this.ih += longValue8;
                        this.jh += longValue9;
                        this.kh += longValue10;
                        if (j7 > j6) {
                            this.dh = longValue3;
                            this.eh = longValue4;
                            this.fh = longValue5;
                            this.gh = longValue6;
                            this.lh = longValue11;
                            this.mh = longValue12;
                            j5 = j7;
                        } else {
                            j5 = j6;
                        }
                        i = i2 + 1;
                        jSONObject3 = jSONObject2;
                        j4 = j9;
                        j3 = j8;
                    } catch (JSONException e) {
                        e = e;
                        jSONObject = jSONObject2;
                        e.printStackTrace();
                        return jSONObject;
                    }
                } else {
                    str = "exception_code";
                    str2 = "first_time_h2p_buffer";
                    break;
                }
            } catch (JSONException e2) {
                e = e2;
                jSONObject = jSONObject3;
            }
        }
        this.bh = j2;
        this.ch = j;
        p();
        jSONObject = jSONObject2;
        try {
            jSONObject.put(str, this.nh);
            jSONObject.put("httpio_play_time", this.bh);
            jSONObject.put("p2pio_play_time", this.ch);
            jSONObject.put("group_id", this.dh);
            jSONObject.put("group_reason", this.eh);
            jSONObject.put("group_enter_reason", this.fh);
            jSONObject.put("p2p_onlines", this.gh);
            jSONObject.put("http_flow_size", this.hh);
            jSONObject.put("p2p_flow_size", this.ih);
            jSONObject.put("p2p_mobile_flow_size", this.jh);
            jSONObject.put("buffer_not_satify_p2p_times", this.kh);
            jSONObject.put("buffer_not_satify_p2p_value", this.lh);
            jSONObject.put(str2, this.mh);
            jSONObject.put("http_patch_dts_size", this.oh);
            jSONObject.put("http_substream_size", this.ph);
            jSONObject.put("session_id", this.L6);
        } catch (JSONException e3) {
            e = e3;
            e.printStackTrace();
            return jSONObject;
        }
        return jSONObject;
    }

    public void A1(JSONObject jSONObject) {
        long j;
        a aVar;
        if (jSONObject == null) {
            return;
        }
        try {
            if (this.xf == 1) {
                if (!this.zf.isEmpty()) {
                    if (!jSONObject.has("source") && this.yf != 1) {
                        com.ss.videoarch.liveplayer.log.a.c("LiveLoggerService", "sei_delay parse roll back, json has not source obj");
                    }
                    if (!this.zf.containsKey(jSONObject.optString("source", ""))) {
                        if (this.yf == 1) {
                            return;
                        } else {
                            com.ss.videoarch.liveplayer.log.a.c("LiveLoggerService", "sei_delay parse roll back, we never get source in array");
                        }
                    } else {
                        com.ss.videoarch.liveplayer.log.a.c("LiveLoggerService", "sei_delay parse successfully ");
                        this.yf = 1;
                    }
                } else {
                    com.ss.videoarch.liveplayer.log.a.c("LiveLoggerService", "sei_delay parse roll back, we never config source Map");
                }
            }
            if (jSONObject.has("ts")) {
                long j2 = jSONObject.getLong("ts");
                long j3 = 0;
                if (this.t8 == 1 && jSONObject.has("tt_ntp") && jSONObject.getInt("tt_ntp") == 1) {
                    if (!this.q8 && (aVar = this.k8) != null) {
                        aVar.b(103, 0L);
                        this.q8 = true;
                    }
                    j3 = this.u8;
                    this.m8 = true;
                } else {
                    if (this.q8 && !jSONObject.has("tt_ntp")) {
                        a aVar2 = this.k8;
                        if (aVar2 != null) {
                            aVar2.b.removeCallbacksAndMessages(null);
                        }
                        this.q8 = false;
                    }
                    this.m8 = false;
                }
                if (jSONObject.has("ntp_diff")) {
                    this.n8 = jSONObject.optInt("ntp_diff", 0);
                }
                if (jSONObject.has("stream_delay")) {
                    j = jSONObject.getLong("stream_delay");
                } else {
                    j = -1;
                }
                if (this.s8 == 1 && jSONObject.has("tt_ntp") && jSONObject.getInt("tt_ntp") == 1) {
                    VideoLiveManager videoLiveManager = this.f;
                    if (videoLiveManager != null) {
                        this.u8 = videoLiveManager.getNtpTimeDiff();
                        com.ss.videoarch.liveplayer.log.a.a("ntp", "ntp_time_diff:" + this.u8);
                    }
                    j3 = this.u8;
                    this.m8 = true;
                }
                this.e.g1 = (System.currentTimeMillis() - j2) + j3;
                this.e.h1 = j;
                com.ss.videoarch.liveplayer.log.a.c("LiveLoggerService", "sei_delay: " + this.e.g1 + ", push delay: " + this.e.h1);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b1 A[Catch: JSONException -> 0x0115, TRY_ENTER, TryCatch #0 {JSONException -> 0x0115, blocks: (B:14:0x0028, B:16:0x0031, B:21:0x003e, B:24:0x0051, B:27:0x005c, B:29:0x009c, B:33:0x00a8, B:36:0x00b1, B:38:0x00b9, B:39:0x00ca, B:43:0x00d2, B:45:0x00d6, B:46:0x0109, B:48:0x010f, B:52:0x0106, B:54:0x00c1, B:55:0x00c7), top: B:13:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x010f A[Catch: JSONException -> 0x0115, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0115, blocks: (B:14:0x0028, B:16:0x0031, B:21:0x003e, B:24:0x0051, B:27:0x005c, B:29:0x009c, B:33:0x00a8, B:36:0x00b1, B:38:0x00b9, B:39:0x00ca, B:43:0x00d2, B:45:0x00d6, B:46:0x0109, B:48:0x010f, B:52:0x0106, B:54:0x00c1, B:55:0x00c7), top: B:13:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0106 A[Catch: JSONException -> 0x0115, TryCatch #0 {JSONException -> 0x0115, blocks: (B:14:0x0028, B:16:0x0031, B:21:0x003e, B:24:0x0051, B:27:0x005c, B:29:0x009c, B:33:0x00a8, B:36:0x00b1, B:38:0x00b9, B:39:0x00ca, B:43:0x00d2, B:45:0x00d6, B:46:0x0109, B:48:0x010f, B:52:0x0106, B:54:0x00c1, B:55:0x00c7), top: B:13:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00c1 A[Catch: JSONException -> 0x0115, TryCatch #0 {JSONException -> 0x0115, blocks: (B:14:0x0028, B:16:0x0031, B:21:0x003e, B:24:0x0051, B:27:0x005c, B:29:0x009c, B:33:0x00a8, B:36:0x00b1, B:38:0x00b9, B:39:0x00ca, B:43:0x00d2, B:45:0x00d6, B:46:0x0109, B:48:0x010f, B:52:0x0106, B:54:0x00c1, B:55:0x00c7), top: B:13:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void P0(int r13) {
        /*
            Method dump skipped, instructions count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: fj6.c.P0(int):void");
    }

    public void r(int i) {
        if (this.a8) {
            if (this.mb == null) {
                this.mb = new LinkedBlockingQueue<>(32);
            }
            if (this.mb.contains(Integer.valueOf(i))) {
                return;
            }
            this.hb++;
            int i2 = this.fb;
            if (i2 >= i && Math.abs(i2 - i) > 32 && i < 200) {
                this.gb += (this.lb - this.kb) + 1;
                this.kb = 1;
                this.lb = -1;
                while (this.mb.poll() != null) {
                }
            }
            if (this.mb.remainingCapacity() == 0) {
                this.mb.poll();
            }
            this.mb.offer(Integer.valueOf(i));
            int i3 = this.kb;
            if (i3 == -1) {
                this.kb = i;
            } else if (i3 > i) {
                this.kb = i;
            }
            int i4 = this.lb;
            if (i4 == -1) {
                this.lb = i;
            } else if (i > i4) {
                this.lb = i;
            }
            if (Math.abs(this.fb - i) > 32 && this.fb != -1) {
                if (this.nb.equals("none")) {
                    this.nb = this.fb + ":" + i;
                } else {
                    this.nb += "," + this.fb + ":" + i;
                }
            }
        } else {
            this.hb++;
            this.gb++;
            int i5 = this.fb;
            if (i5 >= 0) {
                if (i <= i5) {
                    x1(4, i, i5);
                    if (i == 1) {
                        this.ib++;
                        this.jb++;
                    }
                } else {
                    this.ib++;
                    this.jb++;
                    if (i - i5 > 1 && !this.f.getIsRetrying()) {
                        x1(3, i, this.fb);
                        int i6 = this.gb;
                        int i7 = this.fb;
                        this.gb = i6 + ((i - i7) - 1);
                        this.ib += (i - i7) - 1;
                    }
                }
            }
        }
        this.fb = i;
    }

    private JSONObject A(d dVar) throws JSONException {
        JSONArray jSONArray;
        long j;
        JSONObject w = w();
        if (w != null) {
            JSONObject put = w.put("event_key", "session_first_frame").put("total_cost", dVar.q - dVar.a).put("start", this.jc.a).put("sdk_dns_analysis_end", dVar.b).put("prepare_block_end", dVar.c);
            long j2 = dVar.y;
            if (j2 <= 0) {
                j2 = dVar.d;
            }
            JSONObject put2 = put.put("tfo_fall_back_time", j2).put("pre_connect", this.F8).put("request_cdn_cached", dVar.p0).put("request_time_to_source", dVar.r0).put("request_time_for_cdn", dVar.t0).put("http_req_finish_time", dVar.m0).put("http_res_finish_time", dVar.n0).put("first_video_package_end", dVar.m).put("first_audio_package_end", dVar.n).put("first_video_frame_decode_end", dVar.o).put("first_audio_frame_decode_end", dVar.p).put("first_frame_from_player_core", dVar.s).put("first_frame_render_end", dVar.q).put("video_param_send_outlet_time", dVar.q1).put("first_video_frame_send_outlet_time", dVar.r1).put("set_surface_time", this.q9).put("set_surface_cost", this.p9).put("video_render_type", dVar.s1).put("video_device_open_start", dVar.u).put("video_device_open_end", dVar.v).put("audio_device_open_start", dVar.w).put("audio_device_open_end", dVar.x).put("video_device_wait_start", dVar.v1).put("video_device_wait_end", dVar.w1).put("find_stream_info_start", dVar.t1).put("find_stream_info_end", dVar.u1).put("video_first_pkt_pos", dVar.g0).put("video_first_pkt_pts", dVar.h0).put("audio_first_pkt_pos", dVar.i0).put("audio_first_pkt_pts", dVar.j0).put("video_buffer_time", dVar.Z0).put("audio_buffer_time", dVar.a1).put("download_speed", dVar.R0).put("first_sei_delay", dVar.g1).put("response_header_X-Server-IP", dVar.z1).put("response_header_Via", dVar.A1).put("prepare_end", dVar.t).put("drop_audio_pts_diff", dVar.k0).put("drop_audio_cost", dVar.l0).put("enable_tcp_fast_open", this.Ra).put("tfo_success", dVar.E2).put("abr_check_enhance", this.qb);
            if (this.Ta == null) {
                jSONArray = new JSONArray();
            } else {
                jSONArray = new JSONArray((Collection) this.Ta);
            }
            put2.put("optimize_backup_ips", jSONArray).put("suggest_format", this.y9).put("suggest_protocol", this.A9).put("suggest_access_code", this.F9).put("container_fps", this.w9).put("used_drm", this.ve).put("ipv6_probe_result", dVar.H2).put("http_open_start", dVar.g).put("trans_open_start", dVar.h).put("socket_create_end", dVar.j).put("3xx_happen_time", dVar.k).put("trans_strategy_params", this.Ne).put("trans_params_bandwidth", this.Oe).put("trans_params_bandwidth_decision", this.Pe).put("is_free_flow", this.Q).put("enable_fast_first_frame", this.N9).put("preplay_enter_room_timestamp", this.rg).put("event_key_index", Fh.incrementAndGet()).put("UseRedirectedIp", this.G8).put("UsePreconnectIp", this.I8);
            long j3 = this.rg;
            if (j3 != -1) {
                long j4 = dVar.o;
                if (j3 > j4) {
                    this.sg = j3 - j4;
                }
            }
            if (j3 != -1) {
                com.ss.videoarch.liveplayer.log.a.c("LiveLoggerService", "preplay enter room at: " + this.rg + ", wait cost: " + this.sg);
            }
            if (this.ve == 1) {
                w.put("drm_get_secret_key_end", this.xe);
            }
            if (!g0() && !i0()) {
                w.put("player_dns_analysis_end", dVar.d);
                w.put("player_open_input_start", dVar.e);
                if ("kcp".equals(this.z9)) {
                    j = dVar.d;
                } else {
                    j = dVar.f;
                }
                w.put("tcp_connect_end", j);
                w.put("tcp_first_package_end", dVar.l);
            } else {
                w.put("player_dns_analysis_end", this.Gb);
                w.put("rtc_use_sdk_dns", this.Fb);
                w.put("tcp_connect_end", this.Hb);
                w.put("rtc_tls_handshake_end", this.Ib);
                w.put("tcp_first_package_end", this.Jb);
                w.put("rtc_inited_end", dVar.k2);
                w.put("rtc_offer_send_end", dVar.p2);
                w.put("rtc_answer_recv_end", dVar.q2);
                w.put("rtc_ice_connected_time", dVar.t2);
                w.put("rtc_start_end", dVar.u2);
                w.put("rtc_preload_result", X());
                w.put("first_audio_frame_decode_start", dVar.y2);
                w.put("first_video_frame_decode_start", dVar.x2);
                w.put("first_audio_frame_end", dVar.w2);
                w.put("first_video_frame_end", dVar.v2);
                if (i0()) {
                    w.put("player_open_input_start", dVar.e);
                }
            }
            int i = this.E6;
            if (i != -1) {
                w.put("audio_timescale_enable", i);
            }
            if (this.ja) {
                w.put("abr_startup_bitrate", dVar.Y0);
                w.put("abr_request_url", dVar.f3);
            }
            j(w);
            return w;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0381 A[Catch: JSONException -> 0x03a9, TryCatch #0 {JSONException -> 0x03a9, blocks: (B:8:0x002e, B:11:0x0044, B:12:0x0078, B:14:0x007f, B:16:0x0089, B:18:0x0091, B:19:0x0095, B:20:0x0099, B:22:0x00a0, B:24:0x00af, B:25:0x00b7, B:27:0x00bd, B:28:0x00ca, B:30:0x00d0, B:31:0x00da, B:33:0x00e0, B:34:0x00ea, B:37:0x00f2, B:39:0x011f, B:41:0x0129, B:45:0x0379, B:47:0x0381, B:49:0x038b, B:50:0x0397, B:52:0x039f, B:58:0x0135, B:60:0x013b, B:62:0x0141, B:65:0x014b, B:67:0x0155, B:68:0x0164, B:70:0x016a, B:71:0x0179, B:74:0x0183, B:76:0x018f, B:77:0x01a3, B:79:0x01a9, B:80:0x01bd, B:82:0x01c3, B:83:0x01e3, B:85:0x01eb, B:86:0x0208, B:92:0x0228, B:94:0x0231, B:95:0x0238, B:96:0x024b, B:108:0x027c, B:121:0x0305, B:124:0x0310, B:127:0x031d, B:130:0x0327, B:132:0x0336, B:133:0x0350, B:137:0x0293, B:140:0x029e, B:143:0x02aa, B:145:0x02bb, B:146:0x02d5, B:160:0x00f8, B:162:0x00fe, B:164:0x0109, B:165:0x0103, B:166:0x00c6, B:167:0x004d, B:169:0x0053, B:171:0x0062, B:172:0x006a, B:174:0x0070), top: B:7:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x039f A[Catch: JSONException -> 0x03a9, TRY_LEAVE, TryCatch #0 {JSONException -> 0x03a9, blocks: (B:8:0x002e, B:11:0x0044, B:12:0x0078, B:14:0x007f, B:16:0x0089, B:18:0x0091, B:19:0x0095, B:20:0x0099, B:22:0x00a0, B:24:0x00af, B:25:0x00b7, B:27:0x00bd, B:28:0x00ca, B:30:0x00d0, B:31:0x00da, B:33:0x00e0, B:34:0x00ea, B:37:0x00f2, B:39:0x011f, B:41:0x0129, B:45:0x0379, B:47:0x0381, B:49:0x038b, B:50:0x0397, B:52:0x039f, B:58:0x0135, B:60:0x013b, B:62:0x0141, B:65:0x014b, B:67:0x0155, B:68:0x0164, B:70:0x016a, B:71:0x0179, B:74:0x0183, B:76:0x018f, B:77:0x01a3, B:79:0x01a9, B:80:0x01bd, B:82:0x01c3, B:83:0x01e3, B:85:0x01eb, B:86:0x0208, B:92:0x0228, B:94:0x0231, B:95:0x0238, B:96:0x024b, B:108:0x027c, B:121:0x0305, B:124:0x0310, B:127:0x031d, B:130:0x0327, B:132:0x0336, B:133:0x0350, B:137:0x0293, B:140:0x029e, B:143:0x02aa, B:145:0x02bb, B:146:0x02d5, B:160:0x00f8, B:162:0x00fe, B:164:0x0109, B:165:0x0103, B:166:0x00c6, B:167:0x004d, B:169:0x0053, B:171:0x0062, B:172:0x006a, B:174:0x0070), top: B:7:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0395  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void B1(java.lang.String r29) {
        /*
            Method dump skipped, instructions count: 942
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: fj6.c.B1(java.lang.String):void");
    }

    public void N1(boolean z) {
        this.r = "none";
        this.s = "none";
        this.t = "none";
        this.u = false;
        this.x = 0L;
        this.D = "none";
        this.E = "none";
        this.F = "none";
        this.G = "none";
        this.H = "none";
        this.I = -1;
        this.J = -1;
        this.K = -1;
        this.L = -1;
        this.M = -1;
        this.N = "none";
        this.O = "none";
        this.S = "none";
        this.W = false;
        this.T = -1;
        this.V = -1;
        this.X = false;
        this.Y = false;
        this.xa = false;
        this.F8 = -1;
        this.P0 = 1;
        this.b1 = false;
        this.k1 = 0;
        this.x1 = -1;
        this.v1 = -1;
        this.y1 = -1;
        this.H1 = -1;
        this.L1 = -1;
        this.P1 = 0;
        this.T1 = 0;
        this.V1 = 0;
        this.b2 = 0;
        this.v2 = 0;
        this.x2 = 0;
        this.y2 = 0;
        this.H2 = 0;
        this.M2 = -1.0f;
        this.P2 = -1;
        this.T2 = -1.0f;
        this.H4 = 0;
        this.V4 = "none";
        this.w6 = 0L;
        this.J6 = -1;
        this.y6 = 0;
        this.x6 = 2000L;
        this.z6 = -1;
        this.A6 = 0;
        this.B6 = 0;
        this.C6 = 0;
        this.D6 = 0;
        this.F6 = 0;
        this.d9 = -1;
        this.c9 = 0;
        this.e9 = 0;
        this.f9 = 1;
        this.g9 = 0;
        this.b7 = false;
        this.d7 = 0L;
        this.lg = 0L;
        this.og = 0L;
        this.i7 = 0;
        this.k7 = 0L;
        this.m7 = -1L;
        this.n7 = 0L;
        this.o7 = 0L;
        this.C7 = 0L;
        this.B7 = 0L;
        this.E7 = 0L;
        this.D7 = 0L;
        this.e8 = 0L;
        this.f8 = 0L;
        this.c8 = false;
        this.F7 = false;
        this.G7 = 0;
        this.H7 = 0;
        this.K7 = 0;
        this.L7 = 0;
        this.I7 = 0;
        this.J7 = 0;
        this.l7 = 0L;
        this.M7 = 0L;
        this.N7 = 0L;
        this.O7 = 0L;
        this.P7 = 0L;
        this.Q7 = 0L;
        this.R7 = 0L;
        this.S7 = 0L;
        this.T7 = 0;
        this.i = 0L;
        this.U7 = 0;
        this.V7 = 0;
        this.C9 = 0;
        this.D9 = "none";
        this.X7 = -1;
        this.m8 = false;
        this.n8 = 0;
        this.u8 = 0L;
        this.s8 = 0;
        this.t8 = 0;
        this.D8 = 0;
        this.E8 = 0;
        this.j9 = -1;
        this.t9 = false;
        this.s9 = 0;
        this.v9 = false;
        this.w9 = -1.0f;
        this.x9 = 0L;
        this.hc = 0L;
        this.J8 = null;
        this.K8 = null;
        this.L8 = null;
        this.S8 = null;
        this.T8 = null;
        this.R8 = null;
        this.M8 = null;
        this.N8 = null;
        this.O8 = -1L;
        this.H5 = "none";
        this.P8 = "none";
        this.Q8 = "none";
        this.W8 = "none";
        this.V8 = "none";
        this.U8 = null;
        d dVar = this.e;
        if (dVar != null) {
            dVar.a();
        }
        this.H0 = "none";
        this.Z = "none";
        this.o9 = 1;
        this.L0 = 0;
        this.K6 = "none";
        this.L6 = "none";
        this.N6 = "none";
        this.Q9 = "none";
        this.R9 = "none";
        this.S9 = "none";
        this.Ue = "none";
        this.Q6 = "none";
        this.R6 = "";
        this.S6 = 0;
        this.T6 = 0;
        this.U6 = 0L;
        this.V6 = 0L;
        this.W6 = 2L;
        this.X6 = 3000L;
        this.N9 = 0;
        this.w8 = 0;
        this.v8 = 0;
        this.x8 = 0;
        this.z8 = -1;
        this.za = 0L;
        this.ya = 0L;
        this.Ca = 0L;
        this.Qf = 0L;
        this.Pf = 0L;
        this.Sf = 0L;
        this.Tf = 0L;
        this.Uf = 0L;
        this.Vf = 0L;
        this.Wf = 0L;
        this.Xf = 0L;
        this.T9 = false;
        this.V9 = false;
        this.U9 = "rad";
        this.W9 = "origin";
        this.da = "origin";
        this.ea = "none";
        this.ga = -1;
        this.fa = -1L;
        this.ha = 0;
        this.ia = "none";
        this.va = "none";
        this.ra = -1L;
        this.sa = -1L;
        this.ta = -1L;
        this.ua = -1L;
        this.wa = 4;
        this.ja = false;
        this.ka = -1;
        this.Ja = -1;
        this.La = -1;
        this.Ka = -1;
        this.Ma = -1;
        this.Na = -1;
        this.Oa = -1;
        this.Pa = -1;
        this.Qa = -1;
        this.Fa = 0;
        this.Ga = 0L;
        this.Ha = 0L;
        this.Ia = -1L;
        this.Ra = 0;
        this.Sa = 0;
        this.De = 0;
        this.Ee = 0;
        this.Fe = 0;
        this.He = 0;
        this.Ge = 0;
        this.Ie = 0;
        this.Je = 0L;
        this.Me = 0;
        this.Ne = "none";
        this.Oe = 0;
        this.Pe = 0;
        this.Qe = 0;
        this.Re = 0;
        this.G6 = 0;
        this.H6 = -1;
        this.I6 = -1.0f;
        this.Ke = 0;
        this.Ta = null;
        this.qb = 0;
        this.Hb = 0L;
        this.Jb = 0L;
        this.Ib = 0L;
        this.Nb = "none";
        this.Ob = "none";
        this.Zb = 0;
        this.Wb = "none";
        this.Xb = null;
        this.Yb = "none";
        this.dc = 0;
        this.fc = -1;
        this.gc = -1;
        this.ic = 1;
        this.oc = 0;
        this.Ac = 0L;
        this.Bc = 0L;
        this.Cc = 0L;
        this.Dc = 0L;
        this.Ec = 0L;
        this.Nc = 0L;
        this.Oc = 0L;
        this.Pc = 0L;
        this.ie = 0;
        this.je = 0;
        this.ke = 0L;
        this.le = 0L;
        this.f1042me = 0L;
        this.ne = 0L;
        this.re = "";
        this.qe = "";
        this.y8 = 0;
        this.Od = 0;
        this.Pd = 0;
        this.Qd = 0;
        this.Rd = 0;
        this.Sd = "none";
        this.Td = 0L;
        this.Vd = "none";
        this.Wd = 0;
        this.Xd = 0L;
        this.Yd = 0;
        this.A8 = 0;
        this.ae = 0;
        this.be = 0;
        this.Zd = 0;
        this.ce = "";
        this.de = "";
        this.ee = 0L;
        this.fe = 0;
        this.te = 0;
        this.ue = 0;
        this.ve = -1;
        this.we = null;
        this.xe = 0L;
        this.p7 = 0L;
        this.q7 = 0L;
        this.r7 = 0L;
        this.s7 = 0L;
        this.t7 = 0L;
        this.u7 = 0L;
        this.w7 = 0;
        this.v7 = 0;
        this.y7 = 0;
        this.x7 = 0;
        this.z7 = 0;
        this.A7 = 0;
        this.bd = 0L;
        this.cd = 0L;
        this.dd = 0L;
        this.ed = 0L;
        this.fd = 0L;
        this.gd = 0L;
        this.hd = 0L;
        this.id = 0L;
        this.Kd = 0L;
        this.Ld = 0L;
        this.Md = 0L;
        this.Rc = 0L;
        this.Tc = 0L;
        this.Qc = 0L;
        this.Sc = 0L;
        this.od = 0L;
        this.qd = 0L;
        this.nd = 0L;
        this.pd = 0L;
        this.rd = -1;
        this.sd = -1;
        this.td = -1;
        this.ud = 0L;
        this.vd = 0L;
        this.wd = 0L;
        this.xd = 0L;
        this.yd = 0L;
        this.zd = 0L;
        this.Ad = 0L;
        this.Bd = 0L;
        this.Cd = 0L;
        this.Dd = 0L;
        this.Ed = 0L;
        this.Fd = 0L;
        this.Gd = 0L;
        this.Hd = 0L;
        this.Id = 0L;
        this.Jd = 0L;
        this.jd = 0L;
        this.ld = 0L;
        this.kd = 0L;
        this.md = 0L;
        this.Yc = 0L;
        this.Zc = 0L;
        this.ad = 0L;
        this.Be = "none";
        this.Se = 0;
        this.Te = 0;
        this.Xe = null;
        this.Ye = "none";
        this.Ze = "none";
        this.af = false;
        this.L9 = -1;
        this.bf = 0;
        this.df = 0L;
        this.ef = 0L;
        this.hf = 0;
        this.f1040if = 0;
        this.jf = 0;
        this.pf = null;
        this.qf = null;
        this.rf = null;
        this.sf = null;
        this.tf = null;
        this.uf = null;
        this.vf = null;
        this.wf = null;
        this.xf = 0;
        this.zf = null;
        this.yf = -1;
        this.Bf = -1L;
        this.gb = 0;
        this.hb = 0;
        this.ib = 0;
        this.jb = 0;
        this.Cf = 0;
        this.Df = -1;
        this.Ef = "none";
        this.Hf = 0;
        this.Gf = 0;
        this.Ff = "none";
        this.Of = 0;
        this.Nf = 0;
        this.Yf = 0;
        this.eg = 0;
        this.fg = 0;
        this.gg = 0;
        this.hg = 0;
        this.ig = 0;
        if (z) {
            this.Kb = 0;
            this.zb = 0;
        }
        this.qg = -1;
        this.rg = -1L;
        this.sg = -1L;
        this.u9 = false;
        this.jg = -1.0f;
        this.Kg = "";
        this.Ng = -1;
        this.Og = "";
        this.Pg = "";
        this.kg = 0;
        this.a = -1;
        this.kb = -1;
        this.lb = -1;
        LinkedBlockingQueue<Integer> linkedBlockingQueue = this.mb;
        if (linkedBlockingQueue != null) {
            linkedBlockingQueue.clear();
            this.mb = null;
        }
        this.ob = new ArrayList();
        this.pb = new ArrayList();
        this.nb = "none";
        this.Ug = -99;
        this.Fc = 0L;
        this.Gc = 0L;
        this.Hc = 0L;
        this.Ic = 0L;
        this.rb = new ArrayList();
        this.sb = new ArrayList();
        this.Jc = 0L;
        this.Kc = 0L;
        this.Lc = 0L;
        this.Mc = 0L;
        this.tb = new ArrayList();
        this.ub = new ArrayList();
        this.Ah = 0;
        this.Bh = new ArrayList();
    }

    public void Z0(String str) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        long j;
        long j2;
        if (str != null) {
            double d = 0.0d;
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("streamid")) {
                    i4 = jSONObject.optInt("streamid");
                } else {
                    i4 = -1;
                }
                try {
                    if (jSONObject.has("start")) {
                        i3 = jSONObject.optInt("start");
                    } else {
                        i3 = -1;
                    }
                    try {
                        if (jSONObject.has("end")) {
                            i2 = jSONObject.optInt("end");
                        } else {
                            i2 = -1;
                        }
                        try {
                            if (jSONObject.has("drop_per")) {
                                d = jSONObject.optDouble("drop_per", 0.0d);
                            }
                            if (jSONObject.has("type")) {
                                i = jSONObject.optInt("type", 0);
                            } else {
                                i = -1;
                            }
                            try {
                                if (jSONObject.has("c_drop_use_max_time")) {
                                    this.ad = jSONObject.optInt("c_drop_use_max_time", 0);
                                }
                            } catch (JSONException e) {
                                e = e;
                                e.printStackTrace();
                                if (i4 == -1) {
                                    return;
                                } else {
                                    return;
                                }
                            }
                        } catch (JSONException e2) {
                            e = e2;
                            i = -1;
                        }
                    } catch (JSONException e3) {
                        e = e3;
                        i = -1;
                        i2 = -1;
                    }
                } catch (JSONException e4) {
                    e = e4;
                    i = -1;
                    i2 = -1;
                    i3 = -1;
                }
            } catch (JSONException e5) {
                e = e5;
                i = -1;
                i2 = -1;
                i3 = -1;
                i4 = -1;
            }
            if (i4 == -1 && i3 != -1 && i2 != -1 && (i5 = i2 - i3) >= 0) {
                if (this.b7) {
                    j = System.currentTimeMillis() - this.d7;
                } else {
                    j = 0;
                }
                if (i == 0) {
                    j2 = j;
                    this.Zc++;
                } else {
                    j2 = j;
                    if (i == 1) {
                        this.Yc++;
                    }
                }
                if (i4 == 9) {
                    double d2 = d;
                    this.Wc++;
                    this.Sc++;
                    long j3 = i5;
                    this.Xc += j3;
                    this.Tc += j3;
                    if (this.w) {
                        this.ld++;
                        this.pd++;
                        this.md += j3;
                        this.qd += j3;
                    }
                    if (!this.b7) {
                        this.ud += j3;
                        this.vd++;
                        if (this.Y8.equals("none")) {
                            this.Y8 = "-1:" + i5;
                            return;
                        }
                        this.Y8 += ",-1:" + i5;
                        return;
                    }
                    int i6 = this.rd;
                    if (i6 != -1 && j2 < i6) {
                        this.yd += j3;
                        this.zd++;
                    }
                    int i7 = this.sd;
                    if (i7 != -1 && j2 < i7) {
                        this.Ad += j3;
                        this.Bd++;
                    }
                    int i8 = this.td;
                    if (i8 != -1 && j2 < i8) {
                        this.Cd += j3;
                        this.Dd++;
                    }
                    System.currentTimeMillis();
                    long j4 = this.e.q;
                    if (this.Y8.equals("none")) {
                        this.Y8 = i + ":" + (i3 - this.e.h0) + ":" + (i2 - this.e.h0) + ":" + d2;
                        return;
                    }
                    this.Y8 += "," + i + ":" + (i3 - this.e.h0) + ":" + (i2 - this.e.h0) + ":" + d2;
                    return;
                }
                if (i4 == 8) {
                    this.Uc++;
                    this.Qc++;
                    int i9 = i2;
                    long j5 = i5;
                    this.Vc += j5;
                    this.Rc += j5;
                    if (this.w) {
                        this.jd++;
                        this.nd++;
                        this.kd += j5;
                        this.od += j5;
                    }
                    if (!this.b7) {
                        this.wd += j5;
                        this.xd++;
                        if (this.X8.equals("none")) {
                            this.X8 = "-1:" + i5;
                            return;
                        }
                        this.X8 += ",-1:" + i5;
                        return;
                    }
                    int i10 = this.rd;
                    if (i10 != -1 && j2 < i10) {
                        this.Ed += j5;
                        this.Fd++;
                    }
                    int i11 = this.sd;
                    if (i11 != -1 && j2 < i11) {
                        this.Gd += j5;
                        this.Hd++;
                    }
                    int i12 = this.td;
                    if (i12 != -1 && j2 < i12) {
                        this.Id += j5;
                        this.Jd++;
                    }
                    System.currentTimeMillis();
                    long j6 = this.e.q;
                    if (this.X8.equals("none")) {
                        this.X8 = i + ":" + (i3 - this.e.j0) + ":" + (i9 - this.e.j0) + ":" + d;
                        return;
                    }
                    this.X8 += i + ":" + (i3 - this.e.j0) + ":" + (i9 - this.e.j0) + ":" + d;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x026b A[Catch: JSONException -> 0x02dc, TRY_ENTER, TryCatch #0 {JSONException -> 0x02dc, blocks: (B:12:0x001d, B:14:0x0029, B:15:0x002f, B:17:0x004c, B:19:0x0050, B:20:0x01c4, B:22:0x01dd, B:23:0x01e7, B:25:0x01f4, B:26:0x01ff, B:29:0x0206, B:31:0x020a, B:32:0x0212, B:36:0x0218, B:38:0x021e, B:43:0x022b, B:46:0x0238, B:48:0x0256, B:52:0x0262, B:55:0x026b, B:57:0x0273, B:59:0x027b, B:60:0x0281, B:64:0x0284, B:66:0x028c, B:68:0x0290, B:70:0x0296, B:71:0x02ac, B:74:0x02b5, B:77:0x02c8, B:79:0x02d6, B:85:0x029a, B:87:0x02a0, B:89:0x01fa), top: B:11:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x027b A[Catch: JSONException -> 0x02dc, TryCatch #0 {JSONException -> 0x02dc, blocks: (B:12:0x001d, B:14:0x0029, B:15:0x002f, B:17:0x004c, B:19:0x0050, B:20:0x01c4, B:22:0x01dd, B:23:0x01e7, B:25:0x01f4, B:26:0x01ff, B:29:0x0206, B:31:0x020a, B:32:0x0212, B:36:0x0218, B:38:0x021e, B:43:0x022b, B:46:0x0238, B:48:0x0256, B:52:0x0262, B:55:0x026b, B:57:0x0273, B:59:0x027b, B:60:0x0281, B:64:0x0284, B:66:0x028c, B:68:0x0290, B:70:0x0296, B:71:0x02ac, B:74:0x02b5, B:77:0x02c8, B:79:0x02d6, B:85:0x029a, B:87:0x02a0, B:89:0x01fa), top: B:11:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02d6 A[Catch: JSONException -> 0x02dc, TRY_LEAVE, TryCatch #0 {JSONException -> 0x02dc, blocks: (B:12:0x001d, B:14:0x0029, B:15:0x002f, B:17:0x004c, B:19:0x0050, B:20:0x01c4, B:22:0x01dd, B:23:0x01e7, B:25:0x01f4, B:26:0x01ff, B:29:0x0206, B:31:0x020a, B:32:0x0212, B:36:0x0218, B:38:0x021e, B:43:0x022b, B:46:0x0238, B:48:0x0256, B:52:0x0262, B:55:0x026b, B:57:0x0273, B:59:0x027b, B:60:0x0281, B:64:0x0284, B:66:0x028c, B:68:0x0290, B:70:0x0296, B:71:0x02ac, B:74:0x02b5, B:77:0x02c8, B:79:0x02d6, B:85:0x029a, B:87:0x02a0, B:89:0x01fa), top: B:11:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m1(int r12) {
        /*
            Method dump skipped, instructions count: 737
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: fj6.c.m1(int):void");
    }

    public void r1(int i) {
        if (this.i7 == -100015) {
            this.i7 = 0;
        }
        if (!this.F7 || g0()) {
            return;
        }
        this.F7 = false;
        this.f.getLogInfo(this.e, 6);
        JSONObject w = w();
        if (this.M8 == null) {
            this.M8 = new ArrayList<>();
        }
        if (this.N8 == null) {
            this.N8 = new ArrayList<>();
        }
        this.M8.add(Long.valueOf(this.O8));
        this.M8.add(Long.valueOf(-(System.currentTimeMillis() - this.e.a)));
        this.N8.add(Integer.valueOf(this.Qg));
        if (this.N7 == 0) {
            this.N7 = System.currentTimeMillis();
        }
        if (this.ic == 1 && this.wc == 0) {
            this.wc = System.currentTimeMillis();
        }
        if (w != null && this.k7 != 0) {
            try {
                if (this.l7 != 0) {
                    this.G7++;
                    this.H7 = (int) (this.H7 + (System.currentTimeMillis() - this.l7));
                    if (this.w) {
                        this.v7++;
                        this.w7 = (int) (this.w7 + (System.currentTimeMillis() - this.l7));
                    }
                }
                this.n7++;
                this.o7 += System.currentTimeMillis() - this.k7;
                this.ze += System.currentTimeMillis() - this.k7;
                if (this.n7 >= this.W6) {
                    if (this.d7 != 0) {
                        this.R6 += ",[play_time:" + (System.currentTimeMillis() - this.d7) + ", behavior:-3]";
                    } else {
                        this.R6 += ",[no_first_frame, behavior:-3]";
                    }
                    VideoLiveManager videoLiveManager = this.f;
                    u uVar = videoLiveManager.mObserver;
                    if (uVar != null) {
                        uVar.G(videoLiveManager, -2, "to_much_stall");
                    } else {
                        ILiveListener iLiveListener = videoLiveManager.mListener;
                        if (iLiveListener != null) {
                            iLiveListener.onNetworkQualityChanged(-2, "to_much_stall");
                        }
                    }
                    this.W6 += VideoLiveManager.mNetworkBehaviorStallCountThreshlod;
                }
                if (this.o7 >= this.X6) {
                    if (this.d7 != 0) {
                        this.R6 += ",[play_time:" + (System.currentTimeMillis() - this.d7) + ", behavior:-3]";
                    } else {
                        this.R6 += ",[no_first_frame, behavior:-3]";
                    }
                    VideoLiveManager videoLiveManager2 = this.f;
                    u uVar2 = videoLiveManager2.mObserver;
                    if (uVar2 != null) {
                        uVar2.G(videoLiveManager2, -2, "to_much_stall");
                    } else {
                        ILiveListener iLiveListener2 = videoLiveManager2.mListener;
                        if (iLiveListener2 != null) {
                            iLiveListener2.onNetworkQualityChanged(-2, "to_much_stall");
                        }
                    }
                    this.X6 += VideoLiveManager.mNetworkBehaviorStallTimeThreshlod;
                }
                if (this.w) {
                    this.q7++;
                    this.p7 += System.currentTimeMillis() - this.k7;
                }
                if (this.ic == 1) {
                    this.pc++;
                    this.qc += System.currentTimeMillis() - this.k7;
                }
                this.oa++;
                this.pa += System.currentTimeMillis() - this.k7;
                if (this.Cg.get()) {
                    this.Ag += System.currentTimeMillis() - Math.max(this.k7, this.Bg);
                }
                w.put("event_key", "stall").put("stall_start", this.k7).put("stall_end", System.currentTimeMillis()).put("video_buffer_time_stall_start", this.e.X1).put("audio_buffer_time_stall_start", this.e.Y1).put("video_buffer_time_stall_end", this.e.Z1).put("audio_buffer_time_stall_end", this.e.a2).put("last_res", this.ea).put("stall_start_sub_scene", this.Ig).put("stall_start_ver", this.Jg).put("reason", this.m7).put("recover_reason", i);
                B0(w, "live_client_monitor_log");
                long j = this.h7;
                if (j > 0) {
                    this.h7 = j + 1;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("PLAY-StallTime", w.optLong("stall_end") - this.k7).put("event_key", "stall");
                jSONObject.put("PLAY-SessionID", this.N6);
                VideoLiveManager videoLiveManager3 = this.f;
                if (videoLiveManager3 != null && videoLiveManager3.mEnableOpenStrategyEngine == 1) {
                    LiveStrategyManager.inst().setEventInfo(62, jSONObject);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void E1(int i, int i2) {
        this.D8 = i;
        this.E8 = i2;
    }

    public void U1(String str, boolean z) {
        this.t = str;
        this.u = z;
    }

    public void b2(String str, String str2) {
        this.y9 = str;
        this.P6 = str2;
    }

    public void h2(int i, String str) {
        this.G8 = i;
        this.H8 = str;
    }

    private void I1(JSONObject jSONObject, JSONObject jSONObject2) {
        int optInt = jSONObject.optInt("result", 0);
        d dVar = this.jc;
        if (dVar != null) {
            dVar.a = System.currentTimeMillis();
        }
        L1(jSONObject2, optInt, -200100);
    }

    private void Z1(JSONObject jSONObject, String str) {
        if (jSONObject != null && str != null) {
            try {
                a2(jSONObject, new JSONObject(str));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void j1(boolean z, boolean z2) {
        this.e.b = System.currentTimeMillis();
        d dVar = this.jc;
        if (dVar != null) {
            dVar.b = System.currentTimeMillis();
        }
        this.vb.b = System.currentTimeMillis();
        this.W = z2;
        this.Y = z;
    }

    private void B0(JSONObject jSONObject, String str) {
        u uVar;
        try {
            jSONObject = (JSONObject) performVideoLiveManagerMethod("handleMonitorLog", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        k(jSONObject);
        if (B(jSONObject)) {
            b bVar = this.g8;
            if (bVar != null) {
                bVar.i(jSONObject, str);
                return;
            }
            return;
        }
        VideoLiveManager videoLiveManager = this.f;
        if (videoLiveManager != null && (uVar = videoLiveManager.mObserver) != null) {
            uVar.c(videoLiveManager, jSONObject, str);
            return;
        }
        ILiveListener iLiveListener = this.d;
        if (iLiveListener != null) {
            iLiveListener.onMonitorLog(jSONObject, str);
        }
    }

    private void a2(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject2 != null && jSONObject != null) {
            try {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject.put(next, jSONObject2.get(next));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void J0(int i, String str) {
        JSONObject w = w();
        if (w != null) {
            try {
                w.put("event_key", "p2p_error").put("error_msg", str).put("code", i);
                B0(w, "live_client_monitor_log");
                long j = this.h7;
                if (j > 0) {
                    this.h7 = j + 1;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public long R(int i, long j) {
        VideoLiveManager videoLiveManager;
        if (i != 0) {
            if (i != 100) {
                if (i != 101) {
                    return j;
                }
                return this.e.q;
            }
            return this.e.g1;
        }
        int i2 = this.K;
        if (i2 == -1 && (videoLiveManager = this.f) != null) {
            return videoLiveManager.getIntOption(i, j);
        }
        return i2;
    }

    public void T0(long j, boolean z) {
        String str;
        JSONObject w = w();
        if (w != null) {
            try {
                JSONObject put = w.put("event_key", "pts_back");
                if (z) {
                    str = "video";
                } else {
                    str = "audio";
                }
                put.put("type", str).put("pts_back_diff", j);
                B0(w, "live_client_monitor_log");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void U0(String str, String str2) {
        if (this.f == null) {
            return;
        }
        try {
            JSONObject w = w();
            if (w == null) {
                return;
            }
            w.put("event_key", "pull_restart_recmd").put("cmd", str).put("mode", str2);
            this.Sg = str;
            this.Tg = str2;
            B0(w, "live_client_monitor_log");
            long j = this.h7;
            if (j > 0) {
                this.h7 = j + 1;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void K0(int i, String str) {
        JSONObject w = w();
        if (w != null) {
            try {
                if (str.equals("cdn_to_p2p")) {
                    this.x8 = 1;
                }
                w.put("event_key", "p2p_switch").put("switch_info", str).put("p2p_vendor", "none").put("reason", i);
                B0(w, "live_client_monitor_log");
                long j = this.h7;
                if (j > 0) {
                    this.h7 = j + 1;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public long S(String str, long j) {
        str.hashCode();
        switch (str) {
            case "PLAY-FirstFrame":
                return this.Td;
            case "PLAY-FirstFrameDownloadSpeed":
                return this.e.R0;
            case "PLAY-StartTs":
                return this.e.a;
            default:
                return j;
        }
    }

    public void W0(int i, String str) {
        if (this.f == null) {
            return;
        }
        try {
            JSONObject w = w();
            if (w == null) {
                return;
            }
            w.put("event_key", "pull_restart").put("cmd", this.Sg).put("mode", this.Tg).put("code", i).put("reason", str);
            B0(w, "live_client_monitor_log");
            long j = this.h7;
            if (j > 0) {
                this.h7 = j + 1;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void q0(long j, long j2) {
        JSONObject w = w();
        if (w != null) {
            try {
                w.put("event_key", "timestamp_rollback").put("packet_type", "audio").put("timestamp_type", "dts").put("latest_ts", j2).put("previous_ts", j);
                B0(w, "live_client_monitor_log");
                long j3 = this.h7;
                if (j3 > 0) {
                    this.h7 = j3 + 1;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void s1(int i, boolean z) {
        this.i7 = -100015;
        if (!z || g0()) {
            return;
        }
        this.f.getLogInfo(this.e, 5);
        long currentTimeMillis = System.currentTimeMillis();
        this.k7 = currentTimeMillis;
        if (this.M7 == 0) {
            this.M7 = currentTimeMillis;
        }
        if (this.ic == 1) {
            if (this.vc == 0) {
                this.vc = currentTimeMillis;
            }
            this.yc = this.i7;
        }
        this.l7 = currentTimeMillis;
        this.m7 = i;
        this.F7 = true;
        if (this.M8 == null) {
            this.M8 = new ArrayList<>();
        }
        if (this.N8 == null) {
            this.N8 = new ArrayList<>();
        }
        long j = this.k7;
        d dVar = this.e;
        this.O8 = j - dVar.a;
        this.Ig = dVar.p1;
        this.Jg = dVar.l1;
    }

    public void z0(int i, String str) {
        if (this.R8 == null) {
            this.R8 = new JSONObject();
        }
        try {
            this.R8.put(Long.toString(System.currentTimeMillis() - this.e.a), i);
        } catch (JSONException e) {
            this.R8 = null;
            e.printStackTrace();
        }
        this.f.getLogInfo(this.e, 2);
        JSONObject w = w();
        this.f.getCurrentAccessCode();
        if (w != null) {
            try {
                w.put("event_key", "play_error").put("code", i).put("info", str);
                K1(w);
                B0(w, "live_client_monitor_log");
                long j = this.h7;
                if (j > 0) {
                    this.h7 = j + 1;
                }
                this.i7 = i;
                if (g0()) {
                    this.wb = i;
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void C1(long j, int i) {
        if (j <= System.currentTimeMillis() - this.e.a && j > i) {
            this.Jc++;
            this.Kc += j;
            this.Ac++;
            this.Bc += j;
            if (this.w) {
                this.bd++;
                this.cd += j;
            }
            this.tb.add(System.currentTimeMillis() + ":" + j);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("PLAY-StallType", 0).put("PLAY-StallTime", j).put("event_key", "decode_stall");
                jSONObject.put("PLAY-SessionID", this.N6);
                VideoLiveManager videoLiveManager = this.f;
                if (videoLiveManager != null && videoLiveManager.mEnableOpenStrategyEngine == 1) {
                    LiveStrategyManager.inst().setEventInfo(62, jSONObject);
                    return;
                }
                return;
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
        com.ss.videoarch.liveplayer.log.a.c("LiveLoggerService", "abnormal demux stall time" + j);
    }

    public void D1(long j, int i) {
        if (j <= System.currentTimeMillis() - this.e.a && j > i) {
            this.Fc++;
            this.Gc += j;
            this.Ec++;
            this.Nc += j;
            if (this.w) {
                this.fd++;
                this.gd += j;
            }
            this.rb.add(System.currentTimeMillis() + ":" + j);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("PLAY-StallType", 0).put("PLAY-StallTime", j).put("event_key", "demux_stall");
                jSONObject.put("PLAY-SessionID", this.N6);
                VideoLiveManager videoLiveManager = this.f;
                if (videoLiveManager != null && videoLiveManager.mEnableOpenStrategyEngine == 1) {
                    LiveStrategyManager.inst().setEventInfo(62, jSONObject);
                    return;
                }
                return;
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
        com.ss.videoarch.liveplayer.log.a.c("LiveLoggerService", "abnormal demux stall time" + j);
    }

    public void N0(String str, String str2) {
        if (this.jc != null) {
            this.lc = System.currentTimeMillis();
        }
        this.qa = System.currentTimeMillis();
        this.e.a = System.currentTimeMillis();
        if (this.w) {
            this.Kd = this.e.a;
        }
        this.e.x1 = str2;
        this.r = str;
        this.s = str;
        JSONObject w = w();
        this.h7 = 0L;
        if (w != null) {
            try {
                w.put("event_key", "start_play").put("rule_ids", this.K6).put("set_surface_cost", this.p9).put("start_play_time", this.e.a).put("stream_data", this.r9).put("suggest_format", this.y9).put("play_format", this.P6).put("suggest_protocol", this.A9).put("suggest_access_code", this.F9).put("origin_url", this.E9).put("log_total_count_when_playing", this.h7).put("event_key_index", Ch.incrementAndGet()).put("trigger_type", this.z);
                if (TextUtils.equals(this.z9, "h2") || TextUtils.equals(this.z9, "h2q") || TextUtils.equals(this.z9, "h2qu")) {
                    w.remove("h2_context_start_cost");
                }
                B0(w, "live_client_monitor_log");
                this.h7++;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("PLAY-SessionID", this.N6);
                VideoLiveManager videoLiveManager = this.f;
                if (videoLiveManager != null && videoLiveManager.mEnableOpenStrategyEngine == 1) {
                    LiveStrategyManager.inst().setEventInfo(60, jSONObject);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void i1(long j, boolean z) {
        String str;
        int i;
        if (j > System.currentTimeMillis() - this.e.a) {
            com.ss.videoarch.liveplayer.log.a.c("LiveLoggerService", "abnormal rtc decode stall time" + j);
            return;
        }
        JSONObject w = w();
        if (w != null) {
            try {
                JSONObject put = w.put("event_key", "rtc_decode_stall");
                if (z) {
                    str = "video";
                } else {
                    str = "audio";
                }
                put.put("type", str).put("decode_stall_time", j);
                B0(w, "live_client_monitor_log");
                long j2 = this.h7;
                if (j2 > 0) {
                    this.h7 = j2 + 1;
                }
                JSONObject jSONObject = new JSONObject();
                if (z) {
                    i = 0;
                } else {
                    i = 1;
                }
                jSONObject.put("PLAY-StallType", i).put("PLAY-StallTime", j).put("event_key", "rtc_decode_stall");
                jSONObject.put("PLAY-SessionID", this.N6);
                VideoLiveManager videoLiveManager = this.f;
                if (videoLiveManager != null && videoLiveManager.mEnableOpenStrategyEngine == 1) {
                    LiveStrategyManager.inst().setEventInfo(62, jSONObject);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void l0(long j, String str) {
        if (this.qf == null) {
            this.qf = new ArrayList();
            this.rf = new ArrayList();
            this.sf = new ArrayList();
            this.tf = new ArrayList();
            this.uf = new ArrayList();
            this.vf = new ArrayList();
            this.wf = new ArrayList();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.qf.add(Long.valueOf(j));
            if (jSONObject.has("current_download_speed")) {
                this.tf.add(Long.valueOf(jSONObject.optLong("current_download_speed")));
            }
            if (jSONObject.has("current_bitrate")) {
                this.rf.add(Long.valueOf(jSONObject.optLong("current_bitrate")));
            }
            if (jSONObject.has("predict_bitrate")) {
                this.sf.add(Long.valueOf(jSONObject.optLong("predict_bitrate")));
            }
            if (jSONObject.has("probe_bandwidth")) {
                this.uf.add(Long.valueOf(jSONObject.optLong("probe_bandwidth")));
            }
            if (jSONObject.has("is_buffering")) {
                if (jSONObject.optInt("is_buffering") == 1) {
                    this.wf.add(1);
                } else {
                    this.wf.add(0);
                }
            }
            if (jSONObject.has("buffer_len")) {
                this.vf.add(Double.valueOf(jSONObject.optDouble("buffer_len")));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void n1(String str, int i) {
        if (this.jc == null) {
            return;
        }
        this.lc = System.currentTimeMillis();
        this.jc.a = System.currentTimeMillis();
        this.qa = System.currentTimeMillis();
        this.r = str;
        JSONObject w = w();
        this.h7 = 0L;
        if (w != null) {
            try {
                w.put("event_key", "session_start").put("reason", i).put("rule_ids", this.K6).put("set_surface_cost", this.p9).put("start_play_time", this.jc.a).put("stream_data", this.r9).put("suggest_format", this.y9).put("play_format", this.P6).put("suggest_protocol", this.A9).put("suggest_access_code", this.F9).put("origin_url", this.E9).put("log_total_count_when_playing", this.h7).put("event_key_index", Eh.incrementAndGet());
                if (TextUtils.equals(this.z9, "h2") || TextUtils.equals(this.z9, "h2q") || TextUtils.equals(this.z9, "h2qu")) {
                    w.remove("h2_context_start_cost");
                }
                j(w);
                B0(w, "live_client_monitor_log");
                this.h7++;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void r0(long j, int i) {
        if (j <= System.currentTimeMillis() - this.e.a && j > i) {
            this.Lc++;
            this.Mc += j;
            this.Cc++;
            this.Dc += j;
            if (this.w) {
                this.dd++;
                this.ed += j;
            }
            this.ub.add(System.currentTimeMillis() + ":" + j);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("PLAY-StallType", 0).put("PLAY-StallTime", j).put("event_key", "decode_stall");
                jSONObject.put("PLAY-SessionID", this.N6);
                VideoLiveManager videoLiveManager = this.f;
                if (videoLiveManager != null && videoLiveManager.mEnableOpenStrategyEngine == 1) {
                    LiveStrategyManager.inst().setEventInfo(62, jSONObject);
                    return;
                }
                return;
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
        com.ss.videoarch.liveplayer.log.a.c("LiveLoggerService", "abnormal demux stall time" + j);
    }

    public void s0(long j, int i) {
        if (j <= System.currentTimeMillis() - this.e.a && j > i) {
            this.Hc++;
            this.Ic += j;
            this.Oc++;
            this.Pc += j;
            if (this.w) {
                this.hd++;
                this.id += j;
            }
            this.sb.add(System.currentTimeMillis() + ":" + j);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("PLAY-StallType", 1).put("PLAY-StallTime", j).put("event_key", "demux_stall");
                jSONObject.put("PLAY-SessionID", this.N6);
                VideoLiveManager videoLiveManager = this.f;
                if (videoLiveManager != null && videoLiveManager.mEnableOpenStrategyEngine == 1) {
                    LiveStrategyManager.inst().setEventInfo(62, jSONObject);
                    return;
                }
                return;
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
        com.ss.videoarch.liveplayer.log.a.c("LiveLoggerService", "abnormal demux stall time" + j);
    }

    public void H0(String str, boolean z) {
        long j;
        int i;
        if (this.f == null) {
            return;
        }
        try {
            JSONObject w = w();
            JSONObject jSONObject = new JSONObject(str);
            d dVar = new d();
            this.f.getLogInfo(dVar, 11);
            if (this.e.q > 0) {
                j = System.currentTimeMillis() - this.e.q;
            } else {
                j = 0;
            }
            int i2 = this.i7;
            if (i2 == 0) {
                i = 2;
            } else if (i2 == -100015) {
                i = 1;
            } else {
                i = 3;
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                w.put(next, jSONObject.get(next));
            }
            w.put("event_key", "abr_switch").put("load_state", i).put("is_auto_switch", 1).put("play_time", j).put("abr_switch_info", "abr_" + jSONObject.getString("source_resolution") + "_to_" + jSONObject.getString("target_resolution")).put("predict_bitrate", jSONObject.optInt("target_bitrate", -1)).put("tcp_connect_cost", jSONObject.optInt("tran_connect_cost", -1)).put("tcp_first_package_cost", jSONObject.optInt("tran_first_packet_cost", -1)).put("abr_switch_count", jSONObject.optInt("switch_count", -1)).put("stall_count", this.n7).put("abr_switch_stall_time", this.Ag).put("request_url", dVar.f3).put("external_smooth_switch", this.fg).put("use_expect_bitrate", this.dc);
            o0();
            this.dc = 0;
            this.fg = 0;
            if (this.h8 == 1) {
                I1(jSONObject, w);
            }
            if (z) {
                com.ss.videoarch.liveplayer.log.a.e("LiveLoggerService", "llash switch log: " + w);
                B0(w, "live_client_monitor_log");
                long j2 = this.h7;
                if (j2 > 0) {
                    this.h7 = j2 + 1;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void O0(int i, Bundle bundle) {
        JSONObject w;
        if (this.f != null && (w = w()) != null) {
            try {
                w.put("event_key", "live_preload").put("preload_event", i).put("preload_url", bundle.getString("preload_url", "")).put("preload_code", bundle.getInt("preload_code", 0)).put("preload_sub_code", bundle.getInt("preload_sub_code", 0)).put("preload_error", bundle.getString("preload_error", "")).put("preload_num", bundle.getInt("preload_num", 0)).put("video_cached_num", bundle.getInt("video_cached_num", 0)).put("audio_cached_num", bundle.getInt("audio_cached_num", 0)).put("video_init_section_cached", bundle.getInt("video_init_section_cached", 0)).put("audio_init_section_cached", bundle.getInt("audio_init_section_cached", 0)).put("io_read_Bytes", bundle.getLong("io_read_Bytes", 0L)).put("cache_write_bytes", bundle.getLong("cache_write_bytes", 0L)).put("cache_waste_bytes", bundle.getLong("cache_waste_bytes", 0L)).put("cache_mode", bundle.getInt("cache_mode", 0)).put("cache_frame_count", bundle.getInt("cache_frame_count", 0)).put("cache_duration", bundle.getLong("cache_duration", 0L)).put("cancel_cost_time", bundle.getLong("cancel_cost_time", 0L)).put("pull_data", bundle.getString("pull_data", "")).put("enable_probe_startup_bitrate", bundle.getInt("enable_probe_startup_bitrate", 0)).put("probe_startup_bitrate", bundle.getInt("probe_startup_bitrate", 0));
                try {
                    B0(w, "live_client_monitor_log");
                    long j = this.h7;
                    if (j > 0) {
                        this.h7 = j + 1;
                    }
                } catch (JSONException e) {
                    e = e;
                    e.printStackTrace();
                }
            } catch (JSONException e2) {
                e = e2;
            }
        }
    }

    public void q2(String str, int i) {
        JSONObject jSONObject;
        String str2;
        String str3;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            jSONObject = new JSONObject();
            if (jSONObject2.has("anomaly_info") && (optJSONObject3 = jSONObject2.optJSONObject("anomaly_info")) != null && optJSONObject3.has("score")) {
                jSONObject.put("score", optJSONObject3.optString("score"));
            }
            JSONObject jSONObject3 = new JSONObject();
            if (!jSONObject2.has("loudness") || (optJSONObject2 = jSONObject2.optJSONObject("loudness")) == null) {
                str2 = "background_noise_left";
                str3 = "estimated_snr_right";
            } else {
                if (optJSONObject2.has("integrated_loudness")) {
                    str2 = "background_noise_left";
                    str3 = "estimated_snr_right";
                    jSONObject3.put("integrated_loudness", optJSONObject2.optDouble("integrated_loudness"));
                } else {
                    str2 = "background_noise_left";
                    str3 = "estimated_snr_right";
                }
                if (optJSONObject2.has("max_mom_loud")) {
                    jSONObject3.put("max_mom_loud", optJSONObject2.optDouble("max_mom_loud"));
                }
                if (optJSONObject2.has("max_short_term_loud")) {
                    jSONObject3.put("max_short_term_loud", optJSONObject2.optDouble("max_short_term_loud"));
                }
            }
            if (jSONObject2.has("clipping")) {
                jSONObject.put("clipping", jSONObject2.optString("clipping"));
            }
            if (jSONObject2.has("rms_stats") && (optJSONObject = jSONObject2.optJSONObject("rms_stats")) != null) {
                JSONObject jSONObject4 = new JSONObject();
                JSONObject jSONObject5 = new JSONObject();
                JSONObject jSONObject6 = new JSONObject();
                if (optJSONObject.has("left_right_diff")) {
                    jSONObject3.put("left_right_rms_diff", optJSONObject.optDouble("left_right_diff"));
                }
                if (optJSONObject.has("dynamic_range_left")) {
                    jSONObject4.put("dynamic_range_left", optJSONObject.optDouble("dynamic_range_left"));
                }
                if (optJSONObject.has("dynamic_range_right")) {
                    jSONObject4.put("dynamic_range_right", optJSONObject.optDouble("dynamic_range_right"));
                }
                if (optJSONObject.has("estimated_snr_left")) {
                    jSONObject5.put("estimated_snr_left", optJSONObject.optDouble("estimated_snr_left"));
                }
                String str4 = str3;
                if (optJSONObject.has(str4)) {
                    jSONObject5.put(str4, optJSONObject.optDouble(str4));
                }
                String str5 = str2;
                if (optJSONObject.has(str5)) {
                    jSONObject6.put(str5, optJSONObject.optDouble(str5));
                }
                if (optJSONObject.has("background_noise_right")) {
                    jSONObject6.put("background_noise_right", optJSONObject.optDouble("background_noise_right"));
                }
                if (jSONObject4.length() > 0) {
                    jSONObject.put("dynamicrange", jSONObject4.toString());
                }
                if (jSONObject5.length() > 0) {
                    jSONObject.put("snr", jSONObject5.toString());
                }
                if (jSONObject6.length() > 0) {
                    jSONObject.put("backgroundnoise", jSONObject6.toString());
                }
            }
            if (jSONObject3.length() > 0) {
                jSONObject.put("loudness", jSONObject3.toString());
            }
        } catch (JSONException e) {
            e = e;
        }
        try {
            if (i == 1) {
                this.Pg = jSONObject.toString();
            } else {
                this.Og = jSONObject.toString();
            }
        } catch (JSONException e2) {
            e = e2;
            e.printStackTrace();
        }
    }

    public void C0(long j, long j2) {
        d dVar;
        int i;
        int i2;
        long j3;
        VideoLiveManager videoLiveManager;
        int i3 = 1;
        this.b7 = true;
        this.Fa = this.V7;
        this.Ga = this.Ha;
        this.d7 = System.currentTimeMillis();
        this.lg = System.currentTimeMillis();
        this.mg = System.currentTimeMillis();
        this.kc = true;
        this.mc = System.currentTimeMillis();
        if (this.w) {
            this.Ld = this.d7;
        }
        if (this.f != null && (dVar = this.e) != null) {
            try {
                dVar.N0 = System.currentTimeMillis();
                if (this.w) {
                    d dVar2 = this.e;
                    dVar2.O0 = dVar2.N0;
                }
                this.f.getLogInfo(this.e, 0);
                JSONObject y = y(this.e, j, this.Y, j2);
                this.Td = this.d7 - this.e.a;
                if (g0() && (videoLiveManager = this.f) != null) {
                    videoLiveManager.onRTMLog(5, "rtc_play_url:" + this.r);
                    this.f.onRTMLog(5, "mFirstFrameView:" + this.Td);
                    this.f.onRTMLog(5, "startPlayTime:" + this.e.a + ",mFirstFrameTimestamp:" + this.d7);
                    VideoLiveManager videoLiveManager2 = this.f;
                    StringBuilder sb = new StringBuilder();
                    sb.append("rtc_inited_end:");
                    sb.append(this.e.k2);
                    videoLiveManager2.onRTMLog(5, sb.toString());
                    VideoLiveManager videoLiveManager3 = this.f;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("start_2_init_diff: ");
                    d dVar3 = this.e;
                    sb2.append(dVar3.k2 - dVar3.a);
                    videoLiveManager3.onRTMLog(5, sb2.toString());
                    this.f.onRTMLog(5, "rtc_offer_send_end:" + this.e.p2);
                    this.f.onRTMLog(5, "rtc_answer_recv_end:" + this.e.q2);
                    this.f.onRTMLog(5, "rtc_ice_connected_time:" + this.e.t2);
                    this.f.onRTMLog(5, "first_video_package_end:" + this.e.m);
                    this.f.onRTMLog(5, "first_video_frame_end:" + this.e.v2);
                    this.f.onRTMLog(5, "first_video_frame_decode_start:" + this.e.x2);
                    this.f.onRTMLog(5, "first_video_frame_decode_end:" + this.e.o);
                    this.f.onRTMLog(5, "first_frame_render_end:" + this.e.q);
                    this.f.onRTMLog(5, "preload_result: " + X());
                }
                String str = this.P6;
                if (str != null && ("cmaf".equals(str) || "avph".equals(this.P6))) {
                    y.put("video_dns_analysis_end", this.e.Y).put("audio_dns_analysis_end", this.e.Z).put("video_tcp_connect_time", this.e.W).put("audio_tcp_connect_time", this.e.X).put("video_tcp_first_packet_time", this.e.a0).put("audio_tcp_first_packet_time", this.e.b0).put("video_http_req_finish_time", this.e.c0).put("audio_http_req_finish_time", this.e.d0).put("video_http_res_finish_time", this.e.e0).put("audio_http_res_finish_time", this.e.f0);
                    if ("cmaf".equals(this.P6)) {
                        y.put("cmaf_mpd_dns_analysis_end", this.e.z).put("cmaf_sdk_version", this.e.H).put("cmaf_mpd_tcp_connect_time", this.e.A).put("cmaf_mpd_tcp_first_package_end", this.e.C).put("cmaf_mpd_http_req_finish_time", this.e.B).put("cmaf_mpd_http_res_finish_time", this.e.D).put("cmaf_audio_firstseg_connect_time", this.e.F).put("cmaf_video_firstseg_connect_time", this.e.G).put("cmaf_mpd_connect_time", this.e.E);
                    }
                    K1(y);
                }
                if (TextUtils.equals("cmaf", this.P6) || TextUtils.equals("flv", this.P6)) {
                    JSONObject put = y.put("enable_preload", this.bf).put("preload_init_error", this.cf).put("preload_result", this.ff).put("preload_resolution", this.kf).put("play_use_preload_resolution", this.lf).put("preload_visit_timedelta", this.gf);
                    if (this.df == 1) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    JSONObject put2 = put.put("audioHttpxRequestCached", i);
                    if (this.ef == 1) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    JSONObject put3 = put2.put("videoHttpxRequestCached", i2).put("cache_hit", this.f1040if).put("cache_open_start_time", this.e.Y2).put("cache_open_end_time", this.e.Z2);
                    d dVar4 = this.e;
                    put3.put("cache_open_cost", dVar4.Z2 - dVar4.Y2).put("preload_task_state", this.jf);
                    if (this.bf == 1) {
                        if (this.f1040if == 1) {
                            long j4 = this.e.b;
                            if (j != 0) {
                                j3 = j;
                            } else {
                                j3 = j4;
                            }
                            y.put("player_dns_analysis_end", j4);
                            y.put("tcp_connect_end", j3);
                            y.put("tcp_first_package_end", j3);
                        }
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("[first_frame] first_frame_view :");
                        sb3.append(this.Td);
                        sb3.append("\ncache_hit :");
                        sb3.append(this.f1040if);
                        sb3.append("\npreload_result :");
                        sb3.append(this.ff);
                        sb3.append("\npreload_visit_timedelta :");
                        sb3.append(this.gf);
                        sb3.append("\npreload_task_state : ");
                        sb3.append(this.jf);
                        sb3.append("\nfirst_video_pkg_cost : ");
                        d dVar5 = this.e;
                        sb3.append(dVar5.m - dVar5.a);
                        sb3.append("\nfirst_video_frame_decode_cost : ");
                        d dVar6 = this.e;
                        sb3.append(dVar6.o - dVar6.a);
                        sb3.append("\nfirst_video_frame_render_cost : ");
                        d dVar7 = this.e;
                        sb3.append(dVar7.q - dVar7.a);
                        com.ss.videoarch.liveplayer.log.a.c("tt_preload", sb3.toString());
                    }
                }
                long j5 = this.h7;
                if (j5 > 0) {
                    this.h7 = j5 + 1;
                }
                this.V4 = "1.0:" + this.d7;
                d dVar8 = this.e;
                long j6 = dVar8.g1;
                dVar8.i1 = j6;
                dVar8.j1 = j6;
                d dVar9 = this.jc;
                if (dVar9 != null) {
                    dVar9.i1 = j6;
                }
                if (!this.kc) {
                    i3 = 0;
                }
                L1(y, i3, 0);
                B0(y, "live_client_monitor_log");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void g2(String str, String str2, String str3) {
        this.A9 = str;
        this.z9 = str2;
        this.F9 = str3;
    }

    public void l2(String str, int i, int i2) {
        this.A = str;
        this.B = i;
        this.C = i2;
    }

    private void w1(int i, int i2, int i3) {
        JSONObject w;
        if (this.f != null && (w = w()) != null) {
            try {
                w.put("event_key", "stream_abnormal").put("stream_type", "video").put("type", i).put("sent_frames", i2).put("received_frames", i3);
                B0(w, "live_client_monitor_log");
                long j = this.h7;
                if (j > 0) {
                    this.h7 = j + 1;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void x1(int i, int i2, int i3) {
        JSONObject w;
        if (this.f != null && (w = w()) != null) {
            try {
                w.put("event_key", "stream_abnormal").put("stream_type", "video").put("type", i).put("cur_index", i2).put("last_index", i3);
                B0(w, "live_client_monitor_log");
                long j = this.h7;
                if (j > 0) {
                    this.h7 = j + 1;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void Y0(JSONObject jSONObject, JSONArray jSONArray, String str) throws JSONException {
        JSONObject w = w();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            w.put(next, jSONObject.getLong(next));
        }
        if (w != null) {
            try {
                w.put("event_key", str).put("push_retry_stall", jSONArray).put("sei_source", this.e.k1);
                B0(w, "live_client_monitor_log");
                long j = this.h7;
                if (j > 0) {
                    this.h7 = j + 1;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void L1(JSONObject jSONObject, int i, int i2) {
        if (this.jc != null && this.h8 == 1) {
            try {
                String str = this.f7;
                String str2 = this.L6;
                if (str != str2) {
                    this.f7 = str2;
                }
                JSONObject jSONObject2 = new JSONObject();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject2.put(next, jSONObject.get(next));
                }
                int i3 = 0;
                JSONObject put = jSONObject2.put("event_key", "session_first_frame").put("is_stream_received", i).put("wait_surface_elapse", 0);
                if (this.p9 > 0) {
                    i3 = 1;
                }
                put.put("set_surface", i3).put("event_key_index", Fh.incrementAndGet());
                long currentTimeMillis = System.currentTimeMillis() - this.jc.a;
                if (i == 1) {
                    jSONObject2.put("session_succ_elapse", currentTimeMillis);
                } else {
                    jSONObject2.put("session_play_time_on_no_frame", currentTimeMillis);
                    jSONObject2.put("reason", i2);
                }
                B0(jSONObject2, "live_client_monitor_log");
                long j = this.h7;
                if (j > 0) {
                    this.h7 = j + 1;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void f1(int i, float f, float f2) {
        int i2;
        if (this.f == null) {
            return;
        }
        JSONObject w = w();
        this.f.getLogInfo(this.e, 12);
        if (w != null) {
            try {
                JSONObject put = w.put("index", i).put("event_key", "vqscore_report").put("sr_scale_type_float", this.e.p3).put("sr_alg_type", this.e.n3);
                if (this.e.o3 >= 0) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                put.put("sharpen_used", i2).put("sharpen_alg_type", this.e.o3).put("is_hdr", this.e.r3).put("width", this.D8).put("height", this.E8).put("sr_sharp_level", this.e.q3).put("download_speed", this.e.R0).put("vqscore_result", f).put("vqscore_result_after_effect", f2);
                B0(w, "live_client_monitor_log");
                long j = this.h7;
                if (j > 0) {
                    this.h7 = j + 1;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void x0(long j, int i, boolean z) {
        String str;
        int i2;
        if (j <= System.currentTimeMillis() - this.e.a && j > i) {
            if (z) {
                this.Ac++;
                this.Bc += j;
                if (this.w) {
                    this.bd++;
                    this.cd += j;
                }
            } else {
                this.Cc++;
                this.Dc += j;
                if (this.w) {
                    this.dd++;
                    this.ed += j;
                }
            }
            JSONObject w = w();
            if (w != null) {
                try {
                    JSONObject put = w.put("event_key", "decode_stall");
                    if (z) {
                        str = "video";
                    } else {
                        str = "audio";
                    }
                    put.put("type", str).put("stall_time", j);
                    B0(w, "live_client_monitor_log");
                    long j2 = this.h7;
                    if (j2 > 0) {
                        this.h7 = j2 + 1;
                    }
                    JSONObject jSONObject = new JSONObject();
                    if (z) {
                        i2 = 0;
                    } else {
                        i2 = 1;
                    }
                    jSONObject.put("PLAY-StallType", i2).put("PLAY-StallTime", j).put("event_key", "decode_stall");
                    jSONObject.put("PLAY-SessionID", this.N6);
                    VideoLiveManager videoLiveManager = this.f;
                    if (videoLiveManager != null && videoLiveManager.mEnableOpenStrategyEngine == 1) {
                        LiveStrategyManager.inst().setEventInfo(62, jSONObject);
                        return;
                    }
                    return;
                } catch (JSONException e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        com.ss.videoarch.liveplayer.log.a.c("LiveLoggerService", "abnormal decode stall time" + j);
    }

    public void y0(long j, int i, boolean z) {
        String str;
        int i2;
        if (j <= System.currentTimeMillis() - this.e.a && j > i) {
            if (z) {
                this.Ec++;
                this.Nc += j;
                if (this.w) {
                    this.fd++;
                    this.gd += j;
                }
            } else {
                this.Oc++;
                this.Pc += j;
                if (this.w) {
                    this.hd++;
                    this.id += j;
                }
            }
            JSONObject w = w();
            if (w != null) {
                try {
                    JSONObject put = w.put("event_key", "demux_stall");
                    if (z) {
                        str = "video";
                    } else {
                        str = "audio";
                    }
                    put.put("type", str).put("stall_time", j);
                    B0(w, "live_client_monitor_log");
                    long j2 = this.h7;
                    if (j2 > 0) {
                        this.h7 = j2 + 1;
                    }
                    JSONObject jSONObject = new JSONObject();
                    if (z) {
                        i2 = 0;
                    } else {
                        i2 = 1;
                    }
                    jSONObject.put("PLAY-StallType", i2).put("PLAY-StallTime", j).put("event_key", "demux_stall");
                    jSONObject.put("PLAY-SessionID", this.N6);
                    VideoLiveManager videoLiveManager = this.f;
                    if (videoLiveManager != null && videoLiveManager.mEnableOpenStrategyEngine == 1) {
                        LiveStrategyManager.inst().setEventInfo(62, jSONObject);
                        return;
                    }
                    return;
                } catch (JSONException e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        com.ss.videoarch.liveplayer.log.a.c("LiveLoggerService", "abnormal demux stall time" + j);
    }

    private void s(int i, int i2, long j) {
        LinkedBlockingQueue<Long> linkedBlockingQueue;
        long j2;
        int i3;
        if (i < 0 || i2 <= 0 || j < 0 || (linkedBlockingQueue = this.Za) == null) {
            return;
        }
        int i4 = this.cb;
        if (i4 == -1) {
            this.cb = i;
            this.db = i2;
            this.eb = j;
            return;
        }
        if (this.wh != 1 && i == i4) {
            return;
        }
        if (linkedBlockingQueue.size() > 0) {
            j2 = this.Za.peek().longValue();
        } else {
            j2 = -1;
        }
        int i5 = 0;
        if (j2 > 0 && j2 <= this.eb) {
            boolean z = false;
            int i6 = 0;
            while (this.Za.size() > 0) {
                long longValue = this.Za.peek().longValue();
                long j3 = this.eb;
                if (longValue == j3) {
                    z = true;
                }
                if (z && longValue > j3 && longValue <= j) {
                    i6++;
                    if (longValue == j) {
                        break;
                    }
                }
                this.Za.poll().longValue();
            }
            if (i - this.cb == 1 && i6 > 0 && i6 != i2) {
                if (i6 < i2) {
                    i3 = 0;
                } else {
                    i3 = 1;
                }
                if (this.wh == 1) {
                    this.ob.add("type" + i3 + "sent_frames" + i2 + "received_frames" + i6);
                } else {
                    w1(i3, i2, i6);
                }
            }
        }
        int i7 = this.cb;
        if (i - i7 != 1) {
            if (i <= i7) {
                i5 = 1;
            }
            if (this.wh == 1) {
                if (i5 == 0) {
                    this.ob.add("type" + i5 + "sent_frames" + i2 + "last_index" + this.cb);
                } else {
                    this.pb.add("type" + i5 + "sent_frames" + i2 + "last_index" + this.cb);
                }
            } else {
                x1(i5, i, i7);
            }
        }
        this.cb = i;
        this.db = i2;
        this.eb = j;
    }

    public void y1(String str, String str2, String str3, int i) {
        if (this.f == null) {
            return;
        }
        this.mf = true;
        try {
            JSONObject w = w();
            JSONObject put = w.put("event_key", "switch_url");
            if (str == null) {
                str = "null";
            }
            JSONObject put2 = put.put("last_cdn_play_url", str);
            if (str2 == null) {
                str2 = "null";
            }
            put2.put("next_cdn_play_url", str2).put("res_bitrate", this.fa).put("last_res", this.ea).put("code", i).put("reason", str3);
            B0(w, "live_client_monitor_log");
            long j = this.h7;
            if (j > 0) {
                this.h7 = j + 1;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void e1(long j, int i, boolean z, boolean z2) {
        String str;
        int i2;
        this.Ae = 1L;
        if (j <= System.currentTimeMillis() - this.e.a && j > i) {
            if (z) {
                com.ss.videoarch.liveplayer.log.a.c("LiveLoggerService", "video render stall time " + j);
                this.I7 = this.I7 + 1;
                this.B7 = this.B7 + 1;
                this.J7 = (int) (((long) this.J7) + j);
                this.C7 += j;
                if (this.ic == 1) {
                    this.rc++;
                    this.sc += j;
                }
                long currentTimeMillis = System.currentTimeMillis() - this.e.q;
                if (this.Q8.equals("none")) {
                    this.Q8 = currentTimeMillis + ":" + j;
                } else {
                    this.Q8 += "," + currentTimeMillis + ":" + j;
                }
                if (this.w) {
                    this.r7++;
                    this.s7 += j;
                    this.x7++;
                    this.y7 = (int) (this.y7 + j);
                }
            } else {
                com.ss.videoarch.liveplayer.log.a.c("LiveLoggerService", "audio render stall time " + j);
                this.K7 = this.K7 + 1;
                this.D7 = this.D7 + 1;
                this.L7 = (int) (((long) this.L7) + j);
                this.E7 += j;
                if (this.ic == 1) {
                    this.tc++;
                    this.uc += j;
                }
                long currentTimeMillis2 = System.currentTimeMillis() - this.e.q;
                if (this.P8.equals("none")) {
                    this.P8 = currentTimeMillis2 + ":" + j;
                } else {
                    this.P8 += "," + currentTimeMillis2 + ":" + j;
                }
                if (this.w) {
                    this.t7++;
                    this.u7 += j;
                    this.z7++;
                    this.A7 = (int) (this.A7 + j);
                }
            }
            if (z2) {
                this.f.getLogInfo(this.e, 4);
                JSONObject w = w();
                if (w != null) {
                    try {
                        JSONObject put = w.put("event_key", "render_stall");
                        if (z) {
                            str = "video";
                        } else {
                            str = "audio";
                        }
                        put.put("type", str).put("stall_time", j).put("video_buffer_time", this.e.Z0).put("audio_buffer_time", this.e.a1).put("event_key_index", Jh.incrementAndGet());
                        B0(w, "live_client_monitor_log");
                        long j2 = this.h7;
                        if (j2 > 0) {
                            this.h7 = j2 + 1;
                        }
                        JSONObject jSONObject = new JSONObject();
                        if (z) {
                            i2 = 0;
                        } else {
                            i2 = 1;
                        }
                        jSONObject.put("PLAY-StallType", i2).put("PLAY-StallTime", j).put("event_key", "render_stall");
                        jSONObject.put("PLAY-SessionID", this.N6);
                        VideoLiveManager videoLiveManager = this.f;
                        if (videoLiveManager != null && videoLiveManager.mEnableOpenStrategyEngine == 1) {
                            LiveStrategyManager.inst().setEventInfo(62, jSONObject);
                            return;
                        }
                        return;
                    } catch (JSONException e) {
                        e.printStackTrace();
                        return;
                    }
                }
                return;
            }
            return;
        }
        com.ss.videoarch.liveplayer.log.a.c("LiveLoggerService", "abnormal render stall time" + j);
    }

    public void n0(long j, String str, boolean z, boolean z2) {
        long j2;
        int i;
        if (this.f == null) {
            return;
        }
        try {
            JSONObject w = w();
            d dVar = new d();
            this.f.getLogInfo(dVar, 11);
            long j3 = dVar.f;
            long j4 = j3 - dVar.d;
            long j5 = dVar.l - j3;
            if (this.e.q > 0) {
                j2 = System.currentTimeMillis() - this.e.q;
            } else {
                j2 = 0;
            }
            JSONObject put = w.put("event_key", "abr_switch");
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            put.put("auto_switch", i).put("target_resoultion", str).put("predict_bitrate", j).put("abr_switch_info", this.va).put("cur_download_speed", this.ra).put("cur_audio_buffer_time", this.sa).put("cur_video_buffer_time", this.ta).put("stall_count", this.n7).put("switch_cost", this.ua).put("use_expect_bitrate", this.dc).put("tcp_connect_cost", j4).put("tcp_first_package_cost", j5).put("find_stream_info_cost", dVar.e3).put("request_url", dVar.f3).put("prev_video_buffer_time", dVar.Z0).put("prev_audio_buffer_time", dVar.a1).put("external_smooth_switch", this.fg).put("abr_switch_count", this.ha).put("request_cdn_cached", dVar.p0).put("request_time_to_source", dVar.r0).put("request_time_for_cdn", dVar.t0).put("close_io_cost", dVar.g3).put("play_time", j2).put("abr_switch_stall_time", this.Ag);
            o0();
            this.dc = 0;
            this.fg = 0;
            if (this.h8 == 1) {
                L1(w, 1, -200100);
            }
            if (z2) {
                com.ss.videoarch.liveplayer.log.a.e("LiveLoggerService", "abr switch log: " + w);
                B0(w, "live_client_monitor_log");
                long j6 = this.h7;
                if (j6 > 0) {
                    this.h7 = j6 + 1;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private JSONObject y(d dVar, long j, boolean z, long j2) throws JSONException {
        JSONArray jSONArray;
        boolean z2;
        int i;
        long j3;
        long j4;
        JSONObject w = w();
        if (w != null) {
            long j5 = dVar.q - dVar.a;
            JSONObject put = w.put("event_key", "first_frame").put("total_cost", j5).put("last_retry_end", j).put("hit_cache", z ? 1 : 0).put("start", dVar.a).put("sdk_dns_analysis_end", dVar.b).put("prepare_block_end", dVar.c);
            long j6 = dVar.y;
            if (j6 <= 0) {
                j6 = dVar.d;
            }
            JSONObject put2 = put.put("tfo_fall_back_time", j6).put("pre_connect", this.F8).put("request_cdn_cached", this.e.p0).put("request_time_to_source", this.e.r0).put("request_time_for_cdn", this.e.t0).put("http_req_finish_time", dVar.m0).put("http_res_finish_time", dVar.n0).put("first_video_package_end", dVar.m).put("first_audio_package_end", dVar.n).put("first_video_frame_decode_end", dVar.o).put("first_audio_frame_decode_end", dVar.p).put("first_frame_from_player_core", dVar.s).put("first_frame_render_end", dVar.q).put("video_param_send_outlet_time", dVar.q1).put("first_video_frame_send_outlet_time", dVar.r1).put("set_surface_time", this.q9).put("set_surface_cost", this.p9).put("video_render_type", dVar.s1).put("video_device_open_start", dVar.u).put("video_device_open_end", dVar.v).put("audio_device_open_start", dVar.w).put("audio_device_open_end", dVar.x).put("video_device_wait_start", dVar.v1).put("video_device_wait_end", dVar.w1).put("find_stream_info_start", dVar.t1).put("find_stream_info_end", dVar.u1).put("video_first_pkt_pos", dVar.g0).put("video_first_pkt_pts", dVar.h0).put("audio_first_pkt_pos", dVar.i0).put("audio_first_pkt_pts", dVar.j0).put("video_buffer_time", this.e.Z0).put("audio_buffer_time", this.e.a1).put("download_speed", this.e.R0).put("stall_time", j2).put("first_sei_delay", this.e.g1).put("response_header_X-Server-IP", this.e.z1).put("response_header_Via", this.e.A1).put("prepare_end", dVar.t).put("drop_audio_pts_diff", dVar.k0).put("drop_audio_cost", dVar.l0).put("enable_tcp_fast_open", this.Ra).put("tfo_success", dVar.E2).put("abr_check_enhance", this.qb);
            if (this.Ta == null) {
                jSONArray = new JSONArray();
            } else {
                jSONArray = new JSONArray((Collection) this.Ta);
            }
            put2.put("optimize_backup_ips", jSONArray).put("suggest_format", this.y9).put("suggest_protocol", this.A9).put("suggest_access_code", this.F9).put("container_fps", this.w9).put("used_drm", this.ve).put("ipv6_probe_result", dVar.H2).put("http_open_start", dVar.g).put("trans_open_start", dVar.h).put("socket_create_end", dVar.j).put("3xx_happen_time", dVar.k).put("trans_strategy_params", this.Ne).put("trans_params_bandwidth", this.Oe).put("trans_params_bandwidth_decision", this.Pe).put("is_free_flow", this.Q).put("enable_fast_first_frame", this.N9).put("preplay_enter_room_timestamp", this.rg).put("event_key_index", Dh.incrementAndGet()).put("UseRedirectedIp", this.G8).put("UsePreconnectIp", this.I8);
            long j7 = this.rg;
            if (j7 != -1) {
                long j8 = dVar.o;
                if (j7 > j8) {
                    this.sg = j7 - j8;
                }
            }
            if (j7 != -1) {
                com.ss.videoarch.liveplayer.log.a.c("LiveLoggerService", "preplay enter room at: " + this.rg + ", wait cost: " + this.sg);
            }
            if (this.ve == 1) {
                w.put("drm_get_secret_key_end", this.xe);
            }
            if (!g0() && !i0()) {
                if (dVar.b == 0) {
                    w.put("sdk_dns_analysis_end", this.jc.b);
                }
                w.put("player_dns_analysis_end", dVar.d);
                w.put("player_open_input_start", dVar.e);
                if ("kcp".equals(this.z9)) {
                    j4 = dVar.d;
                } else {
                    j4 = dVar.f;
                }
                w.put("tcp_connect_end", j4);
                w.put("tcp_first_package_end", dVar.l);
            } else {
                w.put("player_dns_analysis_end", this.Gb);
                w.put("rtc_use_sdk_dns", this.Fb);
                w.put("tcp_connect_end", this.Hb);
                w.put("rtc_tls_handshake_end", this.Ib);
                w.put("tcp_first_package_end", this.Jb);
                w.put("rtc_inited_end", dVar.k2);
                w.put("rtc_offer_send_end", dVar.p2);
                w.put("rtc_answer_recv_end", dVar.q2);
                w.put("rtc_ice_connected_time", dVar.t2);
                w.put("rtc_start_end", dVar.u2);
                w.put("rtc_preload_result", X());
                w.put("first_audio_frame_decode_start", dVar.y2);
                w.put("first_video_frame_decode_start", dVar.x2);
                w.put("first_audio_frame_end", dVar.w2);
                w.put("first_video_frame_end", dVar.v2);
                if (i0()) {
                    w.put("player_open_input_start", dVar.e);
                }
            }
            int i2 = this.E6;
            if (i2 != -1) {
                w.put("audio_timescale_enable", i2);
            }
            if (this.ja) {
                w.put("abr_startup_bitrate", dVar.Y0);
                w.put("abr_request_url", dVar.f3);
            }
            if (TextUtils.equals(this.z9, "quic") || TextUtils.equals(this.z9, "h2q")) {
                w.put("quic_report_ccre_tag_in_chlo", this.e.b2).put("quic_report_jcco_tag_in_chlo", this.e.c2).put("quic_report_ssr_tag_in_chlo", this.e.d2).put("quic_report_irtt_tag_in_chlo", this.e.e2).put("quic_report_cctk_tag_in_chlo", this.e.f2).put("quic_report_ntyp_tag_in_chlo", this.e.g2).put("quic_report_ccfb_tag_in_shlo", this.e.h2);
            }
            if (TextUtils.equals(this.z9, "quic") || TextUtils.equals(this.z9, "quicu")) {
                a2(w, this.J9);
            }
            if (TextUtils.equals(this.z9, "h2") || TextUtils.equals(this.z9, "h2q") || TextUtils.equals(this.z9, "h2qu")) {
                a2(w, this.I9);
            }
            if (TextUtils.equals(this.P6, "avph")) {
                a2(w, this.K9);
            }
            if (TextUtils.equals(this.P6, "cmaf")) {
                a2(w, this.M9);
                w.put("cmaf_start_seq_no_diff", this.e.M).put("audio_request_cdn_cached", this.e.o0).put("video_request_cdn_cached", this.e.p0).put("audio_request_time_to_source", this.e.q0).put("video_request_time_to_source", this.e.r0).put("audio_request_time_for_cdn", this.e.s0).put("video_request_time_for_cdn", this.e.t0);
            }
            j(w);
            JSONObject jSONObject = new JSONObject();
            JSONObject put3 = jSONObject.put("PLAY-FirstFrameAudioBuffer", this.e.a1).put("PLAY-FirstFrameVideoBuffer", this.e.Z0).put("PLAY-FirstFrameDownloadSpeed", this.e.R0);
            String str = this.j;
            String str2 = "none";
            if (str == null) {
                str = "none";
            }
            JSONObject put4 = put3.put("PLAY-EnterMethod", str);
            String str3 = this.k;
            if (str3 == null) {
                str3 = "none";
            }
            JSONObject put5 = put4.put("PLAY-EnterAction", str3);
            String str4 = this.l;
            if (str4 != null) {
                str2 = str4;
            }
            JSONObject put6 = put5.put("PLAY-EnterMethodSubtag", str2).put("PLAY-IsPreview", this.w ? 1 : 0).put("PLAY-Protocol", this.z9).put("PLAY-FirstFrame", j5).put("PLAY-Success", 1);
            if (this.e.k > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            put6.put("PLAY-302", z2).put("PLAY-BufferDataSeconds", this.f.mBufferDataSeconds);
            jSONObject.put("PLAY-ConnectCost", w.optLong("tcp_connect_end") - w.optLong("player_dns_analysis_end"));
            jSONObject.put("PLAY-SessionID", this.N6);
            w.put("first_play_time", -1);
            VideoLiveManager videoLiveManager = this.f;
            if (videoLiveManager != null && videoLiveManager.mEnableOpenStrategyEngine == 1) {
                jSONObject.put("PLAY-StreamSuffix", videoLiveManager.getStreamSuffix());
                jSONObject.put("PLAY-NeptuneName", this.f.getNeptuneName());
                jSONObject.put("PLAY-FPS", this.f.getFPS());
                if (LiveStrategyManager.inst().mFirstStart) {
                    j3 = dVar.a - LiveStrategyManager.mLoadLibraryTime;
                } else {
                    j3 = -1;
                }
                w.put("first_play_time", j3);
                LiveStrategyManager.inst().setEventInfo(61, jSONObject);
            }
            if (this.wh == 1 && (i = this.Ah) > 0) {
                w.put("receive_sps_pps_count", i);
                w.put("receive_sps_pps_list", this.Bh);
            }
            return w;
        }
        return null;
    }

    private void H1(boolean z, long j, long j2, long j3, long j4, long j5) {
        d dVar;
        long j6;
        long j7;
        long j8;
        long j9;
        long j10;
        long j11;
        VideoLiveManager videoLiveManager = this.f;
        if (videoLiveManager != null && (dVar = this.e) != null) {
            if (j != 0) {
                j6 = j;
            } else {
                try {
                    j6 = dVar.u0;
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (j2 != 0) {
                j7 = j2;
            } else {
                j7 = dVar.v0;
            }
            if (j3 != 0) {
                j8 = j3;
            } else {
                j8 = dVar.N0;
            }
            if (j4 != 0) {
                j9 = j4;
            } else {
                j9 = dVar.P0;
            }
            if (j5 != 0) {
                j10 = j5;
            } else {
                j10 = dVar.O0;
            }
            if (!z) {
                videoLiveManager.getLogInfo(dVar, 1);
                j11 = j10;
            } else {
                j11 = j10;
                dVar.N0 = System.currentTimeMillis();
            }
            if (q()) {
                B0(z(this.e, j6, j7, j8, j9, z, j11), "live_client_monitor_log");
                long j12 = this.h7;
                if (j12 > 0) {
                    this.h7 = j12 + 1;
                }
            }
            long j13 = this.g;
            if (g0()) {
                j13 = this.se;
            }
            if (this.h) {
                this.c.sendEmptyMessageDelayed(101, j13);
            }
        }
    }

    public c(VideoLiveManager videoLiveManager, ILiveListener iLiveListener, long j, long j2, Context context, int i) {
        super(videoLiveManager);
        long j3;
        this.a = -1;
        this.h = false;
        this.i = 0L;
        this.j = "none";
        this.k = "none";
        this.l = "none";
        this.m = "none";
        this.n = "none";
        this.o = null;
        this.p = "none";
        this.q = "none";
        this.r = "none";
        this.s = "none";
        this.t = "none";
        this.u = false;
        this.v = "none";
        this.w = false;
        this.x = 0L;
        this.y = "none";
        this.z = -1;
        this.A = "none";
        this.B = 0;
        this.C = 0;
        this.D = "none";
        this.E = "none";
        this.F = "none";
        this.G = "none";
        this.H = "none";
        this.I = -1;
        this.J = -1;
        this.K = -1;
        this.L = -1;
        this.M = -1;
        this.N = "none";
        this.O = "none";
        this.P = "";
        this.Q = 0;
        this.R = false;
        this.S = "none";
        this.T = -1;
        this.U = -1;
        this.V = -1;
        this.W = false;
        this.X = false;
        this.Y = false;
        this.Z = "none";
        this.k0 = false;
        this.H0 = "none";
        this.L0 = 0;
        this.P0 = 1;
        this.b1 = false;
        this.k1 = 0;
        this.v1 = -1;
        this.x1 = -1;
        this.y1 = -1;
        this.H1 = -1;
        this.L1 = -1;
        this.P1 = 0;
        this.T1 = 0;
        this.V1 = 0;
        this.b2 = 0;
        this.v2 = 0;
        this.x2 = 0;
        this.y2 = 0;
        this.H2 = 0;
        this.M2 = -1.0f;
        this.P2 = -1;
        this.T2 = -1.0f;
        this.V2 = 0.0f;
        this.H3 = 0;
        this.M3 = 0;
        this.P3 = 0;
        this.V3 = 0;
        this.H4 = 0;
        this.V4 = "none";
        this.H5 = "none";
        this.w6 = 0L;
        this.x6 = 2000L;
        this.y6 = 0;
        this.z6 = -1;
        this.A6 = 0;
        this.B6 = 0;
        this.C6 = 0;
        this.D6 = 0;
        this.E6 = -1;
        this.F6 = 0;
        this.G6 = 0;
        this.H6 = -1;
        this.I6 = -1.0f;
        this.J6 = -1;
        this.K6 = "none";
        this.L6 = "none";
        this.M6 = "none";
        this.N6 = "none";
        this.O6 = "none";
        this.P6 = "flv";
        this.Q6 = "none";
        this.R6 = "";
        this.S6 = 0;
        this.T6 = 0;
        this.U6 = 0L;
        this.V6 = 0L;
        this.W6 = 2L;
        this.X6 = 3000L;
        this.Y6 = 0;
        this.Z6 = -1;
        this.a7 = 0;
        this.b7 = false;
        this.c7 = false;
        this.d7 = 0L;
        this.e7 = 0L;
        this.f7 = "";
        this.g7 = 0L;
        this.h7 = 0L;
        this.i7 = 0;
        this.j7 = 0;
        this.k7 = 0L;
        this.l7 = 0L;
        this.m7 = -1L;
        this.n7 = 0L;
        this.o7 = 0L;
        this.p7 = 0L;
        this.q7 = 0L;
        this.r7 = 0L;
        this.s7 = 0L;
        this.t7 = 0L;
        this.u7 = 0L;
        this.v7 = 0;
        this.w7 = 0;
        this.x7 = 0;
        this.y7 = 0;
        this.z7 = 0;
        this.A7 = 0;
        this.B7 = 0L;
        this.C7 = 0L;
        this.D7 = 0L;
        this.E7 = 0L;
        this.F7 = false;
        this.G7 = 0;
        this.H7 = 0;
        this.I7 = 0;
        this.J7 = 0;
        this.K7 = 0;
        this.L7 = 0;
        this.M7 = 0L;
        this.N7 = 0L;
        this.O7 = 0L;
        this.P7 = 0L;
        this.Q7 = 0L;
        this.R7 = 0L;
        this.S7 = 0L;
        this.T7 = 0;
        this.U7 = 0;
        this.V7 = 0;
        this.W7 = false;
        this.X7 = -1;
        this.Y7 = false;
        this.Z7 = false;
        this.a8 = false;
        this.b8 = 10000L;
        this.c8 = false;
        this.d8 = 0L;
        this.e8 = 0L;
        this.f8 = 0L;
        this.h8 = 0;
        this.l8 = 300000L;
        this.n8 = 0;
        this.o8 = -1;
        this.p8 = null;
        this.q8 = false;
        this.s8 = 0;
        this.t8 = 0;
        this.u8 = 0L;
        this.v8 = 0;
        this.w8 = 0;
        this.x8 = 0;
        this.y8 = 0;
        this.z8 = -1;
        this.A8 = 0;
        this.B8 = null;
        this.C8 = 0;
        this.D8 = 0;
        this.E8 = 0;
        this.F8 = -1;
        this.G8 = -1;
        this.H8 = "none";
        this.I8 = -1;
        this.J8 = null;
        this.K8 = null;
        this.L8 = null;
        this.M8 = null;
        this.N8 = null;
        this.O8 = -1L;
        this.P8 = "none";
        this.Q8 = "none";
        this.R8 = null;
        this.S8 = null;
        this.T8 = null;
        this.U8 = null;
        this.V8 = "none";
        this.W8 = "none";
        this.X8 = "none";
        this.Y8 = "none";
        this.Z8 = false;
        this.a9 = null;
        this.b9 = false;
        this.c9 = 0;
        this.d9 = -1;
        this.e9 = 0;
        this.f9 = 1;
        this.g9 = 0;
        this.h9 = "none";
        this.i9 = false;
        this.j9 = -1;
        this.k9 = 0;
        this.l9 = -1;
        this.m9 = false;
        this.n9 = 0;
        this.o9 = 1;
        this.p9 = -1L;
        this.q9 = 0L;
        this.r9 = "none";
        this.s9 = 0;
        this.t9 = false;
        this.u9 = false;
        this.v9 = false;
        this.w9 = -1.0f;
        this.x9 = 0L;
        this.y9 = "none";
        this.z9 = "tcp";
        this.A9 = "none";
        this.B9 = -1;
        this.C9 = 0;
        this.D9 = "none";
        this.E9 = "none";
        this.F9 = "none";
        this.G9 = false;
        this.H9 = false;
        this.I9 = null;
        this.J9 = null;
        this.K9 = null;
        this.L9 = -1;
        this.M9 = null;
        this.N9 = 0;
        this.O9 = Build.BOARD;
        this.P9 = Build.HARDWARE;
        this.Q9 = "none";
        this.R9 = "none";
        this.S9 = "none";
        this.T9 = false;
        this.U9 = "rad";
        this.V9 = false;
        this.W9 = "origin";
        this.X9 = "none";
        this.Y9 = "none";
        this.Z9 = new ArrayList<>();
        this.aa = false;
        this.ba = false;
        this.ca = "none";
        this.da = "origin";
        this.ea = "none";
        this.fa = -1L;
        this.ga = -1;
        this.ha = 0;
        this.ia = "none";
        this.ja = false;
        this.ka = -1;
        this.la = 0;
        this.ma = "none";
        this.na = -1L;
        this.oa = 0L;
        this.pa = 0L;
        this.qa = 0L;
        this.ra = -1L;
        this.sa = -1L;
        this.ta = -1L;
        this.ua = -1L;
        this.va = "none";
        this.wa = 4;
        this.xa = false;
        this.ya = 0L;
        this.za = 0L;
        this.Aa = 0L;
        this.Ba = 0L;
        this.Ca = 0L;
        this.Da = -1L;
        this.Ea = -1L;
        this.Fa = 0;
        this.Ga = 0L;
        this.Ha = 0L;
        this.Ia = -1L;
        this.Ja = -1;
        this.Ka = -1;
        this.La = -1;
        this.Ma = -1;
        this.Na = -1;
        this.Oa = -1;
        this.Pa = -1;
        this.Qa = -1;
        this.Ra = 0;
        this.Sa = 0;
        this.Ta = null;
        this.Ua = 0;
        this.Va = 1;
        this.Wa = 2;
        this.Xa = 3;
        this.Ya = 4;
        this.Za = null;
        this.ab = 600;
        this.bb = 32;
        this.cb = -1;
        this.db = -1;
        this.eb = -1L;
        this.fb = -1;
        this.gb = 0;
        this.hb = 0;
        this.ib = 0;
        this.jb = 0;
        this.kb = -1;
        this.lb = -1;
        this.mb = new LinkedBlockingQueue<>(32);
        this.nb = "none";
        this.ob = new ArrayList();
        this.pb = new ArrayList();
        this.qb = 0;
        this.rb = new ArrayList();
        this.sb = new ArrayList();
        this.tb = new ArrayList();
        this.ub = new ArrayList();
        this.vb = null;
        this.wb = 0;
        this.xb = 0;
        this.yb = 0;
        this.zb = 0;
        this.Ab = -1;
        this.Bb = 5000;
        this.Cb = 500;
        this.Db = "none";
        this.Eb = false;
        this.Fb = -1;
        this.Gb = 0L;
        this.Hb = 0L;
        this.Ib = 0L;
        this.Jb = 0L;
        this.Kb = 0;
        this.Lb = 0L;
        this.Mb = 0L;
        this.Nb = "none";
        this.Ob = "none";
        this.Pb = "none";
        this.Qb = 0;
        this.Rb = 0;
        this.Sb = 1;
        this.Tb = false;
        this.Ub = -1;
        this.Vb = 0;
        this.Wb = "none";
        this.Xb = null;
        this.Yb = "none";
        this.Zb = 0;
        this.ac = -1;
        this.bc = -1.0f;
        this.cc = -1.0f;
        this.dc = 0;
        this.ec = 0;
        this.fc = -1;
        this.gc = -1;
        this.hc = 0L;
        this.ic = 1;
        this.kc = false;
        this.lc = 0L;
        this.mc = 0L;
        this.nc = 0L;
        this.oc = 0;
        this.pc = 0L;
        this.qc = 0L;
        this.rc = 0L;
        this.sc = 0L;
        this.tc = 0L;
        this.uc = 0L;
        this.vc = 0L;
        this.wc = 0L;
        this.xc = -1;
        this.yc = 0;
        this.zc = "none";
        this.Ac = 0L;
        this.Bc = 0L;
        this.Cc = 0L;
        this.Dc = 0L;
        this.Ec = 0L;
        this.Fc = 0L;
        this.Gc = 0L;
        this.Hc = 0L;
        this.Ic = 0L;
        this.Jc = 0L;
        this.Kc = 0L;
        this.Lc = 0L;
        this.Mc = 0L;
        this.Nc = 0L;
        this.Oc = 0L;
        this.Pc = 0L;
        this.Qc = 0L;
        this.Rc = 0L;
        this.Sc = 0L;
        this.Tc = 0L;
        this.Uc = 0L;
        this.Vc = 0L;
        this.Wc = 0L;
        this.Xc = 0L;
        this.Yc = 0L;
        this.Zc = 0L;
        this.ad = 0L;
        this.bd = 0L;
        this.cd = 0L;
        this.dd = 0L;
        this.ed = 0L;
        this.fd = 0L;
        this.gd = 0L;
        this.hd = 0L;
        this.id = 0L;
        this.jd = 0L;
        this.kd = 0L;
        this.ld = 0L;
        this.md = 0L;
        this.nd = 0L;
        this.od = 0L;
        this.pd = 0L;
        this.qd = 0L;
        this.rd = -1;
        this.sd = -1;
        this.td = -1;
        this.ud = 0L;
        this.vd = 0L;
        this.wd = 0L;
        this.xd = 0L;
        this.yd = 0L;
        this.zd = 0L;
        this.Ad = 0L;
        this.Bd = 0L;
        this.Cd = 0L;
        this.Dd = 0L;
        this.Ed = 0L;
        this.Fd = 0L;
        this.Gd = 0L;
        this.Hd = 0L;
        this.Id = 0L;
        this.Jd = 0L;
        this.Kd = 0L;
        this.Ld = 0L;
        this.Md = 0L;
        this.Od = 0;
        this.Pd = 0;
        this.Qd = 0;
        this.Rd = 0;
        this.Sd = "none";
        this.Td = 0L;
        this.Ud = 0L;
        this.Vd = "none";
        this.Wd = 0;
        this.Xd = 0L;
        this.Yd = 0;
        this.Zd = 0;
        this.ae = 0;
        this.be = 0;
        this.ce = "";
        this.de = "";
        this.ee = 0L;
        this.fe = 0;
        this.ge = 0L;
        this.he = 0L;
        this.ie = 0;
        this.je = 0;
        this.ke = 0L;
        this.le = 0L;
        this.f1042me = 0L;
        this.ne = 0L;
        this.oe = 4096;
        this.pe = MediaPlayer.MEDIA_PLAYER_OPTION_APPID;
        this.qe = "";
        this.re = "";
        this.se = 5000L;
        this.te = 0;
        this.ue = 0;
        this.ve = -1;
        this.we = null;
        this.xe = 0L;
        this.ye = new ArrayList<>();
        this.ze = 0L;
        this.Ae = 0L;
        this.Be = "none";
        this.Ce = -1.0f;
        this.De = 0;
        this.Ee = 0;
        this.Fe = 0;
        this.Ge = 0;
        this.He = 0;
        this.Ie = 0;
        this.Je = 0L;
        this.Ke = 0;
        this.Le = "none";
        this.Me = 0;
        this.Ne = "none";
        this.Oe = 0;
        this.Pe = 0;
        this.Qe = 0;
        this.Re = 0;
        this.Se = 0;
        this.Te = 0;
        this.Ue = "none";
        this.Ve = -1;
        this.We = "none";
        this.Xe = null;
        this.Ye = "none";
        this.Ze = "none";
        this.af = false;
        this.bf = 0;
        this.cf = 0;
        this.df = 0L;
        this.ef = 0L;
        this.ff = -998;
        this.gf = 0L;
        this.hf = 0;
        this.f1040if = 0;
        this.jf = 0;
        this.kf = "";
        this.lf = 0;
        this.mf = false;
        this.nf = 0;
        this.of = -1L;
        this.pf = null;
        this.qf = null;
        this.rf = null;
        this.sf = null;
        this.tf = null;
        this.uf = null;
        this.vf = null;
        this.wf = null;
        this.xf = 0;
        this.yf = -1;
        this.zf = null;
        this.Af = false;
        this.Bf = -1L;
        this.Cf = 0;
        this.Df = -1;
        this.Ef = "none";
        this.Ff = "none";
        this.Gf = 0;
        this.Hf = 0;
        this.If = 0L;
        this.Jf = -1;
        this.Kf = 0L;
        this.Lf = 0L;
        this.Mf = 0L;
        this.Nf = 0;
        this.Of = 0;
        this.Pf = 0L;
        this.Qf = 0L;
        this.Rf = 0L;
        this.Sf = 0L;
        this.Tf = 0L;
        this.Uf = 0L;
        this.Vf = 0L;
        this.Wf = 0L;
        this.Xf = 0L;
        this.Yf = 0;
        this.Zf = -1;
        this.ag = "none";
        this.bg = "none";
        this.cg = false;
        this.dg = new ArrayList();
        this.eg = 0;
        this.fg = 0;
        this.gg = 0;
        this.hg = 0;
        this.ig = 0;
        this.jg = -1.0f;
        this.kg = 0;
        this.lg = 0L;
        this.mg = 0L;
        this.ng = false;
        this.og = 0L;
        this.pg = 0L;
        this.qg = -1;
        this.rg = -1L;
        this.sg = -1L;
        this.tg = false;
        this.ug = 0;
        this.vg = 0L;
        this.wg = 0L;
        this.xg = 0L;
        this.yg = 0L;
        this.zg = 0L;
        this.Ag = 0L;
        this.Bg = 0L;
        this.Cg = new AtomicBoolean(false);
        this.Dg = new ArrayList<>();
        this.Eg = 10;
        this.Fg = 0;
        this.Gg = false;
        this.Hg = 0;
        this.Ig = -1;
        this.Jg = 0;
        this.Kg = "";
        this.Lg = -1.0f;
        this.Mg = -1.0f;
        this.Ng = -1;
        this.Og = "";
        this.Pg = "";
        this.Qg = -1;
        this.Rg = -1;
        this.Sg = "";
        this.Tg = "";
        this.Ug = -99;
        this.Vg = "";
        this.Wg = "";
        this.Xg = "";
        this.Yg = -1;
        this.Zg = new ArrayList<>();
        this.ah = "none";
        this.bh = 0L;
        this.ch = 0L;
        this.dh = -1L;
        this.eh = -1L;
        this.fh = -1L;
        this.gh = -1L;
        this.hh = 0L;
        this.ih = 0L;
        this.jh = 0L;
        this.kh = 0L;
        this.lh = 0L;
        this.mh = 0L;
        this.nh = -1;
        this.oh = 0L;
        this.ph = 0L;
        this.qh = 0;
        this.rh = 0L;
        this.sh = new LinkedBlockingQueue(7200);
        this.th = false;
        this.uh = "";
        this.vh = 0;
        this.wh = 0;
        this.xh = 0;
        this.yh = 0;
        this.zh = 0;
        this.Ah = 0;
        this.Bh = new ArrayList();
        this.b = context;
        this.c = new HandlerDelegate(this);
        if (j <= 0) {
            j3 = 60000;
        } else {
            j3 = j;
        }
        this.g = j3;
        this.d = iLiveListener;
        this.f = videoLiveManager;
        this.e = new d();
        org.apache.commons.net.ntp.a aVar = new org.apache.commons.net.ntp.a();
        this.i8 = aVar;
        aVar.c(10000);
        this.b8 = j2;
        com.ss.videoarch.liveplayer.log.a.c("LiveLoggerService", "enable report sessionstop: " + i);
        this.jc = new d();
        this.vb = new d();
        e0();
    }

    public void F1(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        JSONObject w = w();
        if (w != null) {
            try {
                w.put("event_key", "stall_counter").put("type", "video").put("render_stall_200_duration", j / 1000).put("render_stall_200_count", j % 1000).put("render_stall_300_duration", j2 / 1000).put("render_stall_300_count", j2 % 1000).put("render_stall_400_duration", j3 / 1000).put("render_stall_400_count", j3 % 1000).put("render_stall_500_duration", j4 / 1000).put("render_stall_500_count", j4 % 1000).put("demuxer_stall_500_duration", j5 / 1000).put("demuxer_stall_500_count", j5 % 1000).put("decode_pre_stall_500_duration", j6 / 1000).put("decode_pre_stall_500_count", j6 % 1000).put("decode_post_stall_500_duration", j7 / 1000).put("decode_post_stall_500_count", j7 % 1000);
                B0(w, "live_client_monitor_log");
                long j8 = this.h7;
                if (j8 > 0) {
                    this.h7 = j8 + 1;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x043b  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x043d  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private org.json.JSONObject z(fj6.d r21, long r22, long r24, long r26, long r28, boolean r30, long r31) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 1135
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: fj6.c.z(fj6.d, long, long, long, long, boolean, long):org.json.JSONObject");
    }
}
