package com.uhg.utility.builders;

import com.uhg.utility.builders.LevelFourBuilder;
import com.uhg.utility.objects.Level_five.OleObject;
import com.uhg.utility.objects.Level_four.Aarp;
import com.uhg.utility.objects.Level_five.LevelFive;
import com.uhg.utility.objects.Level_four.Uhc;
import com.uhg.utility.objects.Level_four.Uhccp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class LevelFiveBuilder {
    public static LevelFive build(ArrayList<HashMap<String, Object>> unfiltered, ArrayList<HashMap<String, Object>> filtered, ArrayList<HashMap<String, Object>> last_year) throws IOException {
        Aarp aarp = (Aarp) LevelFourBuilder.build("aarp", unfiltered, filtered, last_year);
        Uhc uhc = (Uhc)LevelFourBuilder.build("uhc", unfiltered, filtered, last_year);
        Uhccp uhccp = (Uhccp)LevelFourBuilder.build("uhccp", unfiltered, filtered, last_year);
        return new OleObject(aarp, uhc, uhccp);
    }
}
