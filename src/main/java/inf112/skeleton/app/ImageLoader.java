package inf112.skeleton.app;

import javafx.scene.image.Image;

import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author anya
 */


public class ImageLoader {
	/**
	 * loads image into dictionary to keep it in memory
	 * @param fileName
	 * @return image
	 */
	private final static Map<String, Image> images = new HashMap<>();
	private final static List<String> imagePath = Arrays.asList("", "images/");

	public static Image getImage(String fileName) {
		Image img = images.get(fileName);

		if (img != null) {
			return img;
		}

		for (String p : imagePath) {
			img = tryLoadImage(p + fileName);
			if (img != null) {
				break;
			}
		}

		if (img == null) // fallback
			img = new Image(fileName);
		
		images.put(fileName, img);
		
		return img;
	}

	private static Image tryLoadImage(String pathName) {
		InputStream stream = ImageLoader.class.getResourceAsStream(pathName);
		if (stream == null)
			return null;
		else
			return new Image(stream);
	}
}
