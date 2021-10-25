package com.uhg.utility.service;

import com.uhg.utility.utilities.MyMapper;
import com.uhg.utility.utilities.LogHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.Callable;

public class JdbcService {
    @Autowired
    @Qualifier("jdbcTemplate1")
    JdbcTemplate jdbcTemplate;

    LogHelper logHelper = LogHelper.getLogger();

    public Callable<HashMap<Integer, ArrayList<HashMap<String, Object>>>> newCallable(int idx, String year, String date){
        return new Callable<HashMap<Integer, ArrayList<HashMap<String, Object>>>>() {
            @Override
            public HashMap<Integer, ArrayList<HashMap<String, Object>>> call() throws Exception {
                HashMap<Integer, ArrayList<HashMap<String, Object>>> map = new HashMap<>();
                logHelper.logger.info("Starting query {}", idx);
                String query;
                if(Objects.equals(year, "current")) {
                    query = "SELECT {site, plan_type, status, ole_data, plan_year} with no Ole_status condition";
                }
                else{
                    query = "SELECT (site, plan_type, plan_year, Ole_data) with status condition";
                }
                ArrayList<HashMap<String, Object>> list = new ArrayList<>(jdbcTemplate.query(query, new MyMapper()));
                map.put(idx, list);
                return  map;
            }
        };
    }
}
