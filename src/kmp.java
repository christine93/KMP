//������͵�ַ��http://www.cnblogs.com/yjiyjige/p/3263858.html
public class kmp {

	// �����ƽⷨ
	public static int bf(String str, String sub) {
		char cstr[] = str.toCharArray();
		char csub[] = sub.toCharArray();
		int i = 0; // ������λ��
		int j = 0; // �Ӵ���λ��
		while (i < cstr.length && j < csub.length) {
			// �����ȾͱȽ���һ��
			if (cstr[i] == csub[j]) {
				i++;
				j++;
			} else {
				// �����ƥ�䣬�ع�
				j = 0;
				i = i - j + 1;
			}
		}
		// �������ƥ��ɹ�
		if (j == csub.length) {
			// ���ؿ�ʼƥ��ĵ�һ������ĸ������
			return i - j;
		} else {
			return -1;
		}
	}

	// next[j] == k; ��next������kmp�㷨�ĺ���
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
				// i����Ҫ����
				j = next[j];
			}
		}
		// �������ƥ��ɹ�
		if (j == c2.length) {
			// ���ؿ�ʼƥ��ĵ�һ������ĸ������
			return i - j;
		} else {
			return -1;
		}
	}

	public static void main(String[] args) {
		String sub = "abca";
		String str = "ssabcabe";
		// �����ƽⷨ
		System.out.println(bf(str, sub));
		// kmp�㷨
		System.out.println(kmp(str, sub));
	}
}