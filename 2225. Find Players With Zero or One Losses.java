// Runtime    74ms
// Beats      80.96%

// Memory     107.66MB
// Beats      17.11%

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> win=new HashSet<>();
        Map<Integer,Integer> los=new HashMap<>();

        for(int[] mat:matches){
            los.put(mat[1],los.getOrDefault(mat[1] , 0)+1);
        }

        for(int[] mat:matches){
            if(!los.containsKey(mat[0]))
                win.add(mat[0]);
        }

        List<Integer> winList=new ArrayList<>(win);
        List<Integer> losList=new ArrayList<>();

        for(int loss:los.keySet()){
            if(los.get(loss)==1)
                losList.add(loss);
        }

        Collections.sort(winList);
        Collections.sort(losList);

        List<List<Integer>> res=new ArrayList<>();
        res.add(winList);
        res.add(losList);

        return res;

    }
}
