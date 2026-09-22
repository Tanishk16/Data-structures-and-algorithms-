class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {

            HashSet<Integer> set = new HashSet<>();

            for (int j = i + 1; j < nums.length; j++) {

                int required = -(nums[i] + nums[j]);

                if (set.contains(required)) {

                    List<Integer> triplet = Arrays.asList(
                        nums[i],
                        nums[j],
                        required
                    );
                    Collections.sort(triplet);

                    result.add(triplet);
                }

                set.add(nums[j]);
            }
        }

        return new ArrayList<>(result);
    }
}