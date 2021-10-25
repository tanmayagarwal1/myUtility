package com.uhg.utility.builders;

import com.uhg.utility.builders.LevelTwoBuilder;
import com.uhg.utility.objects.Level_three.*;
import com.uhg.utility.objects.Level_two.DailyCount;
import com.uhg.utility.objects.Level_two.LevelTwo;
import com.uhg.utility.objects.Level_two.Ytd;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class LevelThreeBuilder {
    public static LevelThree build(String site, String type, ArrayList<HashMap<String, Object>> list) throws IOException {
        if(Objects.equals(type, "submissions")){ // list will be unfiltered (with test ole's)
            LevelTwo daily = LevelTwoBuilder.buildDailyCount(site, "current", null, list);
            Ytd ytd = LevelTwoBuilder.buildYtd(site, "current", (DailyCount) daily);
            return new OleSubmissions((DailyCount) daily, ytd);
        }
        if(Objects.equals(type, "success")){ //list will be filtered (without test ole)
            LevelTwo daily = LevelTwoBuilder.buildDailyCount(site,  "current", "S",list);
            Ytd ytd = LevelTwoBuilder.buildYtd(site, "current", (DailyCount) daily);
            return new OleSuccess((DailyCount) daily, ytd);
        }
        if (Objects.equals(type, "last_year")){ // list will be last year
            LevelTwo daily = LevelTwoBuilder.buildDailyCount(site, "previous", null,list);
            Ytd ytd = LevelTwoBuilder.buildYtd(site, "previous", (DailyCount) daily);
            return new OleLastYear((DailyCount) daily,  ytd);
        }
        if (Objects.equals(type, "failed")){ // list will be last year
            LevelTwo daily = LevelTwoBuilder.buildDailyCount(site, "current", "F",list);
            Ytd ytd = LevelTwoBuilder.buildYtd(site, "failed", (DailyCount) daily);
            return new FailedOle((DailyCount) daily,  ytd);
        }
        else{ // list will be for contain abandoned ole's with test filtered
            LevelTwo daily = LevelTwoBuilder.buildDailyCount(site, "current", "P", list);
            Ytd ytd = LevelTwoBuilder.buildYtd(site, "abandoned", (DailyCount) daily);
            return new FailedOle((DailyCount) daily,  ytd);

        }
    }
}
