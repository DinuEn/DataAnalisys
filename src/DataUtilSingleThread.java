import java.util.List;

public interface DataUtilSingleThread {

    static final int ASCII_SIZE = 256;

    public static int averageLength(List<String> data) {
        long total = 0;
        for(String word: data) {
            total += word.length();
        }
        return (int) total / data.size();
    }

    public static int maxLength(List<String> data) {
        int maxLen = -1;
        for(String word: data) {
            if(word.length() > maxLen) {
                maxLen = word.length();
            }
        }
        return maxLen;
    }

    public static int minLength(List<String> data) {
        int minLen = data.get(0).length();
        for(String word: data) {
            if(word.length() < minLen) {
                minLen = word.length();
            }
        }
        return minLen;
    }

    public static char mostFrequentChar(List<String> data) {
        int count[] = new int[ASCII_SIZE]; 

        synchronized(count) {
            for(String word: data) {
                int len = word.length();
                for(int i = 0; i < len; i++) {
                    count[(int)word.charAt(i)]++;
                }
            }

            int max = -1;
            char result = data.get(0).charAt(0);

            for(int i = 0; i < ASCII_SIZE; i++) {
                if(max < count[i]) {
                    max = count[i];
                    result = (char) i;
                }
            }
            return result;
        }
    }
}

