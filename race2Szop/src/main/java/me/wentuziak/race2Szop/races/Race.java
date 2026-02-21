package me.wentuziak.race2Szop.races;

public interface Race {

    public String name = "";
    public Integer id = null;
    public Integer RaceLvl = null;
    public Double cooldownModifier = 1.0;

    // TODO :
    // read skill input
    // lvl up

    private int LevelUp(){
        return 0;
    }
    private int LevelDown(){
        return 0;
    }
}
