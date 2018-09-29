package gfg.tsp.readData;

public class OsakaData {
    public static OsakaGraph get(){
        OsakaGraph graph = readCateGory.buildCat();
        return graph;
    }
    public static void main(String[] args) {
       OsakaData.get().PrintOsaka();
    }
}
