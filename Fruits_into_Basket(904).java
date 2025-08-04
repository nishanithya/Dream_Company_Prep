class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer,Integer> mp=new HashMap<>();
        int left=0;
        int max=0;
        for(int right=0;right<fruits.length;right++){
            mp.put(fruits[right],mp.getOrDefault(fruits[right],0)+1);
            while(mp.size()>2){
               int lfruit=fruits[left];
               mp.put(lfruit,mp.get(lfruit)-1);
               if(mp.get(lfruit)==0){
                mp.remove(lfruit);
               }
               left++;

            }
            max=Math.max(max,right-left+1);


        }
        return max;
        
    }
}