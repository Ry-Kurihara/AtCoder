# ABC_170 problemC in Scala

C問題に関するTips

mdファイルに数式を埋め込む簡単な方法しりたい
```math 
e^{i x} = \cos{x} + i \sin{x}
```

# Construction

C問題のテストケースb06.txtからTLEになってしまった。これを機にScalaでの標準入力方法を見直してみる。
このテストケースでは200,000程度の配列を標準入力で格納する必要がある。

# Experiments
Scalaの水色コーダーと緑色コーダーのコードを参考に標準入力の受け取り方の違いによる実行速度の違いを検証する。
検証する手法は3種類。

- myM. : 自分が今まで使ってたやつ
- grM. : 緑色コーダーの手法（FastScanner）
- lbM. : 水色コーダーの手法

詳細はソースコード参照のこと。受け取り方としては以下のような感じ

```
val sc = new FastScanner(System.in)
val n, m = sc.nextInt()
var k = sc.nextInt()
val a = Array.fill(n)(sc.nextLong())
val b = Array.fill(m)(sc.nextLong())

println(s"aの長さ${a.size}、bの長さ${b.size}")
```

a,bの2つの配列の長さの標準入力をし終えたら実行完了として時間を計測した。

# Environment
* scalaVersion     := "2.12.8"

# Result

- myM.
    - 195ms
- grM.
    - 000ms
- lbM.
    - 67ms

# Note

注意点などがあれば書く

# Author

* Ry-ku（liik）

# License
This project is under AtCoder(https://atcoder.jp/contests/nomura2020).