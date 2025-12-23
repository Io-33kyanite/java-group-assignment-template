import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * テストクラス（テストの活用は任意であり、課題の評価には影響しません）
 *
 * 【ヒント】
 * - 必要に応じて、テストケースを追加・修正してください。
 * - 課題の評価にあたって、テストの有無や通過状況は考慮されません。
 * - ただしテストコード作成をメンバーの役割として位置付けることは可能です。
 * - .github/workflows/auto-test.yml により、リポジトリをプッシュするたびにGitHub上で自動テストが実行されるようにしています。
 * - ローカル環境でJUnitテストを実行することも可能です。
 */
class MainTest {

    // 標準入力を与えて標準出力を取得するユーティリティメソッド
    private String runWithInput(String input) throws Exception {
        InputStream oldIn = System.in;
        PrintStream oldOut = System.out;
        try {
            ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            System.setIn(in);
            System.setOut(new PrintStream(out, true, StandardCharsets.UTF_8));
            Main.main(new String[0]);
            return out.toString(StandardCharsets.UTF_8).trim();
        } finally {
            System.setIn(oldIn);
            System.setOut(oldOut);
        }
    }

    
    // ===== テストケース =====

    @Test
    void testSample() throws Exception {
        // 標準入力を与えて標準出力を検証する例
        assertEquals("8", runWithInput("3 5\n"));
    }

    @Test
    void testMyMethod() throws Exception {
        // 直接メソッドをテストする場合の例
        // assertEquals("ExpectedOutput", Main.myMethod("Input"));
    }

}
