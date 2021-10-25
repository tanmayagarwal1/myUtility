package com.uhg.utility;

import com.uhg.utility.builders.LevelFiveBuilder;
import com.uhg.utility.executor.HttpExecutor;
import com.uhg.utility.executor.JdbcExecutor;
import com.uhg.utility.objects.Date;
import com.uhg.utility.objects.Level_five.LevelFive;
import com.uhg.utility.utilities.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

@RestController
public class Controller {
    @Autowired
    JdbcExecutor jdbcExecutor;

    @Autowired
    HttpExecutor httpExecutor;

    @RequestMapping(method = RequestMethod.POST, value = "/fetch")
    public ResponseEntity<Object> getAllObjects(@RequestBody Date date) throws ExecutionException, InterruptedException, URISyntaxException, IOException {
        HashMap<Integer, ArrayList<HashMap<String, Object>>> jdbcOutput = jdbcExecutor.getExecutionResult(date);
        ArrayList<HashMap<String, Object>> current_year = jdbcOutput.get(0);
        ArrayList<HashMap<String, Object>> previous_year = jdbcOutput.get(1);
        ArrayList<Integer> indexes_current_year = httpExecutor.getIndexes(current_year);
        ArrayList<Integer> indexes_previous_year = httpExecutor.getIndexes(previous_year);
        ArrayList<HashMap<String, Object>> filtered_list_current_year = Filter.filterForTest(current_year, indexes_current_year);
        ArrayList<HashMap<String, Object>> filtered_list_previous_year = Filter.filterForTest(previous_year, indexes_previous_year);
        LevelFive Ole = LevelFiveBuilder.build(current_year, filtered_list_current_year, filtered_list_previous_year);
        return new ResponseEntity<>(Ole, HttpStatus.OK);
    }
}
