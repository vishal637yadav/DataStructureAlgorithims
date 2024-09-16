package sourcecode.mycollection.graph.grid;

public class FindPathSourceToDestinationDemo {

    public static void main(String[] args) {

        int [][] grid = new int[4][6];
        //grid[i][j] = 1 means, cell is blocked not path
        //grid[i][j] = 0 means, cell is not blocked, can be used for path
        grid[0][5]= 1;
        grid[1][1]= 1;
        grid[1][3]= 1;
        grid[1][5]= 1;
        grid[2][1]= 1;
        grid[3][1]= 1;
        grid[3][2]= 1;
        grid[3][3]= 1;

        Pair source = new Pair(0,0);
        Pair destination=new Pair(3,5);

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        //depth first search
        depthFirstSearch(grid, visited, source, destination,"","");

    }

    private static class Pair{
        int row;
        int col;
        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
        @Override
        public String toString() {
            return  row +"-" + col ;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return row == pair.row && col == pair.col;
        }

    }

    public static void depthFirstSearch(int [][] grid, boolean[][] visited, Pair currentPosition, Pair destinationPosition,String pathString,String space){
        space+=", ";
        if(currentPosition.equals(destinationPosition)){
            System.out.println(space+"pathString:::"+pathString+","+currentPosition);
            return;
        }
        System.out.println(space+currentPosition);
        System.out.println(space+destinationPosition);

        visited[currentPosition.row][currentPosition.col] = true;
        System.out.println(space+"visited:"+displayVisitedArr(visited));
        System.out.println(space+"grid:"+displayGridArr(grid));

        if(currentPosition.row+1<grid.length){
            if(grid[currentPosition.row+1][currentPosition.col] != 1 && !visited[currentPosition.row+1][currentPosition.col]  ){
                depthFirstSearch(grid, visited, new Pair(currentPosition.row+1, currentPosition.col ),destinationPosition,pathString+","+currentPosition,space);
            }
        }

        if(currentPosition.col+1<grid[0].length){
            if(grid[currentPosition.row][currentPosition.col+1] != 1 && !visited[currentPosition.row][currentPosition.col+1]){
                depthFirstSearch(grid, visited, new Pair(currentPosition.row, currentPosition.col+1 ),destinationPosition,pathString+","+currentPosition,space);
            }
        }
        visited[currentPosition.row][currentPosition.col] = false;
    }

    private static String displayVisitedArr(boolean [][] ar){
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for(int i=0;i< ar.length;i++){
            for(int j=0;j< ar[0].length;j++){
                if(j!=ar[0].length-1){
                    sb.append(ar[i][j]).append(",");
                }else{
                    sb.append(ar[i][j]).append("\n");
                }
            }
        }
        sb.append("]\n");
        return sb.toString();
    }

    private static String displayGridArr(int [][] ar){
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for(int i=0;i< ar.length;i++){
            for(int j=0;j< ar[0].length;j++){
                if(j!=ar[0].length-1){
                    sb.append(ar[i][j]).append(",");
                }else{
                    sb.append(ar[i][j]).append("\n");
                }
            }
        }
        sb.append("]\n");
        return sb.toString();
    }

}
