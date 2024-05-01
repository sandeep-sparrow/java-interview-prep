package interview.companies.arcserve.Arrays;

public class Challenge1{

    public static void main(String[] args){
        String[] newStringArray = {"0000", "1000", "0002", "0002"};

        // Determine the dimensions of the 2D array
        int rows = newStringArray.length;
        int cols = newStringArray[0].length();

        // Create the 2D array
        char[][] matrix = new char[rows][cols];

        // Fill the 2D array
        for (int i = 0; i < rows; i++) {
            matrix[i] = newStringArray[i].toCharArray();
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Min Distance: " + ArrayChallenge(matrix));
    }

    public static String ArrayChallenge(char[][] matrix) {
        // code goes here

        // find the position of "1"
        int row = -1;
        int col = -1;

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == '1'){
                row = i;
                col = j;
                break;
                }
            }
            if(row != -1 && col != -1) break;
        }

        // if no "1" found
        if(row == -1 || col == -1) return "0";

        // find the closest "2"
        int minDistance = Integer.MAX_VALUE;
        int distance = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == '2'){
                    distance = Math.subtractExact(
                        Math.min(Math.abs(row - i), Math.abs(matrix.length - row + i)), // Vertical distance
                        Math.min(Math.abs(col - j), Math.abs(matrix[0].length - col + j)) // Horizontal distance
                    );
                    minDistance = Math.min(minDistance, Math.abs(distance));
                    break;
                };
            }
            if(distance != 0){
                break;
            }
         }

    return String.valueOf(minDistance);
  }
}