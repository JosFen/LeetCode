class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        int k_tickets = tickets[k];

        for (int i = 0; i <= k; i++) {
            if (tickets[i] > k_tickets) time += k_tickets;
            else time += tickets[i];
        }

        for (int j = k+1; j < tickets.length; j++) {
            if (tickets[j] > k_tickets-1) time += (k_tickets-1);
            else time += tickets[j];
        }

        return time;
    }
}
