public class Solution {
    public int trap(int[] height) {
        int result=0;
        int temp;
        int i;
        boolean flag=false;
        for (i=0;i<height.length-1;i++)
        {
            if (height[i]<height[i+1])
                continue;
            int j=i+1;
            temp=0;
            while (j<height.length)
            {
                if (height[j]<height[i])
                {
                    temp+=height[i]-height[j];
                    j++;
                }
                else
                    break;
            }
            if (j!=height.length)
            {
                result+=temp;
                i=j-1;
            }
            else
            {
                flag=true;
                break;
            }
        }
        if (flag)
        {
            for (int k=height.length-1;k>i;k--)
            {
                if (height[k]<height[k-1])
                    continue;
                int j=k-1;
                temp=0;
                while (j>=0)
                {
                    if (height[j]<height[k])
                    {
                        temp+=height[k]-height[j];
                        j--;
                    }
                    else
                        break;
                }
                result+=temp;
                k=j+1;
            }
        }
        return result;
    }
}
