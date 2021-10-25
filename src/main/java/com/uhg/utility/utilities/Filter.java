package com.uhg.utility.utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class Filter {
    // Filter by site and year
    public static ArrayList<Integer> FilterBy(String site, String year, ArrayList<HashMap<String, Object>> unfiltered_ist){
        int ma = 0, pdp = 0, mapd = 0, csnpSilver = 0, snp = 0, dsnp = 0, csnpStandard = 0;
        for(HashMap<String, Object> map : unfiltered_ist){
            String map_year = (String) map.get("PLAN_YEAR");
            String map_site = (String) map.get("SITE_ID");
            String map_type = (String) map.get("PLAN_TYPE");
            if(Objects.equals(map_year, year)){
                if(Objects.equals(map_site, site)){
                    if(Objects.equals(map_type, "MA")){
                        ma ++;
                    }
                    if(Objects.equals(map_type, "PDP")){
                        pdp ++;
                    }
                    if(Objects.equals(map_type, "MAPD")){
                        mapd ++;
                    }
                    if(Objects.equals(map_type, "CSNPSilver")){
                        csnpSilver ++;
                    }
                    if(Objects.equals(map_type, "SNP")){
                        snp ++;
                    }
                    if(Objects.equals(map_type, "DSNP")){
                        dsnp ++;
                    }
                    if(Objects.equals(map_type, "CSNPStandard")){
                        csnpStandard ++;
                    }
                }
            }
        }
        ArrayList<Integer> output = new ArrayList<>();
        output.add(ma);
        output.add(pdp);
        output.add(mapd);
        output.add(csnpSilver);
        output.add(snp);
        output.add(dsnp);
        output.add(csnpStandard);
        return output;
    }

    // Filter by status, site and year
    public static ArrayList<Integer> FilterBy(String status, String site, String year, ArrayList<HashMap<String, Object>> unfiltered_ist){
        int ma = 0, pdp = 0, mapd = 0, csnpSilver = 0, snp = 0, dsnp = 0, csnpStandard = 0;
        for(HashMap<String, Object> map : unfiltered_ist) {
            String map_year = (String) map.get("PLAN_YEAR");
            String map_site = (String) map.get("SITE_ID");
            String map_type = (String) map.get("PLAN_TYPE");
            String map_status = (String) map.get("OLE_APP_STATUS");
            if (Objects.equals(map_status, status)) {
                if (Objects.equals(map_year, year)) {
                    if (Objects.equals(map_site, site)) {
                        if (Objects.equals(map_type, "MA")) {
                            ma++;
                        }
                        if (Objects.equals(map_type, "PDP")) {
                            pdp++;
                        }
                        if (Objects.equals(map_type, "MAPD")) {
                            mapd++;
                        }
                        if (Objects.equals(map_type, "CSNPSilver")) {
                            csnpSilver++;
                        }
                        if (Objects.equals(map_type, "SNP")) {
                            snp++;
                        }
                        if (Objects.equals(map_type, "DSNP")) {
                            dsnp++;
                        }
                        if (Objects.equals(map_type, "CSNPStandard")) {
                            csnpStandard++;
                        }
                    }
                }
            }
        }
        ArrayList<Integer> output = new ArrayList<>();
        output.add(ma);
        output.add(pdp);
        output.add(mapd);
        output.add(csnpSilver);
        output.add(snp);
        output.add(dsnp);
        output.add(csnpStandard);
        return output;
    }

    public static ArrayList<HashMap<String, Object>> filterForTest(ArrayList<HashMap<String, Object>> unfiltered_list, ArrayList<Integer> indexes){
        ArrayList<HashMap<String, Object>> output = new ArrayList<>();
        String[] testNums = {};
        int count = 0;
        for(HashMap<String, Object> map : unfiltered_list){
            String medicare_number = map.get("MEDICARE_NUMBER").toString();
            if(indexes.contains(count)){
                indexes.remove(Integer.valueOf(count));
                count++;
                continue;
            }
            if(Arrays.asList(testNums).contains(medicare_number)){
                count++;
                continue;
            }
            output.add(map);
            count++;
        }
        return output;
    }
}
