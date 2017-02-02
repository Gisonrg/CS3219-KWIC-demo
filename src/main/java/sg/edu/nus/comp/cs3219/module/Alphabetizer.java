package sg.edu.nus.comp.cs3219.module;

import java.util.Observable;
import java.util.Observer;

import sg.edu.nus.comp.cs3219.event.LineStorageChangeEvent;
import sg.edu.nus.comp.cs3219.model.Line;
import sg.edu.nus.comp.cs3219.model.LineStorage;

public class Alphabetizer implements Observer {
	@Override
	public void update(Observable o, Object arg) {
		LineStorage storage = (LineStorage) o;
		LineStorageChangeEvent event = (LineStorageChangeEvent) arg;
		Line line = storage.get(event.getChangedLine());
		switch (event.getEventType()) {
		case ADD:
			line.capitalizeFirstWord();
			alphabetize(storage, line, event.getChangedLine());
			break;
		default:
			break;
		}
	}

	private void alphabetize(LineStorage storage, Line line, int lineNumber) {
		for (int i = 0; i <= (lineNumber - 1); i++) {
			if (line.compareTo(storage.get(i)) < 0) {
				storage.insert(i, line);
				storage.delete(lineNumber + 1);
				break;
			}
		}
	}
}
