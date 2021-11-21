public class OffByN implements CharacterComparator {
    private Integer offNumber;
    public OffByN(Integer N){
        offNumber=N;
    }
    @Override
    public boolean equalChars(char x, char y){
        if(Math.abs(x-y)==offNumber){
            return true;
        }else{
            return false;
        }
    }
}
