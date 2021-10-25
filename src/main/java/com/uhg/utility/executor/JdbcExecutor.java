package com.uhg.utility.executor;

import com.uhg.utility.objects.Date;
import com.uhg.utility.service.JdbcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

@Service
public class JdbcExecutor {
    @Autowired
    JdbcService service;

    public HashMap<Integer, ArrayList<HashMap<String, Object>>> getExecutionResult(Date date) throws ExecutionException, InterruptedException {
        ArrayList<String> curr_list = new ArrayList<>();
        ArrayList<String> prev_list = new ArrayList<>();
        HashMap<Integer, ArrayList<String>> map = new HashMap<>();
        curr_list.add("current");
        curr_list.add(date.getDate()+" 00:00:00");
        prev_list.add("previous");
        prev_list.add(date.getLast_year_date()+" 05:00:00");
        map.put(0, curr_list);
        map.put(1, prev_list);
        HashMap<Integer, ArrayList<HashMap<String, Object>>> res = executeJdbc(map);
        return res;

    }
    public HashMap<Integer, ArrayList<HashMap<String, Object>>> executeJdbc(HashMap<Integer, ArrayList<String>> inpMap) throws ExecutionException, InterruptedException {
        HashMap<Integer, ArrayList<HashMap<String, Object>>> output = new HashMap<>();
        HashMap<Integer, ArrayList<HashMap<String, Object>>> input;
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        Future<HashMap<Integer, ArrayList<HashMap<String, Object>>>> future;
        for(Map.Entry<Integer, ArrayList<String>> entry : inpMap.entrySet()){
            Integer key = entry.getKey();
            ArrayList<String> inpVals = entry.getValue();
            future =executor.submit(service.newCallable(key, inpVals.get(0), inpVals.get(1)));
            input = future.get();
            output.put(key, input.get(key));
        }
        return output;
    }

}
