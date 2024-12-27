package sourcecode.famous.algo.recursion;

import java.util.ArrayList;
import java.util.List;

public class PermutationOfString {

    public static void main(String[] args) {
        String s = "abc";
        //printAllPermutation(s,"");
        List<String> list = getAllPermutation(s);
        System.out.println("list --j>"+list);

    }

    public static void printAllPermutation(String s,String usedCharaterString){
        // base case
        if(s.isEmpty()){
            System.out.println(usedCharaterString);
            return;
        }
        for(int i=0;i< s.length();i++){
            char currChar = s.charAt(i);
            String remStr = getStringAferRemovingIindexCharacter(s,i);
            System.out.println("After removing currChar="+currChar+" from s="+s+", remStr="+remStr);
            printAllPermutation(remStr,usedCharaterString+currChar);
        }
    }

    public static String getStringAferRemovingIindexCharacter(String s,int i){
        //1 size
        if(s.length() ==1){
            return "";
        }
        return s.substring(0,i)+s.substring(i+1);

    }

    public static List<String> getAllPermutation(String s){

        // base case
        if(s.isEmpty()){
            List<String > list =  new ArrayList<>();
            list.add("");
            return list;
        }

        List<String> list = new ArrayList<>();
        for(int i=0;i< s.length();i++){
            char currChar = s.charAt(i);
            String remStr = getStringAferRemovingIindexCharacter(s,i);
            List<String> ls = getAllPermutation(remStr);

            for(int j=0;j<ls.size();j++){
                list.add(currChar+ls.get(j));
            }
        }
        return list;
    }
}
