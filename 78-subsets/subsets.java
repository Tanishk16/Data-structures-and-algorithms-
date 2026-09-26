class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backTrack(0, nums, new ArrayList<>());
        return result;
    }
    public void backTrack(int index, int[] nums, List<Integer> current){
        if(index == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }

        // take the current element
        current.add(nums[index]);
        backTrack(index+1, nums, current);

        // skip the current element;
        current.remove(current.size()-1);
        backTrack(index+1,nums, current);
    }
}