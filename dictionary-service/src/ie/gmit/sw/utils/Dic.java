package ie.gmit.sw.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class Dic {

	/**
	 * Set whether to output debugging information.(设置是否输出调试信息)
	 */
	private static boolean DEBUG = true;

	/**
	 * Default encoding.(默认编码)
	 */
	public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

	/**
	 * Local dictionary file name.(本地字典文件名)
	 */
	public static final String DIC_FILENAME = "dic.txt";

	/**
	 * Dictionary data.(字典数据)
	 */
	public static byte[] bytes = new byte[0];

	/**
	 * Number of dictionary words.(字典单词数目)
	 */
	public static int count = 0;

	/**
	 * The location of words in word information(单词信息中单词的位置).<br/>
	 * Word information，e.g. Galaxy,This article is about the astronomical structure."
	 */
	public static int INDEX_WORD = 0;
	/**
	 * The location of the comment in the word information(单词信息中注释的位置). <br/>
	 * Word information，e.g. Galaxy,This article is about the astronomical structure."
	 */
	public static int INDEX_PARAPHRASE = 1;

	/**
	 * Load the dictionary(装载字典)
	 */
	static {
		long time = System.currentTimeMillis();

		try {
			LoadDictionary();
			count = count();
			if (DEBUG) {
				System.out.println("Successfully loaded dictionaries" + new File(DIC_FILENAME).getCanonicalPath() + " ，time cost："
						+ (System.currentTimeMillis() - time) + "millisecond，Load the number of characters" + count);
			}
		} catch (Exception e) {
			try {
				System.out.println("Failed to load dictionaries" + new File(DIC_FILENAME).getCanonicalPath() + "\r\n");
			} catch (Exception e1) {
			}
			e.printStackTrace();
		}

	}

	/**
	 * Get the word explanation(获取单词释义)
	 * 
	 * @param str
	 * 
	 * @return word value (单词值)
	 * @throws Exception
	 */
	public static String GetParaphrase(String str) throws Exception {
		return GetCharInfo(str, INDEX_PARAPHRASE);
	}

	/**
	 * Get word information from the dictionary(从字典中获取单词信息)
	 * 
	 * 
	 * @throws Exception
	 */
	public static String GetCharInfo(String str) throws Exception {

		String result = "";

		ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
		BufferedReader br = new BufferedReader(new InputStreamReader(bais));

		String strWord;
		while ((strWord = br.readLine()) != null) {
			String string = strWord.split(",")[INDEX_WORD];
			if (string.equals(str)) {
				result = strWord;
				break;
			}
		}
		br.close();
		bais.close();

		return result;
	}

	/**
	 * Return word information(返回单词信息)
	 * 
	 * @param str
	 * 
	 * @param index
	 *            信息所在的Index
	 * @return
	 * @throws Exception
	 */
	private static String GetCharInfo(String str, int index) throws Exception {
		// Get word information 获取单词信息
		String charInfo = GetCharInfo(str);
		String result = "";
		try {
			if (!"".equals(charInfo))
				result = charInfo.split(",")[index];
		} catch (Exception e) {
			throw new Exception("Please check the dictionary" + str + "is the word record correct?");
			// 检查字典里单词记录是否正确
		}

		return result;
	}

	/**
	 * Load dictionaries into memory (载入字典文件到内存。)
	 * 
	 * @throws Exception
	 */
	private static void LoadDictionary() throws Exception {
		File file = new File(DIC_FILENAME);
		bytes = new byte[(int) file.length()];
		FileInputStream fis = new FileInputStream(file);
		fis.read(bytes, 0, bytes.length);
		fis.close();
	}

	/**
	 * 
	 * @return Returns the dictionary contains the number of words.(返回字典包含的单词数目。)
	 * @throws Exception
	 */
	private static int count() throws Exception {
		int cnt = 0;
		ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
		BufferedReader br = new BufferedReader(new InputStreamReader(bais));

		while (br.readLine() != null) {
			cnt++;
		}
		br.close();
		bais.close();

		return cnt;
	}
}
