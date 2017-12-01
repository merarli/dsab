/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg20171201;

/**
 *
 * @author merarli
 */
public class Sort01 {

    // 実行の種類
    public static enum RunType {
        Test, // テスト実行
        Time,   // 時間計測
    }

    // ソート方法の種類
    public static enum SortType {
        Select, // 選択ソート
        Insert,     // 挿入ソート
    }

    // データの種類
    public static enum DataType {
        Shuffle, // シャッフルされたデータ集合
        AlmostSorted,   // ほとんどソート済のデータ集合
    }

    // 入力サイズ (探索対象のデータ数)
    public static int n;
    // 線形探索、二分探索でデータを格納する配列 (探索対象のデータを格納)
    public static int[] D;

    // 最初に呼ばれる関数
    public static void main(String[] args) {
        // [parameter] 実行の種類 (Test, Time)
        RunType runtype = RunType.Test;
        // [parameter] ソート方法の種類 (Select, Insert)
        SortType sorttype = SortType.Select;
        // [parameter] データの種類 (Shuffle, AlmostSorted)
        DataType datatype = DataType.AlmostSorted;
        // [parameter] データ数 (10000, 30000, 50000)
        n = 50000;

        if (runtype == RunType.Test) {
            n = 10;
        }

        // 配列の初期化
        D = new int[n];
        if (datatype == DataType.Shuffle) {
            // シャッフルした配列
            for (int i = 0; i < n; i++) {
                D[i] = (3 * i) % n;
            }
        } else {
            // ほとんど昇順に並んでいるデータ配列
            for (int i = 0; i < n; i++) {
                D[i] = i;
            }
            swap(D, 0, 1);	// 0番目と1番目のみを入れ替える
        }

        if (runtype == RunType.Test) {
            // テスト実行

            System.out.println(getString(D));  // ソート前の状態をプリント

            // ソート
            if (sorttype == SortType.Select) {
                selectSort(D);
            } else {
                insertSort(D);
            }

            System.out.print("--> ");
            System.out.println(getString(D));  // ソート後の状態をプリント

        } else {
            // 時間計測

            // ストップウォッチの生成と開始
            StopWatch watch = new StopWatch();	// ストップウォッチの生成
            watch.start();			// ストップウォッチの開始

            // ソート
            if (sorttype == SortType.Select) {
                selectSort(D);
            } else {
                insertSort(D);
            }

            // ストップウォッチの終了と時間表示
            watch.stop();	// ストップウォッチの終了
            watch.printTime();	// ストップウォッチの経過時間を表示
        }
    }

    // 配列 a を「選択ソート」でソートする。
    public static void selectSort(int[] a) {
        // !!#
        // 配列 a を「選択ソート」でソートするアルゴリズムを実装せよ。
        // 配列要素の入れ替えでは関数 swap() を利用せよ。

        for (int i = 0; i < a.length - 1; i++) {
            // 最小の要素を探す
            int min_index = i; // 最小の要素のインデックス
            for (int k = i + 1; k < a.length; k++) {
                //a[k] が a[min_index] より小さいなら min_index に k を代入
                if (a[k] < a[min_index]) {
                    min_index = k;
                }
            }
            // i番目の要素を最小のものに入れ替え
            swap(a, i, min_index);
        }
    }

    // 配列 a を「挿入ソート」でソートする。
    public static void insertSort(int[] a) {
        // !!#
        // 配列 a を「挿入ソート」でソートするアルゴリズムを実装せよ。
        for (int i = 1; i < a.length; i++) {
            int x = a[i]; // 挿入する要素
            // 挿入位置を探す
            int k = i;
            while (k > 0) {
                //a[k - 1] が x より大きいなら、a[k - 1] の値を a[k] に代入して、kを1減らす。
                //そうでないならループを抜ける。
                if (a[k - 1] > x) {
                    a[k] = a[k - 1];
                    k--;
                }else{
                    break;
                }
            }
            a[k] = x;

        }
    }
    // 配列 a の i 番目の要素と j 番目の要素を入れ替える。

    public static void swap(int[] a, int i, int j) {
        if (i != j) {
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
    }

    // 配列から文字列を生成して返す。
    public static String getString(int[] a) {
        String str = "{ ";
        for (int i = 0; i < a.length; i++) {
            if (i > 0) {
                str += ", ";
            }
            str += a[i];
        }
        str += " }";
        return str;
    }
}
