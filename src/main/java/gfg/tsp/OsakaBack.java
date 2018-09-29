package gfg.tsp;

import gfg.tsp.readData.GroupIntervalScore;
import gfg.tsp.readData.OsakaData;
import gfg.tsp.readData.OsakaGraph;

public class OsakaBack {
    int budget;
    //29
    int n;
    double[][] cost;
    int[] visit;
    int[] category;
    public void initOsaka( GroupIntervalScore group){
        OsakaGraph data = OsakaData.get();
       budget = group.budget;
       n = data.categoryNum;
       cost = data.osakaCost;
       visit = data.visit;



    }
}
