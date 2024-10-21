/*
First, we can observe that the deleting operation is symmetric, every time we delete half numbers.
Now we define function f(n, left) as the number that n numbers, we first delete from left, then delete from right, …, finally return the last number. 
So we can get f(n, right), the only different is first delete from right, the return last number should be n+1-f(n, left). 
As we can regard it as reverse the array 1 … n, and then iterate to delete from left. So f(n, left) = n + 1- f(n, right).

Suppose there is array 1, 2, …, n, after first delete from left, we get subarray 2, 4, …. 
Then we delete from right, it is similar as we delete the array 1, 2, …, n / 2 from right, f(n/2, right), but number value of array should be 2 * f(n/2, right). 
So we get another equation: f(n, left) = 2 * f(n/2, right), also f(n, right) = 2 * f(n/2, left).
Finally, We can conclude the general equation f(n, left) = n + 1 -f(n, right) = n + 1 – 2 * f(n/2, left). 
As first time n may be odd, so we use n / 2 to eliminate the ambiguity((n+1) / 2 == n/2). So f(n, left) = 2 * (n / 2 + 1-f(n/2, left)).

And we can eliminate the left argument, so f(n) = 2 * (n/2 + 1- f(n/2)).
*/

// O(logn)
class Solution {
    public int lastRemaining(int n) {
        if (n == 1 || n == 2) return n;
        
        return 2 * (1 + n / 2 - lastRemaining(n / 2));  
    }
}
