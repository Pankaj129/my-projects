package utilities;

import java.io.*;

public final class FileUtil {

	private FileUtil() {
		// Prevent instantiation
	}

	/**
	 * Saves any serializable object to a file.
	 */
	public static <T extends Serializable> void save(String fileName, T object) {

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {

			oos.writeObject(object);

			System.out.println(fileName + " saved successfully.");

		} catch (IOException e) {

			System.out.println("Failed to save " + fileName);
			e.printStackTrace();
		}
	}

	/**
	 * Loads any serialized object from a file.
	 */
	@SuppressWarnings("unchecked")
	public static <T> T load(String fileName) {

		File file = new File(fileName);

		if (!file.exists()) {
			return null;
		}

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {

			return (T) ois.readObject();

		} catch (IOException | ClassNotFoundException e) {

			System.out.println("Failed to load " + fileName);
			e.printStackTrace();
		}

		return null;
	}
}
