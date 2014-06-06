/**
 * Software Engineer lab4
 */
package wm.model.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import wm.model.Dictionaries;
import wm.model.Dictionary;
import wm.model.Word;

public class DictionaryImpl implements DictionaryDAO {
	private final static int DICNUMBER = 26;

	@Override
	public Dictionaries selectAllDictionay(String filename) {
		List<Dictionary> dic = new ArrayList<Dictionary>();
		List<List<Word>> tempWords = new ArrayList<List<Word>>();
		for (int i = 0; i < DICNUMBER; i++) {
			tempWords.add(new ArrayList<Word>());
		}
		int index = 0;

		try {
			File allDic = new File("material/" + filename);
			File logfile = new File("material/log.txt");
			String[] entry;
			String[] flag;
			String d = "";
			String log = "";
			boolean recited = false;
			boolean correct = false;
			BufferedReader dicReader = new BufferedReader(
					new FileReader(allDic));

			if (logfile.exists()) {
				BufferedReader logReader = new BufferedReader(new FileReader(
						logfile));
				while ((d = dicReader.readLine()) != null
						&& (log = logReader.readLine()) != null) {

					entry = d.split("\\s+");
					flag = log.split("\t");
					if (flag[1].equals("1")) {
						recited = true;
					} else {
						recited = false;
					}

					if (flag[2].equals("1")) {
						correct = true;
					} else {
						correct = false;
					}

					index = entry[0].charAt(0) - 'a';

					tempWords.get(index).add(
							new Word(entry[0], entry[1], recited, correct));
				}

			} else {
				logfile.createNewFile();
				PrintWriter logWriter = new PrintWriter(logfile);
				while ((d = dicReader.readLine()) != null) {
					entry = d.split("\\s+");
					index = entry[0].charAt(0) - 'a';
					tempWords.get(index).add(
							new Word(entry[0], entry[1], false, false));
					logWriter.println(entry[0].substring(0, 1) + "\t" + 0 + "\t" + 0);
				}
				logWriter.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (int i = 0; i < tempWords.size(); i++) {
			char name = (char) ('A' + i);
			Dictionary tempD = new Dictionary("Dictionary " + name,
					tempWords.get(i));
			dic.add(tempD);
		}
		

		return new Dictionaries(dic);
	}

	@Override
	public boolean updateAllDictionary(Dictionaries dictionaries) {
		Dictionary dic;
		int wordSize;

		String record = "";

		try {
			File logfile = new File("material/log.txt");
			if (!logfile.exists()) {
				logfile.createNewFile();
			}
			PrintWriter logWriter = new PrintWriter(logfile);
			for (int i = 0; i < dictionaries.getDicNumber(); i++) {
				dic = dictionaries.getDictionary(i);
				wordSize = dic.getSize();
				for (int j = 0; j < wordSize; j++) {
					record = dic.getWordEntry(j);
					logWriter.println(record);
				}
			}
			logWriter.close();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
		}

		return false;
	}

	@Override
	public Dictionary selectDictionary(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertDictionary(Dictionary dictionary) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateDictionary(Dictionary dictionary) {
		String prefix = dictionary.getKey(0).substring(0, 1);
		String logline = "";
		String record = "";
		int k = 0;
		try {
			File logfile = new File("material/log.txt");
			File newLogfile = new File("material/newlog.txt");
			if (!newLogfile.exists()) {
				newLogfile.createNewFile();
			}
			String[] entry;
			PrintWriter logWriter = new PrintWriter(newLogfile);
			BufferedReader logReader = new BufferedReader(new FileReader(
					logfile));
			while ((logline = logReader.readLine()) != null) {
				entry = logline.split("\t");

				if (entry[0].substring(0, 1).equals(prefix)) {
					record = dictionary.getWordEntry(k);
					logWriter.println(record);
					k++;
				} else {
					logWriter.println(logline);
				}
			}
			logWriter.close();
			
			logfile.delete();
			newLogfile.renameTo(new File("material/log.txt"));
			return true;

		} catch (Exception e) {
			e.getStackTrace();
		}

		return false;
	}

	@Override
	public boolean deleteDictionary(String name) {
		// TODO Auto-generated method stub
		return false;
	}

}
