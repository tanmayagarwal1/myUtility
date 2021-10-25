package com.uhg.utility.executor;

import com.uhg.utility.service.HttpService;
import com.uhg.utility.utilities.FileHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.*;

@Service
public class HttpExecutor {
    public ArrayList<Integer> getIndexes(ArrayList<HashMap<String, Object>> unfiltered_list) throws IOException {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(41);
        Future<Integer> future;
        int idx = 0;
        for(HashMap<String, Object> map : unfiltered_list){
            Runnable worker = new HttpService(idx, map.get("OLE_DATA").toString());
            executor.execute(worker);
            idx ++;
        }
        return FileHelper.readFromFileExecutionResult();
    }
}
