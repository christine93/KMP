//借鉴博客地址：http://www.cnblogs.com/yjiyjige/p/3263858.html
public class kmp {

	// 暴力破解法
	public static int bf(String str, String sub) {
		char cstr[] = str.toCharArray();
		char csub[] = sub.toCharArray();
		int i = 0; // 主串的位置
		int j = 0; // 子串的位置
		while (i < cstr.length && j < csub.length) {
			// 如果相等就比较下一个
			if (cstr[i] == csub[j]) {
				i++;
				j++;
			} else {
				// 如果不匹配，回归
				j = 0;
				i = i - j + 1;
			}
		}
		// 如果发现匹配成功
		if (j == csub.length) {
			// 返回开始匹配的第一个首字母的索引
			return i - j;
		} else {
			return -1;
		}
	}

	// next[j] == k; 求next数组是kmp算法的核心
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
				// i不需要回溯
				j = next[j];
			}
		}
		// 如果发现匹配成功
		if (j == c2.length) {
			// 返回开始匹配的第一个首字母的索引
			return i - j;
		} else {
			return -1;
		}
	}

	public static void main(String[] args) {
		String sub = "abca";
		String str = "ssabcabe";
		// 暴力破解法
		System.out.println(bf(str, sub));
		// kmp算法
		System.out.println(kmp(str, sub));
	}
}