package com.htc.vehicle.LogUtil;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogUtil {
	static Logger logger;
	public static Logger getLog(String name) throws SecurityException, IOException
	{
		logger=Logger.getLogger(name);
		FileHandler fh=new FileHandler("D:\\Employeelog.log", true);
		fh.setLevel(Level.INFO);
		fh.setFormatter(new SimpleFormatter());
		logger.addHandler(fh);
		
		return logger;
		
	}

}
