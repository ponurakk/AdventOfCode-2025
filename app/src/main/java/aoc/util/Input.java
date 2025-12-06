package aoc.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public final class Input {

  private Input() {
  }

  public static List<String> read(int day) throws IOException {
    String name = String.format("day%02d/data.txt", day);
    var url = Input.class.getClassLoader().getResource(name);
    if (url == null)
      throw new IOException("Resource not found: " + name);

    return Files.readAllLines(Path.of(url.getPath()));
  }
}
