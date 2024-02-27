package interview.companies.egen;

import java.util.*;

public class Banking {

    public static void main(String[] args) {
        String[][] queries = {
            {"CREATE_ACCOUNT", "1", "account1"},
            {"CREATE_ACCOUNT", "2", "account2"},
            {"CREATE_ACCOUNT", "3", "account3"},
            {"DEPOSIT", "4", "account1", "2000"},
            {"DEPOSIT", "5", "account2", "3000"},
            {"DEPOSIT", "6", "account3", "4000"},
            {"TOP_ACTIVITY", "7", "3"},
            {"PAY", "8", "account1", "1500"},
            {"PAY", "9", "account2", "250"},
            {"DEPOSIT", "10", "account3", "250"},
            {"TOP_ACTIVITY", "11", "3"}
        };

        List<String> output = TransactionProcessor.processQueries(queries);
        System.out.println(Arrays.toString(output.toArray(new String[0])));
    }
    static class TransactionProcessor {
        public static List<String> processQueries(String[][] queries) {
            Map<String, Integer> accounts = new HashMap<>();
            List<String> result = new ArrayList<>();

            for (String[] query : queries) {
                String command = query[0];
                String account = query[2];

                switch (command) {
                    case "CREATE_ACCOUNT":
                        result.add(accounts.containsKey(account)
                                ? "false" : "true");
                        accounts.putIfAbsent(account, 0);
                        break;
                    case "DEPOSIT":
                        if (accounts.containsKey(account)) {
                            int amount = Integer.parseInt(query[3]);
                            accounts.put(account, accounts.get(account) + amount);
                            Integer newAmount = accounts.get(account);
                            result.add(newAmount.toString());
                        } else {
                            result.add("");
                        }
                        break;
                    case "PAY":
                        if (accounts.containsKey(account)) {
                            int amount = Integer.parseInt(query[3]);
                            if (accounts.get(account) >= amount) {
                                accounts.put(account,
                                        accounts.get(account) - amount);
                                Integer newAmount = accounts.get(account);
                                result.add(newAmount.toString());
                            } else {
                                result.add("");
                            }
                        } else {
                            result.add("");
                        }
                        break;
                    case "TOP_ACTIVITY":
                        int n = Integer.parseInt(query[2]);
                        result.add(getTopActivities(accounts, n));
                        break;
                    default:
                        break;
                }
            }
            return result;
        }

        private static String getTopActivities(Map<String, Integer> 
                                               accounts, int n) 
        {
            PriorityQueue<Map.Entry<String, Integer>> pq = 
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

            for (Map.Entry<String, Integer> entry : accounts.entrySet()) {
                pq.offer(entry);
            }

            StringBuilder sb = new StringBuilder();
            int count = 0;
            sb.append('"');
            while (!pq.isEmpty() && count < n) {
                Map.Entry<String, Integer> entry = pq.poll();
                    sb.append(entry.getKey()).append("(")
                    .append(entry.getValue()).append("), ");
                count++;
            }
            sb.append('"');

            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 2);
                sb.deleteCharAt(sb.length() - 2);
            }

            return sb.toString();
        }
    }
}
