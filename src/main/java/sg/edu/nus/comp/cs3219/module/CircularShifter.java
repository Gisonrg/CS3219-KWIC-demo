package sg.edu.nus.comp.cs3219.module;

import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import sg.edu.nus.comp.cs3219.event.LineStorageChangeEvent;
import sg.edu.nus.comp.cs3219.model.Line;
import sg.edu.nus.comp.cs3219.model.LineStorage;

public class CircularShifter implements Observer {
	final private LineStorage resultStorage;
	private Set<String> ignoreWords = new HashSet<>();

	public CircularShifter(LineStorage storage) {
		resultStorage = storage;
	}

	public Set<String> getIgnoreWords() {
		return ignoreWords;
	}

	public void setIgnoreWords(Set<String> ignoreWords) {
		this.ignoreWords = ignoreWords;
	}

	@Override
	public void update(Observable o, Object arg) {
		LineStorage storage = (LineStorage) o;
		LineStorageChangeEvent event = (LineStorageChangeEvent) arg;
		switch (event.getEventType()) {
		case ADD:
			Line line = storage.get(event.getChangedLine());
			makeIgnoreWordsLowercase(line);
			doShift(line);
			break;
		default:
			break;
		}
	}

	private void doShift(Line line) {
		for (int i = 0; i < line.size(); i++) {
			// Ignore shift starting with ignored word.
			if (isIgnoreWord(line.getWord(i))) {
				continue;
			}
			String newLine = Stream
					.concat(line.getWordsFromIndexToEnd(i).stream(), line.getWordsFromStartToIndex(i).stream())
					.collect(Collectors.joining(" "));
			resultStorage.addLine(newLine);
		}
	}

	private void makeIgnoreWordsLowercase(Line line) {
		for (int i = 0; i < line.size();i++) {
			String word = line.getWord(i);
			if (isIgnoreWord(word)) {
				line.setWord(i, word.toLowerCase());
			}
		}
	}
	
	private boolean isIgnoreWord(String word) {
		return ignoreWords.contains(word.toLowerCase());
	}
}
