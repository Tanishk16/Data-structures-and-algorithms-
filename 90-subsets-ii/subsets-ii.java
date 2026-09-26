class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> subset = new ArrayList<>();
        solve(0, nums, subset);
        return result;
    }
    public void solve(int i, int[] nums, List<Integer> current){
        if(i == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[i]);
        solve(i+1,nums,current);
        current.remove(current.size()-1);
        while(i+1 < nums.length && nums[i] == nums[i+1]){
            i++;
        }
        solve(i+1,nums,current);
    }
}