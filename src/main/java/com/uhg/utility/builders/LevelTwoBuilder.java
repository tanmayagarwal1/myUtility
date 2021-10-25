package com.uhg.utility.builders;

import com.uhg.utility.utilities.FileHelper;
import com.uhg.utility.utilities.Filter;
import com.uhg.utility.objects.Level_one.CurrentYear;
import com.uhg.utility.objects.Level_one.FutureYear;
import com.uhg.utility.objects.Level_two.DailyCount;
import com.uhg.utility.objects.Level_two.LevelTwo;
import com.uhg.utility.objects.Level_two.Ytd;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class LevelTwoBuilder {
    public static LevelTwo buildDailyCount(String site, String year, String status, ArrayList<HashMap<String, Object>> list){
        ArrayList<Integer> CurrentYear_list;
        ArrayList<Integer> FutureYear_list;
        if(Objects.equals(year, "current")) {
            if(status == null) {
                CurrentYear_list = Filter.FilterBy(site, "2021", list);
                FutureYear_list = Filter.FilterBy(site, "2022", list);
            }
            else{
                CurrentYear_list = Filter.FilterBy(status, site, "2021", list);
                FutureYear_list = Filter.FilterBy(status, site, "2022", list);
            }
            CurrentYear currentYear = new CurrentYear(CurrentYear_list.get(0), CurrentYear_list.get(1), CurrentYear_list.get(2), CurrentYear_list.get(3), CurrentYear_list.get(4), CurrentYear_list.get(5), CurrentYear_list.get(6)); // this list will be 2021
            FutureYear future_year = new FutureYear(FutureYear_list.get(0), FutureYear_list.get(1), FutureYear_list.get(2), FutureYear_list.get(3), FutureYear_list.get(4), FutureYear_list.get(5), FutureYear_list.get(6)); // this list will be 2022
            return new DailyCount(currentYear, future_year);
        }
        else{
            if(status == null) {
                CurrentYear_list = Filter.FilterBy(site, "2020", list);
                FutureYear_list = Filter.FilterBy(site, "2021", list);
            }
            else{
                CurrentYear_list = Filter.FilterBy(status, site, "2020", list);
                FutureYear_list = Filter.FilterBy(status, site, "2021", list);
            }
            CurrentYear currentYear = new CurrentYear(CurrentYear_list.get(0), CurrentYear_list.get(1), CurrentYear_list.get(2), CurrentYear_list.get(3), CurrentYear_list.get(4), CurrentYear_list.get(5), CurrentYear_list.get(6)); // this list will be 2021
            FutureYear future_year = new FutureYear(FutureYear_list.get(0), FutureYear_list.get(1), FutureYear_list.get(2), FutureYear_list.get(3), FutureYear_list.get(4), FutureYear_list.get(5), FutureYear_list.get(6)); // this list will be 2022
            return new DailyCount(currentYear, future_year);
        }
    }

    // here possible year values : current, previous, failed
    public static Ytd buildYtd(String site, String year, DailyCount daily) throws IOException {
        ArrayList<Integer> ytd_nums = FileHelper.readFromFileForYtd(site, year);
        int MA_ytd = ytd_nums.get(0) + daily.getCurrent_year().getMA() + daily.getFuture_year().getMA();
        int PDP_ytd = ytd_nums.get(1) + daily.getCurrent_year().getPDP() + daily.getFuture_year().getPDP();
        int MAPD_ytd = ytd_nums.get(2) + daily.getCurrent_year().getMAPD() + daily.getFuture_year().getMAPD();
        int CSNPSilver_ytd = ytd_nums.get(3) + daily.getCurrent_year().getCSNPSilver() + daily.getFuture_year().getCSNPSilver();
        int SNP_ytd = ytd_nums.get(4) + daily.getCurrent_year().getSNP() + daily.getFuture_year().getSNP();
        int DSNP_ytd = ytd_nums.get(0) + daily.getCurrent_year().getDSNP() + daily.getFuture_year().getDSNP();
        int CSNPStandard_ytd = ytd_nums.get(0) + daily.getCurrent_year().getCSNPStandard() + daily.getFuture_year().getCSNPStandard();
        CurrentYear currentYear = new CurrentYear(MA_ytd, PDP_ytd, MAPD_ytd, CSNPSilver_ytd, SNP_ytd, DSNP_ytd, CSNPStandard_ytd);
        return new Ytd(currentYear);
    }
}
