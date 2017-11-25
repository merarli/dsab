/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg20171125;

import static pkg20171112.HashSearch.H;
import static pkg20171112.HashSearch.M;
import static pkg20171112.HashSearch.hash;

/**
 *
 * @author merarli
 */
/*
 * 「アルゴリズムとデータ構造」探索アルゴリズムの速度比較
 */
public class Search {

    // 入力サイズ (探索対象のデータ数)
    public static int n;
    // 線形探索、二分探索でデータを格納する配列 (探索対象のデータを格納)
    public static int[] D;
    // ハッシュ法での配列サイズ
    public static int M;
    // ハッシュ法でデータを格納する配列
    public static int[] H;
    // 探索の繰り返し回数
    public static int repeat = 10000;

    // 実行の種類
    public static enum RunType {
        Test, // テスト実行
        Time,   // 時間計測
    }

    // 検索方法の種類
    public static enum SearchType {
        Linear, // 線形探索
        Binary, // 二分探索
        Hash,       // ハッシュ探索
    }

    // 最初に呼ばれる関数
    public static void main(String[] args) {
        // [parameter] 実行の種類 (Test, Time)
        RunType runtype = RunType.Time;
        // [parameter] 検索方法の種類 (Linear, Binary, Hash)
        SearchType searchtype = SearchType.Hash;
        // [parameter] 探索対象のデータ数 (1000000, 5000000, 9000000)
        n = 119000000;
        System.out.println("n = " + n + "の結果");

        // データ構造の初期化
        if (searchtype == SearchType.Hash) {
            // ハッシュの配列を初期化
            M = 2 * n;		// 配列のサイズ
            H = new int[M];	// 配列の生成
            // -1 で初期化
            for (int i = 0; i < M; i++) {
                H[i] = -1;
            }
            // 値を挿入
            for (int i = 0; i < n; i++) {
                hashInsert(2 * i);
            }

        } else {
            // 線形探索、二分探索用の配列の初期化 (生成して値を格納)
            D = new int[n];	// 配列の生成
            // 値を挿入
            for (int i = 0; i < n; i++) {
                D[i] = 2 * i;
            }
        }

        if (runtype == RunType.Test) {
            // テスト実行
            switch (searchtype) {
                case Linear:
                    System.out.println("linearSearch(0) = " + linearSearch(0));
                    System.out.println("linearSearch(25) = " + linearSearch(25));
                    System.out.println("linearSearch(50) = " + linearSearch(50));
                    break;
                case Binary:
                    System.out.println("binarySearch(0) = " + binarySearch(0));
                    System.out.println("binarySearch(25) = " + binarySearch(25));
                    System.out.println("binarySearch(50) = " + binarySearch(50));
                    break;
                case Hash:
                    System.out.println("hashSearch(0) = " + hashSearch(0));
                    System.out.println("hashSearch(25) = " + hashSearch(25));
                    System.out.println("hashSearch(50) = " + hashSearch(50));
                    break;
            }

        } else {
            // 時間計測実行

            java.util.Random rand = new java.util.Random();

            // ストップウォッチの生成と開始
            StopWatch watch = new StopWatch();	// ストップウォッチの生成
            watch.start();                      // ストップウォッチの開始

            switch (searchtype) {
                case Linear:
                    for (int i = 0; i < repeat; i++) {
                        linearSearch(2 * getRand(rand, n));
                    }
                    break;
                case Binary:
                    for (int i = 0; i < repeat; i++) {
                        binarySearch(2 * getRand(rand, n));
                    }
                    break;
                case Hash:
                    for (int i = 0; i < repeat; i++) {
                        hashSearch(2 * getRand(rand, n));
                    }
                    break;
            }

            // ストップウォッチの終了と時間表示
            watch.stop();	// ストップウォッチの終了
            watch.printTime();	// ストップウォッチの経過時間を表示
        }
    }

    // サイズ n の配列 D において値 x を「線形探索」で探す。
    // 見つかったらそのインデックスを返す。なかったら -1 を返す。
    public static int linearSearch(int x) {
        // !!#
        // サイズ n の配列 D において値 x を「線形探索」で探す関数を実装せよ。
        // 見つかったらそのインデックスを返す。なかったら -1 を返すようにせよ。
        for (int i = 0; i < n; i++) {
            if (x == D[i]) {
                return i; // Found
            }
        }
        return -1; // Not found

    }

    // サイズ n の配列 D において値 x を「二分探索」で探す。
    // 見つかったらそのインデックスを返す。なかったら -1 を返す。
    public static int binarySearch(int x) {
        // !!#
        // サイズ n の配列 D において値 x を「二分探索」で探す関数を実装せよ。
        // 見つかったらそのインデックスを返す。なかったら -1 を返すようにせよ。

        int left = 0;
        int right = n - 1;
        int mid = 0;

        while (left < right) {
            mid = (left + right) / 2;

            if (D[mid] == x) {
                return mid;
            } else if (D[mid] < x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return -1;
    }

    // ハッシュ関数
    // 値 x のハッシュ値 (最初の格納場所) を返す
    public static int hash(int x) {
        // 配列サイズは M
        return x % M;
    }

    // サイズ m の配列 H に対して、値 x を格納する。
    public static void hashInsert(int x) {
        int k = hash(x);	// 最初の位置
        // 空の位置を探す
        while (H[k] >= 0) {
            k = (k + 1) % M;
        }
        H[k] = x;	// 格納
    }

    // サイズ M の配列 H に対して、値 x が格納されているかを探す。
    // あった場合はその位置、なかった場合は負を返す。
    public static int hashSearch(int x) {
        // !!#
        // サイズ M の配列 H に対して、値 x が格納されているかを探す関数を実装せよ。
        // あった場合はその位置、なかった場合は負を返すようにせよ。

        int k = hash(x);
        // !!#
        // サイズ M の配列 H に対して、値 x が格納されているかを探す関数を作成せよ。

        try {
            while (H[k] != -1) {

                if (k > M) {
                    break;
                }

                if (H[k] == x) {
                    return k;
                }
                k++;
            }

            return -1;
        } catch (ArrayIndexOutOfBoundsException e) {
            return -1;
        }
        // あった場合にはその値、なかった場合には -1 を返すようにせよ。

    }

    // 0 から n までの乱数を生成する。
    public static int getRand(java.util.Random rand, int n) {
        int r = rand.nextInt();
        if (r < 0) {
            r = -r;
        }
        return r % n;
    }
}
