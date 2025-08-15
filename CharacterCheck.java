public class CharacterCheck {
    public static void main(String[] args) {
        String s = "abcd";
        int[] n = s.chars().toArray();
        for (int i = 0; i < n.length; i++) {
            System.out.println((char) n[i]);
        }
        System.arraycopy(n, 0, n, 0, n.length);
    }
}
