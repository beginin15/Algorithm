public class Main {
    public static void main(String[] args) {
        //        String answer = new Solution().solution(new String [] {"leo", "kiki", "eden"}, new String [] {"eden", "kiki"});
//        String answer = new Solution().solution(new String [] {"marina", "josipa", "nikola", "vinko", "filipa"},
//                new String [] {"josipa", "filipa", "marina", "nikola"});
//        String answer = new Solution().solution(new String [] {"mislav", "stanko", "mislav", "ana"},
//                new String [] {"stanko", "ana", "mislav"});
        String answer = new Solution().solution(new String [] {"mislav", "stanko", "mislav", "ana", "mislav", "ana"},
                new String [] {"mislav", "stanko", "mislav", "ana", "mislav"});

        System.out.println(answer);
    }
}
