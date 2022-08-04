# TeamKUNServerUtils

### FEATURES

- ops.jsonの初期化機能
- LuckPerms導入時
    - reload confirm防止
    - WE権限付与コマンドのショートカット

### COMMAND

- ksu
    - op
        - init - ops.jsonを初期化
- gw [player] - 対象にlpのWE権限を付与 (/lp user [player] parent add we のショートカット)

### CONFIG

- OPSDownloadURL : ops.jsonの取得先URL (default: " ")
- enableOPSInitializer : ops.jsonの初期化機能の有効/無効 (default: true)
- enableAutoOPSInitialize : ops.jsonの自動初期化機能の有効/無効 (default: true)
- WEPermissionName : LPのWE権限の権限名 (default: we)
- enableReloadGuard (default: true)