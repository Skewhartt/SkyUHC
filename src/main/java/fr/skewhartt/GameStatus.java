package fr.skewhartt;

public enum GameStatus {
    LOBBY(), GAME(), END();

    private static GameStatus status;

    public static void setStatus(GameStatus statuss){
        status = statuss;
    }

    public static boolean isStatus(GameStatus statuss){
        return status == statuss;
    }

    public static GameStatus getStatus(){
        return status;
    }
}
