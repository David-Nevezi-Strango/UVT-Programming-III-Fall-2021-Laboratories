package Laboratory8;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class ExtensionFilterer extends SimpleFileVisitor<Path> {
	private PathMatcher pm;

	List<Path> filteredPaths;

	public ExtensionFilterer(String extension) {
		super();

		FileSystem fs = FileSystems.getDefault();
		this.pm = fs.getPathMatcher("regex:.*\\." + extension);

		this.filteredPaths = new ArrayList<Path>();
	}

	public FileVisitResult visitFile(Path file, BasicFileAttributes bfa) {
		if (this.pm.matches(file))
			filteredPaths.add(file);
		return FileVisitResult.CONTINUE;
	}
}
