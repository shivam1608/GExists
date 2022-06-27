/*
 * @author shivzee
 * based on https://blog.0day.rocks/abusing-gmail-to-get-previously-unlisted-e-mail-addresses-41544b62b2
 * Java Implementation
 * Based on both Asynchronous / Synchronous methods
 * 2022
 */


package me.shivzee;


import me.shivzee.helper.ResponseCallback;
import me.shivzee.helper.Username;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class GExists {

    private ThreadPoolExecutor executor;
    private final boolean useExecutor;

    /**
     * Default Settings
     */
    public GExists(){
        this.useExecutor = false;
    }

    /**
     * Advanced options (useExecutor Java8+) uses executorService
     * @param useExecutor value true/flase
     */
    public GExists(boolean useExecutor){
        executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        this.useExecutor = true;
    }

    /**
     * Checks if gmail exists or not
     * @param gmail the gmail string to check
     * @return true/false according to existence
     */
    private boolean checkExists(String gmail){
        try{
            HttpURLConnection connection = (HttpURLConnection)
                    new URL("https://mail.google.com/mail/gxlu?email="+gmail)
                            .openConnection();
            connection.setRequestMethod("GET");

            return connection.getHeaderField("Set-Cookie") != null;

        }catch (Exception e){
            System.out.println("Exception Caught : "+e);
        }
        return false;
    }


    /**
     * Checks for username synchronous
     * @param username username object to check
     * @return true/false as per response
     */
    public boolean exists(Username username){
        return checkExists(username.getGmail());
    }


    /**
     * Checks for username synchronous
     * @param username username object to check
     * @return true/false as per response
     */
    public boolean exists(String username){
        return exists(new Username(username));
    }


    /**
     * Checks for username asynchronous
     * @param username username object to check
     * @param callback callback
     */
    public void exists(Username username , ResponseCallback callback){
        if(useExecutor){
            executor.submit(()-> callback.onCheck(exists(username)));
            return;
        }
        new Thread(()-> callback.onCheck(exists(username))).start();
    }

    /**
     * Checks for username asynchronous
     * @param username username object to check
     * @param callback callback
     */
    public void exists(String username , ResponseCallback callback){
        exists(new Username(username) , callback);
    }

    /**
     * Shutdowns the executor if using executor (useExecutor = true)
     */
    public void exit(){
        executor.shutdown();
    }

}
