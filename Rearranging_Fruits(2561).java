class Solution {
    public long minCost(int[] b1, int[] b2) {
         Map<Integer,Integer> mp1=new HashMap<>();
         Map<Integer,Integer> mp2=new HashMap<>();
         int min=Integer.MAX_VALUE;
         for(int i=0;i<b1.length;i++){
            mp1.put(b1[i],mp1.getOrDefault(b1[i],0)+1);
            mp2.put(b2[i],mp2.getOrDefault(b2[i],0)+1);
            min=Math.min(min,Math.min(b1[i],b2[i]));
         }
         List<Integer> toSwap=new ArrayList<>();
         for(int cost:new ArrayList<>(mp1.keySet())){
            int occ1=mp1.getOrDefault(cost,0);
            int occ2=mp2.getOrDefault(cost,0);
            int diff=Math.abs(occ1-occ2);
            if(diff%2==1)return -1;
            diff/=2;
            for(int i=0;i<diff;i++){
                toSwap.add(cost);
            }
            mp1.put(cost,0);
            mp2.put(cost,0);
         }

         for(int cost:new ArrayList<>(mp2.keySet())){

            int occ1=mp1.getOrDefault(cost,0);
            int occ2=mp2.getOrDefault(cost,0);
            int diff=Math.abs(occ1-occ2);
            if(diff%2==1)return -1;
            diff/=2;
            for(int i=0;i<diff;i++){
                toSwap.add(cost);
            }
            mp2.put(cost,0);
            mp1.put(cost,0);
         }
         Collections.sort(toSwap);

         long ans=0;
         for(int i=0;i<toSwap.size()/2;i++){
            long direct=toSwap.get(i);
            long viamin=2L*min;
            ans+=Math.min(direct,viamin);
         }
         return ans;




    }
}