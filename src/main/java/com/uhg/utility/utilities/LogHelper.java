package com.uhg.utility.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogHelper {
    public Logger logger;
    public static LogHelper LogHelperObj;

    public LogHelper() {
        logger = LoggerFactory.getLogger(LogHelper.class);
    }
    public static LogHelper getLogger(){
        if(LogHelperObj == null){
            LogHelperObj = new LogHelper();
        }
        return LogHelperObj;
    }

}
