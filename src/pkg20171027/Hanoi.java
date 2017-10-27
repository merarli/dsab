/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg20171027;

/**
 *
 * @author merarli
 */
/*
 * 「アルゴリズムとデータ構造」
 * ハノイの塔の問題を再帰的アルゴリズムで解く
 *  Hirohito Shibata (hshibata@stf.teu.ac.jp)
 */
public class Hanoi {

    // 入力サイズ (探索対象のデータ数)
    public static int n;

    // 関数呼び出しの詳細を表示するか否か
    static private boolean detail;

    // 最初に呼ばれる関数
    public static void main(String[] args) {
        // [parameter] 整数
        n = 9;
        // [parameter] 関数呼び出しの詳細表示
        detail = false;

        // n枚の円盤の問題を解く
        hanoi(n, 'A', 'B', 'C');
    }

    // 実行ステップ数
    static private int step = 0;

    // n番目の円盤を棒 from から棒 to へ移動する (その際、棒 buffer をバッファとして利用する)。
    static private void hanoi(int n, char from, char buffer, char to) {
        // 関数呼び出しの詳細
        if (detail) {

            for (int i = 0; i < n; i++) {
                System.out.print("  ");
            }

            System.out.println("hanoi(" + n + ", " + from + ", " + buffer + ", " + to + ")");
        }

        // !!#
        // n枚の円盤を棒 from から (棒 buffer をバッファとして利用して) 棒 to へ移動する関数を実装せよ。
        // ステップ数のカウントには、関数のすぐ上にある変数 step を利用せよ。
        // 参考までに
        // n 番目の円盤を棒 from から棒 to へ移動したことの報告 (結果表示) は、次のように記述すればよい。
        if (n > 0) {
            hanoi(n - 1, 'a', 'c', 'b');
            step++;
            System.out.println(step + ")move " + n + " from " + from + " to " + to);
            hanoi(n - 1, 'b', 'a', 'c');
        }
        System.out.println("ステップ数は：" + step);

    }
}
