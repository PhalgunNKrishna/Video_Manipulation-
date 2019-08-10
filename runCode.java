/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 *
 * @author charlesarellano
 */

/****************************
    *   Title: <How to Compile and Run Java Program from another Java Program>
    *   Author: <Pankaj>
    *   Date: <2018>
    *   Availability: <https://www.journaldev.com/937/compile-run-java-program-another-java-program>
    * 
    *   Modified to fit my requirements
    ****************************/
public class runCode {
    public runCode() {}

    public void compileRunCode(String startTime, String endTime, String fileName) {
        System.out.println("\nRUNNING:");
        try {
            System.out.println("**********");
            String command = ("ffmpeg -i " +  fileName + " -ss " + startTime + " -t " + endTime + " -async 1 cut.mp4");
            Process pro = Runtime.getRuntime().exec(command);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
