package sg.edu.nus.comp.cs3219.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.stream.Collectors;

import sg.edu.nus.comp.cs3219.event.LineStorageChangeEvent;
import sg.edu.nus.comp.cs3219.event.LineStorageChangeEvent.LineStorageChangeType;

public class LineStorage extends Observable {

	private List<Line> lines = new ArrayList<>();
	
	public void addLine(Line newLine) {
		lines.add(newLine);
		setChanged();
		notifyObservers(new LineStorageChangeEvent(LineStorageChangeType.ADD, getLastIndex()));
	}
	
	public void addLine(String line) {
		Line newLine = new Line(line.trim());
		lines.add(newLine);
		setChanged();
		notifyObservers(new LineStorageChangeEvent(LineStorageChangeType.ADD, getLastIndex()));
	}

	public Line get(int lineNumber) {
		return lines.get(lineNumber);
	}

	public void insert(int i, String line) {
		lines.add(i, new Line(line));
	}
	
	public void insert(int i, Line line) {
		lines.add(i, line);
	}

	public void delete(int index) {
		lines.remove(index);
	}

	public int size() {
		return lines.size();
	}

	public int getLastIndex() {
		return lines.size() - 1;
	}

	public void clearLines() {
		lines.clear();
	}
	
	public List<String> getAll() {
		return lines.stream().map(x -> x.toString()).collect(Collectors.toList());
	}
}

