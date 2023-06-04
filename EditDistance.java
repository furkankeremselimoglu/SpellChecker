public class EditDistance {
    public static int calculateDistance(String word1, String word2) {
        int x = word1.length();
        int y = word2.length();
        int[][] matrix = new int[x + 1][y + 1];
        for(int i = 0; i <= x; i++){
            for(int j = 0; j <= y; j++){
                if(i == 0){
                    matrix[i][j] = j;
                } else if(j == 0){
                    matrix[i][j] = i;
                } else {
                    int costOfSubstitution;
                    if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                        costOfSubstitution = 0;
                    } else {
                        costOfSubstitution = 1;
                    }
                    matrix[i][j] = min(matrix[i - 1][j] + 1,  //deletion
                            matrix[i][j - 1] + 1,  // insertion
                            matrix[i - 1][j - 1] + costOfSubstitution);  //substitution
                    if(i > 1 && j > 1 && word1.charAt(i - 1) == word2.charAt(j - 2) && word1.charAt(i - 2) == word2.charAt(j - 1)){
                        matrix[i][j] = min(matrix[i][j],matrix[i-2][j-2] + 1);  //transposition
                    }
                }
            }
        }
        return matrix[x][y];
    }
    public static int min(int... numbers){
        int min = Integer.MAX_VALUE;
        for(int number : numbers){
            if(number < min){
                min = number;
            }
        }
        return min;
    }
}