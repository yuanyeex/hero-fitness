package com.yuanyeex.herofitness.infa.fit;

import com.yuanyeex.herofitness.infra.fit.FitActivityParser;
import org.junit.jupiter.api.Test;

public class FitActivityParserTest {

    @Test
    public void testParser() {
        FitActivityParser parser = new FitActivityParser();
        parser.parse(FitActivityParser.class.getClassLoader().getResourceAsStream("fit_examples/test.fit"));
    }

}
