//Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
public class MajorityElement2 {
    public static void main(String[] args) {
        int[] arr = {2,2,3,3,3,5,2,2,3};
        int n=arr.length;
        if(n<=2){
            for(int x:arr){
                System.out.print(x+" ");
            }
            return;
        }
        int freq=n/3;
        int[] freqArr = new int[50000];
        int count=0;
        for(int x:arr){
            freqArr[x]++;
        }
        for(int i=0;i<freqArr.length;i++){
            if(freqArr[i]>freq){
                System.out.println(i);
                count++;
                if(count==2){
                    break;
                }
            }
        }
    }
}