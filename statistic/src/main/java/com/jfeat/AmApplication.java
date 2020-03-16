package com.jfeat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.SQLException;

/**
 * SpringBoot方式启动类
 *
 * @author Admin
 * @Date 2017/5/21 12:06
 */
@SpringBootApplication
@EnableScheduling
public class AmApplication implements CommandLineRunner {

    protected final static Logger logger = LoggerFactory.getLogger(AmApplication.class);

    @Override
    public void run(String... strings) throws Exception {
    }

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(AmApplication.class, args);
        logger.info("Statistic Statement is success!");




        /**
         * find jar file
         */
        String LOCATION = "";
        String URLLOCATION = "";
        try {
            LOCATION =com.jfeat.am.core.jwt.JWTKit.class.getProtectionDomain().getCodeSource().getLocation().getFile();
            URLLOCATION =  URLDecoder.decode(LOCATION, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.info( "error:");
            logger.info( ""+e);
        }
        logger.info( "** loc=" + LOCATION + "; URLLoc=" + URLLOCATION);
        logger.info( "** loc=" + LOCATION + "; URLLoc=" + URLLOCATION);
        logger.info( "** loc=" + LOCATION + "; URLLoc=" + URLLOCATION);

    }
}
