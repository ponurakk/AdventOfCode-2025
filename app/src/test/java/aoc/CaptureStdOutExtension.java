package aoc;

import org.junit.jupiter.api.extension.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CaptureStdOutExtension implements BeforeEachCallback, AfterTestExecutionCallback {

  private ByteArrayOutputStream outContent;
  private PrintStream originalOut;

  @Override
  public void beforeEach(ExtensionContext context) {
    originalOut = System.out;
    outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
  }

  @Override
  public void afterTestExecution(ExtensionContext context) {
    System.setOut(originalOut);
    if (context.getExecutionException().isPresent()) {
      System.out.println(outContent.toString());
    }
  }
}
