import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void firstMarkdownTest() throws IOException {
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        assertEquals(List.of("https://something.com","some-thing.html"),
            MarkdownParse.getLinks(content));
    }
}