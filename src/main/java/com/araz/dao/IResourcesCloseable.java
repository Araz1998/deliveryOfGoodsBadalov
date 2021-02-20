package com.araz.dao;

import com.araz.util.ApplicationExeption;
import org.apache.log4j.Logger;

public interface IResourcesCloseable {
    Logger logger = Logger.getLogger(IResourcesCloseable.class);
    
    default void close(AutoCloseable... objects) {
        for (AutoCloseable object : objects) {
            if (object != null) {
                try {
                    object.close();
                } catch (Exception e) {
                    try {
                        throw new ApplicationExeption("Cannot close " + object);
                    } catch (ApplicationExeption applicationExeption) {
                        logger.error("Cannot close " + object);
                    }
                }
            }
        }
    }
}
