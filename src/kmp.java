//Reference£ºhttp://www.cnblogs.com/yjiyjige/p/3263858.html
public class kmp {

	// Brute-Force
	public static int bf(String str, String sub) {
		char cstr[] = str.toCharArray();
		char csub[] = sub.toCharArray();
		int i = 0; // Main String's index
		int j = 0; // Sub_String's inedx
		while (i < cstr.length && j < csub.length) {
			// if equals then compare next character
			if (cstr[i] == csub[j]) {
				i++;
				j++;
			} else {
				// if not match,the main string's index come back
				j = 0;
				i = i - j + 1;
			}
		}
		// if successful
		if (j == csub.length) {
			// return the first character's index
			return i - j;
		} else {
			return -1;
		}
	}

	// next[j] == k; how to get the next array is the most important thing in the KMP
	public static int[] next(String sub) {
		int next[] = new int[sub.length()];
		char c[] = sub.toCharArray();
		int j = 0;
		int k = -1;
		while (j < c.length - 1) {
			if (k == -1 || c[j] == c[k]) {
				next[j] = k;
				j++;
				k++;
			} else {
				k = next[k];
			}
		}
		return next;
	}

	public static int kmp(String str, String sub) {
		char c1[] = str.toCharArray();
		char c2[] = sub.toCharArray();

		int i = 0;
		int j = 0;

		int next[] = next(sub);

		while (i < c1.length && j < c2.length) {
			if (j == -1 || c1[i] == c2[j]) {
				i++;
				j++;
			} else {
				// i needn't to come back
				j = next[j];
			}
		}
		// if successful
		if (j == c2.length) {
			// return the first character's index
			return i - j;
		} else {
			return -1;
		}
	}

	public static void main(String[] args) {
		String sub = "abca";
		String str = "ssabcabe";
		//Brute-force
		System.out.println(bf(str, sub));
		// kmp
		System.out.println(kmp(str, sub));
	}
}