# mysetting
個人用の設定メモです。

### キーマップ変更について  

```
$ xev 
```

キーボードの入力から実行されるコードを把握する。

```
$ xmodmap -pke
```

現在設定されているキーコードをすべて表示する。

```
$ xmodmap
```

現在設定されている特殊コマンドをすべて表示する。

上記確認後、ホームディレクトリに.Xmodmapを置き

```
$ xmodmap .Xmodmap
```

で実行する。毎回ログインで実行するには、スタートアップで上記コマンドを設定。


### vimプラグインについて
NeoBundleのvimプラグイン管理パッケージを用いる。

- NeoBundleのインストール(gitが必要）

```
$ curl https://raw.githubusercontent.com/Shougo/neobundle.vim/master/bin/install.sh | sh
```

上記後、.vimrcをホームディレクトリに置く。
