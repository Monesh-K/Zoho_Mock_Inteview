//You are given an n x n 2D matrix representing an image, rotate the
//image by 90 degrees (clockwise).
//
//You have to rotate the image in-place, which means you have to modify
//the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
//Input: matrix = [
//        [1,2,3],
//        [4,5,6],
//        [7,8,9]]
//Output: [
//        [7,4,1],
//        [8,5,2],
//        [9,6,3]]

public class RotateImage {
    public static void main(String[] args) {
        int[][] mat= {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int row=mat.length, col=mat.length;
        int degree=90;
        int rotateTimes = (degree/90)%4;
        if(rotateTimes==0){
            displayMatrix(mat);
            return;
        }
        for(int k=0;k<rotateTimes;k++){
            for(int i=0;i<row;i++){
                for(int j=i;j<col;j++){
                    if(i==j) continue;
                    int temp=mat[i][j];
                    mat[i][j]=mat[j][i];
                    mat[j][i]=temp;
                }
            }
            for(int i=0;i<row;i++){
                int l=0,r=col-1;
                while(l<r){
                    int temp=mat[i][l];
                    mat[i][l]=mat[i][r];
                    mat[i][r]=temp;
                    l++;
                    r--;
                }
            }
        }
        displayMatrix(mat);
    }

    private static void displayMatrix(int[][] mat) {
        for(int[] row:mat){
            for(int col:row){
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }
}
