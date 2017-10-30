package com.digisight.platform.utility;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;

/**
 * @author Mahesh Reddy
 * Created Date: 24-10-07
 * 
 * 
 * @modified by 
 * This class provides file and path utilities.
 */


public class FileUtils extends org.apache.commons.io.FileUtils {

	
	private static Logger _logger = Logger.getLogger(FileUtils.class);

	
	private FileUtils() {
	}

	/**
	 * Get the directory location for a given class.
	 *
	 * @param clazz
	 *            Class to get the directory location from
	 * @return Directory location for the given class
	 */
	public static <T> String getDirectoryOfClass(Class<T> clazz) {
		File file = new File(clazz.getProtectionDomain().getCodeSource().getLocation().getFile());
		return file.getAbsolutePath();
	}

	/**
	 * Convenience method for deleting a file. Keeps file based functions in one
	 * class. Just calls File.delete().
	 *
	 * @param file
	 *            File to delete
	 * @return true if the file was successfully deleted
	 */
	public static boolean deleteFile(File file) {
		return file.delete();
	}

	/**
	 * Get the file path for a given resource.
	 *
	 * @param resourceName
	 *            Name of resource
	 * @return Absolute path for the given resource
	 * @throws UtilsException
	 *             Error getting path for the given resource
	 * @throws MalformedURLException 
	 */
	public static String getResourcePath(String resourceName) throws UtilsException, MalformedURLException {
		return getResourcePath(resourceName, false, false);
	}

	/**
	 * Get the file path for a given resource.
	 *
	 * @param resourceName
	 *            Name of resource
	 * @param extractFromJar
	 *            If true, extract the resource to a temporary file
	 * @param setExecutable
	 *            If true, set the extracted file to be executable
	 * @return Absolute path for the given resource
	 * @throws UtilsException
	 *             Error getting path for the given resource
	 * @throws MalformedURLException 
	 */
	public static String getResourcePath(String resourceName, boolean extractFromJar, boolean setExecutable)
			throws UtilsException, MalformedURLException {
		URL location = getUrlForResource(resourceName);
		if (location == null) {
			throw new UtilsException("Resource not found: " + resourceName);
		}
		try {
			File file;
			if (extractFromJar && location.getProtocol().equals("jar")) {
				int index = resourceName.lastIndexOf("/");
				String suffix = index != -1 ? resourceName.substring(index + 1) : resourceName;
				file = copyUrlToTempFile(location, "resource", suffix);
				if (setExecutable) {
					file.setExecutable(true);
				}
			} else {
				file = new File(location.toURI());
			}
			return file.getAbsolutePath();
		} catch (URISyntaxException e) {
			throw new UtilsException("Error getting resource path: " + e.getMessage());
		}
	}

	public static URL getUrlForResource(String filename) throws MalformedURLException {
		return getUrlForResource(filename, FileUtils.class);
	}

	@SuppressWarnings("deprecation")
	public static URL getUrlForResource(String filename, Class<?> requestingClass) throws MalformedURLException {

		// is it a filesystem path?
		File file = new File(filename);
		if (file.exists()) {
			return file.toURL();
		}

		URI uri;
		try {
			uri = new URI(filename);
		} catch (URISyntaxException e) {
			return requestingClass.getResource(filename);
		}
		_logger.info(uri);
		if (uri.getScheme() == null)
			return requestingClass.getResource(filename);

		return getUrlForResource(uri, requestingClass);
	}

	public static URL getUrlForResource(URI uri, Class<?> requestingClass) throws MalformedURLException {
		if ("classpath".equals(uri.getScheme())) {
			return requestingClass.getResource(uri.getPath());
		} else
			return uri.toURL();
	}

	/**
	 * Get the file path to a resource by inspecting the classpath.
	 *
	 * @param resourceName
	 *            Name of resource (e.g., jar file)
	 * @return File path to the resource, null if not found
	 */
	public static String getResourcePathFromClasspath(String resourceName) {
		String classPath = System.getProperty("java.class.path");
		for (String path : classPath.split(":")) {
			if (path.endsWith(resourceName)) {
				return path;
			}
		}
		return null;
	}

	/**
	 * Normalize a path. Removes "." and ".." steps and expands "^~/" into the
	 * user's home directory
	 *
	 * @param path
	 *            Path to be normalized
	 * @return Normalized path
	 */
	public static String normalizePath(String path) {
		if (path.startsWith("~/")) {
			path = path.replaceFirst("^~/", getUserDirectoryPath() + "/");
		}
		return FilenameUtils.normalize(new File(path).getAbsolutePath());
	}

	private static File copyUrlToTempFile(URL url, String prefix, String suffix) throws UtilsException {
		try {
			File file = File.createTempFile(prefix, suffix);
			file.deleteOnExit();
			copyURLToFile(url, file);
			return file;
		} catch (IOException e) {
			throw new UtilsException("Error copying URL to temporary file: " + e.getMessage());
		}
	}

	/**
	 * Appends First file data to end of second file.
	 *
	 * @param File
	 *            Target file
	 * @param File
	 *            Master file
	 * @exception IOException
	 * @exception InterruptedException
	 */
	public static void mergeFiles(String targetFile, String mergeFile) throws IOException, InterruptedException {
		File targetPath = new File(targetFile);
		File mergePath = new File(mergeFile);
		BufferedWriter bufferWritter = new BufferedWriter(new FileWriter(mergePath, true));
		BufferedReader bufferReader = new BufferedReader(new FileReader(targetPath));
		try {
			String lineData;
			while ((lineData = bufferReader.readLine()) != null) {
				bufferWritter.write(lineData);
				bufferWritter.newLine();
				bufferWritter.flush();
			}
		} catch (IOException e) {
			throw new IOException("Unable to merge files" + e.getMessage());
		} finally {
			bufferWritter.close();
			bufferReader.close();
		}
	}

}
