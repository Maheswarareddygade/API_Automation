package com.digisight.platform.utility;

import java.net.MalformedURLException;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class UiLogger {

  /** The underlying Logger. */
  private final Logger _logger;


  private static final String LOG4J_PROPERTIES = "/log4j.properties";
  private UiLogger(Logger logger) {
  _logger = logger;
  }

  private static final ConcurrentHashMap<Logger, UiLogger> _loggers = new ConcurrentHashMap<Logger, UiLogger>();

  static {
    try {
		initLog4j();
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }

  // Factory methods
  public static UiLogger getLogger(Class<?> clazz) {
    Logger logger = Logger.getLogger(clazz);
    return getLogger(logger);
  }

  public static UiLogger getLogger(String name) {
    Logger logger = Logger.getLogger(name);
    return getLogger(logger);
  }

  private static void initLog4j() throws MalformedURLException {
    try {
      PropertyConfigurator.configure(FileUtils.getResourcePath(LOG4J_PROPERTIES, true, false));
    } catch (UtilsException e) {
      throw new BaseRuntimeException("Error configuring log4j: " + e.getMessage());
    }
  }

  private static UiLogger getLogger(Logger logger) {
	  UiLogger ret = _loggers.get(logger);
    if (ret == null) {
      _loggers.put(logger, new UiLogger(logger));
      ret = _loggers.get(logger);
    }
    return ret;
  }

  public static UiLogger getRootUitfLogger() {
    Logger logger = Logger.getRootLogger();
    return getLogger(logger);
  }

  /**
   * Set the level of this Category.
   * If you are passing any of Level.DEBUG, Level.INFO, Level.WARN, Level.ERROR, Level.FATAL as a parameter,
   * you need to case them as Level.
   *
   * @param level
   */
  public void setLevel(Level level) {
    try {
      _logger.setLevel(level);
    } catch (NoSuchMethodError e) {
      // ignore this exception, since sbt-infrastructure blocks using log4j and requires log4j-over-slf4j
      // which might not have this method implemented (which if it is available, is just a no-op anyway)
    }
  }

  /**
   * Check whether this category is enabled for a given Level passed as parameter
   *
   * @param level
   * @return   boolean True if this category is enabled for level.
   */
  public boolean isEnabledFor(Level level) {
    return _logger.isEnabledFor(level);
  }


  /**
   * Returns the assigned Level, if any, for this Category.
   * @return   Returns the assigned Level
   */
  public Level getLevel() {
    return _logger.getLevel();
  }

  /**
   * Log a message object with the INFO level.
   *
   * @param message - the message object to log.
   */
  public void info(Object message) {
    _logger.info(message, null);
  }

  /**
   * Logs a message object with the INFO level including the stack trace of the Throwable t passed as parameter.
   *
   * @param message      the message object to log.
   * @param throwable    the exception to log, including its stack trace.
   */
  public void info(Object message, Throwable throwable) {
    _logger.info(message, throwable);
  }

  /**
   * Log a message object with the DEBUG level.
   *
   * @param message  the message object to log.
   */
  public void debug(Object message) {
    _logger.debug(message, null);
  }

  /**
   * Log a message object with the DEBUG level including the stack trace of the Throwable t passed as parameter.
   *
   * @param message    the message object to log.
   * @param throwable  the exception to log, including its stack trace.
   */
  public void debug(Object message, Throwable throwable) {
    _logger.debug(message, throwable);
  }

  public boolean isInfoEnabled() {
    return _logger.isEnabledFor(Level.INFO);
  }


  /**
   * Log a message object with the WARN level.
   *
   * @param message  the message object to log.
   */
  public void warn(Object message) {
    _logger.warn(message, null);
  }

  /**
   * Log a message object with the WARN level including the stack trace of the Throwable t passed as parameter.
   *
   * @param message    the message object to log.
   * @param throwable  the exception to log, including its stack trace.
   */
  public void warn(Object message, Throwable throwable) {
    _logger.warn(message, throwable);
  }


  /**
   * Log a message object with the ERROR level.
   *
   * @param message  the message object to log.
   */
  public void error(Object message) {
    _logger.error(message, null);
  }

  /**
   * Log a message object with the ERROR level including the stack trace of the Throwable t passed as parameter.
   *
   * @param message    the message object to log.
   * @param throwable  the exception to log, including its stack trace.
   */
  public void error(Object message, Throwable throwable) {
    _logger.error(message, throwable);
  }


  /**
   * Log a message object with the FATAL level.
   *
   * @param message  the message object to log.
   */
  public void fatal(Object message) {
    _logger.fatal(message, null);
  }


  /**
   * Log a message object with the FATAL level including the stack trace of the Throwable t passed as parameter.
   *
   * @param message    the message object to log.
   * @param throwable  the exception to log, including its stack trace.
   */
  public void fatal(Object message, Throwable throwable) {
    _logger.fatal(message, throwable);
  }
  

}
