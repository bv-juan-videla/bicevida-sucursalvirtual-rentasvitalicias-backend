package cl.bicevida.util;


import java.util.HashMap;

import org.apache.log4j.Logger;

public class LogExecutionTime {
	
	private Logger log;
	private HashMap<String,Long> initTimeStamps;
	
	public LogExecutionTime(Logger log) {
		this.log = log;
		if(log.isDebugEnabled()){
			initTimeStamps = new HashMap<>();
		}
	}
	
	public void startLogin(String process){
		if(log.isDebugEnabled()){
			initTimeStamps.put(process, System.currentTimeMillis());
		}
	}
	public void stopLogin(String process){
		if(log.isDebugEnabled()){
			if(!this.initTimeStamps.containsKey(process)){
				log.debug("no existe la marca de tiempo inicial para "+process); 
			}
			Long duration = System.currentTimeMillis()-this.initTimeStamps.get(process);
			log.debug(String.format("Duracion %s - %s ms",process,duration));
		}
	}

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}

	public HashMap<String, Long> getInitTimeStamps() {
		return initTimeStamps;
	}

	public void setInitTimeStamps(HashMap<String, Long> initTimeStamps) {
		this.initTimeStamps = initTimeStamps;
	}

}
