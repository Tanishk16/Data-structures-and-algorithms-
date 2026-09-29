class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        solve(candidates, target, 0 , new ArrayList<Integer>(), result);
        return result;
    }

    public void solve(int[] candidate, int target,int start, List<Integer> comb, List<List<Integer>> res ){
        
        if(target == 0){
            res.add(new ArrayList<Integer>(comb));
            return;
        }
        if(target < 0){
            return ;
        }

        for(int i =start;i<candidate.length;i++){
            
            if(i > start && candidate[i] == candidate[i-1]){
                continue;
            }

            if(candidate[i] > target){
                break;
            }

            // make a choice
            comb.add(candidate[i]);
            solve(candidate,target - candidate[i], i+1, comb, res);
            comb.remove(comb.size()-1);
        }

    }
}