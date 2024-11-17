import java.util.HashMap;
import java.util.Map;

//Given an array of strings strs, group the anagrams
//together. You can return the answer in any order.
// Input: strs = ["eat","tea","tan","ate","nat","bat"]
//Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        Map<String, arraylist> map = new HashMap<>();
        for(String str:strs){
            char[] sorted=str.toCharArray();
            mergeSort(sorted, 0, str.length()-1);
            String sortedStr=new String(sorted);
            map.put(sortedStr,map.getOrDefault(sortedStr, new arraylist()));
            map.get(sortedStr).add(str);
        }
        for(Map.Entry<String, arraylist> val: map.entrySet()){
            arraylist obj=val.getValue();
            for(int i=0;i<obj.size;i++){
                System.out.print(obj.list[i]+" ");
            }
            System.out.println();
        }
    }

    private static void mergeSort(char[] str, int low, int high) {
        if(low>=high) return;
        int mid=low+(high-low)/2;
        mergeSort(str, low, mid);
        mergeSort(str, mid+1, high);
        merge(str, low, mid, high);
    }

    public static void merge(char[] str, int low, int mid, int high){
        char[] temp=new char[high-low+1];
        int left=low, right=mid+1, idx=0;
        while(left<=mid && right<=high){
            if(str[left]>str[right]){
                temp[idx++]=str[right++];
            }
            else{
                temp[idx++]=str[left++];
            }
        }
        while(left<=mid){
            temp[idx++]=str[left++];
        }
        while(right<=high){
            temp[idx++]=str[right++];
        }
        for(int i=low;i<=high;i++){
            str[i-low]=temp[i];
        }
    }
}

class arraylist{
    String[] list;
    int size=0;
    int capacity=10;
    arraylist(){
        list=new String[capacity];
    }

    public void add(String element){
        checkCapacity();
        list[size++]=element;
    }
    public void checkCapacity(){
        if(size==capacity){
            capacity*=2;
            String[] temp = new String[capacity];
            for(int i=0;i<size;i++){
                temp[i]=list[i];
            }
            list=temp;
        }
    }
}
