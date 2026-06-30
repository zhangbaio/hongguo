#!/bin/bash
# P2 多进程签名池部署: 模板化双签名实例(9099/9100) + 9100外部封锁 + SIGN_SERVER轮询
# 幂等, 可重复执行。2核 → 2进程(签名CPU密集, 一进程一核)。
set -euo pipefail

echo "[1/5] iptables 封锁 9100 外部访问(仅 loopback)"
sudo iptables -C INPUT ! -i lo -p tcp --dport 9100 -j DROP 2>/dev/null \
  || sudo iptables -A INPUT ! -i lo -p tcp --dport 9100 -j DROP
( sudo netfilter-persistent save 2>/dev/null \
  || sudo bash -c 'mkdir -p /etc/iptables && iptables-save > /etc/iptables/rules.v4' ) || true

echo "[2/5] 写 systemd 模板 hongguo-sign@.service"
sudo tee /etc/systemd/system/hongguo-sign@.service >/dev/null <<'EOF'
[Unit]
Description=Hongguo offline sign (unidbg FqTrace) port %i
After=network.target
[Service]
Type=simple
User=ubuntu
WorkingDirectory=/www/hongguo-offline/unidbg-sign
ExecStart=/usr/bin/java -Xmx512m --add-opens java.base/java.lang=ALL-UNNAMED -cp /www/hongguo-offline/unidbg-sign/unidbg-sign.jar com.hongguo.sign.FqTrace serve %i
Restart=on-failure
RestartSec=5
[Install]
WantedBy=multi-user.target
EOF

echo "[3/5] 停旧单实例, 起 9099/9100 双实例"
sudo systemctl disable --now hongguo-sign 2>/dev/null || true
sudo systemctl daemon-reload
sudo systemctl enable --now hongguo-sign@9099 hongguo-sign@9100

echo "[4/5] 更新 hongguo-api 的 SIGN_SERVER 轮询"
sudo mkdir -p /etc/systemd/system/hongguo-api.service.d
sudo tee /etc/systemd/system/hongguo-api.service.d/signserver.conf >/dev/null <<'EOF'
[Service]
Environment=SIGN_SERVER=http://127.0.0.1:9099,http://127.0.0.1:9100
EOF
sudo systemctl daemon-reload
sudo systemctl restart hongguo-api

echo "[5/5] 等待双签名实例就绪"
for p in 9099 9100; do
  for i in $(seq 1 60); do
    if curl -s -o /dev/null -w '%{http_code}' --max-time 3 -X POST "http://127.0.0.1:$p/sign" \
        -H 'content-type: application/json' \
        -d '{"url":"https://api5-normal-sinfonlinea.fqnovel.com/reading/bookapi/search/tab/v?aid=8662","headers":{}}' \
        2>/dev/null | grep -q 200; then
      echo "  $p 就绪✓"; break
    fi
    sleep 1
  done
done
echo "部署完成。状态:"
systemctl is-active hongguo-sign@9099 hongguo-sign@9100 hongguo-api
