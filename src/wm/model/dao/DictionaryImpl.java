package wm.model.dao;

import java.io.File;

import wm.model.Dictionaries;
import wm.model.Dictionary;

public class DictionaryImpl implements DictionaryDAO {

	@Override
	public Dictionaries selectAllDictionay() {
		File logfile = new File("material/dictionary.txt");
		if(logfile.exists()){
			
		}else{
			
		}
		return null;
	}

	@Override
	public boolean updateAllDictionary(Dictionaries dictionaries) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteDictionary(String name) {
		// TODO Auto-generated method stub
		return false;
	}

}
