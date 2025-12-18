import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 採点用テストクラス
 *
 * 【注意】
 * - 学生はこのファイルを編集してはいけません。
 *   （改変すると自動採点が正しく行われない可能性があります）
 * - ローカルテストでは、以下の「公開テストケース」だけが実行されます。
 *   実際の採点時は、「非公開テストケース」も実行されます。
 *   したがって、サンプル入力に合わせたハードコードでは点が取れません。
 */
class MainTest {

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

    
    // ===== 公開テストケース =====

    @Test
    void testSample1() throws Exception {
        assertEquals("8", runWithInput("3 5\n"));
    }

}
