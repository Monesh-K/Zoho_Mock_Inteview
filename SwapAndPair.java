import java.util.Arrays;

public class SwapAndPair {
    public static void main(String[] args) {
        String str="HELLOHELLO";
        int len=str.length();
        char[] strArr = new char[len];
        for(int i=0;i<len;i++){
            strArr[i]=str.charAt(i);
        }
        int minSwaps=0;
        for(int i=1;i<len;i++){
            char ch=strArr[i-1];
            if(ch==strArr[i]) continue;
            int l=i, r=len-1;
            while(l<r){
                if(strArr[r]==ch){
                    strArr[r]=strArr[i];
                    strArr[i]=ch;
                    minSwaps++;
                    break;
                }
                r--;
            }
        }
        System.out.println(Arrays.toString(strArr));
        System.out.println("Min swaps: "+minSwaps);
    }


}
