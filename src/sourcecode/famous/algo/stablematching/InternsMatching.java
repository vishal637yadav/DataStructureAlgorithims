package sourcecode.famous.algo.stablematching;

import java.util.Arrays;

public class InternsMatching {

    public int [][] stableInterships(int [][] interns,int [][] teams){
        int n = interns.length;
        int [] internMatch = new int [n];
        int [] teamMatch = new int[n];

        Arrays.fill(internMatch, -1);
        Arrays.fill(teamMatch, -1);

        for(int i = 0;i< n;i++){

            for(int j=0;j< n ;j++){

                if ( internMatch[i]==-1){
                    int team = interns[j][i];
                }
            }

        }
        return null;
    }
}
