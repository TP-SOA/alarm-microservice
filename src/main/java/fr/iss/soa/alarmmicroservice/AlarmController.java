package fr.iss.soa.alarmmicroservice;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlarmController {
	private final AlarmModel alarmModel;

	public AlarmController(AlarmModel alarmModel){
		this.alarmModel = alarmModel;
	}

	@GetMapping("/alarms")
	public List<Alarm> lights() {
		return alarmModel.findAll();
	}

	@GetMapping(value = "/alarms/{id}")
	public Alarm lightsID(@PathVariable int id) {
		return alarmModel.findById(id);
	}

	@PostMapping(value = "/alarms")
	public void addLight(@RequestBody Alarm alarm){
		alarmModel.add(alarm);
	}
	@PostMapping(value="/alarms/{id}")
	public void setLight(@PathVariable int id, @RequestBody String requestBody) {
		JSONObject jsonBody = new JSONObject(requestBody);
		try {
			boolean enabled = jsonBody.getBoolean("enabled");
			alarmModel.update(id, enabled);
		} catch(JSONException e) {
			e.printStackTrace();
		}
	}
}
