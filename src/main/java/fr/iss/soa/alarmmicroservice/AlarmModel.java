package fr.iss.soa.alarmmicroservice;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AlarmModel {
	public static List<Alarm> alarmList = new ArrayList<>();

	static {
		alarmList.add(new Alarm(1, true));
		alarmList.add(new Alarm(7, false));
		alarmList.add(new Alarm(11, false));
		alarmList.add(new Alarm(114, true));
		alarmList.add(new Alarm(116, false));
		alarmList.add(new Alarm(213, false));
	}

	public List<Alarm> findAll() {
		return alarmList;
	}

	public Alarm findById(int id) {
		for (Alarm alarm : alarmList){
			if(alarm.getId() == id){
				return alarm;
			}
		}
		return null;
	}

	public void add(Alarm light) {
		alarmList.add(light);
	}

	public void update(int id, boolean enabled) {
		Alarm l = findById(id);
		l.setEnabled(enabled);
	}
}
