package com.uhg.utility.utilities;

import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class FileHelper {
    static String ytdPath = "src/main/resources/ytd/";
    static String httpCallResultPath = "src/main/resources/result.txt";

    public static ArrayList<Integer> readFromFileForYtd(String fileName, String type) throws IOException {
        ClassPathResource resource;
        if(Objects.equals(type, "previous")) {
            resource = new ClassPathResource(ytdPath +fileName+ "_last_year.txt");
        }
        else if(Objects.equals(type, "failed")){
            resource = new ClassPathResource(ytdPath +fileName+ "_failed.txt");
        }
        else if(Objects.equals(type, "abandoned")){
            resource = new ClassPathResource(ytdPath +fileName+ "_abandoned.txt");
        }
        else {
            resource = new ClassPathResource(ytdPath +fileName+ ".txt");
        }
        File file = new File(resource.getPath());
        ArrayList<Integer> output = new ArrayList<>();
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line = br.readLine()) != null){
            output.add(Integer.valueOf(line));
        }
        br.close();
        return output;
    }

    public static void WriteToFileForYtd(String fileName, Boolean isPreviousYear, ArrayList<Integer> new_ytd_nums) throws IOException {
        ClassPathResource resource;
        if(isPreviousYear) {
            resource = new ClassPathResource(ytdPath +fileName+ "_last_year.txt");
        }
        else{
            resource = new ClassPathResource(ytdPath +fileName+ ".txt");
        }
        FileWriter writer = new FileWriter(resource.getPath());
        for(Integer num : new_ytd_nums){
            writer.write(num+System.lineSeparator());
        }
        writer.close();
    }

    public static void writeToFileForExecution(String sti) throws IOException {
        ClassPathResource res = new ClassPathResource("/src/main/resources/ytd/res.txt");
        FileWriter writer = new FileWriter(res.getPath(), true);
        writer.write(sti + System.lineSeparator());
        writer.close();
    }

    public static ArrayList<Integer> readFromFileExecutionResult() throws IOException {
        ClassPathResource res = new ClassPathResource("/src/main/resources/ytd/res.txt");
        File file = new File(res.getPath());
        ArrayList<Integer> output = new ArrayList<>();
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line = br.readLine()) != null){
            output.add(Integer.valueOf(line));
        }
        return output;
    }
}
