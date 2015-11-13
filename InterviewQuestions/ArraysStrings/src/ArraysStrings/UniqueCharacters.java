package ArraysStrings;

public class UniqueCharacters 
{
	
//	public void questionOne(String input) {
//        /*-- implement an algorithm to determine if a string has all unique characters. 
//         * What if you cannot use additional data structures?   --*/
//
//        boolean[] chars = new boolean[26];
//        int x = 0;
//
//        for(int i = 0; i < input.length(); i++) {
//
//            if(!chars[(int)input.toUpperCase().charAt(i) - 64]) {
//                chars[(int)input.toUpperCase().charAt(i) - 64] = true;
//            }
//            else {
//                System.out.println("not unique");
//                x = -1;
//                break;
//            }
//        }
//
//        if(x == 0)
//            System.out.println("unique");
//    }

        public boolean uniqueChars(String s) {
        boolean[] mask = new boolean[256];
        for (int i = 0; i < s.length(); i++) {
            if (mask[s.charAt(i)])
                return false;
            mask[s.charAt(i)] = true;
        }
        return true;
    }
        
    public static void main(String[] args) {
    	UniqueCharacters test = new UniqueCharacters();
        //test.questionOne("dsfdddft");
        boolean x = test.uniqueChars("abhnhjn");
        System.out.println("result"+x);
    }

}
