package com.uhg.utility.builders;

import com.uhg.utility.builders.LevelThreeBuilder;
import com.uhg.utility.objects.Level_four.Aarp;
import com.uhg.utility.objects.Level_four.Uhc;
import com.uhg.utility.objects.Level_four.Uhccp;
import com.uhg.utility.objects.Level_four.LevelFour;
import com.uhg.utility.objects.Level_three.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class LevelFourBuilder {
    public static LevelFour build(String site, ArrayList<HashMap<String, Object>> unfiltered, ArrayList<HashMap<String, Object>> filtered, ArrayList<HashMap<String, Object>> last_year) throws IOException {
        if(Objects.equals(site, "aarp")){
            LevelThree ole_submissions = LevelThreeBuilder.build("aarp", "submissions", unfiltered);
            LevelThree ole_success = LevelThreeBuilder.build("aarp", "success", filtered); // split at S
            LevelThree ole_last_year = LevelThreeBuilder.build("aarp", "last_year", last_year);
            LevelThree failed_ole = LevelThreeBuilder.build("aarp", "failed", filtered); // split at F
            LevelThree abandoned_ole = LevelThreeBuilder.build("aarp", "abandoned", filtered); // split at P or X
            return new Aarp((OleSubmissions) ole_submissions, (OleSuccess) ole_success, (OleLastYear) ole_last_year, (FailedOle) failed_ole, (AbandonedOle) abandoned_ole);
        }
        if(Objects.equals(site, "uhc")){
            LevelThree ole_submissions = LevelThreeBuilder.build("uhc", "submissions", unfiltered);
            LevelThree ole_success = LevelThreeBuilder.build("uhc", "success", filtered);
            LevelThree ole_last_year = LevelThreeBuilder.build("uhc", "last_year", last_year);
            LevelThree failed_ole = LevelThreeBuilder.build("uhc", "failed", filtered);
            LevelThree abandoned_ole = LevelThreeBuilder.build("uhc", "abandoned", filtered);
            return new Uhc((OleSubmissions) ole_submissions, (OleSuccess) ole_success, (OleLastYear) ole_last_year, (FailedOle) failed_ole, (AbandonedOle) abandoned_ole);
        }
        else{
            LevelThree ole_submissions = LevelThreeBuilder.build("uhccp", "submissions", unfiltered);
            LevelThree ole_success = LevelThreeBuilder.build("uhccp", "success", filtered);
            LevelThree ole_last_year = LevelThreeBuilder.build("uhccp", "last_year", last_year);
            LevelThree failed_ole = LevelThreeBuilder.build("uhccp", "failed", filtered);
            LevelThree abandoned_ole = LevelThreeBuilder.build("uhccp", "abandoned", filtered);
            return new Uhccp((OleSubmissions) ole_submissions, (OleSuccess) ole_success, (OleLastYear) ole_last_year, (FailedOle) failed_ole, (AbandonedOle) abandoned_ole);
        }
    }
}
