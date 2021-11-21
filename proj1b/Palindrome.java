public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> dc = new LinkedListDeque<>();
        for(int i=0;i<word.length();i++){
            dc.addLast(word.charAt(i));
        }
        return dc;
    }
    public boolean isPalindrome(String word){
        Deque<Character> dc = wordToDeque(word);
        if(dc.isEmpty()){
            return true;
        }
        while(dc.size()>1){
            Character p = dc.removeFirst();
            Character t = dc.removeLast();
            if(!p.equals(t)){//////////////////////////////
                return false;
            }
         }
        return true;
    }
    //a third public method
    private static class Pcc implements CharacterComparator{
        @Override
        public boolean equalChars(char x, char y){
            if(Math.abs(x-y)==0){
                return true;
            }else{
                return false;
            }
        }
    }
    public static Pcc getPcc(){
        return new Pcc();
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque<Character> dc = wordToDeque(word);
        if(dc.isEmpty()){
            return true;
        }
        while(dc.size()>1){
            Character p = dc.removeFirst();
            Character t = dc.removeLast();
            if(!cc.equalChars(p,t)){////////////////////////
                return false;
            }
        }
        return true;
    }
}
