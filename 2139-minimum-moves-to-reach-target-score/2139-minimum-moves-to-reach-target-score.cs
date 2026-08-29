public class Solution {
    public int MinMoves(int target, int maxDoubles) {
        if (maxDoubles == 0)
            return target - 1;

        int steps = 0;
        while (target != 1)
        {
            if (target % 2 == 0 && maxDoubles > 0)
            {
                target = target / 2;
                maxDoubles -= 1;
            }
            else
            {
                target -= 1;
            }

            steps++;
        }

        return steps;
    }
}