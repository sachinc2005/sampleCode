package com.sample.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Logger;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.typesafe.config.ConfigValue;

public class DataParsingService {

	private File fname;
	public Map<String, String> map;
	private Config fileConfig;
	private Set<Entry<String, ConfigValue>> set;
	private String confFile;
	
	Logger LOGGER = Logger.getLogger(DataParsingService.class.getName());

	public DataParsingService(String confFile) {

		this.confFile = confFile;
	}

	public Map<String, String> dataFilter(String tagName) {

		fname = new File(confFile);
		map = new HashMap<String, String>();
		fileConfig = ConfigFactory.parseFile(fname).getConfig(tagName);
		set = fileConfig.entrySet();
		for (Entry<String, ConfigValue> entry : set) {

			map.put(entry.getKey(), entry.getValue().unwrapped().toString());
		}

		return map;
	}
	
	public Map<String, String> dataFilter(String tagName,String confFile) {

		fname = new File(confFile);
		map = new HashMap<String, String>();
		fileConfig = ConfigFactory.parseFile(fname).getConfig(tagName);
		set = fileConfig.entrySet();
		for (Entry<String, ConfigValue> entry : set) {

			map.put(entry.getKey(), entry.getValue().unwrapped().toString());
		}

		return map;
	}
    


}

